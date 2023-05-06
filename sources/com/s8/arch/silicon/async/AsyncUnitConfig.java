package com.s8.arch.silicon.async;

import java.util.ArrayList;
import java.util.List;

import com.s8.io.xml.annotations.XML_SetAttribute;
import com.s8.io.xml.annotations.XML_SetElement;
import com.s8.io.xml.annotations.XML_Type;


@XML_Type(name = "T1UnitConfig")	
public class AsyncUnitConfig {

	/**
	 * 
	 */
	public int nThreads = 4;

	
	public int queueCapacity = AsyncWorker.DEFAULT_CAPACITY;
	
	/**
	 * 
	 */
	private List<ProfileMappingBuilder> builders;


	@XML_SetAttribute(name = "n-threads")
	public void setNbThreads(int nThreads) {
		this.nThreads = nThreads;
	}
	
	@XML_SetAttribute(name = "queue-capacity")
	public void setQueueCapacity(int capacity) {
		this.queueCapacity = capacity;
	}

	@XML_SetElement(tag = "map")
	public void appendEntry(ProfileMappingBuilder builder) {
		if(builders==null) {
			builders = new ArrayList<>();
		}
		builders.add(builder);
	}



	public AsyncUnitConfig() {
		super();
	}
	

	public AsyncSiUnit build() {
		ProfileMapping[] rules = new ProfileMapping[MthProfile.CODE_RANGE];

		// appy rules if any
		if(builders!=null) {
			builders.forEach(builder -> {
				ProfileMapping mapping = builder.build(nThreads);
				rules[mapping.getProfile().code] = mapping;
			});	
		}

		// fill gaps
		for(MthProfile profile : MthProfile.values()) {
			if(rules[profile.code]==null) {
				rules[profile.code] = ProfileMapping.createDefault(profile);
			}
		}

		return new AsyncSiUnit(nThreads, queueCapacity, rules);
	}


	/**
	 * 
	 * @return
	 */
	public static AsyncUnitConfig createDefault() {
		AsyncUnitConfig mapBuilder = new AsyncUnitConfig();
		mapBuilder.nThreads = 4;
		return mapBuilder;
	}
}

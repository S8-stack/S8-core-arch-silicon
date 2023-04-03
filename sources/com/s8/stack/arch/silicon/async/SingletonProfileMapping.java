package com.s8.stack.arch.silicon.async;

public class SingletonProfileMapping extends ProfileMapping {
	
	private final int slot;
	
	public SingletonProfileMapping(MthProfile profile, int slot) {
		super(profile);
		this.slot = slot;
	}
	
	@Override
	public int getSlot() {
		return slot;
	}
	
}

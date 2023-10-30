/**
 * 
 */
/**
 * @author pierreconvert
 *
 */
module com.s8.core.arch.silicon {
	
	exports com.s8.core.arch.silicon;
	exports com.s8.core.arch.silicon.async;
	exports com.s8.core.arch.silicon.watch;
	exports com.s8.core.arch.silicon.clock;
	
	
	requires transitive com.s8.api;
	requires transitive com.s8.core.io.xml;
}
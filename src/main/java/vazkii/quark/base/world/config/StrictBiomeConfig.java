package vazkii.quark.base.world.config;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.util.ResourceLocation;
import vazkii.quark.base.module.config.Config;

public class StrictBiomeConfig implements IBiomeConfig {

	@Config(name = "Biomes")
	private List<String> biomeStrings;

	@Config
	private boolean isBlacklist;

	public StrictBiomeConfig(boolean isBlacklist, String... biomes) {
		this.isBlacklist = isBlacklist;

		biomeStrings = new LinkedList<>();
		biomeStrings.addAll(Arrays.asList(biomes));
	}
	
	@Override
	public boolean canSpawn(ResourceLocation res) {
		return biomeStrings.contains(res.toString()) != isBlacklist;
	}

}

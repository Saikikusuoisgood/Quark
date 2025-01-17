package vazkii.quark.addons.oddities.client.model;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vazkii.quark.addons.oddities.block.TinyPotatoBlock;
import vazkii.quark.addons.oddities.client.render.be.TinyPotatoRenderer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@OnlyIn(Dist.CLIENT)
public record TinyPotatoModel(BakedModel originalModel) implements BakedModel {

	@Override
	public boolean useAmbientOcclusion() {
		return originalModel.useAmbientOcclusion();
	}

	@Override
	public boolean isGui3d() {
		return originalModel.isGui3d();
	}

	@Override
	public boolean usesBlockLight() {
		return originalModel.usesBlockLight();
	}

	@Override
	public boolean isCustomRenderer() {
		return originalModel.isCustomRenderer();
	}

	@Nonnull
	@Override
	public TextureAtlasSprite getParticleIcon() {
		return originalModel.getParticleIcon();
	}

	@Nonnull
	@Override
	public ItemTransforms getTransforms() {
		return originalModel.getTransforms();
	}

	@Nonnull
	@Override
	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand) {
		return List.of();
	}

	@Nonnull
	@Override
	public ItemOverrides getOverrides() {
		return new ItemOverrides() {
			@Override
			public BakedModel resolve(@Nonnull BakedModel model, @Nonnull ItemStack stack, @Nullable ClientLevel world, @Nullable LivingEntity livingEntity, int seed) {
				if (stack.hasCustomHoverName() || TinyPotatoBlock.isAngry(stack)) {
					return TinyPotatoRenderer.getModelFromDisplayName(stack.getHoverName(), TinyPotatoBlock.isAngry(stack));
				}
				return originalModel;
			}
		};
	}
}

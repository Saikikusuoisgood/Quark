package vazkii.quark.content.tweaks.module;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Vex;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import vazkii.quark.base.module.LoadModule;
import vazkii.quark.base.module.ModuleCategory;
import vazkii.quark.base.module.QuarkModule;

@LoadModule(category = ModuleCategory.TWEAKS, hasSubscriptions = true)
public class VexesDieWithTheirMastersModule extends QuarkModule {

	@SubscribeEvent // omae wa mou shindeiru
	public void checkWhetherAlreadyDead(LivingEvent.LivingUpdateEvent event) {
		if (event.getEntity() instanceof Vex vex) {
			Mob owner = vex.getOwner();
			if (owner != null && owner.isDeadOrDying() && !vex.isDeadOrDying())
				vex.hurt(DamageSource.mobAttack(owner).bypassArmor().bypassInvul().bypassMagic(), vex.getHealth());
		}
	}
}

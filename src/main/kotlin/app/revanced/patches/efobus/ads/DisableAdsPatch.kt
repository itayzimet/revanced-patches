package app.revanced.patches.efobus.ads

import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.Patch

import app.revanced.patches.efobus.ads.fingerprints.OnCreate

@Patch(
    name = "Hide ads",
    description = "Hides all in-app ads.")
@Suppress("unused")
object DisableAdsPatch : BytecodePatch(setOf(OnCreate)) {
    override fun execute(context: BytecodeContext) {
        OnCreate.result?.mutableMethod?.addInstructions(
            0,
            """
	const/4 p1, 0x1
	invoke-static {p1}, Lil/co/mitug/WhereBus/CWhereBusApp;->setSubscribedToAdFree(Z)V""")
    }
}
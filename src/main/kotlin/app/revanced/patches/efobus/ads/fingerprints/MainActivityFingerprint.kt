package app.revanced.patches.efobus.ads.fingerprints


import app.revanced.patcher.fingerprint.MethodFingerprint

internal object OnCreate : MethodFingerprint (
    customFingerprint =  { method, classDef ->
        classDef.endsWith("MainActivity;") && method.name == "onCreate"
    }
)

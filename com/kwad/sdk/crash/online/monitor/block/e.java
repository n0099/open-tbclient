package com.kwad.sdk.crash.online.monitor.block;

import java.util.Random;
/* loaded from: classes10.dex */
public final class e {
    public static com.kwad.sdk.crash.online.monitor.a.a aFF;

    public static com.kwad.sdk.crash.online.monitor.a.a GH() {
        return aFF;
    }

    public static boolean GI() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aFF;
        if (aVar != null && aVar.GL()) {
            return true;
        }
        return false;
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.GO()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "allFuncDisable");
            } else if (!a.GF()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
            } else {
                a.a(aVar);
                aFF = aVar;
                boolean bz = a.bz(true);
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bz);
                if (aVar.anQ < new Random().nextFloat()) {
                    return;
                }
                b.a(aVar);
                if (aVar.GM() && bz) {
                    c.b(aVar);
                }
                if (aVar.GN()) {
                    boolean bA = a.bA(false);
                    com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + bA);
                }
            }
        } catch (Throwable th) {
            try {
                com.kwad.sdk.crash.b.m(th);
            } catch (Exception unused) {
            }
        }
    }
}

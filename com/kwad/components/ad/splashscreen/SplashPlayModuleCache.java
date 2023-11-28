package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class SplashPlayModuleCache {
    public HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.e.a>> Ck;

    /* loaded from: classes10.dex */
    public enum Holder {
        INSTANCE;
        
        public SplashPlayModuleCache mInstance = new SplashPlayModuleCache((byte) 0);

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    public SplashPlayModuleCache() {
        this.Ck = new HashMap<>(1);
    }

    public /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }
}

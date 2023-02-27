package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class SplashPlayModuleCache {
    public HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.c.a>> ya;

    /* loaded from: classes8.dex */
    public enum Holder {
        INSTANCE;
        
        public SplashPlayModuleCache mInstance = new SplashPlayModuleCache((byte) 0);

        Holder() {
        }

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public SplashPlayModuleCache() {
        this.ya = new HashMap<>(1);
    }

    public /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }

    public static SplashPlayModuleCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final com.kwad.components.ad.splashscreen.c.a X(String str) {
        WeakReference<com.kwad.components.ad.splashscreen.c.a> weakReference = this.ya.get(str);
        if (weakReference != null) {
            com.kwad.components.ad.splashscreen.c.a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.ya.remove(str);
        }
        return null;
    }

    public final void a(String str, com.kwad.components.ad.splashscreen.c.a aVar) {
        this.ya.put(str, new WeakReference<>(aVar));
    }
}

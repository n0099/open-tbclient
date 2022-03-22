package com.kwad.sdk.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class SplashPlayModuleCache {
    public HashMap<String, WeakReference<com.kwad.sdk.splashscreen.b.a>> a;

    /* loaded from: classes7.dex */
    public enum Holder {
        INSTANCE;
        
        public SplashPlayModuleCache mInstance = new SplashPlayModuleCache();

        Holder() {
        }

        public SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public SplashPlayModuleCache() {
        this.a = new HashMap<>(1);
    }

    public static SplashPlayModuleCache a() {
        return Holder.INSTANCE.getInstance();
    }

    public com.kwad.sdk.splashscreen.b.a a(String str) {
        WeakReference<com.kwad.sdk.splashscreen.b.a> weakReference = this.a.get(str);
        if (weakReference != null) {
            com.kwad.sdk.splashscreen.b.a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.a.remove(str);
        }
        return null;
    }

    public void a(String str, com.kwad.sdk.splashscreen.b.a aVar) {
        this.a.put(str, new WeakReference<>(aVar));
    }
}

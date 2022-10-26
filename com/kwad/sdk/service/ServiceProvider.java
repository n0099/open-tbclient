package com.kwad.sdk.service;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ServiceProvider {

    /* loaded from: classes8.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;
        
        public final Map mProviders = new HashMap();

        ServiceProviderDelegate() {
        }

        public final Object get(Class cls) {
            return this.mProviders.get(cls);
        }

        public final void put(Class cls, Object obj) {
            this.mProviders.put(cls, obj);
        }
    }

    public static Object get(Class cls) {
        return ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static void put(Class cls, Object obj) {
        ServiceProviderDelegate.INSTANCE.put(cls, obj);
    }
}

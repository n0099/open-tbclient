package com.kwad.sdk.service;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class ServiceProvider {

    /* loaded from: classes7.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;
        
        public final Map<Class<?>, Object> mProviders = new HashMap();

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }
}

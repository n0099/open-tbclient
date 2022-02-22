package com.kwad.sdk.design.provider;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class ServiceProvider {

    /* loaded from: classes4.dex */
    public enum ServiceProviderDelegate {
        INSTANCE;
        
        public final Map<Class<?>, Object> mProviders = new HashMap();

        ServiceProviderDelegate() {
        }

        public <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public void put(Class<?> cls, Object obj) {
            this.mProviders.put(cls, obj);
        }
    }

    public static <T> T a(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static void a(Class<?> cls, Object obj) {
        ServiceProviderDelegate.INSTANCE.put(cls, obj);
    }
}

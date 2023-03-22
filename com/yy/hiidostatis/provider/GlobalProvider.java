package com.yy.hiidostatis.provider;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes9.dex */
public enum GlobalProvider {
    instance;
    
    public ConcurrentMap<Class, Provider> classProvider = new ConcurrentHashMap();
    public ConcurrentMap<String, Provider> nameProvider = new ConcurrentHashMap();

    GlobalProvider() {
    }

    public <T> T get(Class cls, MessageConfig messageConfig) {
        Provider provider = this.classProvider.get(cls);
        if (provider != null) {
            return (T) provider.generate(messageConfig);
        }
        return null;
    }

    public void registerProvider(Class cls, Provider provider) {
        this.classProvider.put(cls, provider);
    }

    public <T> T get(String str, MessageConfig messageConfig) {
        Provider provider = this.nameProvider.get(str);
        if (provider != null) {
            return (T) provider.generate(messageConfig);
        }
        return null;
    }

    public void registerProvider(String str, Provider provider) {
        this.nameProvider.put(str, provider);
    }
}

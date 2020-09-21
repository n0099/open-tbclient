package com.facebook.rebound;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes17.dex */
public class SpringConfigRegistry {
    private static final SpringConfigRegistry INSTANCE = new SpringConfigRegistry(true);
    private final Map<SpringConfig, String> mSpringConfigMap = new HashMap();

    public static SpringConfigRegistry getInstance() {
        return INSTANCE;
    }

    SpringConfigRegistry(boolean z) {
        if (z) {
            addSpringConfig(SpringConfig.defaultConfig, "default config");
        }
    }

    public boolean addSpringConfig(SpringConfig springConfig, String str) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        if (str == null) {
            throw new IllegalArgumentException("configName is required");
        }
        if (this.mSpringConfigMap.containsKey(springConfig)) {
            return false;
        }
        this.mSpringConfigMap.put(springConfig, str);
        return true;
    }

    public boolean removeSpringConfig(SpringConfig springConfig) {
        if (springConfig == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        return this.mSpringConfigMap.remove(springConfig) != null;
    }

    public Map<SpringConfig, String> getAllSpringConfig() {
        return Collections.unmodifiableMap(this.mSpringConfigMap);
    }

    public void removeAllSpringConfig() {
        this.mSpringConfigMap.clear();
    }
}

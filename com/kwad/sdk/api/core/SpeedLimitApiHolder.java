package com.kwad.sdk.api.core;

import com.kwad.sdk.api.loader.Loader;
/* loaded from: classes7.dex */
public class SpeedLimitApiHolder {
    public static volatile SpeedLimitApi instance;

    public static SpeedLimitApi getInstance() {
        if (instance == null) {
            synchronized (SpeedLimitApiHolder.class) {
                if (instance == null) {
                    instance = (SpeedLimitApi) Loader.get().newInstance(SpeedLimitApi.class);
                }
            }
        }
        return instance;
    }
}

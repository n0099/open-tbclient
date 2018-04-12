package com.meizu.cloud.pushsdk.pushtracer.utils;
/* loaded from: classes3.dex */
public enum LogLevel {
    OFF(0),
    ERROR(1),
    DEBUG(2),
    VERBOSE(3);
    
    private int a;

    LogLevel(int i) {
        this.a = i;
    }

    public int getLevel() {
        return this.a;
    }
}

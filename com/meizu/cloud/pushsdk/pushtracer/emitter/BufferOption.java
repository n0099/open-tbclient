package com.meizu.cloud.pushsdk.pushtracer.emitter;
/* loaded from: classes3.dex */
public enum BufferOption {
    Single(1),
    DefaultGroup(2),
    HeavyGroup(25);
    
    private int a;

    BufferOption(int i) {
        this.a = i;
    }

    public int getCode() {
        return this.a;
    }
}

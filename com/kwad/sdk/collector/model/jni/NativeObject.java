package com.kwad.sdk.collector.model.jni;
/* loaded from: classes7.dex */
public abstract class NativeObject {
    public long mPtr;

    public abstract void destroy();

    public long getNativePtr() {
        return this.mPtr;
    }
}

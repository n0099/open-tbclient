package com.bytedance.sdk.openadsdk.k.f;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f29554a;

    /* renamed from: b  reason: collision with root package name */
    public int f29555b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public String f29556c;

    public b a(String str) {
        this.f29554a = str;
        return this;
    }

    public b b(String str) {
        this.f29556c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f29554a + "', maxPreloadSize=" + this.f29555b + ", fileNameKey='" + this.f29556c + "'}";
    }

    public b a(int i2) {
        if (i2 > 0) {
            this.f29555b = i2;
        }
        return this;
    }
}

package com.bytedance.sdk.openadsdk.k.f;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f30277a;

    /* renamed from: b  reason: collision with root package name */
    public int f30278b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public String f30279c;

    public b a(String str) {
        this.f30277a = str;
        return this;
    }

    public b b(String str) {
        this.f30279c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f30277a + "', maxPreloadSize=" + this.f30278b + ", fileNameKey='" + this.f30279c + "'}";
    }

    public b a(int i2) {
        if (i2 > 0) {
            this.f30278b = i2;
        }
        return this;
    }
}

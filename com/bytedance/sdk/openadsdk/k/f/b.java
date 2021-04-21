package com.bytedance.sdk.openadsdk.k.f;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f29374a;

    /* renamed from: b  reason: collision with root package name */
    public int f29375b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public String f29376c;

    public b a(String str) {
        this.f29374a = str;
        return this;
    }

    public b b(String str) {
        this.f29376c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f29374a + "', maxPreloadSize=" + this.f29375b + ", fileNameKey='" + this.f29376c + "'}";
    }

    public b a(int i) {
        if (i > 0) {
            this.f29375b = i;
        }
        return this;
    }
}

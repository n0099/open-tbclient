package com.bytedance.sdk.openadsdk.k.f;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f29680a;

    /* renamed from: b  reason: collision with root package name */
    public int f29681b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public String f29682c;

    public b a(String str) {
        this.f29680a = str;
        return this;
    }

    public b b(String str) {
        this.f29682c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f29680a + "', maxPreloadSize=" + this.f29681b + ", fileNameKey='" + this.f29682c + "'}";
    }

    public b a(int i) {
        if (i > 0) {
            this.f29681b = i;
        }
        return this;
    }
}

package com.bytedance.sdk.openadsdk.k.f;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f29681a;

    /* renamed from: b  reason: collision with root package name */
    public int f29682b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public String f29683c;

    public b a(String str) {
        this.f29681a = str;
        return this;
    }

    public b b(String str) {
        this.f29683c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f29681a + "', maxPreloadSize=" + this.f29682b + ", fileNameKey='" + this.f29683c + "'}";
    }

    public b a(int i) {
        if (i > 0) {
            this.f29682b = i;
        }
        return this;
    }
}

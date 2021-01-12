package com.bytedance.sdk.openadsdk.j.f;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f7279a;

    /* renamed from: b  reason: collision with root package name */
    public int f7280b = com.baidu.fsg.base.statistics.b.f1935b;
    public String c;

    public b a(String str) {
        this.f7279a = str;
        return this;
    }

    public b a(int i) {
        if (i > 0) {
            this.f7280b = i;
        }
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f7279a + "', maxPreloadSize=" + this.f7280b + ", fileNameKey='" + this.c + "'}";
    }
}

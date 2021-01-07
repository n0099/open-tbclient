package com.bytedance.sdk.openadsdk.j.f;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f7579a;

    /* renamed from: b  reason: collision with root package name */
    public int f7580b = com.baidu.fsg.base.statistics.b.f1985b;
    public String c;

    public b a(String str) {
        this.f7579a = str;
        return this;
    }

    public b a(int i) {
        if (i > 0) {
            this.f7580b = i;
        }
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f7579a + "', maxPreloadSize=" + this.f7580b + ", fileNameKey='" + this.c + "'}";
    }
}

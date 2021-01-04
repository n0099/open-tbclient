package com.bytedance.sdk.openadsdk.j.f;

import java.io.Serializable;
/* loaded from: classes4.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f7578a;

    /* renamed from: b  reason: collision with root package name */
    public int f7579b = com.baidu.fsg.base.statistics.b.f1984b;
    public String c;

    public b a(String str) {
        this.f7578a = str;
        return this;
    }

    public b a(int i) {
        if (i > 0) {
            this.f7579b = i;
        }
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f7578a + "', maxPreloadSize=" + this.f7579b + ", fileNameKey='" + this.c + "'}";
    }
}

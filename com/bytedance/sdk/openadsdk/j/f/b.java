package com.bytedance.sdk.openadsdk.j.f;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f7281a;

    /* renamed from: b  reason: collision with root package name */
    public int f7282b = com.baidu.fsg.base.statistics.b.f1933b;
    public String c;

    public b a(String str) {
        this.f7281a = str;
        return this;
    }

    public b a(int i) {
        if (i > 0) {
            this.f7282b = i;
        }
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f7281a + "', maxPreloadSize=" + this.f7282b + ", fileNameKey='" + this.c + "'}";
    }
}

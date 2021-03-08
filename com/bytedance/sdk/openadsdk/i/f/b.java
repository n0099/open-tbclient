package com.bytedance.sdk.openadsdk.i.f;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f4840a;
    public int b = com.baidu.fsg.base.statistics.b.b;
    public String c;

    public b a(String str) {
        this.f4840a = str;
        return this;
    }

    public b a(int i) {
        if (i > 0) {
            this.b = i;
        }
        return this;
    }

    public b b(String str) {
        this.c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f4840a + "', maxPreloadSize=" + this.b + ", fileNameKey='" + this.c + "'}";
    }
}

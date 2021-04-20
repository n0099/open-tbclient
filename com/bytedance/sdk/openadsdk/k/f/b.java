package com.bytedance.sdk.openadsdk.k.f;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f29366a;

    /* renamed from: b  reason: collision with root package name */
    public int f29367b = 204800;

    /* renamed from: c  reason: collision with root package name */
    public String f29368c;

    public b a(String str) {
        this.f29366a = str;
        return this;
    }

    public b b(String str) {
        this.f29368c = str;
        return this;
    }

    public String toString() {
        return "VideoUrlModel{url='" + this.f29366a + "', maxPreloadSize=" + this.f29367b + ", fileNameKey='" + this.f29368c + "'}";
    }

    public b a(int i) {
        if (i > 0) {
            this.f29367b = i;
        }
        return this;
    }
}

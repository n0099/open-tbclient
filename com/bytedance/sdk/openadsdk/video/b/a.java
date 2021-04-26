package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f31088a;

    /* renamed from: b  reason: collision with root package name */
    public String f31089b;

    /* renamed from: c  reason: collision with root package name */
    public int f31090c = 204800;

    public String a() {
        return this.f31088a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f31089b)) {
            this.f31089b = b.a(this.f31088a);
        }
        return this.f31089b;
    }

    public int c() {
        return this.f31090c;
    }

    public void a(String str) {
        this.f31088a = str;
    }

    public void a(int i2) {
        this.f31090c = i2;
    }

    public void b(String str) {
        this.f31089b = str;
    }
}

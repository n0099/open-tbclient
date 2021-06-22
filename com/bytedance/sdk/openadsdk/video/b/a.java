package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30447a;

    /* renamed from: b  reason: collision with root package name */
    public String f30448b;

    /* renamed from: c  reason: collision with root package name */
    public int f30449c = 204800;

    public String a() {
        return this.f30447a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30448b)) {
            this.f30448b = b.a(this.f30447a);
        }
        return this.f30448b;
    }

    public int c() {
        return this.f30449c;
    }

    public void a(String str) {
        this.f30447a = str;
    }

    public void a(int i2) {
        this.f30449c = i2;
    }

    public void b(String str) {
        this.f30448b = str;
    }
}

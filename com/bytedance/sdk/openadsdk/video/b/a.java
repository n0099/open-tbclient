package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30333a;

    /* renamed from: b  reason: collision with root package name */
    public String f30334b;

    /* renamed from: c  reason: collision with root package name */
    public int f30335c = 204800;

    public String a() {
        return this.f30333a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30334b)) {
            this.f30334b = b.a(this.f30333a);
        }
        return this.f30334b;
    }

    public int c() {
        return this.f30335c;
    }

    public void a(String str) {
        this.f30333a = str;
    }

    public void a(int i2) {
        this.f30335c = i2;
    }

    public void b(String str) {
        this.f30334b = str;
    }
}

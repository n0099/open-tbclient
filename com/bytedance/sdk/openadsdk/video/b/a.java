package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30262a;

    /* renamed from: b  reason: collision with root package name */
    public String f30263b;

    /* renamed from: c  reason: collision with root package name */
    public int f30264c = 204800;

    public String a() {
        return this.f30262a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30263b)) {
            this.f30263b = b.a(this.f30262a);
        }
        return this.f30263b;
    }

    public int c() {
        return this.f30264c;
    }

    public void a(String str) {
        this.f30262a = str;
    }

    public void a(int i2) {
        this.f30264c = i2;
    }

    public void b(String str) {
        this.f30263b = str;
    }
}

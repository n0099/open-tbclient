package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30171a;

    /* renamed from: b  reason: collision with root package name */
    public String f30172b;

    /* renamed from: c  reason: collision with root package name */
    public int f30173c = 204800;

    public String a() {
        return this.f30171a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30172b)) {
            this.f30172b = b.a(this.f30171a);
        }
        return this.f30172b;
    }

    public int c() {
        return this.f30173c;
    }

    public void a(String str) {
        this.f30171a = str;
    }

    public void a(int i) {
        this.f30173c = i;
    }

    public void b(String str) {
        this.f30172b = str;
    }
}

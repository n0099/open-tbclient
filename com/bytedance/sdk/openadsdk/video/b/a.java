package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30478a;

    /* renamed from: b  reason: collision with root package name */
    public String f30479b;

    /* renamed from: c  reason: collision with root package name */
    public int f30480c = 204800;

    public String a() {
        return this.f30478a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30479b)) {
            this.f30479b = b.a(this.f30478a);
        }
        return this.f30479b;
    }

    public int c() {
        return this.f30480c;
    }

    public void a(String str) {
        this.f30478a = str;
    }

    public void a(int i) {
        this.f30480c = i;
    }

    public void b(String str) {
        this.f30479b = str;
    }
}

package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30163a;

    /* renamed from: b  reason: collision with root package name */
    public String f30164b;

    /* renamed from: c  reason: collision with root package name */
    public int f30165c = 204800;

    public String a() {
        return this.f30163a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30164b)) {
            this.f30164b = b.a(this.f30163a);
        }
        return this.f30164b;
    }

    public int c() {
        return this.f30165c;
    }

    public void a(String str) {
        this.f30163a = str;
    }

    public void a(int i) {
        this.f30165c = i;
    }

    public void b(String str) {
        this.f30164b = str;
    }
}

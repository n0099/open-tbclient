package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30477a;

    /* renamed from: b  reason: collision with root package name */
    public String f30478b;

    /* renamed from: c  reason: collision with root package name */
    public int f30479c = 204800;

    public String a() {
        return this.f30477a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30478b)) {
            this.f30478b = b.a(this.f30477a);
        }
        return this.f30478b;
    }

    public int c() {
        return this.f30479c;
    }

    public void a(String str) {
        this.f30477a = str;
    }

    public void a(int i) {
        this.f30479c = i;
    }

    public void b(String str) {
        this.f30478b = str;
    }
}

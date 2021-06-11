package com.bytedance.sdk.openadsdk.video.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.video.d.b;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f30365a;

    /* renamed from: b  reason: collision with root package name */
    public String f30366b;

    /* renamed from: c  reason: collision with root package name */
    public int f30367c = 204800;

    public String a() {
        return this.f30365a;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f30366b)) {
            this.f30366b = b.a(this.f30365a);
        }
        return this.f30366b;
    }

    public int c() {
        return this.f30367c;
    }

    public void a(String str) {
        this.f30365a = str;
    }

    public void a(int i2) {
        this.f30367c = i2;
    }

    public void b(String str) {
        this.f30366b = str;
    }
}

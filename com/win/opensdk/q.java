package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public B1 f40400a;

    /* renamed from: b  reason: collision with root package name */
    public r f40401b;

    public q(Context context, String str) {
        B1 b1 = new B1(context, str);
        this.f40400a = b1;
        b1.f40014f = new p(this);
    }

    public void a() {
        try {
            if (this.f40400a != null) {
                this.f40400a.a();
                this.f40400a = null;
            }
            if (this.f40401b != null) {
                this.f40401b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        B1 b1 = this.f40400a;
        if (b1 != null) {
            b1.a(view, pBMediaView);
        }
    }

    public String b() {
        B1 b1 = this.f40400a;
        return (b1 == null || !b1.b()) ? "" : b1.f40011c.getLoad_type();
    }

    public boolean c() {
        B1 b1 = this.f40400a;
        return b1 != null && b1.b();
    }
}

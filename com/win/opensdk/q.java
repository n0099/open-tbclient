package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public B1 f40016a;

    /* renamed from: b  reason: collision with root package name */
    public r f40017b;

    public q(Context context, String str) {
        B1 b1 = new B1(context, str);
        this.f40016a = b1;
        b1.f39630f = new p(this);
    }

    public void a() {
        try {
            if (this.f40016a != null) {
                this.f40016a.a();
                this.f40016a = null;
            }
            if (this.f40017b != null) {
                this.f40017b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        B1 b1 = this.f40016a;
        if (b1 != null) {
            b1.a(view, pBMediaView);
        }
    }

    public String b() {
        B1 b1 = this.f40016a;
        return (b1 == null || !b1.b()) ? "" : b1.f39627c.getLoad_type();
    }

    public boolean c() {
        B1 b1 = this.f40016a;
        return b1 != null && b1.b();
    }
}

package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public B1 f40305a;

    /* renamed from: b  reason: collision with root package name */
    public r f40306b;

    public q(Context context, String str) {
        B1 b1 = new B1(context, str);
        this.f40305a = b1;
        b1.f39919f = new p(this);
    }

    public void a() {
        try {
            if (this.f40305a != null) {
                this.f40305a.a();
                this.f40305a = null;
            }
            if (this.f40306b != null) {
                this.f40306b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        B1 b1 = this.f40305a;
        if (b1 != null) {
            b1.a(view, pBMediaView);
        }
    }

    public String b() {
        B1 b1 = this.f40305a;
        return (b1 == null || !b1.b()) ? "" : b1.f39916c.getLoad_type();
    }

    public boolean c() {
        B1 b1 = this.f40305a;
        return b1 != null && b1.b();
    }
}

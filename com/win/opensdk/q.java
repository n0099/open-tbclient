package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public Y0 f40876a;

    /* renamed from: b  reason: collision with root package name */
    public r f40877b;

    public q(Context context, String str) {
        Y0 y0 = new Y0(context, str);
        this.f40876a = y0;
        y0.f40768f = new p(this);
    }

    public void a() {
        try {
            if (this.f40876a != null) {
                this.f40876a.a();
                this.f40876a = null;
            }
            if (this.f40877b != null) {
                this.f40877b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        Y0 y0 = this.f40876a;
        if (y0 != null) {
            y0.a(view, pBMediaView);
        }
    }

    public String b() {
        Y0 y0 = this.f40876a;
        return (y0 == null || !y0.b()) ? "" : y0.f40765c.getLoad_type();
    }

    public boolean c() {
        Y0 y0 = this.f40876a;
        return y0 != null && y0.b();
    }
}

package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public Y0 f37094a;

    /* renamed from: b  reason: collision with root package name */
    public r f37095b;

    public q(Context context, String str) {
        Y0 y0 = new Y0(context, str);
        this.f37094a = y0;
        y0.f36986f = new p(this);
    }

    public void a() {
        try {
            if (this.f37094a != null) {
                this.f37094a.a();
                this.f37094a = null;
            }
            if (this.f37095b != null) {
                this.f37095b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        Y0 y0 = this.f37094a;
        if (y0 != null) {
            y0.a(view, pBMediaView);
        }
    }

    public String b() {
        Y0 y0 = this.f37094a;
        return (y0 == null || !y0.b()) ? "" : y0.f36983c.getLoad_type();
    }

    public boolean c() {
        Y0 y0 = this.f37094a;
        return y0 != null && y0.b();
    }
}

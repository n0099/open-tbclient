package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public Y0 f37165a;

    /* renamed from: b  reason: collision with root package name */
    public r f37166b;

    public q(Context context, String str) {
        Y0 y0 = new Y0(context, str);
        this.f37165a = y0;
        y0.f37057f = new p(this);
    }

    public void a() {
        try {
            if (this.f37165a != null) {
                this.f37165a.a();
                this.f37165a = null;
            }
            if (this.f37166b != null) {
                this.f37166b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        Y0 y0 = this.f37165a;
        if (y0 != null) {
            y0.a(view, pBMediaView);
        }
    }

    public String b() {
        Y0 y0 = this.f37165a;
        return (y0 == null || !y0.b()) ? "" : y0.f37054c.getLoad_type();
    }

    public boolean c() {
        Y0 y0 = this.f37165a;
        return y0 != null && y0.b();
    }
}

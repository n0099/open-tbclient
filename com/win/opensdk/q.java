package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes6.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public Y0 f37920a;

    /* renamed from: b  reason: collision with root package name */
    public r f37921b;

    public q(Context context, String str) {
        Y0 y0 = new Y0(context, str);
        this.f37920a = y0;
        y0.f37812f = new p(this);
    }

    public void a() {
        try {
            if (this.f37920a != null) {
                this.f37920a.a();
                this.f37920a = null;
            }
            if (this.f37921b != null) {
                this.f37921b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        Y0 y0 = this.f37920a;
        if (y0 != null) {
            y0.a(view, pBMediaView);
        }
    }

    public String b() {
        Y0 y0 = this.f37920a;
        return (y0 == null || !y0.b()) ? "" : y0.f37809c.getLoad_type();
    }

    public boolean c() {
        Y0 y0 = this.f37920a;
        return y0 != null && y0.b();
    }
}

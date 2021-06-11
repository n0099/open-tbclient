package com.win.opensdk;

import android.content.Context;
import android.view.View;
/* loaded from: classes7.dex */
public class q implements d {

    /* renamed from: a  reason: collision with root package name */
    public Y0 f40773a;

    /* renamed from: b  reason: collision with root package name */
    public r f40774b;

    public q(Context context, String str) {
        Y0 y0 = new Y0(context, str);
        this.f40773a = y0;
        y0.f40665f = new p(this);
    }

    public void a() {
        try {
            if (this.f40773a != null) {
                this.f40773a.a();
                this.f40773a = null;
            }
            if (this.f40774b != null) {
                this.f40774b = null;
            }
        } catch (Exception unused) {
        }
    }

    public void a(View view, PBMediaView pBMediaView) {
        Y0 y0 = this.f40773a;
        if (y0 != null) {
            y0.a(view, pBMediaView);
        }
    }

    public String b() {
        Y0 y0 = this.f40773a;
        return (y0 == null || !y0.b()) ? "" : y0.f40662c.getLoad_type();
    }

    public boolean c() {
        Y0 y0 = this.f40773a;
        return y0 != null && y0.b();
    }
}

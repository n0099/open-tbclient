package com.kwad.sdk.reward;

import android.app.Activity;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class g extends Presenter {
    public a a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.a = (a) p();
    }

    public void a(boolean z) {
        int i = z ? 1 : 153;
        a aVar = this.a;
        com.kwad.sdk.core.report.a.a(aVar.f40747g, i, aVar.j.getTouchCoords(), this.a.f40745e);
        this.a.f40742b.a();
    }

    public boolean f() {
        return com.kwad.sdk.core.response.a.d.u(this.a.f40747g);
    }

    public boolean g() {
        return com.kwad.sdk.core.response.a.d.v(this.a.f40747g);
    }

    public void h() {
        Activity activity = this.a.f40748h;
        if (activity != null) {
            activity.finish();
        }
    }
}

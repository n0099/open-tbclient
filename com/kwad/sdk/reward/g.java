package com.kwad.sdk.reward;

import android.app.Activity;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class g extends Presenter {
    public a a;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.a = (a) p();
    }

    public void a(boolean z) {
        int i2 = z ? 1 : 153;
        a aVar = this.a;
        com.kwad.sdk.core.report.a.a(aVar.f59455g, i2, aVar.f59458j.getTouchCoords(), this.a.f59453e);
        this.a.f59450b.a();
    }

    public boolean f() {
        return com.kwad.sdk.core.response.a.d.u(this.a.f59455g);
    }

    public boolean g() {
        return com.kwad.sdk.core.response.a.d.v(this.a.f59455g);
    }

    public void h() {
        Activity activity = this.a.f59456h;
        if (activity != null) {
            activity.finish();
        }
    }
}

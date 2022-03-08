package com.kwad.sdk.reward;

import android.app.Activity;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes8.dex */
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
        com.kwad.sdk.core.report.a.a(aVar.f55769g, i2, aVar.f55772j.getTouchCoords(), this.a.f55767e);
        this.a.f55764b.a();
    }

    public boolean f() {
        return com.kwad.sdk.core.response.a.d.u(this.a.f55769g);
    }

    public boolean g() {
        return com.kwad.sdk.core.response.a.d.v(this.a.f55769g);
    }

    public void h() {
        Activity activity = this.a.f55770h;
        if (activity != null) {
            activity.finish();
        }
    }
}

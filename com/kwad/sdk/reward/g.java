package com.kwad.sdk.reward;

import android.app.Activity;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes4.dex */
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
        com.kwad.sdk.core.report.a.a(aVar.f57419g, i2, aVar.f57422j.getTouchCoords(), this.a.f57417e);
        this.a.f57414b.a();
    }

    public boolean f() {
        return com.kwad.sdk.core.response.a.d.u(this.a.f57419g);
    }

    public boolean g() {
        return com.kwad.sdk.core.response.a.d.v(this.a.f57419g);
    }

    public void h() {
        Activity activity = this.a.f57420h;
        if (activity != null) {
            activity.finish();
        }
    }
}

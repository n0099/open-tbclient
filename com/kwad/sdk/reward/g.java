package com.kwad.sdk.reward;

import android.app.Activity;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
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
        com.kwad.sdk.core.report.a.a(aVar.g, i, aVar.j.getTouchCoords(), this.a.e);
        this.a.b.a();
    }

    public boolean f() {
        return com.kwad.sdk.core.response.a.d.u(this.a.g);
    }

    public boolean g() {
        return com.kwad.sdk.core.response.a.d.v(this.a.g);
    }

    public void h() {
        Activity activity = this.a.h;
        if (activity != null) {
            activity.finish();
        }
    }
}

package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes3.dex */
public class a extends Presenter implements com.kwad.sdk.widget.d {
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.f f57807b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57808c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f57809d = null;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.f57809d = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.f57809d;
        if (gVar == null) {
            return;
        }
        this.f57808c = com.kwad.sdk.core.response.a.c.g(gVar.f57920d);
        boolean a = i.a(com.kwad.sdk.core.response.a.d.j(this.f57809d.f57920d));
        this.a.setVisibility(a ? 0 : 8);
        if (a) {
            this.f57807b = new com.kwad.sdk.widget.f(this.a.getContext(), this.a, this);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        Context context;
        int i2;
        if (com.kwad.sdk.splashscreen.g.a(view.getContext(), com.kwad.sdk.core.response.a.d.j(this.f57809d.f57920d))) {
            gVar = this.f57809d;
            context = view.getContext();
            i2 = 53;
        } else {
            gVar = this.f57809d;
            context = view.getContext();
            i2 = 0;
        }
        gVar.a(context, i2, 2);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.core.d.a.a("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.f57808c);
        if (this.f57808c) {
            this.f57809d.a(view.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = a(R.id.ksad_splash_actionbar_full_screen);
    }
}

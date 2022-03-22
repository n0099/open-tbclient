package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes7.dex */
public class a extends Presenter implements com.kwad.sdk.widget.d {
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.widget.f f41232b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41233c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f41234d = null;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.f41234d = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.f41234d;
        if (gVar == null) {
            return;
        }
        this.f41233c = com.kwad.sdk.core.response.a.c.g(gVar.f41330d);
        boolean a = i.a(com.kwad.sdk.core.response.a.d.j(this.f41234d.f41330d));
        this.a.setVisibility(a ? 0 : 8);
        if (a) {
            this.f41232b = new com.kwad.sdk.widget.f(this.a.getContext(), this.a, this);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        Context context;
        int i;
        if (com.kwad.sdk.splashscreen.g.a(view.getContext(), com.kwad.sdk.core.response.a.d.j(this.f41234d.f41330d))) {
            gVar = this.f41234d;
            context = view.getContext();
            i = 53;
        } else {
            gVar = this.f41234d;
            context = view.getContext();
            i = 0;
        }
        gVar.a(context, i, 2);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.core.d.a.a("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.f41233c);
        if (this.f41233c) {
            this.f41234d.a(view.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = a(R.id.obfuscated_res_0x7f09113d);
    }
}

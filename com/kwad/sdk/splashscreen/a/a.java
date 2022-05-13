package com.kwad.sdk.splashscreen.a;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes5.dex */
public class a extends Presenter implements com.kwad.sdk.widget.d {
    public View a;
    public com.kwad.sdk.widget.f b;
    public boolean c;
    public com.kwad.sdk.splashscreen.g d = null;

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.d = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.d;
        if (gVar == null) {
            return;
        }
        this.c = com.kwad.sdk.core.response.a.c.g(gVar.d);
        boolean a = i.a(com.kwad.sdk.core.response.a.d.j(this.d.d));
        this.a.setVisibility(a ? 0 : 8);
        if (a) {
            this.b = new com.kwad.sdk.widget.f(this.a.getContext(), this.a, this);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        com.kwad.sdk.splashscreen.g gVar;
        Context context;
        int i;
        if (com.kwad.sdk.splashscreen.g.a(view2.getContext(), com.kwad.sdk.core.response.a.d.j(this.d.d))) {
            gVar = this.d;
            context = view2.getContext();
            i = 53;
        } else {
            gVar = this.d;
            context = view2.getContext();
            i = 0;
        }
        gVar.a(context, i, 2);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        com.kwad.sdk.core.d.a.a("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.c);
        if (this.c) {
            this.d.a(view2.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.a = a(R.id.obfuscated_res_0x7f091146);
    }
}

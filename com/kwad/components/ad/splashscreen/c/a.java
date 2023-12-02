package com.kwad.components.ad.splashscreen.c;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    public View CU;
    public boolean CV;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.CU = findViewById(R.id.obfuscated_res_0x7f0914af);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        this.Df.c(1, view2.getContext(), 53, 2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        com.kwad.sdk.core.e.c.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.CV);
        if (!this.CV) {
            return;
        }
        this.Df.c(1, view2.getContext(), 153, 2);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        int i;
        super.aj();
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar == null) {
            return;
        }
        this.CV = com.kwad.sdk.core.response.b.d.dE(hVar.mAdTemplate);
        boolean n = com.kwad.components.ad.splashscreen.h.n(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate));
        View view2 = this.CU;
        if (n) {
            i = 0;
        } else {
            i = 8;
        }
        view2.setVisibility(i);
        if (n) {
            new com.kwad.sdk.widget.f(this.CU.getContext(), this.CU, this);
        }
    }
}

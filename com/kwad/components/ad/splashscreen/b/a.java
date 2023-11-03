package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class a extends e implements com.kwad.sdk.widget.c {
    public View yu;
    public com.kwad.sdk.widget.f yv;
    public boolean yw;

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar == null) {
            return;
        }
        this.yw = com.kwad.sdk.core.response.a.c.bF(hVar.mAdTemplate);
        boolean n = m.n(com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate));
        this.yu.setVisibility(n ? 0 : 8);
        if (n) {
            this.yv = new com.kwad.sdk.widget.f(this.yu.getContext(), this.yu, this);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        this.yF.c(view2.getContext(), 53, 2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        com.kwad.sdk.core.e.b.d("FullScreenTouchConvertPresenter", "onSlide: enableSlickClick: " + this.yw);
        if (this.yw) {
            this.yF.c(view2.getContext(), 153, 2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.yu = findViewById(R.id.obfuscated_res_0x7f09145a);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}

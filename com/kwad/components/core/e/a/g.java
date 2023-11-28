package com.kwad.components.core.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class g extends KSFrameLayout {
    public final d JI;
    public a JR;
    public final d JT;
    public final com.kwad.components.core.widget.a.b bQ;
    public final AdTemplate mAdTemplate;
    public Presenter mPresenter;
    public boolean nY;

    public g(@NonNull Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.JT = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void mW() {
                g.this.dJ();
            }
        };
        this.mAdTemplate = adTemplate;
        this.JI = dVar;
        this.bQ = new com.kwad.components.core.widget.a.b(this, 70);
        initMVP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ() {
        if (this.nY) {
            return;
        }
        this.nY = true;
        this.JI.mW();
    }

    private void initMVP() {
        this.JR = nd();
        Presenter onCreatePresenter = onCreatePresenter();
        this.mPresenter = onCreatePresenter;
        onCreatePresenter.G(this);
        this.mPresenter.k(this.JR);
    }

    private a nd() {
        a aVar = new a();
        aVar.JG = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.JH = this.bQ;
        aVar.JI = this.JT;
        return aVar;
    }

    public static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        com.kwad.sdk.core.e.c.d("InstalledActivateView", "onViewAttached");
        this.bQ.tm();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        com.kwad.sdk.core.e.c.d("InstalledActivateView", "onViewDetached");
        this.bQ.release();
        this.mPresenter.destroy();
        this.JR.release();
        dJ();
    }
}

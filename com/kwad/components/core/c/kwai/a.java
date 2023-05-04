package com.kwad.components.core.c.kwai;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.kwai.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public final class a extends KSFrameLayout {
    @Nullable
    public final b DG;
    public final b.C0598b DH;
    public d DI;
    public InterfaceC0597a DJ;
    public final AdTemplate mAdTemplate;
    public Presenter mPresenter;
    public final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.c.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0597a {
        void mp();
    }

    public a(@Nullable b bVar, b.C0598b c0598b) {
        super(c0598b.context);
        this.DG = bVar;
        this.DH = c0598b;
        this.mAdTemplate = c0598b.adTemplate;
        FrameLayout.inflate(c0598b.context, R.layout.obfuscated_res_0x7f0d0454, this);
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f09134f);
    }

    public static Presenter ap() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d mo() {
        d dVar = new d();
        dVar.DG = this.DG;
        dVar.DH = this.DH;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate);
        }
        return dVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        super.am();
        this.DI = mo();
        Presenter ap = ap();
        this.mPresenter = ap;
        ap.B(this.mRootContainer);
        this.mPresenter.e(this.DI);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        d dVar = this.DI;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0597a interfaceC0597a = this.DJ;
        if (interfaceC0597a != null) {
            interfaceC0597a.mp();
        }
    }

    public final void setChangeListener(InterfaceC0597a interfaceC0597a) {
        this.DJ = interfaceC0597a;
    }
}

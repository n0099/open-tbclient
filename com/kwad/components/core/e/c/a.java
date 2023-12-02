package com.kwad.components.core.e.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.core.e.c.b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.m.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes10.dex */
public final class a extends KSFrameLayout {
    public final b Kd;
    public final b.C0643b Ke;
    public d Kf;
    public InterfaceC0642a Kg;
    public final AdTemplate mAdTemplate;
    public final Context mContext;
    public Presenter mPresenter;
    public final AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.e.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0642a {
        void ni();
    }

    public a(Context context, b bVar, b.C0643b c0643b) {
        super(context);
        this.mContext = context;
        this.Kd = bVar;
        this.Ke = c0643b;
        this.mAdTemplate = c0643b.adTemplate;
        l.inflate(context, R.layout.obfuscated_res_0x7f0d04bd, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.obfuscated_res_0x7f091490);
        this.mRootContainer = adBaseFrameLayout;
        a(adBaseFrameLayout, "rootView is null");
        a((KsAdWebView) this.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09135a), "webView is null");
    }

    private void a(View view2, String str) {
        if (view2 != null) {
            return;
        }
        throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + a.class.getClassLoader().getClass().getName());
    }

    public static Presenter af() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    private d nh() {
        d dVar = new d();
        dVar.Kd = this.Kd;
        dVar.Ke = this.Ke;
        AdTemplate adTemplate = this.mAdTemplate;
        dVar.mAdTemplate = adTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.dP(adTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        return dVar;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ac() {
        super.ac();
        this.Kf = nh();
        Presenter af = af();
        this.mPresenter = af;
        af.G(this.mRootContainer);
        this.mPresenter.k(this.Kf);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        d dVar = this.Kf;
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
        InterfaceC0642a interfaceC0642a = this.Kg;
        if (interfaceC0642a != null) {
            interfaceC0642a.ni();
        }
    }

    public final void setChangeListener(InterfaceC0642a interfaceC0642a) {
        this.Kg = interfaceC0642a;
    }
}

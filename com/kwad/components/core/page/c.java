package com.kwad.components.core.page;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.c.a.e;
import com.kwad.components.core.page.c.a.f;
import com.kwad.components.core.page.c.a.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.core.l.c<com.kwad.components.core.page.c.a.b> {
    public AdWebViewActivityProxy.a Oj;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public boolean mAutoShow;
    public Context mContext;
    public com.kwad.components.core.page.a.a mLandPageViewListener;
    public String mPageTitle;
    public String mPageUrl;
    public boolean mShowPermission;
    public com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d049f;
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
    }

    public c(Context context) {
        super(context);
    }

    public final void setLandPageViewListener(com.kwad.components.core.page.a.a aVar) {
        this.mLandPageViewListener = aVar;
    }

    public final void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView == null && bVar != null) {
            bVar.b(null);
        }
    }

    public static c a(Context context, AdWebViewActivityProxy.a aVar) {
        c cVar = new c(context);
        cVar.b(context, aVar);
        return cVar;
    }

    private void b(Context context, AdWebViewActivityProxy.a aVar) {
        this.Oj = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.oV();
        this.mPageTitle = aVar.oU();
        this.mShowPermission = aVar.oX();
        this.mAutoShow = aVar.oZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.l.c
    /* renamed from: pb */
    public com.kwad.components.core.page.c.a.b kr() {
        com.kwad.components.core.page.c.a.b bVar = new com.kwad.components.core.page.c.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.Oj = this.Oj;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.Oz = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.gS = this.lC;
        return bVar;
    }

    public final boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.c.a.b) this.mPresenter.HU()).pi();
    }

    @Override // com.kwad.components.core.l.c
    public final void kp() {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f091512);
    }

    public final void pc() {
        ((com.kwad.components.core.page.c.a.b) this.mPresenter.HU()).pc();
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        presenter.a(new e());
        if (com.kwad.sdk.core.response.b.e.F(((com.kwad.components.core.page.c.a.b) this.Mo).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.c.a.c());
        }
        if (com.kwad.sdk.core.response.b.a.aO(com.kwad.sdk.core.response.b.e.dP(((com.kwad.components.core.page.c.a.b) this.Mo).mAdTemplate)) && com.kwad.components.core.q.a.qu().qA() && com.kwad.components.core.q.a.qu().qv() == 1) {
            presenter.a(new com.kwad.components.core.page.c.a.d());
        }
        presenter.a(new g());
        return presenter;
    }
}

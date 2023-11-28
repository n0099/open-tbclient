package com.kwad.components.core.page.c.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.b.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import java.util.List;
/* loaded from: classes10.dex */
public final class f extends com.kwad.components.core.page.c.a.a {
    public boolean OW;
    public com.kwad.components.core.b.a mTitleBarHelper;

    /* loaded from: classes10.dex */
    public interface a {
        void ax(int i);
    }

    @Override // com.kwad.components.core.page.c.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        b bVar = this.Oy;
        this.OW = TextUtils.equals(bVar.mPageUrl, com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dP(bVar.mAdTemplate)));
        ps();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(View view2) {
        KsAdWebView ksAdWebView = this.Oy.mAdWebView;
        if (ksAdWebView != null && ksAdWebView.canGoBack()) {
            this.Oy.mAdWebView.goBack();
            if (this.OW) {
                com.kwad.sdk.core.report.a.bP(this.Oy.mAdTemplate);
                return;
            }
            return;
        }
        com.kwad.components.core.page.a.a aVar = this.Oy.Oz;
        if (aVar != null) {
            aVar.oS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(View view2) {
        com.kwad.components.core.page.a.a aVar = this.Oy.Oz;
        if (aVar != null) {
            aVar.oT();
        }
    }

    private String getTitle() {
        if (!TextUtils.isEmpty(this.Oy.mPageTitle)) {
            return this.Oy.mPageTitle;
        }
        List<AdInfo> list = this.Oy.mAdTemplate.adInfoList;
        if (list != null && list.size() > 0 && this.Oy.mAdTemplate.adInfoList.get(0) != null) {
            return com.kwad.sdk.core.response.b.a.cc(com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate));
        }
        return "详情页面";
    }

    private void ps() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.Oy.gS);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.ah(true);
        this.mTitleBarHelper.a(new a.InterfaceC0632a() { // from class: com.kwad.components.core.page.c.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0632a
            public final void u(View view2) {
                f.this.x(view2);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0632a
            public final void v(View view2) {
                f.this.y(view2);
            }
        });
        ViewGroup gD = this.mTitleBarHelper.gD();
        AdTemplate adTemplate = this.Oy.mAdTemplate;
        int i = 0;
        if (!adTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.b.a.bY(adTemplate) && !com.kwad.sdk.core.response.b.b.df(com.kwad.sdk.core.response.b.e.dP(this.Oy.mAdTemplate))) {
            i = 8;
        }
        gD.setVisibility(i);
        this.Oy.a(new a() { // from class: com.kwad.components.core.page.c.a.f.2
            @Override // com.kwad.components.core.page.c.a.f.a
            public final void ax(int i2) {
                int i3;
                ViewGroup gD2 = f.this.mTitleBarHelper.gD();
                if (i2 == 1) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                gD2.setVisibility(i3);
            }
        });
    }
}

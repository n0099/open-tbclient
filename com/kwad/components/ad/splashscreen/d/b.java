package com.kwad.components.ad.splashscreen.d;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes9.dex */
public final class b implements com.kwad.sdk.widget.c {
    @NonNull
    public ViewGroup es;
    @Nullable
    public AdInfo mAdInfo;
    @Nullable
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public a yM;
    public ViewStub zM;
    public KsAdWebView zN;
    public ViewGroup zO;
    public View zP;
    public TextView zQ;
    public boolean zR;
    @Nullable
    public f zS;
    public com.kwad.sdk.widget.f zT;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, com.kwad.components.core.c.a.c cVar) {
        this.es = viewGroup;
        this.zM = viewStub;
        this.zN = ksAdWebView;
        this.mApkDownloadHelper = cVar;
        this.zR = z;
    }

    private void a(e eVar) {
        if (eVar == null) {
            return;
        }
        ab(eVar.jw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str) {
        TextView textView = this.zQ;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.zP = viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d1);
        this.zQ = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0913d4);
        this.zT = new com.kwad.sdk.widget.f(this.zP.getContext(), this.zP, this);
        this.zP.getContext();
        a(e.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void g(boolean z, boolean z2) {
        f fVar = this.zS;
        if (fVar != null) {
            fVar.f(z, z2);
        }
    }

    public final void E(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.yM;
        if (aVar2 == null) {
            this.yM = new a(this.es.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.d.b.1
                @Override // com.kwad.components.ad.splashscreen.d.a
                public final void Z(String str) {
                    b.this.ab(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        }
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.yM) == null) {
            return;
        }
        cVar.b(aVar);
    }

    public final void a(@Nullable f fVar) {
        this.zS = fVar;
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        g(true, view2.equals(this.zP));
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (this.zR) {
            g(false, view2.equals(this.zP));
        }
    }

    public final void kv() {
        com.kwad.sdk.core.e.b.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.zM + ", mSplashWebView: " + this.zN);
        if (this.zN == null) {
            return;
        }
        if (this.zO == null) {
            ViewStub viewStub = this.zM;
            this.zO = (ViewGroup) ((viewStub == null || viewStub.getParent() == null) ? this.es.findViewById(R.id.obfuscated_res_0x7f0913d2) : this.zM.inflate());
            g(this.zO);
        }
        ViewGroup viewGroup = this.zO;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
            this.zN.setVisibility(8);
        }
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.yM) == null) {
            return;
        }
        cVar.c(aVar);
    }
}

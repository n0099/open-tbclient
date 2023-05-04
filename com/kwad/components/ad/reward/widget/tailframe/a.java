package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a implements c {
    public KsLogoView bq;
    public TextView cE;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public JSONObject mReportExtData;
    public k nM;
    public View wU;
    public ImageView wV;
    public com.kwad.components.ad.widget.tailframe.appbar.a wW;
    public TailFrameBarH5View wX;
    public b wY;
    public TextProgressBar wZ;
    public View xa;
    public int xb;

    public a(int i) {
        this.xb = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(View view2, final boolean z) {
        if (d.p(this.mAdTemplate)) {
            this.nM.a(this.wU.getContext(), z ? 1 : 153, view2 == this.xa ? 1 : 2);
        } else if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
            com.kwad.components.core.c.a.a.a(new a.C0596a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.wZ).ae(r1).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    if (a.this.wY != null) {
                        a.this.wY.R(z);
                    }
                }
            }));
        } else {
            com.kwad.components.core.c.a.a.a(new a.C0596a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.wZ).ae(r1).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    if (a.this.wY != null) {
                        a.this.wY.R(z);
                    }
                }
            }));
        }
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.wW.u(a.this.mAdInfo);
                a.this.wZ.f(com.kwad.sdk.core.response.a.a.al(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.wW.u(a.this.mAdInfo);
                a.this.wZ.f(com.kwad.sdk.core.response.a.a.aJ(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.wW.u(a.this.mAdInfo);
                a.this.wZ.f(com.kwad.sdk.core.response.a.a.al(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.wW.u(a.this.mAdInfo);
                a.this.wZ.f(com.kwad.sdk.core.response.a.a.P(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                a.this.wW.u(a.this.mAdInfo);
                a.this.wZ.f(com.kwad.sdk.core.response.a.a.aX(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.wW.u(a.this.mAdInfo);
                a.this.wZ.f(com.kwad.sdk.core.response.a.a.aW(i), i);
            }
        });
    }

    private void jh() {
        this.wU.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    private void jj() {
        if (!com.kwad.sdk.core.response.a.a.am(this.mAdInfo) && !d.p(this.mAdTemplate)) {
            this.wX.c(this.mAdTemplate);
            TextView h5OpenBtn = this.wX.getH5OpenBtn();
            this.cE = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.wX.setVisibility(0);
            new f(this.cE, this);
            return;
        }
        this.wW.c(this.mAdTemplate);
        this.wW.setVisibility(0);
        this.wZ = this.wW.getTextProgressBar();
        if (!d.p(this.mAdTemplate)) {
            this.wZ.setClickable(true);
            new f(this.wZ, this);
            bindDownloadListener();
            return;
        }
        View btnInstallContainer = this.wW.getBtnInstallContainer();
        this.xa = btnInstallContainer;
        btnInstallContainer.setClickable(true);
        new f(this.xa, this);
    }

    public void E(Context context) {
        View inflate = LayoutInflater.from(context).inflate(this.xb, (ViewGroup) null, false);
        this.wU = inflate;
        this.wV = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0913af);
        this.bq = (KsLogoView) this.wU.findViewById(R.id.obfuscated_res_0x7f0913ac);
        this.wW = (com.kwad.components.ad.widget.tailframe.appbar.a) this.wU.findViewById(R.id.obfuscated_res_0x7f091389);
        this.wX = (TailFrameBarH5View) this.wU.findViewById(R.id.obfuscated_res_0x7f09139f);
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.bQ(adTemplate);
        this.mReportExtData = jSONObject;
        this.wY = bVar;
        this.bq.T(this.mAdTemplate);
        jj();
        this.wU.setClickable(true);
        new f(this.wU, this);
    }

    public final void d(boolean z, boolean z2) {
        this.wX.e(z, z2);
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.wW;
        if (aVar != null) {
            aVar.jl();
            this.wW.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.wX;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.jl();
            this.wX.setVisibility(8);
        }
        jh();
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        if (com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public final void iP() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.wW;
        if (aVar != null) {
            aVar.jl();
        }
        TailFrameBarH5View tailFrameBarH5View = this.wX;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.jl();
        }
    }

    public final View ji() {
        return this.wU;
    }

    public final void setCallerContext(k kVar) {
        this.nM = kVar;
    }
}

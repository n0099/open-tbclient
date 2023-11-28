package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class a implements c {
    public View BB;
    public ImageView BC;
    public com.kwad.components.ad.widget.tailframe.appbar.a BD;
    public TailFrameBarH5View BE;
    public b BF;
    public TextProgressBar BG;
    public View BH;
    public int BI;
    public TextView dM;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public KsLogoView mLogoView;
    public JSONObject mReportExtData;
    public g qn;

    public a(int i) {
        this.BI = i;
    }

    public final void setCallerContext(g gVar) {
        this.qn = gVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(View view2, final boolean z) {
        int i;
        int i2;
        int i3 = 2;
        boolean z2 = true;
        if (e.F(this.mAdTemplate)) {
            if (z) {
                i2 = 1;
            } else {
                i2 = 153;
            }
            g gVar = this.qn;
            Context context = this.BB.getContext();
            if (view2 == this.BH) {
                i3 = 1;
            }
            gVar.a(1, context, i2, i3);
        } else if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            a.C0644a b = new a.C0644a(view2.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper);
            if (i3 != 1) {
                i = 1;
            } else {
                i = 0;
            }
            a.C0644a al = b.am(i).al(1);
            if (view2 != this.BG) {
                z2 = false;
            }
            com.kwad.components.core.e.d.a.a(al.ao(z2).an(i3).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (a.this.BF != null) {
                        a.this.BF.N(z);
                    }
                }
            }));
        } else {
            a.C0644a b2 = new a.C0644a(view2.getContext()).aq(this.mAdTemplate).b(this.mApkDownloadHelper);
            if (i3 != 1) {
            }
            a.C0644a al2 = b2.am(i).al(1);
            if (view2 != this.BG) {
            }
            com.kwad.components.core.e.d.a.a(al2.ao(z2).an(i3).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (a.this.BF != null) {
                        a.this.BF.N(z);
                    }
                }
            }));
        }
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.BD.D(a.this.mAdInfo);
                a.this.BG.e(com.kwad.sdk.core.response.b.a.cR(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.BD.D(a.this.mAdInfo);
                a.this.BG.e(com.kwad.sdk.core.response.b.a.cQ(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.BD.D(a.this.mAdInfo);
                a.this.BG.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.BD.D(a.this.mAdInfo);
                a.this.BG.e(com.kwad.sdk.core.response.b.a.bX(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.BD.D(a.this.mAdInfo);
                a.this.BG.e(com.kwad.sdk.core.response.b.a.aE(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.BD.D(a.this.mAdInfo);
                a.this.BG.e(com.kwad.sdk.core.response.b.a.ac(a.this.mAdInfo), 0);
            }
        });
    }

    private void kg() {
        this.BB.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.BD;
        if (aVar != null) {
            aVar.kk();
            this.BD.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.BE;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kk();
            this.BE.setVisibility(8);
        }
        kg();
    }

    public final void jO() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.BD;
        if (aVar != null) {
            aVar.kk();
        }
        TailFrameBarH5View tailFrameBarH5View = this.BE;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.kk();
        }
    }

    public final View kh() {
        return this.BB;
    }

    private void ki() {
        if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo) && !e.F(this.mAdTemplate)) {
            this.BE.b(this.mAdTemplate);
            TextView h5OpenBtn = this.BE.getH5OpenBtn();
            this.dM = h5OpenBtn;
            h5OpenBtn.setClickable(true);
            this.BE.setVisibility(0);
            new f(this.dM, this);
            return;
        }
        this.BD.b(this.mAdTemplate);
        this.BD.setVisibility(0);
        this.BG = this.BD.getTextProgressBar();
        if (!e.F(this.mAdTemplate)) {
            this.BG.setClickable(true);
            new f(this.BG, this);
            bindDownloadListener();
            return;
        }
        View btnInstallContainer = this.BD.getBtnInstallContainer();
        this.BH = btnInstallContainer;
        btnInstallContainer.setClickable(true);
        new f(this.BH, this);
    }

    public void B(Context context) {
        View a = l.a(context, this.BI, null, false);
        this.BB = a;
        this.BC = (ImageView) a.findViewById(R.id.obfuscated_res_0x7f09150d);
        this.mLogoView = (KsLogoView) this.BB.findViewById(R.id.obfuscated_res_0x7f09150a);
        this.BD = (com.kwad.components.ad.widget.tailframe.appbar.a) this.BB.findViewById(R.id.obfuscated_res_0x7f0914e2);
        this.BE = (TailFrameBarH5View) this.BB.findViewById(R.id.obfuscated_res_0x7f0914f8);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
        b(view2, true);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        if (d.dE(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dP(adTemplate);
        this.mReportExtData = jSONObject;
        this.BF = bVar;
        this.mLogoView.aD(this.mAdTemplate);
        ki();
        this.BB.setClickable(true);
        new f(this.BB, this);
    }

    public final void f(boolean z, boolean z2) {
        this.BE.g(z, z2);
    }
}

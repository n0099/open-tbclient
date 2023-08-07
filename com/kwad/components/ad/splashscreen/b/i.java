package com.kwad.components.ad.splashscreen.b;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class i extends h implements com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    public View yO;
    public KsRotateView yP;
    public TextView yQ;
    public TextView yR;
    public com.kwad.sdk.core.g.c yS;
    public com.kwad.components.ad.splashscreen.e yT;
    public Runnable yU = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.i.3
        @Override // java.lang.Runnable
        public final void run() {
            i.this.yS.vb();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void Y(String str) {
        TextView textView = this.yR;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void aa(final String str) {
        Runnable runnable;
        long j;
        boolean qm = this.yF.yd.qm();
        boolean mq = com.kwad.components.core.c.kwai.b.mq();
        if (!qm || mq) {
            runnable = this.yU;
            j = DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT;
        } else {
            this.yP.kF();
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            if (hVar != null) {
                hVar.a(getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.b.i.2
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.f fVar) {
                        fVar.cs(str);
                    }
                });
            }
            kn();
            runnable = this.yU;
            j = 2000;
        }
        bd.a(runnable, null, j);
    }

    @Override // com.kwad.components.ad.splashscreen.b.h, com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void initView() {
        this.yO = ((ViewStub) findViewById(R.id.obfuscated_res_0x7f0913e0)).inflate();
        this.yQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0913e1);
        this.yR = (TextView) findViewById(R.id.obfuscated_res_0x7f0913df);
        this.yP = (KsRotateView) findViewById(R.id.obfuscated_res_0x7f0913e2);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void jy() {
        com.kwad.sdk.core.g.c cVar = this.yS;
        if (cVar != null) {
            cVar.bA(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kf() {
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
        getContext();
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        com.kwad.components.ad.splashscreen.e a = com.kwad.components.ad.splashscreen.e.a(hVar.mAdTemplate, bQ, hVar.mApkDownloadHelper, 1);
        this.yT = a;
        TextView textView = this.yQ;
        if (textView != null) {
            textView.setText(a.getTitle());
        }
        TextView textView2 = this.yR;
        if (textView2 != null) {
            textView2.setText(this.yT.jw());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kg() {
        View view2 = this.yO;
        if (view2 == null || this.yF == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.yF.mAdTemplate, (int) H262Reader.START_GROUP, (JSONObject) null);
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kh() {
        com.kwad.components.ad.splashscreen.local.b.R(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void ki() {
        AdMatrixInfo.RotateInfo bq = com.kwad.sdk.core.response.a.b.bq(this.yF.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.yS;
        if (cVar != null) {
            cVar.a(bq);
            return;
        }
        com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(bq);
        this.yS = cVar2;
        cVar2.a(this);
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kj() {
        this.yS.bz(getContext());
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kk() {
        this.yP.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.i.1
            @Override // java.lang.Runnable
            public final void run() {
                i.this.yP.kk();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.b.h
    public final void kl() {
        if (com.kwad.components.ad.splashscreen.d.c.b(this.yF)) {
            com.kwad.components.ad.splashscreen.d.c.a(findViewById(R.id.obfuscated_res_0x7f0913df), -1, 60, -1, -1);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void ko() {
        com.kwad.sdk.core.report.a.az(this.yF.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.b.h, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.b.d("SplashRotatePresenter", "onUnbind");
        com.kwad.sdk.core.g.c cVar = this.yS;
        if (cVar != null) {
            cVar.bA(getContext());
        }
        com.kwad.components.ad.splashscreen.h hVar = this.yF;
        if (hVar != null) {
            hVar.b(this);
        }
    }
}

package com.kwad.components.ad.splashscreen.c;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.location.BDLocation;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.extractor.ts.H262Reader;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.ad.splashscreen.widget.KsRotateView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class l extends i implements View.OnClickListener, com.kwad.components.ad.splashscreen.g, com.kwad.sdk.core.g.a {
    public com.kwad.components.ad.splashscreen.d DA;
    public View Dv;
    public KsRotateView Dw;
    public TextView Dx;
    public TextView Dy;
    public com.kwad.sdk.core.g.c Dz;
    public long mStartTime;

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i) {
    }

    @Override // com.kwad.components.ad.splashscreen.c.i, com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        getRootView().post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.l.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.ad.splashscreen.h hVar = l.this.Df;
                if (hVar != null) {
                    hVar.CH = SystemClock.elapsedRealtime() - l.this.mStartTime;
                }
            }
        });
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar != null) {
            hVar.a(this);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ky() {
        com.kwad.sdk.core.g.c cVar = this.Dz;
        if (cVar != null) {
            cVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void ld() {
        View view2 = this.Dv;
        if (view2 != null && this.Df != null) {
            view2.setVisibility(0);
            com.kwad.sdk.core.report.a.b(this.Df.mAdTemplate, (int) H262Reader.START_GROUP, (JSONObject) null);
            com.kwad.components.core.webview.tachikoma.d.a.sO().aR(H262Reader.START_GROUP);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void le() {
        AdMatrixInfo.RotateInfo cT = com.kwad.sdk.core.response.b.b.cT(this.Df.mAdTemplate);
        com.kwad.sdk.core.g.c cVar = this.Dz;
        if (cVar == null) {
            com.kwad.sdk.core.g.c cVar2 = new com.kwad.sdk.core.g.c(cT);
            this.Dz = cVar2;
            cVar2.a(this);
            return;
        }
        cVar.a(cT);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lf() {
        com.kwad.sdk.core.g.c cVar = this.Dz;
        if (cVar != null) {
            cVar.bi(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lg() {
        com.kwad.sdk.core.g.c cVar = this.Dz;
        if (cVar != null) {
            cVar.bj(getContext());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lh() {
        this.Dw.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.l.1
            @Override // java.lang.Runnable
            public final void run() {
                l.this.Dw.lh();
            }
        });
    }

    @Override // com.kwad.sdk.core.g.a
    public final void lk() {
        com.kwad.sdk.core.report.a.bQ(this.Df.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.e.c.d("SplashRotatePresenter", "onUnbind");
        com.kwad.components.ad.splashscreen.h hVar = this.Df;
        if (hVar != null) {
            hVar.b(this);
        }
    }

    @Override // com.kwad.sdk.core.g.a
    public final void U(final String str) {
        boolean tp = this.Df.Cr.tp();
        boolean nj = com.kwad.components.core.e.c.b.nj();
        if (tp && !nj) {
            this.Dw.lN();
            com.kwad.components.ad.splashscreen.h hVar = this.Df;
            if (hVar != null) {
                hVar.a(1, getContext(), 161, 2, new h.a() { // from class: com.kwad.components.ad.splashscreen.c.l.3
                    @Override // com.kwad.components.ad.splashscreen.h.a
                    public final void b(@NonNull com.kwad.sdk.core.report.j jVar) {
                        jVar.dR(str);
                    }
                });
            }
            lj();
            lg();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        this.Df.c(1, getContext(), BDLocation.TypeServerDecryptError, 1);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void initView() {
        this.mStartTime = SystemClock.elapsedRealtime();
        ViewStub viewStub = (ViewStub) findViewById(R.id.obfuscated_res_0x7f091491);
        if (viewStub != null) {
            this.Dv = viewStub.inflate();
        } else {
            this.Dv = findViewById(R.id.obfuscated_res_0x7f091492);
        }
        this.Dx = (TextView) findViewById(R.id.obfuscated_res_0x7f091493);
        this.Dy = (TextView) findViewById(R.id.obfuscated_res_0x7f091490);
        KsRotateView ksRotateView = (KsRotateView) findViewById(R.id.obfuscated_res_0x7f091494);
        this.Dw = ksRotateView;
        ksRotateView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void lc() {
        AdTemplate adTemplate = this.Df.mAdTemplate;
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        this.DA = com.kwad.components.ad.splashscreen.d.a(adTemplate, dP, this.Df.mApkDownloadHelper, 1);
        TextView textView = this.Dx;
        if (textView != null) {
            textView.setText(com.kwad.sdk.core.response.b.b.dh(dP));
        }
        TextView textView2 = this.Dy;
        if (textView2 != null) {
            textView2.setText("或点击" + this.DA.ks());
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.i
    public final void j(int i, String str) {
        TextView textView = this.Dy;
        if (textView != null) {
            if (i == 2) {
                textView.setText(str);
                return;
            }
            textView.setText("或点击" + str);
        }
    }
}

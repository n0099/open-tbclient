package com.kwad.components.ad.splashscreen.c.a;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.utils.bm;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g extends com.kwad.components.ad.splashscreen.c.c.c implements com.kwad.sdk.core.h.c {
    public FrameLayout lc;
    public aw wy;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    private void lx() {
        this.Df.mRootContainer.findViewById(R.id.obfuscated_res_0x7f092363).setVisibility(8);
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.sk();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.sl();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.Df.Cr.a(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.sg();
            this.wy.sh();
        }
        lx();
        this.lc.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.lc;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dr(this.Df.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lc = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09235d);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        super.onUnbind();
        this.Df.Cr.b(this);
    }

    private void Z(int i) {
        y.a aVar = new y.a();
        bm bmVar = this.Df.mTimerHelper;
        if (bmVar != null) {
            aVar.duration = bmVar.getTime();
        }
        j a = new j().cJ(6).a(aVar);
        if (i == 2) {
            a.cB(14);
        } else {
            a.cB(1);
        }
        com.kwad.sdk.core.report.a.b(this.Df.mAdTemplate, a, (JSONObject) null);
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Df.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.a.g.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    g.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.a.g.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            g.this.Df.kz();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.d.a.a.b(getContext(), this.Df.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.d.a.a.b(getContext(), this.Df.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wy = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        lx();
        this.lc.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        Z(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.Df.kL();
            return;
        }
        com.kwad.components.ad.splashscreen.monitor.a.kM().l(this.Df.mAdTemplate);
        this.Df.kH();
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(a(bVar));
    }
}

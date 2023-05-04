package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bd;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class m extends a {
    public float pY;
    public n qa;
    public KsToastView qh;
    public Runnable qk;
    public boolean qi = false;
    public boolean qj = false;
    public boolean ql = false;
    public boolean qb = false;
    public com.kwad.components.ad.reward.d.e mPlayEndPageListener = new com.kwad.components.ad.reward.d.e() { // from class: com.kwad.components.ad.reward.presenter.m.1
        @Override // com.kwad.components.ad.reward.d.e
        public final void bA() {
            m.this.qh.setVisibility(8);
        }
    };

    public m(n nVar) {
        this.qa = nVar;
    }

    public static /* synthetic */ boolean a(m mVar, boolean z) {
        mVar.ql = true;
        return true;
    }

    private synchronized void gY() {
        if (this.qb) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.nM.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.f().aK(192).F(this.nM.eF.getPlayDuration()));
        this.qb = true;
    }

    private void hd() {
        this.qk = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.m.3
            @Override // java.lang.Runnable
            public final void run() {
                if (m.this.ql) {
                    return;
                }
                if (m.this.qh != null) {
                    m.this.qh.setVisibility(8);
                }
                com.kwad.components.ad.reward.b.eV().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void he() {
        bd.c(this.qk);
        this.qk = null;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.a(this.mPlayEndPageListener);
    }

    public final void hb() {
        if (this.qj) {
            return;
        }
        gY();
        this.qj = true;
        this.qh.setVisibility(0);
        this.qh.U(3);
        hd();
        bd.a(this.qk, null, 3000L);
    }

    public final void hc() {
        this.qj = false;
        this.qh.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsToastView ksToastView = (KsToastView) findViewById(R.id.obfuscated_res_0x7f091385);
        this.qh = ksToastView;
        ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.m.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m.a(m.this, true);
                m.this.qh.setVisibility(8);
                com.kwad.components.ad.reward.b.eV().a(PlayableSource.PENDANT_CLICK_AUTO);
            }
        });
        this.pY = com.kwad.components.ad.reward.kwai.b.gb();
        this.qi = com.kwad.components.ad.reward.kwai.b.gc() && com.kwad.components.ad.reward.kwai.b.gd();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        he();
        this.nM.b(this.mPlayEndPageListener);
    }
}

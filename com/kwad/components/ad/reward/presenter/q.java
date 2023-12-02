package com.kwad.components.ad.reward.presenter;

import android.view.View;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.widget.KsToastView;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class q extends b {
    public float sB;
    public r sD;
    public KsToastView sK;
    public Runnable sN;
    public boolean sL = false;
    public boolean sM = false;
    public boolean sO = false;
    public boolean sE = false;
    public com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.q.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            q.this.sK.setVisibility(8);
        }
    };

    public q(r rVar) {
        this.sD = rVar;
    }

    public static /* synthetic */ boolean a(q qVar, boolean z) {
        qVar.sO = true;
        return true;
    }

    private void hA() {
        this.sN = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (q.this.sO) {
                    return;
                }
                if (q.this.sK != null) {
                    q.this.sK.setVisibility(8);
                }
                com.kwad.components.ad.reward.a.eW().a(PlayableSource.PENDANT_AUTO);
            }
        };
    }

    private void hB() {
        bn.c(this.sN);
        this.sN = null;
    }

    private synchronized void hv() {
        if (this.sE) {
            return;
        }
        com.kwad.sdk.core.report.a.d(this.qn.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.report.j().cC(192).ai(this.qn.oI.getPlayDuration()));
        this.sE = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.sK == null) {
            KsToastView ksToastView = (KsToastView) findViewById(R.id.obfuscated_res_0x7f0914dd);
            this.sK = ksToastView;
            ksToastView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.reward.presenter.q.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    q.a(q.this, true);
                    q.this.sK.setVisibility(8);
                    com.kwad.components.ad.reward.a.eW().a(PlayableSource.PENDANT_CLICK_AUTO);
                }
            });
        }
        this.qn.b(this.mPlayEndPageListener);
    }

    public final void hy() {
        if (this.sM) {
            return;
        }
        hv();
        this.sM = true;
        this.sK.setVisibility(0);
        this.sK.U(3);
        hA();
        bn.a(this.sN, null, 3000L);
    }

    public final void hz() {
        this.sM = false;
        this.sK.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        boolean z;
        super.onCreate();
        this.sB = com.kwad.components.ad.reward.a.b.gt();
        if (com.kwad.components.ad.reward.a.b.gu() && com.kwad.components.ad.reward.a.b.gv()) {
            z = true;
        } else {
            z = false;
        }
        this.sL = z;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        hB();
        this.qn.c(this.mPlayEndPageListener);
    }
}

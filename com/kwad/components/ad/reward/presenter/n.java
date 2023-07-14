package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes10.dex */
public final class n extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.d.e, com.kwad.components.ad.reward.d.f, x.b {
    public float pY;
    public boolean qn;
    @Nullable
    public a qo;
    @Nullable
    public m qp;
    @Nullable
    public k qq;
    public l qr;
    public int qs;
    public boolean qt;
    public boolean qu;
    public boolean qv;
    public boolean qw;

    /* loaded from: classes10.dex */
    public class a extends com.kwad.components.core.video.h {
        public long qx;
        public long videoDuration;

        public a() {
        }

        public /* synthetic */ a(n nVar, byte b) {
            this();
        }

        @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
        public final void onVideoPlayProgress(long j, long j2) {
            super.onVideoPlayProgress(j, j2);
            this.qx = j2;
            this.videoDuration = j;
            if (n.this.qu) {
                return;
            }
            n.this.a(j, j2, false);
        }
    }

    public n(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    public n(AdTemplate adTemplate, boolean z, boolean z2) {
        this.qs = 0;
        this.qt = false;
        this.qu = false;
        this.qv = true;
        this.qw = true;
        this.qv = z;
        this.qw = z2;
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        if (!com.kwad.sdk.core.response.a.a.aY(bQ)) {
            if (com.kwad.sdk.core.response.a.a.aZ(bQ)) {
                return;
            }
            com.kwad.components.core.j.a.og().P(adTemplate);
            return;
        }
        l lVar = new l();
        this.qr = lVar;
        a(lVar);
        if (this.qw) {
            m mVar = new m(this);
            this.qp = mVar;
            a(mVar);
        }
        if (this.qv) {
            k kVar = new k(this);
            this.qq = kVar;
            a(kVar);
        }
        a(new com.kwad.components.ad.reward.presenter.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        m mVar;
        if (hf() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.pY) {
            if (!com.kwad.components.ad.reward.kwai.b.gd()) {
                k kVar = this.qq;
                if (kVar != null) {
                    kVar.M(!z);
                    this.qs = 2;
                }
            } else if (this.qt || (mVar = this.qp) == null) {
            } else {
                mVar.hb();
                this.qs = 1;
                this.qt = true;
            }
        }
    }

    private boolean hf() {
        return this.qn;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.j jVar) {
        k kVar;
        m mVar;
        this.qu = true;
        if (this.qs == 1 && (mVar = this.qp) != null) {
            mVar.hc();
        } else if (this.qs != 2 || (kVar = this.qq) == null) {
        } else {
            kVar.hide();
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        a aVar2;
        boolean isSuccess = aVar.isSuccess();
        this.qn = isSuccess;
        if (!isSuccess || (aVar2 = this.qo) == null) {
            return;
        }
        a(aVar2.videoDuration, this.qo.qx, false);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.a(this);
        com.kwad.components.core.playable.a aVar = this.nM.mk;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean gc = com.kwad.components.ad.reward.kwai.b.gc();
        this.pY = com.kwad.components.ad.reward.kwai.b.gb();
        if (gc) {
            a aVar2 = new a(this, (byte) 0);
            this.qo = aVar2;
            this.nM.eF.a(aVar2);
        }
        com.kwad.components.ad.reward.b.eV().a(this);
    }

    @Override // com.kwad.components.ad.reward.d.e
    public final void bA() {
        RewardActionBarControl.ShowActionBarResult hx = this.nM.ml.hx();
        if (hx != null) {
            hx.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.qr == null || this.nM.fA()) {
            return;
        }
        if (hf()) {
            this.qr.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.qr.ha();
        }
    }

    public final boolean bG() {
        boolean fD = this.nM.fD();
        if (!this.qu || fD) {
            return false;
        }
        com.kwad.components.ad.reward.b.eV().eW();
        this.qu = false;
        return true;
    }

    public final boolean bH() {
        return this.qu;
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bO() {
        this.qu = false;
        a aVar = this.qo;
        if (aVar == null || this.qs != 2) {
            return;
        }
        a(aVar.videoDuration, this.qo.qx, true);
    }

    @Override // com.kwad.components.ad.reward.d.f
    public final void bP() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.b(this);
        com.kwad.components.core.playable.a aVar = this.nM.mk;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.qo;
        if (aVar2 != null) {
            this.nM.eF.b(aVar2);
        }
        com.kwad.components.ad.reward.b.eV().b(this);
    }
}

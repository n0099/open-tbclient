package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements j {
    public g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.e.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            e.this.iq();
        }
    };
    public View vu;
    public View vv;
    public ImageView vw;

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    public e() {
        a(new com.kwad.components.ad.reward.presenter.platdetail.a());
        a(new com.kwad.components.ad.reward.presenter.d.a());
    }

    private void ip() {
        if (!this.qn.oZ) {
            this.vv.setVisibility(8);
        }
        this.vu.setVisibility(0);
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qn.mAdTemplate) && ai.Kx()) {
            this.vw.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.vu.setVisibility(0);
        this.vv.setVisibility(8);
        this.qn.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eW().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        ip();
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
        iq();
    }

    public final void iq() {
        if (this.qn.oZ) {
            this.vu.setVisibility(8);
        } else {
            this.vu.setVisibility(8);
            this.vv.setVisibility(0);
        }
        getContext();
        if (com.kwad.components.ad.reward.g.F(this.qn.mAdTemplate) && ai.Kx()) {
            this.vw.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.vu = findViewById(R.id.obfuscated_res_0x7f0913e6);
        this.vv = findViewById(R.id.obfuscated_res_0x7f0913e7);
        this.vw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091318);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ip();
        this.qn.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.eW().b(this);
        this.vv.setVisibility(8);
    }
}

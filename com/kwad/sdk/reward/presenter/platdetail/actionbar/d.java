package com.kwad.sdk.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.reward.d.g;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes5.dex */
public class d extends g implements RewardActionBarControl.c {
    public ViewGroup b;
    public com.kwad.sdk.reward.d.g c;
    public KsLogoView d;
    public int e;
    public FrameLayout.LayoutParams f;
    public g.a g;

    public d(ViewGroup viewGroup, g.a aVar) {
        this.b = viewGroup;
        this.g = aVar;
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        ((com.kwad.sdk.reward.g) this).a.n.a(this);
        AdInfo j = com.kwad.sdk.core.response.a.d.j(((com.kwad.sdk.reward.g) this).a.g);
        this.e = this.d.getVisibility();
        this.f = c.a(q(), j, this.d, R.dimen.obfuscated_res_0x7f07039d);
        com.kwad.sdk.reward.d.g gVar = new com.kwad.sdk.reward.d.g(this.b, new com.kwad.sdk.reward.d.a(q(), ((com.kwad.sdk.reward.g) this).a) { // from class: com.kwad.sdk.reward.presenter.platdetail.actionbar.d.1
            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void a() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }

            @Override // com.kwad.sdk.reward.d.a, com.kwad.sdk.reward.d.b
            public void b() {
                ((com.kwad.sdk.reward.g) d.this).a.a(d.this.q(), 10, 1);
            }
        });
        this.c = gVar;
        gVar.a(this.g);
        this.c.a(((com.kwad.sdk.reward.g) this).a.g);
        w.a(new com.kwad.sdk.widget.c(com.kwad.sdk.core.config.b.aL()), this.c.a());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.d.setVisibility(this.e);
        FrameLayout.LayoutParams layoutParams = this.f;
        if (layoutParams != null) {
            this.d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        this.d = (KsLogoView) a(R.id.obfuscated_res_0x7f091019);
    }

    @Override // com.kwad.sdk.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public void d() {
        this.b.setVisibility(0);
    }
}

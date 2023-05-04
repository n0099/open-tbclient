package com.kwad.components.ad.reward.presenter.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.presenter.o;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.webview.b.a;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
/* loaded from: classes8.dex */
public final class b extends a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    public final com.kwad.components.core.webview.b.d.a mt = new com.kwad.components.core.webview.b.d.a() { // from class: com.kwad.components.ad.reward.presenter.c.b.4
        @Override // com.kwad.components.core.webview.b.d.a
        public final void cy() {
            if (b.this.tp != null) {
                com.kwad.components.core.webview.b.a.a aVar = new com.kwad.components.core.webview.b.a.a();
                aVar.NJ = b.this.nM.mT ? 1 : 0;
                b.this.tp.b(aVar);
            }
        }
    };
    public ViewGroup tj;
    public ViewGroup tk;
    public ViewGroup tl;
    public View tm;
    public ViewGroup tn;
    public FrameLayout to;
    public com.kwad.components.core.webview.b.c tp;

    private void R(final int i) {
        this.nM.mRootContainer.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.c.b.3
            @Override // java.lang.Runnable
            public final void run() {
                int m94if = b.this.m94if();
                int S = b.this.S(i);
                if (b.this.to != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) b.this.to.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.topMargin = m94if;
                    layoutParams.height = (az.getScreenHeight(b.this.getContext()) - m94if) - S;
                    b.this.to.setLayoutParams(layoutParams);
                }
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int S(int i) {
        return this.tk.getHeight() > 0 ? this.tk.getHeight() : this.tn.getHeight() > 0 ? this.tn.getHeight() : i > 0 ? i : com.kwad.sdk.b.kwai.a.a(getContext(), 120.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public int m94if() {
        ViewGroup viewGroup;
        int height;
        if (this.tj.getHeight() > 0) {
            viewGroup = this.tj;
        } else if (com.kwad.sdk.core.response.a.a.ao(com.kwad.sdk.core.response.a.d.bQ(this.nM.mAdTemplate)) && (height = ((ViewGroup.MarginLayoutParams) this.tm.getLayoutParams()).topMargin + 0 + this.tm.getHeight()) > 0) {
            return height;
        } else {
            viewGroup = this.tl;
        }
        return viewGroup.getHeight();
    }

    private com.kwad.components.core.webview.b.c ig() {
        return new com.kwad.components.core.webview.b.c() { // from class: com.kwad.components.ad.reward.presenter.c.b.5
            @Override // com.kwad.components.core.webview.b.c, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.b.a.a aVar = new com.kwad.components.core.webview.b.a.a();
                aVar.NJ = b.this.nM.mT ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    private com.kwad.components.core.webview.b.b ih() {
        return new com.kwad.components.core.webview.b.b() { // from class: com.kwad.components.ad.reward.presenter.c.b.6
            @Override // com.kwad.components.core.webview.b.b, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.b.a.c cVar2 = new com.kwad.components.core.webview.b.a.c();
                cVar2.NL = com.kwad.components.ad.reward.model.b.gK();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        R(layoutParams != null ? layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + layoutParams.height : layoutParams.height : 0);
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.core.webview.b.e
    public final void a(h hVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(hVar, bVar);
        this.tp = ig();
        this.nM.a(this.mt);
        hVar.c(this.tp);
        hVar.c(new com.kwad.components.core.webview.b.a(new a.InterfaceC0609a() { // from class: com.kwad.components.ad.reward.presenter.c.b.1
            @Override // com.kwad.components.core.webview.b.a.InterfaceC0609a
            public final void ii() {
                com.kwad.components.ad.reward.model.b.P(b.this.nM.mContext);
            }
        }));
        hVar.c(ih());
        hVar.c(new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.b() { // from class: com.kwad.components.ad.reward.presenter.c.b.2
            @Override // com.kwad.components.core.webview.jshandler.b
            public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
                if (TextUtils.equals(str, "autoCallApp")) {
                    AdTemplate adTemplate = b.this.nM.mAdTemplate;
                    AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                    boolean z = true;
                    aVar.h(!com.kwad.sdk.core.response.a.a.aY(bQ) && (adTemplate.inPlayAgain || adTemplate.mPlayAgain != null), (!com.kwad.sdk.core.response.a.a.aY(bQ) && !com.kwad.components.ad.reward.kwai.b.j(bQ) && com.kwad.sdk.core.response.a.b.cg(bQ) && o.hg() && b.this.nM.mScreenOrientation == 0) ? false : false);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.nM.ml.a(this);
        this.to.setVisibility(0);
        R(0);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        return "ksad-video-middle-card";
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        return this.to;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        this.to.setVisibility(8);
        com.kwad.components.core.webview.b.c.a.pR().aK(bZ());
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a
    public final boolean cc() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.to = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09125d);
        this.tj = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09125f);
        this.tl = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091297);
        this.tk = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09125c);
        this.tn = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09129d);
        this.tm = findViewById(R.id.obfuscated_res_0x7f091203);
    }

    @Override // com.kwad.components.ad.reward.presenter.c.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.nM.ml.b(this);
        this.nM.a((com.kwad.components.core.webview.b.d.a) null);
    }
}

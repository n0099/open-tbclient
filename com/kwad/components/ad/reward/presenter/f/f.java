package com.kwad.components.ad.reward.presenter.f;

import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.k.l;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.i.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class f extends a implements j, a.InterfaceC0649a {
    public com.kwad.components.core.webview.tachikoma.e lg;
    public List<com.kwad.components.core.i.c> tm;
    public FrameLayout wf;
    public boolean wg = false;
    public final com.kwad.components.core.webview.tachikoma.e.a oU = new com.kwad.components.core.webview.tachikoma.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.1
        @Override // com.kwad.components.core.webview.tachikoma.e.a
        public final void iY() {
            if (f.this.lg != null) {
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.ZP = f.this.qn.fP ? 1 : 0;
                f.this.lg.b(aVar);
            }
        }
    };

    @Override // com.kwad.components.ad.reward.e.j
    public final void bZ() {
    }

    @IdRes
    public int ci() {
        return R.id.obfuscated_res_0x7f09139e;
    }

    public String getTKReaderScene() {
        return "tk_reward";
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void onRequestResult(int i) {
    }

    private com.kwad.components.core.webview.tachikoma.c dB() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.f.6
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.c cVar2 = new com.kwad.components.core.webview.tachikoma.b.c();
                cVar2.ZR = com.kwad.components.ad.reward.model.b.cO();
                cVar.a(cVar2);
            }
        };
    }

    private com.kwad.components.core.webview.tachikoma.e dC() {
        return new com.kwad.components.core.webview.tachikoma.e() { // from class: com.kwad.components.ad.reward.presenter.f.f.5
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.b.a aVar = new com.kwad.components.core.webview.tachikoma.b.a();
                aVar.ZP = f.this.qn.fP ? 1 : 0;
                cVar.a(aVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (!this.wg) {
            V(true);
        }
        com.kwad.components.ad.reward.g gVar = this.qn;
        gVar.oY = true ^ this.wg;
        gVar.a((a.InterfaceC0649a) this);
        com.kwad.components.ad.reward.a.eW().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void bY() {
        FrameLayout frameLayout;
        if (!this.wg && (frameLayout = this.wf) != null) {
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.wf;
    }

    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dl(this.qn.mAdTemplate);
    }

    public final BackPressHandleResult gl() {
        com.kwad.components.ad.reward.k.a.d dVar = this.wj;
        if (dVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return dVar.gl();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wf = (FrameLayout) findViewById(ci());
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.qn.b((a.InterfaceC0649a) this);
        com.kwad.components.ad.reward.a.eW().b(this);
    }

    private void V(boolean z) {
        int i;
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "fullTK: " + z);
        FrameLayout frameLayout = this.wf;
        if (frameLayout == null) {
            return;
        }
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
    }

    public static List<AdTemplate> a(List<com.kwad.components.core.i.c> list, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(adTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.l(list));
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
        FrameLayout frameLayout;
        if (!this.wg && (frameLayout = this.wf) != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onTkLoadFailed");
        this.wg = true;
        this.qn.oY = false;
        V(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar) {
        com.kwad.components.ad.reward.e.b bVar;
        com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onSkipClick: " + tVar.aaf);
        com.kwad.components.ad.reward.g gVar = this.qn;
        if (gVar != null && (bVar = gVar.oH) != null) {
            bVar.onVideoSkipToEnd(tVar.aaf * 1000);
        }
        com.kwad.components.ad.reward.presenter.f.s(this.qn);
        com.kwad.components.ad.reward.g.a(this.qn.oQ, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.f.7
            public static void c(com.kwad.components.ad.reward.k.a aVar) {
                aVar.iJ();
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.k.a aVar) {
                c(aVar);
            }
        });
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0649a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list != null && list.size() != 0 && this.wj != null) {
            this.tm = list;
            List<AdTemplate> a = a(list, this.qn.mAdTemplate);
            com.kwad.sdk.core.webview.b st = this.wj.st();
            if (st != null) {
                st.setAdTemplateList(a);
            }
            l jm = this.wj.jm();
            if (jm != null) {
                jm.g(a);
            } else {
                this.wj.h(a);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(new com.kwad.components.ad.reward.c.f(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.presenter.f.f.2
            @Override // com.kwad.components.ad.reward.c.d
            public final void a(com.kwad.components.ad.reward.c.b bVar2) {
                com.kwad.sdk.core.e.c.d("TkRewardPagePresenter", "onUpdateExtraReward : " + bVar2.gM());
                f.this.a(bVar2);
            }
        }));
        this.lg = dC();
        this.qn.a(this.oU);
        pVar.c(this.lg);
        pVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.f.3
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void dL() {
                com.kwad.components.ad.reward.model.b.J(f.this.qn.mContext);
            }
        }));
        pVar.c(dB());
        pVar.c(new com.kwad.components.core.webview.jshandler.h(new com.kwad.components.core.webview.jshandler.n() { // from class: com.kwad.components.ad.reward.presenter.f.f.4
            @Override // com.kwad.components.core.webview.jshandler.n
            public final void a(com.kwad.components.core.webview.jshandler.h hVar, String str) {
                boolean z;
                if (TextUtils.equals(str, "autoCallApp")) {
                    if (com.kwad.components.ad.reward.g.g(com.kwad.sdk.core.response.b.e.dP(f.this.qn.mAdTemplate)) && com.kwad.sdk.core.d.a.Cw() && f.this.qn.mScreenOrientation == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    hVar.aS(z);
                }
            }
        }));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar != null && !com.kwad.sdk.core.response.b.e.b(this.qn.mAdResultData.getProceedTemplateList(), aVar.creativeId, aVar.adStyle)) {
            if (aVar.adTemplate != null && !aVar.aDK) {
                this.qn.oH.bJ();
                return;
            }
            com.kwad.components.core.i.c a = com.kwad.components.ad.reward.g.a(this.tm, aVar.creativeId);
            if (a != null) {
                this.qn.a(a);
                return;
            }
            return;
        }
        this.qn.oH.bJ();
    }
}

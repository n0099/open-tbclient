package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
/* loaded from: classes10.dex */
public final class k extends b {
    public final AdLiveCallerContextListener sl = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.qn);
        }
    };
    public final com.kwad.components.core.l.a.a sm = new com.kwad.components.core.l.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            if (k.this.qn.oI.jK()) {
                k.this.qn.oI.jL().onPause();
            }
        }

        @Override // com.kwad.components.core.l.a.b, com.kwad.components.core.l.a.a
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            if (k.this.qn.oI.jK()) {
                k.this.qn.oI.jL().onResume();
                if (com.kwad.components.core.s.a.ah(k.this.qn.mContext).qJ()) {
                    k.this.qn.d(false, false);
                }
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        if (this.qn.oI.jK()) {
            this.qn.oI.jL().registerAdLiveCallerContextListener(this.sl);
            this.qn.Mm.add(this.sm);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.qn.oI.jK()) {
            this.qn.oI.jL().unRegisterAdLiveCallerContextListener(this.sl);
            this.qn.Mm.remove(this.sm);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}

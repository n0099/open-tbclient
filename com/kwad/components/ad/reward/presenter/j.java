package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class j extends b {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        try {
            this.qn.oI.jG();
        } catch (Throwable th) {
            bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.presenter.j.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.sdk.crash.b.m(th);
                    j.this.hn();
                }
            });
        }
    }
}

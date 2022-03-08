package com.kwad.sdk.reward.presenter.platdetail;

import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.presenter.platdetail.kwai.d;
import com.kwad.sdk.reward.presenter.platdetail.kwai.e;
/* loaded from: classes8.dex */
public class c extends g {
    public c(boolean z) {
        Presenter bVar;
        if (z) {
            bVar = new e();
        } else {
            a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.kwai.a());
            bVar = new com.kwad.sdk.reward.presenter.platdetail.kwai.b();
        }
        a(bVar);
        a((Presenter) new d());
        a((Presenter) new com.kwad.sdk.reward.presenter.platdetail.kwai.c());
    }
}

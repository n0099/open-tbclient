package com.kwad.components.ad.reward.presenter.b;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.model.AdLiveEndResultData;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.report.j;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.b.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    public IAdLiveEndRequest ga;
    public long hj;
    @Nullable
    public p ph;
    @Nullable
    public View tO;
    public final l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData> mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.1
        @Override // com.kwad.sdk.core.network.l
        public final boolean isPostByJson() {
            return false;
        }

        @NonNull
        public static AdLiveEndResultData P(String str) {
            AdLiveEndResultData adLiveEndResultData = new AdLiveEndResultData();
            adLiveEndResultData.parseJson(new JSONObject(str));
            return adLiveEndResultData;
        }

        /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ AdLiveEndResultData parseData(String str) {
            return P(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: bC */
        public com.kwad.components.core.liveEnd.a createRequest() {
            return new com.kwad.components.core.liveEnd.a(b.this.ga);
        }
    };
    public final com.kwad.components.core.video.l su = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.b.b.2
        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.hM();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayResume() {
            super.onLivePlayResume();
            b.this.hN();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.hN();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            b.this.hj = j2;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void hM() {
        if (this.ga == null) {
            return;
        }
        this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndResultData>() { // from class: com.kwad.components.ad.reward.presenter.b.b.3
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.liveEnd.a aVar) {
                super.onStartRequest(aVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.liveEnd.a aVar, int i, String str) {
                super.onError(aVar, i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.liveEnd.a aVar, @NonNull final AdLiveEndResultData adLiveEndResultData) {
                super.onSuccess(aVar, adLiveEndResultData);
                if (adLiveEndResultData.mQLivePushEndInfo == null) {
                    return;
                }
                b.this.qn.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.b.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (b.this.ph == null) {
                            b bVar = b.this;
                            bVar.ph = new p(bVar.qn);
                        }
                        b.this.ph.h(b.this.qn.mRootContainer);
                        b.this.ph.b(r.R(b.this.qn.mAdTemplate));
                        b.this.ph.a(b.this.qn, adLiveEndResultData.mQLivePushEndInfo, b.this.hj);
                        b.this.qn.ph = b.this.ph;
                        b bVar2 = b.this;
                        bVar2.tO = bVar2.findViewById(R.id.obfuscated_res_0x7f0913bf);
                        b.this.tO.setVisibility(0);
                        b.this.hv();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hN() {
        View view2 = this.tO;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hv() {
        j jVar = new j();
        y.a aVar = new y.a();
        jVar.cJ(24);
        jVar.a(aVar);
        com.kwad.components.ad.reward.j.b.a(true, this.qn.mAdTemplate, null, jVar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mNetworking.cancel();
        if (this.qn.oI.jK()) {
            this.qn.oI.b(this.su);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        com.kwad.components.core.n.a.a.a aVar;
        super.aj();
        if (this.qn.oI.jK()) {
            this.qn.oI.a(this.su);
            String bg = com.kwad.sdk.core.response.b.a.bg(e.dP(this.qn.mAdTemplate));
            if (!TextUtils.isEmpty(bg) && (aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.a.a.class)) != null) {
                this.ga = aVar.getAdLiveEndRequest(bg);
            }
        }
    }
}

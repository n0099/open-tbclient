package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.k.kwai.a;
import com.kwad.components.core.m.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.feed.e$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass1 extends com.kwad.components.core.k.c {
        public final /* synthetic */ KsLoadManager.FeedAdListener cT;
        public final /* synthetic */ KsScene cU;
        public final /* synthetic */ boolean cV;

        public AnonymousClass1(KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene, boolean z) {
            this.cT = feedAdListener;
            this.cU = ksScene;
            this.cV = z;
        }

        @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
        public final void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adResultData.getAdTemplateList().size());
            String str = null;
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        KsScene ksScene = this.cU;
                        if (ksScene instanceof SceneImpl) {
                            adTemplate.mAdScene = (SceneImpl) ksScene;
                        }
                        arrayList.add(new d(adTemplate, this.cU.getWidth(), this.cV));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.aD(bQ)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            if (!arrayList.isEmpty()) {
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        int size = arrayList.size();
                        com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "mHandler " + size);
                        if (size == 0) {
                            KsAdLoadManager.ab().b(arrayList);
                            AnonymousClass1.this.cT.onFeedAdLoad(arrayList);
                            return;
                        }
                        final d.a aVar = new d.a(size);
                        for (KsFeedAd ksFeedAd : arrayList) {
                            final d dVar = (d) ksFeedAd;
                            com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            dVar.a(new d.b() { // from class: com.kwad.components.ad.feed.e.1.2.1
                                @Override // com.kwad.components.ad.feed.d.b
                                public final void aZ() {
                                    com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + dVar + " cnt: " + aVar.ba());
                                    if (aVar.bb()) {
                                        KsAdLoadManager.ab().b(arrayList);
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        AnonymousClass1.this.cT.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            int i = com.kwad.sdk.core.network.f.Yd.errorCode;
            onError(i, com.kwad.sdk.core.network.f.Yd.Qd + str);
            com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
        public final void onError(final int i, final String str) {
            bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                    AnonymousClass1.this.cT.onError(i, str);
                }
            });
        }
    }

    public static void a(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        boolean a = m.oF().a(ksScene, "loadConfigFeedAd");
        ksScene.setAdStyle(1);
        KsAdLoadManager.ab();
        KsAdLoadManager.a(new a.C0624a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new AnonymousClass1(feedAdListener, ksScene, z)).oo());
    }
}

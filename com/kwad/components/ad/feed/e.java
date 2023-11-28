package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.feed.e$2  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static class AnonymousClass2 extends com.kwad.components.core.request.d {
        public final /* synthetic */ KsLoadManager.FeedAdListener el;
        public final /* synthetic */ SceneImpl em;
        public final /* synthetic */ boolean en;
        public final /* synthetic */ long eo;

        public AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z, long j) {
            this.el = feedAdListener;
            this.em = sceneImpl;
            this.en = z;
            this.eo = j;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.aY();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
                    if (!FeedType.checkTypeValid(adTemplate)) {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.be(dP)), FeedType.fromInt(adTemplate.type));
                        com.kwad.components.ad.feed.monitor.b.e(com.kwad.sdk.core.response.b.a.be(dP), adTemplate.type);
                    } else {
                        adTemplate.mAdScene = this.em;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dP))) {
                            Pair<Integer, String> d = com.kwad.components.ad.feed.monitor.a.d(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.e(((Integer) d.first).intValue(), (String) d.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate), this.en));
                    }
                }
            }
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.t(arrayList.size());
            if (arrayList.isEmpty()) {
                int i = com.kwad.sdk.core.network.e.ats.errorCode;
                com.kwad.components.ad.feed.monitor.b.d(i, com.kwad.sdk.core.network.e.ats.msg + str);
                int i2 = com.kwad.sdk.core.network.e.ats.errorCode;
                onError(i2, com.kwad.sdk.core.network.e.ats.msg + str);
                com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
                return;
            }
            com.kwad.sdk.commercial.e.c.j(adTemplateList.get(0), arrayList.size());
            if (com.kwad.sdk.core.config.d.Ap() && (!KsAdSDKImpl.get().getIsExternal() || (KsAdSDKImpl.get().getIsExternal() && com.kwad.sdk.core.config.d.Aq() == 1))) {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.eo);
                        KsAdLoadManager.M().b(arrayList);
                        AnonymousClass2.this.el.onFeedAdLoad(arrayList);
                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.em.getPosId(), arrayList);
                    }
                });
            } else {
                bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        final int i3;
                        final int size = arrayList.size();
                        final int[] iArr = {0};
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final c cVar = (c) ksFeedAd;
                            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            if (com.kwad.sdk.core.response.b.b.cN(cVar.getAdTemplate())) {
                                i3 = 3;
                            } else {
                                i3 = 2;
                            }
                            final long elapsedRealtime = SystemClock.elapsedRealtime();
                            cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                @Override // com.kwad.components.ad.feed.c.a
                                public final void c(int i4, String str2) {
                                    com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                    com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i4, i3, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                    int[] iArr2 = iArr;
                                    int i5 = iArr2[0] + 1;
                                    iArr2[0] = i5;
                                    int i6 = size;
                                    if (i5 == i6) {
                                        com.kwad.components.ad.feed.monitor.b.a(i6, SystemClock.elapsedRealtime() - AnonymousClass2.this.eo);
                                        KsAdLoadManager.M().b(arrayList);
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        AnonymousClass2.this.el.onFeedAdLoad(arrayList);
                                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.em.getPosId(), arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(final int i, final String str) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass2.this.el.onError(i, str);
                }
            });
            com.kwad.sdk.core.e.c.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            com.kwad.components.ad.feed.monitor.b.d(i, str);
            if (i != com.kwad.sdk.core.network.e.atn.errorCode && i != com.kwad.sdk.core.network.e.ats.errorCode) {
                com.kwad.components.ad.feed.monitor.b.f(i, str);
            }
        }
    }

    public static void a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.e.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.FeedAdListener feedAdListener2 = KsLoadManager.FeedAdListener.this;
                    int i = com.kwad.sdk.core.network.e.ats.errorCode;
                    feedAdListener2.onError(i, com.kwad.sdk.core.network.e.ats.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.s(covert.getAdNum());
        boolean a = m.qR().a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0661a().e(new ImpInfo(covert)).aI(a).a(new AnonymousClass2(feedAdListener, covert, z, elapsedRealtime)).ql());
    }
}

package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.util.List;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.ad.feed.e$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static class AnonymousClass1 extends com.kwad.components.core.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KsLoadManager.FeedAdListener cT;
        public final /* synthetic */ KsScene cU;
        public final /* synthetic */ boolean cV;

        public AnonymousClass1(KsLoadManager.FeedAdListener feedAdListener, KsScene ksScene, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedAdListener, ksScene, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.cT = feedAdListener;
            this.cU = ksScene;
            this.cV = z;
        }

        @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
        public final void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, adResultData) == null) {
                ArrayList arrayList = new ArrayList();
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
                    bd.runOnUiThread(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.feed.e.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ List aZ;
                        public final /* synthetic */ AnonymousClass1 cW;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.cW = this;
                            this.aZ = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.aZ.size();
                                com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "mHandler " + size);
                                if (size == 0) {
                                    KsAdLoadManager.ab().b(this.aZ);
                                    this.cW.cT.onFeedAdLoad(this.aZ);
                                    return;
                                }
                                d.a aVar = new d.a(size);
                                for (KsFeedAd ksFeedAd : this.aZ) {
                                    d dVar = (d) ksFeedAd;
                                    com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                                    dVar.a(new d.b(this, dVar, aVar) { // from class: com.kwad.components.ad.feed.e.1.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ d cX;
                                        public final /* synthetic */ d.a cY;
                                        public final /* synthetic */ AnonymousClass2 cZ;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, dVar, aVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.cZ = this;
                                            this.cX = dVar;
                                            this.cY = aVar;
                                        }

                                        @Override // com.kwad.components.ad.feed.d.b
                                        public final void aZ() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + this.cX + " cnt: " + this.cY.ba());
                                                if (this.cY.bb()) {
                                                    KsAdLoadManager.ab().b(this.cZ.aZ);
                                                    AnonymousClass2 anonymousClass2 = this.cZ;
                                                    anonymousClass2.cW.cT.onFeedAdLoad(anonymousClass2.aZ);
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                    return;
                }
                int i = com.kwad.sdk.core.network.f.Yd.errorCode;
                onError(i, com.kwad.sdk.core.network.f.Yd.Qd + str);
                com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "loadFeedAd onError");
            }
        }

        @Override // com.kwad.components.core.k.c, com.kwad.components.core.k.g
        public final void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                bd.runOnUiThread(new Runnable(this, i, str) { // from class: com.kwad.components.ad.feed.e.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int aW;
                    public final /* synthetic */ String aX;
                    public final /* synthetic */ AnonymousClass1 cW;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(i), str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.cW = this;
                        this.aW = i;
                        this.aX = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.e.b.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.aW), this.aX));
                            this.cW.cT.onError(this.aW, this.aX);
                        }
                    }
                });
            }
        }
    }

    public static void a(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65536, null, ksScene, feedAdListener, z) == null) {
            boolean a = m.oF().a(ksScene, "loadConfigFeedAd");
            ksScene.setAdStyle(1);
            KsAdLoadManager.ab();
            KsAdLoadManager.a(new a.C0579a().c(new com.kwad.components.core.k.kwai.b(ksScene)).ax(a).a(new AnonymousClass1(feedAdListener, ksScene, z)).oo());
        }
    }
}

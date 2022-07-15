package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.j.kwai.a;
import com.kwad.components.core.l.m;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.ad.feed.e$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static class AnonymousClass1 extends com.kwad.components.core.j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ KsLoadManager.FeedAdListener a;
        public final /* synthetic */ KsScene b;
        public final /* synthetic */ boolean c;

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
            this.a = feedAdListener;
            this.b = ksScene;
            this.c = z;
        }

        @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
        public final void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                az.a(new Runnable(this, i, str) { // from class: com.kwad.components.ad.feed.e.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int a;
                    public final /* synthetic */ String b;
                    public final /* synthetic */ AnonymousClass1 c;

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
                        this.c = this;
                        this.a = i;
                        this.b = str;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(this.a), this.b));
                            this.c.a.onError(this.a, this.b);
                        }
                    }
                });
            }
        }

        @Override // com.kwad.components.core.j.c, com.kwad.components.core.j.g
        public final void a(@NonNull AdResultData adResultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                ArrayList arrayList = new ArrayList();
                com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adResultData.getAdTemplateList().size());
                String str = null;
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
                        if (FeedType.checkTypeValid(adTemplate)) {
                            KsScene ksScene = this.b;
                            if (ksScene instanceof SceneImpl) {
                                adTemplate.mAdScene = (SceneImpl) ksScene;
                            }
                            arrayList.add(new d(adTemplate, this.b.getWidth(), this.c));
                        } else {
                            str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.Y(i)), FeedType.fromInt(adTemplate.type));
                        }
                    }
                }
                com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
                if (!arrayList.isEmpty()) {
                    az.a(new Runnable(this, arrayList) { // from class: com.kwad.components.ad.feed.e.1.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ List a;
                        public final /* synthetic */ AnonymousClass1 b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.b = this;
                            this.a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                int size = this.a.size();
                                com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "mHandler " + size);
                                if (size == 0) {
                                    this.b.a.onFeedAdLoad(this.a);
                                    return;
                                }
                                d.a aVar = new d.a(size);
                                for (KsFeedAd ksFeedAd : this.a) {
                                    d dVar = (d) ksFeedAd;
                                    com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                                    dVar.a(new d.b(this, dVar, aVar) { // from class: com.kwad.components.ad.feed.e.1.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ d a;
                                        public final /* synthetic */ d.a b;
                                        public final /* synthetic */ AnonymousClass2 c;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, dVar, aVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.c = this;
                                            this.a = dVar;
                                            this.b = aVar;
                                        }

                                        @Override // com.kwad.components.ad.feed.d.b
                                        public final void a() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + this.a + " cnt: " + this.b.a());
                                                if (this.b.b()) {
                                                    AnonymousClass2 anonymousClass2 = this.c;
                                                    anonymousClass2.b.a.onFeedAdLoad(anonymousClass2.a);
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
                int i2 = f.f.p;
                a(i2, f.f.q + str);
                com.kwad.sdk.core.d.b.a("KsAdFeedLoadManager", "loadFeedAd onError");
            }
        }
    }

    public static void a(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65536, null, ksScene, feedAdListener, z) == null) {
            boolean a = m.a().a(ksScene, "loadConfigFeedAd");
            ksScene.setAdStyle(1);
            KsAdLoadManager.a();
            KsAdLoadManager.a(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).b(a).a(new AnonymousClass1(feedAdListener, ksScene, z)).a());
        }
    }
}

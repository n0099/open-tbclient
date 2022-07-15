package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.j.kwai.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T extends com.kwad.components.core.j.a> T a(com.kwad.sdk.d.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) ? bVar.a() : (T) invokeL.objValue;
    }

    @Nullable
    public static AdTemplate a(AdBitResultData adBitResultData, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, adBitResultData, j)) == null) {
            for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
                if (adTemplate != null && j == d.t(adTemplate)) {
                    return adTemplate;
                }
            }
            return null;
        }
        return (AdTemplate) invokeLJ.objValue;
    }

    public static String a(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ksScene)) == null) {
            b bVar = (b) a(new com.kwad.sdk.d.b<b>(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).a(new com.kwad.components.core.j.c()).a()) { // from class: com.kwad.components.ad.adbit.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = r6;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.d.b
                /* renamed from: b */
                public b a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new b(this.a) : (b) invokeV.objValue;
                }
            });
            return new a(bVar.getBody(), bVar.getHeader()).a();
        }
        return (String) invokeL.objValue;
    }

    public static List<AdTemplate> a(AdBitResultData adBitResultData) {
        InterceptResult invokeL;
        AdTemplate a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adBitResultData)) == null) {
            ArrayList arrayList = new ArrayList();
            for (AdBid adBid : adBitResultData.adBidList) {
                if (adBid != null && adBid.bidEcpm > 0) {
                    long j = adBid.creativeId;
                    if (j > 0 && (a = a(adBitResultData, j)) != null) {
                        a.mBidEcpm = adBid.bidEcpm;
                        arrayList.add(a);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void a(String str, @NonNull com.kwad.components.core.j.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, aVar) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData = new AdBitResultData(aVar.a.a);
                adBitResultData.parseJson(jSONObject);
                List<String> b = b(adBitResultData);
                if (b.isEmpty()) {
                    com.kwad.components.core.j.kwai.a.a(aVar, f.f.p, f.f.q, false);
                } else {
                    a(b, adBitResultData, aVar);
                }
            } catch (Exception e) {
                f fVar = f.e;
                com.kwad.components.core.j.kwai.a.a(aVar, fVar.p, fVar.q, false);
                com.kwad.sdk.core.d.b.b(e);
            }
        }
    }

    public static void a(List<String> list, AdBitResultData adBitResultData, com.kwad.components.core.j.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, list, adBitResultData, aVar) == null) {
            new l<com.kwad.components.ad.kwai.b, AdBitResultData>(aVar, adBitResultData, list) { // from class: com.kwad.components.ad.adbit.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.a a;
                public final /* synthetic */ AdBitResultData b;
                public final /* synthetic */ List c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar, adBitResultData, list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                    this.b = adBitResultData;
                    this.c = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                /* renamed from: a */
                public AdBitResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdBitResultData adBitResultData2 = new AdBitResultData(this.a.a.a);
                        adBitResultData2.parseJson(jSONObject);
                        return adBitResultData2;
                    }
                    return (AdBitResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.components.ad.kwai.b createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65538, this)) == null) ? new com.kwad.components.ad.kwai.b(this.b.adxId, this.c) : (com.kwad.components.ad.kwai.b) invokeV.objValue;
                }
            }.request(new m<com.kwad.components.ad.kwai.b, AdBitResultData>(adBitResultData, aVar) { // from class: com.kwad.components.ad.adbit.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdBitResultData a;
                public final /* synthetic */ com.kwad.components.core.j.kwai.a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {adBitResultData, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = adBitResultData;
                    this.b = aVar;
                }

                private void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65537, this, i, str) == null) {
                        com.kwad.components.core.j.kwai.a.a(this.b, i, str, false);
                    }
                }

                private void a(@NonNull AdBitResultData adBitResultData2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, adBitResultData2) == null) {
                        adBitResultData2.setAdTemplateList(c.b(this.a, adBitResultData2));
                        if (adBitResultData2.isAdResultDataEmpty()) {
                            com.kwad.components.core.j.kwai.a aVar2 = this.b;
                            f fVar = f.f;
                            com.kwad.components.core.j.kwai.a.a(aVar2, fVar.p, fVar.q, false);
                            return;
                        }
                        AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                        int i = this.b.a.a.adStyle;
                        if (i == 10000 || i == d.c(adTemplate)) {
                            com.kwad.components.core.j.kwai.a.a(this.b, adBitResultData2, false);
                            return;
                        }
                        com.kwad.components.core.j.kwai.a aVar3 = this.b;
                        f fVar2 = f.j;
                        com.kwad.components.core.j.kwai.a.a(aVar3, fVar2.p, fVar2.q, false);
                    }
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                    a(i, str);
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                    a((AdBitResultData) baseResultData);
                }
            });
        }
    }

    public static boolean a(@NonNull com.kwad.components.core.j.kwai.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, aVar)) == null) {
            String bidResponseV2 = aVar.a.a.getBidResponseV2();
            if (!TextUtils.isEmpty(bidResponseV2)) {
                a(bidResponseV2, aVar);
                return true;
            }
            com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
            String bidResponse = aVar.a.a.getBidResponse();
            if (TextUtils.isEmpty(bidResponse)) {
                return false;
            }
            com.kwad.sdk.core.threads.b.g().submit(new Runnable(bidResponse, aVar) { // from class: com.kwad.components.ad.adbit.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ com.kwad.components.core.j.kwai.a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bidResponse, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bidResponse;
                    this.b = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.a);
                            AdBitResultData adBitResultData = new AdBitResultData(this.b.a.a);
                            adBitResultData.parseJson(jSONObject);
                            adBitResultData.setAdTemplateList(c.a(adBitResultData));
                            if (adBitResultData.isAdResultDataEmpty()) {
                                com.kwad.components.core.j.kwai.a.a(this.b, f.f.p, f.f.q, true);
                                return;
                            }
                            AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                            int adStyle = this.b.a.a.getAdStyle();
                            if (adStyle == 10000 || adStyle == d.c(adTemplate)) {
                                com.kwad.components.core.j.kwai.a.a(this.b, adBitResultData, true);
                            } else {
                                com.kwad.components.core.j.kwai.a.a(this.b, f.j.p, f.j.q, true);
                            }
                        } catch (Exception e) {
                            com.kwad.components.core.j.kwai.a aVar2 = this.b;
                            f fVar = f.e;
                            com.kwad.components.core.j.kwai.a.a(aVar2, fVar.p, fVar.q, true);
                            com.kwad.sdk.core.d.b.b(e);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String b(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ksScene)) == null) {
            com.kwad.components.ad.kwai.a aVar = (com.kwad.components.ad.kwai.a) a(new com.kwad.sdk.d.b<com.kwad.components.ad.kwai.a>(new a.C0512a().a(new com.kwad.components.core.j.kwai.b(ksScene)).a(new com.kwad.components.core.j.c()).a()) { // from class: com.kwad.components.ad.adbit.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.a a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = r6;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.d.b
                /* renamed from: b */
                public com.kwad.components.ad.kwai.a a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new com.kwad.components.ad.kwai.a(this.a) : (com.kwad.components.ad.kwai.a) invokeV.objValue;
                }
            });
            return new a(aVar.getBody(), aVar.getHeader()).a();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> b(AdBitResultData adBitResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, adBitResultData)) == null) {
            ArrayList arrayList = new ArrayList();
            for (AdBid adBid : adBitResultData.adBidList) {
                if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                    arrayList.add(adBid.materialId);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        InterceptResult invokeLL;
        AdTemplate a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, adBitResultData, adBitResultData2)) == null) {
            ArrayList arrayList = new ArrayList();
            for (AdBid adBid : adBitResultData.adBidList) {
                if (adBid != null && adBid.bidEcpm > 0) {
                    long j = adBid.creativeId;
                    if (j > 0 && (a = a(adBitResultData2, j)) != null) {
                        a.mBidEcpm = adBid.bidEcpm;
                        arrayList.add(a);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

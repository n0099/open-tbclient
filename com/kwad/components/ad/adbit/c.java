package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.k.kwai.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T extends com.kwad.components.core.k.a> T a(com.kwad.sdk.d.b<T> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bVar)) == null) ? bVar.get() : (T) invokeL.objValue;
    }

    @Nullable
    public static AdTemplate a(AdBitResultData adBitResultData, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, adBitResultData, j)) == null) {
            for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
                if (adTemplate != null && j == d.ca(adTemplate)) {
                    return adTemplate;
                }
            }
            return null;
        }
        return (AdTemplate) invokeLJ.objValue;
    }

    public static List<String> a(AdBitResultData adBitResultData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adBitResultData)) == null) {
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

    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        InterceptResult invokeLL;
        AdTemplate a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, adBitResultData, adBitResultData2)) == null) {
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

    public static void a(String str, @NonNull com.kwad.components.core.k.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData = new AdBitResultData(aVar.EI.HS);
                adBitResultData.parseJson(jSONObject);
                List<String> a = a(adBitResultData);
                if (a.isEmpty()) {
                    com.kwad.components.core.k.kwai.a.a(aVar, f.Yd.errorCode, f.Yd.Qd, false);
                } else {
                    a(a, adBitResultData, aVar);
                }
            } catch (Exception e) {
                f fVar = f.Yc;
                com.kwad.components.core.k.kwai.a.a(aVar, fVar.errorCode, fVar.Qd, false);
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
        }
    }

    public static void a(List<String> list, AdBitResultData adBitResultData, com.kwad.components.core.k.kwai.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, list, adBitResultData, aVar) == null) {
            new m<com.kwad.components.ad.kwai.b, AdBitResultData>(aVar, adBitResultData, list) { // from class: com.kwad.components.ad.adbit.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;
                public final /* synthetic */ AdBitResultData aD;
                public final /* synthetic */ List aE;

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
                    this.aB = aVar;
                    this.aD = adBitResultData;
                    this.aE = list;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: af */
                public com.kwad.components.ad.kwai.b createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new com.kwad.components.ad.kwai.b(this.aD.adxId, this.aE) : (com.kwad.components.ad.kwai.b) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.m
                @NonNull
                /* renamed from: s */
                public AdBitResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdBitResultData adBitResultData2 = new AdBitResultData(this.aB.EI.HS);
                        adBitResultData2.parseJson(jSONObject);
                        return adBitResultData2;
                    }
                    return (AdBitResultData) invokeL.objValue;
                }
            }.request(new n<com.kwad.components.ad.kwai.b, AdBitResultData>(adBitResultData, aVar) { // from class: com.kwad.components.ad.adbit.c.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;
                public final /* synthetic */ AdBitResultData aD;

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
                    this.aD = adBitResultData;
                    this.aB = aVar;
                }

                private void b(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65537, this, i, str) == null) {
                        com.kwad.components.core.k.kwai.a.a(this.aB, i, str, false);
                    }
                }

                private void c(@NonNull AdBitResultData adBitResultData2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, adBitResultData2) == null) {
                        adBitResultData2.setAdTemplateList(c.a(this.aD, adBitResultData2));
                        if (adBitResultData2.isAdResultDataEmpty()) {
                            com.kwad.components.core.k.kwai.a aVar2 = this.aB;
                            f fVar = f.Yd;
                            com.kwad.components.core.k.kwai.a.a(aVar2, fVar.errorCode, fVar.Qd, false);
                            return;
                        }
                        AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                        int i = this.aB.EI.HS.adStyle;
                        if (i == 10000 || i == d.bK(adTemplate)) {
                            com.kwad.components.core.k.kwai.a.a(this.aB, adBitResultData2, false);
                            return;
                        }
                        com.kwad.components.core.k.kwai.a aVar3 = this.aB;
                        f fVar2 = f.Yh;
                        com.kwad.components.core.k.kwai.a.a(aVar3, fVar2.errorCode, fVar2.Qd, false);
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull g gVar, int i, String str) {
                    b(i, str);
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                    c((AdBitResultData) baseResultData);
                }
            });
        }
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        InterceptResult invokeL;
        AdTemplate a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, adBitResultData)) == null) {
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

    public static boolean b(@NonNull com.kwad.components.core.k.kwai.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVar)) == null) {
            String bidResponseV2 = aVar.EI.HS.getBidResponseV2();
            if (!TextUtils.isEmpty(bidResponseV2)) {
                a(bidResponseV2, aVar);
                return true;
            }
            com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
            String bidResponse = aVar.EI.HS.getBidResponse();
            if (TextUtils.isEmpty(bidResponse)) {
                return false;
            }
            com.kwad.sdk.core.threads.b.vn().submit(new Runnable(bidResponse, aVar) { // from class: com.kwad.components.ad.adbit.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;
                public final /* synthetic */ String aC;

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
                    this.aC = bidResponse;
                    this.aB = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(this.aC);
                            AdBitResultData adBitResultData = new AdBitResultData(this.aB.EI.HS);
                            adBitResultData.parseJson(jSONObject);
                            adBitResultData.setAdTemplateList(c.b(adBitResultData));
                            if (adBitResultData.isAdResultDataEmpty()) {
                                com.kwad.components.core.k.kwai.a.a(this.aB, f.Yd.errorCode, f.Yd.Qd, true);
                                return;
                            }
                            AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                            int adStyle = this.aB.EI.HS.getAdStyle();
                            if (adStyle == 10000 || adStyle == d.bK(adTemplate)) {
                                com.kwad.components.core.k.kwai.a.a(this.aB, adBitResultData, true);
                            } else {
                                com.kwad.components.core.k.kwai.a.a(this.aB, f.Yh.errorCode, f.Yh.Qd, true);
                            }
                        } catch (Exception e) {
                            com.kwad.components.core.k.kwai.a aVar2 = this.aB;
                            f fVar = f.Yc;
                            com.kwad.components.core.k.kwai.a.a(aVar2, fVar.errorCode, fVar.Qd, true);
                            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String getBidRequestToken(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, ksScene)) == null) {
            b bVar = (b) a(new com.kwad.sdk.d.b<b>(new a.C0357a().c(new com.kwad.components.core.k.kwai.b(ksScene)).a(new com.kwad.components.core.k.c()).oo()) { // from class: com.kwad.components.ad.adbit.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

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
                    this.aB = r6;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.d.b
                /* renamed from: ad */
                public b get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new b(this.aB) : (b) invokeV.objValue;
                }
            });
            return new a(bVar.getBody(), bVar.getHeader()).ac();
        }
        return (String) invokeL.objValue;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, ksScene)) == null) {
            com.kwad.components.ad.kwai.a aVar = (com.kwad.components.ad.kwai.a) a(new com.kwad.sdk.d.b<com.kwad.components.ad.kwai.a>(new a.C0357a().c(new com.kwad.components.core.k.kwai.b(ksScene)).a(new com.kwad.components.core.k.c()).oo()) { // from class: com.kwad.components.ad.adbit.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.k.kwai.a aB;

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
                    this.aB = r6;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.d.b
                /* renamed from: ae */
                public com.kwad.components.ad.kwai.a get() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new com.kwad.components.ad.kwai.a(this.aB) : (com.kwad.components.ad.kwai.a) invokeV.objValue;
                }
            });
            return new a(aVar.getBody(), aVar.getHeader()).ac();
        }
        return (String) invokeL.objValue;
    }
}

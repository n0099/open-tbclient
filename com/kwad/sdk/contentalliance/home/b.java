package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.g.a.j;
import com.kwad.sdk.core.g.e;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.g.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f35081a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-113361233, "Lcom/kwad/sdk/contentalliance/home/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-113361233, "Lcom/kwad/sdk/contentalliance/home/b;");
                return;
            }
        }
        f35081a = new AtomicBoolean(false);
    }

    @Nullable
    public static com.kwai.video.ksvodplayerkit.d.b a(AdTemplate adTemplate, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, adTemplate, i2)) == null) {
            if (adTemplate != null) {
                String l = com.kwad.sdk.core.response.b.c.l(adTemplate);
                if (ag.a(l)) {
                    return null;
                }
                return new com.kwai.video.ksvodplayerkit.d.f(l, String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)), i2);
            }
            return null;
        }
        return (com.kwai.video.ksvodplayerkit.d.b) invokeLI.objValue;
    }

    public static void a(List<KsScene> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || list == null || list.isEmpty() || f35081a.get()) {
            return;
        }
        f35081a.set(true);
        h.a aVar = new h.a();
        for (KsScene ksScene : list) {
            aVar.f36273a.add(new com.kwad.sdk.core.g.a.f(ksScene));
        }
        aVar.f36274b = new com.kwad.sdk.core.g.a.c();
        aVar.f36276d = new j(1);
        i.a(aVar, new e.a() { // from class: com.kwad.sdk.contentalliance.home.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    com.kwad.sdk.core.d.a.a("ContentPreloadManager", "PhotoRequestManager onError msg=" + str);
                }
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adResultData) == null) {
                    com.kwad.sdk.core.d.a.a("ContentPreloadManager", "PhotoRequestManager onSuccess");
                    if (adResultData.result != 1) {
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36360c;
                        a(fVar.k, fVar.l);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    HashMap hashMap = new HashMap();
                    for (AdTemplate adTemplate : adResultData.adTemplateList) {
                        if (adTemplate != null) {
                            arrayList.add(adTemplate);
                            if (!hashMap.containsKey(Long.valueOf(adTemplate.posId))) {
                                com.kwad.sdk.core.d.a.a("ContentPreloadManager", "posId = " + adTemplate.posId + " getAuthorName = " + com.kwad.sdk.core.response.b.c.v(adTemplate));
                                hashMap.put(Long.valueOf(adTemplate.posId), adTemplate);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f36360c;
                        a(fVar2.k, fVar2.l);
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ContentPreloadManager", "save");
                    a.a().b();
                    a.a().a(arrayList);
                    com.kwad.sdk.core.report.e.a(arrayList);
                    b.b(hashMap);
                }
            }
        });
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.p() && com.kwad.sdk.core.config.c.ag() && b() && com.kwad.sdk.core.video.a.d.p() : invokeV.booleanValue;
    }

    public static void b(@NonNull Map<Long, AdTemplate> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, map) == null) && a()) {
            c(map);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (com.kwad.sdk.core.config.c.ah() != 1) {
                return com.kwad.sdk.core.config.c.ah() == 2 && com.ksad.download.d.b.b(KsAdSDKImpl.get().getContext());
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void c(@NonNull Map<Long, AdTemplate> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, map) == null) {
            int i2 = 0;
            for (Long l : map.keySet()) {
                AdTemplate adTemplate = map.get(l);
                int i3 = i2 + 1;
                com.kwai.video.ksvodplayerkit.d.b a2 = a(adTemplate, 1000 - i2);
                if (a2 != null) {
                    com.kwai.video.ksvodplayerkit.d.c.a().a(a2);
                    com.kwad.sdk.core.d.a.a("ContentPreloadManager", "addPreloadTask " + com.kwad.sdk.core.response.b.c.v(adTemplate) + " key=" + l);
                }
                m.a(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.b.c.m(adTemplate).a());
                i2 = i3;
            }
        }
    }
}

package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.related.RelatedVideoDetailParam;
import com.kwad.sdk.core.g.l;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35061c;

    /* renamed from: d  reason: collision with root package name */
    public RelatedVideoDetailParam f35062d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35063e;

    /* renamed from: f  reason: collision with root package name */
    public int f35064f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35065g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> f35066h;

    public h(SceneImpl sceneImpl, RelatedVideoDetailParam relatedVideoDetailParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, relatedVideoDetailParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35063e = false;
        this.f35061c = sceneImpl;
        this.f35062d = relatedVideoDetailParam;
        this.f35065g = true;
    }

    public static /* synthetic */ int b(h hVar) {
        int i2 = hVar.f35064f;
        hVar.f35064f = i2 + 1;
        return i2;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.f35065g : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f35063e) {
            return;
        }
        this.f35063e = true;
        a(z, z2, i2, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f35005b.post(new Runnable(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35067a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f35068b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35068b = this;
                    this.f35067a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f35067a) {
                            this.f35068b.f35004a.clear();
                        }
                        if (this.f35068b.f35004a.isEmpty()) {
                            m.e();
                        }
                        this.f35068b.f35004a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                        com.kwad.sdk.contentalliance.home.c.c();
                        this.f35068b.a(this.f35067a, 0);
                        this.f35068b.f35063e = false;
                    }
                }
            });
        } else if (!e()) {
            this.f35005b.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.a.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f35069a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35069a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        h hVar = this.f35069a;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36364g;
                        hVar.a(fVar.k, fVar.l);
                        this.f35069a.f35063e = false;
                    }
                }
            });
        } else {
            l.a aVar = new l.a();
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f35061c);
            fVar.f36139b = this.f35061c.getPageScene();
            aVar.f36298a = fVar;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f36126d = this.f35064f;
            aVar.f36299b = cVar;
            aVar.f36300c = this.f35062d.mSourcePhotoId;
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>(this, aVar) { // from class: com.kwad.sdk.contentalliance.home.a.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l.a f35070a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f35071b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35071b = this;
                    this.f35070a = aVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public AdResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.f35071b.f35061c);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public com.kwad.sdk.core.network.g b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new l(this.f35070a) : (com.kwad.sdk.core.network.g) invokeV.objValue;
                }
            };
            this.f35066h = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.h.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35072a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ h f35073b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35073b = this;
                    this.f35072a = z;
                }

                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, gVar, i3, str) == null) {
                        this.f35073b.f35005b.post(new Runnable(this, i3, str) { // from class: com.kwad.sdk.contentalliance.home.a.h.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f35076a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f35077b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f35078c;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i3), str};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f35078c = this;
                                this.f35076a = i3;
                                this.f35077b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (com.kwad.sdk.core.network.f.f36364g.k == this.f35076a) {
                                        this.f35078c.f35073b.f35065g = false;
                                    }
                                    this.f35078c.f35073b.a(this.f35076a, this.f35077b);
                                    this.f35078c.f35073b.f35063e = false;
                                }
                            }
                        });
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, adResultData) == null) {
                        this.f35073b.f35005b.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.contentalliance.home.a.h.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f35074a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f35075b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, adResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f35075b = this;
                                this.f35074a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass4 anonymousClass4 = this.f35075b;
                                    if (anonymousClass4.f35072a) {
                                        anonymousClass4.f35073b.f35004a.clear();
                                    }
                                    if (this.f35075b.f35073b.f35004a.isEmpty()) {
                                        m.e();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    for (AdTemplate adTemplate : this.f35074a.adTemplateList) {
                                        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                            arrayList.add(adTemplate);
                                        }
                                    }
                                    this.f35075b.f35073b.f35004a.addAll(arrayList);
                                    AnonymousClass4 anonymousClass42 = this.f35075b;
                                    anonymousClass42.f35073b.a(anonymousClass42.f35072a, 0);
                                    this.f35075b.f35073b.f35063e = false;
                                    h.b(this.f35075b.f35073b);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = this.f35066h;
            if (iVar != null) {
                iVar.e();
            }
            this.f35063e = false;
        }
    }
}

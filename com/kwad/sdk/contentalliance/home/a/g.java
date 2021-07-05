package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.profile.tabvideo.detail.ProfileVideoDetailParam;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final ProfileVideoDetailParam f35043c;

    /* renamed from: d  reason: collision with root package name */
    public SceneImpl f35044d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f35045e;

    /* renamed from: f  reason: collision with root package name */
    public int f35046f;

    /* renamed from: g  reason: collision with root package name */
    public String f35047g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> f35048h;

    public g(SceneImpl sceneImpl, ProfileVideoDetailParam profileVideoDetailParam) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, profileVideoDetailParam};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35045e = false;
        this.f35044d = sceneImpl;
        this.f35043c = profileVideoDetailParam;
    }

    public static /* synthetic */ int a(g gVar) {
        int i2 = gVar.f35046f;
        gVar.f35046f = i2 + 1;
        return i2;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f35045e) {
            return;
        }
        this.f35045e = true;
        a(z, z2, i2, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f35005b.post(new Runnable(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.g.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35049a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f35050b;

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
                    this.f35050b = this;
                    this.f35049a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f35049a) {
                            this.f35050b.f35004a.clear();
                        }
                        this.f35050b.f35004a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                        if (!this.f35050b.f35004a.isEmpty()) {
                            g gVar = this.f35050b;
                            List<AdTemplate> list = gVar.f35004a;
                            gVar.f35047g = list.get(list.size() - 1).mPcursor;
                        }
                        com.kwad.sdk.contentalliance.home.c.c();
                        this.f35050b.a(this.f35049a, 0);
                        this.f35050b.f35045e = false;
                    }
                }
            });
        } else if (!e()) {
            this.f35005b.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ g f35051a;

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
                    this.f35051a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        g gVar = this.f35051a;
                        com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f36364g;
                        gVar.a(fVar.k, fVar.l);
                        this.f35051a.f35045e = false;
                    }
                }
            });
        } else {
            p.a aVar = new p.a();
            aVar.f36324e = this.f35047g;
            com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f35044d);
            fVar.f36139b = this.f35044d.getPageScene();
            aVar.f36320a = fVar;
            ProfileVideoDetailParam profileVideoDetailParam = this.f35043c;
            aVar.f36322c = profileVideoDetailParam.mAuthorId;
            aVar.f36323d = profileVideoDetailParam.mTabId;
            com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
            cVar.f36126d = this.f35046f;
            aVar.f36321b = cVar;
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData>(this, aVar) { // from class: com.kwad.sdk.contentalliance.home.a.g.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p.a f35052a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f35053b;

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
                    this.f35053b = this;
                    this.f35052a = aVar;
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
                        AdResultData adResultData = new AdResultData(this.f35052a.f36320a.f36138a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: c */
                public p b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? new p(this.f35052a) : (p) invokeV.objValue;
                }
            };
            this.f35048h = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, AdResultData>(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.g.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35054a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ g f35055b;

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
                    this.f35055b = this;
                    this.f35054a = z;
                }

                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, gVar, i3, str) == null) {
                        this.f35055b.f35005b.post(new Runnable(this, i3, str) { // from class: com.kwad.sdk.contentalliance.home.a.g.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f35058a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f35059b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f35060c;

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
                                this.f35060c = this;
                                this.f35058a = i3;
                                this.f35059b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f35060c.f35055b.a(this.f35058a, this.f35059b);
                                    this.f35060c.f35055b.f35045e = false;
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
                        this.f35055b.f35005b.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.contentalliance.home.a.g.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AdResultData f35056a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f35057b;

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
                                this.f35057b = this;
                                this.f35056a = adResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass4 anonymousClass4 = this.f35057b;
                                    if (anonymousClass4.f35054a) {
                                        anonymousClass4.f35055b.f35004a.clear();
                                    }
                                    if (this.f35057b.f35055b.f35004a.isEmpty()) {
                                        m.e();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    for (AdTemplate adTemplate : this.f35056a.adTemplateList) {
                                        if (com.kwad.sdk.core.response.b.c.b(adTemplate)) {
                                            arrayList.add(adTemplate);
                                        }
                                    }
                                    this.f35057b.f35055b.f35004a.addAll(arrayList);
                                    this.f35057b.f35055b.f35047g = this.f35056a.pcursor;
                                    AnonymousClass4 anonymousClass42 = this.f35057b;
                                    anonymousClass42.f35055b.a(anonymousClass42.f35054a, 0);
                                    this.f35057b.f35055b.f35045e = false;
                                    g.a(this.f35057b.f35055b);
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
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, AdResultData> iVar = this.f35048h;
            if (iVar != null) {
                iVar.e();
            }
            this.f35045e = false;
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !"0".equals(this.f35047g) : invokeV.booleanValue;
    }
}

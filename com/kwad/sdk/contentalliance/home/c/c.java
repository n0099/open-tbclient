package com.kwad.sdk.contentalliance.home.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.g.p;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.home.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35199c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35200d;

    /* renamed from: e  reason: collision with root package name */
    public String f35201e;

    /* renamed from: f  reason: collision with root package name */
    public i<g, AdResultData> f35202f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f35203g;

    public c(SceneImpl sceneImpl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35203g = false;
        this.f35199c = sceneImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, list) == null) {
            long k = d.k(this.f35200d.photoInfo);
            Iterator<AdTemplate> it = list.iterator();
            while (it.hasNext()) {
                AdTemplate next = it.next();
                if (k == d.k(next.photoInfo)) {
                    if (this.f35004a.contains(this.f35200d)) {
                        it.remove();
                    } else {
                        list.set(list.indexOf(next), this.f35200d);
                    }
                }
                next.mIsLeftSlipStatus = 1;
            }
            this.f35004a.addAll(list);
            if (this.f35004a.contains(this.f35200d)) {
                return;
            }
            if (this.f35004a.size() <= 3) {
                this.f35004a.add(this.f35200d);
            } else {
                this.f35004a.add(2, this.f35200d);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f35203g) {
            return;
        }
        this.f35203g = true;
        if (!e()) {
            this.f35005b.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.c.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f35204a;

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
                    this.f35204a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        c cVar = this.f35204a;
                        f fVar = f.f36364g;
                        cVar.a(fVar.k, fVar.l);
                        this.f35204a.f35203g = false;
                    }
                }
            });
            return;
        }
        a(z, z2, i2, 0);
        p.a aVar = new p.a();
        aVar.f36324e = this.f35201e;
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f35199c);
        fVar.f36139b = this.f35199c.getPageScene();
        aVar.f36320a = fVar;
        aVar.f36322c = d.o(this.f35200d.photoInfo);
        aVar.f36321b = new com.kwad.sdk.core.g.a.c();
        i<g, AdResultData> iVar = new i<g, AdResultData>(this, aVar) { // from class: com.kwad.sdk.contentalliance.home.c.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ p.a f35205a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f35206b;

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
                this.f35206b = this;
                this.f35205a = aVar;
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
                    AdResultData adResultData = new AdResultData(this.f35206b.f35199c);
                    adResultData.parseJson(jSONObject);
                    return adResultData;
                }
                return (AdResultData) invokeL.objValue;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public g b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new p(this.f35205a) : (g) invokeV.objValue;
            }
        };
        this.f35202f = iVar;
        iVar.a(new j<g, AdResultData>(this, z) { // from class: com.kwad.sdk.contentalliance.home.c.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f35207a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f35208b;

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
                this.f35208b = this;
                this.f35207a = z;
            }

            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, int i3, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, gVar, i3, str) == null) {
                    if ((f.f36358a.k != i3 && (!this.f35208b.f35004a.isEmpty() || f.f36360c.k != i3)) || this.f35208b.f35004a.contains(this.f35208b.f35200d)) {
                        this.f35208b.f35005b.post(new Runnable(this, i3, str) { // from class: com.kwad.sdk.contentalliance.home.c.c.3.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f35212a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f35213b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass3 f35214c;

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
                                this.f35214c = this;
                                this.f35212a = i3;
                                this.f35213b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f35214c.f35208b.a(this.f35212a, this.f35213b);
                                    this.f35214c.f35208b.f35203g = false;
                                }
                            }
                        });
                        return;
                    }
                    this.f35208b.f35004a.add(this.f35208b.f35200d);
                    this.f35208b.f35005b.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.c.c.3.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f35211a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35211a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass3 anonymousClass3 = this.f35211a;
                                anonymousClass3.f35208b.a(anonymousClass3.f35207a, 0);
                                this.f35211a.f35208b.f35203g = false;
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull g gVar, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, adResultData) == null) {
                    this.f35208b.f35005b.post(new Runnable(this, adResultData) { // from class: com.kwad.sdk.contentalliance.home.c.c.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdResultData f35209a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f35210b;

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
                            this.f35210b = this;
                            this.f35209a = adResultData;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                AnonymousClass3 anonymousClass3 = this.f35210b;
                                if (anonymousClass3.f35207a) {
                                    anonymousClass3.f35208b.f35004a.clear();
                                }
                                if (this.f35210b.f35208b.f35004a.isEmpty()) {
                                    m.e();
                                }
                                this.f35210b.f35208b.f35201e = this.f35209a.pcursor;
                                this.f35210b.f35208b.a(this.f35209a.adTemplateList);
                                AnonymousClass3 anonymousClass32 = this.f35210b;
                                anonymousClass32.f35208b.a(anonymousClass32.f35207a, 0);
                                this.f35210b.f35208b.f35203g = false;
                            }
                        }
                    });
                }
            }
        });
    }

    public void b(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f35200d = adTemplate;
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f35203g = false;
            i<g, AdResultData> iVar = this.f35202f;
            if (iVar != null) {
                iVar.e();
            }
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !"0".equals(this.f35201e) : invokeV.booleanValue;
    }
}

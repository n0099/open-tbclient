package com.kwad.sdk.contentalliance.home.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35007c;

    /* renamed from: d  reason: collision with root package name */
    public int f35008d;

    /* renamed from: e  reason: collision with root package name */
    public int f35009e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35010f;

    /* renamed from: g  reason: collision with root package name */
    public String f35011g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35012h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f35013i;
    public int j;
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> k;

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
        this.f35010f = false;
        this.f35012h = true;
        this.f35007c = sceneImpl;
        this.f35013i = new Handler(Looper.getMainLooper());
    }

    private boolean a(SceneImpl sceneImpl) {
        InterceptResult invokeL;
        List<AdTemplate> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, this, sceneImpl)) == null) {
            long posId = sceneImpl.getPosId();
            com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "preload usePreloadContentData posId=" + posId);
            com.kwad.sdk.contentalliance.home.a a3 = com.kwad.sdk.contentalliance.home.a.a();
            if (a3.c(posId) || (a2 = a3.a(posId)) == null || a2.isEmpty()) {
                return false;
            }
            for (AdTemplate adTemplate : a2) {
                SceneImpl sceneImpl2 = adTemplate.mAdScene;
                if (sceneImpl2 != null) {
                    sceneImpl2.entryScene = sceneImpl.entryScene;
                    sceneImpl2.setUrlPackage(sceneImpl.getUrlPackage());
                }
            }
            com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "usePreloadContentData cache item list size=" + a2.size());
            this.f35004a.addAll(a2);
            a3.b(posId);
            a(false, this.f35008d);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static /* synthetic */ int b(c cVar) {
        int i2 = cVar.f35008d;
        cVar.f35008d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(c cVar) {
        int i2 = cVar.j;
        cVar.j = i2 + 1;
        return i2;
    }

    public void a(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null) {
                str2 = Uri.parse(str).getQueryParameter("push");
                if (str2 != null) {
                    try {
                        str2 = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                str2 = "";
            }
            this.f35011g = str2;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.f35009e = z ? 1 : 0;
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f35010f) {
            return;
        }
        int i3 = 1;
        this.f35010f = true;
        com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "loadData isRefresh=" + z);
        a(z, z2, i2, this.f35008d);
        if (!this.f35012h) {
            this.f35011g = null;
        }
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f35013i.post(new Runnable(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35014a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f35015b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f35015b = this;
                    this.f35014a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f35014a) {
                            this.f35015b.f35004a.clear();
                            this.f35015b.f35008d = 0;
                        }
                        if (this.f35015b.f35004a.isEmpty()) {
                            m.e();
                        }
                        this.f35015b.f35004a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                        com.kwad.sdk.contentalliance.home.c.c();
                        c cVar = this.f35015b;
                        cVar.a(this.f35014a, cVar.f35008d);
                        c.b(this.f35015b);
                        this.f35015b.f35010f = false;
                    }
                }
            });
            return;
        }
        int i4 = 0;
        if (!TextUtils.isEmpty(this.f35011g) || z || z2 || !this.f35004a.isEmpty()) {
            z3 = false;
        } else {
            z3 = a(this.f35007c);
            if (z3) {
                m.e();
            }
        }
        h.a aVar = new h.a();
        com.kwad.sdk.core.g.a.f fVar = new com.kwad.sdk.core.g.a.f(this.f35007c);
        fVar.f36139b = this.f35007c.getPageScene();
        fVar.f36140c = 100L;
        aVar.f36273a.add(fVar);
        if (i2 == 0) {
            i3 = 3;
        } else if (i2 == 1) {
            com.kwad.sdk.core.report.e.b(this.f35007c, 1);
            i4 = 1;
        } else if (i2 == 2) {
            com.kwad.sdk.core.report.e.b(this.f35007c, 2);
            i4 = 2;
        } else if (i2 != 3) {
            i3 = i2 != 4 ? 0 : 2;
        } else {
            com.kwad.sdk.core.report.e.b(this.f35007c, 3);
            i4 = 3;
        }
        com.kwad.sdk.core.g.a.c cVar = new com.kwad.sdk.core.g.a.c();
        cVar.f36125c = i3;
        cVar.f36124b = this.f35009e;
        cVar.f36126d = this.j;
        aVar.f36274b = cVar;
        aVar.f36275c = this.f35011g;
        if (z3) {
            aVar.f36276d = new com.kwad.sdk.core.g.a.j(this.f35004a);
        }
        com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData>(this, aVar) { // from class: com.kwad.sdk.contentalliance.home.a.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h.a f35016a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f35017b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35017b = this;
                this.f35016a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.g.h b() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new com.kwad.sdk.core.g.h(this.f35016a) : (com.kwad.sdk.core.g.h) invokeV.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    JSONObject jSONObject = new JSONObject(str);
                    ArrayList arrayList = new ArrayList();
                    for (com.kwad.sdk.core.g.a.f fVar2 : this.f35016a.f36273a) {
                        arrayList.add(fVar2.f36138a);
                    }
                    AdResultData adResultData = new AdResultData(arrayList);
                    adResultData.parseJson(jSONObject);
                    return adResultData;
                }
                return (AdResultData) invokeL.objValue;
            }
        };
        this.k = iVar;
        iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.h, AdResultData>(this, i4, z) { // from class: com.kwad.sdk.contentalliance.home.a.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f35018a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f35019b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ c f35020c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i4), Boolean.valueOf(z)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35020c = this;
                this.f35018a = i4;
                this.f35019b = z;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, int i5, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, hVar, i5, str) == null) {
                    this.f35020c.f35013i.post(new Runnable(this, str, i5) { // from class: com.kwad.sdk.contentalliance.home.a.c.3.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f35023a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ int f35024b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f35025c;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, str, Integer.valueOf(i5)};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35025c = this;
                            this.f35023a = str;
                            this.f35024b = i5;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onError msg:" + this.f35023a);
                                this.f35025c.f35020c.a(this.f35024b, this.f35023a);
                                this.f35025c.f35020c.f35010f = false;
                            }
                        }
                    });
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.h hVar, @NonNull AdResultData adResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, adResultData) == null) {
                    ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.adTemplateList) {
                        if (adTemplate != null) {
                            adTemplate.mPhotoResponseType = this.f35018a;
                            arrayList.add(adTemplate);
                        }
                    }
                    this.f35020c.f35013i.post(new Runnable(this, arrayList) { // from class: com.kwad.sdk.contentalliance.home.a.c.3.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f35021a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass3 f35022b;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i5 = newInitContext.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35022b = this;
                            this.f35021a = arrayList;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f35022b.f35020c.f35012h = false;
                                AnonymousClass3 anonymousClass3 = this.f35022b;
                                if (anonymousClass3.f35019b) {
                                    anonymousClass3.f35020c.f35008d = 0;
                                    this.f35022b.f35020c.f35004a.clear();
                                }
                                if (this.f35022b.f35020c.f35004a.isEmpty()) {
                                    m.e();
                                }
                                this.f35022b.f35020c.f35004a.addAll(this.f35021a);
                                AnonymousClass3 anonymousClass32 = this.f35022b;
                                c cVar2 = anonymousClass32.f35020c;
                                cVar2.a(anonymousClass32.f35019b, cVar2.f35008d);
                                com.kwad.sdk.core.d.a.a("DataFetcherContentImpl", "onContentAllianceLoad mTemplateList:" + this.f35022b.f35020c.f35004a.size());
                                this.f35022b.f35020c.f35010f = false;
                                c.b(this.f35022b.f35020c);
                                c.c(this.f35022b.f35020c);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a, com.kwad.sdk.contentalliance.home.a.b
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.h, AdResultData> iVar = this.k;
            if (iVar != null) {
                iVar.e();
            }
            this.f35010f = false;
        }
    }
}

package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.report.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfoResultData;
import com.kwad.sdk.utils.ag;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35026c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35027d;

    /* renamed from: e  reason: collision with root package name */
    public SceneImpl f35028e;

    /* renamed from: f  reason: collision with root package name */
    public String f35029f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> f35030g;

    public f(SceneImpl sceneImpl, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sceneImpl, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35027d = false;
        this.f35028e = sceneImpl;
        this.f35026c = z;
    }

    private boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? !"no_more".equals(this.f35029f) : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.a
    public void a(boolean z, boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) || this.f35027d) {
            return;
        }
        this.f35027d = true;
        a(z, z2, i2, 0);
        if (com.kwad.sdk.contentalliance.home.c.a()) {
            this.f35005b.post(new Runnable(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35031a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f35032b;

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
                    this.f35032b = this;
                    this.f35031a = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35032b.f35004a.clear();
                        m.e();
                        this.f35032b.f35004a.addAll(com.kwad.sdk.contentalliance.home.c.b());
                        if (!this.f35032b.f35004a.isEmpty()) {
                            f fVar = this.f35032b;
                            List<AdTemplate> list = fVar.f35004a;
                            fVar.f35029f = list.get(list.size() - 1).mLiveInfo.pcursor;
                        }
                        com.kwad.sdk.contentalliance.home.c.c();
                        this.f35032b.a(this.f35031a, 0);
                        this.f35032b.f35027d = false;
                    }
                }
            });
        } else if (!this.f35026c) {
            this.f35005b.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.a.f.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f35042a;

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
                    this.f35042a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f fVar = this.f35042a;
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f36364g;
                        fVar.a(fVar2.k, fVar2.l);
                        this.f35042a.f35027d = false;
                    }
                }
            });
        } else if (!e()) {
            this.f35005b.post(new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.a.f.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f35033a;

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
                    this.f35033a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        f fVar = this.f35033a;
                        com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f36364g;
                        fVar.a(fVar2.k, fVar2.l);
                        this.f35033a.f35027d = false;
                    }
                }
            });
        } else {
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> iVar = new com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData>(this) { // from class: com.kwad.sdk.contentalliance.home.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f35034a;

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
                    this.f35034a = this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.i
                @NonNull
                /* renamed from: a */
                public LiveInfoResultData b(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                        LiveInfoResultData liveInfoResultData = new LiveInfoResultData();
                        liveInfoResultData.parseJson(new JSONObject(str));
                        return liveInfoResultData;
                    }
                    return (LiveInfoResultData) invokeL.objValue;
                }

                @Override // com.kwad.sdk.core.network.i
                public boolean a_() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.kwad.sdk.core.network.a
                @NonNull
                public com.kwad.sdk.core.network.g b() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) ? ag.a(this.f35034a.f35029f) ? new com.kwad.sdk.live.a.a() : new com.kwad.sdk.live.a.a(this.f35034a.f35029f) : (com.kwad.sdk.core.network.g) invokeV.objValue;
                }
            };
            this.f35030g = iVar;
            iVar.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.network.g, LiveInfoResultData>(this, z) { // from class: com.kwad.sdk.contentalliance.home.a.f.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f35035a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f35036b;

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
                    this.f35036b = this;
                    this.f35035a = z;
                }

                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, int i3, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, gVar, i3, str) == null) {
                        this.f35036b.f35005b.post(new Runnable(this, i3, str) { // from class: com.kwad.sdk.contentalliance.home.a.f.4.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ int f35039a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ String f35040b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f35041c;

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
                                this.f35041c = this;
                                this.f35039a = i3;
                                this.f35040b = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.f35041c.f35036b.a(this.f35039a, this.f35040b);
                                    this.f35041c.f35036b.f35027d = false;
                                }
                            }
                        });
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
                public void a(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull LiveInfoResultData liveInfoResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, gVar, liveInfoResultData) == null) {
                        this.f35036b.f35005b.post(new Runnable(this, liveInfoResultData) { // from class: com.kwad.sdk.contentalliance.home.a.f.4.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ LiveInfoResultData f35037a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass4 f35038b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, liveInfoResultData};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f35038b = this;
                                this.f35037a = liveInfoResultData;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    AnonymousClass4 anonymousClass4 = this.f35038b;
                                    if (anonymousClass4.f35035a) {
                                        anonymousClass4.f35036b.f35004a.clear();
                                    }
                                    if (this.f35038b.f35036b.f35004a.isEmpty()) {
                                        m.e();
                                    }
                                    this.f35038b.f35036b.f35029f = this.f35037a.pcursor;
                                    f fVar = this.f35038b.f35036b;
                                    fVar.f35004a.addAll(com.kwad.sdk.live.mode.a.a(this.f35037a, fVar.f35028e));
                                    AnonymousClass4 anonymousClass42 = this.f35038b;
                                    anonymousClass42.f35036b.a(anonymousClass42.f35035a, 0);
                                    this.f35038b.f35036b.f35027d = false;
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
            com.kwad.sdk.core.network.i<com.kwad.sdk.core.network.g, LiveInfoResultData> iVar = this.f35030g;
            if (iVar != null) {
                iVar.e();
            }
        }
    }
}

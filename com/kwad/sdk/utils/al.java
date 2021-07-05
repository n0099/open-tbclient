package com.kwad.sdk.utils;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public static volatile al l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f39337a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39338b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f39339c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f39340d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f39341e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f39342f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f39343g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f39344h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f39345i;
    public volatile long j;
    public volatile boolean k;

    public al() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f39337a = false;
        this.f39338b = false;
        this.f39339c = false;
        this.f39340d = false;
        this.f39341e = false;
        this.f39342f = false;
        this.f39343g = 0L;
        this.f39344h = 0L;
        this.f39345i = 0L;
        this.j = -1L;
        this.k = false;
    }

    public static al a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (l == null) {
                synchronized (al.class) {
                    if (l == null) {
                        l = new al();
                    }
                }
            }
            return l;
        }
        return (al) invokeV.objValue;
    }

    private void e(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, this, adTemplate) == null) && this.k && !this.f39338b) {
            this.f39338b = true;
            this.f39344h = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(66L, adTemplate);
            aVar.l = this.f39344h - this.f39343g;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, adTemplate) == null) || !this.k || this.f39339c || this.f39341e) {
            return;
        }
        this.f39339c = true;
        com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(67L, adTemplate);
        aVar.m = System.currentTimeMillis() - this.f39343g;
        aVar.n = this.j;
        com.kwad.sdk.core.report.g.c(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, adTemplate) == null) || !this.k || this.f39340d || this.f39341e) {
            return;
        }
        this.f39340d = true;
        com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(68L, adTemplate);
        aVar.m = System.currentTimeMillis() - this.f39343g;
        aVar.n = this.j;
        aVar.b();
        com.kwad.sdk.core.report.g.c(aVar);
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.j = j;
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.k = com.kwad.sdk.core.config.c.U();
            if (this.k && !this.f39337a) {
                this.f39337a = true;
                this.f39343g = System.currentTimeMillis();
                com.kwad.sdk.core.report.g.c(new com.kwad.sdk.core.report.a(65L, adTemplate));
            }
        }
    }

    public void b(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) && this.k && !this.f39341e) {
            this.f39341e = true;
            this.f39345i = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(69L, adTemplate);
            aVar.l = this.f39345i - this.f39344h;
            aVar.m = this.f39345i - this.f39343g;
            aVar.n = this.j;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39342f : invokeV.booleanValue;
    }

    public void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, adTemplate) == null) && this.k && !this.f39342f) {
            this.f39342f = true;
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.report.a aVar = new com.kwad.sdk.core.report.a(70L, adTemplate);
            aVar.l = currentTimeMillis - this.f39345i;
            aVar.m = currentTimeMillis - this.f39343g;
            aVar.n = this.j;
            com.kwad.sdk.core.report.g.c(aVar);
        }
    }

    public void d(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, adTemplate) == null) && this.k) {
            e(adTemplate);
            ak.a(new Runnable(this, adTemplate) { // from class: com.kwad.sdk.utils.al.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f39346a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ al f39347b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39347b = this;
                    this.f39346a = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39347b.f(this.f39346a);
                    }
                }
            }, null, 1000L);
            ak.a(new Runnable(this, adTemplate) { // from class: com.kwad.sdk.utils.al.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdTemplate f39348a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ al f39349b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, adTemplate};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39349b = this;
                    this.f39348a = adTemplate;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f39349b.g(this.f39348a);
                    }
                }
            }, null, 3000L);
        }
    }
}

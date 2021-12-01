package com.kwad.sdk.reward.presenter.kwai;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.kwai.kwai.a;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.g;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f59182b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f59183c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f59184d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.kwai.kwai.a f59185e;

    /* renamed from: f  reason: collision with root package name */
    public long f59186f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f59187g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59188h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f59189i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f59190j;

    /* renamed from: k  reason: collision with root package name */
    public d f59191k;

    public a() {
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
        this.f59185e = new com.kwad.sdk.contentalliance.detail.kwai.kwai.a();
        this.f59186f = 0L;
        this.f59187g = new Handler(Looper.getMainLooper());
        this.f59188h = true;
        this.f59189i = false;
        this.f59190j = new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.f59185e.c()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.f59185e.e();
                        int a = this.a.f59185e.d().a();
                        ((g) this.a).a.a(elapsedRealtime, this.a.f59185e.d().b(), a);
                    } else if (this.a.f59188h) {
                        ((g) this.a).a.a(5000L, 5000L, 1);
                    }
                    com.kwad.sdk.core.report.d.c(this.a.f59182b);
                }
            }
        };
        this.f59191k = new e(this) { // from class: com.kwad.sdk.reward.presenter.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.a.a(j3);
                    this.a.f59186f = j3;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.a.f59189i = false;
                    com.kwad.sdk.core.report.a.a(this.a.f59182b, ((g) this.a).a.f58872e);
                    com.kwad.sdk.core.report.a.g(this.a.f59182b, ((g) this.a).a.f58872e);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    this.a.f59185e.b();
                    this.a.f59188h = false;
                    if (this.a.f59189i) {
                        return;
                    }
                    this.a.f59189i = true;
                    com.kwad.sdk.core.report.d.a(this.a.f59182b, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.e();
                    this.a.f59185e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    if (!((g) this.a).a.r || !((g) this.a).a.u) {
                        com.kwad.sdk.core.report.a.h(this.a.f59182b, ((g) this.a).a.f58872e);
                    }
                    this.a.f59185e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.g();
                    this.a.f59185e.a();
                    this.a.f59187g.removeCallbacks(this.a.f59190j);
                    this.a.f59187g.postDelayed(this.a.f59190j, 5000L);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.h();
                    this.a.f59185e.a();
                    this.a.f59187g.removeCallbacks(this.a.f59190j);
                    this.a.f59187g.postDelayed(this.a.f59190j, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f59184d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f59184d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f59182b, ceil, ((g) this).a.f58872e);
                    this.f59184d.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((g) this).a.f58874g;
            this.f59182b = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            this.f59183c = j2;
            this.f59184d = com.kwad.sdk.core.response.a.a.S(j2);
            ((g) this).a.f58878k.a(this.f59191k);
            this.f59187g.postDelayed(this.f59190j, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f59187g.removeCallbacksAndMessages(null);
            ((g) this).a.f58878k.b(this.f59191k);
            a.C2010a d2 = this.f59185e.d();
            com.kwad.sdk.core.report.d.a(((g) this).a.f58874g, this.f59186f, d2.b(), d2.a());
        }
    }
}

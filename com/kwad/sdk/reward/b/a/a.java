package com.kwad.sdk.reward.b.a;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.detail.a.a.a;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f73584b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f73585c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f73586d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f73587e;

    /* renamed from: f  reason: collision with root package name */
    public long f73588f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f73589g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73590h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f73591i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f73592j;
    public com.kwad.sdk.contentalliance.detail.video.d k;

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
        this.f73587e = new com.kwad.sdk.contentalliance.detail.a.a.a();
        this.f73588f = 0L;
        this.f73589g = new Handler(Looper.getMainLooper());
        this.f73590h = true;
        this.f73591i = false;
        this.f73592j = new Runnable(this) { // from class: com.kwad.sdk.reward.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f73593a;

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
                this.f73593a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f73593a.f73587e.c()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f73593a.f73587e.e();
                        int a2 = this.f73593a.f73587e.d().a();
                        ((d) this.f73593a).f73909a.a(elapsedRealtime, this.f73593a.f73587e.d().b(), a2);
                    } else if (this.f73593a.f73590h) {
                        ((d) this.f73593a).f73909a.a(5000L, 5000L, 1);
                    }
                    com.kwad.sdk.core.report.d.c(this.f73593a.f73584b);
                }
            }
        };
        this.k = new e(this) { // from class: com.kwad.sdk.reward.b.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f73594a;

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
                this.f73594a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f73594a.a(j3);
                    this.f73594a.f73588f = j3;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.f73594a.f73591i = false;
                    com.kwad.sdk.core.report.a.a(this.f73594a.f73584b, ((d) this.f73594a).f73909a.f73570d);
                    com.kwad.sdk.core.report.a.g(this.f73594a.f73584b, ((d) this.f73594a).f73909a.f73570d);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    this.f73594a.f73587e.b();
                    this.f73594a.f73590h = false;
                    if (this.f73594a.f73591i) {
                        return;
                    }
                    this.f73594a.f73591i = true;
                    com.kwad.sdk.core.report.d.a(this.f73594a.f73584b, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.e();
                    this.f73594a.f73587e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    com.kwad.sdk.core.report.a.h(this.f73594a.f73584b, ((d) this.f73594a).f73909a.f73570d);
                    this.f73594a.f73587e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.g();
                    this.f73594a.f73587e.a();
                    this.f73594a.f73589g.removeCallbacks(this.f73594a.f73592j);
                    this.f73594a.f73589g.postDelayed(this.f73594a.f73592j, 5000L);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.h();
                    this.f73594a.f73587e.a();
                    this.f73594a.f73589g.removeCallbacks(this.f73594a.f73592j);
                    this.f73594a.f73589g.postDelayed(this.f73594a.f73592j, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            int ceil = (int) Math.ceil(((float) j2) / 1000.0f);
            List<Integer> list = this.f73586d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f73586d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f73584b, ceil, ((d) this).f73909a.f73570d);
                    this.f73586d.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((d) this).f73909a.f73572f;
            this.f73584b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f73585c = i2;
            this.f73586d = com.kwad.sdk.core.response.b.a.I(i2);
            ((d) this).f73909a.f73575i.a(this.k);
            this.f73589g.postDelayed(this.f73592j, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f73589g.removeCallbacksAndMessages(null);
            ((d) this).f73909a.f73575i.b(this.k);
            a.C1984a d2 = this.f73587e.d();
            com.kwad.sdk.core.report.d.a(((d) this).f73909a.f73572f, this.f73588f, d2.b(), d2.a());
        }
    }
}

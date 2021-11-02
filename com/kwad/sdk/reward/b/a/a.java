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
/* loaded from: classes2.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f66027b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f66028c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f66029d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f66030e;

    /* renamed from: f  reason: collision with root package name */
    public long f66031f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f66032g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66033h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f66034i;
    public Runnable j;
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
        this.f66030e = new com.kwad.sdk.contentalliance.detail.a.a.a();
        this.f66031f = 0L;
        this.f66032g = new Handler(Looper.getMainLooper());
        this.f66033h = true;
        this.f66034i = false;
        this.j = new Runnable(this) { // from class: com.kwad.sdk.reward.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66035a;

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
                this.f66035a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f66035a.f66030e.c()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f66035a.f66030e.e();
                        int a2 = this.f66035a.f66030e.d().a();
                        ((d) this.f66035a).f66343a.a(elapsedRealtime, this.f66035a.f66030e.d().b(), a2);
                    } else if (this.f66035a.f66033h) {
                        ((d) this.f66035a).f66343a.a(5000L, 5000L, 1);
                    }
                    com.kwad.sdk.core.report.d.c(this.f66035a.f66027b);
                }
            }
        };
        this.k = new e(this) { // from class: com.kwad.sdk.reward.b.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66036a;

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
                this.f66036a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f66036a.a(j2);
                    this.f66036a.f66031f = j2;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.f66036a.f66034i = false;
                    com.kwad.sdk.core.report.a.a(this.f66036a.f66027b, ((d) this.f66036a).f66343a.f66014d);
                    com.kwad.sdk.core.report.a.g(this.f66036a.f66027b, ((d) this.f66036a).f66343a.f66014d);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    this.f66036a.f66030e.b();
                    this.f66036a.f66033h = false;
                    if (this.f66036a.f66034i) {
                        return;
                    }
                    this.f66036a.f66034i = true;
                    com.kwad.sdk.core.report.d.a(this.f66036a.f66027b, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.e();
                    this.f66036a.f66030e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    com.kwad.sdk.core.report.a.h(this.f66036a.f66027b, ((d) this.f66036a).f66343a.f66014d);
                    this.f66036a.f66030e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.g();
                    this.f66036a.f66030e.a();
                    this.f66036a.f66032g.removeCallbacks(this.f66036a.j);
                    this.f66036a.f66032g.postDelayed(this.f66036a.j, 5000L);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.h();
                    this.f66036a.f66030e.a();
                    this.f66036a.f66032g.removeCallbacks(this.f66036a.j);
                    this.f66036a.f66032g.postDelayed(this.f66036a.j, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f66029d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f66029d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f66027b, ceil, ((d) this).f66343a.f66014d);
                    this.f66029d.remove(num);
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
            AdTemplate adTemplate = ((d) this).f66343a.f66016f;
            this.f66027b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f66028c = i2;
            this.f66029d = com.kwad.sdk.core.response.b.a.I(i2);
            ((d) this).f66343a.f66019i.a(this.k);
            this.f66032g.postDelayed(this.j, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f66032g.removeCallbacksAndMessages(null);
            ((d) this).f66343a.f66019i.b(this.k);
            a.C1895a d2 = this.f66030e.d();
            com.kwad.sdk.core.report.d.a(((d) this).f66343a.f66016f, this.f66031f, d2.b(), d2.a());
        }
    }
}

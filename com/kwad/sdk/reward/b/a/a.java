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
/* loaded from: classes6.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f35899b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f35900c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f35901d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f35902e;

    /* renamed from: f  reason: collision with root package name */
    public long f35903f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f35904g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f35905h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f35906i;
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
        this.f35902e = new com.kwad.sdk.contentalliance.detail.a.a.a();
        this.f35903f = 0L;
        this.f35904g = new Handler(Looper.getMainLooper());
        this.f35905h = true;
        this.f35906i = false;
        this.j = new Runnable(this) { // from class: com.kwad.sdk.reward.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35907a;

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
                this.f35907a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f35907a.f35902e.c()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f35907a.f35902e.e();
                        int a2 = this.f35907a.f35902e.d().a();
                        ((d) this.f35907a).f36214a.a(elapsedRealtime, this.f35907a.f35902e.d().b(), a2);
                    } else if (this.f35907a.f35905h) {
                        ((d) this.f35907a).f36214a.a(5000L, 5000L, 1);
                    }
                    com.kwad.sdk.core.report.d.c(this.f35907a.f35899b);
                }
            }
        };
        this.k = new e(this) { // from class: com.kwad.sdk.reward.b.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35908a;

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
                this.f35908a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f35908a.a(j2);
                    this.f35908a.f35903f = j2;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.f35908a.f35906i = false;
                    com.kwad.sdk.core.report.a.a(this.f35908a.f35899b, ((d) this.f35908a).f36214a.f35886d);
                    com.kwad.sdk.core.report.a.g(this.f35908a.f35899b, ((d) this.f35908a).f36214a.f35886d);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    this.f35908a.f35902e.b();
                    this.f35908a.f35905h = false;
                    if (this.f35908a.f35906i) {
                        return;
                    }
                    this.f35908a.f35906i = true;
                    com.kwad.sdk.core.report.d.a(this.f35908a.f35899b, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.e();
                    this.f35908a.f35902e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    com.kwad.sdk.core.report.a.h(this.f35908a.f35899b, ((d) this.f35908a).f36214a.f35886d);
                    this.f35908a.f35902e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.g();
                    this.f35908a.f35902e.a();
                    this.f35908a.f35904g.removeCallbacks(this.f35908a.j);
                    this.f35908a.f35904g.postDelayed(this.f35908a.j, 5000L);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.h();
                    this.f35908a.f35902e.a();
                    this.f35908a.f35904g.removeCallbacks(this.f35908a.j);
                    this.f35908a.f35904g.postDelayed(this.f35908a.j, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f35901d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f35901d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f35899b, ceil, ((d) this).f36214a.f35886d);
                    this.f35901d.remove(num);
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
            AdTemplate adTemplate = ((d) this).f36214a.f35888f;
            this.f35899b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f35900c = i2;
            this.f35901d = com.kwad.sdk.core.response.b.a.I(i2);
            ((d) this).f36214a.f35891i.a(this.k);
            this.f35904g.postDelayed(this.j, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f35904g.removeCallbacksAndMessages(null);
            ((d) this).f36214a.f35891i.b(this.k);
            a.C0407a d2 = this.f35902e.d();
            com.kwad.sdk.core.report.d.a(((d) this).f36214a.f35888f, this.f35903f, d2.b(), d2.a());
        }
    }
}

package com.kwad.components.ad.reward.presenter.kwai;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.model.EcOrderCardStyle;
import com.kwad.components.core.l.c;
import com.kwad.components.core.video.e;
import com.kwad.components.core.video.g;
import com.kwad.components.core.video.h;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes5.dex */
public final class a extends com.kwad.components.ad.reward.presenter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate b;
    public AdInfo c;
    public List<Integer> d;
    public final e e;
    public long f;
    public Handler g;
    public boolean h;
    public volatile boolean i;
    public Runnable j;
    public g k;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new e();
        this.f = 0L;
        this.g = new Handler(Looper.getMainLooper());
        this.h = true;
        this.i = false;
        this.j = new Runnable(this) { // from class: com.kwad.components.ad.reward.presenter.kwai.a.1
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.e.c()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.a.e.e();
                        int a = this.a.e.d().a();
                        ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(elapsedRealtime, this.a.e.d().b(), a);
                    } else if (this.a.h) {
                        ((com.kwad.components.ad.reward.presenter.a) this.a).a.a(5000L, 5000L, 1);
                    }
                    com.kwad.components.core.i.a.a().c(this.a.b);
                }
            }
        };
        this.k = new h(this) { // from class: com.kwad.components.ad.reward.presenter.kwai.a.2
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.a.e.b();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) {
                    super.a(i3, i4);
                    com.kwad.components.ad.reward.monitor.a.a(((com.kwad.components.ad.reward.presenter.a) this.a).a.t, ((com.kwad.components.ad.reward.presenter.a) this.a).a.g, ((com.kwad.components.ad.reward.presenter.a) this.a).a.F, i3, i4);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.a.a(j2);
                    this.a.f = j2;
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.b();
                    this.a.e.b();
                    this.a.h = false;
                    if (this.a.i) {
                        return;
                    }
                    this.a.i = true;
                    com.kwad.components.core.i.a.a().a(this.a.b, System.currentTimeMillis(), 1);
                    com.kwad.components.ad.reward.monitor.a.b(((com.kwad.components.ad.reward.presenter.a) this.a).a.t, this.a.b, ((com.kwad.components.ad.reward.presenter.a) this.a).a.a);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void c() {
                f fVar;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.c();
                    this.a.i = false;
                    EcOrderCardStyle createFromAdInfo = EcOrderCardStyle.createFromAdInfo(this.a.c);
                    if (createFromAdInfo != null) {
                        fVar = new f();
                        u.a aVar = new u.a();
                        aVar.c = String.valueOf(createFromAdInfo.getValue());
                        fVar.a(aVar);
                    } else {
                        fVar = null;
                    }
                    c.a().a(this.a.b, null, fVar);
                    com.kwad.sdk.core.report.a.f(this.a.b, ((com.kwad.components.ad.reward.presenter.a) this.a).a.e);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    if (!((com.kwad.components.ad.reward.presenter.a) this.a).a.t || !((com.kwad.components.ad.reward.presenter.a) this.a).a.v) {
                        com.kwad.sdk.core.report.a.g(this.a.b, ((com.kwad.components.ad.reward.presenter.a) this.a).a.e);
                    }
                    this.a.e.b();
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.f();
                    this.a.e.a();
                    this.a.g.removeCallbacks(this.a.j);
                    this.a.g.postDelayed(this.a.j, 5000L);
                }
            }

            @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
            public final void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                    super.g();
                    this.a.e.a();
                    this.a.g.removeCallbacks(this.a.j);
                    this.a.g.postDelayed(this.a.j, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.b, ceil, ((com.kwad.components.ad.reward.presenter.a) this).a.e);
                    this.d.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.components.ad.reward.presenter.a) this).a.g;
            this.b = adTemplate;
            AdInfo i = d.i(adTemplate);
            this.c = i;
            this.d = com.kwad.sdk.core.response.a.a.Z(i);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.a(this.k);
            this.g.postDelayed(this.j, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.k_();
            this.g.removeCallbacksAndMessages(null);
            ((com.kwad.components.ad.reward.presenter.a) this).a.j.b(this.k);
            e.a d = this.e.d();
            com.kwad.components.core.i.a.a().a(((com.kwad.components.ad.reward.presenter.a) this).a.g, this.f, d.b(), d.a());
        }
    }
}

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
    public AdTemplate f66939b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f66940c;

    /* renamed from: d  reason: collision with root package name */
    public List<Integer> f66941d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.a.a.a f66942e;

    /* renamed from: f  reason: collision with root package name */
    public long f66943f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f66944g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66945h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f66946i;
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
        this.f66942e = new com.kwad.sdk.contentalliance.detail.a.a.a();
        this.f66943f = 0L;
        this.f66944g = new Handler(Looper.getMainLooper());
        this.f66945h = true;
        this.f66946i = false;
        this.j = new Runnable(this) { // from class: com.kwad.sdk.reward.b.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66947a;

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
                this.f66947a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f66947a.f66942e.c()) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f66947a.f66942e.e();
                        int a2 = this.f66947a.f66942e.d().a();
                        ((d) this.f66947a).f67255a.a(elapsedRealtime, this.f66947a.f66942e.d().b(), a2);
                    } else if (this.f66947a.f66945h) {
                        ((d) this.f66947a).f67255a.a(5000L, 5000L, 1);
                    }
                    com.kwad.sdk.core.report.d.c(this.f66947a.f66939b);
                }
            }
        };
        this.k = new e(this) { // from class: com.kwad.sdk.reward.b.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f66948a;

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
                this.f66948a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f66948a.a(j2);
                    this.f66948a.f66943f = j2;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.c();
                    this.f66948a.f66946i = false;
                    com.kwad.sdk.core.report.a.a(this.f66948a.f66939b, ((d) this.f66948a).f67255a.f66926d);
                    com.kwad.sdk.core.report.a.g(this.f66948a.f66939b, ((d) this.f66948a).f67255a.f66926d);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.d();
                    this.f66948a.f66942e.b();
                    this.f66948a.f66945h = false;
                    if (this.f66948a.f66946i) {
                        return;
                    }
                    this.f66948a.f66946i = true;
                    com.kwad.sdk.core.report.d.a(this.f66948a.f66939b, System.currentTimeMillis(), 1);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.e();
                    this.f66948a.f66942e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    com.kwad.sdk.core.report.a.h(this.f66948a.f66939b, ((d) this.f66948a).f67255a.f66926d);
                    this.f66948a.f66942e.b();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.g();
                    this.f66948a.f66942e.a();
                    this.f66948a.f66944g.removeCallbacks(this.f66948a.j);
                    this.f66948a.f66944g.postDelayed(this.f66948a.j, 5000L);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.h();
                    this.f66948a.f66942e.a();
                    this.f66948a.f66944g.removeCallbacks(this.f66948a.j);
                    this.f66948a.f66944g.postDelayed(this.f66948a.j, 5000L);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.f66941d;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.f66941d) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(this.f66939b, ceil, ((d) this).f67255a.f66926d);
                    this.f66941d.remove(num);
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
            AdTemplate adTemplate = ((d) this).f67255a.f66928f;
            this.f66939b = adTemplate;
            AdInfo i2 = c.i(adTemplate);
            this.f66940c = i2;
            this.f66941d = com.kwad.sdk.core.response.b.a.I(i2);
            ((d) this).f67255a.f66931i.a(this.k);
            this.f66944g.postDelayed(this.j, 5000L);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f66944g.removeCallbacksAndMessages(null);
            ((d) this).f67255a.f66931i.b(this.k);
            a.C1935a d2 = this.f66942e.d();
            com.kwad.sdk.core.report.d.a(((d) this).f67255a.f66928f, this.f66943f, d2.b(), d2.a());
        }
    }
}

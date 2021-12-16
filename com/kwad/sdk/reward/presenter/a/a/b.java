package com.kwad.sdk.reward.presenter.a.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.d;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.j;
/* loaded from: classes3.dex */
public class b extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f59613b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f59614c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59615d;

    /* renamed from: e  reason: collision with root package name */
    public long f59616e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f59617f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f59618g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f59619h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f59620i;

    /* renamed from: j  reason: collision with root package name */
    public d f59621j;

    /* renamed from: k  reason: collision with root package name */
    public f f59622k;

    public b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59614c = new Handler(Looper.getMainLooper());
        this.f59619h = 0L;
        this.f59620i = false;
        this.f59621j = new e(this) { // from class: com.kwad.sdk.reward.presenter.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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
            public void a(long j3, long j4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                    super.a(j3, j4);
                    this.a.f59619h = j4;
                    this.a.f59620i = j3 - j4 < 800;
                }
            }
        };
        this.f59622k = new f(this) { // from class: com.kwad.sdk.reward.presenter.a.a.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
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

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((g) this.a).a.x) {
                    return;
                }
                long j3 = this.a.f59616e;
                if (j3 == 0 || !this.a.f59615d) {
                    this.a.e();
                } else {
                    this.a.f59614c.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.presenter.a.a.b.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AnonymousClass2 a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr2 = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.a.a.o() == null || this.a.a.o().isFinishing()) {
                                return;
                            }
                            this.a.a.e();
                            this.a.a.f59613b.setAlpha(0.0f);
                            this.a.a.f59613b.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, j3);
                }
            }
        };
        this.f59616e = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f59613b.setVisibility(0);
            this.f59613b.setOnClickListener(this);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            AdTemplate adTemplate = this.f59617f;
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            j.a(((g) this).a.f59456h, this.f59617f, j.a(adTemplate, (String) null, aVar.y, aVar.z), new j.c(this) { // from class: com.kwad.sdk.reward.presenter.a.a.b.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.c(this.a.f59617f, Opcodes.FCMPL, null);
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        com.kwad.sdk.core.report.a.a(((g) this.a).a.f59455g, (int) (this.a.f59616e / 1000), (int) (this.a.f59619h / 1000));
                        com.kwad.sdk.core.report.a.f(this.a.f59617f, (int) Opcodes.DCMPL);
                        this.a.r();
                        this.a.h();
                    }
                }

                @Override // com.kwad.sdk.reward.j.c, com.kwad.sdk.reward.j.b
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        com.kwad.sdk.core.report.a.f(this.a.f59617f, 150);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            ((g) this).a.f59450b.a(false);
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            ((g) this).a.f59450b.e();
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f59619h = 0L;
            this.f59620i = false;
            AdTemplate adTemplate = ((g) this).a.f59455g;
            this.f59617f = adTemplate;
            this.f59618g = com.kwad.sdk.core.response.a.d.j(adTemplate);
            ((g) this).a.a(this.f59622k);
            ((g) this).a.f59459k.a(this.f59621j);
        }
    }

    public b b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.f59615d = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((g) this).a.b(this.f59622k);
            this.f59614c.removeCallbacksAndMessages(null);
            ((g) this).a.f59459k.b(this.f59621j);
            this.f59613b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c_();
            this.f59613b = a(R.id.ksad_end_close_btn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d_();
            this.f59614c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.f59613b) {
            boolean z = false;
            boolean z2 = true;
            if (f() || g()) {
                com.kwad.sdk.core.report.a.a(this.f59617f, 69, (int) (this.f59616e / 1000), (int) (this.f59619h / 1000));
                if (!((g) this).a.v && com.kwad.sdk.core.config.b.R() && !((g) this).a.u) {
                    z = true;
                }
                if (z) {
                    i();
                    return;
                }
            } else {
                long p = com.kwad.sdk.core.response.a.a.p(this.f59618g);
                if (p >= 0) {
                    z2 = (this.f59620i || this.f59619h >= p) ? true : true;
                }
                if (z2) {
                    s();
                }
            }
            r();
            h();
        }
    }
}

package com.kwad.sdk.reward.b.c.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.d;
/* loaded from: classes10.dex */
public class b extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public View f73839b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f73840c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73841d;

    /* renamed from: e  reason: collision with root package name */
    public long f73842e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f73843f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f73844g;

    /* renamed from: h  reason: collision with root package name */
    public f f73845h;

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
        this.f73840c = new Handler(Looper.getMainLooper());
        this.f73843f = 0L;
        this.f73844g = new e(this) { // from class: com.kwad.sdk.reward.b.c.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73846a;

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
                this.f73846a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j3, long j4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j3), Long.valueOf(j4)}) == null) {
                    super.a(j3, j4);
                    this.f73846a.f73843f = j4;
                }
            }
        };
        this.f73845h = new f(this) { // from class: com.kwad.sdk.reward.b.c.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f73847a;

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
                this.f73847a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((d) this.f73847a).f73944a.t) {
                    return;
                }
                long j3 = this.f73847a.f73842e;
                if (j3 == 0 || !this.f73847a.f73841d) {
                    this.f73847a.e();
                } else {
                    this.f73847a.f73840c.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.b.c.b.b.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f73848a;

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
                            this.f73848a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f73848a.f73847a.k() == null || this.f73848a.f73847a.k().isFinishing()) {
                                return;
                            }
                            this.f73848a.f73847a.e();
                            this.f73848a.f73847a.f73839b.setAlpha(0.0f);
                            this.f73848a.f73847a.f73839b.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }, j3);
                }
            }
        };
        this.f73842e = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.f73839b.setVisibility(0);
            this.f73839b.setOnClickListener(this);
        }
    }

    private void f() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || (activity = ((d) this).f73944a.f73608g) == null) {
            return;
        }
        activity.finish();
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ((d) this).f73944a.f73603b.a(false);
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            ((d) this).f73944a.f73603b.e();
        }
    }

    public b a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.f73841d = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.a();
            this.f73843f = 0L;
            ((d) this).f73944a.a(this.f73845h);
            ((d) this).f73944a.f73610i.a(this.f73844g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            this.f73839b = a(R.id.ksad_end_close_btn);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            ((d) this).f73944a.b(this.f73845h);
            this.f73840c.removeCallbacksAndMessages(null);
            ((d) this).f73944a.f73610i.b(this.f73844g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            this.f73840c.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.f73839b) {
            long ao = com.kwad.sdk.core.config.c.ao() * 1000;
            boolean z = true;
            if (ao >= 0 && this.f73843f <= ao) {
                z = false;
            }
            if (z) {
                o();
            }
            n();
            f();
        }
    }
}

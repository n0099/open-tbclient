package com.kwad.sdk.d.kwai;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.ax;
/* loaded from: classes2.dex */
public class f extends b implements a.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f58282b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f58283c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public a f58284d;

    /* renamed from: e  reason: collision with root package name */
    public int f58285e;

    /* renamed from: com.kwad.sdk.d.kwai.f$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public int f58286b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f58287c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f58288d;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
            this.f58286b = Integer.MIN_VALUE;
            this.f58287c = false;
            this.f58288d = false;
        }

        public /* synthetic */ a(f fVar, AnonymousClass1 anonymousClass1) {
            this(fVar);
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f58288d = z;
            }
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f58287c = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58288d) {
                return;
            }
            if (!this.f58287c) {
                if (this.f58286b == Integer.MIN_VALUE) {
                    this.f58286b = this.a.f58285e;
                }
                if (this.f58286b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this.a.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.f58286b);
                this.a.b(this.f58286b);
                this.f58286b = this.f58286b + (-1);
            }
            ax.a(this, null, f.a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1144122678, "Lcom/kwad/sdk/d/kwai/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1144122678, "Lcom/kwad/sdk/d/kwai/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        c cVar;
        com.kwad.sdk.d.a.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || (bVar = (cVar = this.f58282b).f58252e) == null) {
            return;
        }
        if (i2 != 0) {
            bVar.a(true, i2);
        } else if (cVar.d()) {
        } else {
            this.f58282b.a(q(), this.f58283c);
            r();
            c cVar2 = this.f58282b;
            cVar2.a(true, cVar2.f58256i);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.sdk.core.video.videoview.b bVar = this.f58282b.f58256i;
            if (bVar != null) {
                bVar.k();
            }
            this.f58282b.f58250c.dismiss();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f58282b.f58249b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onBind");
            c cVar = (c) p();
            this.f58282b = cVar;
            AdTemplate adTemplate = cVar.a;
            this.f58283c = adTemplate;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            long j3 = j2.adInsertScreenInfo.autoCloseTime;
            if (j3 > 0) {
                this.f58285e = (int) Math.min(com.kwad.sdk.core.config.b.a(j2), j3);
            } else {
                this.f58285e = com.kwad.sdk.core.config.b.a(j2);
            }
            com.kwad.sdk.d.a.b bVar = this.f58282b.f58252e;
            if (bVar != null) {
                bVar.a(true, -1);
            }
            if (!com.kwad.sdk.core.response.a.a.P(j2)) {
                a aVar = new a(this, null);
                this.f58284d = aVar;
                ax.a(aVar, null, 1000L);
                return;
            }
            this.f58285e = (int) Math.min(this.f58285e, com.kwad.sdk.core.response.a.a.b(j2));
            this.f58284d = null;
            this.f58282b.a(this);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            b(this.f58285e - ((int) (j2 / 1000)));
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            com.kwad.sdk.core.d.a.a("InterstitialPlayablePresenter", this + " onUnbind");
            this.f58282b.b(this);
            a aVar = this.f58284d;
            if (aVar != null) {
                aVar.a(true);
                ax.b(this.f58284d);
                this.f58284d = null;
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c_();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.a.b
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f58282b.a(q(), this.f58283c);
            r();
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.g();
            a aVar = this.f58284d;
            if (aVar != null) {
                aVar.b(false);
            }
        }
    }

    @Override // com.kwad.sdk.d.kwai.b
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.h();
            a aVar = this.f58284d;
            if (aVar != null) {
                aVar.b(true);
            }
        }
    }
}

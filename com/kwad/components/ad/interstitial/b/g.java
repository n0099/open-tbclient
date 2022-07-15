package com.kwad.components.ad.interstitial.b;

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
import com.kwad.components.core.video.a;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class g extends b implements a.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static long a = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public c b;
    public AdTemplate c;
    @Nullable
    public a d;
    public int e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;
        public int b;
        public boolean c;
        public boolean d;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gVar;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.d = false;
        }

        public /* synthetic */ a(g gVar, byte b) {
            this(gVar);
        }

        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.d = true;
            }
        }

        public final void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.c = z;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.d) {
                return;
            }
            if (!this.c) {
                if (this.b == Integer.MIN_VALUE) {
                    this.b = this.a.e;
                }
                if (this.b < 0) {
                    return;
                }
                com.kwad.sdk.core.d.b.a("InterstitialPlayablePresenter", this.a.toString() + ", this: " + toString() + " PlayableTimerRunnable run : " + this.b);
                this.a.a(this.b);
                this.b = this.b + (-1);
            }
            az.a(this, null, g.a);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(228459915, "Lcom/kwad/components/ad/interstitial/b/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(228459915, "Lcom/kwad/components/ad/interstitial/b/g;");
        }
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        c cVar;
        com.kwad.components.ad.interstitial.widget.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65539, this, i) == null) || (fVar = (cVar = this.b).e) == null) {
            return;
        }
        if (i != 0) {
            fVar.a(true, i);
        } else if (cVar.d()) {
        } else {
            this.b.a(u(), this.c);
            h();
            c cVar2 = this.b;
            cVar2.a(true, cVar2.l);
        }
    }

    private void h() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            com.kwad.sdk.core.video.videoview.a aVar = this.b.l;
            if (aVar != null) {
                aVar.i();
            }
            this.b.c.dismiss();
            c cVar = this.b;
            if (cVar.h || (adInteractionListener = cVar.b) == null) {
                return;
            }
            adInteractionListener.onAdClosed();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.b.a("InterstitialPlayablePresenter", this + " onBind");
            c cVar = (c) t();
            this.b = cVar;
            AdTemplate adTemplate = cVar.a;
            this.c = adTemplate;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            long j = i.adInsertScreenInfo.autoCloseTime;
            if (j > 0) {
                this.e = (int) Math.min(com.kwad.components.ad.interstitial.kwai.b.a(i), j);
            } else {
                this.e = com.kwad.components.ad.interstitial.kwai.b.a(i);
            }
            com.kwad.components.ad.interstitial.widget.f fVar = this.b.e;
            if (fVar != null) {
                fVar.a(true, -1);
            }
            if (!com.kwad.sdk.core.response.a.a.W(i)) {
                a aVar = new a(this, (byte) 0);
                this.d = aVar;
                az.a(aVar, null, 1000L);
                return;
            }
            this.e = (int) Math.min(this.e, com.kwad.sdk.core.response.a.a.c(i));
            this.d = null;
            this.b.a(this);
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            a(this.e - ((int) (j / 1000)));
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            a aVar = this.d;
            if (aVar != null) {
                aVar.b(false);
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.e();
            a aVar = this.d;
            if (aVar != null) {
                aVar.b(true);
            }
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void f_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void g_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.kwad.components.core.video.a.b
    public final void h_() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.b.d()) {
            return;
        }
        this.b.a(u(), this.c);
        h();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.i_();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.k_();
            com.kwad.sdk.core.d.b.a("InterstitialPlayablePresenter", this + " onUnbind");
            this.b.b(this);
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(true);
                az.b(this.d);
                this.d = null;
            }
        }
    }
}

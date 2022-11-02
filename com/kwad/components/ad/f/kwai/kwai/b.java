package com.kwad.components.ad.f.kwai.kwai;

import androidx.annotation.NonNull;
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
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
/* loaded from: classes7.dex */
public final class b implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ks = 1;
    public static int kt = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.webview.kwai.c kr;
    public int ku;
    public int kv;
    public c kw;
    public InterfaceC0532b kx;
    @Nullable
    public Runnable ky;

    @KsJson
    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int kA;
        public int kB;

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
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.f.kwai.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0532b {
        void C(int i);
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean kC;
        public int kD;
        public final /* synthetic */ b kz;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.kz = bVar;
            this.kC = false;
            this.kD = -1;
        }

        public /* synthetic */ c(b bVar, byte b) {
            this(bVar);
        }

        public final void J(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.kD = i;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                com.kwad.sdk.core.e.b.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.kC + ", currentTime: " + this.kD);
                if (this.kC) {
                    bd.a(this, null, 1000L);
                    return;
                }
                int i = this.kD;
                if (i < 0) {
                    return;
                }
                this.kz.I(i);
                this.kD--;
                bd.a(this, null, 1000L);
            }
        }

        public final void y(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.kC = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(55751259, "Lcom/kwad/components/ad/f/kwai/kwai/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(55751259, "Lcom/kwad/components/ad/f/kwai/kwai/b;");
        }
    }

    public b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.kw = new c(this, (byte) 0);
        this.ky = null;
        this.ku = i;
        this.kv = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i) == null) {
            com.kwad.sdk.core.e.b.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.kr);
            if (i >= 0 && this.kr != null) {
                InterfaceC0532b interfaceC0532b = this.kx;
                if (interfaceC0532b != null && i == 0) {
                    interfaceC0532b.C(this.ku);
                }
                a aVar = new a();
                aVar.kB = i;
                aVar.kA = this.ku;
                com.kwad.sdk.core.webview.kwai.c cVar = this.kr;
                if (cVar != null) {
                    cVar.a(aVar);
                }
            }
        }
    }

    @Nullable
    public static b j(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, adTemplate)) == null) {
            AdInfo bQ = d.bQ(adTemplate);
            if (!com.kwad.sdk.core.response.a.a.aB(bQ)) {
                if (com.kwad.sdk.core.response.a.a.aY(bQ)) {
                    return new b(kt, com.kwad.components.ad.interstitial.kwai.b.b(bQ));
                }
                int i = bQ.adInsertScreenInfo.autoCloseTime;
                if (i > 0) {
                    return new b(ks, i);
                }
                return null;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public final void a(InterfaceC0532b interfaceC0532b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, interfaceC0532b) == null) {
            this.kx = interfaceC0532b;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            this.kr = cVar;
            Runnable runnable = this.ky;
            if (runnable != null) {
                runnable.run();
                this.ky = null;
            }
        }
    }

    public final void eA() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.kw.y(true);
        }
    }

    public final void eB() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.kw.y(false);
        }
    }

    public final void ez() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.e.b.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.kr);
            if (this.kr == null) {
                this.ky = new Runnable(this) { // from class: com.kwad.components.ad.f.kwai.kwai.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b kz;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.kz = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.kz.ez();
                        }
                    }
                };
                return;
            }
            this.kw.J(this.kv);
            bd.runOnUiThread(this.kw);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "registerTimerListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.kr = null;
        }
    }
}

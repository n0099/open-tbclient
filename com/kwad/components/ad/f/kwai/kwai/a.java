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
import com.kwad.sdk.utils.az;
/* loaded from: classes5.dex */
public final class a implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public static int b = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.webview.kwai.c c;
    public int d;
    public int e;
    public c f;
    public b g;
    @Nullable
    public Runnable h;

    @KsJson
    /* renamed from: com.kwad.components.ad.f.kwai.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0461a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public C0461a() {
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

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;
        public boolean b;
        public int c;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = false;
            this.c = -1;
        }

        public /* synthetic */ c(a aVar, byte b) {
            this(aVar);
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.c = i;
            }
        }

        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.b = z;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                com.kwad.sdk.core.d.b.a("RegisterTimer", "TimerRunnable run timerPaused:  " + this.b + ", currentTime: " + this.c);
                if (this.b) {
                    az.a(this, null, 1000L);
                    return;
                }
                int i = this.c;
                if (i < 0) {
                    return;
                }
                this.a.a(i);
                this.c--;
                az.a(this, null, 1000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(55751228, "Lcom/kwad/components/ad/f/kwai/kwai/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(55751228, "Lcom/kwad/components/ad/f/kwai/kwai/a;");
        }
    }

    public a(int i, int i2) {
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
        this.f = new c(this, (byte) 0);
        this.h = null;
        this.d = i;
        this.e = i2;
    }

    public static int a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) {
            int i = adInfo.adInsertScreenInfo.autoCloseTime;
            int a2 = com.kwad.components.ad.interstitial.kwai.b.a(adInfo);
            if (i > 0) {
                a2 = Math.min(a2, i);
            }
            if (a2 > 0) {
                return a2;
            }
            return 60;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static a a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adTemplate)) == null) {
            AdInfo i = d.i(adTemplate);
            boolean ar = com.kwad.sdk.core.response.a.a.ar(i);
            boolean z = !com.kwad.sdk.core.response.a.a.W(i);
            if (ar && z) {
                return new a(b, a(i));
            }
            if (i.adInsertScreenInfo.autoCloseTime > 0) {
                return new a(a, a(i));
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            com.kwad.sdk.core.d.b.a("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.c);
            if (i >= 0 && this.c != null) {
                b bVar = this.g;
                if (bVar != null && i == 0) {
                    bVar.a(this.d);
                }
                C0461a c0461a = new C0461a();
                c0461a.b = i;
                c0461a.a = this.d;
                this.c.a(c0461a);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerTimerListener" : (String) invokeV.objValue;
    }

    public final void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.g = bVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            this.c = cVar;
            Runnable runnable = this.h;
            if (runnable != null) {
                runnable.run();
                this.h = null;
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = null;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.b.a("RegisterTimer", "startTimer: mCallBackFunction: " + this.c);
            if (this.c == null) {
                this.h = new Runnable(this) { // from class: com.kwad.components.ad.f.kwai.kwai.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

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
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.c();
                        }
                    }
                };
                return;
            }
            this.f.a(this.e);
            az.a(this.f);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.a(true);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f.a(false);
        }
    }
}

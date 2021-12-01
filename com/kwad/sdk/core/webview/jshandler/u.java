package com.kwad.sdk.core.webview.jshandler;

import android.content.Context;
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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
/* loaded from: classes2.dex */
public class u implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f58078b = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.webview.kwai.c f58079c;

    /* renamed from: d  reason: collision with root package name */
    public int f58080d;

    /* renamed from: e  reason: collision with root package name */
    public int f58081e;

    /* renamed from: f  reason: collision with root package name */
    public c f58082f;

    /* renamed from: g  reason: collision with root package name */
    public b f58083g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Runnable f58084h;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58085b;

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
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i2);
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f58086b;

        /* renamed from: c  reason: collision with root package name */
        public int f58087c;

        public c(u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uVar;
            this.f58086b = false;
            this.f58087c = -1;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f58087c = i2;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f58086b = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                com.kwad.sdk.core.d.a.a("RegisterTimer", "TimerRunnable run timerPaused:  " + this.f58086b + ", currentTime: " + this.f58087c);
                if (this.f58086b) {
                    ax.a(this, null, 1000L);
                    return;
                }
                int i2 = this.f58087c;
                if (i2 < 0) {
                    return;
                }
                this.a.a(i2);
                this.f58087c--;
                ax.a(this, null, 1000L);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1790839199, "Lcom/kwad/sdk/core/webview/jshandler/u;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1790839199, "Lcom/kwad/sdk/core/webview/jshandler/u;");
        }
    }

    public u(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58080d = -1;
        this.f58081e = -1;
        this.f58082f = new c();
        this.f58084h = null;
        this.f58080d = i2;
        this.f58081e = i3;
    }

    public static int a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adInfo)) == null) {
            int i2 = adInfo.adInsertScreenInfo.autoCloseTime;
            int a2 = com.kwad.sdk.core.config.b.a(adInfo);
            if (i2 > 0) {
                a2 = Math.min(a2, i2);
            }
            if (a2 > 0) {
                return a2;
            }
            return 60;
        }
        return invokeL.intValue;
    }

    @Nullable
    public static u a(Context context, AdTemplate adTemplate) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, adTemplate)) == null) {
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            boolean an = com.kwad.sdk.core.response.a.a.an(j2);
            boolean z = !com.kwad.sdk.core.response.a.a.P(j2);
            if (an && z) {
                return new u(f58078b, a(j2));
            }
            if (j2.adInsertScreenInfo.autoCloseTime > 0) {
                return new u(a, a(j2));
            }
            return null;
        }
        return (u) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            com.kwad.sdk.core.d.a.a("RegisterTimer", "updateTimer: " + i2 + ", mCallBackFunction: " + this.f58079c);
            if (i2 >= 0 && this.f58079c != null) {
                b bVar = this.f58083g;
                if (bVar != null && i2 == 0) {
                    bVar.a(this.f58080d);
                }
                a aVar = new a();
                aVar.f58085b = i2;
                aVar.a = this.f58080d;
                this.f58079c.a(aVar);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerTimerListener" : (String) invokeV.objValue;
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f58083g = bVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            this.f58079c = cVar;
            Runnable runnable = this.f58084h;
            if (runnable != null) {
                runnable.run();
                this.f58084h = null;
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58079c = null;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            com.kwad.sdk.core.d.a.a("RegisterTimer", "startTimer: mCallBackFunction: " + this.f58079c);
            if (this.f58079c == null) {
                this.f58084h = new Runnable(this) { // from class: com.kwad.sdk.core.webview.jshandler.u.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ u a;

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

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.a.c();
                        }
                    }
                };
                return;
            }
            this.f58082f.a(this.f58081e);
            ax.a(this.f58082f);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f58082f.a(true);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f58082f.a(false);
        }
    }
}

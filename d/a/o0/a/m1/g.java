package d.a.o0.a.m1;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.h;
import d.a.o0.a.j2.k;
/* loaded from: classes7.dex */
public class g implements d.a.o0.a.h0.j.c, d.a.o0.a.h0.j.e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f46611d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile g f46612e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46613a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f46614b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.a.m1.a f46615c;

    /* loaded from: classes7.dex */
    public class a implements Action<d.a.o0.a.z1.b.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f46616a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46616a = gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        /* renamed from: a */
        public void call(d.a.o0.a.z1.b.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f46616a.h(new d.a.o0.a.m1.h.a(aVar));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(514609448, "Ld/a/o0/a/m1/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(514609448, "Ld/a/o0/a/m1/g;");
                return;
            }
        }
        f46611d = d.a.o0.a.a2.e.y;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46614b = false;
        this.f46615c = new b();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", d.a.o0.a.z1.b.b.a.class, 0, new a(this));
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            c.a();
        }
    }

    @NonNull
    public static g f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f46612e == null) {
                synchronized (g.class) {
                    if (f46612e == null) {
                        f46612e = new g();
                    }
                }
            }
            return f46612e;
        }
        return (g) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.j.e
    public void a(d.a.o0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            if (f46611d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            h(new d.a.o0.a.m1.h.e(eVar, true));
        }
    }

    @Override // d.a.o0.a.h0.j.e
    public void b(d.a.o0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            if (f46611d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            h(new d.a.o0.a.m1.h.e(eVar, false));
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? ((b) this.f46615c).d() : invokeV.intValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.o0.a.c1.a.Z().getSwitch("swan_white_screen_forward", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h(d.a.o0.a.m1.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f46615c.a(cVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(new d.a.o0.a.m1.h.c(11));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (f46611d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
                Log.d("SwanAppPageMonitor", sb.toString());
            }
            h(new d.a.o0.a.m1.h.b(z));
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && h.f46265e) {
            if (z) {
                m();
            } else {
                l();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f46614b = true;
            h(new d.a.o0.a.m1.h.c(12, null, 0L, false));
            if (f46611d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f46614b) {
            h(new d.a.o0.a.m1.h.c(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (f46611d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f46613a = z;
            if (z) {
                f.k();
                d.a.o0.a.j2.e.z();
                this.f46614b = false;
            }
        }
    }

    public void o() {
        d.a.o0.a.m1.h.c cVar;
        b.a L;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long o = d.a.o0.a.c1.a.Z().o();
            if (f46611d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + o);
            }
            if (this.f46613a) {
                boolean g2 = g();
                if (f46611d) {
                    Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + g2);
                }
                SwanAppActivity activity = d.a.o0.a.g1.f.V().getActivity();
                if (g2 && activity != null && (L = d.a.o0.a.a2.d.g().r().L()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - L.N();
                    o -= currentTimeMillis;
                    if (o < 0) {
                        if (f46611d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                        aVar.j(5L);
                        aVar.h(40L);
                        aVar.e("whitescreen monitor out of time: time=" + currentTimeMillis);
                        d.a.o0.a.j2.p.d dVar = new d.a.o0.a.j2.p.d();
                        dVar.q(k.m(L.G()));
                        dVar.p(aVar);
                        dVar.r(L);
                        k.L(dVar);
                    }
                }
                cVar = new d.a.o0.a.m1.h.c(1, null, o, true);
                this.f46613a = false;
                this.f46614b = false;
                if (h.f46265e) {
                    h(cVar);
                }
            } else {
                cVar = null;
            }
            if (f46611d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + o);
            }
            if (h.f46265e) {
                return;
            }
            if (cVar == null) {
                cVar = new d.a.o0.a.m1.h.c(1, null, o);
            }
            h(cVar);
        }
    }

    @Override // d.a.o0.a.h0.j.c
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i2, i3, i4, i5) == null) {
            if (i4 == 0 && i5 == 0 && i2 == 0 && i3 == 1) {
                return;
            }
            h(new d.a.o0.a.m1.h.c(3));
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            h(new d.a.o0.a.m1.h.c(9, null, 6000L));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (f46611d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            h(new d.a.o0.a.m1.h.c(7));
        }
    }
}

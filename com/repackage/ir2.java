package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl2;
/* loaded from: classes6.dex */
public class ir2 implements h22, j22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile ir2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public br2 c;

    /* loaded from: classes6.dex */
    public class a implements Action<rz2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ir2 a;

        public a(ir2 ir2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ir2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ir2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(rz2 rz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rz2Var) == null) {
                this.a.f(new jr2(rz2Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755608920, "Lcom/repackage/ir2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755608920, "Lcom/repackage/ir2;");
                return;
            }
        }
        d = u03.v;
    }

    public ir2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new cr2();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", rz2.class, 0, new a(this));
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            dr2.a();
        }
    }

    @NonNull
    public static ir2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (ir2.class) {
                    if (e == null) {
                        e = new ir2();
                    }
                }
            }
            return e;
        }
        return (ir2) invokeV.objValue;
    }

    @Override // com.repackage.j22
    public void a(dn1 dn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dn1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new nr2(dn1Var, true));
        }
    }

    @Override // com.repackage.j22
    public void b(dn1 dn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dn1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new nr2(dn1Var, false));
        }
    }

    public final void f(lr2 lr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lr2Var) == null) {
            this.c.a(lr2Var);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new lr2(11));
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (d) {
                StringBuilder sb = new StringBuilder();
                sb.append("change to ");
                sb.append(z ? NotificationCompat.WearableExtender.KEY_BACKGROUND : Constant.FOREGROUND);
                Log.d("SwanAppPageMonitor", sb.toString());
            }
            f(new kr2(z));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && i73.d) {
            if (z) {
                k();
            } else {
                j();
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b = true;
            f(new lr2(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b) {
            f(new lr2(13, null, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=" + PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (z) {
                hr2.k();
                e73.z();
                this.b = false;
            }
        }
    }

    public void m() {
        lr2 lr2Var;
        rl2.a V;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = bk2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (hm2.U().getActivity() != null && (V = t03.J().r().V()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - V.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        nc3 nc3Var = new nc3();
                        nc3Var.k(5L);
                        nc3Var.i(40L);
                        nc3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        v73 v73Var = new v73();
                        v73Var.q(n73.n(V.G()));
                        v73Var.p(nc3Var);
                        v73Var.r(V);
                        n73.R(v73Var);
                    }
                }
                lr2Var = new lr2(1, null, n, true);
                this.a = false;
                j12.b().e(n);
                this.b = false;
                if (i73.d) {
                    f(lr2Var);
                }
            } else {
                lr2Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (i73.d) {
                return;
            }
            if (lr2Var == null) {
                lr2Var = new lr2(1, null, n);
            }
            f(lr2Var);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new lr2(9, null, 6000L));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new lr2(7));
        }
    }

    @Override // com.repackage.h22
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new lr2(3));
        }
    }
}

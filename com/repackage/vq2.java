package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.el2;
/* loaded from: classes7.dex */
public class vq2 implements u12, w12 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile vq2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public oq2 c;

    /* loaded from: classes7.dex */
    public class a implements Action<ez2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vq2 a;

        public a(vq2 vq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vq2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.bdeventbus.Action
        public void call(ez2 ez2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ez2Var) == null) {
                this.a.f(new wq2(ez2Var));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755222598, "Lcom/repackage/vq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755222598, "Lcom/repackage/vq2;");
                return;
            }
        }
        d = h03.v;
    }

    public vq2() {
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
        this.c = new pq2();
        BdEventBus.Companion.getDefault().lazyRegister("dialog_event_tag", ez2.class, 0, new a(this));
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            qq2.a();
        }
    }

    @NonNull
    public static vq2 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (vq2.class) {
                    if (e == null) {
                        e = new vq2();
                    }
                }
            }
            return e;
        }
        return (vq2) invokeV.objValue;
    }

    @Override // com.repackage.w12
    public void a(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qm1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview insert event");
            }
            f(new ar2(qm1Var, true));
        }
    }

    @Override // com.repackage.w12
    public void b(qm1 qm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qm1Var) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "webview remove event");
            }
            f(new ar2(qm1Var, false));
        }
    }

    public final void f(yq2 yq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yq2Var) == null) {
            this.c.a(yq2Var);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f(new yq2(11));
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
            f(new xq2(z));
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && v63.d) {
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
            f(new yq2(12, null, 0L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onPause cancel route monitor");
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b) {
            f(new yq2(13, null, 4000L, false));
            if (d) {
                Log.d("SwanAPPPageMonitor-Route", "**************** page onResume start route monitor, time=4000");
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
            if (z) {
                uq2.k();
                r63.z();
                this.b = false;
            }
        }
    }

    public void m() {
        yq2 yq2Var;
        el2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long n = oj2.g0().n();
            if (d) {
                Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + n);
            }
            if (this.a) {
                if (ul2.U().getActivity() != null && (W = g03.K().q().W()) != null) {
                    long currentTimeMillis = System.currentTimeMillis() - W.N();
                    n -= currentTimeMillis;
                    if (n < 0) {
                        if (d) {
                            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                        }
                        ac3 ac3Var = new ac3();
                        ac3Var.k(5L);
                        ac3Var.i(40L);
                        ac3Var.f("whitescreen monitor out of time: time=" + currentTimeMillis);
                        i73 i73Var = new i73();
                        i73Var.q(a73.n(W.G()));
                        i73Var.p(ac3Var);
                        i73Var.r(W);
                        a73.R(i73Var);
                    }
                }
                yq2Var = new yq2(1, null, n, true);
                this.a = false;
                w02.b().e(n);
                this.b = false;
                if (v63.d) {
                    f(yq2Var);
                }
            } else {
                yq2Var = null;
            }
            if (d) {
                Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + n);
            }
            if (v63.d) {
                return;
            }
            if (yq2Var == null) {
                yq2Var = new yq2(1, null, n);
            }
            f(yq2Var);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f(new yq2(9, null, 6000L));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (d) {
                Log.d("SwanAppPageMonitor", "stop page monitoring");
            }
            f(new yq2(7));
        }
    }

    @Override // com.repackage.u12
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048588, this, i, i2, i3, i4) == null) {
            if (i3 == 0 && i4 == 0 && i == 0 && i2 == 1) {
                return;
            }
            f(new yq2(3));
        }
    }
}

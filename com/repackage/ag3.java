package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.event.base.TKBaseEvent;
/* loaded from: classes5.dex */
public class ag3 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public int[] e;
    public c f;
    public long g;
    public b h;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public MotionEvent a;
        public ab2 b;
        public final /* synthetic */ ag3 c;

        public b(ag3 ag3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ag3Var;
        }

        public final void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                this.a = motionEvent;
                this.b = this.c.d(motionEvent, "longtap");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.g(this.b);
            }
        }

        public /* synthetic */ b(ag3 ag3Var, a aVar) {
            this(ag3Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public double b;

        public c(ag3 ag3Var, double d, double d2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag3Var, Double.valueOf(d), Double.valueOf(d2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d;
            this.b = d2;
        }

        public double a(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return Double.MAX_VALUE;
                }
                double pow = Math.pow(cVar.a - this.a, 2.0d) + Math.pow(cVar.b - this.b, 2.0d);
                if (pow <= 0.0d) {
                    return 0.0d;
                }
                return Math.sqrt(pow);
            }
            return invokeL.doubleValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755857788, "Lcom/repackage/ag3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755857788, "Lcom/repackage/ag3;");
                return;
            }
        }
        i = eh1.a;
    }

    public ag3(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = false;
        this.e = new int[2];
        this.h = new b(this, null);
        this.a = str;
        this.b = str2;
        this.c = str3;
        i();
        j();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONObject, T] */
    public final ab2 c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            zf3 zf3Var = new zf3(motionEvent);
            zf3Var.i(this.e);
            ab2 ab2Var = new ab2();
            ab2Var.c = bg3.b(this.a, this.b, this.c, zf3Var.e(), zf3Var.c());
            return ab2Var;
        }
        return (ab2) invokeL.objValue;
    }

    /* JADX WARN: Type inference failed for: r6v2, types: [org.json.JSONObject, T] */
    public final ab2 d(MotionEvent motionEvent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent, str)) == null) {
            zf3 zf3Var = new zf3(motionEvent, str);
            zf3Var.i(this.e);
            ab2 ab2Var = new ab2();
            ab2Var.c = bg3.b(this.a, this.b, this.c, zf3Var.e(), zf3Var.c());
            return ab2Var;
        }
        return (ab2) invokeLL.objValue;
    }

    public final void e(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent) == null) {
            if (view2 != null && motionEvent != null && !TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0 && motionEvent.getPointerCount() == 1) {
                    this.f = new c(this, motionEvent.getX(), motionEvent.getY());
                    this.g = motionEvent.getEventTime();
                    this.h.b(motionEvent);
                    view2.postDelayed(this.h, 350L);
                    j();
                } else if (actionMasked == 1 || actionMasked == 3 || !f(new c(this, motionEvent.getX(), motionEvent.getY()))) {
                    view2.removeCallbacks(this.h);
                }
                g(c(motionEvent));
                if (actionMasked == 1 && f(new c(this, motionEvent.getX(), motionEvent.getY())) && motionEvent.getEventTime() - this.g < 350) {
                    g(d(motionEvent, TKBaseEvent.TK_CLICK_EVENT_NAME));
                    return;
                }
                return;
            }
            ux1.c("SwanAppTouchListener", "params is null, slaveId = " + this.a + " ; viewId = " + this.b);
        }
    }

    public final boolean f(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cVar)) == null) {
            c cVar2 = this.f;
            return cVar2 != null && cVar2.a(cVar) <= ((double) le3.g(10.0f));
        }
        return invokeL.booleanValue;
    }

    public final void g(ab2 ab2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ab2Var) == null) {
            if (i) {
                Log.d("SwanAppTouchListener", "sendEventToWebView = " + ab2Var.c);
            }
            if (!this.d) {
                hm2.U().m(this.a, ab2Var);
            } else {
                hm2.U().u(ab2Var);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = je3.f("1.12.0") && TextUtils.equals("canvas", this.c);
        }
    }

    public final void j() {
        View m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (m = oe3.m(this.a)) == null) {
            return;
        }
        m.getLocationOnScreen(this.e);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view2, motionEvent)) == null) {
            e(view2, motionEvent);
            return true;
        }
        return invokeLL.booleanValue;
    }
}

package d.a.q0.a.q1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.g;
import d.a.q0.a.h;
import d.a.q0.a.h0.g.k;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public class f extends k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Timer J0;

    /* loaded from: classes8.dex */
    public class a extends d.a.q0.a.h0.j.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f50144c;

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
            this.f50144c = fVar;
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", "title: " + str);
            }
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", "onReceivedSslError:  statusCode = " + i2);
            }
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (str != null && str.startsWith("weixin://wap/pay")) {
                    d.a.q0.a.e0.d.g("SwanAppWxPayFragment", " weixin  url:   " + str);
                    d.a.q0.a.j2.k.F("wechatH5Action", "intoPayment", 0);
                    this.f50144c.J0.cancel();
                    this.f50144c.J0 = null;
                    k.L2();
                    return false;
                }
                return super.c(str);
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public void d(int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
                String str3 = "onReceivedError:  failingUrl = " + str2 + " errorCode = " + i2 + " description = " + str;
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", str3);
                d.a.q0.a.j2.k.D(false, "wechatH5Action", d.a.q0.a.q1.a.c(str2, str3));
            }
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", "url: " + str);
            }
        }

        @Override // d.a.q0.a.h0.j.a, d.a.q0.a.h0.j.d
        public void goBack() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", "goBack: ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f50145e;

        public b(f fVar) {
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
            this.f50145e = fVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", " WeChat H5 pay redirect time out : ");
                d.a.q0.a.j2.k.F("wechatH5Action", "outOfTime", 0);
            }
        }
    }

    public f() {
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

    @Override // d.a.q0.a.h0.g.k
    public void J2(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, frameLayout) == null) {
            frameLayout.addView((RelativeLayout) LayoutInflater.from(q()).inflate(g.aiapps_wx_pay_loading_layout, (ViewGroup) null), new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    @Override // d.a.q0.a.h0.g.k
    public d.a.q0.a.h0.j.d M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new a(this) : (d.a.q0.a.h0.j.d) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.k, d.a.q0.a.h0.g.d
    public void Q1(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.Q1(view);
            this.n0.setTitle(z().getString(h.aiapps_wx_pay_title));
            p2(false);
        }
    }

    public Timer V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.q0.a.e0.d.h("SwanAppWxPayFragment", " start WeChat H5 redirect timer start : ");
            Timer timer = new Timer();
            try {
                timer.schedule(new b(this), 10000L);
            } catch (Exception e2) {
                if (k.I0) {
                    e2.printStackTrace();
                }
                d.a.q0.a.e0.d.h("SwanAppWxPayFragment", e2.getMessage());
            }
            return timer;
        }
        return (Timer) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.g.k
    public d.a.q0.a.p.e.e m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.J0 == null) {
                this.J0 = V2();
            }
            return d.a.q0.a.h0.u.g.N().X().g(q());
        }
        return (d.a.q0.a.p.e.e) invokeV.objValue;
    }
}

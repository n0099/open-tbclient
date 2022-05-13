package com.repackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.t80;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class d80 implements t80.a, Observer {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c80 d;
    public static volatile d80 e;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public b c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d80 this$0;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
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
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.this$0.d("netchange");
                }
            }
        }

        public b(d80 d80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = d80Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                b90.a("LCPClientManager", "NetStatusReceiver changed");
                if (RequsetNetworkUtils.isNetworkAvailable(context) && c90.m(context)) {
                    b90.b("LCPClientManager", "NetStatusReceiver reconnect");
                    w80.a(context).b(new a(this));
                }
            }
        }

        public /* synthetic */ b(d80 d80Var, a aVar) {
            this(d80Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755813675, "Lcom/repackage/d80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755813675, "Lcom/repackage/d80;");
                return;
            }
        }
        d = new c80();
        new LinkedHashMap();
    }

    public d80() {
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
        this.b = -1;
        new LinkedBlockingQueue();
    }

    public static synchronized d80 e() {
        InterceptResult invokeV;
        d80 d80Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (d80.class) {
                if (e == null) {
                    synchronized (d80.class) {
                        if (e == null) {
                            e = new d80();
                        }
                    }
                }
                d80Var = e;
            }
            return d80Var;
        }
        return (d80) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a : invokeV.intValue;
    }

    public void b(Context context, String str, String str2, int i, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            if (d.a != -2 && d.a != 0) {
                if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                    w70.h(context).f();
                }
                c(context, str, str2, i, str3);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SocketConnect state is ");
            sb.append(d.a == 0 ? "connected" : "connecting");
            b90.a("LCPClientManager", sb.toString());
        }
    }

    public synchronized void c(Context context, String str, String str2, int i, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, Integer.valueOf(i), str3}) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                    this.a = context;
                    if (TextUtils.isEmpty(c90.b(context))) {
                        c90.q(context, str);
                    }
                    if (TextUtils.isEmpty(c90.e(context))) {
                        c90.s(context, str2);
                    }
                    k80.S(context).addObserver(e);
                    if (d.a != -2 && d.a != 0) {
                        if (this.c == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                            b bVar = new b(this, null);
                            this.c = bVar;
                            context.registerReceiver(bVar, intentFilter);
                        }
                        if (z70.f(context) && !w70.i().booleanValue()) {
                            w70.h(context).e(context, String.valueOf(601110), 10);
                            z70.m(context, i);
                        }
                        if (!c90.k(context)) {
                            if (this.b < 0) {
                                t70.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3).c("token_begin", System.currentTimeMillis());
                                l();
                            }
                            return;
                        }
                        b90.b("LCPClientManager", "token is not null ");
                        t70.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3);
                        k(0);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("SocketConnect state is ");
                    sb.append(d.a == 0 ? "connected" : "connecting");
                    b90.a("LCPClientManager", sb.toString());
                    return;
                }
                b90.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
                t70.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("P0", "connect param not correct or net unconnected").d("con_err_code", "P0").c("flow_end_time", System.currentTimeMillis()).d("source", str3).e();
            }
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            Context context = this.a;
            b(context, c90.b(context), c90.e(this.a), z70.c(this.a), str);
        }
    }

    public void g(@NonNull BLCPRequest bLCPRequest, @Nullable f80 f80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bLCPRequest, f80Var) == null) {
            Context context = this.a;
            if (context == null || !c90.m(context)) {
                if (f80Var != null) {
                    f80Var.onResponse(8010, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                }
            } else if (d.a != 0) {
                if (!(bLCPRequest instanceof e80) && f80Var != null) {
                    f80Var.onResponse(8010, "unconnected", bLCPRequest.a, bLCPRequest.b, bLCPRequest.d, new byte[0]);
                }
                if (d.a == -1 || !j()) {
                    d("invoke");
                }
            } else {
                k80.S(this.a).H(bLCPRequest, f80Var);
                if (bLCPRequest.b == 1 && bLCPRequest.a == 4) {
                    b90.a("LCPClientManager", "云控登录打点");
                    Context context2 = this.a;
                    y80.a(context2, 1L, "invoke", bLCPRequest.d + "");
                }
                if (bLCPRequest.b == 50 && bLCPRequest.a == 2) {
                    Context context3 = this.a;
                    y80.a(context3, 50L, "invoke", bLCPRequest.d + "");
                }
            }
        }
    }

    public void h() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (context = this.a) == null) {
            return;
        }
        k80.S(context).b0();
    }

    public void i(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        this.a = context;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context context = this.a;
            return context == null || k80.S(context).R().a != -1;
        }
        return invokeV.booleanValue;
    }

    public final void k(int i) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (context = this.a) != null && c90.m(context)) {
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                b90.a("LCPClientManager", "socketAction closeSocket");
                k80.S(this.a).i0("socketAction closeSocket:", k80.S(this.a).x);
                return;
            }
            b90.a("LCPClientManager", "socketAction createSocket");
            d.a = -2;
            t70.h(this.a).g(601110).d("P8", "socketAction createSocket").d("con_err_code", "P8");
            k80.S(this.a).h0();
        }
    }

    public void l() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Context context2 = this.a;
            if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
                this.b++;
                t70.h(this.a).g(601110).b("token_count", this.b);
                b90.a("LCPClientManager", "no token, so request token, and tryCount = " + this.b);
                if (this.b < 3) {
                    t80 t80Var = new t80(this.a, this);
                    u80.e(t80Var, t80Var);
                    return;
                }
                this.b = -1;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("context = ");
            sb.append(this.a);
            sb.append(", net :");
            sb.append(this.a == null ? "" : Boolean.valueOf(!RequsetNetworkUtils.isConnected(context)));
            b90.a("LCPClientManager", sb.toString());
            t70.h(this.a).g(601110).d("P1", "token request net unconnected").d("con_err_code", "P1").c("flow_end_time", System.currentTimeMillis()).e();
        }
    }

    @Override // com.repackage.t80.a
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, str) == null) {
            b90.b("LCPClientManager", "getToken :" + str);
            v70 g = t70.h(this.a).g(601110);
            g.d("P4", "getToken errCode:" + i + ",errMsg:" + str).d("con_err_code", "P4");
            l();
            if (this.b == 2) {
                v70 c = t70.h(this.a).g(601110).c("flow_end_time", System.currentTimeMillis());
                c.d("P5", "token request count is max:" + this.b).d("con_err_code", "P5").e();
                d.a = -1;
                k80.S(this.a).Z();
            }
        }
    }

    @Override // com.repackage.t80.a
    public void onResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            t70.h(this.a).g(601110).d("P3", "accessToken success").d("con_err_code", "P3");
            this.b = -1;
            k(0);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, observable, obj) == null) && (obj instanceof c80)) {
            d.a = ((c80) obj).a;
            b90.a("LCPClientManager", "Manager update connectState :" + d.a);
        }
    }
}

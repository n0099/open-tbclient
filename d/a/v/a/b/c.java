package d.a.v.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.ResponseCode;
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
import d.a.v.a.a.d;
import d.a.v.a.a.g;
import d.a.v.a.f.b;
import d.a.v.a.h.e;
import d.a.v.a.h.f;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public class c implements b.a, Observer {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile d.a.v.a.b.b f68344h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile c f68345i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f68346e;

    /* renamed from: f  reason: collision with root package name */
    public int f68347f;

    /* renamed from: g  reason: collision with root package name */
    public b f68348g;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c this$0;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f68349e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f68349e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f68349e.this$0.e("netchange");
                }
            }
        }

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                e.a("LCPClientManager", "NetStatusReceiver changed");
                if (RequsetNetworkUtils.isNetworkAvailable(context) && f.m(context)) {
                    e.b("LCPClientManager", "NetStatusReceiver reconnect");
                    d.a.v.a.g.a.a(context).b(new a(this));
                }
            }
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(788845681, "Ld/a/v/a/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(788845681, "Ld/a/v/a/b/c;");
                return;
            }
        }
        f68344h = new d.a.v.a.b.b();
        new LinkedHashMap();
    }

    public c() {
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
        this.f68347f = -1;
        new LinkedBlockingQueue();
    }

    public static synchronized c f() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (c.class) {
                if (f68345i == null) {
                    synchronized (c.class) {
                        if (f68345i == null) {
                            f68345i = new c();
                        }
                    }
                }
                cVar = f68345i;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public static int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f68344h.f68343a : invokeV.intValue;
    }

    @Override // d.a.v.a.f.b.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            d.a.v.a.a.a.h(this.f68346e).g(601110).d("P3", "accessToken success").d("con_err_code", "P3");
            this.f68347f = -1;
            l(0);
        }
    }

    public void c(Context context, String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, Integer.valueOf(i2), str3}) == null) {
            if (f68344h.f68343a != -2 && f68344h.f68343a != 0) {
                if (!TextUtils.isEmpty(str3) && UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE.equals(str3)) {
                    d.h(context).f();
                }
                d(context, str, str2, i2, str3);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("SocketConnect state is ");
            sb.append(f68344h.f68343a == 0 ? "connected" : "connecting");
            e.a("LCPClientManager", sb.toString());
        }
    }

    public synchronized void d(Context context, String str, String str2, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, str2, Integer.valueOf(i2), str3}) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && RequsetNetworkUtils.isConnected(context)) {
                    this.f68346e = context;
                    if (TextUtils.isEmpty(f.b(context))) {
                        f.q(context, str);
                    }
                    if (TextUtils.isEmpty(f.e(context))) {
                        f.s(context, str2);
                    }
                    d.a.v.a.c.f.S(context).addObserver(f68345i);
                    if (f68344h.f68343a != -2 && f68344h.f68343a != 0) {
                        if (this.f68348g == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                            b bVar = new b(this, null);
                            this.f68348g = bVar;
                            context.registerReceiver(bVar, intentFilter);
                        }
                        if (g.f(context) && !d.i().booleanValue()) {
                            d.h(context).e(context, String.valueOf(601110), 10);
                            g.m(context, i2);
                        }
                        if (!f.k(context)) {
                            if (this.f68347f < 0) {
                                d.a.v.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3).c("token_begin", System.currentTimeMillis());
                                m();
                            }
                            return;
                        }
                        e.b("LCPClientManager", "token is not null ");
                        d.a.v.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("source", str3);
                        l(0);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("SocketConnect state is ");
                    sb.append(f68344h.f68343a == 0 ? "connected" : "connecting");
                    e.a("LCPClientManager", sb.toString());
                    return;
                }
                e.a("LCPClientManager", "flow 参数错误、网络错误无法连接 增加打点");
                d.a.v.a.a.a.h(context).b(601110).c("flow_start_time", System.currentTimeMillis()).d("P0", "connect param not correct or net unconnected").d("con_err_code", "P0").c("flow_end_time", System.currentTimeMillis()).d("source", str3).e();
            }
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            Context context = this.f68346e;
            c(context, f.b(context), f.e(this.f68346e), g.c(this.f68346e), str);
        }
    }

    public void h(@NonNull BLCPRequest bLCPRequest, @Nullable d.a.v.a.b.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bLCPRequest, bVar) == null) {
            Context context = this.f68346e;
            if (context == null || !f.m(context)) {
                if (bVar != null) {
                    bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6438a, bLCPRequest.f6439b, bLCPRequest.f6441d, new byte[0]);
                }
            } else if (f68344h.f68343a != 0) {
                if (!(bLCPRequest instanceof d.a.v.a.b.d.a) && bVar != null) {
                    bVar.onResponse(ResponseCode.LCP_STATE_CONNECTING, "unconnected", bLCPRequest.f6438a, bLCPRequest.f6439b, bLCPRequest.f6441d, new byte[0]);
                }
                if (f68344h.f68343a == -1 || !k()) {
                    e("invoke");
                }
            } else {
                d.a.v.a.c.f.S(this.f68346e).H(bLCPRequest, bVar);
                if (bLCPRequest.f6439b == 1 && bLCPRequest.f6438a == 4) {
                    e.a("LCPClientManager", "云控登录打点");
                    Context context2 = this.f68346e;
                    d.a.v.a.h.b.a(context2, 1L, "invoke", bLCPRequest.f6441d + "");
                }
                if (bLCPRequest.f6439b == 50 && bLCPRequest.f6438a == 2) {
                    Context context3 = this.f68346e;
                    d.a.v.a.h.b.a(context3, 50L, "invoke", bLCPRequest.f6441d + "");
                }
            }
        }
    }

    public void i() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (context = this.f68346e) == null) {
            return;
        }
        d.a.v.a.c.f.S(context).b0();
    }

    public void j(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, context) == null) || context == null) {
            return;
        }
        this.f68346e = context;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Context context = this.f68346e;
            return context == null || d.a.v.a.c.f.S(context).R().f68343a != -1;
        }
        return invokeV.booleanValue;
    }

    public final void l(int i2) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (context = this.f68346e) != null && f.m(context)) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                e.a("LCPClientManager", "socketAction closeSocket");
                d.a.v.a.c.f.S(this.f68346e).i0("socketAction closeSocket:", d.a.v.a.c.f.S(this.f68346e).x);
                return;
            }
            e.a("LCPClientManager", "socketAction createSocket");
            f68344h.f68343a = -2;
            d.a.v.a.a.a.h(this.f68346e).g(601110).d("P8", "socketAction createSocket").d("con_err_code", "P8");
            d.a.v.a.c.f.S(this.f68346e).h0();
        }
    }

    public void m() {
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Context context2 = this.f68346e;
            if (context2 != null && RequsetNetworkUtils.isConnected(context2)) {
                this.f68347f++;
                d.a.v.a.a.a.h(this.f68346e).g(601110).b("token_count", this.f68347f);
                e.a("LCPClientManager", "no token, so request token, and tryCount = " + this.f68347f);
                if (this.f68347f < 3) {
                    d.a.v.a.f.b bVar = new d.a.v.a.f.b(this.f68346e, this);
                    d.a.v.a.f.c.e(bVar, bVar);
                    return;
                }
                this.f68347f = -1;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("context = ");
            sb.append(this.f68346e);
            sb.append(", net :");
            sb.append(this.f68346e == null ? "" : Boolean.valueOf(!RequsetNetworkUtils.isConnected(context)));
            e.a("LCPClientManager", sb.toString());
            d.a.v.a.a.a.h(this.f68346e).g(601110).d("P1", "token request net unconnected").d("con_err_code", "P1").c("flow_end_time", System.currentTimeMillis()).e();
        }
    }

    @Override // d.a.v.a.f.b.a
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, str) == null) {
            e.b("LCPClientManager", "getToken :" + str);
            d.a.v.a.a.c g2 = d.a.v.a.a.a.h(this.f68346e).g(601110);
            g2.d("P4", "getToken errCode:" + i2 + ",errMsg:" + str).d("con_err_code", "P4");
            m();
            if (this.f68347f == 2) {
                d.a.v.a.a.c c2 = d.a.v.a.a.a.h(this.f68346e).g(601110).c("flow_end_time", System.currentTimeMillis());
                c2.d("P5", "token request count is max:" + this.f68347f).d("con_err_code", "P5").e();
                f68344h.f68343a = -1;
                d.a.v.a.c.f.S(this.f68346e).Z();
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, observable, obj) == null) && (obj instanceof d.a.v.a.b.b)) {
            f68344h.f68343a = ((d.a.v.a.b.b) obj).f68343a;
            e.a("LCPClientManager", "Manager update connectState :" + f68344h.f68343a);
        }
    }
}

package com.sdk.y;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.api.CallBack;
import com.sdk.f.f;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.p.f;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes10.dex */
public class f<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.y.f";
    public static Boolean b;
    public static ConnectivityManager.NetworkCallback c;
    public transient /* synthetic */ FieldHolder $fh;
    public CallBack<T> d;
    public Context e;
    public f<T>.a f;
    public com.sdk.a.e g;
    public int h;
    public URL i;
    public ConnectivityManager j;
    public HttpURLConnection k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1592601158, "Lcom/sdk/y/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1592601158, "Lcom/sdk/y/f;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.f.f.a);
    }

    public List a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (!nextElement.isVirtual() && nextElement.isUp()) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (nextElement2 != null && ((nextElement2 instanceof Inet4Address) || (nextElement2 instanceof Inet6Address))) {
                                arrayList.add(nextElement2.getHostAddress());
                            }
                        }
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Handler a;
        public long b;
        public final /* synthetic */ f c;

        public a(f fVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fVar;
            this.a = new Handler(Looper.getMainLooper());
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.g != null) {
                    com.sdk.o.a.c(f.a, "超时，已取消请求", f.b);
                    this.c.g.a();
                }
                this.c.a(1, "超时", 101005, null, com.sdk.o.b.a().c);
            }
        }
    }

    public f(Context context, int i, CallBack<T> callBack) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), callBack};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = callBack;
        this.e = context;
        i = i <= 0 ? 30 : i;
        this.h = i;
        f<T>.a aVar = new a(this, i * 1000);
        this.f = aVar;
        aVar.a.postDelayed(aVar, aVar.b);
        com.sdk.o.b.b();
    }

    @SuppressLint({"NewApi", "WrongConstant"})
    public void a(int i) {
        boolean z;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            try {
                String a2 = com.sdk.b.a.a(this.e, i, f.b.b.a());
                if (com.sdk.o.a.b(a2).booleanValue()) {
                    a(0, "成功", 100, com.sdk.b.a.a(a2), com.sdk.b.a.b(a2));
                } else if (!com.sdk.r.b.a(this.e)) {
                    a(1, 201001, "操作频繁请,稍后再试");
                } else {
                    this.j = (ConnectivityManager) this.e.getSystemService("connectivity");
                    StringBuilder sb = new StringBuilder();
                    sb.append(f.a.a.a());
                    sb.append("/dro/netm/v1.0/qc");
                    try {
                        this.i = new URL(sb.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        builder.addCapability(12);
                        builder.addTransportType(0);
                        NetworkRequest build = builder.build();
                        b bVar = new b(this, i);
                        c = bVar;
                        if (this.j != null) {
                            this.j.requestNetwork(build, bVar);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        while (true) {
                            if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                httpURLConnection = this.k;
                                if (httpURLConnection != null) {
                                    break;
                                }
                            } else {
                                httpURLConnection = null;
                                break;
                            }
                        }
                        if (httpURLConnection == null) {
                            a(1, 102001, "选择流量通道失败");
                        }
                    }
                }
            } catch (Exception unused) {
                String a3 = com.sdk.b.a.a(this.e, 0, f.b.b.a());
                if (com.sdk.o.a.b(a3).booleanValue()) {
                    a(0, "成功", 100, com.sdk.b.a.a(a3), com.sdk.b.a.b(a3));
                } else if (!com.sdk.r.b.a(this.e)) {
                    a(1, 201001, "操作频繁请,稍后再试");
                } else {
                    this.g = new com.sdk.x.a().a(this.e, 0, a(), new c(this, 0));
                }
            }
        }
    }

    public final void a(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, str) == null) {
            try {
                String str2 = com.sdk.o.b.a().c;
                if (com.sdk.o.a.a(str2).booleanValue()) {
                    str2 = com.sdk.r.a.a(20);
                }
                if (this.f != null) {
                    f<T>.a aVar = this.f;
                    aVar.a.removeCallbacks(aVar);
                }
                if (this.d != null) {
                    this.d.onFailed(i, i2, str, str2);
                    this.d = null;
                }
                UiOauthManager.getInstance(this.e).unregisterNetworkCallback();
                com.sdk.u.a.a();
            } catch (Exception unused) {
                String str3 = com.sdk.o.b.a().c;
                if (com.sdk.o.a.a(str3).booleanValue()) {
                    str3 = com.sdk.r.a.a(20);
                }
                f<T>.a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.a.removeCallbacks(aVar2);
                }
                CallBack<T> callBack = this.d;
                if (callBack != null) {
                    callBack.onFailed(i, i2, str, str3);
                    this.d = null;
                }
                com.sdk.u.a.a();
            }
        }
    }

    public final void a(int i, String str, int i2, T t, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), t, str2}) == null) {
            try {
                if (com.sdk.o.a.a(str2).booleanValue()) {
                    str2 = com.sdk.r.a.a(20);
                }
                if (this.f != null) {
                    f<T>.a aVar = this.f;
                    aVar.a.removeCallbacks(aVar);
                }
                if (this.d != null) {
                    this.d.onSuccess(i, str, i2, t, str2);
                    this.d = null;
                }
                UiOauthManager.getInstance(this.e).unregisterNetworkCallback();
                com.sdk.u.a.a();
            } catch (Exception unused) {
                if (com.sdk.o.a.a(str2).booleanValue()) {
                    str2 = com.sdk.r.a.a(20);
                }
                String str3 = str2;
                f<T>.a aVar2 = this.f;
                if (aVar2 != null) {
                    aVar2.a.removeCallbacks(aVar2);
                }
                CallBack<T> callBack = this.d;
                if (callBack != null) {
                    callBack.onSuccess(i, str, i2, t, str3);
                    this.d = null;
                }
                com.sdk.u.a.a();
            }
        }
    }
}

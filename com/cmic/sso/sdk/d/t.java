package com.cmic.sso.sdk.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static t f32856a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectivityManager f32857b;

    /* renamed from: c  reason: collision with root package name */
    public Network f32858c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f32859d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f32860e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f32861f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(Network network);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436819496, "Lcom/cmic/sso/sdk/d/t;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436819496, "Lcom/cmic/sso/sdk/d/t;");
        }
    }

    public t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32861f = false;
        this.f32857b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            int indexOf = str.indexOf("://");
            if (indexOf > 0) {
                str = str.substring(indexOf + 3);
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0) {
                str = str.substring(0, indexOf2);
            }
            int indexOf3 = str.indexOf(47);
            if (indexOf3 >= 0) {
                str = str.substring(0, indexOf3);
            }
            int indexOf4 = str.indexOf(63);
            return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
        }
        return (String) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    this.f32861f = false;
                    this.f32857b.stopUsingNetworkFeature(0, "enableHIPRI");
                    return;
                }
                if (this.f32857b != null && this.f32859d != null) {
                    this.f32857b.unregisterNetworkCallback(this.f32859d);
                    this.f32859d = null;
                    this.f32858c = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.f32858c != null;
            }
            return this.f32861f;
        }
        return invokeV.booleanValue;
    }

    public static t a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (f32856a == null) {
                synchronized (t.class) {
                    if (f32856a == null) {
                        f32856a = new t(context);
                    }
                }
            }
            return f32856a;
        }
        return (t) invokeL.objValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            try {
                InetAddress byName = InetAddress.getByName(str);
                if (byName != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("lookupHost inetAddress ");
                    sb.append(byName.toString());
                    c.b("WifiNetworkUtils", sb.toString());
                }
                byte[] address = byName.getAddress();
                return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
            } catch (UnknownHostException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @TargetApi(21)
    public void a(a aVar) {
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        Network network = this.f32858c;
        if (network != null && !this.f32860e && (networkInfo = this.f32857b.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            Log.e("HttpUtils", "reuse network: ");
            aVar.a(this.f32858c);
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f32859d;
        if (networkCallback != null) {
            try {
                this.f32857b.unregisterNetworkCallback(networkCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f32859d = null;
            }
            Log.e("HttpUtils", "clear: ");
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback(this, aVar) { // from class: com.cmic.sso.sdk.d.t.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f32862a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ t f32863b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32863b = this;
                this.f32862a = aVar;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, network2) == null) {
                    this.f32863b.f32858c = network2;
                    this.f32862a.a(network2);
                    this.f32863b.f32860e = false;
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network2) == null) {
                    this.f32863b.f32860e = true;
                }
            }
        };
        this.f32859d = networkCallback2;
        this.f32857b.requestNetwork(build, networkCallback2);
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f32857b.startUsingNetworkFeature(0, "enableHIPRI");
            for (int i2 = 0; i2 < 30; i2++) {
                try {
                    if (this.f32857b.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                        break;
                    }
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    c.a("WifiNetworkUtils", "check hipri failed");
                }
            }
            this.f32861f = this.f32857b.requestRouteToHost(5, b(c(str)));
            c.a("WifiNetworkUtils", "切换数据网络结果 >>> " + this.f32861f);
            return this.f32861f;
        }
        return invokeL.booleanValue;
    }

    public String a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i2)) == null) {
            try {
                return (this.f32858c == null || Build.VERSION.SDK_INT < 21) ? "" : this.f32858c.getSocketFactory().createSocket(str, i2).getLocalAddress().getHostAddress();
            } catch (Exception unused) {
                c.a("WifiNetworkUtils", "获取eip失败");
                return "";
            }
        }
        return (String) invokeLI.objValue;
    }
}

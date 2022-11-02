package com.cmic.sso.sdk.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static r a;
    public transient /* synthetic */ FieldHolder $fh;
    public ConnectivityManager b;
    public Network c;
    public ConnectivityManager.NetworkCallback d;
    public boolean e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(Network network);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1436789767, "Lcom/cmic/sso/sdk/e/r;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1436789767, "Lcom/cmic/sso/sdk/e/r;");
        }
    }

    public r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.b = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static r a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (a == null) {
                synchronized (r.class) {
                    if (a == null) {
                        a = new r(context);
                    }
                }
            }
            return a;
        }
        return (r) invokeL.objValue;
    }

    @TargetApi(21)
    public synchronized void a(a aVar) {
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            synchronized (this) {
                ConnectivityManager connectivityManager = this.b;
                if (connectivityManager == null) {
                    c.a("WifiNetworkUtils", "mConnectivityManager 为空");
                    aVar.a(null);
                    return;
                }
                Network network = this.c;
                if (network != null && !this.e && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                    Log.e("HttpUtils", "reuse network: ");
                    aVar.a(this.c);
                    return;
                }
                ConnectivityManager.NetworkCallback networkCallback = this.d;
                if (networkCallback != null) {
                    try {
                        this.b.unregisterNetworkCallback(networkCallback);
                    } catch (Exception e) {
                        e.printStackTrace();
                        this.d = null;
                    }
                    Log.e("HttpUtils", "clear: ");
                }
                NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback(this, aVar) { // from class: com.cmic.sso.sdk.e.r.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;
                    public final /* synthetic */ r b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.b = this;
                        this.a = aVar;
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, network2) == null) {
                            try {
                                if (!this.b.b.getNetworkCapabilities(network2).hasTransport(0)) {
                                    c.a("WifiNetworkUtils", "切换失败，未开启数据网络");
                                    this.b.c = null;
                                    this.a.a(null);
                                    this.b.b.unregisterNetworkCallback(this.b.d);
                                } else {
                                    this.b.c = network2;
                                    this.a.a(network2);
                                    this.b.e = false;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                this.b.c = null;
                                this.a.a(null);
                            }
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLost(Network network2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, network2) != null) {
                            return;
                        }
                        this.b.e = true;
                    }
                };
                this.d = networkCallback2;
                try {
                    this.b.requestNetwork(build, networkCallback2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    aVar.a(null);
                }
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT < 21 || this.c == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (connectivityManager = this.b) == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 21 || this.d == null) {
                return;
            }
            connectivityManager.unregisterNetworkCallback(this.d);
            this.d = null;
            this.c = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

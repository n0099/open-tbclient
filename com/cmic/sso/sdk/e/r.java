package com.cmic.sso.sdk.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
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

    /* loaded from: classes7.dex */
    public interface a {
        void a(Network network, ConnectivityManager.NetworkCallback networkCallback);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
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

    public void a(ConnectivityManager.NetworkCallback networkCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, networkCallback) != null) || this.b == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 21 || networkCallback == null) {
                return;
            }
            c.b("WifiNetworkUtils", "unregisterNetworkCallback");
            this.b.unregisterNetworkCallback(networkCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(21)
    public synchronized void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            synchronized (this) {
                if (this.b == null) {
                    c.a("WifiNetworkUtils", "mConnectivityManager 为空");
                    aVar.a(null, null);
                    return;
                }
                NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(this, aVar) { // from class: com.cmic.sso.sdk.e.r.1
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
                    public void onAvailable(Network network) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                            try {
                                if (this.b.b.getNetworkCapabilities(network).hasTransport(0)) {
                                    this.a.a(network, this);
                                } else {
                                    c.a("WifiNetworkUtils", "切换失败，未开启数据网络");
                                    this.a.a(null, this);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                this.a.a(null, this);
                            }
                        }
                    }
                };
                try {
                    this.b.requestNetwork(build, networkCallback);
                } catch (Exception e) {
                    e.printStackTrace();
                    aVar.a(null, networkCallback);
                }
            }
        }
    }
}

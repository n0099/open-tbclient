package com.sdk.mobile.manager.login.cucc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.j.a;
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
public class ConnectionChangeReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ConnectionChangeReceiver";
    public transient /* synthetic */ FieldHolder $fh;
    public ConnectivityManager.NetworkCallback networkcallback;
    public URL url2;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1097138471, "Lcom/sdk/mobile/manager/login/cucc/ConnectionChangeReceiver;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1097138471, "Lcom/sdk/mobile/manager/login/cucc/ConnectionChangeReceiver;");
        }
    }

    public ConnectionChangeReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void getip(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (Build.VERSION.SDK_INT >= 9 && !nextElement.isVirtual() && nextElement.isUp()) {
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
            String str = TAG;
            Log.d(str, "onAvailable: list" + arrayList);
        }
    }

    public void getstongip(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    str = "网络已断开！";
                } else {
                    if (Build.VERSION.SDK_INT >= 21) {
                        ArrayList arrayList = new ArrayList();
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        builder.addCapability(12);
                        builder.addTransportType(0);
                        NetworkRequest build = builder.build();
                        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(this, arrayList) { // from class: com.sdk.mobile.manager.login.cucc.ConnectionChangeReceiver.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ConnectionChangeReceiver this$0;
                            public final /* synthetic */ List val$list;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, arrayList};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$list = arrayList;
                            }

                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, network) == null) {
                                    try {
                                        HttpURLConnection httpURLConnection = (HttpURLConnection) network.openConnection(this.this$0.url2);
                                        String str2 = ConnectionChangeReceiver.TAG;
                                        Log.d(str2, "onAvailable: " + network.openConnection(this.this$0.url2));
                                        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                                        while (networkInterfaces.hasMoreElements()) {
                                            NetworkInterface nextElement = networkInterfaces.nextElement();
                                            if (!nextElement.isVirtual() && nextElement.isUp()) {
                                                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                                                while (inetAddresses.hasMoreElements()) {
                                                    InetAddress nextElement2 = inetAddresses.nextElement();
                                                    if (nextElement2 != null && ((nextElement2 instanceof Inet4Address) || (nextElement2 instanceof Inet6Address))) {
                                                        this.val$list.add(nextElement2.getHostAddress());
                                                    }
                                                }
                                            }
                                        }
                                        String str3 = ConnectionChangeReceiver.TAG;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("onAvailable: list");
                                        sb.append(this.val$list);
                                        Log.d(str3, sb.toString());
                                    } catch (Exception e) {
                                        String str4 = ConnectionChangeReceiver.TAG;
                                        Log.d(str4, "onAvailable: " + e);
                                    }
                                }
                            }
                        };
                        this.networkcallback = networkCallback;
                        connectivityManager.requestNetwork(build, networkCallback);
                    }
                    str = "网络已连接！";
                }
                Log.d(str, "");
            } catch (Exception unused) {
                getip(context);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
            try {
                if (a.a() <= 23) {
                    getip(context);
                } else {
                    getstongip(context);
                }
            } catch (Exception e) {
                String str = TAG;
                Log.d(str, "onReceive Exception: " + e);
            }
        }
    }
}

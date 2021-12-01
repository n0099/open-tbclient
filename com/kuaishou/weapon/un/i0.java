package com.kuaishou.weapon.un;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public i0() {
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

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces != null) {
                    Iterator it = Collections.list(networkInterfaces).iterator();
                    while (it.hasNext()) {
                        NetworkInterface networkInterface = (NetworkInterface) it.next();
                        if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName()))) {
                            return 1;
                        }
                    }
                    return 0;
                }
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static JSONObject a(Context context) {
        int port;
        String str;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 14) {
                    str = System.getProperty("http.proxyHost");
                    String property = System.getProperty("http.proxyPort");
                    if (property == null) {
                        property = "-1";
                    }
                    port = Integer.parseInt(property);
                } else {
                    String host = Proxy.getHost(context);
                    port = Proxy.getPort(context);
                    str = host;
                }
                if (TextUtils.isEmpty(str) || port == -1) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("h", str);
                jSONObject.put("p", port);
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}

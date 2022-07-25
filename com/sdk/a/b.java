package com.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
@SuppressLint({"NewApi"})
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.a.b";
    public static Boolean b;
    public static Network c;
    public static boolean d;
    public static ConnectivityManager.NetworkCallback e;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpURLConnection f;
    public ConnectivityManager g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593316266, "Lcom/sdk/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593316266, "Lcom/sdk/a/b;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.f.g.b);
    }

    public b() {
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

    public b(Context context, URL url) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, url};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            if (c != null && !d) {
                try {
                    this.f = (HttpURLConnection) c.openConnection(url);
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            d = false;
            a aVar = new a(this, url);
            e = aVar;
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            ConnectivityManager connectivityManager = this.g;
            if (connectivityManager != null) {
                connectivityManager.requestNetwork(build, aVar);
            }
        } catch (Exception e2) {
            com.sdk.n.a.a(a, e2.toString(), b);
        }
    }

    public HttpURLConnection a() {
        InterceptResult invokeV;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                    return null;
                }
                httpURLConnection = this.f;
            } while (httpURLConnection == null);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeV.objValue;
    }
}

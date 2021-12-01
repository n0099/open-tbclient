package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.URL;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.base.framework.a.a";

    /* renamed from: b  reason: collision with root package name */
    public static Boolean f60892b;

    /* renamed from: d  reason: collision with root package name */
    public static ConnectivityManager.NetworkCallback f60893d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public HttpURLConnection f60894c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040379608, "Lcom/sdk/base/framework/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040379608, "Lcom/sdk/base/framework/a/a;");
                return;
            }
        }
        f60892b = Boolean.valueOf(com.sdk.base.framework.c.f.f60988b);
    }

    public a(Context context, URL url) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, url};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            NetworkRequest build = builder.build();
            b bVar = new b(this, url);
            f60893d = bVar;
            ((ConnectivityManager) context.getSystemService("connectivity")).requestNetwork(build, bVar);
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(a, e2.toString(), f60892b);
        }
    }

    public final HttpURLConnection a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = new c(this, 2000L);
            while (!cVar.a()) {
                HttpURLConnection httpURLConnection = this.f60894c;
                if (httpURLConnection != null) {
                    return httpURLConnection;
                }
            }
            return null;
        }
        return (HttpURLConnection) invokeV.objValue;
    }
}

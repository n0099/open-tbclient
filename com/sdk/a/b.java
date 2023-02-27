package com.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
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
        b = Boolean.valueOf(com.sdk.f.f.a);
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
        this.g = (ConnectivityManager) context.getApplicationContext().getApplicationContext().getSystemService("connectivity");
        try {
            if (c == null || d) {
                d = false;
                a aVar = new a(this, url);
                e = aVar;
                a(aVar, context, url);
                return;
            }
            try {
                this.f = (HttpURLConnection) c.openConnection(url);
            } catch (IOException unused) {
                String str = a;
                StringBuilder sb = new StringBuilder();
                sb.append("CellularConnection: ");
                sb.append(this.f);
                Log.d(str, sb.toString());
            }
        } catch (Exception e2) {
            com.sdk.o.a.a(a, e2.toString(), b);
        }
    }

    public HttpURLConnection a() {
        InterceptResult invokeV;
        boolean z;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            do {
                if (System.currentTimeMillis() - currentTimeMillis > 2000) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    httpURLConnection = this.f;
                } else {
                    return null;
                }
            } while (httpURLConnection == null);
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ConnectivityManager.NetworkCallback networkCallback, Context context, URL url) {
        boolean z;
        TelephonyManager telephonyManager;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkCallback, context, url) == null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                declaredMethod = telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (declaredMethod != null) {
                z = ((Boolean) declaredMethod.invoke(telephonyManager, new Object[0])).booleanValue();
                if (!z) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        NetworkRequest.Builder builder = new NetworkRequest.Builder();
                        builder.addCapability(12);
                        builder.addTransportType(0);
                        this.g.requestNetwork(builder.build(), networkCallback);
                        return;
                    }
                    return;
                }
                Log.d(a, "移动网络不可用,请打开移动网络 1");
                return;
            }
            z = false;
            if (!z) {
            }
        }
    }
}

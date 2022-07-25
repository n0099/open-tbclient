package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Proxy;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String e = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public h0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";
        this.b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";
        this.c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";
        this.d = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";
    }

    private void a(JSONObject jSONObject, int i) {
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, jSONObject, i) == null) {
            try {
                Object a2 = Build.VERSION.SDK_INT >= 26 ? h3.a(new String(d.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2)), "IActivityManagerSingleton") : h3.a(new String(d.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2)), "gDefault");
                if (a2 == null || (a = h3.a("android.util.Singleton", a2, "get", new Object[0])) == null) {
                    return;
                }
                a(a, jSONObject, i);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    private boolean a(Object obj, JSONObject jSONObject, int i) {
        InterceptResult invokeLLI;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, obj, jSONObject, i)) == null) {
            if (jSONObject != null) {
                try {
                    boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                    String name = obj.getClass().getName();
                    if (!isProxyClass) {
                        if (i == 3 && !name.contains("Instrumentation")) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(i);
                            jSONObject.put(sb2.toString(), isProxyClass ? 1 : 0);
                            sb = new StringBuilder();
                            sb.append(i);
                            sb.append("-c");
                        }
                        return isProxyClass;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i);
                    jSONObject.put(sb3.toString(), isProxyClass ? 1 : 0);
                    sb = new StringBuilder();
                    sb.append(i);
                    sb.append("-c");
                    jSONObject.put(sb.toString(), name);
                    return isProxyClass;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    private void b(JSONObject jSONObject, int i) {
        Object a;
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, jSONObject, i) == null) {
            try {
                if (Build.VERSION.SDK_INT < 29 || (a = h3.a(new String(d.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(d.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (a2 = h3.a("android.util.Singleton", a, "get", new Object[0])) == null) {
                    return;
                }
                a(a2, jSONObject, i);
            } catch (Exception unused) {
            }
        }
    }

    private void c(JSONObject jSONObject, int i) {
        Object a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, i) == null) {
            try {
                Object a2 = h3.a(new String(d.a(e.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
                if (a2 == null || (a = h3.a(a2.getClass(), a2, "mInstrumentation")) == null) {
                    return;
                }
                a(a, jSONObject, i);
            } catch (Exception unused) {
            }
        }
    }

    private void d(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, jSONObject, i) == null) {
            try {
                Object a = h3.a(new String(d.a(e.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
                if (a != null) {
                    a(a, jSONObject, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                d(jSONObject, 0);
                a(jSONObject, 1);
                b(jSONObject, 2);
                c(jSONObject, 3);
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                PackageManager packageManager = context.getPackageManager();
                Object a = h3.a(packageManager.getClass(), packageManager, "mPM");
                if (a != null) {
                    if (a(a, jSONObject, 0)) {
                        return jSONObject;
                    }
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}

package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Proxy;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ah {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public ah() {
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
        this.b = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";
        this.c = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";
        this.d = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";
        this.e = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                b(jSONObject, 0);
                a(jSONObject, 1);
                c(jSONObject, 2);
                d(jSONObject, 3);
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

    private void a(JSONObject jSONObject, int i) {
        Object a2;
        Object a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, jSONObject, i) == null) {
            try {
                String str = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2));
                String str2 = new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2));
                if (Build.VERSION.SDK_INT >= 26) {
                    a2 = dh.a(str, "IActivityManagerSingleton");
                } else {
                    a2 = dh.a(str2, "gDefault");
                }
                if (a2 != null && (a3 = dh.a("android.util.Singleton", a2, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, new Object[0])) != null) {
                    a(a3, jSONObject, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void c(JSONObject jSONObject, int i) {
        Object a2;
        Object a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, i) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 29 && (a2 = dh.a(new String(c.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(c.a("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) != null && (a3 = dh.a("android.util.Singleton", a2, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, new Object[0])) != null) {
                    a(a3, jSONObject, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 int)] */
    private boolean a(Object obj, JSONObject jSONObject, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, this, obj, jSONObject, i)) == null) {
            if (jSONObject != null) {
                try {
                    boolean isProxyClass = Proxy.isProxyClass(obj.getClass());
                    String name = obj.getClass().getName();
                    int i2 = 1;
                    if (isProxyClass) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(i);
                        String sb2 = sb.toString();
                        if (!isProxyClass) {
                            i2 = 0;
                        }
                        jSONObject.put(sb2, i2);
                        jSONObject.put(i + "-c", name);
                    } else if (i == 3 && !name.contains("Instrumentation")) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i);
                        String sb4 = sb3.toString();
                        if (!isProxyClass) {
                            i2 = 0;
                        }
                        jSONObject.put(sb4, i2);
                        jSONObject.put(i + "-c", name);
                    }
                    return isProxyClass;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    private void b(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, jSONObject, i) == null) {
            try {
                Object a2 = dh.a(new String(c.a(a.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
                if (a2 != null) {
                    a(a2, jSONObject, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void d(JSONObject jSONObject, int i) {
        Object a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, jSONObject, i) == null) {
            try {
                Object a3 = dh.a(new String(c.a(a.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
                if (a3 != null && (a2 = dh.a(a3.getClass(), a3, "mInstrumentation")) != null) {
                    a(a2, jSONObject, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                PackageManager packageManager = context.getPackageManager();
                Object a2 = dh.a(packageManager.getClass(), packageManager, "mPM");
                if (a2 != null) {
                    if (a(a2, jSONObject, 0)) {
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

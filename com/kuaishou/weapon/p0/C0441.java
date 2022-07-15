package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Proxy;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ᵔ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0441 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final String f620 = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public final String f621;

    /* renamed from: ʼ  reason: contains not printable characters */
    public final String f622;

    /* renamed from: ʽ  reason: contains not printable characters */
    public final String f623;

    /* renamed from: ʾ  reason: contains not printable characters */
    public final String f624;

    public C0441() {
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
        this.f621 = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy";
        this.f622 = "YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl";
        this.f623 = "YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==";
        this.f624 = "SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=";
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m941(JSONObject jSONObject, int i) {
        Object m431;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, this, jSONObject, i) == null) {
            try {
                Object m432 = Build.VERSION.SDK_INT >= 26 ? C0376.m432(new String(C0446.m974("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2Vy".getBytes(), 2)), "IActivityManagerSingleton") : C0376.m432(new String(C0446.m974("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyTmF0aXZl".getBytes(), 2)), "gDefault");
                if (m432 == null || (m431 = C0376.m431("android.util.Singleton", m432, SharedPreferenceManager.OPERATION_GET_PERFIX, new Object[0])) == null) {
                    return;
                }
                m942(m431, jSONObject, i);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v0 int)] */
    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m942(Object obj, JSONObject jSONObject, int i) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m943(JSONObject jSONObject, int i) {
        Object m432;
        Object m431;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65539, this, jSONObject, i) == null) {
            try {
                if (Build.VERSION.SDK_INT < 29 || (m432 = C0376.m432(new String(C0446.m974("YW5kcm9pZC5hcHAuQWN0aXZpdHlUYXNrTWFuYWdlcg==".getBytes(), 2)), new String(C0446.m974("SUFjdGl2aXR5VGFza01hbmFnZXJTaW5nbGV0b24=".getBytes(), 2)))) == null || (m431 = C0376.m431("android.util.Singleton", m432, SharedPreferenceManager.OPERATION_GET_PERFIX, new Object[0])) == null) {
                    return;
                }
                m942(m431, jSONObject, i);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m944(JSONObject jSONObject, int i) {
        Object m429;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, jSONObject, i) == null) {
            try {
                Object m431 = C0376.m431(new String(C0446.m974(f620.getBytes(), 2)), (Object) null, "currentActivityThread", new Object[0]);
                if (m431 == null || (m429 = C0376.m429(m431.getClass(), m431, "mInstrumentation")) == null) {
                    return;
                }
                m942(m429, jSONObject, i);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private void m945(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, this, jSONObject, i) == null) {
            try {
                Object m431 = C0376.m431(new String(C0446.m974(f620.getBytes(), 2)), (Object) null, "getPackageManager", new Object[0]);
                if (m431 != null) {
                    m942(m431, jSONObject, i);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m946() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                m945(jSONObject, 0);
                m941(jSONObject, 1);
                m943(jSONObject, 2);
                m944(jSONObject, 3);
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m947(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                PackageManager packageManager = context.getPackageManager();
                Object m429 = C0376.m429(packageManager.getClass(), packageManager, "mPM");
                if (m429 != null) {
                    if (m942(m429, jSONObject, 0)) {
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

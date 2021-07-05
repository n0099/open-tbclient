package d.a.q0.a.m2.c;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49434a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f49435b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(905107447, "Ld/a/q0/a/m2/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(905107447, "Ld/a/q0/a/m2/c/a;");
                return;
            }
        }
        f49434a = k.f49133a;
    }

    public static synchronized JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f49435b != null) {
                    if (f49434a) {
                        Log.d("SwanCoreConfigHelper", "return cache obj : " + f49435b.toString());
                    }
                    return f49435b;
                }
                JSONObject rawSwitch = d.a.q0.a.c1.a.Z().getRawSwitch();
                if (rawSwitch == null) {
                    f49435b = new JSONObject();
                    if (f49434a) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    return f49435b;
                }
                Iterator<String> keys = rawSwitch.keys();
                while (keys.hasNext()) {
                    if (!keys.next().startsWith("swanswitch")) {
                        keys.remove();
                    }
                }
                f49435b = rawSwitch;
                if (f49434a) {
                    Log.d("SwanCoreConfigHelper", "return new obj : " + f49435b.toString());
                }
                return f49435b;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("abTestSwitch", a());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            synchronized (a.class) {
                if (f49434a) {
                    Log.d("SwanCoreConfigHelper", "release cache ab obj ");
                }
                f49435b = null;
            }
        }
    }
}

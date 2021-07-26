package d.a.o0.a.m2.c;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46636a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f46637b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(646942009, "Ld/a/o0/a/m2/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(646942009, "Ld/a/o0/a/m2/c/a;");
                return;
            }
        }
        f46636a = k.f46335a;
    }

    public static synchronized JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a.class) {
                if (f46637b != null) {
                    if (f46636a) {
                        Log.d("SwanCoreConfigHelper", "return cache obj : " + f46637b.toString());
                    }
                    return f46637b;
                }
                JSONObject rawSwitch = d.a.o0.a.c1.a.Z().getRawSwitch();
                if (rawSwitch == null) {
                    f46637b = new JSONObject();
                    if (f46636a) {
                        Log.d("SwanCoreConfigHelper", "raw switch is null, return empty obj");
                    }
                    return f46637b;
                }
                Iterator<String> keys = rawSwitch.keys();
                while (keys.hasNext()) {
                    if (!keys.next().startsWith("swanswitch")) {
                        keys.remove();
                    }
                }
                f46637b = rawSwitch;
                if (f46636a) {
                    Log.d("SwanCoreConfigHelper", "return new obj : " + f46637b.toString());
                }
                return f46637b;
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
                if (f46636a) {
                    Log.d("SwanCoreConfigHelper", "release cache ab obj ");
                }
                f46637b = null;
            }
        }
    }
}

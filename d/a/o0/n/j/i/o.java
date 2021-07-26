package d.a.o0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f51288a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-131337183, "Ld/a/o0/n/j/i/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-131337183, "Ld/a/o0/n/j/i/o;");
        }
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            int i2 = 5;
            if (c() <= 0) {
                return 5;
            }
            String string = d.a.o0.n.c.b().j().getString("expire_time", "");
            if (TextUtils.isEmpty(string)) {
                return 5;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                i2 = jSONObject.optInt("time", 5);
                JSONObject optJSONObject = jSONObject.optJSONObject("appkeys");
                if (optJSONObject == null) {
                    return i2;
                }
                int optInt = optJSONObject.optInt(str, -1);
                return optInt < 0 ? i2 : optInt;
            } catch (JSONException e2) {
                if (d.a.o0.n.c.f51112a) {
                    e2.printStackTrace();
                }
                return i2;
            }
        }
        return invokeL.intValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TimeUnit.HOURS.toMillis(a(str)) : invokeL.longValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f51288a < 0) {
                d.a.o0.n.c.b().C("swan_update_expired_time", 0);
                f51288a = 0;
            }
            return f51288a;
        }
        return invokeV.intValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.a.o0.n.c.b().j().getString("expire_time_version", "0") : (String) invokeV.objValue;
    }

    public static void e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (d.a.o0.n.c.f51112a) {
            Log.d("UpdateExpireTimeManager", "processUpdateExpireTime: data" + jSONObject);
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        d.a.o0.n.c.b().j().putString("expire_time_version", optString);
        d.a.o0.n.c.b().j().putString("expire_time", optJSONObject.toString());
    }
}

package d.a.q0.a.v2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.JSONUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51432a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(129924414, "Ld/a/q0/a/v2/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(129924414, "Ld/a/q0/a/v2/w;");
                return;
            }
        }
        f51432a = d.a.q0.a.k.f49133a;
    }

    public static <T> T a(JSONObject jSONObject, String str, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jSONObject, str, cls)) == null) {
            if (jSONObject == null) {
                return null;
            }
            T t = (T) jSONObject.opt(str);
            if (cls.isInstance(t)) {
                if (f51432a) {
                    String obj = t.toString();
                    if (((t instanceof JSONObject) || (t instanceof JSONArray)) && obj.length() > 30) {
                        obj = obj.substring(0, 30) + StringHelper.STRING_MORE;
                    }
                    if (f51432a) {
                        Log.d(JSONUtils.TAG, "json: " + str + "=" + obj);
                    }
                }
                return t;
            }
            if (f51432a) {
                if (t == null) {
                    Log.w(JSONUtils.TAG, "Json has no value by name: '" + str + "'!");
                } else {
                    Log.w(JSONUtils.TAG, "Value of '" + str + "' is not a instance of '" + cls.getSimpleName() + "'!");
                }
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static float b(JSONObject jSONObject, String str, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{jSONObject, str, Float.valueOf(f2)})) == null) ? jSONObject == null ? f2 : (float) jSONObject.optDouble(str, f2) : invokeCommon.floatValue;
    }

    public static JSONArray c(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, jSONObject, str)) == null) ? (JSONArray) a(jSONObject, str, JSONArray.class) : (JSONArray) invokeLL.objValue;
    }

    @NonNull
    public static JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (f51432a) {
                    Log.w(JSONUtils.TAG, "JSONObject parsed error!!", e2);
                }
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONArray e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONArray();
            }
            try {
                return new JSONArray(str);
            } catch (JSONException e2) {
                if (f51432a) {
                    Log.w(JSONUtils.TAG, "JSONArray parsed error!!", e2);
                }
                return new JSONArray();
            }
        }
        return (JSONArray) invokeL.objValue;
    }

    public static JSONObject f(JSONObject jSONObject, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject, str, obj)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(str, obj);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLL.objValue;
    }
}

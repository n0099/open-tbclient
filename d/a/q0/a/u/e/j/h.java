package d.a.q0.a.u.e.j;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.common.internal.Sets;
import d.a.q0.a.k;
import d.a.q0.a.v2.d0;
import java.util.List;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51001a;

    /* renamed from: b  reason: collision with root package name */
    public static final Set<String> f51002b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111708331, "Ld/a/q0/a/u/e/j/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111708331, "Ld/a/q0/a/u/e/j/h;");
                return;
            }
        }
        f51001a = k.f49133a;
        f51002b = Sets.newHashSet("localhost", "127.0.0.1");
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return str + "_" + System.currentTimeMillis();
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(@Nullable HttpUrl httpUrl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpUrl)) == null) {
            boolean i2 = d.a.q0.a.b2.a.b.i();
            if (!d.a.q0.a.c1.a.Z().F()) {
                i2 = false;
            }
            if (httpUrl != null) {
                return (!i2 || HttpUrl.defaultPort(httpUrl.scheme()) == httpUrl.port()) && !f51002b.contains(httpUrl.host().toLowerCase());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("cancelTag", str);
                }
            } catch (JSONException e2) {
                if (f51001a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? d0.b() : (String) invokeV.objValue;
    }

    @Nullable
    public static String e(@Nullable String str) {
        InterceptResult invokeL;
        HttpUrl parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
                return null;
            }
            return parse.host();
        }
        return (String) invokeL.objValue;
    }

    public static HttpUrl f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            HttpUrl parse = HttpUrl.parse(str);
            if (d.a.q0.a.a2.d.g().x() == null) {
                if (b(parse)) {
                    return parse;
                }
                return null;
            } else if (d.a.q0.a.u1.a.a.o() || b(parse)) {
                return parse;
            } else {
                return null;
            }
        }
        return (HttpUrl) invokeL.objValue;
    }

    public static JSONObject g(Headers headers) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, headers)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (headers == null) {
                return jSONObject;
            }
            for (String str : headers.names()) {
                if (!TextUtils.isEmpty(str)) {
                    List<String> values = headers.values(str);
                    StringBuilder sb = new StringBuilder();
                    int size = values.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sb.append(values.get(i2));
                        if (i2 == size - 1) {
                            break;
                        }
                        sb.append(",");
                    }
                    jSONObject.put(str, sb.toString());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}

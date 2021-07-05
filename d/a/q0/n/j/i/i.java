package d.a.q0.n.j.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f54071c = "PageTipsManager";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f54072d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f54073a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f54074b;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final i f54075a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2046982251, "Ld/a/q0/n/j/i/i$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2046982251, "Ld/a/q0/n/j/i/i$b;");
                    return;
                }
            }
            f54075a = new i(null);
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends d.a.q0.t.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super("updatecore_node_page_tips");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(569727209, "Ld/a/q0/n/j/i/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(569727209, "Ld/a/q0/n/j/i/i;");
                return;
            }
        }
        f54072d = d.a.q0.n.c.f53910a;
    }

    public /* synthetic */ i(a aVar) {
        this();
    }

    public static i b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f54075a : (i) invokeV.objValue;
    }

    @NonNull
    public static JSONObject f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException e2) {
                if (f54072d) {
                    Log.w(f54071c, "JSONObject parsed error!!", e2);
                }
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void a() {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (map = this.f54074b) == null) {
            return;
        }
        map.clear();
        this.f54074b = null;
    }

    public Map<String, String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Map<String, String> map = this.f54074b;
            if (map == null || map.size() < 1) {
                h();
            }
            return this.f54074b;
        }
        return (Map) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f54073a.getString("version", "0") : (String) invokeV.objValue;
    }

    public final void e(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f54074b = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("tips");
                Map<String, String> map = this.f54074b;
                map.put(next + "_tips", optString);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("button");
                if (optJSONObject2 != null) {
                    String optString2 = optJSONObject2.optString("cmd");
                    if (!TextUtils.isEmpty(optString2)) {
                        Map<String, String> map2 = this.f54074b;
                        map2.put(next + "_btn_cmd", optString2);
                    }
                    String optString3 = optJSONObject2.optString("text");
                    if (!TextUtils.isEmpty(optString3)) {
                        Map<String, String> map3 = this.f54074b;
                        map3.put(next + "_btn_text", optString3);
                    }
                }
            }
        }
    }

    public void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("version");
        if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a();
        e(optJSONObject);
        i(optJSONObject.toString(), optString);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            JSONObject f2 = f(this.f54073a.getString("page_error_tips", ""));
            a();
            e(f2);
        }
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) || str == null || str.isEmpty() || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = this.f54073a.edit();
        edit.clear();
        edit.putString("version", str2);
        edit.putString("page_error_tips", str);
        edit.apply();
        if (f54072d) {
            Log.d(f54071c, "write success");
        }
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54073a = new c();
    }
}

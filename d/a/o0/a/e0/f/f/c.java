package d.a.o0.a.e0.f.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44605h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44606a;

    /* renamed from: b  reason: collision with root package name */
    public String f44607b;

    /* renamed from: c  reason: collision with root package name */
    public String f44608c;

    /* renamed from: d  reason: collision with root package name */
    public String f44609d;

    /* renamed from: e  reason: collision with root package name */
    public String f44610e;

    /* renamed from: f  reason: collision with root package name */
    public String f44611f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f44612g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411121175, "Ld/a/o0/a/e0/f/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1411121175, "Ld/a/o0/a/e0/f/f/c;");
                return;
            }
        }
        f44605h = k.f46335a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static c e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            c cVar = new c();
            try {
                cVar.f44606a = jSONObject.getString("appKey");
                cVar.f44607b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.o0.a.m2.b.h(0) + "&appVersion=" + q0.D();
                cVar.f44608c = jSONObject.getString("wsUrl");
                cVar.f44609d = jSONObject.optString("notInHistory", "1");
                cVar.f44610e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
                cVar.f44611f = jSONObject.optString("slavePreload");
                cVar.f44612g = jSONObject.optJSONArray("hosts");
                return cVar;
            } catch (JSONException unused) {
                if (f44605h) {
                    Log.e("WirelessDebugModel", "DebuggerLaunchAction params is invalid");
                    return null;
                }
                return null;
            }
        }
        return (c) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? b(i2, this.f44607b) : (String) invokeI.objValue;
    }

    public final String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (this.f44612g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f44612g.length()) {
                Uri parse = Uri.parse(str);
                String optString = this.f44612g.optString(i2);
                if (!TextUtils.isEmpty(optString) && parse.getHost() != null) {
                    return str.replace(parse.getHost(), optString);
                }
            }
            return str;
        }
        return (String) invokeIL.objValue;
    }

    public String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? b(i2, this.f44608c) : (String) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.f44606a) || TextUtils.isEmpty(this.f44607b) || TextUtils.isEmpty(this.f44608c) : invokeV.booleanValue;
    }
}

package d.a.n0.a.e0.f.f;

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
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f44101h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44102a;

    /* renamed from: b  reason: collision with root package name */
    public String f44103b;

    /* renamed from: c  reason: collision with root package name */
    public String f44104c;

    /* renamed from: d  reason: collision with root package name */
    public String f44105d;

    /* renamed from: e  reason: collision with root package name */
    public String f44106e;

    /* renamed from: f  reason: collision with root package name */
    public String f44107f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f44108g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1916679800, "Ld/a/n0/a/e0/f/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1916679800, "Ld/a/n0/a/e0/f/f/c;");
                return;
            }
        }
        f44101h = k.f45831a;
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
                cVar.f44102a = jSONObject.getString("appKey");
                cVar.f44103b = jSONObject.getString("appUrl") + "?swanJsVersion=" + d.a.n0.a.m2.b.h(0) + "&appVersion=" + q0.D();
                cVar.f44104c = jSONObject.getString("wsUrl");
                cVar.f44105d = jSONObject.optString("notInHistory", "1");
                cVar.f44106e = jSONObject.optString(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD);
                cVar.f44107f = jSONObject.optString("slavePreload");
                cVar.f44108g = jSONObject.optJSONArray("hosts");
                return cVar;
            } catch (JSONException unused) {
                if (f44101h) {
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
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? b(i2, this.f44103b) : (String) invokeI.objValue;
    }

    public final String b(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str)) == null) {
            if (this.f44108g != null && !TextUtils.isEmpty(str) && i2 >= 0 && i2 < this.f44108g.length()) {
                Uri parse = Uri.parse(str);
                String optString = this.f44108g.optString(i2);
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
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? b(i2, this.f44104c) : (String) invokeI.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? TextUtils.isEmpty(this.f44102a) || TextUtils.isEmpty(this.f44103b) || TextUtils.isEmpty(this.f44104c) : invokeV.booleanValue;
    }
}

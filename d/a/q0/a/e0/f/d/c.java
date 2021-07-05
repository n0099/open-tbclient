package d.a.q0.a.e0.f.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f47310i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f47311a;

    /* renamed from: b  reason: collision with root package name */
    public String f47312b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f47313c;

    /* renamed from: d  reason: collision with root package name */
    public String f47314d;

    /* renamed from: e  reason: collision with root package name */
    public String f47315e;

    /* renamed from: f  reason: collision with root package name */
    public String f47316f;

    /* renamed from: g  reason: collision with root package name */
    public String f47317g;

    /* renamed from: h  reason: collision with root package name */
    public long f47318h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(399944343, "Ld/a/q0/a/e0/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(399944343, "Ld/a/q0/a/e0/f/d/c;");
                return;
            }
        }
        f47310i = k.f49133a;
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

    @NonNull
    public static c c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            c cVar = new c();
            try {
                cVar.f47313c = jSONObject.getJSONArray("host");
                cVar.f47312b = jSONObject.getString("appKey");
                cVar.f47311a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                cVar.f47314d = jSONObject.getString("serverPort");
                cVar.f47316f = jSONObject.getString("wsServerPort");
                Uri.decode(jSONObject.optString("url"));
                cVar.f47317g = jSONObject.optString("notInHistory", "1");
                cVar.f47318h = jSONObject.optLong("coreVersion");
            } catch (JSONException unused) {
                if (f47310i) {
                    Log.e("RemoteDebugModel", "DebuggerLaunchAction params: JSONException");
                }
            }
            return cVar;
        }
        return (c) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            JSONArray jSONArray = this.f47313c;
            return jSONArray == null ? "" : jSONArray.optString(i2);
        }
        return (String) invokeI.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return "http://" + str + ":" + this.f47314d + "/app.zip";
        }
        return (String) invokeL.objValue;
    }
}

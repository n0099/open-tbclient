package d.a.o0.a.e0.f.d;

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
import d.a.o0.a.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f44512i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44513a;

    /* renamed from: b  reason: collision with root package name */
    public String f44514b;

    /* renamed from: c  reason: collision with root package name */
    public JSONArray f44515c;

    /* renamed from: d  reason: collision with root package name */
    public String f44516d;

    /* renamed from: e  reason: collision with root package name */
    public String f44517e;

    /* renamed from: f  reason: collision with root package name */
    public String f44518f;

    /* renamed from: g  reason: collision with root package name */
    public String f44519g;

    /* renamed from: h  reason: collision with root package name */
    public long f44520h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1411061593, "Ld/a/o0/a/e0/f/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1411061593, "Ld/a/o0/a/e0/f/d/c;");
                return;
            }
        }
        f44512i = k.f46335a;
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
                cVar.f44515c = jSONObject.getJSONArray("host");
                cVar.f44514b = jSONObject.getString("appKey");
                cVar.f44513a = jSONObject.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                cVar.f44516d = jSONObject.getString("serverPort");
                cVar.f44518f = jSONObject.getString("wsServerPort");
                Uri.decode(jSONObject.optString("url"));
                cVar.f44519g = jSONObject.optString("notInHistory", "1");
                cVar.f44520h = jSONObject.optLong("coreVersion");
            } catch (JSONException unused) {
                if (f44512i) {
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
            JSONArray jSONArray = this.f44515c;
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
            return "http://" + str + ":" + this.f44516d + "/app.zip";
        }
        return (String) invokeL.objValue;
    }
}

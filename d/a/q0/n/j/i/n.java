package d.a.q0.n.j.i;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile n f54084b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f54085a;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static n b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f54084b == null) {
                synchronized (n.class) {
                    if (f54084b == null) {
                        f54084b = new n();
                    }
                }
            }
            return f54084b;
        }
        return (n) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f54085a)) {
                this.f54085a = d.a.q0.n.c.b().j().getString("extract_js_url", null);
            }
            return this.f54085a;
        }
        return (String) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? d.a.q0.n.c.b().j().getString("tts_node_version", "0") : (String) invokeV.objValue;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            if (d.a.q0.n.c.f53910a) {
                Log.d("TTSConfigManager", WebGLImageLoader.DATA_URL + jSONObject);
            }
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("version");
            if (TextUtils.isEmpty(optString) || (optJSONObject = jSONObject.optJSONObject("data")) == null || !optJSONObject.has("extract_js_url")) {
                return;
            }
            String optString2 = optJSONObject.optString("extract_js_url");
            d.a.q0.n.c.b().j().putString("tts_node_version", optString);
            d.a.q0.n.c.b().j().putString("extract_js_url", optString2);
        }
    }
}

package d.a.n0.n.j.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.node.Node;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.t.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f50751b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f50752a;

    /* loaded from: classes7.dex */
    public static class a extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a() {
            super("updatecore_node_ceres");
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

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50752a = new a();
    }

    public static b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f50751b == null) {
                synchronized (b.class) {
                    if (f50751b == null) {
                        f50751b = new b();
                    }
                }
            }
            return f50751b;
        }
        return (b) invokeV.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50752a.getString("ceres_info", "0") : (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50752a.getString("global_info", "0") : (String) invokeV.objValue;
    }

    public d.a.n0.n.j.h.a d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            if (d.a.n0.n.c.f50608a) {
                Log.d(Node.TAG, "ceres info " + jSONObject.toString());
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("ceres_info");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("global_info");
            if (optJSONObject == null || optJSONObject2 == null) {
                return null;
            }
            String optString = optJSONObject.optString("version");
            JSONArray optJSONArray = optJSONObject.optJSONArray("data");
            if (TextUtils.isEmpty(optString) || optJSONArray == null) {
                return null;
            }
            String optString2 = optJSONObject2.optString("version");
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("data");
            if (TextUtils.isEmpty(optString) || optJSONObject3 == null) {
                return null;
            }
            this.f50752a.edit().putString("ceres_info", optString).putString("global_info", optString2).apply();
            return new d.a.n0.n.j.h.a(optJSONArray, optJSONObject3);
        }
        return (d.a.n0.n.j.h.a) invokeL.objValue;
    }
}

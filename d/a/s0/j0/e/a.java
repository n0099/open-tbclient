package d.a.s0.j0.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.mode.Message;
import d.a.c.e.p.k;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62083a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f62084b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62085c;

    public a() {
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
        this.f62083a = "";
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62083a : (String) invokeV.objValue;
    }

    public HashMap<String, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62084b : (HashMap) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62085c : invokeV.booleanValue;
    }

    public void d(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || (optJSONObject = jSONObject.optJSONObject("data")) == null || (optJSONObject2 = optJSONObject.optJSONObject("hotmonitor")) == null) {
            return;
        }
        this.f62083a = optJSONObject2.optString("link");
        this.f62085c = optJSONObject2.optInt("open", 0) == 1;
        JSONArray optJSONArray = optJSONObject2.optJSONArray("config");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return;
        }
        this.f62084b = new HashMap<>();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
            if (optJSONObject3 != null) {
                String optString = optJSONObject3.optString("event");
                String optString2 = optJSONObject3.optString(Message.RULE);
                if (!k.isEmpty(optString) && !k.isEmpty(optString2)) {
                    this.f62084b.put(optString, optString2);
                }
            }
        }
    }
}

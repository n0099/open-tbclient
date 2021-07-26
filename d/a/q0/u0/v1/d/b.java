package d.a.q0.u0.v1.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final BdUniqueId f64556f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f64557e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(397186959, "Ld/a/q0/u0/v1/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(397186959, "Ld/a/q0/u0/v1/d/b;");
                return;
            }
        }
        f64556f = BdUniqueId.gen();
    }

    public b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("id");
        this.f64557e = jSONObject.optString("user_id");
        jSONObject.optString("forum_id");
        jSONObject.optString(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
        jSONObject.optString("create_time");
        jSONObject.optString("time_passed");
        jSONObject.optString("content");
        jSONObject.optInt("zan_num");
        jSONObject.optInt("is_zan", 0);
        jSONObject.optString("user_name");
        jSONObject.optString("portrait");
    }

    @Override // d.a.d.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f64556f : (BdUniqueId) invokeV.objValue;
    }
}

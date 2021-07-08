package d.a.p0.w2.f0.b;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65919a;

    /* renamed from: b  reason: collision with root package name */
    public double f65920b;

    /* renamed from: c  reason: collision with root package name */
    public double f65921c;

    public e() {
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

    public static e b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            e eVar = new e();
            eVar.f65919a = jSONObject.optString("bottom_picture", "");
            jSONObject.optInt("cover_shadow_switch", 0);
            eVar.f65920b = jSONObject.optDouble("player_width_ratio", 0.0d);
            eVar.f65921c = jSONObject.optDouble("right_margin_ratio", 0.0d);
            jSONObject.optDouble("player_height_clipping_ratio", 0.0d);
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f65919a) : invokeV.booleanValue;
    }
}

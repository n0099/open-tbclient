package d.a.s0.w2.f0.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f69143a;

    /* renamed from: b  reason: collision with root package name */
    public int f69144b;

    /* renamed from: c  reason: collision with root package name */
    public int f69145c;

    /* renamed from: d  reason: collision with root package name */
    public long f69146d;

    public d() {
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

    public static d a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            d dVar = new d();
            dVar.f69143a = jSONObject.optInt("agree_num", -1);
            dVar.f69144b = jSONObject.optInt("share_num", -1);
            dVar.f69145c = jSONObject.optInt("reply_num", -1);
            dVar.f69146d = jSONObject.optLong("time", System.currentTimeMillis());
            return dVar;
        }
        return (d) invokeL.objValue;
    }
}

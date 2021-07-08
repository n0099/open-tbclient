package d.a.n0.h.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f49778a;

    /* renamed from: b  reason: collision with root package name */
    public String f49779b;

    /* renamed from: c  reason: collision with root package name */
    public int f49780c;

    /* renamed from: d  reason: collision with root package name */
    public long f49781d;

    public g() {
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

    public static g a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            g gVar = new g();
            gVar.f49778a = jSONObject.optInt("state");
            gVar.f49779b = jSONObject.optString("msg");
            gVar.f49780c = jSONObject.optInt("switch_open");
            gVar.f49781d = jSONObject.optLong("heartbeat_time");
            return gVar;
        }
        return (g) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "UpUseTimeModel{state=" + this.f49778a + ", limit='" + this.f49779b + "', open=" + this.f49780c + ", interval=" + this.f49781d + '}';
        }
        return (String) invokeV.objValue;
    }
}

package d.a.q0.h3.q0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f58763a;

    /* renamed from: b  reason: collision with root package name */
    public long f58764b;

    /* renamed from: c  reason: collision with root package name */
    public int f58765c;

    /* renamed from: d  reason: collision with root package name */
    public String f58766d;

    /* renamed from: e  reason: collision with root package name */
    public Map<Long, a> f58767e;

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
        this.f58763a = System.currentTimeMillis();
        this.f58767e = new HashMap();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startTime", String.valueOf(this.f58763a));
            jSONObject.put("endTime", String.valueOf(this.f58764b));
            jSONObject.put("errorCode", String.valueOf(this.f58765c));
            jSONObject.put("errorMessage", this.f58766d);
            if (this.f58767e != null) {
                JSONArray jSONArray = new JSONArray();
                for (a aVar : this.f58767e.values()) {
                    jSONArray.put(aVar.a());
                }
                jSONObject.put("imagesData", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}

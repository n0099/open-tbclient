package d.a.o0.h.f0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f50496a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.h.f0.i.d f50497b;

    /* renamed from: c  reason: collision with root package name */
    public int f50498c;

    /* renamed from: d  reason: collision with root package name */
    public long f50499d;

    public a(int i2, d.a.o0.h.f0.i.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50496a = i2;
        this.f50497b = dVar;
        this.f50498c = h.d() ? 20 : 10;
        this.f50499d = System.currentTimeMillis();
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.f50496a);
                jSONObject.put("stage", this.f50498c);
                jSONObject.put("ts", this.f50499d);
                if (this.f50497b != null) {
                    jSONObject.put("msg", this.f50497b.a());
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}

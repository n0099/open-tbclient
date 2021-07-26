package d.a.q0.p2;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.p2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends b.AbstractC1596b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final int f62005d;

    /* renamed from: e  reason: collision with root package name */
    public final String f62006e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, int i3, String str2) {
        super(i2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62005d = i3;
        this.f62006e = str2;
    }

    @Override // d.a.q0.p2.b.AbstractC1596b, d.a.q0.p2.b
    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject a2 = super.a();
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.f62005d != -4399) {
                    jSONObject.put("code", this.f62005d);
                }
                if (!StringUtils.isNull(this.f62006e)) {
                    jSONObject.put("msg", this.f62006e);
                }
                a2.put("ext", jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return a2;
        }
        return (JSONObject) invokeV.objValue;
    }
}

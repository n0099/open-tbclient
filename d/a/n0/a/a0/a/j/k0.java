package d.a.n0.a.a0.a.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class k0 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f43270e;

    /* renamed from: f  reason: collision with root package name */
    public int f43271f;

    /* renamed from: g  reason: collision with root package name */
    public int f43272g;

    /* renamed from: h  reason: collision with root package name */
    public i f43273h;

    public k0(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e(jSONArray);
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i iVar = this.f43273h;
            return iVar != null && iVar.d();
        }
        return invokeV.booleanValue;
    }

    public void e(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 3) {
                    this.f43270e = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(0));
                    this.f43271f = d.a.n0.a.v2.n0.g((float) jSONArray.optDouble(1));
                    this.f43272g = jSONArray.optInt(2);
                    this.f43273h = new i(jSONArray.optJSONArray(3));
                }
            } catch (Exception e2) {
                if (d.a.n0.a.k.f45831a) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

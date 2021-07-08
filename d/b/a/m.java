package d.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class m extends s1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f68802e;

    /* renamed from: f  reason: collision with root package name */
    public final y1 f68803f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, y1 y1Var) {
        super(true, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68802e = context;
        this.f68803f = y1Var;
    }

    @Override // d.b.a.s1
    public boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) this.f68802e.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    z1.g(jSONObject, "carrier", telephonyManager.getNetworkOperatorName());
                    z1.g(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                    z1.g(jSONObject, "udid", this.f68803f.n() ? f0.a(telephonyManager) : this.f68803f.m());
                    return true;
                } catch (Exception e2) {
                    h0.b(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

package d.a.q0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @Override // d.a.q0.a.k2.g.d
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            Bundle bundle = new Bundle();
            b b2 = h.b(cVar.f49204a);
            if (b2 == null) {
                if (d.f49208a) {
                    throw new IllegalArgumentException("illegal sp.");
                }
                return bundle;
            }
            int i2 = cVar.f49205b;
            if (i2 == 1) {
                bundle.putInt("result_value", b2.getInt(cVar.f49206c, Integer.parseInt(cVar.f49207d)));
            } else if (i2 == 2) {
                bundle.putLong("result_value", b2.getLong(cVar.f49206c, Long.parseLong(cVar.f49207d)));
            } else if (i2 == 3) {
                bundle.putBoolean("result_value", b2.getBoolean(cVar.f49206c, Boolean.parseBoolean(cVar.f49207d)));
            } else if (i2 == 4) {
                bundle.putString("result_value", b2.getString(cVar.f49206c, cVar.f49207d));
            } else if (i2 != 5) {
                if (d.f49208a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                bundle.putFloat("result_value", b2.getFloat(cVar.f49206c, Float.parseFloat(cVar.f49207d)));
            }
            if (d.f49208a) {
                Log.d("SwanAppSpDelegation", "Get: " + cVar);
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }
}

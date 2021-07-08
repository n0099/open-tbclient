package d.a.n0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // d.a.n0.a.k2.g.d
    public Bundle a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            b b2 = h.b(cVar.f45902a);
            if (b2 == null) {
                if (!d.f45906a) {
                    return Bundle.EMPTY;
                }
                throw new IllegalArgumentException("illegal sp.");
            }
            int i2 = cVar.f45903b;
            if (i2 == 1) {
                b2.putInt(cVar.f45904c, Integer.parseInt(cVar.f45905d));
            } else if (i2 == 2) {
                b2.putLong(cVar.f45904c, Long.parseLong(cVar.f45905d));
            } else if (i2 == 3) {
                b2.putBoolean(cVar.f45904c, Boolean.parseBoolean(cVar.f45905d));
            } else if (i2 == 4) {
                b2.putString(cVar.f45904c, cVar.f45905d);
            } else if (i2 != 5) {
                if (d.f45906a) {
                    throw new IllegalArgumentException("wrong info params.");
                }
            } else {
                b2.putFloat(cVar.f45904c, Float.parseFloat(cVar.f45905d));
            }
            if (d.f45906a) {
                Log.d("SwanAppSpDelegation", "Put: " + cVar);
            }
            return Bundle.EMPTY;
        }
        return (Bundle) invokeL.objValue;
    }
}

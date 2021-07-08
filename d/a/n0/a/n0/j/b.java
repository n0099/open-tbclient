package d.a.n0.a.n0.j;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.n0.j.g.d;
import d.a.n0.a.n0.j.g.e;
import d.a.n0.a.n0.j.g.f;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @SuppressLint({"SwitchIntDef"})
    public static d.a.n0.a.n0.j.g.b a(@NonNull d.a.n0.a.n0.j.f.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            int i2 = aVar.f46258a;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return new d.a.n0.a.n0.j.g.a(aVar);
                        }
                        return new e(aVar);
                    }
                    return new d.a.n0.a.n0.j.g.c(aVar);
                }
                return new f(aVar);
            }
            return new d(aVar);
        }
        return (d.a.n0.a.n0.j.g.b) invokeL.objValue;
    }
}

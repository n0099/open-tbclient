package d.l.a.e.b.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d.l.a.e.b.g.n f71971a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.l.a.e.b.g.n f71972b;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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

    public static d.l.a.e.b.g.n a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z && d.l.a.e.b.g.e.s()) {
                if (f71972b == null) {
                    synchronized (l.class) {
                        if (f71972b == null) {
                            f71972b = d.l.a.e.b.g.e.t().b();
                        }
                    }
                }
                return f71972b;
            }
            if (f71971a == null) {
                synchronized (l.class) {
                    if (f71971a == null) {
                        f71971a = new o();
                    }
                }
            }
            return f71971a;
        }
        return (d.l.a.e.b.g.n) invokeZ.objValue;
    }
}

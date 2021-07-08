package d.a.p0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.s.c.h;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    public static void b(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, hVar) == null) || hVar == null) {
            return;
        }
        if (hVar.f53105b != 0) {
            d.a.o0.r.d0.b.j().x("app_entrance_nologin", hVar.f53105b + "");
        }
        if (hVar.f53104a == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.a.o0.r.d0.b.j().x("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), hVar.f53104a + "");
    }

    public int a() {
        InterceptResult invokeV;
        String p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccount() == null) {
                p = d.a.o0.r.d0.b.j().p("app_entrance_nologin", "");
            } else {
                d.a.o0.r.d0.b j = d.a.o0.r.d0.b.j();
                p = j.p("app_entrance_" + TbadkCoreApplication.getCurrentAccount(), "");
            }
            int d2 = d.a.c.e.m.b.d(p, 0);
            return (d2 != 1 && d2 == 2) ? 1 : 2;
        }
        return invokeV.intValue;
    }
}

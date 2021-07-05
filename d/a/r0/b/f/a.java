package d.a.r0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    public static void d(List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.a.r0.b.d.c());
        for (d.a.c.k.e.n nVar : list) {
            if (nVar instanceof d.a.r0.r.q.a) {
                d.a.r0.r.q.a aVar = (d.a.r0.r.q.a) nVar;
                for (Map.Entry entry : hashMap.entrySet()) {
                    aVar.setABTest((BdUniqueId) entry.getKey(), (d.a.r0.b.e) entry.getValue());
                }
            }
        }
    }

    public static void e(l... lVarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, lVarArr) == null) || lVarArr == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.a.r0.b.d.c());
        for (l lVar : lVarArr) {
            if (lVar != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    lVar.setABTest((BdUniqueId) entry.getKey(), (d.a.r0.b.e) entry.getValue());
                }
            }
        }
    }

    public abstract ArrayList<String> a();

    public abstract d.a.r0.b.e b();

    public abstract BdUniqueId c();

    public abstract void f(d.a.r0.b.e eVar);
}

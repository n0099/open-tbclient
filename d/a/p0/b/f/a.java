package d.a.p0.b.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
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

    public static void d(List<d.a.d.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.a.p0.b.d.c());
        for (d.a.d.k.e.n nVar : list) {
            if (nVar instanceof d.a.p0.s.q.a) {
                d.a.p0.s.q.a aVar = (d.a.p0.s.q.a) nVar;
                for (Map.Entry entry : hashMap.entrySet()) {
                    aVar.setABTest((BdUniqueId) entry.getKey(), (d.a.p0.b.e) entry.getValue());
                }
            }
        }
    }

    public static void e(n... nVarArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, nVarArr) == null) || nVarArr == null) {
            return;
        }
        HashMap hashMap = new HashMap(d.a.p0.b.d.c());
        for (n nVar : nVarArr) {
            if (nVar != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    nVar.setABTest((BdUniqueId) entry.getKey(), (d.a.p0.b.e) entry.getValue());
                }
            }
        }
    }

    public abstract ArrayList<String> a();

    public abstract d.a.p0.b.e b();

    public abstract BdUniqueId c();

    public abstract void f(d.a.p0.b.e eVar);
}

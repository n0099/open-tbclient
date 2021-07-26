package d.a.s.i;

import com.baidu.helios.ids.gaid.GaidProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s.h.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c implements b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // d.a.s.h.b.a
    public List<d.a.s.h.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new d.a.s.h.c.a());
            arrayList.add(new d.a.s.h.f.a());
            arrayList.add(new GaidProvider());
            arrayList.add(new d.a.s.h.g.a());
            arrayList.add(new d.a.s.h.e.a());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}

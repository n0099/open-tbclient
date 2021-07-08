package d.a.n0.f.i.m;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.c1.c.d;
import d.a.n0.a.c1.c.e;
import d.a.n0.f.i.m.b.c;
import d.a.n0.h.t.b.b;
@Autowired
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Inject(force = false)
    public static d.a.n0.f.i.m.b.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b.a() : (d.a.n0.f.i.m.b.a) invokeV.objValue;
    }

    @Inject
    public static d.a.n0.f.i.m.b.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? d.a() : (d.a.n0.f.i.m.b.b) invokeV.objValue;
    }

    @Inject
    public static c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new e() : (c) invokeV.objValue;
    }
}

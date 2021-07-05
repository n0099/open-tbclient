package d.a.q0.v.i.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;
import d.a.q0.a.p.d.i0;
import d.a.q0.a.y0.g.h.b;
import d.a.q0.v.i.a.c.c;
@Service
/* loaded from: classes8.dex */
public class a implements i0 {
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

    @Override // d.a.q0.a.p.d.i0
    public b a(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, invoker, str)) == null) ? new d.a.q0.v.i.a.b.b() : (b) invokeLL.objValue;
    }

    @Override // d.a.q0.a.p.d.i0
    public d.a.q0.a.y0.k.g.a b(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, invoker, str)) == null) ? new c(invoker, str) : (d.a.q0.a.y0.k.g.a) invokeLL.objValue;
    }

    @Override // d.a.q0.a.p.d.i0
    public d.a.q0.a.y0.k.g.a c(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, invoker, str)) == null) ? new d.a.q0.v.i.a.c.b(invoker, str) : (d.a.q0.a.y0.k.g.a) invokeLL.objValue;
    }

    @Override // d.a.q0.a.p.d.i0
    public d.a.q0.a.y0.g.h.a d(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, invoker, str)) == null) ? new d.a.q0.v.i.a.b.a() : (d.a.q0.a.y0.g.h.a) invokeLL.objValue;
    }

    @Override // d.a.q0.a.p.d.i0
    public d.a.q0.a.y0.f.a e(ZeusPluginFactory.Invoker invoker, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, invoker, str)) == null) ? new d.a.q0.v.k.a(invoker, str) : (d.a.q0.a.y0.f.a) invokeLL.objValue;
    }
}

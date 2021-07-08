package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.l;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class a<IN, OUT> extends l<IN, OUT> {
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

    public abstract String a(b<OUT> bVar, IN in);

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.bytedance.sdk.openadsdk.preload.b.b<OUT> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, in)) == null) {
            String a2 = a(new m(bVar), in);
            l.a aVar = a().get(a2);
            if (aVar != null) {
                List<h> list = aVar.f32098a;
                Object a3 = c.a(list, ((i) bVar).f32091a, this).a((b) in);
                return !a(list) ? a3 : bVar.a((b<OUT>) a3);
            }
            throw new IllegalArgumentException("can not found branch, branch name is：" + a2);
        }
        return invokeLL.objValue;
    }
}

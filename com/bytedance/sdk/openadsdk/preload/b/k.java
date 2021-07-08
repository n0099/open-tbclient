package com.bytedance.sdk.openadsdk.preload.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.i;
/* loaded from: classes5.dex */
public abstract class k<IN, OUT> extends d<IN, OUT> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public IN f32096d;

    public k() {
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

    private Object a(b<OUT> bVar, IN in, Throwable th) throws Throwable {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, bVar, in, th)) == null) {
            while (a(th)) {
                try {
                    return bVar.a((b<OUT>) b());
                } catch (i.a e2) {
                    th = e2.getCause();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw th;
        }
        return invokeLLL.objValue;
    }

    public abstract boolean a(Throwable th);

    @Override // com.bytedance.sdk.openadsdk.preload.b.d
    public final Object a_(b<OUT> bVar, IN in) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, in)) == null) {
            this.f32096d = in;
            try {
                return bVar.a((b<OUT>) b());
            } catch (i.a e2) {
                return a(bVar, in, e2.getCause());
            } catch (Throwable th) {
                return a(bVar, in, th);
            }
        }
        return invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [IN, OUT] */
    public OUT b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32096d : (OUT) invokeV.objValue;
    }

    public final IN g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32096d : (IN) invokeV.objValue;
    }
}

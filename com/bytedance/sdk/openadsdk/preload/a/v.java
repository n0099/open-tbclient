package com.bytedance.sdk.openadsdk.preload.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class v<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v() {
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

    public final v<T> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new v<T>(this) { // from class: com.bytedance.sdk.openadsdk.preload.a.v.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ v f32269a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f32269a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, cVar, t) == null) {
                    if (t == null) {
                        cVar.f();
                    } else {
                        this.f32269a.a(cVar, t);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.preload.a.v
            public T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                    if (aVar.f() == com.bytedance.sdk.openadsdk.preload.a.d.b.f32229i) {
                        aVar.j();
                        return null;
                    }
                    return (T) this.f32269a.b(aVar);
                }
                return (T) invokeL.objValue;
            }
        } : (v) invokeV.objValue;
    }

    public abstract void a(com.bytedance.sdk.openadsdk.preload.a.d.c cVar, T t) throws IOException;

    public abstract T b(com.bytedance.sdk.openadsdk.preload.a.d.a aVar) throws IOException;

    public final l a(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            try {
                com.bytedance.sdk.openadsdk.preload.a.b.a.f fVar = new com.bytedance.sdk.openadsdk.preload.a.b.a.f();
                a(fVar, t);
                return fVar.a();
            } catch (IOException e2) {
                throw new m(e2);
            }
        }
        return (l) invokeL.objValue;
    }
}

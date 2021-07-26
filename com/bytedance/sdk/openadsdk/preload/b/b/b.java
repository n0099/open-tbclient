package com.bytedance.sdk.openadsdk.preload.b.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes5.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<a> f32271a;

    public b(a... aVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f32271a = copyOnWriteArrayList;
        if (aVarArr == null) {
            return;
        }
        copyOnWriteArrayList.addAll(Arrays.asList(aVarArr));
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        this.f32271a.add(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, dVar) == null) {
            for (a aVar : this.f32271a) {
                if (aVar != null) {
                    aVar.b(bVar, dVar);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void c(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, bVar, dVar) == null) {
            for (a aVar : this.f32271a) {
                if (aVar != null) {
                    aVar.c(bVar, dVar);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void f(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, bVar, dVar, th) == null) {
            for (a aVar : this.f32271a) {
                if (aVar != null) {
                    aVar.f(bVar, dVar, th);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
            for (a aVar : this.f32271a) {
                if (aVar != null) {
                    aVar.a(bVar, dVar);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void b(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, bVar, dVar, th) == null) {
            for (a aVar : this.f32271a) {
                if (aVar != null) {
                    aVar.b(bVar, dVar, th);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.b.b.a
    public <T> void a(com.bytedance.sdk.openadsdk.preload.b.b<T> bVar, d dVar, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bVar, dVar, th) == null) {
            for (a aVar : this.f32271a) {
                if (aVar != null) {
                    aVar.a(bVar, dVar, th);
                }
            }
        }
    }
}

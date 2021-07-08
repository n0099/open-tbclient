package com.bytedance.sdk.openadsdk.preload.geckox.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.b.d;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends d<?, ?>>, com.bytedance.sdk.openadsdk.preload.b.b.b> f32202a;

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
                return;
            }
        }
        this.f32202a = new HashMap();
    }

    public void a(Class<? extends d<?, ?>> cls, com.bytedance.sdk.openadsdk.preload.b.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, aVar) == null) {
            synchronized (this.f32202a) {
                com.bytedance.sdk.openadsdk.preload.b.b.b bVar = this.f32202a.get(cls);
                if (bVar == null) {
                    bVar = new com.bytedance.sdk.openadsdk.preload.b.b.b(new com.bytedance.sdk.openadsdk.preload.b.b.a[0]);
                    this.f32202a.put(cls, bVar);
                }
                bVar.a(aVar);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.preload.b.b.a a(Class<? extends d<?, ?>> cls) {
        InterceptResult invokeL;
        com.bytedance.sdk.openadsdk.preload.b.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            synchronized (this.f32202a) {
                bVar = this.f32202a.get(cls);
            }
            return bVar;
        }
        return (com.bytedance.sdk.openadsdk.preload.b.b.a) invokeL.objValue;
    }
}

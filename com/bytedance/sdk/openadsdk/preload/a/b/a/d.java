package com.bytedance.sdk.openadsdk.preload.a.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.a.s;
import com.bytedance.sdk.openadsdk.preload.a.v;
import com.bytedance.sdk.openadsdk.preload.a.w;
/* loaded from: classes9.dex */
public final class d implements w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.preload.a.b.c f68363a;

    public d(com.bytedance.sdk.openadsdk.preload.a.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68363a = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.w
    public <T> v<T> a(com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<T> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, aVar)) == null) {
            com.bytedance.sdk.openadsdk.preload.a.a.b bVar = (com.bytedance.sdk.openadsdk.preload.a.a.b) aVar.a().getAnnotation(com.bytedance.sdk.openadsdk.preload.a.a.b.class);
            if (bVar == null) {
                return null;
            }
            return (v<T>) a(this.f68363a, fVar, aVar, bVar);
        }
        return (v) invokeLL.objValue;
    }

    public v<?> a(com.bytedance.sdk.openadsdk.preload.a.b.c cVar, com.bytedance.sdk.openadsdk.preload.a.f fVar, com.bytedance.sdk.openadsdk.preload.a.c.a<?> aVar, com.bytedance.sdk.openadsdk.preload.a.a.b bVar) {
        InterceptResult invokeLLLL;
        v<?> lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cVar, fVar, aVar, bVar)) == null) {
            Object a2 = cVar.a(com.bytedance.sdk.openadsdk.preload.a.c.a.b(bVar.a())).a();
            if (a2 instanceof v) {
                lVar = (v) a2;
            } else if (a2 instanceof w) {
                lVar = ((w) a2).a(fVar, aVar);
            } else {
                boolean z = a2 instanceof s;
                if (!z && !(a2 instanceof com.bytedance.sdk.openadsdk.preload.a.k)) {
                    throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                }
                lVar = new l<>(z ? (s) a2 : null, a2 instanceof com.bytedance.sdk.openadsdk.preload.a.k ? (com.bytedance.sdk.openadsdk.preload.a.k) a2 : null, fVar, aVar, null);
            }
            return (lVar == null || !bVar.b()) ? lVar : lVar.a();
        }
        return (v) invokeLLLL.objValue;
    }
}

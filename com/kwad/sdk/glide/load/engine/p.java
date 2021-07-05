package com.kwad.sdk.glide.load.engine;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, j<?>> f38146a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<com.kwad.sdk.glide.load.c, j<?>> f38147b;

    public p() {
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
        this.f38146a = new HashMap();
        this.f38147b = new HashMap();
    }

    private Map<com.kwad.sdk.glide.load.c, j<?>> a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, this, z)) == null) ? z ? this.f38147b : this.f38146a : (Map) invokeZ.objValue;
    }

    public j<?> a(com.kwad.sdk.glide.load.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, cVar, z)) == null) ? a(z).get(cVar) : (j) invokeLZ.objValue;
    }

    public void a(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, jVar) == null) {
            a(jVar.a()).put(cVar, jVar);
        }
    }

    public void b(com.kwad.sdk.glide.load.c cVar, j<?> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, jVar) == null) {
            Map<com.kwad.sdk.glide.load.c, j<?>> a2 = a(jVar.a());
            if (jVar.equals(a2.get(cVar))) {
                a2.remove(cVar);
            }
        }
    }
}

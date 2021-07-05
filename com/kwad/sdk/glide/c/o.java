package com.kwad.sdk.glide.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes7.dex */
public final class o implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<com.kwad.sdk.glide.request.a.j<?>> f37663a;

    public o() {
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
        this.f37663a = Collections.newSetFromMap(new WeakHashMap());
    }

    @NonNull
    public List<com.kwad.sdk.glide.request.a.j<?>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwad.sdk.glide.g.k.a(this.f37663a) : (List) invokeV.objValue;
    }

    public void a(@NonNull com.kwad.sdk.glide.request.a.j<?> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
            this.f37663a.add(jVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f37663a.clear();
        }
    }

    public void b(@NonNull com.kwad.sdk.glide.request.a.j<?> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
            this.f37663a.remove(jVar);
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (com.kwad.sdk.glide.request.a.j jVar : com.kwad.sdk.glide.g.k.a(this.f37663a)) {
                jVar.c();
            }
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (com.kwad.sdk.glide.request.a.j jVar : com.kwad.sdk.glide.g.k.a(this.f37663a)) {
                jVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (com.kwad.sdk.glide.request.a.j jVar : com.kwad.sdk.glide.g.k.a(this.f37663a)) {
                jVar.e();
            }
        }
    }
}

package com.kwad.sdk.glide.load.engine.a;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.a.h;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.glide.g.g<com.kwad.sdk.glide.load.c, s<?>> implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h.a f37977a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g.g
    public int a(@Nullable s<?> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVar)) == null) ? sVar == null ? super.a((g) null) : sVar.c() : invokeL.intValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    @Nullable
    public /* synthetic */ s a(@NonNull com.kwad.sdk.glide.load.c cVar) {
        return (s) super.c(cVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 >= 40) {
                a();
            } else if (i2 >= 20 || i2 == 15) {
                a(b() / 2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.g.g
    public void a(@NonNull com.kwad.sdk.glide.load.c cVar, @Nullable s<?> sVar) {
        h.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, cVar, sVar) == null) || (aVar = this.f37977a) == null || sVar == null) {
            return;
        }
        aVar.b(sVar);
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    public void a(@NonNull h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.f37977a = aVar;
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.a.h
    @Nullable
    public /* bridge */ /* synthetic */ s b(@NonNull com.kwad.sdk.glide.load.c cVar, @Nullable s sVar) {
        return (s) super.b((g) cVar, (com.kwad.sdk.glide.load.c) sVar);
    }
}

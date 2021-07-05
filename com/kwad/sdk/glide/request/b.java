package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class b implements c, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f38353a;

    /* renamed from: b  reason: collision with root package name */
    public c f38354b;

    /* renamed from: c  reason: collision with root package name */
    public c f38355c;

    public b(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38353a = dVar;
    }

    private boolean g(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cVar)) == null) ? cVar.equals(this.f38354b) || (this.f38354b.g() && cVar.equals(this.f38355c)) : invokeL.booleanValue;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            d dVar = this.f38353a;
            return dVar == null || dVar.b(this);
        }
        return invokeV.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            d dVar = this.f38353a;
            return dVar == null || dVar.d(this);
        }
        return invokeV.booleanValue;
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            d dVar = this.f38353a;
            return dVar == null || dVar.c(this);
        }
        return invokeV.booleanValue;
    }

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            d dVar = this.f38353a;
            return dVar != null && dVar.i();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f38354b.c()) {
            return;
        }
        this.f38354b.a();
    }

    public void a(c cVar, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2) == null) {
            this.f38354b = cVar;
            this.f38355c = cVar2;
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (cVar instanceof b) {
                b bVar = (b) cVar;
                return this.f38354b.a(bVar.f38354b) && this.f38355c.a(bVar.f38355c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38354b.b();
            if (this.f38355c.c()) {
                this.f38355c.b();
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) ? j() && g(cVar) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (this.f38354b.g() ? this.f38355c : this.f38354b).c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) ? l() && g(cVar) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) ? k() && g(cVar) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || (dVar = this.f38353a) == null) {
            return;
        }
        dVar.e(this);
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (this.f38354b.g() ? this.f38355c : this.f38354b).e();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (this.f38354b.g() ? this.f38355c : this.f38354b).e_();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            if (!cVar.equals(this.f38355c)) {
                if (this.f38355c.c()) {
                    return;
                }
                this.f38355c.a();
                return;
            }
            d dVar = this.f38353a;
            if (dVar != null) {
                dVar.f(this);
            }
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (this.f38354b.g() ? this.f38355c : this.f38354b).f();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38354b.g() && this.f38355c.g() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f38354b.h();
            this.f38355c.h();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? m() || e() : invokeV.booleanValue;
    }
}

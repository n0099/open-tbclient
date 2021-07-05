package com.kwad.sdk.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h implements c, d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final d f38358a;

    /* renamed from: b  reason: collision with root package name */
    public c f38359b;

    /* renamed from: c  reason: collision with root package name */
    public c f38360c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f38361d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    public h() {
        this(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((d) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38358a = dVar;
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            d dVar = this.f38358a;
            return dVar == null || dVar.b(this);
        }
        return invokeV.booleanValue;
    }

    private boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            d dVar = this.f38358a;
            return dVar == null || dVar.d(this);
        }
        return invokeV.booleanValue;
    }

    private boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, this)) == null) {
            d dVar = this.f38358a;
            return dVar == null || dVar.c(this);
        }
        return invokeV.booleanValue;
    }

    private boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            d dVar = this.f38358a;
            return dVar != null && dVar.i();
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f38361d = true;
            if (!this.f38359b.e_() && !this.f38360c.c()) {
                this.f38360c.a();
            }
            if (!this.f38361d || this.f38359b.c()) {
                return;
            }
            this.f38359b.a();
        }
    }

    public void a(c cVar, c cVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2) == null) {
            this.f38359b = cVar;
            this.f38360c = cVar2;
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            if (cVar instanceof h) {
                h hVar = (h) cVar;
                c cVar2 = this.f38359b;
                if (cVar2 == null) {
                    if (hVar.f38359b != null) {
                        return false;
                    }
                } else if (!cVar2.a(hVar.f38359b)) {
                    return false;
                }
                c cVar3 = this.f38360c;
                c cVar4 = hVar.f38360c;
                if (cVar3 == null) {
                    if (cVar4 != null) {
                        return false;
                    }
                } else if (!cVar3.a(cVar4)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38361d = false;
            this.f38360c.b();
            this.f38359b.b();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean b(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) ? j() && (cVar.equals(this.f38359b) || !this.f38359b.e()) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38359b.c() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean c(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) ? l() && cVar.equals(this.f38359b) && !i() : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean d(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) ? k() && cVar.equals(this.f38359b) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) || cVar.equals(this.f38360c)) {
            return;
        }
        d dVar = this.f38358a;
        if (dVar != null) {
            dVar.e(this);
        }
        if (this.f38360c.e_()) {
            return;
        }
        this.f38360c.b();
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38359b.e() || this.f38360c.e() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean e_() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f38359b.e_() || this.f38360c.e_() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.d
    public void f(c cVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) && cVar.equals(this.f38359b) && (dVar = this.f38358a) != null) {
            dVar.f(this);
        }
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f38359b.f() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38359b.g() : invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.glide.request.c
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f38359b.h();
            this.f38360c.h();
        }
    }

    @Override // com.kwad.sdk.glide.request.d
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? m() || e() : invokeV.booleanValue;
    }
}

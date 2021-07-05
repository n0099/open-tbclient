package com.kwad.sdk.contentalliance.home.a;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes7.dex */
public class j implements i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public b f35079a;

    /* renamed from: b  reason: collision with root package name */
    public b f35080b;

    public j(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35079a = bVar;
        this.f35080b = bVar;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int a(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, adTemplate)) == null) ? this.f35079a.a(adTemplate) : invokeL.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f35080b.a();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f35080b.a(i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(int i2, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, adTemplate) == null) {
            this.f35079a.a(i2, adTemplate);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void a(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.f35080b.a(dVar);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public boolean a(@NonNull b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            b bVar2 = this.f35080b;
            if (bVar2 == bVar) {
                return false;
            }
            bVar2.d();
            this.f35080b = bVar;
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public int b(AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, adTemplate)) == null) ? this.f35080b.a(adTemplate) : invokeL.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f35080b.d();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public void b(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f35080b.b(dVar);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    @NonNull
    public b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f35079a : (b) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.a.i
    public List<AdTemplate> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35080b.b() : (List) invokeV.objValue;
    }
}

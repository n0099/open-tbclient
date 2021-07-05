package com.kwad.sdk.glide.request.a;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class c<T> implements j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f38332a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38333b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.request.c f38334c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (com.kwad.sdk.glide.g.k.a(i2, i3)) {
            this.f38332a = i2;
            this.f38333b = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
            iVar.a(this.f38332a, this.f38333b);
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void a(@Nullable com.kwad.sdk.glide.request.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f38334c = cVar;
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    @Nullable
    public final com.kwad.sdk.glide.request.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38334c : (com.kwad.sdk.glide.request.c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void b(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, drawable) == null) {
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void b(@NonNull i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iVar) == null) {
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public void c(@Nullable Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, drawable) == null) {
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.kwad.sdk.glide.c.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }
}

package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class q implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<BitmapDrawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Resources f38239a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.s<Bitmap> f38240b;

    public q(@NonNull Resources resources, @NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38239a = (Resources) com.kwad.sdk.glide.g.j.a(resources);
        this.f38240b = (com.kwad.sdk.glide.load.engine.s) com.kwad.sdk.glide.g.j.a(sVar);
    }

    @Nullable
    public static com.kwad.sdk.glide.load.engine.s<BitmapDrawable> a(@NonNull Resources resources, @Nullable com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, resources, sVar)) == null) {
            if (sVar == null) {
                return null;
            }
            return new q(resources, sVar);
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<BitmapDrawable> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BitmapDrawable.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.kwad.sdk.glide.load.engine.s<Bitmap> sVar = this.f38240b;
            if (sVar instanceof com.kwad.sdk.glide.load.engine.o) {
                ((com.kwad.sdk.glide.load.engine.o) sVar).b();
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38240b.c() : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38240b.d_();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public BitmapDrawable e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new BitmapDrawable(this.f38239a, this.f38240b.e()) : (BitmapDrawable) invokeV.objValue;
    }
}

package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.glide.load.engine.o, com.kwad.sdk.glide.load.engine.s<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f38211a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f38212b;

    public d(@NonNull Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38211a = (Bitmap) com.kwad.sdk.glide.g.j.a(bitmap, "Bitmap must not be null");
        this.f38212b = (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) com.kwad.sdk.glide.g.j.a(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static d a(@Nullable Bitmap bitmap, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, bitmap, eVar)) == null) {
            if (bitmap == null) {
                return null;
            }
            return new d(bitmap, eVar);
        }
        return (d) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    public Class<Bitmap> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Bitmap.class : (Class) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.o
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f38211a.prepareToDraw();
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.glide.g.k.a(this.f38211a) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38212b.a(this.f38211a);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    @NonNull
    /* renamed from: f */
    public Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f38211a : (Bitmap) invokeV.objValue;
    }
}

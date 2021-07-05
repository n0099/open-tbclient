package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class m implements com.kwad.sdk.glide.load.h<Drawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.h<Bitmap> f38232b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38233c;

    public m(com.kwad.sdk.glide.load.h<Bitmap> hVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38232b = hVar;
        this.f38233c = z;
    }

    private com.kwad.sdk.glide.load.engine.s<Drawable> a(Context context, com.kwad.sdk.glide.load.engine.s<Bitmap> sVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, sVar)) == null) ? q.a(context.getResources(), sVar) : (com.kwad.sdk.glide.load.engine.s) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public com.kwad.sdk.glide.load.engine.s<Drawable> a(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.s<Drawable> sVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, context, sVar, i2, i3)) == null) {
            com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = com.kwad.sdk.glide.c.a(context).a();
            Drawable e2 = sVar.e();
            com.kwad.sdk.glide.load.engine.s<Bitmap> a3 = l.a(a2, e2, i2, i3);
            if (a3 != null) {
                com.kwad.sdk.glide.load.engine.s<Bitmap> a4 = this.f38232b.a(context, a3, i2, i3);
                if (a4.equals(a3)) {
                    a4.d_();
                    return sVar;
                }
                return a(context, a4);
            } else if (this.f38233c) {
                throw new IllegalArgumentException("Unable to convert " + e2 + " to a Bitmap");
            } else {
                return sVar;
            }
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeLLII.objValue;
    }

    public com.kwad.sdk.glide.load.h<BitmapDrawable> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this : (com.kwad.sdk.glide.load.h) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, messageDigest) == null) {
            this.f38232b.a(messageDigest);
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj instanceof m) {
                return this.f38232b.equals(((m) obj).f38232b);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38232b.hashCode() : invokeV.intValue;
    }
}

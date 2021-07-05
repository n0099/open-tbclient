package com.kwad.sdk.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class e implements com.kwad.sdk.glide.load.h<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // com.kwad.sdk.glide.load.h
    @NonNull
    public final com.kwad.sdk.glide.load.engine.s<Bitmap> a(@NonNull Context context, @NonNull com.kwad.sdk.glide.load.engine.s<Bitmap> sVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sVar, i2, i3)) == null) {
            if (!com.kwad.sdk.glide.g.k.a(i2, i3)) {
                throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
            }
            com.kwad.sdk.glide.load.engine.bitmap_recycle.e a2 = com.kwad.sdk.glide.c.a(context).a();
            Bitmap e2 = sVar.e();
            if (i2 == Integer.MIN_VALUE) {
                i2 = e2.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = e2.getHeight();
            }
            Bitmap a3 = a(a2, e2, i2, i3);
            return e2.equals(a3) ? sVar : d.a(a3, a2);
        }
        return (com.kwad.sdk.glide.load.engine.s) invokeLLII.objValue;
    }
}

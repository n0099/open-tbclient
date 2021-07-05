package com.kwad.sdk.support;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.engine.bitmap_recycle.e;
import com.kwad.sdk.glide.load.resource.bitmap.i;
/* loaded from: classes7.dex */
public class a extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // com.kwad.sdk.glide.load.resource.bitmap.i, com.kwad.sdk.glide.load.resource.bitmap.e
    public Bitmap a(@NonNull e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, eVar, bitmap, i2, i3)) == null) ? b.a(eVar, bitmap, i2, i3) : (Bitmap) invokeLLII.objValue;
    }
}

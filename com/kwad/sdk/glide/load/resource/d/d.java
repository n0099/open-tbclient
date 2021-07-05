package com.kwad.sdk.glide.load.resource.d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.kwad.sdk.glide.load.EncodeStrategy;
import com.kwad.sdk.glide.load.engine.s;
import java.io.File;
import java.io.IOException;
/* loaded from: classes7.dex */
public class d implements com.kwad.sdk.glide.load.g<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    @Override // com.kwad.sdk.glide.load.g
    @NonNull
    public EncodeStrategy a(@NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? EncodeStrategy.SOURCE : (EncodeStrategy) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a
    public boolean a(@NonNull s<c> sVar, @NonNull File file, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sVar, file, eVar)) == null) {
            try {
                com.kwad.sdk.glide.g.a.a(sVar.e().c(), file);
                return true;
            } catch (IOException e2) {
                if (Log.isLoggable(GifDrawableEncoder.TAG, 5)) {
                    Log.w(GifDrawableEncoder.TAG, "Failed to encode GIF drawable data", e2);
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}

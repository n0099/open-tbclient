package com.kwad.sdk.glide.webp;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.c.h;
import com.kwad.sdk.glide.c.k;
import com.kwad.sdk.glide.c.l;
import com.kwad.sdk.glide.g;
/* loaded from: classes7.dex */
public final class b implements k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.kwad.sdk.glide.c.k.a
    @NonNull
    public g a(@NonNull com.kwad.sdk.glide.c cVar, @NonNull h hVar, @NonNull l lVar, @NonNull Context context) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, cVar, hVar, lVar, context)) == null) ? new com.kwad.sdk.glide.webp.a.c(cVar, hVar, lVar, context) : (g) invokeLLLL.objValue;
    }
}

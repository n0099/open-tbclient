package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.MessageDigest;
/* loaded from: classes7.dex */
public class i extends e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f38216b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-32649355, "Lcom/kwad/sdk/glide/load/resource/bitmap/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-32649355, "Lcom/kwad/sdk/glide/load/resource/bitmap/i;");
                return;
            }
        }
        f38216b = "com.kwad.sdk.glide.load.resource.bitmap.CircleCrop.1".getBytes(com.kwad.sdk.glide.load.c.f37921a);
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.glide.load.resource.bitmap.e
    public Bitmap a(@NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048576, this, eVar, bitmap, i2, i3)) == null) ? t.d(eVar, bitmap, i2, i3) : (Bitmap) invokeLLII.objValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public void a(@NonNull MessageDigest messageDigest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, messageDigest) == null) {
            messageDigest.update(f38216b);
        }
    }

    @Override // com.kwad.sdk.glide.load.c
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? obj instanceof i : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.glide.load.c
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 768609307;
        }
        return invokeV.intValue;
    }
}

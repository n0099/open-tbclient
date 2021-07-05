package com.facebook.imagepipeline.bitmaps;

import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
/* loaded from: classes6.dex */
public class PlatformBitmapFactoryProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PlatformBitmapFactoryProvider() {
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

    public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory poolFactory, PlatformDecoder platformDecoder, CloseableReferenceFactory closeableReferenceFactory) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, poolFactory, platformDecoder, closeableReferenceFactory)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                return new ArtBitmapFactory(poolFactory.getBitmapPool(), closeableReferenceFactory);
            }
            if (i2 >= 11) {
                return new HoneycombBitmapFactory(new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory()), platformDecoder, closeableReferenceFactory);
            }
            return new GingerbreadBitmapFactory();
        }
        return (PlatformBitmapFactory) invokeLLL.objValue;
    }
}

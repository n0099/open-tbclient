package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.ResourceReleaser;
/* loaded from: classes3.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public static SimpleBitmapReleaser sInstance;
    public transient /* synthetic */ FieldHolder $fh;

    public SimpleBitmapReleaser() {
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

    public static SimpleBitmapReleaser getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                sInstance = new SimpleBitmapReleaser();
            }
            return sInstance;
        }
        return (SimpleBitmapReleaser) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
            bitmap.recycle();
        }
    }
}

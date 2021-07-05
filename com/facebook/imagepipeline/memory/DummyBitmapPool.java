package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.memory.MemoryTrimType;
/* loaded from: classes6.dex */
public class DummyBitmapPool implements BitmapPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DummyBitmapPool() {
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

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, memoryTrimType) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public Bitmap get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565) : (Bitmap) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            bitmap.recycle();
        }
    }
}

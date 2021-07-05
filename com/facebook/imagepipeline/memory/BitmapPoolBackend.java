package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BitmapPoolBackend";
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapPoolBackend() {
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

    public boolean isReusable(@Nullable Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmap)) == null) {
            if (bitmap == null) {
                return false;
            }
            if (bitmap.isRecycled()) {
                FLog.wtf(TAG, "Cannot reuse a recycled bitmap: %s", bitmap);
                return false;
            } else if (bitmap.isMutable()) {
                return true;
            } else {
                FLog.wtf(TAG, "Cannot reuse an immutable bitmap: %s", bitmap);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    @Nullable
    public Bitmap get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Bitmap bitmap = (Bitmap) super.get(i2);
            if (bitmap == null || !isReusable(bitmap)) {
                return null;
            }
            bitmap.eraseColor(0);
            return bitmap;
        }
        return (Bitmap) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.memory.PoolBackend
    public int getSize(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap)) == null) ? BitmapUtil.getSizeInBytes(bitmap) : invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.memory.LruBucketsPoolBackend, com.facebook.imagepipeline.memory.PoolBackend
    public void put(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bitmap) == null) && isReusable(bitmap)) {
            super.put((BitmapPoolBackend) bitmap);
        }
    }
}

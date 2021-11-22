package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes11.dex */
public class BucketsBitmapPool extends BasePool<Bitmap> implements BitmapPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BucketsBitmapPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryTrimmableRegistry, poolParams, poolStatsTracker};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MemoryTrimmableRegistry) objArr2[0], (PoolParams) objArr2[1], (PoolStatsTracker) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        initialize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public Bitmap alloc(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? Bitmap.createBitmap(1, (int) Math.ceil(i2 / 2.0d), Bitmap.Config.RGB_565) : (Bitmap) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            Preconditions.checkNotNull(bitmap);
            bitmap.recycle();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bitmap)) == null) {
            Preconditions.checkNotNull(bitmap);
            return bitmap.getAllocationByteCount();
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    @Nullable
    public Bitmap getValue(Bucket<Bitmap> bucket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bucket)) == null) {
            Bitmap bitmap = (Bitmap) super.getValue((Bucket<Object>) bucket);
            if (bitmap != null) {
                bitmap.eraseColor(0);
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean isReusable(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bitmap)) == null) {
            Preconditions.checkNotNull(bitmap);
            return !bitmap.isRecycled() && bitmap.isMutable();
        }
        return invokeL.booleanValue;
    }
}

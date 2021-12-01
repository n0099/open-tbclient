package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class LruBitmapPool implements BitmapPool {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentSize;
    public int mMaxBitmapSize;
    public final int mMaxPoolSize;
    public final PoolStatsTracker mPoolStatsTracker;
    public final PoolBackend<Bitmap> mStrategy;

    public LruBitmapPool(int i2, int i3, PoolStatsTracker poolStatsTracker, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), poolStatsTracker, memoryTrimmableRegistry};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStrategy = new BitmapPoolBackend();
        this.mMaxPoolSize = i2;
        this.mMaxBitmapSize = i3;
        this.mPoolStatsTracker = poolStatsTracker;
        if (memoryTrimmableRegistry != null) {
            memoryTrimmableRegistry.registerMemoryTrimmable(this);
        }
    }

    @VisibleForTesting
    private Bitmap alloc(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            this.mPoolStatsTracker.onAlloc(i2);
            return Bitmap.createBitmap(1, i2, Bitmap.Config.ALPHA_8);
        }
        return (Bitmap) invokeI.objValue;
    }

    private synchronized void trimTo(int i2) {
        Bitmap pop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, this, i2) == null) {
            synchronized (this) {
                while (this.mCurrentSize > i2 && (pop = this.mStrategy.pop()) != null) {
                    int size = this.mStrategy.getSize(pop);
                    this.mCurrentSize -= size;
                    this.mPoolStatsTracker.onFree(size);
                }
            }
        }
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, memoryTrimType) == null) {
            trimTo((int) (this.mMaxPoolSize * (1.0d - memoryTrimType.getSuggestedTrimRatio())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    public synchronized Bitmap get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            synchronized (this) {
                if (this.mCurrentSize > this.mMaxPoolSize) {
                    trimTo(this.mMaxPoolSize);
                }
                Bitmap bitmap = this.mStrategy.get(i2);
                if (bitmap != null) {
                    int size = this.mStrategy.getSize(bitmap);
                    this.mCurrentSize -= size;
                    this.mPoolStatsTracker.onValueReuse(size);
                    return bitmap;
                }
                return alloc(i2);
            }
        }
        return (Bitmap) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) || (size = this.mStrategy.getSize(bitmap)) > this.mMaxBitmapSize) {
            return;
        }
        this.mPoolStatsTracker.onValueRelease(size);
        this.mStrategy.put(bitmap);
        synchronized (this) {
            this.mCurrentSize += size;
        }
    }
}

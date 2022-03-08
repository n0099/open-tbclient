package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes7.dex */
public class BitmapCounter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public int mCount;
    public final int mMaxCount;
    public final int mMaxSize;
    @GuardedBy("this")
    public long mSize;
    public final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;

    public BitmapCounter(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        this.mMaxCount = i2;
        this.mMaxSize = i3;
        this.mUnpooledBitmapsReleaser = new ResourceReleaser<Bitmap>(this) { // from class: com.facebook.imagepipeline.memory.BitmapCounter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BitmapCounter this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(Bitmap bitmap) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bitmap) == null) {
                    try {
                        this.this$0.decrease(bitmap);
                    } finally {
                        bitmap.recycle();
                    }
                }
            }
        };
    }

    public synchronized void decrease(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
            synchronized (this) {
                int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
                Preconditions.checkArgument(this.mCount > 0, "No bitmaps registered.");
                long j2 = sizeInBytes;
                Preconditions.checkArgument(j2 <= this.mSize, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(sizeInBytes), Long.valueOf(this.mSize));
                this.mSize -= j2;
                this.mCount--;
            }
        }
    }

    public synchronized int getCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i2 = this.mCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i2 = this.mMaxCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxSize() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i2 = this.mMaxSize;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mUnpooledBitmapsReleaser : (ResourceReleaser) invokeV.objValue;
    }

    public synchronized long getSize() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                j2 = this.mSize;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public synchronized boolean increase(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            synchronized (this) {
                int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
                if (this.mCount < this.mMaxCount) {
                    long j2 = sizeInBytes;
                    if (this.mSize + j2 <= this.mMaxSize) {
                        this.mCount++;
                        this.mSize += j2;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

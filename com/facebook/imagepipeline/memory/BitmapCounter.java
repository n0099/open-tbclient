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

    public BitmapCounter(int i, int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(i2 > 0);
        this.mMaxCount = i;
        this.mMaxSize = i2;
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
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
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
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bitmap) == null) {
            synchronized (this) {
                int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
                if (this.mCount > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "No bitmaps registered.");
                long j = sizeInBytes;
                if (j <= this.mSize) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2, "Bitmap size bigger than the total registered size: %d, %d", Integer.valueOf(sizeInBytes), Long.valueOf(this.mSize));
                this.mSize -= j;
                this.mCount--;
            }
        }
    }

    public synchronized int getCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.mCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i = this.mMaxCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i = this.mMaxSize;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public ResourceReleaser<Bitmap> getReleaser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mUnpooledBitmapsReleaser;
        }
        return (ResourceReleaser) invokeV.objValue;
    }

    public synchronized long getSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                j = this.mSize;
            }
            return j;
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
                    long j = sizeInBytes;
                    if (this.mSize + j <= this.mMaxSize) {
                        this.mCount++;
                        this.mSize += j;
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}

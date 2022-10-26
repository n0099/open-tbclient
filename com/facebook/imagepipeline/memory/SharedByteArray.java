package com.facebook.imagepipeline.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;
/* loaded from: classes7.dex */
public class SharedByteArray implements MemoryTrimmable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final OOMSoftReference mByteArraySoftRef;
    public final int mMaxByteArraySize;
    public final int mMinByteArraySize;
    public final ResourceReleaser mResourceReleaser;
    public final Semaphore mSemaphore;

    public SharedByteArray(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryTrimmableRegistry, poolParams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(memoryTrimmableRegistry);
        if (poolParams.minBucketSize > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(poolParams.maxBucketSize >= poolParams.minBucketSize);
        this.mMaxByteArraySize = poolParams.maxBucketSize;
        this.mMinByteArraySize = poolParams.minBucketSize;
        this.mByteArraySoftRef = new OOMSoftReference();
        this.mSemaphore = new Semaphore(1);
        this.mResourceReleaser = new ResourceReleaser(this) { // from class: com.facebook.imagepipeline.memory.SharedByteArray.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SharedByteArray this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(byte[] bArr) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr) == null) {
                    this.this$0.mSemaphore.release();
                }
            }
        };
        memoryTrimmableRegistry.registerMemoryTrimmable(this);
    }

    private synchronized byte[] allocateByteArray(int i) {
        InterceptResult invokeI;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            synchronized (this) {
                this.mByteArraySoftRef.clear();
                bArr = new byte[i];
                this.mByteArraySoftRef.set(bArr);
            }
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    private byte[] getByteArray(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            int bucketedSize = getBucketedSize(i);
            byte[] bArr = (byte[]) this.mByteArraySoftRef.get();
            if (bArr == null || bArr.length < bucketedSize) {
                return allocateByteArray(bucketedSize);
            }
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }

    public int getBucketedSize(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return Integer.highestOneBit(Math.max(i, this.mMinByteArraySize) - 1) * 2;
        }
        return invokeI.intValue;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, memoryTrimType) != null) || !this.mSemaphore.tryAcquire()) {
            return;
        }
        try {
            this.mByteArraySoftRef.clear();
        } finally {
            this.mSemaphore.release();
        }
    }

    public CloseableReference get(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            boolean z2 = true;
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Size must be greater than zero");
            if (i > this.mMaxByteArraySize) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "Requested size is too big");
            this.mSemaphore.acquireUninterruptibly();
            try {
                return CloseableReference.of(getByteArray(i), this.mResourceReleaser);
            } catch (Throwable th) {
                this.mSemaphore.release();
                throw Throwables.propagate(th);
            }
        }
        return (CloseableReference) invokeI.objValue;
    }
}

package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.NotThreadSafe;
/* loaded from: classes7.dex */
public abstract class BasePool<V> implements Pool<V> {
    public static /* synthetic */ Interceptable $ic;
    public static OnFailedListener mOnFailedListener;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<?> TAG;
    public boolean mAllowNewBuckets;
    @VisibleForTesting
    public final SparseArray<Bucket<V>> mBuckets;
    @VisibleForTesting
    @GuardedBy("this")
    public final Counter mFree;
    public boolean mIgnoreHardCap;
    @VisibleForTesting
    public final Set<V> mInUseValues;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final PoolParams mPoolParams;
    public final PoolStatsTracker mPoolStatsTracker;
    @VisibleForTesting
    @GuardedBy("this")
    public final Counter mUsed;

    /* loaded from: classes7.dex */
    public interface OnFailedListener {
        void onFailed();
    }

    public abstract V alloc(int i);

    @VisibleForTesting
    public abstract void free(V v);

    public abstract int getBucketedSize(int i);

    public abstract int getBucketedSizeForValue(V v);

    public abstract int getSizeInBytes(int i);

    public void onParamsChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @VisibleForTesting
    @NotThreadSafe
    /* loaded from: classes7.dex */
    public static class Counter {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        public transient /* synthetic */ FieldHolder $fh;
        public int mCount;
        public int mNumBytes;

        public Counter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mCount = 0;
                this.mNumBytes = 0;
            }
        }

        public void decrement(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                int i3 = this.mNumBytes;
                if (i3 >= i && (i2 = this.mCount) > 0) {
                    this.mCount = i2 - 1;
                    this.mNumBytes = i3 - i;
                    return;
                }
                FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
            }
        }

        public void increment(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.mCount++;
                this.mNumBytes += i;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class InvalidSizeException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidSizeException(Object obj) {
            super("Invalid size: " + obj.toString());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class InvalidValueException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidValueException(Object obj) {
            super("Invalid value: " + obj.toString());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            super("Pool hard cap violation? Hard cap = " + i + " Used size = " + i2 + " Free size = " + i3 + " Request size = " + i4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SizeTooLargeException(Object obj) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryTrimmableRegistry, poolParams, poolStatsTracker};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = getClass();
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        this.mPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new SparseArray<>();
        if (this.mPoolParams.fixBucketsReinitialization) {
            initBuckets();
        } else {
            legacyInitBuckets(new SparseIntArray(0));
        }
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker, boolean z) {
        this(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryTrimmableRegistry, poolParams, poolStatsTracker, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MemoryTrimmableRegistry) objArr2[0], (PoolParams) objArr2[1], (PoolStatsTracker) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIgnoreHardCap = z;
    }

    private synchronized void ensurePoolSizeInvariant() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (isMaxSizeSoftCapExceeded() && this.mFree.mNumBytes != 0) {
                    z = false;
                    Preconditions.checkState(z);
                }
                z = true;
                Preconditions.checkState(z);
            }
        }
    }

    private synchronized void initBuckets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            synchronized (this) {
                SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
                if (sparseIntArray != null) {
                    fillBuckets(sparseIntArray);
                    this.mAllowNewBuckets = false;
                } else {
                    this.mAllowNewBuckets = true;
                }
            }
        }
    }

    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
            this.mPoolStatsTracker.setBasePool(this);
        }
    }

    @VisibleForTesting
    public synchronized boolean isMaxSizeSoftCapExceeded() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                if (this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.mPoolStatsTracker.onSoftCapReached();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @VisibleForTesting
    public synchronized void trimToSoftCap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            synchronized (this) {
                if (isMaxSizeSoftCapExceeded()) {
                    trimToSize(this.mPoolParams.maxSizeSoftCap);
                }
            }
        }
    }

    private void fillBuckets(SparseIntArray sparseIntArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, sparseIntArray) == null) {
            this.mBuckets.clear();
            for (int i = 0; i < sparseIntArray.size(); i++) {
                int keyAt = sparseIntArray.keyAt(i);
                this.mBuckets.put(keyAt, new Bucket<>(getSizeInBytes(keyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
            }
        }
    }

    @VisibleForTesting
    public synchronized Bucket<V> getBucket(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                Bucket<V> bucket = this.mBuckets.get(i);
                if (bucket == null && this.mAllowNewBuckets) {
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(i));
                    }
                    Bucket<V> newBucket = newBucket(i);
                    this.mBuckets.put(i, newBucket);
                    return newBucket;
                }
                return bucket;
            }
        }
        return (Bucket) invokeI.objValue;
    }

    private synchronized Bucket<V> getBucketIfPresent(int i) {
        InterceptResult invokeI;
        Bucket<V> bucket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            synchronized (this) {
                bucket = this.mBuckets.get(i);
            }
            return bucket;
        }
        return (Bucket) invokeI.objValue;
    }

    public static void setOnFailedListener(OnFailedListener onFailedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, onFailedListener) == null) {
            mOnFailedListener = onFailedListener;
        }
    }

    @Nullable
    public synchronized V getValue(Bucket<V> bucket) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bucket)) == null) {
            synchronized (this) {
                v = bucket.get();
            }
            return v;
        }
        return (V) invokeL.objValue;
    }

    public boolean isReusable(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, v)) == null) {
            Preconditions.checkNotNull(v);
            return true;
        }
        return invokeL.booleanValue;
    }

    public Bucket<V> newBucket(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            return new Bucket<>(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
        }
        return (Bucket) invokeI.objValue;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, memoryTrimType) == null) {
            trimToNothing();
        }
    }

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, sparseIntArray) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(sparseIntArray);
                this.mBuckets.clear();
                SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
                if (sparseIntArray2 != null) {
                    for (int i = 0; i < sparseIntArray2.size(); i++) {
                        int keyAt = sparseIntArray2.keyAt(i);
                        this.mBuckets.put(keyAt, new Bucket<>(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mPoolParams.fixBucketsReinitialization));
                    }
                    this.mAllowNewBuckets = false;
                } else {
                    this.mAllowNewBuckets = true;
                }
            }
        }
    }

    @VisibleForTesting
    public synchronized boolean canAllocate(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this) {
                if (this.mIgnoreHardCap) {
                    return true;
                }
                int i2 = this.mPoolParams.maxSizeHardCap;
                if (i > i2 - this.mUsed.mNumBytes) {
                    this.mPoolStatsTracker.onHardCapReached();
                    return false;
                }
                int i3 = this.mPoolParams.maxSizeSoftCap;
                if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
                    trimToSize(i3 - i);
                }
                if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
                    return true;
                }
                this.mPoolStatsTracker.onHardCapReached();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void logStats() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && FLog.isLoggable(2)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    private List<Bucket<V>> refillBuckets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            ArrayList arrayList = new ArrayList(this.mBuckets.size());
            int size = this.mBuckets.size();
            for (int i = 0; i < size; i++) {
                Bucket<V> valueAt = this.mBuckets.valueAt(i);
                int i2 = valueAt.mItemSize;
                int i3 = valueAt.mMaxLength;
                int inUseCount = valueAt.getInUseCount();
                if (valueAt.getFreeListSize() > 0) {
                    arrayList.add(valueAt);
                }
                this.mBuckets.setValueAt(i, new Bucket<>(getSizeInBytes(i2), i3, inUseCount, this.mPoolParams.fixBucketsReinitialization));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private V retryOnce(int i, int i2, boolean z) {
        InterceptResult invokeCommon;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            try {
                V alloc = alloc(i2);
                if (FLog.isLoggable(3)) {
                    FLog.d(this.TAG, "alloc success!!");
                }
                return alloc;
            } catch (Throwable th) {
                if (FLog.isLoggable(3)) {
                    FLog.d(this.TAG, "alloc fail!!");
                }
                if (z && mOnFailedListener != null) {
                    if (FLog.isLoggable(3)) {
                        Class<?> cls = this.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("retryOnce will work.");
                        if (z) {
                            str3 = "retry = true";
                        } else {
                            str3 = "retry = false";
                        }
                        sb.append(str3);
                        if (mOnFailedListener == null) {
                            str4 = ",mOnFailedListener is null";
                        } else {
                            str4 = ",mOnFailedListener is not null";
                        }
                        sb.append(str4);
                        FLog.d(cls, sb.toString());
                    }
                    mOnFailedListener.onFailed();
                    return retryOnce(i, i2, false);
                }
                if (FLog.isLoggable(3)) {
                    Class<?> cls2 = this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("retryOnce won't work.");
                    if (z) {
                        str = "retry = true";
                    } else {
                        str = "retry = false";
                    }
                    sb2.append(str);
                    if (mOnFailedListener == null) {
                        str2 = ",mOnFailedListener is null";
                    } else {
                        str2 = ",mOnFailedListener is not null";
                    }
                    sb2.append(str2);
                    FLog.d(cls2, sb2.toString());
                }
                synchronized (this) {
                    this.mUsed.decrement(i);
                    Bucket<V> bucket = getBucket(i2);
                    if (bucket != null) {
                        bucket.decrementInUseCount();
                    }
                    Throwables.propagateIfPossible(th);
                    return null;
                }
            }
        }
        return (V) invokeCommon.objValue;
    }

    @Override // com.facebook.common.memory.Pool
    public V get(int i) {
        InterceptResult invokeI;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ensurePoolSizeInvariant();
            int bucketedSize = getBucketedSize(i);
            synchronized (this) {
                Bucket<V> bucket = getBucket(bucketedSize);
                if (bucket != null && (value = getValue(bucket)) != null) {
                    Preconditions.checkState(this.mInUseValues.add(value));
                    int bucketedSizeForValue = getBucketedSizeForValue(value);
                    int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
                    this.mUsed.increment(sizeInBytes);
                    this.mFree.decrement(sizeInBytes);
                    this.mPoolStatsTracker.onValueReuse(sizeInBytes);
                    logStats();
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(value)), Integer.valueOf(bucketedSizeForValue));
                    }
                    return value;
                }
                int sizeInBytes2 = getSizeInBytes(bucketedSize);
                if (canAllocate(sizeInBytes2)) {
                    this.mUsed.increment(sizeInBytes2);
                    if (bucket != null) {
                        bucket.incrementInUseCount();
                    }
                    V retryOnce = retryOnce(sizeInBytes2, bucketedSize, true);
                    synchronized (this) {
                        Preconditions.checkState(this.mInUseValues.add(retryOnce));
                        trimToSoftCap();
                        this.mPoolStatsTracker.onAlloc(sizeInBytes2);
                        logStats();
                        if (FLog.isLoggable(2)) {
                            FLog.v(this.TAG, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(retryOnce)), Integer.valueOf(bucketedSize));
                        }
                    }
                    return retryOnce;
                }
                throw new PoolSizeViolationException(this.mPoolParams.maxSizeHardCap, this.mUsed.mNumBytes, this.mFree.mNumBytes, sizeInBytes2);
            }
        }
        return (V) invokeI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
        r2.decrementInUseCount();
     */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, v) == null) {
            Preconditions.checkNotNull(v);
            int bucketedSizeForValue = getBucketedSizeForValue(v);
            int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
            synchronized (this) {
                Bucket<V> bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
                if (!this.mInUseValues.remove(v)) {
                    FLog.e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                    free(v);
                    this.mPoolStatsTracker.onFree(sizeInBytes);
                } else {
                    if (bucketIfPresent != null && !bucketIfPresent.isMaxLengthExceeded() && !isMaxSizeSoftCapExceeded() && isReusable(v)) {
                        bucketIfPresent.release(v);
                        this.mFree.increment(sizeInBytes);
                        this.mUsed.decrement(sizeInBytes);
                        this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                        if (FLog.isLoggable(2)) {
                            FLog.v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                        }
                    }
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                    }
                    free(v);
                    this.mUsed.decrement(sizeInBytes);
                    this.mPoolStatsTracker.onFree(sizeInBytes);
                }
                logStats();
            }
        }
    }

    @VisibleForTesting
    public synchronized void trimToSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            synchronized (this) {
                int min = Math.min((this.mUsed.mNumBytes + this.mFree.mNumBytes) - i, this.mFree.mNumBytes);
                if (min <= 0) {
                    return;
                }
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(min));
                }
                logStats();
                for (int i2 = 0; i2 < this.mBuckets.size() && min > 0; i2++) {
                    Bucket<V> valueAt = this.mBuckets.valueAt(i2);
                    while (min > 0) {
                        V pop = valueAt.pop();
                        if (pop == null) {
                            break;
                        }
                        free(pop);
                        min -= valueAt.mItemSize;
                        this.mFree.decrement(valueAt.mItemSize);
                    }
                }
                logStats();
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
                }
            }
        }
    }

    public synchronized Map<String, Integer> getStats() {
        InterceptResult invokeV;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                hashMap = new HashMap();
                for (int i = 0; i < this.mBuckets.size(); i++) {
                    int keyAt = this.mBuckets.keyAt(i);
                    hashMap.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(keyAt), Integer.valueOf(this.mBuckets.valueAt(i).getInUseCount()));
                }
                hashMap.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
                hashMap.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.mPoolParams.maxSizeHardCap));
                hashMap.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.mUsed.mCount));
                hashMap.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.mUsed.mNumBytes));
                hashMap.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.mFree.mCount));
                hashMap.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.mFree.mNumBytes));
            }
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.facebook.imagepipeline.memory.BasePool<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public void trimToNothing() {
        int i;
        List arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                if (this.mPoolParams.fixBucketsReinitialization) {
                    arrayList = refillBuckets();
                } else {
                    arrayList = new ArrayList(this.mBuckets.size());
                    SparseIntArray sparseIntArray = new SparseIntArray();
                    for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
                        Bucket<V> valueAt = this.mBuckets.valueAt(i2);
                        if (valueAt.getFreeListSize() > 0) {
                            arrayList.add(valueAt);
                        }
                        sparseIntArray.put(this.mBuckets.keyAt(i2), valueAt.getInUseCount());
                    }
                    legacyInitBuckets(sparseIntArray);
                }
                this.mFree.reset();
                logStats();
            }
            onParamsChanged();
            for (i = 0; i < arrayList.size(); i++) {
                Bucket bucket = (Bucket) arrayList.get(i);
                while (true) {
                    Object pop = bucket.pop();
                    if (pop == null) {
                        break;
                    }
                    free(pop);
                }
            }
        }
    }
}

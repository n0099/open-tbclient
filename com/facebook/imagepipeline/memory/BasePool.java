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
/* loaded from: classes3.dex */
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
    @VisibleForTesting
    public final Set<V> mInUseValues;
    public final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    public final PoolParams mPoolParams;
    public final PoolStatsTracker mPoolStatsTracker;
    @VisibleForTesting
    @GuardedBy("this")
    public final Counter mUsed;

    @VisibleForTesting
    @NotThreadSafe
    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void decrement(int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                int i4 = this.mNumBytes;
                if (i4 >= i2 && (i3 = this.mCount) > 0) {
                    this.mCount = i3 - 1;
                    this.mNumBytes = i4 - i2;
                    return;
                }
                FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i2), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
            }
        }

        public void increment(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.mCount++;
                this.mNumBytes += i2;
            }
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.mCount = 0;
                this.mNumBytes = 0;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnFailedListener {
        void onFailed();
    }

    /* loaded from: classes3.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PoolSizeViolationException(int i2, int i3, int i4, int i5) {
            super("Pool hard cap violation? Hard cap = " + i2 + " Used size = " + i3 + " Free size = " + i4 + " Request size = " + i5);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i6 = newInitContext.flag;
                if ((i6 & 1) != 0) {
                    int i7 = i6 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private synchronized void ensurePoolSizeInvariant() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
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

    private void fillBuckets(SparseIntArray sparseIntArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, sparseIntArray) == null) {
            this.mBuckets.clear();
            for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
                int keyAt = sparseIntArray.keyAt(i2);
                this.mBuckets.put(keyAt, new Bucket<>(getSizeInBytes(keyAt), sparseIntArray.valueAt(i2), 0, this.mPoolParams.fixBucketsReinitialization));
            }
        }
    }

    private synchronized Bucket<V> getBucketIfPresent(int i2) {
        InterceptResult invokeI;
        Bucket<V> bucket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) {
            synchronized (this) {
                bucket = this.mBuckets.get(i2);
            }
            return bucket;
        }
        return (Bucket) invokeI.objValue;
    }

    private synchronized void initBuckets() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, sparseIntArray) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(sparseIntArray);
                this.mBuckets.clear();
                SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
                if (sparseIntArray2 != null) {
                    for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
                        int keyAt = sparseIntArray2.keyAt(i2);
                        this.mBuckets.put(keyAt, new Bucket<>(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i2), sparseIntArray.get(keyAt, 0), this.mPoolParams.fixBucketsReinitialization));
                    }
                    this.mAllowNewBuckets = false;
                } else {
                    this.mAllowNewBuckets = true;
                }
            }
        }
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void logStats() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65542, this) == null) && FLog.isLoggable(2)) {
            FLog.v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    private List<Bucket<V>> refillBuckets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            ArrayList arrayList = new ArrayList(this.mBuckets.size());
            int size = this.mBuckets.size();
            for (int i2 = 0; i2 < size; i2++) {
                Bucket<V> valueAt = this.mBuckets.valueAt(i2);
                int i3 = valueAt.mItemSize;
                int i4 = valueAt.mMaxLength;
                int inUseCount = valueAt.getInUseCount();
                if (valueAt.getFreeListSize() > 0) {
                    arrayList.add(valueAt);
                }
                this.mBuckets.setValueAt(i2, new Bucket<>(getSizeInBytes(i3), i4, inUseCount, this.mPoolParams.fixBucketsReinitialization));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private V retryOnce(int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            try {
                V alloc = alloc(i3);
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
                        sb.append(z ? "retry = true" : "retry = false");
                        sb.append(mOnFailedListener == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null");
                        FLog.d(cls, sb.toString());
                    }
                    mOnFailedListener.onFailed();
                    return retryOnce(i2, i3, false);
                }
                if (FLog.isLoggable(3)) {
                    Class<?> cls2 = this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("retryOnce won't work.");
                    sb2.append(z ? "retry = true" : "retry = false");
                    sb2.append(mOnFailedListener == null ? ",mOnFailedListener is null" : ",mOnFailedListener is not null");
                    FLog.d(cls2, sb2.toString());
                }
                synchronized (this) {
                    this.mUsed.decrement(i2);
                    Bucket<V> bucket = getBucket(i3);
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

    public static void setOnFailedListener(OnFailedListener onFailedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, onFailedListener) == null) {
            mOnFailedListener = onFailedListener;
        }
    }

    public abstract V alloc(int i2);

    @VisibleForTesting
    public synchronized boolean canAllocate(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            synchronized (this) {
                int i3 = this.mPoolParams.maxSizeHardCap;
                if (i2 > i3 - this.mUsed.mNumBytes) {
                    this.mPoolStatsTracker.onHardCapReached();
                    return false;
                }
                int i4 = this.mPoolParams.maxSizeSoftCap;
                if (i2 > i4 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
                    trimToSize(i4 - i2);
                }
                if (i2 > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
                    this.mPoolStatsTracker.onHardCapReached();
                    return false;
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    @VisibleForTesting
    public abstract void free(V v);

    @Override // com.facebook.common.memory.Pool
    public V get(int i2) {
        InterceptResult invokeI;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            ensurePoolSizeInvariant();
            int bucketedSize = getBucketedSize(i2);
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

    @VisibleForTesting
    public synchronized Bucket<V> getBucket(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (this) {
                Bucket<V> bucket = this.mBuckets.get(i2);
                if (bucket == null && this.mAllowNewBuckets) {
                    if (FLog.isLoggable(2)) {
                        FLog.v(this.TAG, "creating new bucket %s", Integer.valueOf(i2));
                    }
                    Bucket<V> newBucket = newBucket(i2);
                    this.mBuckets.put(i2, newBucket);
                    return newBucket;
                }
                return bucket;
            }
        }
        return (Bucket) invokeI.objValue;
    }

    public abstract int getBucketedSize(int i2);

    public abstract int getBucketedSizeForValue(V v);

    public abstract int getSizeInBytes(int i2);

    public synchronized Map<String, Integer> getStats() {
        InterceptResult invokeV;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                hashMap = new HashMap();
                for (int i2 = 0; i2 < this.mBuckets.size(); i2++) {
                    int keyAt = this.mBuckets.keyAt(i2);
                    hashMap.put(PoolStatsTracker.BUCKETS_USED_PREFIX + getSizeInBytes(keyAt), Integer.valueOf(this.mBuckets.valueAt(i2).getInUseCount()));
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
                z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
                if (z) {
                    this.mPoolStatsTracker.onSoftCapReached();
                }
            }
            return z;
        }
        return invokeV.booleanValue;
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

    public Bucket<V> newBucket(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? new Bucket<>(getSizeInBytes(i2), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization) : (Bucket) invokeI.objValue;
    }

    public void onParamsChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
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

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, memoryTrimType) == null) {
            trimToNothing();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.facebook.imagepipeline.memory.BasePool<V> */
    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public void trimToNothing() {
        int i2;
        List arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                if (this.mPoolParams.fixBucketsReinitialization) {
                    arrayList = refillBuckets();
                } else {
                    arrayList = new ArrayList(this.mBuckets.size());
                    SparseIntArray sparseIntArray = new SparseIntArray();
                    for (int i3 = 0; i3 < this.mBuckets.size(); i3++) {
                        Bucket<V> valueAt = this.mBuckets.valueAt(i3);
                        if (valueAt.getFreeListSize() > 0) {
                            arrayList.add(valueAt);
                        }
                        sparseIntArray.put(this.mBuckets.keyAt(i3), valueAt.getInUseCount());
                    }
                    legacyInitBuckets(sparseIntArray);
                }
                this.mFree.reset();
                logStats();
            }
            onParamsChanged();
            for (i2 = 0; i2 < arrayList.size(); i2++) {
                Bucket bucket = (Bucket) arrayList.get(i2);
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

    @VisibleForTesting
    public synchronized void trimToSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            synchronized (this) {
                int min = Math.min((this.mUsed.mNumBytes + this.mFree.mNumBytes) - i2, this.mFree.mNumBytes);
                if (min <= 0) {
                    return;
                }
                if (FLog.isLoggable(2)) {
                    FLog.v(this.TAG, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i2), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes), Integer.valueOf(min));
                }
                logStats();
                for (int i3 = 0; i3 < this.mBuckets.size() && min > 0; i3++) {
                    Bucket<V> valueAt = this.mBuckets.valueAt(i3);
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
                    FLog.v(this.TAG, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i2), Integer.valueOf(this.mUsed.mNumBytes + this.mFree.mNumBytes));
                }
            }
        }
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
}

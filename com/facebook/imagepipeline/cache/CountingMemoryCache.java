package com.facebook.imagepipeline.cache;

import android.graphics.Bitmap;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class CountingMemoryCache<K, V> implements MemoryCache<K, V>, MemoryTrimmable {
    public static /* synthetic */ Interceptable $ic;
    @VisibleForTesting
    public static final long PARAMS_INTERCHECK_INTERVAL_MS;
    public transient /* synthetic */ FieldHolder $fh;
    public final CacheTrimStrategy mCacheTrimStrategy;
    @VisibleForTesting
    @GuardedBy("this")
    public final CountingLruMap<K, Entry<K, V>> mCachedEntries;
    @VisibleForTesting
    @GuardedBy("this")
    public final CountingLruMap<K, Entry<K, V>> mExclusiveEntries;
    @GuardedBy("this")
    public long mLastCacheParamsCheck;
    @GuardedBy("this")
    public MemoryCacheParams mMemoryCacheParams;
    public final Supplier<MemoryCacheParams> mMemoryCacheParamsSupplier;
    @VisibleForTesting
    @GuardedBy("this")
    public final Map<Bitmap, Object> mOtherEntries;
    public final ValueDescriptor<V> mValueDescriptor;

    /* loaded from: classes6.dex */
    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    @VisibleForTesting
    /* loaded from: classes6.dex */
    public static class Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int clientCount;
        public boolean isOrphan;
        public final K key;
        @Nullable
        public final EntryStateObserver<K> observer;
        public final CloseableReference<V> valueRef;

        public Entry(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, closeableReference, entryStateObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = (K) Preconditions.checkNotNull(k);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.clientCount = 0;
            this.isOrphan = false;
            this.observer = entryStateObserver;
        }

        @VisibleForTesting
        public static <K, V> Entry<K, V> of(K k, CloseableReference<V> closeableReference, @Nullable EntryStateObserver<K> entryStateObserver) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, k, closeableReference, entryStateObserver)) == null) ? new Entry<>(k, closeableReference, entryStateObserver) : (Entry) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface EntryStateObserver<K> {
        void onExclusivityChanged(K k, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(691692955, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(691692955, "Lcom/facebook/imagepipeline/cache/CountingMemoryCache;");
                return;
            }
        }
        PARAMS_INTERCHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
    }

    public CountingMemoryCache(ValueDescriptor<V> valueDescriptor, CacheTrimStrategy cacheTrimStrategy, Supplier<MemoryCacheParams> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valueDescriptor, cacheTrimStrategy, supplier};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mOtherEntries = new WeakHashMap();
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap<>(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = supplier.get();
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (getInUseSizeInBytes() <= (r4.mMemoryCacheParams.maxCacheSize - r5)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean canCacheNewValue(V v) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, v)) == null) {
            synchronized (this) {
                int sizeInBytes = this.mValueDescriptor.getSizeInBytes(v);
                z = true;
                if (sizeInBytes <= this.mMemoryCacheParams.maxCacheEntrySize && getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1) {
                }
                z = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private synchronized void decreaseClientCount(Entry<K, V> entry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, this, entry) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                Preconditions.checkState(entry.clientCount > 0);
                entry.clientCount--;
            }
        }
    }

    private synchronized void increaseClientCount(Entry<K, V> entry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, entry) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                Preconditions.checkState(!entry.isOrphan);
                entry.clientCount++;
            }
        }
    }

    private synchronized void makeOrphan(Entry<K, V> entry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, entry) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                Preconditions.checkState(!entry.isOrphan);
                entry.isOrphan = true;
            }
        }
    }

    private synchronized void makeOrphans(@Nullable ArrayList<Entry<K, V>> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, arrayList) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    Iterator<Entry<K, V>> it = arrayList.iterator();
                    while (it.hasNext()) {
                        makeOrphan(it.next());
                    }
                }
            }
        }
    }

    private synchronized boolean maybeAddToExclusives(Entry<K, V> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, entry)) == null) {
            synchronized (this) {
                if (entry.isOrphan || entry.clientCount != 0) {
                    return false;
                }
                this.mExclusiveEntries.put(entry.key, entry);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private void maybeClose(@Nullable ArrayList<Entry<K, V>> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, arrayList) == null) || arrayList == null) {
            return;
        }
        Iterator<Entry<K, V>> it = arrayList.iterator();
        while (it.hasNext()) {
            CloseableReference.closeSafely((CloseableReference<?>) referenceToClose(it.next()));
        }
    }

    private void maybeEvictEntries() {
        ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            synchronized (this) {
                trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
                makeOrphans(trimExclusivelyOwnedEntries);
            }
            maybeClose(trimExclusivelyOwnedEntries);
            maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
        }
    }

    public static <K, V> void maybeNotifyExclusiveEntryInsertion(@Nullable Entry<K, V> entry) {
        EntryStateObserver<K> entryStateObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, entry) == null) || entry == null || (entryStateObserver = entry.observer) == null) {
            return;
        }
        entryStateObserver.onExclusivityChanged(entry.key, true);
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList<Entry<K, V>> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, this, arrayList) == null) || arrayList == null) {
            return;
        }
        Iterator<Entry<K, V>> it = arrayList.iterator();
        while (it.hasNext()) {
            maybeNotifyExclusiveEntryRemoval(it.next());
        }
    }

    private synchronized void maybeUpdateCacheParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            synchronized (this) {
                if (this.mLastCacheParamsCheck + PARAMS_INTERCHECK_INTERVAL_MS > SystemClock.uptimeMillis()) {
                    return;
                }
                this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
                this.mMemoryCacheParams = this.mMemoryCacheParamsSupplier.get();
            }
        }
    }

    private synchronized CloseableReference<V> newClientReference(Entry<K, V> entry) {
        InterceptResult invokeL;
        CloseableReference<V> of;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, entry)) == null) {
            synchronized (this) {
                increaseClientCount(entry);
                of = CloseableReference.of(entry.valueRef.get(), new ResourceReleaser<V>(this, entry) { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CountingMemoryCache this$0;
                    public final /* synthetic */ Entry val$entry;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, entry};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$entry = entry;
                    }

                    @Override // com.facebook.common.references.ResourceReleaser
                    public void release(V v) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, v) == null) {
                            this.this$0.releaseClientReference(this.val$entry);
                        }
                    }
                });
            }
            return of;
        }
        return (CloseableReference) invokeL.objValue;
    }

    @Nullable
    private synchronized CloseableReference<V> referenceToClose(Entry<K, V> entry) {
        InterceptResult invokeL;
        CloseableReference<V> closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, entry)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                closeableReference = (entry.isOrphan && entry.clientCount == 0) ? entry.valueRef : null;
            }
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(Entry<K, V> entry) {
        boolean maybeAddToExclusives;
        CloseableReference<V> referenceToClose;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, entry) == null) {
            Preconditions.checkNotNull(entry);
            synchronized (this) {
                decreaseClientCount(entry);
                maybeAddToExclusives = maybeAddToExclusives(entry);
                referenceToClose = referenceToClose(entry);
            }
            CloseableReference.closeSafely((CloseableReference<?>) referenceToClose);
            if (!maybeAddToExclusives) {
                entry = null;
            }
            maybeNotifyExclusiveEntryInsertion(entry);
            maybeUpdateCacheParams();
            maybeEvictEntries();
        }
    }

    @Nullable
    private synchronized ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeII = interceptable.invokeII(65554, this, i2, i3)) != null) {
            return (ArrayList) invokeII.objValue;
        }
        synchronized (this) {
            int max = Math.max(i2, 0);
            int max2 = Math.max(i3, 0);
            if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                return null;
            }
            ArrayList<Entry<K, V>> arrayList = new ArrayList<>();
            while (true) {
                if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                    return arrayList;
                }
                K firstKey = this.mExclusiveEntries.getFirstKey();
                this.mExclusiveEntries.remove(firstKey);
                arrayList.add(this.mCachedEntries.remove(firstKey));
            }
        }
    }

    private ValueDescriptor<Entry<K, V>> wrapValueDescriptor(ValueDescriptor<V> valueDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, this, valueDescriptor)) == null) ? new ValueDescriptor<Entry<K, V>>(this, valueDescriptor) { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CountingMemoryCache this$0;
            public final /* synthetic */ ValueDescriptor val$evictableValueDescriptor;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, valueDescriptor};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$evictableValueDescriptor = valueDescriptor;
            }

            @Override // com.facebook.imagepipeline.cache.ValueDescriptor
            public /* bridge */ /* synthetic */ int getSizeInBytes(Object obj) {
                return getSizeInBytes((Entry) ((Entry) obj));
            }

            public int getSizeInBytes(Entry<K, V> entry) {
                InterceptResult invokeL2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, entry)) == null) ? this.val$evictableValueDescriptor.getSizeInBytes(entry.valueRef.get()) : invokeL2.intValue;
            }
        } : (ValueDescriptor) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k, closeableReference)) == null) ? cache(k, closeableReference, null) : (CloseableReference) invokeLL.objValue;
    }

    public void clear() {
        ArrayList<Entry<K, V>> clear;
        ArrayList<Entry<K, V>> clear2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                clear = this.mExclusiveEntries.clear();
                clear2 = this.mCachedEntries.clear();
                makeOrphans(clear2);
            }
            maybeClose(clear2);
            maybeNotifyExclusiveEntryRemoval(clear);
            maybeUpdateCacheParams();
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate<K> predicate) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, predicate)) == null) {
            synchronized (this) {
                z = !this.mCachedEntries.getMatchingEntries(predicate).isEmpty();
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference<V> get(K k) {
        InterceptResult invokeL;
        Entry<K, V> remove;
        CloseableReference<V> newClientReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) {
            Preconditions.checkNotNull(k);
            synchronized (this) {
                remove = this.mExclusiveEntries.remove(k);
                Entry<K, V> entry = this.mCachedEntries.get(k);
                newClientReference = entry != null ? newClientReference(entry) : null;
            }
            maybeNotifyExclusiveEntryRemoval(remove);
            maybeUpdateCacheParams();
            maybeEvictEntries();
            return newClientReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    public synchronized int getCount() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                count = this.mCachedEntries.getCount();
            }
            return count;
        }
        return invokeV.intValue;
    }

    public synchronized int getEvictionQueueCount() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                count = this.mExclusiveEntries.getCount();
            }
            return count;
        }
        return invokeV.intValue;
    }

    public synchronized int getEvictionQueueSizeInBytes() {
        InterceptResult invokeV;
        int sizeInBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                sizeInBytes = this.mExclusiveEntries.getSizeInBytes();
            }
            return sizeInBytes;
        }
        return invokeV.intValue;
    }

    public synchronized int getInUseCount() {
        InterceptResult invokeV;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                count = this.mCachedEntries.getCount() - this.mExclusiveEntries.getCount();
            }
            return count;
        }
        return invokeV.intValue;
    }

    public synchronized int getInUseSizeInBytes() {
        InterceptResult invokeV;
        int sizeInBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                sizeInBytes = this.mCachedEntries.getSizeInBytes() - this.mExclusiveEntries.getSizeInBytes();
            }
            return sizeInBytes;
        }
        return invokeV.intValue;
    }

    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int sizeInBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                sizeInBytes = this.mCachedEntries.getSizeInBytes();
            }
            return sizeInBytes;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate<K> predicate) {
        InterceptResult invokeL;
        ArrayList<Entry<K, V>> removeAll;
        ArrayList<Entry<K, V>> removeAll2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, predicate)) == null) {
            synchronized (this) {
                removeAll = this.mExclusiveEntries.removeAll(predicate);
                removeAll2 = this.mCachedEntries.removeAll(predicate);
                makeOrphans(removeAll2);
            }
            maybeClose(removeAll2);
            maybeNotifyExclusiveEntryRemoval(removeAll);
            maybeUpdateCacheParams();
            maybeEvictEntries();
            return removeAll2.size();
        }
        return invokeL.intValue;
    }

    @Nullable
    public CloseableReference<V> reuse(K k) {
        InterceptResult invokeL;
        Entry<K, V> remove;
        boolean z;
        CloseableReference<V> closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, k)) == null) {
            Preconditions.checkNotNull(k);
            synchronized (this) {
                remove = this.mExclusiveEntries.remove(k);
                z = true;
                if (remove != null) {
                    Entry<K, V> remove2 = this.mCachedEntries.remove(k);
                    Preconditions.checkNotNull(remove2);
                    Preconditions.checkState(remove2.clientCount == 0);
                    closeableReference = remove2.valueRef;
                } else {
                    closeableReference = null;
                    z = false;
                }
            }
            if (z) {
                maybeNotifyExclusiveEntryRemoval(remove);
            }
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList<Entry<K, V>> trimExclusivelyOwnedEntries;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, memoryTrimType) == null) {
            double trimRatio = this.mCacheTrimStrategy.getTrimRatio(memoryTrimType);
            synchronized (this) {
                trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Integer.MAX_VALUE, Math.max(0, ((int) (this.mCachedEntries.getSizeInBytes() * (1.0d - trimRatio))) - getInUseSizeInBytes()));
                makeOrphans(trimExclusivelyOwnedEntries);
            }
            maybeClose(trimExclusivelyOwnedEntries);
            maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
            maybeUpdateCacheParams();
            maybeEvictEntries();
        }
    }

    @Nullable
    public CloseableReference<V> cache(K k, CloseableReference<V> closeableReference, EntryStateObserver<K> entryStateObserver) {
        InterceptResult invokeLLL;
        Entry<K, V> remove;
        CloseableReference<V> closeableReference2;
        CloseableReference<V> closeableReference3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k, closeableReference, entryStateObserver)) == null) {
            Preconditions.checkNotNull(k);
            Preconditions.checkNotNull(closeableReference);
            maybeUpdateCacheParams();
            synchronized (this) {
                remove = this.mExclusiveEntries.remove(k);
                Entry<K, V> remove2 = this.mCachedEntries.remove(k);
                closeableReference2 = null;
                if (remove2 != null) {
                    makeOrphan(remove2);
                    closeableReference3 = referenceToClose(remove2);
                } else {
                    closeableReference3 = null;
                }
                if (canCacheNewValue(closeableReference.get())) {
                    Entry<K, V> of = Entry.of(k, closeableReference, entryStateObserver);
                    this.mCachedEntries.put(k, of);
                    closeableReference2 = newClientReference(of);
                }
            }
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference3);
            maybeNotifyExclusiveEntryRemoval(remove);
            maybeEvictEntries();
            return closeableReference2;
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(K k) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) {
            synchronized (this) {
                contains = this.mCachedEntries.contains(k);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public static <K, V> void maybeNotifyExclusiveEntryRemoval(@Nullable Entry<K, V> entry) {
        EntryStateObserver<K> entryStateObserver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, entry) == null) || entry == null || (entryStateObserver = entry.observer) == null) {
            return;
        }
        entryStateObserver.onExclusivityChanged(entry.key, false);
    }
}

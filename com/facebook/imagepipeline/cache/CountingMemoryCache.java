package com.facebook.imagepipeline.cache;

import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imagepipeline.cache.MemoryCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class CountingMemoryCache implements MemoryCache, MemoryTrimmable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemoryCache.CacheTrimStrategy mCacheTrimStrategy;
    public final CountingLruMap mCachedEntries;
    @Nullable
    public final EntryStateObserver mEntryStateObserver;
    public final CountingLruMap mExclusiveEntries;
    public long mLastCacheParamsCheck;
    public MemoryCacheParams mMemoryCacheParams;
    public final Supplier mMemoryCacheParamsSupplier;
    public final Map mOtherEntries;
    public final ValueDescriptor mValueDescriptor;

    /* loaded from: classes7.dex */
    public interface EntryStateObserver {
        void onExclusivityChanged(Object obj, boolean z);
    }

    /* loaded from: classes7.dex */
    public class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int clientCount;
        public boolean isOrphan;
        public final Object key;
        @Nullable
        public final EntryStateObserver observer;
        public final CloseableReference valueRef;

        public Entry(Object obj, CloseableReference closeableReference, @Nullable EntryStateObserver entryStateObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, closeableReference, entryStateObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = Preconditions.checkNotNull(obj);
            this.valueRef = (CloseableReference) Preconditions.checkNotNull(CloseableReference.cloneOrNull(closeableReference));
            this.clientCount = 0;
            this.isOrphan = false;
            this.observer = entryStateObserver;
        }

        public static Entry of(Object obj, CloseableReference closeableReference, @Nullable EntryStateObserver entryStateObserver) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, obj, closeableReference, entryStateObserver)) == null) {
                return new Entry(obj, closeableReference, entryStateObserver);
            }
            return (Entry) invokeLLL.objValue;
        }
    }

    public CountingMemoryCache(ValueDescriptor valueDescriptor, MemoryCache.CacheTrimStrategy cacheTrimStrategy, Supplier supplier, @Nullable EntryStateObserver entryStateObserver) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {valueDescriptor, cacheTrimStrategy, supplier, entryStateObserver};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOtherEntries = new WeakHashMap();
        this.mValueDescriptor = valueDescriptor;
        this.mExclusiveEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCachedEntries = new CountingLruMap(wrapValueDescriptor(valueDescriptor));
        this.mCacheTrimStrategy = cacheTrimStrategy;
        this.mMemoryCacheParamsSupplier = supplier;
        this.mMemoryCacheParams = (MemoryCacheParams) supplier.get();
        this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
        this.mEntryStateObserver = entryStateObserver;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public CloseableReference cache(Object obj, CloseableReference closeableReference) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, closeableReference)) == null) {
            return cache(obj, closeableReference, this.mEntryStateObserver);
        }
        return (CloseableReference) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (getInUseSizeInBytes() <= (r4.mMemoryCacheParams.maxCacheSize - r5)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean canCacheNewValue(Object obj) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, obj)) == null) {
            synchronized (this) {
                int sizeInBytes = this.mValueDescriptor.getSizeInBytes(obj);
                z = true;
                if (sizeInBytes <= this.mMemoryCacheParams.maxCacheEntrySize && getInUseCount() <= this.mMemoryCacheParams.maxCacheEntries - 1) {
                }
                z = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseClientReference(Entry entry) {
        boolean maybeAddToExclusives;
        CloseableReference referenceToClose;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, entry) == null) {
            Preconditions.checkNotNull(entry);
            synchronized (this) {
                decreaseClientCount(entry);
                maybeAddToExclusives = maybeAddToExclusives(entry);
                referenceToClose = referenceToClose(entry);
            }
            CloseableReference.closeSafely(referenceToClose);
            if (!maybeAddToExclusives) {
                entry = null;
            }
            maybeNotifyExclusiveEntryInsertion(entry);
            maybeUpdateCacheParams();
            maybeEvictEntries();
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    @Nullable
    public CloseableReference get(Object obj) {
        InterceptResult invokeL;
        Entry entry;
        CloseableReference closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            Preconditions.checkNotNull(obj);
            synchronized (this) {
                entry = (Entry) this.mExclusiveEntries.remove(obj);
                Entry entry2 = (Entry) this.mCachedEntries.get(obj);
                if (entry2 != null) {
                    closeableReference = newClientReference(entry2);
                } else {
                    closeableReference = null;
                }
            }
            maybeNotifyExclusiveEntryRemoval(entry);
            maybeUpdateCacheParams();
            maybeEvictEntries();
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int removeAll(Predicate predicate) {
        InterceptResult invokeL;
        ArrayList removeAll;
        ArrayList removeAll2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, predicate)) == null) {
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
    public CloseableReference reuse(Object obj) {
        InterceptResult invokeL;
        Entry entry;
        boolean z;
        CloseableReference closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, obj)) == null) {
            Preconditions.checkNotNull(obj);
            synchronized (this) {
                entry = (Entry) this.mExclusiveEntries.remove(obj);
                z = true;
                boolean z2 = false;
                if (entry != null) {
                    Entry entry2 = (Entry) this.mCachedEntries.remove(obj);
                    Preconditions.checkNotNull(entry2);
                    if (entry2.clientCount == 0) {
                        z2 = true;
                    }
                    Preconditions.checkState(z2);
                    closeableReference = entry2.valueRef;
                } else {
                    closeableReference = null;
                    z = false;
                }
            }
            if (z) {
                maybeNotifyExclusiveEntryRemoval(entry);
            }
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    private synchronized void decreaseClientCount(Entry entry) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, entry) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                if (entry.clientCount > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                entry.clientCount--;
            }
        }
    }

    private synchronized void increaseClientCount(Entry entry) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, entry) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                if (!entry.isOrphan) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                entry.clientCount++;
            }
        }
    }

    private synchronized void makeOrphan(Entry entry) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, entry) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                if (!entry.isOrphan) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z);
                entry.isOrphan = true;
            }
        }
    }

    private synchronized void makeOrphans(@Nullable ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, arrayList) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        makeOrphan((Entry) it.next());
                    }
                }
            }
        }
    }

    private synchronized boolean maybeAddToExclusives(Entry entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, entry)) == null) {
            synchronized (this) {
                if (!entry.isOrphan && entry.clientCount == 0) {
                    this.mExclusiveEntries.put(entry.key, entry);
                    return true;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    private void maybeClose(@Nullable ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, this, arrayList) == null) && arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.closeSafely(referenceToClose((Entry) it.next()));
            }
        }
    }

    public static void maybeNotifyExclusiveEntryInsertion(@Nullable Entry entry) {
        EntryStateObserver entryStateObserver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, entry) == null) && entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, true);
        }
    }

    public static void maybeNotifyExclusiveEntryRemoval(@Nullable Entry entry) {
        EntryStateObserver entryStateObserver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, entry) == null) && entry != null && (entryStateObserver = entry.observer) != null) {
            entryStateObserver.onExclusivityChanged(entry.key, false);
        }
    }

    private synchronized CloseableReference newClientReference(Entry entry) {
        InterceptResult invokeL;
        CloseableReference of;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, entry)) == null) {
            synchronized (this) {
                increaseClientCount(entry);
                of = CloseableReference.of(entry.valueRef.get(), new ResourceReleaser(this, entry) { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.2
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$entry = entry;
                    }

                    @Override // com.facebook.common.references.ResourceReleaser
                    public void release(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
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
    private synchronized CloseableReference referenceToClose(Entry entry) {
        InterceptResult invokeL;
        CloseableReference closeableReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, entry)) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(entry);
                if (entry.isOrphan && entry.clientCount == 0) {
                    closeableReference = entry.valueRef;
                } else {
                    closeableReference = null;
                }
            }
            return closeableReference;
        }
        return (CloseableReference) invokeL.objValue;
    }

    private ValueDescriptor wrapValueDescriptor(ValueDescriptor valueDescriptor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, valueDescriptor)) == null) {
            return new ValueDescriptor(this, valueDescriptor) { // from class: com.facebook.imagepipeline.cache.CountingMemoryCache.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$evictableValueDescriptor = valueDescriptor;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.facebook.imagepipeline.cache.ValueDescriptor
                public int getSizeInBytes(Entry entry) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, entry)) == null) {
                        return this.val$evictableValueDescriptor.getSizeInBytes(entry.valueRef.get());
                    }
                    return invokeL2.intValue;
                }
            };
        }
        return (ValueDescriptor) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Predicate predicate) {
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
    public void probe(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, obj) == null) {
            Preconditions.checkNotNull(obj);
            synchronized (this) {
                Entry entry = (Entry) this.mExclusiveEntries.remove(obj);
                if (entry != null) {
                    this.mExclusiveEntries.put(obj, entry);
                }
            }
        }
    }

    private void maybeEvictEntries() {
        ArrayList trimExclusivelyOwnedEntries;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            synchronized (this) {
                trimExclusivelyOwnedEntries = trimExclusivelyOwnedEntries(Math.min(this.mMemoryCacheParams.maxEvictionQueueEntries, this.mMemoryCacheParams.maxCacheEntries - getInUseCount()), Math.min(this.mMemoryCacheParams.maxEvictionQueueSize, this.mMemoryCacheParams.maxCacheSize - getInUseSizeInBytes()));
                makeOrphans(trimExclusivelyOwnedEntries);
            }
            maybeClose(trimExclusivelyOwnedEntries);
            maybeNotifyExclusiveEntryRemoval(trimExclusivelyOwnedEntries);
        }
    }

    private synchronized void maybeUpdateCacheParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            synchronized (this) {
                if (this.mLastCacheParamsCheck + this.mMemoryCacheParams.paramsCheckIntervalMs > SystemClock.uptimeMillis()) {
                    return;
                }
                this.mLastCacheParamsCheck = SystemClock.uptimeMillis();
                this.mMemoryCacheParams = (MemoryCacheParams) this.mMemoryCacheParamsSupplier.get();
            }
        }
    }

    private void maybeNotifyExclusiveEntryRemoval(@Nullable ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, this, arrayList) == null) && arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                maybeNotifyExclusiveEntryRemoval((Entry) it.next());
            }
        }
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized boolean contains(Object obj) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            synchronized (this) {
                contains = this.mCachedEntries.contains(obj);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    private synchronized ArrayList trimExclusivelyOwnedEntries(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65553, this, i, i2)) == null) {
            synchronized (this) {
                int max = Math.max(i, 0);
                int max2 = Math.max(i2, 0);
                if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                while (true) {
                    if (this.mExclusiveEntries.getCount() <= max && this.mExclusiveEntries.getSizeInBytes() <= max2) {
                        return arrayList;
                    }
                    Object firstKey = this.mExclusiveEntries.getFirstKey();
                    this.mExclusiveEntries.remove(firstKey);
                    arrayList.add(this.mCachedEntries.remove(firstKey));
                }
            }
        } else {
            return (ArrayList) invokeII.objValue;
        }
    }

    @Nullable
    public CloseableReference cache(Object obj, CloseableReference closeableReference, EntryStateObserver entryStateObserver) {
        InterceptResult invokeLLL;
        Entry entry;
        CloseableReference closeableReference2;
        CloseableReference closeableReference3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, closeableReference, entryStateObserver)) == null) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(closeableReference);
            maybeUpdateCacheParams();
            synchronized (this) {
                entry = (Entry) this.mExclusiveEntries.remove(obj);
                Entry entry2 = (Entry) this.mCachedEntries.remove(obj);
                closeableReference2 = null;
                if (entry2 != null) {
                    makeOrphan(entry2);
                    closeableReference3 = referenceToClose(entry2);
                } else {
                    closeableReference3 = null;
                }
                if (canCacheNewValue(closeableReference.get())) {
                    Entry of = Entry.of(obj, closeableReference, entryStateObserver);
                    this.mCachedEntries.put(obj, of);
                    closeableReference2 = newClientReference(of);
                }
            }
            CloseableReference.closeSafely(closeableReference3);
            maybeNotifyExclusiveEntryRemoval(entry);
            maybeEvictEntries();
            return closeableReference2;
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    public void clear() {
        ArrayList clear;
        ArrayList clear2;
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

    public MemoryCacheParams getMemoryCacheParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mMemoryCacheParams;
        }
        return (MemoryCacheParams) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int sizeInBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                sizeInBytes = this.mCachedEntries.getSizeInBytes();
            }
            return sizeInBytes;
        }
        return invokeV.intValue;
    }

    public String reportData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return Objects.toStringHelper("CountingMemoryCache").add("cached_entries_count:", this.mCachedEntries.getCount()).add("cached_entries_size_bytes", this.mCachedEntries.getSizeInBytes()).add("exclusive_entries_count", this.mExclusiveEntries.getCount()).add("exclusive_entries_size_bytes", this.mExclusiveEntries.getSizeInBytes()).toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
        ArrayList trimExclusivelyOwnedEntries;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, memoryTrimType) == null) {
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
}

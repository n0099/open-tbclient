package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public final class SimpleCache implements Cache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SimpleCache";
    public transient /* synthetic */ FieldHolder $fh;
    public final File cacheDir;
    public final CacheEvictor evictor;
    public final CachedContentIndex index;
    public final HashMap<String, ArrayList<Cache.Listener>> listeners;
    public final HashMap<String, CacheSpan> lockedSpans;
    public long totalSpace;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, null, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, cacheEvictor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], (CacheEvictor) objArr2[1], (byte[]) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addSpan(SimpleCacheSpan simpleCacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, simpleCacheSpan) == null) {
            this.index.add(simpleCacheSpan.key).addSpan(simpleCacheSpan);
            this.totalSpace += simpleCacheSpan.length;
            notifySpanAdded(simpleCacheSpan);
        }
    }

    private SimpleCacheSpan getSpan(String str, long j) throws Cache.CacheException {
        InterceptResult invokeLJ;
        SimpleCacheSpan span;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, this, str, j)) == null) {
            CachedContent cachedContent = this.index.get(str);
            if (cachedContent == null) {
                return SimpleCacheSpan.createOpenHole(str, j);
            }
            while (true) {
                span = cachedContent.getSpan(j);
                if (!span.isCached || span.file.exists()) {
                    break;
                }
                removeStaleSpansAndCachedContents();
            }
            return span;
        }
        return (SimpleCacheSpan) invokeLJ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            if (!this.cacheDir.exists()) {
                this.cacheDir.mkdirs();
                return;
            }
            this.index.load();
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (!file.getName().equals(CachedContentIndex.FILE_NAME)) {
                    SimpleCacheSpan createCacheEntry = file.length() > 0 ? SimpleCacheSpan.createCacheEntry(file, this.index) : null;
                    if (createCacheEntry != null) {
                        addSpan(createCacheEntry);
                    } else {
                        file.delete();
                    }
                }
            }
            this.index.removeEmpty();
            try {
                this.index.store();
            } catch (Cache.CacheException e) {
                Log.e(TAG, "Storing index file failed", e);
            }
        }
    }

    private void notifySpanAdded(SimpleCacheSpan simpleCacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, simpleCacheSpan) == null) {
            ArrayList<Cache.Listener> arrayList = this.listeners.get(simpleCacheSpan.key);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    arrayList.get(size).onSpanAdded(this, simpleCacheSpan);
                }
            }
            this.evictor.onSpanAdded(this, simpleCacheSpan);
        }
    }

    private void notifySpanRemoved(CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, cacheSpan) == null) {
            ArrayList<Cache.Listener> arrayList = this.listeners.get(cacheSpan.key);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    arrayList.get(size).onSpanRemoved(this, cacheSpan);
                }
            }
            this.evictor.onSpanRemoved(this, cacheSpan);
        }
    }

    private void notifySpanTouched(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, simpleCacheSpan, cacheSpan) == null) {
            ArrayList<Cache.Listener> arrayList = this.listeners.get(simpleCacheSpan.key);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    arrayList.get(size).onSpanTouched(this, simpleCacheSpan, cacheSpan);
                }
            }
            this.evictor.onSpanTouched(this, simpleCacheSpan, cacheSpan);
        }
    }

    private void removeSpan(CacheSpan cacheSpan, boolean z) throws Cache.CacheException {
        CachedContent cachedContent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65548, this, cacheSpan, z) == null) && (cachedContent = this.index.get(cacheSpan.key)) != null && cachedContent.removeSpan(cacheSpan)) {
            this.totalSpace -= cacheSpan.length;
            if (z) {
                try {
                    if (cachedContent.isEmpty()) {
                        this.index.removeEmpty(cachedContent.key);
                        this.index.store();
                    }
                } finally {
                    notifySpanRemoved(cacheSpan);
                }
            }
        }
    }

    private void removeStaleSpansAndCachedContents() throws Cache.CacheException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ArrayList arrayList = new ArrayList();
            for (CachedContent cachedContent : this.index.getAll()) {
                Iterator<SimpleCacheSpan> it = cachedContent.getSpans().iterator();
                while (it.hasNext()) {
                    SimpleCacheSpan next = it.next();
                    if (!next.file.exists()) {
                        arrayList.add(next);
                    }
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                removeSpan((CacheSpan) arrayList.get(i), false);
            }
            this.index.removeEmpty();
            this.index.store();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> addListener(String str, Cache.Listener listener) {
        InterceptResult invokeLL;
        NavigableSet<CacheSpan> cachedSpans;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, listener)) == null) {
            synchronized (this) {
                ArrayList<Cache.Listener> arrayList = this.listeners.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.listeners.put(str, arrayList);
                }
                arrayList.add(listener);
                cachedSpans = getCachedSpans(str);
            }
            return cachedSpans;
        }
        return (NavigableSet) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(File file) throws Cache.CacheException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
            synchronized (this) {
                SimpleCacheSpan createCacheEntry = SimpleCacheSpan.createCacheEntry(file, this.index);
                boolean z = true;
                Assertions.checkState(createCacheEntry != null);
                Assertions.checkState(this.lockedSpans.containsKey(createCacheEntry.key));
                if (file.exists()) {
                    if (file.length() == 0) {
                        file.delete();
                        return;
                    }
                    Long valueOf = Long.valueOf(getContentLength(createCacheEntry.key));
                    if (valueOf.longValue() != -1) {
                        if (createCacheEntry.position + createCacheEntry.length > valueOf.longValue()) {
                            z = false;
                        }
                        Assertions.checkState(z);
                    }
                    addSpan(createCacheEntry);
                    this.index.store();
                    notifyAll();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                j = this.totalSpace;
            }
            return j;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedBytes(String str, long j, long j2) {
        InterceptResult invokeCommon;
        long cachedBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                CachedContent cachedContent = this.index.get(str);
                cachedBytes = cachedContent != null ? cachedContent.getCachedBytes(j, j2) : -j2;
            }
            return cachedBytes;
        }
        return invokeCommon.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<CacheSpan> getCachedSpans(String str) {
        InterceptResult invokeL;
        TreeSet treeSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            synchronized (this) {
                CachedContent cachedContent = this.index.get(str);
                treeSet = (cachedContent == null || cachedContent.isEmpty()) ? null : new TreeSet((Collection) cachedContent.getSpans());
            }
            return treeSet;
        }
        return (NavigableSet) invokeL.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getContentLength(String str) {
        InterceptResult invokeL;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                contentLength = this.index.getContentLength(str);
            }
            return contentLength;
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set<String> getKeys() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                hashSet = new HashSet(this.index.getKeys());
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized boolean isCached(String str, long j, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                CachedContent cachedContent = this.index.get(str);
                if (cachedContent != null) {
                    z = cachedContent.getCachedBytes(j, j2) >= j2;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void releaseHoleSpan(CacheSpan cacheSpan) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cacheSpan) == null) {
            synchronized (this) {
                Assertions.checkState(cacheSpan == this.lockedSpans.remove(cacheSpan.key));
                notifyAll();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeListener(String str, Cache.Listener listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, listener) == null) {
            synchronized (this) {
                ArrayList<Cache.Listener> arrayList = this.listeners.get(str);
                if (arrayList != null) {
                    arrayList.remove(listener);
                    if (arrayList.isEmpty()) {
                        this.listeners.remove(str);
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void setContentLength(String str, long j) throws Cache.CacheException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j) == null) {
            synchronized (this) {
                this.index.setContentLength(str, j);
                this.index.store();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j, long j2) throws Cache.CacheException {
        InterceptResult invokeCommon;
        File cacheFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            synchronized (this) {
                Assertions.checkState(this.lockedSpans.containsKey(str));
                if (!this.cacheDir.exists()) {
                    removeStaleSpansAndCachedContents();
                    this.cacheDir.mkdirs();
                }
                this.evictor.onStartFile(this, str, j, j2);
                cacheFile = SimpleCacheSpan.getCacheFile(this.cacheDir, this.index.assignIdForKey(str), j, System.currentTimeMillis());
            }
            return cacheFile;
        }
        return (File) invokeCommon.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, cacheEvictor, bArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], (CacheEvictor) objArr2[1], (byte[]) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized SimpleCacheSpan startReadWrite(String str, long j) throws InterruptedException, Cache.CacheException {
        InterceptResult invokeLJ;
        SimpleCacheSpan startReadWriteNonBlocking;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048590, this, str, j)) == null) {
            synchronized (this) {
                while (true) {
                    startReadWriteNonBlocking = startReadWriteNonBlocking(str, j);
                    if (startReadWriteNonBlocking == null) {
                        wait();
                    }
                }
            }
            return startReadWriteNonBlocking;
        }
        return (SimpleCacheSpan) invokeLJ.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized SimpleCacheSpan startReadWriteNonBlocking(String str, long j) throws Cache.CacheException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048592, this, str, j)) == null) {
            synchronized (this) {
                SimpleCacheSpan span = getSpan(str, j);
                if (span.isCached) {
                    SimpleCacheSpan simpleCacheSpan = this.index.get(str).touch(span);
                    notifySpanTouched(span, simpleCacheSpan);
                    return simpleCacheSpan;
                } else if (this.lockedSpans.containsKey(str)) {
                    return null;
                } else {
                    this.lockedSpans.put(str, span);
                    return span;
                }
            }
        }
        return (SimpleCacheSpan) invokeLJ.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, byte[] bArr, boolean z) {
        this(file, cacheEvictor, new CachedContentIndex(file, bArr, z));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, cacheEvictor, bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], (CacheEvictor) objArr2[1], (CachedContentIndex) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, cacheEvictor, cachedContentIndex};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.totalSpace = 0L;
        this.cacheDir = file;
        this.evictor = cacheEvictor;
        this.lockedSpans = new HashMap<>();
        this.index = cachedContentIndex;
        this.listeners = new HashMap<>();
        ConditionVariable conditionVariable = new ConditionVariable();
        new Thread(this, "SimpleCache.initialize()", conditionVariable) { // from class: com.google.android.exoplayer2.upstream.cache.SimpleCache.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SimpleCache this$0;
            public final /* synthetic */ ConditionVariable val$conditionVariable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8, conditionVariable};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((String) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$conditionVariable = conditionVariable;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (this.this$0) {
                        this.val$conditionVariable.open();
                        this.this$0.initialize();
                        this.this$0.evictor.onCacheInitialized();
                    }
                }
            }
        }.start();
        conditionVariable.block();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeSpan(CacheSpan cacheSpan) throws Cache.CacheException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cacheSpan) == null) {
            synchronized (this) {
                removeSpan(cacheSpan, true);
            }
        }
    }
}

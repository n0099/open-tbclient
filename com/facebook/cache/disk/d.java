package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.disk.c;
import com.facebook.common.statfs.StatFsHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class d implements h, com.facebook.common.a.a {
    private final g mlJ;
    private final CacheEventListener mlK;
    private final boolean mlM;
    private final long mlT;
    private final long mlU;
    private final CountDownLatch mlV;
    private long mlW;
    @GuardedBy("mLock")
    final Set<String> mlX;
    private final long mlZ;
    private final CacheErrorLogger mlx;
    private final com.facebook.common.time.a mly;
    private final c mmb;
    private boolean mmd;
    private static final Class<?> mls = d.class;
    private static final long mlR = TimeUnit.HOURS.toMillis(2);
    private static final long mlS = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper mma = StatFsHelper.duV();
    private long mlY = -1;
    private final a mmc = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long foE = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.foE = -1L;
            this.mSize = -1L;
        }

        public synchronized void H(long j, long j2) {
            this.foE = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void I(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.foE += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.foE;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long mlT;
        public final long mlU;
        public final long mlZ;

        public b(long j, long j2, long j3) {
            this.mlZ = j;
            this.mlT = j2;
            this.mlU = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.mlT = bVar.mlT;
        this.mlU = bVar.mlU;
        this.mlW = bVar.mlU;
        this.mmb = cVar;
        this.mlJ = gVar;
        this.mlK = cacheEventListener;
        this.mlZ = bVar.mlZ;
        this.mlx = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.mly = com.facebook.common.time.c.duZ();
        this.mlM = z;
        this.mlX = new HashSet();
        if (this.mlM) {
            this.mlV = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.duo();
                    }
                    d.this.mmd = true;
                    d.this.mlV.countDown();
                }
            });
            return;
        }
        this.mlV = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.duu().h(bVar);
        try {
            synchronized (this.mLock) {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                int i = 0;
                String str = null;
                aVar = null;
                while (true) {
                    if (i >= a2.size()) {
                        break;
                    }
                    String str2 = a2.get(i);
                    h.PO(str2);
                    com.facebook.a.a D = this.mmb.D(str2, bVar);
                    if (D != null) {
                        str = str2;
                        aVar = D;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = D;
                }
                if (aVar == null) {
                    this.mlK.b(h);
                    this.mlX.remove(str);
                } else {
                    this.mlK.a(h);
                    this.mlX.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.mlx.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mls, "getResource", e);
            h.e(e);
            this.mlK.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dum();
        return this.mmb.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aL;
        synchronized (this.mLock) {
            aL = bVar.aL(bVar2);
            this.mlX.add(str);
            this.mmc.I(aL.size(), 1L);
        }
        return aL;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.duu().h(bVar);
        this.mlK.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.PO(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fC(a3.size()).fD(this.mmc.getSize());
                    this.mlK.d(h);
                    return a3;
                } finally {
                    if (!a2.dtY()) {
                        com.facebook.common.c.a.h(mls, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.mlK.f(h);
                com.facebook.common.c.a.b(mls, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            h.recycle();
        }
    }

    @Override // com.facebook.cache.disk.h
    public void e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            try {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a2.size()) {
                        break;
                    }
                    String str = a2.get(i2);
                    this.mmb.PK(str);
                    this.mlX.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.mlx.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, mls, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dum() throws IOException {
        synchronized (this.mLock) {
            boolean duo = duo();
            dun();
            long size = this.mmc.getSize();
            if (size > this.mlW && !duo) {
                this.mmc.reset();
                duo();
            }
            if (size > this.mlW) {
                a((this.mlW * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> j3 = j(this.mmb.dtV());
            long size = this.mmc.getSize();
            long j4 = size - j;
            int i2 = 0;
            long j5 = 0;
            Iterator<c.a> it = j3.iterator();
            while (true) {
                i = i2;
                j2 = j5;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j4) {
                    break;
                }
                long a2 = this.mmb.a(next);
                this.mlX.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fE = i.duu().PO(next.getId()).a(evictionReason).fC(a2).fD(size - j2).fE(j);
                    this.mlK.g(fE);
                    fE.recycle();
                }
                long j6 = j2;
                i2 = i;
                j5 = j6;
            }
            this.mmc.I(-j2, -i);
            this.mmb.dtU();
        } catch (IOException e) {
            this.mlx.a(CacheErrorLogger.CacheErrorCategory.EVICTION, mls, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> j(Collection<c.a> collection) {
        long now = mlR + this.mly.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.mlJ.dtZ());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dun() {
        if (this.mma.a(this.mmb.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mlU - this.mmc.getSize())) {
            this.mlW = this.mlT;
        } else {
            this.mlW = this.mlU;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.mlX.contains(a2.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean g(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            if (f(bVar)) {
                return true;
            }
            try {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                for (int i = 0; i < a2.size(); i++) {
                    String str = a2.get(i);
                    if (this.mmb.E(str, bVar)) {
                        this.mlX.add(str);
                        return true;
                    }
                }
                return false;
            } catch (IOException e) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public boolean duo() {
        long now = this.mly.now();
        if (!this.mmc.isInitialized() || this.mlY == -1 || now - this.mlY > mlS) {
            return dup();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dup() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.mly.now();
        long j3 = now + mlR;
        if (this.mlM && this.mlX.isEmpty()) {
            set = this.mlX;
        } else if (this.mlM) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.mmb.dtV()) {
                int i6 = i5 + 1;
                j4 += aVar.getSize();
                if (aVar.getTimestamp() > j3) {
                    int i7 = i3 + 1;
                    int size = (int) (i4 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j2);
                    i = size;
                    i2 = i7;
                    z = true;
                } else {
                    if (this.mlM) {
                        set.add(aVar.getId());
                    }
                    long j5 = j2;
                    i = i4;
                    i2 = i3;
                    j = j5;
                    z = z2;
                }
                z2 = z;
                i5 = i6;
                i3 = i2;
                i4 = i;
                j2 = j;
            }
            if (z2) {
                this.mlx.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, mls, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.mmc.getCount() != i5 || this.mmc.getSize() != j4) {
                if (this.mlM && this.mlX != set) {
                    this.mlX.clear();
                    this.mlX.addAll(set);
                }
                this.mmc.H(j4, i5);
            }
            this.mlY = now;
            return true;
        } catch (IOException e) {
            this.mlx.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mls, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

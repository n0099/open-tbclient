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
/* loaded from: classes2.dex */
public class d implements h, com.facebook.common.a.a {
    private final g hXG;
    private final CacheEventListener hXH;
    private final boolean hXJ;
    private final long hXQ;
    private final long hXR;
    private long hXS;
    @GuardedBy("mLock")
    final Set<String> hXT;
    private final long hXV;
    private final c hXX;
    private boolean hXZ;
    private final CacheErrorLogger hXr;
    private final com.facebook.common.time.a hXs;
    private final CountDownLatch mCountDownLatch;
    private static final Class<?> hXm = d.class;
    private static final long hXO = TimeUnit.HOURS.toMillis(2);
    private static final long hXP = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper hXW = StatFsHelper.bRr();
    private long hXU = -1;
    private final a hXY = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean hYb = false;
        private long mSize = -1;
        private long hYc = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.hYb;
        }

        public synchronized void reset() {
            this.hYb = false;
            this.hYc = -1L;
            this.mSize = -1L;
        }

        public synchronized void o(long j, long j2) {
            this.hYc = j2;
            this.mSize = j;
            this.hYb = true;
        }

        public synchronized void p(long j, long j2) {
            if (this.hYb) {
                this.mSize += j;
                this.hYc += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.hYc;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long hXQ;
        public final long hXR;
        public final long hXV;

        public b(long j, long j2, long j3) {
            this.hXV = j;
            this.hXQ = j2;
            this.hXR = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.hXQ = bVar.hXQ;
        this.hXR = bVar.hXR;
        this.hXS = bVar.hXR;
        this.hXX = cVar;
        this.hXG = gVar;
        this.hXH = cacheEventListener;
        this.hXV = bVar.hXV;
        this.hXr = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.hXs = com.facebook.common.time.b.bRw();
        this.hXJ = z;
        this.hXT = new HashSet();
        if (this.hXJ) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bQJ();
                    }
                    d.this.hXZ = true;
                    d.this.mCountDownLatch.countDown();
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.bQP().g(bVar);
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
                    g.yy(str2);
                    com.facebook.a.a l = this.hXX.l(str2, bVar);
                    if (l != null) {
                        str = str2;
                        aVar = l;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = l;
                }
                if (aVar == null) {
                    this.hXH.b(g);
                    this.hXT.remove(str);
                } else {
                    this.hXH.a(g);
                    this.hXT.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.hXr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, hXm, "getResource", e);
            g.a(e);
            this.hXH.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bQH();
        return this.hXX.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a al;
        synchronized (this.mLock) {
            al = bVar.al(bVar2);
            this.hXT.add(str);
            this.hXY.p(al.size(), 1L);
        }
        return al;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bQP().g(bVar);
        this.hXH.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.yy(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.dl(a3.size()).dm(this.hXY.getSize());
                    this.hXH.d(g);
                    return a3;
                } finally {
                    if (!a2.bQt()) {
                        com.facebook.common.c.a.g(hXm, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.hXH.f(g);
                com.facebook.common.c.a.b(hXm, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void bQH() throws IOException {
        synchronized (this.mLock) {
            boolean bQJ = bQJ();
            bQI();
            long size = this.hXY.getSize();
            if (size > this.hXS && !bQJ) {
                this.hXY.reset();
                bQJ();
            }
            if (size > this.hXS) {
                a((this.hXS * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.hXX.bQq());
            long size = this.hXY.getSize();
            long j3 = size - j;
            int i2 = 0;
            long j4 = 0;
            Iterator<c.a> it = g.iterator();
            while (true) {
                i = i2;
                j2 = j4;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j3) {
                    break;
                }
                long a2 = this.hXX.a(next);
                this.hXT.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i dn = i.bQP().yy(next.getId()).a(evictionReason).dl(a2).dm(size - j2).dn(j);
                    this.hXH.g(dn);
                    dn.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.hXY.p(-j2, -i);
            this.hXX.bQp();
        } catch (IOException e) {
            this.hXr.a(CacheErrorLogger.CacheErrorCategory.EVICTION, hXm, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = hXO + this.hXs.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.hXG.bQu());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bQI() {
        if (this.hXW.a(this.hXX.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.hXR - this.hXY.getSize())) {
            this.hXS = this.hXQ;
        } else {
            this.hXS = this.hXR;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.hXT.contains(a2.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            if (e(bVar)) {
                return true;
            }
            try {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                for (int i = 0; i < a2.size(); i++) {
                    String str = a2.get(i);
                    if (this.hXX.m(str, bVar)) {
                        this.hXT.add(str);
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
    public boolean bQJ() {
        long now = this.hXs.now();
        if (!this.hXY.isInitialized() || this.hXU == -1 || now - this.hXU > hXP) {
            return bQK();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean bQK() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.hXs.now();
        long j3 = now + hXO;
        if (this.hXJ && this.hXT.isEmpty()) {
            set = this.hXT;
        } else if (this.hXJ) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.hXX.bQq()) {
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
                    if (this.hXJ) {
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
                this.hXr.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, hXm, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.hXY.getCount() != i5 || this.hXY.getSize() != j4) {
                if (this.hXJ && this.hXT != set) {
                    this.hXT.clear();
                    this.hXT.addAll(set);
                }
                this.hXY.o(j4, i5);
            }
            this.hXU = now;
            return true;
        } catch (IOException e) {
            this.hXr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, hXm, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
    private final CountDownLatch apS;
    private final boolean jZB;
    private final long jZI;
    private final long jZJ;
    private long jZK;
    @GuardedBy("mLock")
    final Set<String> jZL;
    private final long jZN;
    private final c jZP;
    private boolean jZR;
    private final CacheErrorLogger jZl;
    private final com.facebook.common.time.a jZm;
    private final g jZy;
    private final CacheEventListener jZz;
    private static final Class<?> jZg = d.class;
    private static final long jZG = TimeUnit.HOURS.toMillis(2);
    private static final long jZH = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper jZO = StatFsHelper.cFt();
    private long jZM = -1;
    private final a jZQ = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aWr = -1;
        private long jZT = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jZT = -1L;
            this.aWr = -1L;
        }

        public synchronized void u(long j, long j2) {
            this.jZT = j2;
            this.aWr = j;
            this.mInitialized = true;
        }

        public synchronized void v(long j, long j2) {
            if (this.mInitialized) {
                this.aWr += j;
                this.jZT += j2;
            }
        }

        public synchronized long getSize() {
            return this.aWr;
        }

        public synchronized long getCount() {
            return this.jZT;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jZI;
        public final long jZJ;
        public final long jZN;

        public b(long j, long j2, long j3) {
            this.jZN = j;
            this.jZI = j2;
            this.jZJ = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jZI = bVar.jZI;
        this.jZJ = bVar.jZJ;
        this.jZK = bVar.jZJ;
        this.jZP = cVar;
        this.jZy = gVar;
        this.jZz = cacheEventListener;
        this.jZN = bVar.jZN;
        this.jZl = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jZm = com.facebook.common.time.b.cFx();
        this.jZB = z;
        this.jZL = new HashSet();
        if (this.jZB) {
            this.apS = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cEL();
                    }
                    d.this.jZR = true;
                    d.this.apS.countDown();
                }
            });
            return;
        }
        this.apS = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.cER().g(bVar);
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
                    g.HF(str2);
                    com.facebook.a.a r = this.jZP.r(str2, bVar);
                    if (r != null) {
                        str = str2;
                        aVar = r;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = r;
                }
                if (aVar == null) {
                    this.jZz.b(g);
                    this.jZL.remove(str);
                } else {
                    this.jZz.a(g);
                    this.jZL.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jZl.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jZg, "getResource", e);
            g.a(e);
            this.jZz.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cEJ();
        return this.jZP.q(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aA;
        synchronized (this.mLock) {
            aA = bVar.aA(bVar2);
            this.jZL.add(str);
            this.jZQ.v(aA.size(), 1L);
        }
        return aA;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cER().g(bVar);
        this.jZz.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.HF(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.eI(a3.size()).eJ(this.jZQ.getSize());
                    this.jZz.d(g);
                    return a3;
                } finally {
                    if (!a2.cEv()) {
                        com.facebook.common.c.a.g(jZg, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jZz.f(g);
                com.facebook.common.c.a.b(jZg, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cEJ() throws IOException {
        synchronized (this.mLock) {
            boolean cEL = cEL();
            cEK();
            long size = this.jZQ.getSize();
            if (size > this.jZK && !cEL) {
                this.jZQ.reset();
                cEL();
            }
            if (size > this.jZK) {
                a((this.jZK * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jZP.cEs());
            long size = this.jZQ.getSize();
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
                long a2 = this.jZP.a(next);
                this.jZL.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eK = i.cER().HF(next.getId()).a(evictionReason).eI(a2).eJ(size - j2).eK(j);
                    this.jZz.g(eK);
                    eK.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jZQ.v(-j2, -i);
            this.jZP.cEr();
        } catch (IOException e) {
            this.jZl.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jZg, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jZG + this.jZm.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jZy.cEw());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cEK() {
        if (this.jZO.a(this.jZP.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jZJ - this.jZQ.getSize())) {
            this.jZK = this.jZI;
        } else {
            this.jZK = this.jZJ;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jZL.contains(a2.get(i))) {
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
                    if (this.jZP.s(str, bVar)) {
                        this.jZL.add(str);
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
    public boolean cEL() {
        long now = this.jZm.now();
        if (!this.jZQ.isInitialized() || this.jZM == -1 || now - this.jZM > jZH) {
            return cEM();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cEM() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jZm.now();
        long j3 = now + jZG;
        if (this.jZB && this.jZL.isEmpty()) {
            set = this.jZL;
        } else if (this.jZB) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jZP.cEs()) {
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
                    if (this.jZB) {
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
                this.jZl.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jZg, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jZQ.getCount() != i5 || this.jZQ.getSize() != j4) {
                if (this.jZB && this.jZL != set) {
                    this.jZL.clear();
                    this.jZL.addAll(set);
                }
                this.jZQ.u(j4, i5);
            }
            this.jZM = now;
            return true;
        } catch (IOException e) {
            this.jZl.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jZg, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

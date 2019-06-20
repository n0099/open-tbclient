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
    private static final Class<?> jQV = d.class;
    private static final long jRw = TimeUnit.HOURS.toMillis(2);
    private static final long jRx = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch apo;
    private long jRA;
    @GuardedBy("mLock")
    final Set<String> jRB;
    private final long jRD;
    private final c jRF;
    private boolean jRH;
    private final CacheErrorLogger jRa;
    private final com.facebook.common.time.a jRb;
    private final g jRo;
    private final CacheEventListener jRp;
    private final boolean jRr;
    private final long jRy;
    private final long jRz;
    private final Object mLock = new Object();
    private final StatFsHelper jRE = StatFsHelper.cBX();
    private long jRC = -1;
    private final a jRG = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aVH = -1;
        private long jRJ = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jRJ = -1L;
            this.aVH = -1L;
        }

        public synchronized void u(long j, long j2) {
            this.jRJ = j2;
            this.aVH = j;
            this.mInitialized = true;
        }

        public synchronized void v(long j, long j2) {
            if (this.mInitialized) {
                this.aVH += j;
                this.jRJ += j2;
            }
        }

        public synchronized long getSize() {
            return this.aVH;
        }

        public synchronized long getCount() {
            return this.jRJ;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jRD;
        public final long jRy;
        public final long jRz;

        public b(long j, long j2, long j3) {
            this.jRD = j;
            this.jRy = j2;
            this.jRz = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jRy = bVar.jRy;
        this.jRz = bVar.jRz;
        this.jRA = bVar.jRz;
        this.jRF = cVar;
        this.jRo = gVar;
        this.jRp = cacheEventListener;
        this.jRD = bVar.jRD;
        this.jRa = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jRb = com.facebook.common.time.b.cCb();
        this.jRr = z;
        this.jRB = new HashSet();
        if (this.jRr) {
            this.apo = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cBp();
                    }
                    d.this.jRH = true;
                    d.this.apo.countDown();
                }
            });
            return;
        }
        this.apo = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.cBv().g(bVar);
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
                    g.GK(str2);
                    com.facebook.a.a r = this.jRF.r(str2, bVar);
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
                    this.jRp.b(g);
                    this.jRB.remove(str);
                } else {
                    this.jRp.a(g);
                    this.jRB.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jRa.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jQV, "getResource", e);
            g.a(e);
            this.jRp.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cBn();
        return this.jRF.q(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aA;
        synchronized (this.mLock) {
            aA = bVar.aA(bVar2);
            this.jRB.add(str);
            this.jRG.v(aA.size(), 1L);
        }
        return aA;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cBv().g(bVar);
        this.jRp.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.GK(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.eA(a3.size()).eB(this.jRG.getSize());
                    this.jRp.d(g);
                    return a3;
                } finally {
                    if (!a2.cAZ()) {
                        com.facebook.common.c.a.g(jQV, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jRp.f(g);
                com.facebook.common.c.a.b(jQV, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cBn() throws IOException {
        synchronized (this.mLock) {
            boolean cBp = cBp();
            cBo();
            long size = this.jRG.getSize();
            if (size > this.jRA && !cBp) {
                this.jRG.reset();
                cBp();
            }
            if (size > this.jRA) {
                a((this.jRA * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jRF.cAW());
            long size = this.jRG.getSize();
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
                long a2 = this.jRF.a(next);
                this.jRB.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eC = i.cBv().GK(next.getId()).a(evictionReason).eA(a2).eB(size - j2).eC(j);
                    this.jRp.g(eC);
                    eC.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jRG.v(-j2, -i);
            this.jRF.cAV();
        } catch (IOException e) {
            this.jRa.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jQV, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jRw + this.jRb.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jRo.cBa());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cBo() {
        if (this.jRE.a(this.jRF.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jRz - this.jRG.getSize())) {
            this.jRA = this.jRy;
        } else {
            this.jRA = this.jRz;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jRB.contains(a2.get(i))) {
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
                    if (this.jRF.s(str, bVar)) {
                        this.jRB.add(str);
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
    public boolean cBp() {
        long now = this.jRb.now();
        if (!this.jRG.isInitialized() || this.jRC == -1 || now - this.jRC > jRx) {
            return cBq();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cBq() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jRb.now();
        long j3 = now + jRw;
        if (this.jRr && this.jRB.isEmpty()) {
            set = this.jRB;
        } else if (this.jRr) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jRF.cAW()) {
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
                    if (this.jRr) {
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
                this.jRa.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jQV, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jRG.getCount() != i5 || this.jRG.getSize() != j4) {
                if (this.jRr && this.jRB != set) {
                    this.jRB.clear();
                    this.jRB.addAll(set);
                }
                this.jRG.u(j4, i5);
            }
            this.jRC = now;
            return true;
        } catch (IOException e) {
            this.jRa.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jQV, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

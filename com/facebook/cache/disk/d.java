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
    private static final Class<?> jQS = d.class;
    private static final long jRt = TimeUnit.HOURS.toMillis(2);
    private static final long jRu = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch apo;
    private final CacheErrorLogger jQX;
    private final com.facebook.common.time.a jQY;
    private final long jRA;
    private final c jRC;
    private boolean jRE;
    private final g jRl;
    private final CacheEventListener jRm;
    private final boolean jRo;
    private final long jRv;
    private final long jRw;
    private long jRx;
    @GuardedBy("mLock")
    final Set<String> jRy;
    private final Object mLock = new Object();
    private final StatFsHelper jRB = StatFsHelper.cBY();
    private long jRz = -1;
    private final a jRD = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aVH = -1;
        private long jRG = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jRG = -1L;
            this.aVH = -1L;
        }

        public synchronized void u(long j, long j2) {
            this.jRG = j2;
            this.aVH = j;
            this.mInitialized = true;
        }

        public synchronized void v(long j, long j2) {
            if (this.mInitialized) {
                this.aVH += j;
                this.jRG += j2;
            }
        }

        public synchronized long getSize() {
            return this.aVH;
        }

        public synchronized long getCount() {
            return this.jRG;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jRA;
        public final long jRv;
        public final long jRw;

        public b(long j, long j2, long j3) {
            this.jRA = j;
            this.jRv = j2;
            this.jRw = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jRv = bVar.jRv;
        this.jRw = bVar.jRw;
        this.jRx = bVar.jRw;
        this.jRC = cVar;
        this.jRl = gVar;
        this.jRm = cacheEventListener;
        this.jRA = bVar.jRA;
        this.jQX = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jQY = com.facebook.common.time.b.cCc();
        this.jRo = z;
        this.jRy = new HashSet();
        if (this.jRo) {
            this.apo = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cBq();
                    }
                    d.this.jRE = true;
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
        i g = i.cBw().g(bVar);
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
                    g.GI(str2);
                    com.facebook.a.a r = this.jRC.r(str2, bVar);
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
                    this.jRm.b(g);
                    this.jRy.remove(str);
                } else {
                    this.jRm.a(g);
                    this.jRy.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jQX.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jQS, "getResource", e);
            g.a(e);
            this.jRm.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cBo();
        return this.jRC.q(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aA;
        synchronized (this.mLock) {
            aA = bVar.aA(bVar2);
            this.jRy.add(str);
            this.jRD.v(aA.size(), 1L);
        }
        return aA;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cBw().g(bVar);
        this.jRm.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.GI(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.eA(a3.size()).eB(this.jRD.getSize());
                    this.jRm.d(g);
                    return a3;
                } finally {
                    if (!a2.cBa()) {
                        com.facebook.common.c.a.g(jQS, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jRm.f(g);
                com.facebook.common.c.a.b(jQS, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cBo() throws IOException {
        synchronized (this.mLock) {
            boolean cBq = cBq();
            cBp();
            long size = this.jRD.getSize();
            if (size > this.jRx && !cBq) {
                this.jRD.reset();
                cBq();
            }
            if (size > this.jRx) {
                a((this.jRx * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jRC.cAX());
            long size = this.jRD.getSize();
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
                long a2 = this.jRC.a(next);
                this.jRy.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eC = i.cBw().GI(next.getId()).a(evictionReason).eA(a2).eB(size - j2).eC(j);
                    this.jRm.g(eC);
                    eC.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jRD.v(-j2, -i);
            this.jRC.cAW();
        } catch (IOException e) {
            this.jQX.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jQS, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jRt + this.jQY.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jRl.cBb());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cBp() {
        if (this.jRB.a(this.jRC.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jRw - this.jRD.getSize())) {
            this.jRx = this.jRv;
        } else {
            this.jRx = this.jRw;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jRy.contains(a2.get(i))) {
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
                    if (this.jRC.s(str, bVar)) {
                        this.jRy.add(str);
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
    public boolean cBq() {
        long now = this.jQY.now();
        if (!this.jRD.isInitialized() || this.jRz == -1 || now - this.jRz > jRu) {
            return cBr();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cBr() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jQY.now();
        long j3 = now + jRt;
        if (this.jRo && this.jRy.isEmpty()) {
            set = this.jRy;
        } else if (this.jRo) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jRC.cAX()) {
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
                    if (this.jRo) {
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
                this.jQX.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jQS, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jRD.getCount() != i5 || this.jRD.getSize() != j4) {
                if (this.jRo && this.jRy != set) {
                    this.jRy.clear();
                    this.jRy.addAll(set);
                }
                this.jRD.u(j4, i5);
            }
            this.jRz = now;
            return true;
        } catch (IOException e) {
            this.jQX.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jQS, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

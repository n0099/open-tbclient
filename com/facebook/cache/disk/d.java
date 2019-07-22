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
    private final long jYC;
    private final long jYD;
    private long jYE;
    @GuardedBy("mLock")
    final Set<String> jYF;
    private final long jYH;
    private final c jYJ;
    private boolean jYL;
    private final CacheErrorLogger jYf;
    private final com.facebook.common.time.a jYg;
    private final g jYs;
    private final CacheEventListener jYt;
    private final boolean jYv;
    private static final Class<?> jYa = d.class;
    private static final long jYA = TimeUnit.HOURS.toMillis(2);
    private static final long jYB = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper jYI = StatFsHelper.cEY();
    private long jYG = -1;
    private final a jYK = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aWr = -1;
        private long jYN = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jYN = -1L;
            this.aWr = -1L;
        }

        public synchronized void u(long j, long j2) {
            this.jYN = j2;
            this.aWr = j;
            this.mInitialized = true;
        }

        public synchronized void v(long j, long j2) {
            if (this.mInitialized) {
                this.aWr += j;
                this.jYN += j2;
            }
        }

        public synchronized long getSize() {
            return this.aWr;
        }

        public synchronized long getCount() {
            return this.jYN;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jYC;
        public final long jYD;
        public final long jYH;

        public b(long j, long j2, long j3) {
            this.jYH = j;
            this.jYC = j2;
            this.jYD = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jYC = bVar.jYC;
        this.jYD = bVar.jYD;
        this.jYE = bVar.jYD;
        this.jYJ = cVar;
        this.jYs = gVar;
        this.jYt = cacheEventListener;
        this.jYH = bVar.jYH;
        this.jYf = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jYg = com.facebook.common.time.b.cFc();
        this.jYv = z;
        this.jYF = new HashSet();
        if (this.jYv) {
            this.apS = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cEq();
                    }
                    d.this.jYL = true;
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
        i g = i.cEw().g(bVar);
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
                    g.HE(str2);
                    com.facebook.a.a r = this.jYJ.r(str2, bVar);
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
                    this.jYt.b(g);
                    this.jYF.remove(str);
                } else {
                    this.jYt.a(g);
                    this.jYF.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jYf.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jYa, "getResource", e);
            g.a(e);
            this.jYt.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cEo();
        return this.jYJ.q(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aA;
        synchronized (this.mLock) {
            aA = bVar.aA(bVar2);
            this.jYF.add(str);
            this.jYK.v(aA.size(), 1L);
        }
        return aA;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cEw().g(bVar);
        this.jYt.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.HE(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.eI(a3.size()).eJ(this.jYK.getSize());
                    this.jYt.d(g);
                    return a3;
                } finally {
                    if (!a2.cEa()) {
                        com.facebook.common.c.a.g(jYa, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jYt.f(g);
                com.facebook.common.c.a.b(jYa, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cEo() throws IOException {
        synchronized (this.mLock) {
            boolean cEq = cEq();
            cEp();
            long size = this.jYK.getSize();
            if (size > this.jYE && !cEq) {
                this.jYK.reset();
                cEq();
            }
            if (size > this.jYE) {
                a((this.jYE * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jYJ.cDX());
            long size = this.jYK.getSize();
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
                long a2 = this.jYJ.a(next);
                this.jYF.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eK = i.cEw().HE(next.getId()).a(evictionReason).eI(a2).eJ(size - j2).eK(j);
                    this.jYt.g(eK);
                    eK.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jYK.v(-j2, -i);
            this.jYJ.cDW();
        } catch (IOException e) {
            this.jYf.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jYa, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jYA + this.jYg.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jYs.cEb());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cEp() {
        if (this.jYI.a(this.jYJ.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jYD - this.jYK.getSize())) {
            this.jYE = this.jYC;
        } else {
            this.jYE = this.jYD;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jYF.contains(a2.get(i))) {
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
                    if (this.jYJ.s(str, bVar)) {
                        this.jYF.add(str);
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
    public boolean cEq() {
        long now = this.jYg.now();
        if (!this.jYK.isInitialized() || this.jYG == -1 || now - this.jYG > jYB) {
            return cEr();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cEr() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jYg.now();
        long j3 = now + jYA;
        if (this.jYv && this.jYF.isEmpty()) {
            set = this.jYF;
        } else if (this.jYv) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jYJ.cDX()) {
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
                    if (this.jYv) {
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
                this.jYf.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jYa, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jYK.getCount() != i5 || this.jYK.getSize() != j4) {
                if (this.jYv && this.jYF != set) {
                    this.jYF.clear();
                    this.jYF.addAll(set);
                }
                this.jYK.u(j4, i5);
            }
            this.jYG = now;
            return true;
        } catch (IOException e) {
            this.jYf.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jYa, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

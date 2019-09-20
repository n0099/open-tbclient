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
    private static final Class<?> kbD = d.class;
    private static final long kcd = TimeUnit.HOURS.toMillis(2);
    private static final long kce = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch aqq;
    private final CacheErrorLogger kbI;
    private final com.facebook.common.time.a kbJ;
    private final g kbV;
    private final CacheEventListener kbW;
    private final boolean kbY;
    private final long kcf;
    private final long kcg;
    private long kch;
    @GuardedBy("mLock")
    final Set<String> kci;
    private final long kck;
    private final c kcm;
    private boolean kco;
    private final Object mLock = new Object();
    private final StatFsHelper kcl = StatFsHelper.cGh();
    private long kcj = -1;
    private final a kcn = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aWP = -1;
        private long kcq = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.kcq = -1L;
            this.aWP = -1L;
        }

        public synchronized void u(long j, long j2) {
            this.kcq = j2;
            this.aWP = j;
            this.mInitialized = true;
        }

        public synchronized void v(long j, long j2) {
            if (this.mInitialized) {
                this.aWP += j;
                this.kcq += j2;
            }
        }

        public synchronized long getSize() {
            return this.aWP;
        }

        public synchronized long getCount() {
            return this.kcq;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long kcf;
        public final long kcg;
        public final long kck;

        public b(long j, long j2, long j3) {
            this.kck = j;
            this.kcf = j2;
            this.kcg = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.kcf = bVar.kcf;
        this.kcg = bVar.kcg;
        this.kch = bVar.kcg;
        this.kcm = cVar;
        this.kbV = gVar;
        this.kbW = cacheEventListener;
        this.kck = bVar.kck;
        this.kbI = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.kbJ = com.facebook.common.time.b.cGl();
        this.kbY = z;
        this.kci = new HashSet();
        if (this.kbY) {
            this.aqq = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cFz();
                    }
                    d.this.kco = true;
                    d.this.aqq.countDown();
                }
            });
            return;
        }
        this.aqq = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.cFF().g(bVar);
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
                    g.If(str2);
                    com.facebook.a.a r = this.kcm.r(str2, bVar);
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
                    this.kbW.b(g);
                    this.kci.remove(str);
                } else {
                    this.kbW.a(g);
                    this.kci.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.kbI.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, kbD, "getResource", e);
            g.a(e);
            this.kbW.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cFx();
        return this.kcm.q(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aA;
        synchronized (this.mLock) {
            aA = bVar.aA(bVar2);
            this.kci.add(str);
            this.kcn.v(aA.size(), 1L);
        }
        return aA;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cFF().g(bVar);
        this.kbW.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.If(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.eL(a3.size()).eM(this.kcn.getSize());
                    this.kbW.d(g);
                    return a3;
                } finally {
                    if (!a2.cFj()) {
                        com.facebook.common.c.a.g(kbD, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.kbW.f(g);
                com.facebook.common.c.a.b(kbD, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cFx() throws IOException {
        synchronized (this.mLock) {
            boolean cFz = cFz();
            cFy();
            long size = this.kcn.getSize();
            if (size > this.kch && !cFz) {
                this.kcn.reset();
                cFz();
            }
            if (size > this.kch) {
                a((this.kch * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.kcm.cFg());
            long size = this.kcn.getSize();
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
                long a2 = this.kcm.a(next);
                this.kci.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eN = i.cFF().If(next.getId()).a(evictionReason).eL(a2).eM(size - j2).eN(j);
                    this.kbW.g(eN);
                    eN.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.kcn.v(-j2, -i);
            this.kcm.cFf();
        } catch (IOException e) {
            this.kbI.a(CacheErrorLogger.CacheErrorCategory.EVICTION, kbD, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = kcd + this.kbJ.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.kbV.cFk());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cFy() {
        if (this.kcl.a(this.kcm.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.kcg - this.kcn.getSize())) {
            this.kch = this.kcf;
        } else {
            this.kch = this.kcg;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.kci.contains(a2.get(i))) {
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
                    if (this.kcm.s(str, bVar)) {
                        this.kci.add(str);
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
    public boolean cFz() {
        long now = this.kbJ.now();
        if (!this.kcn.isInitialized() || this.kcj == -1 || now - this.kcj > kce) {
            return cFA();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cFA() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.kbJ.now();
        long j3 = now + kcd;
        if (this.kbY && this.kci.isEmpty()) {
            set = this.kci;
        } else if (this.kbY) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.kcm.cFg()) {
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
                    if (this.kbY) {
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
                this.kbI.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, kbD, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.kcn.getCount() != i5 || this.kcn.getSize() != j4) {
                if (this.kbY && this.kci != set) {
                    this.kci.clear();
                    this.kci.addAll(set);
                }
                this.kcn.u(j4, i5);
            }
            this.kcj = now;
            return true;
        } catch (IOException e) {
            this.kbI.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, kbD, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

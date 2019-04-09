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
    private final CountDownLatch apc;
    private final long jyE;
    private final long jyF;
    private long jyG;
    @GuardedBy("mLock")
    final Set<String> jyH;
    private final long jyJ;
    private final c jyL;
    private boolean jyN;
    private final CacheErrorLogger jyg;
    private final com.facebook.common.time.a jyh;
    private final g jyu;
    private final CacheEventListener jyv;
    private final boolean jyx;
    private static final Class<?> jyb = d.class;
    private static final long jyC = TimeUnit.HOURS.toMillis(2);
    private static final long jyD = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper jyK = StatFsHelper.ctZ();
    private long jyI = -1;
    private final a jyM = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aSS = -1;
        private long jyP = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jyP = -1L;
            this.aSS = -1L;
        }

        public synchronized void t(long j, long j2) {
            this.jyP = j2;
            this.aSS = j;
            this.mInitialized = true;
        }

        public synchronized void u(long j, long j2) {
            if (this.mInitialized) {
                this.aSS += j;
                this.jyP += j2;
            }
        }

        public synchronized long getSize() {
            return this.aSS;
        }

        public synchronized long getCount() {
            return this.jyP;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jyE;
        public final long jyF;
        public final long jyJ;

        public b(long j, long j2, long j3) {
            this.jyJ = j;
            this.jyE = j2;
            this.jyF = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jyE = bVar.jyE;
        this.jyF = bVar.jyF;
        this.jyG = bVar.jyF;
        this.jyL = cVar;
        this.jyu = gVar;
        this.jyv = cacheEventListener;
        this.jyJ = bVar.jyJ;
        this.jyg = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jyh = com.facebook.common.time.b.cue();
        this.jyx = z;
        this.jyH = new HashSet();
        if (this.jyx) {
            this.apc = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.ctr();
                    }
                    d.this.jyN = true;
                    d.this.apc.countDown();
                }
            });
            return;
        }
        this.apc = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.ctx().g(bVar);
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
                    g.Fn(str2);
                    com.facebook.a.a o = this.jyL.o(str2, bVar);
                    if (o != null) {
                        str = str2;
                        aVar = o;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = o;
                }
                if (aVar == null) {
                    this.jyv.b(g);
                    this.jyH.remove(str);
                } else {
                    this.jyv.a(g);
                    this.jyH.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jyg.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyb, "getResource", e);
            g.a(e);
            this.jyv.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        ctp();
        return this.jyL.n(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a ay;
        synchronized (this.mLock) {
            ay = bVar.ay(bVar2);
            this.jyH.add(str);
            this.jyM.u(ay.size(), 1L);
        }
        return ay;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.ctx().g(bVar);
        this.jyv.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.Fn(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.eb(a3.size()).ec(this.jyM.getSize());
                    this.jyv.d(g);
                    return a3;
                } finally {
                    if (!a2.ctb()) {
                        com.facebook.common.c.a.g(jyb, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jyv.f(g);
                com.facebook.common.c.a.b(jyb, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void ctp() throws IOException {
        synchronized (this.mLock) {
            boolean ctr = ctr();
            ctq();
            long size = this.jyM.getSize();
            if (size > this.jyG && !ctr) {
                this.jyM.reset();
                ctr();
            }
            if (size > this.jyG) {
                a((this.jyG * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jyL.csY());
            long size = this.jyM.getSize();
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
                long a2 = this.jyL.a(next);
                this.jyH.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i ed = i.ctx().Fn(next.getId()).a(evictionReason).eb(a2).ec(size - j2).ed(j);
                    this.jyv.g(ed);
                    ed.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jyM.u(-j2, -i);
            this.jyL.csX();
        } catch (IOException e) {
            this.jyg.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jyb, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jyC + this.jyh.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jyu.ctc());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void ctq() {
        if (this.jyK.a(this.jyL.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jyF - this.jyM.getSize())) {
            this.jyG = this.jyE;
        } else {
            this.jyG = this.jyF;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jyH.contains(a2.get(i))) {
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
                    if (this.jyL.p(str, bVar)) {
                        this.jyH.add(str);
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
    public boolean ctr() {
        long now = this.jyh.now();
        if (!this.jyM.isInitialized() || this.jyI == -1 || now - this.jyI > jyD) {
            return cts();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cts() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jyh.now();
        long j3 = now + jyC;
        if (this.jyx && this.jyH.isEmpty()) {
            set = this.jyH;
        } else if (this.jyx) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jyL.csY()) {
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
                    if (this.jyx) {
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
                this.jyg.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jyb, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jyM.getCount() != i5 || this.jyM.getSize() != j4) {
                if (this.jyx && this.jyH != set) {
                    this.jyH.clear();
                    this.jyH.addAll(set);
                }
                this.jyM.t(j4, i5);
            }
            this.jyI = now;
            return true;
        } catch (IOException e) {
            this.jyg.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyb, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

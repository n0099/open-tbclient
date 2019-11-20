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
    private static final Class<?> jYW = d.class;
    private static final long jZw = TimeUnit.HOURS.toMillis(2);
    private static final long jZx = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch aJo;
    private long jZA;
    @GuardedBy("mLock")
    final Set<String> jZB;
    private final long jZD;
    private final c jZF;
    private boolean jZH;
    private final CacheErrorLogger jZb;
    private final com.facebook.common.time.a jZc;
    private final g jZo;
    private final CacheEventListener jZp;
    private final boolean jZr;
    private final long jZy;
    private final long jZz;
    private final Object mLock = new Object();
    private final StatFsHelper jZE = StatFsHelper.cDd();
    private long jZC = -1;
    private final a jZG = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long dEO = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.dEO = -1L;
            this.mSize = -1L;
        }

        public synchronized void A(long j, long j2) {
            this.dEO = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void B(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.dEO += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.dEO;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jZD;
        public final long jZy;
        public final long jZz;

        public b(long j, long j2, long j3) {
            this.jZD = j;
            this.jZy = j2;
            this.jZz = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jZy = bVar.jZy;
        this.jZz = bVar.jZz;
        this.jZA = bVar.jZz;
        this.jZF = cVar;
        this.jZo = gVar;
        this.jZp = cacheEventListener;
        this.jZD = bVar.jZD;
        this.jZb = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jZc = com.facebook.common.time.b.cDh();
        this.jZr = z;
        this.jZB = new HashSet();
        if (this.jZr) {
            this.aJo = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cCv();
                    }
                    d.this.jZH = true;
                    d.this.aJo.countDown();
                }
            });
            return;
        }
        this.aJo = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.cCB().g(bVar);
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
                    g.Gw(str2);
                    com.facebook.a.a o = this.jZF.o(str2, bVar);
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
                    this.jZp.b(g);
                    this.jZB.remove(str);
                } else {
                    this.jZp.a(g);
                    this.jZB.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jZb.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jYW, "getResource", e);
            g.a(e);
            this.jZp.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cCt();
        return this.jZF.n(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a av;
        synchronized (this.mLock) {
            av = bVar.av(bVar2);
            this.jZB.add(str);
            this.jZG.B(av.size(), 1L);
        }
        return av;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cCB().g(bVar);
        this.jZp.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.Gw(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.ee(a3.size()).ef(this.jZG.getSize());
                    this.jZp.d(g);
                    return a3;
                } finally {
                    if (!a2.cCf()) {
                        com.facebook.common.c.a.f(jYW, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jZp.f(g);
                com.facebook.common.c.a.b(jYW, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cCt() throws IOException {
        synchronized (this.mLock) {
            boolean cCv = cCv();
            cCu();
            long size = this.jZG.getSize();
            if (size > this.jZA && !cCv) {
                this.jZG.reset();
                cCv();
            }
            if (size > this.jZA) {
                a((this.jZA * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> e = e(this.jZF.cCc());
            long size = this.jZG.getSize();
            long j3 = size - j;
            int i2 = 0;
            long j4 = 0;
            Iterator<c.a> it = e.iterator();
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
                long a2 = this.jZF.a(next);
                this.jZB.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eg = i.cCB().Gw(next.getId()).a(evictionReason).ee(a2).ef(size - j2).eg(j);
                    this.jZp.g(eg);
                    eg.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jZG.B(-j2, -i);
            this.jZF.cCb();
        } catch (IOException e2) {
            this.jZb.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jYW, "evictAboveSize: " + e2.getMessage(), e2);
            throw e2;
        }
    }

    private Collection<c.a> e(Collection<c.a> collection) {
        long now = jZw + this.jZc.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jZo.cCg());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cCu() {
        if (this.jZE.a(this.jZF.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jZz - this.jZG.getSize())) {
            this.jZA = this.jZy;
        } else {
            this.jZA = this.jZz;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jZB.contains(a2.get(i))) {
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
                    if (this.jZF.p(str, bVar)) {
                        this.jZB.add(str);
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
    public boolean cCv() {
        long now = this.jZc.now();
        if (!this.jZG.isInitialized() || this.jZC == -1 || now - this.jZC > jZx) {
            return cCw();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cCw() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jZc.now();
        long j3 = now + jZw;
        if (this.jZr && this.jZB.isEmpty()) {
            set = this.jZB;
        } else if (this.jZr) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jZF.cCc()) {
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
                    if (this.jZr) {
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
                this.jZb.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jYW, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jZG.getCount() != i5 || this.jZG.getSize() != j4) {
                if (this.jZr && this.jZB != set) {
                    this.jZB.clear();
                    this.jZB.addAll(set);
                }
                this.jZG.A(j4, i5);
            }
            this.jZC = now;
            return true;
        } catch (IOException e) {
            this.jZb.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jYW, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
    private static final Class<?> jZN = d.class;
    private static final long kan = TimeUnit.HOURS.toMillis(2);
    private static final long kao = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch aJG;
    private final CacheErrorLogger jZS;
    private final com.facebook.common.time.a jZT;
    private final g kaf;
    private final CacheEventListener kag;
    private final boolean kai;
    private final long kap;
    private final long kaq;
    private long kar;
    @GuardedBy("mLock")
    final Set<String> kas;
    private final long kau;
    private final c kaw;
    private boolean kay;
    private final Object mLock = new Object();
    private final StatFsHelper kav = StatFsHelper.cDf();
    private long kat = -1;
    private final a kax = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long dFF = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.dFF = -1L;
            this.mSize = -1L;
        }

        public synchronized void A(long j, long j2) {
            this.dFF = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void B(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.dFF += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.dFF;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long kap;
        public final long kaq;
        public final long kau;

        public b(long j, long j2, long j3) {
            this.kau = j;
            this.kap = j2;
            this.kaq = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.kap = bVar.kap;
        this.kaq = bVar.kaq;
        this.kar = bVar.kaq;
        this.kaw = cVar;
        this.kaf = gVar;
        this.kag = cacheEventListener;
        this.kau = bVar.kau;
        this.jZS = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jZT = com.facebook.common.time.b.cDj();
        this.kai = z;
        this.kas = new HashSet();
        if (this.kai) {
            this.aJG = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cCx();
                    }
                    d.this.kay = true;
                    d.this.aJG.countDown();
                }
            });
            return;
        }
        this.aJG = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.cCD().g(bVar);
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
                    com.facebook.a.a o = this.kaw.o(str2, bVar);
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
                    this.kag.b(g);
                    this.kas.remove(str);
                } else {
                    this.kag.a(g);
                    this.kas.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jZS.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jZN, "getResource", e);
            g.a(e);
            this.kag.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        cCv();
        return this.kaw.n(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a av;
        synchronized (this.mLock) {
            av = bVar.av(bVar2);
            this.kas.add(str);
            this.kax.B(av.size(), 1L);
        }
        return av;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.cCD().g(bVar);
        this.kag.c(g);
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
                    g.ef(a3.size()).eg(this.kax.getSize());
                    this.kag.d(g);
                    return a3;
                } finally {
                    if (!a2.cCh()) {
                        com.facebook.common.c.a.f(jZN, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.kag.f(g);
                com.facebook.common.c.a.b(jZN, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void cCv() throws IOException {
        synchronized (this.mLock) {
            boolean cCx = cCx();
            cCw();
            long size = this.kax.getSize();
            if (size > this.kar && !cCx) {
                this.kax.reset();
                cCx();
            }
            if (size > this.kar) {
                a((this.kar * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> e = e(this.kaw.cCe());
            long size = this.kax.getSize();
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
                long a2 = this.kaw.a(next);
                this.kas.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eh = i.cCD().Gw(next.getId()).a(evictionReason).ef(a2).eg(size - j2).eh(j);
                    this.kag.g(eh);
                    eh.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.kax.B(-j2, -i);
            this.kaw.cCd();
        } catch (IOException e2) {
            this.jZS.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jZN, "evictAboveSize: " + e2.getMessage(), e2);
            throw e2;
        }
    }

    private Collection<c.a> e(Collection<c.a> collection) {
        long now = kan + this.jZT.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.kaf.cCi());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void cCw() {
        if (this.kav.a(this.kaw.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.kaq - this.kax.getSize())) {
            this.kar = this.kap;
        } else {
            this.kar = this.kaq;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.kas.contains(a2.get(i))) {
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
                    if (this.kaw.p(str, bVar)) {
                        this.kas.add(str);
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
    public boolean cCx() {
        long now = this.jZT.now();
        if (!this.kax.isInitialized() || this.kat == -1 || now - this.kat > kao) {
            return cCy();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean cCy() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jZT.now();
        long j3 = now + kan;
        if (this.kai && this.kas.isEmpty()) {
            set = this.kas;
        } else if (this.kai) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.kaw.cCe()) {
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
                    if (this.kai) {
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
                this.jZS.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jZN, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.kax.getCount() != i5 || this.kax.getSize() != j4) {
                if (this.kai && this.kas != set) {
                    this.kas.clear();
                    this.kas.addAll(set);
                }
                this.kax.A(j4, i5);
            }
            this.kat = now;
            return true;
        } catch (IOException e) {
            this.jZS.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jZN, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
    private static final Class<?> hVC = d.class;
    private static final long hWe = TimeUnit.HOURS.toMillis(2);
    private static final long hWf = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger hVH;
    private final com.facebook.common.time.a hVI;
    private final g hVW;
    private final CacheEventListener hVX;
    private final boolean hVZ;
    private final long hWg;
    private final long hWh;
    private long hWi;
    @GuardedBy("mLock")
    final Set<String> hWj;
    private final long hWl;
    private final c hWn;
    private boolean hWp;
    private final CountDownLatch mCountDownLatch;
    private final Object mLock = new Object();
    private final StatFsHelper hWm = StatFsHelper.bRW();
    private long hWk = -1;
    private final a hWo = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean hWr = false;
        private long mSize = -1;
        private long hWs = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.hWr;
        }

        public synchronized void reset() {
            this.hWr = false;
            this.hWs = -1L;
            this.mSize = -1L;
        }

        public synchronized void p(long j, long j2) {
            this.hWs = j2;
            this.mSize = j;
            this.hWr = true;
        }

        public synchronized void q(long j, long j2) {
            if (this.hWr) {
                this.mSize += j;
                this.hWs += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.hWs;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long hWg;
        public final long hWh;
        public final long hWl;

        public b(long j, long j2, long j3) {
            this.hWl = j;
            this.hWg = j2;
            this.hWh = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.hWg = bVar.hWg;
        this.hWh = bVar.hWh;
        this.hWi = bVar.hWh;
        this.hWn = cVar;
        this.hVW = gVar;
        this.hVX = cacheEventListener;
        this.hWl = bVar.hWl;
        this.hVH = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.hVI = com.facebook.common.time.b.bSb();
        this.hVZ = z;
        this.hWj = new HashSet();
        if (this.hVZ) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bRo();
                    }
                    d.this.hWp = true;
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
        i g = i.bRu().g(bVar);
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
                    g.yt(str2);
                    com.facebook.a.a l = this.hWn.l(str2, bVar);
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
                    this.hVX.b(g);
                    this.hWj.remove(str);
                } else {
                    this.hVX.a(g);
                    this.hWj.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.hVH.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, hVC, "getResource", e);
            g.a(e);
            this.hVX.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bRm();
        return this.hWn.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a am;
        synchronized (this.mLock) {
            am = bVar.am(bVar2);
            this.hWj.add(str);
            this.hWo.q(am.size(), 1L);
        }
        return am;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bRu().g(bVar);
        this.hVX.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.yt(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.dq(a3.size()).dr(this.hWo.getSize());
                    this.hVX.d(g);
                    return a3;
                } finally {
                    if (!a2.bQY()) {
                        com.facebook.common.c.a.g(hVC, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.hVX.f(g);
                com.facebook.common.c.a.b(hVC, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void bRm() throws IOException {
        synchronized (this.mLock) {
            boolean bRo = bRo();
            bRn();
            long size = this.hWo.getSize();
            if (size > this.hWi && !bRo) {
                this.hWo.reset();
                bRo();
            }
            if (size > this.hWi) {
                a((this.hWi * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> d = d(this.hWn.bQV());
            long size = this.hWo.getSize();
            long j3 = size - j;
            int i2 = 0;
            long j4 = 0;
            Iterator<c.a> it = d.iterator();
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
                long a2 = this.hWn.a(next);
                this.hWj.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i ds = i.bRu().yt(next.getId()).a(evictionReason).dq(a2).dr(size - j2).ds(j);
                    this.hVX.g(ds);
                    ds.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.hWo.q(-j2, -i);
            this.hWn.bQU();
        } catch (IOException e) {
            this.hVH.a(CacheErrorLogger.CacheErrorCategory.EVICTION, hVC, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> d(Collection<c.a> collection) {
        long now = hWe + this.hVI.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.hVW.bQZ());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bRn() {
        if (this.hWm.a(this.hWn.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.hWh - this.hWo.getSize())) {
            this.hWi = this.hWg;
        } else {
            this.hWi = this.hWh;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.hWj.contains(a2.get(i))) {
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
                    if (this.hWn.m(str, bVar)) {
                        this.hWj.add(str);
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
    public boolean bRo() {
        long now = this.hVI.now();
        if (!this.hWo.isInitialized() || this.hWk == -1 || now - this.hWk > hWf) {
            return bRp();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean bRp() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.hVI.now();
        long j3 = now + hWe;
        if (this.hVZ && this.hWj.isEmpty()) {
            set = this.hWj;
        } else if (this.hVZ) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.hWn.bQV()) {
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
                    if (this.hVZ) {
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
                this.hVH.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, hVC, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.hWo.getCount() != i5 || this.hWo.getSize() != j4) {
                if (this.hVZ && this.hWj != set) {
                    this.hWj.clear();
                    this.hWj.addAll(set);
                }
                this.hWo.p(j4, i5);
            }
            this.hWk = now;
            return true;
        } catch (IOException e) {
            this.hVH.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, hVC, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

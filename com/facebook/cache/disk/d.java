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
    private static final Class<?> hVB = d.class;
    private static final long hWd = TimeUnit.HOURS.toMillis(2);
    private static final long hWe = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger hVG;
    private final com.facebook.common.time.a hVH;
    private final g hVV;
    private final CacheEventListener hVW;
    private final boolean hVY;
    private final long hWf;
    private final long hWg;
    private long hWh;
    @GuardedBy("mLock")
    final Set<String> hWi;
    private final long hWk;
    private final c hWm;
    private boolean hWo;
    private final CountDownLatch mCountDownLatch;
    private final Object mLock = new Object();
    private final StatFsHelper hWl = StatFsHelper.bRW();
    private long hWj = -1;
    private final a hWn = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean hWq = false;
        private long mSize = -1;
        private long hWr = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.hWq;
        }

        public synchronized void reset() {
            this.hWq = false;
            this.hWr = -1L;
            this.mSize = -1L;
        }

        public synchronized void p(long j, long j2) {
            this.hWr = j2;
            this.mSize = j;
            this.hWq = true;
        }

        public synchronized void q(long j, long j2) {
            if (this.hWq) {
                this.mSize += j;
                this.hWr += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.hWr;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long hWf;
        public final long hWg;
        public final long hWk;

        public b(long j, long j2, long j3) {
            this.hWk = j;
            this.hWf = j2;
            this.hWg = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.hWf = bVar.hWf;
        this.hWg = bVar.hWg;
        this.hWh = bVar.hWg;
        this.hWm = cVar;
        this.hVV = gVar;
        this.hVW = cacheEventListener;
        this.hWk = bVar.hWk;
        this.hVG = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.hVH = com.facebook.common.time.b.bSb();
        this.hVY = z;
        this.hWi = new HashSet();
        if (this.hVY) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bRo();
                    }
                    d.this.hWo = true;
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
                    com.facebook.a.a l = this.hWm.l(str2, bVar);
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
                    this.hVW.b(g);
                    this.hWi.remove(str);
                } else {
                    this.hVW.a(g);
                    this.hWi.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.hVG.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, hVB, "getResource", e);
            g.a(e);
            this.hVW.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bRm();
        return this.hWm.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a am;
        synchronized (this.mLock) {
            am = bVar.am(bVar2);
            this.hWi.add(str);
            this.hWn.q(am.size(), 1L);
        }
        return am;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bRu().g(bVar);
        this.hVW.c(g);
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
                    g.dq(a3.size()).dr(this.hWn.getSize());
                    this.hVW.d(g);
                    return a3;
                } finally {
                    if (!a2.bQY()) {
                        com.facebook.common.c.a.g(hVB, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.hVW.f(g);
                com.facebook.common.c.a.b(hVB, "Failed inserting a file into the cache", (Throwable) e);
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
            long size = this.hWn.getSize();
            if (size > this.hWh && !bRo) {
                this.hWn.reset();
                bRo();
            }
            if (size > this.hWh) {
                a((this.hWh * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> d = d(this.hWm.bQV());
            long size = this.hWn.getSize();
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
                long a2 = this.hWm.a(next);
                this.hWi.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i ds = i.bRu().yt(next.getId()).a(evictionReason).dq(a2).dr(size - j2).ds(j);
                    this.hVW.g(ds);
                    ds.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.hWn.q(-j2, -i);
            this.hWm.bQU();
        } catch (IOException e) {
            this.hVG.a(CacheErrorLogger.CacheErrorCategory.EVICTION, hVB, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> d(Collection<c.a> collection) {
        long now = hWd + this.hVH.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.hVV.bQZ());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bRn() {
        if (this.hWl.a(this.hWm.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.hWg - this.hWn.getSize())) {
            this.hWh = this.hWf;
        } else {
            this.hWh = this.hWg;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.hWi.contains(a2.get(i))) {
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
                    if (this.hWm.m(str, bVar)) {
                        this.hWi.add(str);
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
        long now = this.hVH.now();
        if (!this.hWn.isInitialized() || this.hWj == -1 || now - this.hWj > hWe) {
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
        long now = this.hVH.now();
        long j3 = now + hWd;
        if (this.hVY && this.hWi.isEmpty()) {
            set = this.hWi;
        } else if (this.hVY) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.hWm.bQV()) {
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
                    if (this.hVY) {
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
                this.hVG.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, hVB, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.hWn.getCount() != i5 || this.hWn.getSize() != j4) {
                if (this.hVY && this.hWi != set) {
                    this.hWi.clear();
                    this.hWi.addAll(set);
                }
                this.hWn.p(j4, i5);
            }
            this.hWj = now;
            return true;
        } catch (IOException e) {
            this.hVG.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, hVB, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
/* loaded from: classes13.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> lGY = d.class;
    private static final long lHx = TimeUnit.HOURS.toMillis(2);
    private static final long lHy = TimeUnit.MINUTES.toMillis(30);
    private final long lHA;
    private final CountDownLatch lHB;
    private long lHC;
    @GuardedBy("mLock")
    final Set<String> lHD;
    private final long lHF;
    private final c lHH;
    private boolean lHJ;
    private final CacheErrorLogger lHd;
    private final com.facebook.common.time.a lHe;
    private final g lHp;
    private final CacheEventListener lHq;
    private final boolean lHs;
    private final long lHz;
    private final Object mLock = new Object();
    private final StatFsHelper lHG = StatFsHelper.dkX();
    private long lHE = -1;
    private final a lHI = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long evZ = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.evZ = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.evZ = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.evZ += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.evZ;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long lHA;
        public final long lHF;
        public final long lHz;

        public b(long j, long j2, long j3) {
            this.lHF = j;
            this.lHz = j2;
            this.lHA = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lHz = bVar.lHz;
        this.lHA = bVar.lHA;
        this.lHC = bVar.lHA;
        this.lHH = cVar;
        this.lHp = gVar;
        this.lHq = cacheEventListener;
        this.lHF = bVar.lHF;
        this.lHd = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lHe = com.facebook.common.time.c.dlb();
        this.lHs = z;
        this.lHD = new HashSet();
        if (this.lHs) {
            this.lHB = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dkq();
                    }
                    d.this.lHJ = true;
                    d.this.lHB.countDown();
                }
            });
            return;
        }
        this.lHB = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dkw().h(bVar);
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
                    h.OO(str2);
                    com.facebook.a.a v = this.lHH.v(str2, bVar);
                    if (v != null) {
                        str = str2;
                        aVar = v;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = v;
                }
                if (aVar == null) {
                    this.lHq.b(h);
                    this.lHD.remove(str);
                } else {
                    this.lHq.a(h);
                    this.lHD.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lHd.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lGY, "getResource", e);
            h.b(e);
            this.lHq.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dko();
        return this.lHH.u(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aQ;
        synchronized (this.mLock) {
            aQ = bVar.aQ(bVar2);
            this.lHD.add(str);
            this.lHI.J(aQ.size(), 1L);
        }
        return aQ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dkw().h(bVar);
        this.lHq.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.OO(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.eV(a3.size()).eW(this.lHI.getSize());
                    this.lHq.d(h);
                    return a3;
                } finally {
                    if (!a2.dka()) {
                        com.facebook.common.c.a.h(lGY, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.b(e);
                this.lHq.f(h);
                com.facebook.common.c.a.b(lGY, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            h.recycle();
        }
    }

    @Override // com.facebook.cache.disk.h
    public void e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            try {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a2.size()) {
                        break;
                    }
                    String str = a2.get(i2);
                    this.lHH.OK(str);
                    this.lHD.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lHd.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lGY, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dko() throws IOException {
        synchronized (this.mLock) {
            boolean dkq = dkq();
            dkp();
            long size = this.lHI.getSize();
            if (size > this.lHC && !dkq) {
                this.lHI.reset();
                dkq();
            }
            if (size > this.lHC) {
                a((this.lHC * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lHH.djX());
            long size = this.lHI.getSize();
            long j3 = size - j;
            int i2 = 0;
            long j4 = 0;
            Iterator<c.a> it = h.iterator();
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
                long a2 = this.lHH.a(next);
                this.lHD.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eX = i.dkw().OO(next.getId()).a(evictionReason).eV(a2).eW(size - j2).eX(j);
                    this.lHq.g(eX);
                    eX.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lHI.J(-j2, -i);
            this.lHH.djW();
        } catch (IOException e) {
            this.lHd.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lGY, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lHx + this.lHe.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lHp.dkb());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dkp() {
        if (this.lHG.a(this.lHH.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lHA - this.lHI.getSize())) {
            this.lHC = this.lHz;
        } else {
            this.lHC = this.lHA;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lHD.contains(a2.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean g(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            if (f(bVar)) {
                return true;
            }
            try {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                for (int i = 0; i < a2.size(); i++) {
                    String str = a2.get(i);
                    if (this.lHH.w(str, bVar)) {
                        this.lHD.add(str);
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
    public boolean dkq() {
        long now = this.lHe.now();
        if (!this.lHI.isInitialized() || this.lHE == -1 || now - this.lHE > lHy) {
            return dkr();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dkr() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lHe.now();
        long j3 = now + lHx;
        if (this.lHs && this.lHD.isEmpty()) {
            set = this.lHD;
        } else if (this.lHs) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lHH.djX()) {
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
                    if (this.lHs) {
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
                this.lHd.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lGY, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lHI.getCount() != i5 || this.lHI.getSize() != j4) {
                if (this.lHs && this.lHD != set) {
                    this.lHD.clear();
                    this.lHD.addAll(set);
                }
                this.lHI.I(j4, i5);
            }
            this.lHE = now;
            return true;
        } catch (IOException e) {
            this.lHd.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lGY, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

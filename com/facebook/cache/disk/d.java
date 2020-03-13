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
    private final g lHC;
    private final CacheEventListener lHD;
    private final boolean lHF;
    private final long lHM;
    private final long lHN;
    private final CountDownLatch lHO;
    private long lHP;
    @GuardedBy("mLock")
    final Set<String> lHQ;
    private final long lHS;
    private final c lHU;
    private boolean lHW;
    private final CacheErrorLogger lHq;
    private final com.facebook.common.time.a lHr;
    private static final Class<?> lHl = d.class;
    private static final long lHK = TimeUnit.HOURS.toMillis(2);
    private static final long lHL = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper lHT = StatFsHelper.dla();
    private long lHR = -1;
    private final a lHV = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long ewn = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.ewn = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.ewn = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.ewn += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.ewn;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long lHM;
        public final long lHN;
        public final long lHS;

        public b(long j, long j2, long j3) {
            this.lHS = j;
            this.lHM = j2;
            this.lHN = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lHM = bVar.lHM;
        this.lHN = bVar.lHN;
        this.lHP = bVar.lHN;
        this.lHU = cVar;
        this.lHC = gVar;
        this.lHD = cacheEventListener;
        this.lHS = bVar.lHS;
        this.lHq = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lHr = com.facebook.common.time.c.dle();
        this.lHF = z;
        this.lHQ = new HashSet();
        if (this.lHF) {
            this.lHO = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dkt();
                    }
                    d.this.lHW = true;
                    d.this.lHO.countDown();
                }
            });
            return;
        }
        this.lHO = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dkz().h(bVar);
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
                    h.OP(str2);
                    com.facebook.a.a v = this.lHU.v(str2, bVar);
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
                    this.lHD.b(h);
                    this.lHQ.remove(str);
                } else {
                    this.lHD.a(h);
                    this.lHQ.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lHq.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lHl, "getResource", e);
            h.b(e);
            this.lHD.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dkr();
        return this.lHU.u(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aQ;
        synchronized (this.mLock) {
            aQ = bVar.aQ(bVar2);
            this.lHQ.add(str);
            this.lHV.J(aQ.size(), 1L);
        }
        return aQ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dkz().h(bVar);
        this.lHD.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.OP(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.eV(a3.size()).eW(this.lHV.getSize());
                    this.lHD.d(h);
                    return a3;
                } finally {
                    if (!a2.dkd()) {
                        com.facebook.common.c.a.h(lHl, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.b(e);
                this.lHD.f(h);
                com.facebook.common.c.a.b(lHl, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.lHU.OL(str);
                    this.lHQ.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lHq.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lHl, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dkr() throws IOException {
        synchronized (this.mLock) {
            boolean dkt = dkt();
            dks();
            long size = this.lHV.getSize();
            if (size > this.lHP && !dkt) {
                this.lHV.reset();
                dkt();
            }
            if (size > this.lHP) {
                a((this.lHP * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lHU.dka());
            long size = this.lHV.getSize();
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
                long a2 = this.lHU.a(next);
                this.lHQ.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eX = i.dkz().OP(next.getId()).a(evictionReason).eV(a2).eW(size - j2).eX(j);
                    this.lHD.g(eX);
                    eX.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lHV.J(-j2, -i);
            this.lHU.djZ();
        } catch (IOException e) {
            this.lHq.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lHl, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lHK + this.lHr.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lHC.dke());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dks() {
        if (this.lHT.a(this.lHU.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lHN - this.lHV.getSize())) {
            this.lHP = this.lHM;
        } else {
            this.lHP = this.lHN;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lHQ.contains(a2.get(i))) {
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
                    if (this.lHU.w(str, bVar)) {
                        this.lHQ.add(str);
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
    public boolean dkt() {
        long now = this.lHr.now();
        if (!this.lHV.isInitialized() || this.lHR == -1 || now - this.lHR > lHL) {
            return dku();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dku() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lHr.now();
        long j3 = now + lHK;
        if (this.lHF && this.lHQ.isEmpty()) {
            set = this.lHQ;
        } else if (this.lHF) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lHU.dka()) {
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
                    if (this.lHF) {
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
                this.lHq.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lHl, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lHV.getCount() != i5 || this.lHV.getSize() != j4) {
                if (this.lHF && this.lHQ != set) {
                    this.lHQ.clear();
                    this.lHQ.addAll(set);
                }
                this.lHV.I(j4, i5);
            }
            this.lHR = now;
            return true;
        } catch (IOException e) {
            this.lHq.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lHl, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

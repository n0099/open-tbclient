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
    private final long lHB;
    private final long lHC;
    private final CountDownLatch lHD;
    private long lHE;
    @GuardedBy("mLock")
    final Set<String> lHF;
    private final long lHH;
    private final c lHJ;
    private boolean lHL;
    private final CacheErrorLogger lHf;
    private final com.facebook.common.time.a lHg;
    private final g lHr;
    private final CacheEventListener lHs;
    private final boolean lHu;
    private static final Class<?> lHa = d.class;
    private static final long lHz = TimeUnit.HOURS.toMillis(2);
    private static final long lHA = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper lHI = StatFsHelper.dkZ();
    private long lHG = -1;
    private final a lHK = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long ewa = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.ewa = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.ewa = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.ewa += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.ewa;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long lHB;
        public final long lHC;
        public final long lHH;

        public b(long j, long j2, long j3) {
            this.lHH = j;
            this.lHB = j2;
            this.lHC = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lHB = bVar.lHB;
        this.lHC = bVar.lHC;
        this.lHE = bVar.lHC;
        this.lHJ = cVar;
        this.lHr = gVar;
        this.lHs = cacheEventListener;
        this.lHH = bVar.lHH;
        this.lHf = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lHg = com.facebook.common.time.c.dld();
        this.lHu = z;
        this.lHF = new HashSet();
        if (this.lHu) {
            this.lHD = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dks();
                    }
                    d.this.lHL = true;
                    d.this.lHD.countDown();
                }
            });
            return;
        }
        this.lHD = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dky().h(bVar);
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
                    com.facebook.a.a v = this.lHJ.v(str2, bVar);
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
                    this.lHs.b(h);
                    this.lHF.remove(str);
                } else {
                    this.lHs.a(h);
                    this.lHF.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lHf.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lHa, "getResource", e);
            h.b(e);
            this.lHs.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dkq();
        return this.lHJ.u(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aQ;
        synchronized (this.mLock) {
            aQ = bVar.aQ(bVar2);
            this.lHF.add(str);
            this.lHK.J(aQ.size(), 1L);
        }
        return aQ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dky().h(bVar);
        this.lHs.c(h);
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
                    h.eV(a3.size()).eW(this.lHK.getSize());
                    this.lHs.d(h);
                    return a3;
                } finally {
                    if (!a2.dkc()) {
                        com.facebook.common.c.a.h(lHa, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.b(e);
                this.lHs.f(h);
                com.facebook.common.c.a.b(lHa, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.lHJ.OK(str);
                    this.lHF.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lHf.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lHa, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dkq() throws IOException {
        synchronized (this.mLock) {
            boolean dks = dks();
            dkr();
            long size = this.lHK.getSize();
            if (size > this.lHE && !dks) {
                this.lHK.reset();
                dks();
            }
            if (size > this.lHE) {
                a((this.lHE * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lHJ.djZ());
            long size = this.lHK.getSize();
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
                long a2 = this.lHJ.a(next);
                this.lHF.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eX = i.dky().OO(next.getId()).a(evictionReason).eV(a2).eW(size - j2).eX(j);
                    this.lHs.g(eX);
                    eX.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lHK.J(-j2, -i);
            this.lHJ.djY();
        } catch (IOException e) {
            this.lHf.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lHa, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lHz + this.lHg.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lHr.dkd());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dkr() {
        if (this.lHI.a(this.lHJ.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lHC - this.lHK.getSize())) {
            this.lHE = this.lHB;
        } else {
            this.lHE = this.lHC;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lHF.contains(a2.get(i))) {
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
                    if (this.lHJ.w(str, bVar)) {
                        this.lHF.add(str);
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
    public boolean dks() {
        long now = this.lHg.now();
        if (!this.lHK.isInitialized() || this.lHG == -1 || now - this.lHG > lHA) {
            return dkt();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dkt() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lHg.now();
        long j3 = now + lHz;
        if (this.lHu && this.lHF.isEmpty()) {
            set = this.lHF;
        } else if (this.lHu) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lHJ.djZ()) {
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
                    if (this.lHu) {
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
                this.lHf.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lHa, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lHK.getCount() != i5 || this.lHK.getSize() != j4) {
                if (this.lHu && this.lHF != set) {
                    this.lHF.clear();
                    this.lHF.addAll(set);
                }
                this.lHK.I(j4, i5);
            }
            this.lHG = now;
            return true;
        } catch (IOException e) {
            this.lHf.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lHa, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

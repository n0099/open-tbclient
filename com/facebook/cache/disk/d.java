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
    private final g lQD;
    private final CacheEventListener lQE;
    private final boolean lQG;
    private final long lQN;
    private final long lQO;
    private final CountDownLatch lQP;
    private long lQQ;
    @GuardedBy("mLock")
    final Set<String> lQR;
    private final long lQT;
    private final c lQV;
    private boolean lQX;
    private final CacheErrorLogger lQr;
    private final com.facebook.common.time.a lQs;
    private static final Class<?> lQm = d.class;
    private static final long lQL = TimeUnit.HOURS.toMillis(2);
    private static final long lQM = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper lQU = StatFsHelper.dnq();
    private long lQS = -1;
    private final a lQW = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long faM = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.faM = -1L;
            this.mSize = -1L;
        }

        public synchronized void G(long j, long j2) {
            this.faM = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void H(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.faM += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.faM;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long lQN;
        public final long lQO;
        public final long lQT;

        public b(long j, long j2, long j3) {
            this.lQT = j;
            this.lQN = j2;
            this.lQO = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lQN = bVar.lQN;
        this.lQO = bVar.lQO;
        this.lQQ = bVar.lQO;
        this.lQV = cVar;
        this.lQD = gVar;
        this.lQE = cacheEventListener;
        this.lQT = bVar.lQT;
        this.lQr = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lQs = com.facebook.common.time.c.dnv();
        this.lQG = z;
        this.lQR = new HashSet();
        if (this.lQG) {
            this.lQP = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dmJ();
                    }
                    d.this.lQX = true;
                    d.this.lQP.countDown();
                }
            });
            return;
        }
        this.lQP = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dmP().h(bVar);
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
                    h.NW(str2);
                    com.facebook.a.a A = this.lQV.A(str2, bVar);
                    if (A != null) {
                        str = str2;
                        aVar = A;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = A;
                }
                if (aVar == null) {
                    this.lQE.b(h);
                    this.lQR.remove(str);
                } else {
                    this.lQE.a(h);
                    this.lQR.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lQr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lQm, "getResource", e);
            h.d(e);
            this.lQE.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dmH();
        return this.lQV.z(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aG;
        synchronized (this.mLock) {
            aG = bVar.aG(bVar2);
            this.lQR.add(str);
            this.lQW.H(aG.size(), 1L);
        }
        return aG;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dmP().h(bVar);
        this.lQE.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.NW(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fC(a3.size()).fD(this.lQW.getSize());
                    this.lQE.d(h);
                    return a3;
                } finally {
                    if (!a2.dmt()) {
                        com.facebook.common.c.a.h(lQm, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.d(e);
                this.lQE.f(h);
                com.facebook.common.c.a.b(lQm, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.lQV.NS(str);
                    this.lQR.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lQr.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lQm, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dmH() throws IOException {
        synchronized (this.mLock) {
            boolean dmJ = dmJ();
            dmI();
            long size = this.lQW.getSize();
            if (size > this.lQQ && !dmJ) {
                this.lQW.reset();
                dmJ();
            }
            if (size > this.lQQ) {
                a((this.lQQ * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lQV.dmq());
            long size = this.lQW.getSize();
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
                long a2 = this.lQV.a(next);
                this.lQR.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fE = i.dmP().NW(next.getId()).a(evictionReason).fC(a2).fD(size - j2).fE(j);
                    this.lQE.g(fE);
                    fE.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lQW.H(-j2, -i);
            this.lQV.dmp();
        } catch (IOException e) {
            this.lQr.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lQm, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lQL + this.lQs.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lQD.dmu());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dmI() {
        if (this.lQU.a(this.lQV.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lQO - this.lQW.getSize())) {
            this.lQQ = this.lQN;
        } else {
            this.lQQ = this.lQO;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lQR.contains(a2.get(i))) {
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
                    if (this.lQV.B(str, bVar)) {
                        this.lQR.add(str);
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
    public boolean dmJ() {
        long now = this.lQs.now();
        if (!this.lQW.isInitialized() || this.lQS == -1 || now - this.lQS > lQM) {
            return dmK();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dmK() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lQs.now();
        long j3 = now + lQL;
        if (this.lQG && this.lQR.isEmpty()) {
            set = this.lQR;
        } else if (this.lQG) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lQV.dmq()) {
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
                    if (this.lQG) {
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
                this.lQr.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lQm, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lQW.getCount() != i5 || this.lQW.getSize() != j4) {
                if (this.lQG && this.lQR != set) {
                    this.lQR.clear();
                    this.lQR.addAll(set);
                }
                this.lQW.G(j4, i5);
            }
            this.lQS = now;
            return true;
        } catch (IOException e) {
            this.lQr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lQm, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

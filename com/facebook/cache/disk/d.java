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
/* loaded from: classes5.dex */
public class d implements h, com.facebook.common.a.a {
    private final g pnD;
    private final CacheEventListener pnE;
    private final boolean pnG;
    private final long pnN;
    private final long pnO;
    private final CountDownLatch pnP;
    private long pnQ;
    @GuardedBy("mLock")
    final Set<String> pnR;
    private final long pnT;
    private final c pnV;
    private boolean pnX;
    private final CacheErrorLogger pnr;
    private final com.facebook.common.time.a pns;
    private static final Class<?> pnm = d.class;
    private static final long pnL = TimeUnit.HOURS.toMillis(2);
    private static final long pnM = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper pnU = StatFsHelper.eqx();
    private long pnS = -1;
    private final a pnW = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gLl = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gLl = -1L;
            this.mSize = -1L;
        }

        public synchronized void M(long j, long j2) {
            this.gLl = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void N(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gLl += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gLl;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final long pnN;
        public final long pnO;
        public final long pnT;

        public b(long j, long j2, long j3) {
            this.pnT = j;
            this.pnN = j2;
            this.pnO = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pnN = bVar.pnN;
        this.pnO = bVar.pnO;
        this.pnQ = bVar.pnO;
        this.pnV = cVar;
        this.pnD = gVar;
        this.pnE = cacheEventListener;
        this.pnT = bVar.pnT;
        this.pnr = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.pns = com.facebook.common.time.c.eqB();
        this.pnG = z;
        this.pnR = new HashSet();
        if (this.pnG) {
            this.pnP = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.epQ();
                    }
                    d.this.pnX = true;
                    d.this.pnP.countDown();
                }
            });
            return;
        }
        this.pnP = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.epW().h(bVar);
        try {
            try {
                synchronized (this.mLock) {
                    List<String> a2 = com.facebook.cache.common.c.a(bVar);
                    aVar = null;
                    String str = null;
                    for (int i = 0; i < a2.size(); i++) {
                        str = a2.get(i);
                        h.Yf(str);
                        aVar = this.pnV.G(str, bVar);
                        if (aVar != null) {
                            break;
                        }
                    }
                    if (aVar == null) {
                        this.pnE.b(h);
                        this.pnR.remove(str);
                    } else {
                        this.pnE.a(h);
                        this.pnR.add(str);
                    }
                }
                h.recycle();
                return aVar;
            } catch (IOException e) {
                this.pnr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pnm, "getResource", e);
                h.h(e);
                this.pnE.e(h);
                h.recycle();
                return null;
            }
        } catch (Throwable th) {
            h.recycle();
            throw th;
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        epO();
        return this.pnV.F(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aZ;
        synchronized (this.mLock) {
            aZ = bVar.aZ(bVar2);
            this.pnR.add(str);
            this.pnW.N(aZ.size(), 1L);
        }
        return aZ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.epW().h(bVar);
        this.pnE.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Yf(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.ix(a3.size()).iy(this.pnW.getSize());
                    this.pnE.d(h);
                    return a3;
                } finally {
                    if (!a2.epB()) {
                        com.facebook.common.c.a.i(pnm, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.h(e);
                this.pnE.f(h);
                com.facebook.common.c.a.b(pnm, "Failed inserting a file into the cache", e);
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
                    this.pnV.Yb(str);
                    this.pnR.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.pnr.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, pnm, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void epO() throws IOException {
        synchronized (this.mLock) {
            boolean epQ = epQ();
            epP();
            long size = this.pnW.getSize();
            if (size > this.pnQ && !epQ) {
                this.pnW.reset();
                epQ();
            }
            if (size > this.pnQ) {
                a((this.pnQ * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2;
        try {
            Collection<c.a> l = l(this.pnV.epy());
            long size = this.pnW.getSize();
            long j3 = size - j;
            int i = 0;
            long j4 = 0;
            Iterator<c.a> it = l.iterator();
            while (true) {
                j2 = j4;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j3) {
                    break;
                }
                long a2 = this.pnV.a(next);
                this.pnR.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i iz = i.epW().Yf(next.getId()).a(evictionReason).ix(a2).iy(size - j2).iz(j);
                    this.pnE.g(iz);
                    iz.recycle();
                }
                j4 = j2;
            }
            this.pnW.N(-j2, -i);
            this.pnV.epx();
        } catch (IOException e) {
            this.pnr.a(CacheErrorLogger.CacheErrorCategory.EVICTION, pnm, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = pnL + this.pns.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.pnD.epC());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void epP() {
        if (this.pnU.a(this.pnV.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pnO - this.pnW.getSize())) {
            this.pnQ = this.pnN;
        } else {
            this.pnQ = this.pnO;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.pnR.contains(a2.get(i))) {
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
                    if (this.pnV.H(str, bVar)) {
                        this.pnR.add(str);
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
    public boolean epQ() {
        long now = this.pns.now();
        if (!this.pnW.isInitialized() || this.pnS == -1 || now - this.pnS > pnM) {
            return epR();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean epR() {
        Set<String> set;
        long j;
        long j2 = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        long j3 = -1;
        long now = this.pns.now();
        long j4 = now + pnL;
        if (this.pnG && this.pnR.isEmpty()) {
            set = this.pnR;
        } else if (this.pnG) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            int i3 = 0;
            for (c.a aVar : this.pnV.epy()) {
                i3++;
                j2 += aVar.getSize();
                if (aVar.getTimestamp() > j4) {
                    z = true;
                    i++;
                    i2 = (int) (i2 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j3);
                } else {
                    if (this.pnG) {
                        set.add(aVar.getId());
                    }
                    j = j3;
                }
                j3 = j;
            }
            if (z) {
                this.pnr.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, pnm, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            if (this.pnW.getCount() != i3 || this.pnW.getSize() != j2) {
                if (this.pnG && this.pnR != set) {
                    this.pnR.clear();
                    this.pnR.addAll(set);
                }
                this.pnW.M(j2, i3);
            }
            this.pnS = now;
            return true;
        } catch (IOException e) {
            this.pnr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pnm, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

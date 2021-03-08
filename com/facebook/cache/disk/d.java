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
    private final boolean pAB;
    private final long pAI;
    private final long pAJ;
    private final CountDownLatch pAK;
    private long pAL;
    @GuardedBy("mLock")
    final Set<String> pAM;
    private final long pAO;
    private final c pAQ;
    private boolean pAS;
    private final CacheErrorLogger pAm;
    private final com.facebook.common.time.a pAn;
    private final g pAy;
    private final CacheEventListener pAz;
    private static final Class<?> pAh = d.class;
    private static final long pAG = TimeUnit.HOURS.toMillis(2);
    private static final long pAH = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper pAP = StatFsHelper.eth();
    private long pAN = -1;
    private final a pAR = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gPO = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gPO = -1L;
            this.mSize = -1L;
        }

        public synchronized void Q(long j, long j2) {
            this.gPO = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void R(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gPO += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gPO;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final long pAI;
        public final long pAJ;
        public final long pAO;

        public b(long j, long j2, long j3) {
            this.pAO = j;
            this.pAI = j2;
            this.pAJ = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pAI = bVar.pAI;
        this.pAJ = bVar.pAJ;
        this.pAL = bVar.pAJ;
        this.pAQ = cVar;
        this.pAy = gVar;
        this.pAz = cacheEventListener;
        this.pAO = bVar.pAO;
        this.pAm = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.pAn = com.facebook.common.time.c.etl();
        this.pAB = z;
        this.pAM = new HashSet();
        if (this.pAB) {
            this.pAK = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.esA();
                    }
                    d.this.pAS = true;
                    d.this.pAK.countDown();
                }
            });
            return;
        }
        this.pAK = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.esG().h(bVar);
        try {
            try {
                synchronized (this.mLock) {
                    List<String> a2 = com.facebook.cache.common.c.a(bVar);
                    aVar = null;
                    String str = null;
                    for (int i = 0; i < a2.size(); i++) {
                        str = a2.get(i);
                        h.Zz(str);
                        aVar = this.pAQ.E(str, bVar);
                        if (aVar != null) {
                            break;
                        }
                    }
                    if (aVar == null) {
                        this.pAz.b(h);
                        this.pAM.remove(str);
                    } else {
                        this.pAz.a(h);
                        this.pAM.add(str);
                    }
                }
                h.recycle();
                return aVar;
            } catch (IOException e) {
                this.pAm.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pAh, "getResource", e);
                h.h(e);
                this.pAz.e(h);
                h.recycle();
                return null;
            }
        } catch (Throwable th) {
            h.recycle();
            throw th;
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        esy();
        return this.pAQ.D(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a bb;
        synchronized (this.mLock) {
            bb = bVar.bb(bVar2);
            this.pAM.add(str);
            this.pAR.R(bb.size(), 1L);
        }
        return bb;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.esG().h(bVar);
        this.pAz.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zz(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.iA(a3.size()).iB(this.pAR.getSize());
                    this.pAz.d(h);
                    return a3;
                } finally {
                    if (!a2.esl()) {
                        com.facebook.common.c.a.i(pAh, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.h(e);
                this.pAz.f(h);
                com.facebook.common.c.a.b(pAh, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.pAQ.Zv(str);
                    this.pAM.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.pAm.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, pAh, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void esy() throws IOException {
        synchronized (this.mLock) {
            boolean esA = esA();
            esz();
            long size = this.pAR.getSize();
            if (size > this.pAL && !esA) {
                this.pAR.reset();
                esA();
            }
            if (size > this.pAL) {
                a((this.pAL * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2;
        try {
            Collection<c.a> l = l(this.pAQ.esi());
            long size = this.pAR.getSize();
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
                long a2 = this.pAQ.a(next);
                this.pAM.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i iC = i.esG().Zz(next.getId()).a(evictionReason).iA(a2).iB(size - j2).iC(j);
                    this.pAz.g(iC);
                    iC.recycle();
                }
                j4 = j2;
            }
            this.pAR.R(-j2, -i);
            this.pAQ.esh();
        } catch (IOException e) {
            this.pAm.a(CacheErrorLogger.CacheErrorCategory.EVICTION, pAh, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = pAG + this.pAn.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.pAy.esm());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void esz() {
        if (this.pAP.a(this.pAQ.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pAJ - this.pAR.getSize())) {
            this.pAL = this.pAI;
        } else {
            this.pAL = this.pAJ;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.pAM.contains(a2.get(i))) {
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
                    if (this.pAQ.F(str, bVar)) {
                        this.pAM.add(str);
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
    public boolean esA() {
        long now = this.pAn.now();
        if (!this.pAR.isInitialized() || this.pAN == -1 || now - this.pAN > pAH) {
            return esB();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean esB() {
        Set<String> set;
        long j;
        long j2 = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        long j3 = -1;
        long now = this.pAn.now();
        long j4 = now + pAG;
        if (this.pAB && this.pAM.isEmpty()) {
            set = this.pAM;
        } else if (this.pAB) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            int i3 = 0;
            for (c.a aVar : this.pAQ.esi()) {
                i3++;
                j2 += aVar.getSize();
                if (aVar.getTimestamp() > j4) {
                    z = true;
                    i++;
                    i2 = (int) (i2 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j3);
                } else {
                    if (this.pAB) {
                        set.add(aVar.getId());
                    }
                    j = j3;
                }
                j3 = j;
            }
            if (z) {
                this.pAm.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, pAh, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            if (this.pAR.getCount() != i3 || this.pAR.getSize() != j2) {
                if (this.pAB && this.pAM != set) {
                    this.pAM.clear();
                    this.pAM.addAll(set);
                }
                this.pAR.Q(j2, i3);
            }
            this.pAN = now;
            return true;
        } catch (IOException e) {
            this.pAm.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pAh, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

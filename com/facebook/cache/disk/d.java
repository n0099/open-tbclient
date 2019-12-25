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
/* loaded from: classes11.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> lCO = d.class;
    private static final long lDn = TimeUnit.HOURS.toMillis(2);
    private static final long lDo = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger lCT;
    private final com.facebook.common.time.a lCU;
    private final g lDf;
    private final CacheEventListener lDg;
    private final boolean lDi;
    private final long lDp;
    private final long lDq;
    private final CountDownLatch lDr;
    private long lDs;
    @GuardedBy("mLock")
    final Set<String> lDt;
    private final long lDv;
    private final c lDx;
    private boolean lDz;
    private final Object mLock = new Object();
    private final StatFsHelper lDw = StatFsHelper.diH();
    private long lDu = -1;
    private final a lDy = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long eqC = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.eqC = -1L;
            this.mSize = -1L;
        }

        public synchronized void J(long j, long j2) {
            this.eqC = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void K(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.eqC += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.eqC;
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        public final long lDp;
        public final long lDq;
        public final long lDv;

        public b(long j, long j2, long j3) {
            this.lDv = j;
            this.lDp = j2;
            this.lDq = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lDp = bVar.lDp;
        this.lDq = bVar.lDq;
        this.lDs = bVar.lDq;
        this.lDx = cVar;
        this.lDf = gVar;
        this.lDg = cacheEventListener;
        this.lDv = bVar.lDv;
        this.lCT = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lCU = com.facebook.common.time.c.diL();
        this.lDi = z;
        this.lDt = new HashSet();
        if (this.lDi) {
            this.lDr = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dia();
                    }
                    d.this.lDz = true;
                    d.this.lDr.countDown();
                }
            });
            return;
        }
        this.lDr = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dig().h(bVar);
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
                    h.Or(str2);
                    com.facebook.a.a v = this.lDx.v(str2, bVar);
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
                    this.lDg.b(h);
                    this.lDt.remove(str);
                } else {
                    this.lDg.a(h);
                    this.lDt.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lCT.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lCO, "getResource", e);
            h.b(e);
            this.lDg.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dhY();
        return this.lDx.u(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aO;
        synchronized (this.mLock) {
            aO = bVar.aO(bVar2);
            this.lDt.add(str);
            this.lDy.K(aO.size(), 1L);
        }
        return aO;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dig().h(bVar);
        this.lDg.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Or(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.eS(a3.size()).eT(this.lDy.getSize());
                    this.lDg.d(h);
                    return a3;
                } finally {
                    if (!a2.dhK()) {
                        com.facebook.common.c.a.h(lCO, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.b(e);
                this.lDg.f(h);
                com.facebook.common.c.a.b(lCO, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.lDx.Oo(str);
                    this.lDt.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lCT.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lCO, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dhY() throws IOException {
        synchronized (this.mLock) {
            boolean dia = dia();
            dhZ();
            long size = this.lDy.getSize();
            if (size > this.lDs && !dia) {
                this.lDy.reset();
                dia();
            }
            if (size > this.lDs) {
                a((this.lDs * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lDx.dhH());
            long size = this.lDy.getSize();
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
                long a2 = this.lDx.a(next);
                this.lDt.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eU = i.dig().Or(next.getId()).a(evictionReason).eS(a2).eT(size - j2).eU(j);
                    this.lDg.g(eU);
                    eU.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lDy.K(-j2, -i);
            this.lDx.dhG();
        } catch (IOException e) {
            this.lCT.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lCO, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lDn + this.lCU.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lDf.dhL());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dhZ() {
        if (this.lDw.a(this.lDx.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lDq - this.lDy.getSize())) {
            this.lDs = this.lDp;
        } else {
            this.lDs = this.lDq;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lDt.contains(a2.get(i))) {
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
                    if (this.lDx.w(str, bVar)) {
                        this.lDt.add(str);
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
    public boolean dia() {
        long now = this.lCU.now();
        if (!this.lDy.isInitialized() || this.lDu == -1 || now - this.lDu > lDo) {
            return dib();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dib() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lCU.now();
        long j3 = now + lDn;
        if (this.lDi && this.lDt.isEmpty()) {
            set = this.lDt;
        } else if (this.lDi) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lDx.dhH()) {
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
                    if (this.lDi) {
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
                this.lCT.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lCO, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lDy.getCount() != i5 || this.lDy.getSize() != j4) {
                if (this.lDi && this.lDt != set) {
                    this.lDt.clear();
                    this.lDt.addAll(set);
                }
                this.lDy.J(j4, i5);
            }
            this.lDu = now;
            return true;
        } catch (IOException e) {
            this.lCT.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lCO, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

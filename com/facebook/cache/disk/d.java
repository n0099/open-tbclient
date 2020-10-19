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
/* loaded from: classes12.dex */
public class d implements h, com.facebook.common.a.a {
    private final long nJG;
    private final long nJH;
    private final CountDownLatch nJI;
    private long nJJ;
    @GuardedBy("mLock")
    final Set<String> nJK;
    private final long nJM;
    private final c nJO;
    private boolean nJQ;
    private final CacheErrorLogger nJk;
    private final com.facebook.common.time.a nJl;
    private final g nJw;
    private final CacheEventListener nJx;
    private final boolean nJz;
    private static final Class<?> nJf = d.class;
    private static final long nJE = TimeUnit.HOURS.toMillis(2);
    private static final long nJF = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper nJN = StatFsHelper.dWH();
    private long nJL = -1;
    private final a nJP = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gfW = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gfW = -1L;
            this.mSize = -1L;
        }

        public synchronized void H(long j, long j2) {
            this.gfW = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void I(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gfW += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gfW;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public final long nJG;
        public final long nJH;
        public final long nJM;

        public b(long j, long j2, long j3) {
            this.nJM = j;
            this.nJG = j2;
            this.nJH = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.nJG = bVar.nJG;
        this.nJH = bVar.nJH;
        this.nJJ = bVar.nJH;
        this.nJO = cVar;
        this.nJw = gVar;
        this.nJx = cacheEventListener;
        this.nJM = bVar.nJM;
        this.nJk = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.nJl = com.facebook.common.time.c.dWL();
        this.nJz = z;
        this.nJK = new HashSet();
        if (this.nJz) {
            this.nJI = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dWa();
                    }
                    d.this.nJQ = true;
                    d.this.nJI.countDown();
                }
            });
            return;
        }
        this.nJI = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dWg().h(bVar);
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
                    h.VG(str2);
                    com.facebook.a.a D = this.nJO.D(str2, bVar);
                    if (D != null) {
                        str = str2;
                        aVar = D;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = D;
                }
                if (aVar == null) {
                    this.nJx.b(h);
                    this.nJK.remove(str);
                } else {
                    this.nJx.a(h);
                    this.nJK.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.nJk.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, nJf, "getResource", e);
            h.e(e);
            this.nJx.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dVY();
        return this.nJO.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aT;
        synchronized (this.mLock) {
            aT = bVar.aT(bVar2);
            this.nJK.add(str);
            this.nJP.I(aT.size(), 1L);
        }
        return aT;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dWg().h(bVar);
        this.nJx.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.VG(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.gP(a3.size()).gQ(this.nJP.getSize());
                    this.nJx.d(h);
                    return a3;
                } finally {
                    if (!a2.dVK()) {
                        com.facebook.common.c.a.h(nJf, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.nJx.f(h);
                com.facebook.common.c.a.b(nJf, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.nJO.VC(str);
                    this.nJK.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.nJk.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, nJf, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dVY() throws IOException {
        synchronized (this.mLock) {
            boolean dWa = dWa();
            dVZ();
            long size = this.nJP.getSize();
            if (size > this.nJJ && !dWa) {
                this.nJP.reset();
                dWa();
            }
            if (size > this.nJJ) {
                a((this.nJJ * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.nJO.dVH());
            long size = this.nJP.getSize();
            long j3 = size - j;
            int i2 = 0;
            long j4 = 0;
            Iterator<c.a> it = l.iterator();
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
                long a2 = this.nJO.a(next);
                this.nJK.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i gR = i.dWg().VG(next.getId()).a(evictionReason).gP(a2).gQ(size - j2).gR(j);
                    this.nJx.g(gR);
                    gR.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.nJP.I(-j2, -i);
            this.nJO.dVG();
        } catch (IOException e) {
            this.nJk.a(CacheErrorLogger.CacheErrorCategory.EVICTION, nJf, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = nJE + this.nJl.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.nJw.dVL());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dVZ() {
        if (this.nJN.a(this.nJO.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.nJH - this.nJP.getSize())) {
            this.nJJ = this.nJG;
        } else {
            this.nJJ = this.nJH;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.nJK.contains(a2.get(i))) {
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
                    if (this.nJO.E(str, bVar)) {
                        this.nJK.add(str);
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
    public boolean dWa() {
        long now = this.nJl.now();
        if (!this.nJP.isInitialized() || this.nJL == -1 || now - this.nJL > nJF) {
            return dWb();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dWb() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.nJl.now();
        long j3 = now + nJE;
        if (this.nJz && this.nJK.isEmpty()) {
            set = this.nJK;
        } else if (this.nJz) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.nJO.dVH()) {
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
                    if (this.nJz) {
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
                this.nJk.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, nJf, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.nJP.getCount() != i5 || this.nJP.getSize() != j4) {
                if (this.nJz && this.nJK != set) {
                    this.nJK.clear();
                    this.nJK.addAll(set);
                }
                this.nJP.H(j4, i5);
            }
            this.nJL = now;
            return true;
        } catch (IOException e) {
            this.nJk.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, nJf, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
/* loaded from: classes7.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> paD = d.class;
    private static final long pbc = TimeUnit.HOURS.toMillis(2);
    private static final long pbd = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger paI;
    private final com.facebook.common.time.a paJ;
    private final g paU;
    private final CacheEventListener paV;
    private final boolean paX;
    private final long pbe;
    private final long pbf;
    private final CountDownLatch pbg;
    private long pbh;
    @GuardedBy("mLock")
    final Set<String> pbi;
    private final long pbk;
    private final c pbm;
    private boolean pbo;
    private final Object mLock = new Object();
    private final StatFsHelper pbl = StatFsHelper.eqh();
    private long pbj = -1;
    private final a pbn = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gEd = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gEd = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.gEd = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gEd += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gEd;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public final long pbe;
        public final long pbf;
        public final long pbk;

        public b(long j, long j2, long j3) {
            this.pbk = j;
            this.pbe = j2;
            this.pbf = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pbe = bVar.pbe;
        this.pbf = bVar.pbf;
        this.pbh = bVar.pbf;
        this.pbm = cVar;
        this.paU = gVar;
        this.paV = cacheEventListener;
        this.pbk = bVar.pbk;
        this.paI = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.paJ = com.facebook.common.time.c.eql();
        this.paX = z;
        this.pbi = new HashSet();
        if (this.paX) {
            this.pbg = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.epA();
                    }
                    d.this.pbo = true;
                    d.this.pbg.countDown();
                }
            });
            return;
        }
        this.pbg = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.epG().h(bVar);
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
                    h.Zd(str2);
                    com.facebook.a.a C = this.pbm.C(str2, bVar);
                    if (C != null) {
                        str = str2;
                        aVar = C;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = C;
                }
                if (aVar == null) {
                    this.paV.b(h);
                    this.pbi.remove(str);
                } else {
                    this.paV.a(h);
                    this.pbi.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.paI.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, paD, "getResource", e);
            h.e(e);
            this.paV.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        epy();
        return this.pbm.B(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aY;
        synchronized (this.mLock) {
            aY = bVar.aY(bVar2);
            this.pbi.add(str);
            this.pbn.J(aY.size(), 1L);
        }
        return aY;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.epG().h(bVar);
        this.paV.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zd(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.ij(a3.size()).ik(this.pbn.getSize());
                    this.paV.d(h);
                    return a3;
                } finally {
                    if (!a2.epl()) {
                        com.facebook.common.c.a.h(paD, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.paV.f(h);
                com.facebook.common.c.a.b(paD, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.pbm.YZ(str);
                    this.pbi.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.paI.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, paD, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void epy() throws IOException {
        synchronized (this.mLock) {
            boolean epA = epA();
            epz();
            long size = this.pbn.getSize();
            if (size > this.pbh && !epA) {
                this.pbn.reset();
                epA();
            }
            if (size > this.pbh) {
                a((this.pbh * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.pbm.epi());
            long size = this.pbn.getSize();
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
                long a2 = this.pbm.a(next);
                this.pbi.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i il = i.epG().Zd(next.getId()).a(evictionReason).ij(a2).ik(size - j2).il(j);
                    this.paV.g(il);
                    il.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.pbn.J(-j2, -i);
            this.pbm.eph();
        } catch (IOException e) {
            this.paI.a(CacheErrorLogger.CacheErrorCategory.EVICTION, paD, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = pbc + this.paJ.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.paU.epm());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void epz() {
        if (this.pbl.a(this.pbm.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pbf - this.pbn.getSize())) {
            this.pbh = this.pbe;
        } else {
            this.pbh = this.pbf;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.pbi.contains(a2.get(i))) {
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
                    if (this.pbm.D(str, bVar)) {
                        this.pbi.add(str);
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
    public boolean epA() {
        long now = this.paJ.now();
        if (!this.pbn.isInitialized() || this.pbj == -1 || now - this.pbj > pbd) {
            return epB();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean epB() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.paJ.now();
        long j3 = now + pbc;
        if (this.paX && this.pbi.isEmpty()) {
            set = this.pbi;
        } else if (this.paX) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.pbm.epi()) {
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
                    if (this.paX) {
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
                this.paI.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, paD, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.pbn.getCount() != i5 || this.pbn.getSize() != j4) {
                if (this.paX && this.pbi != set) {
                    this.pbi.clear();
                    this.pbi.addAll(set);
                }
                this.pbn.I(j4, i5);
            }
            this.pbj = now;
            return true;
        } catch (IOException e) {
            this.paI.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, paD, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
    private final g lGD;
    private final CacheEventListener lGE;
    private final boolean lGG;
    private final long lGN;
    private final long lGO;
    private final CountDownLatch lGP;
    private long lGQ;
    @GuardedBy("mLock")
    final Set<String> lGR;
    private final long lGT;
    private final c lGV;
    private boolean lGX;
    private final CacheErrorLogger lGr;
    private final com.facebook.common.time.a lGs;
    private static final Class<?> lGm = d.class;
    private static final long lGL = TimeUnit.HOURS.toMillis(2);
    private static final long lGM = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper lGU = StatFsHelper.djI();
    private long lGS = -1;
    private final a lGW = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long erP = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.erP = -1L;
            this.mSize = -1L;
        }

        public synchronized void J(long j, long j2) {
            this.erP = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void K(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.erP += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.erP;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public final long lGN;
        public final long lGO;
        public final long lGT;

        public b(long j, long j2, long j3) {
            this.lGT = j;
            this.lGN = j2;
            this.lGO = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lGN = bVar.lGN;
        this.lGO = bVar.lGO;
        this.lGQ = bVar.lGO;
        this.lGV = cVar;
        this.lGD = gVar;
        this.lGE = cacheEventListener;
        this.lGT = bVar.lGT;
        this.lGr = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lGs = com.facebook.common.time.c.djM();
        this.lGG = z;
        this.lGR = new HashSet();
        if (this.lGG) {
            this.lGP = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.djb();
                    }
                    d.this.lGX = true;
                    d.this.lGP.countDown();
                }
            });
            return;
        }
        this.lGP = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.djh().h(bVar);
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
                    h.OB(str2);
                    com.facebook.a.a v = this.lGV.v(str2, bVar);
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
                    this.lGE.b(h);
                    this.lGR.remove(str);
                } else {
                    this.lGE.a(h);
                    this.lGR.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lGr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lGm, "getResource", e);
            h.b(e);
            this.lGE.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        diZ();
        return this.lGV.u(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aO;
        synchronized (this.mLock) {
            aO = bVar.aO(bVar2);
            this.lGR.add(str);
            this.lGW.K(aO.size(), 1L);
        }
        return aO;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.djh().h(bVar);
        this.lGE.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.OB(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.eX(a3.size()).eY(this.lGW.getSize());
                    this.lGE.d(h);
                    return a3;
                } finally {
                    if (!a2.diL()) {
                        com.facebook.common.c.a.h(lGm, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.b(e);
                this.lGE.f(h);
                com.facebook.common.c.a.b(lGm, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.lGV.Oy(str);
                    this.lGR.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lGr.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lGm, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void diZ() throws IOException {
        synchronized (this.mLock) {
            boolean djb = djb();
            dja();
            long size = this.lGW.getSize();
            if (size > this.lGQ && !djb) {
                this.lGW.reset();
                djb();
            }
            if (size > this.lGQ) {
                a((this.lGQ * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lGV.diI());
            long size = this.lGW.getSize();
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
                long a2 = this.lGV.a(next);
                this.lGR.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i eZ = i.djh().OB(next.getId()).a(evictionReason).eX(a2).eY(size - j2).eZ(j);
                    this.lGE.g(eZ);
                    eZ.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lGW.K(-j2, -i);
            this.lGV.diH();
        } catch (IOException e) {
            this.lGr.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lGm, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lGL + this.lGs.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lGD.diM());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dja() {
        if (this.lGU.a(this.lGV.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lGO - this.lGW.getSize())) {
            this.lGQ = this.lGN;
        } else {
            this.lGQ = this.lGO;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lGR.contains(a2.get(i))) {
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
                    if (this.lGV.w(str, bVar)) {
                        this.lGR.add(str);
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
    public boolean djb() {
        long now = this.lGs.now();
        if (!this.lGW.isInitialized() || this.lGS == -1 || now - this.lGS > lGM) {
            return djc();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean djc() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lGs.now();
        long j3 = now + lGL;
        if (this.lGG && this.lGR.isEmpty()) {
            set = this.lGR;
        } else if (this.lGG) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lGV.diI()) {
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
                    if (this.lGG) {
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
                this.lGr.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lGm, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lGW.getCount() != i5 || this.lGW.getSize() != j4) {
                if (this.lGG && this.lGR != set) {
                    this.lGR.clear();
                    this.lGR.addAll(set);
                }
                this.lGW.J(j4, i5);
            }
            this.lGS = now;
            return true;
        } catch (IOException e) {
            this.lGr.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lGm, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

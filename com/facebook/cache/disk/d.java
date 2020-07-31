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
/* loaded from: classes3.dex */
public class d implements h, com.facebook.common.a.a {
    private final CacheErrorLogger mPC;
    private final com.facebook.common.time.a mPD;
    private final g mPO;
    private final CacheEventListener mPP;
    private final boolean mPR;
    private final long mPY;
    private final long mPZ;
    private final CountDownLatch mQa;
    private long mQb;
    @GuardedBy("mLock")
    final Set<String> mQc;
    private final long mQe;
    private final c mQg;
    private boolean mQi;
    private static final Class<?> mPx = d.class;
    private static final long mPW = TimeUnit.HOURS.toMillis(2);
    private static final long mPX = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper mQf = StatFsHelper.dCO();
    private long mQd = -1;
    private final a mQh = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long fEY = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.fEY = -1L;
            this.mSize = -1L;
        }

        public synchronized void K(long j, long j2) {
            this.fEY = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void L(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.fEY += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.fEY;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public final long mPY;
        public final long mPZ;
        public final long mQe;

        public b(long j, long j2, long j3) {
            this.mQe = j;
            this.mPY = j2;
            this.mPZ = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.mPY = bVar.mPY;
        this.mPZ = bVar.mPZ;
        this.mQb = bVar.mPZ;
        this.mQg = cVar;
        this.mPO = gVar;
        this.mPP = cacheEventListener;
        this.mQe = bVar.mQe;
        this.mPC = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.mPD = com.facebook.common.time.c.dCS();
        this.mPR = z;
        this.mQc = new HashSet();
        if (this.mPR) {
            this.mQa = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dCh();
                    }
                    d.this.mQi = true;
                    d.this.mQa.countDown();
                }
            });
            return;
        }
        this.mQa = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dCn().h(bVar);
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
                    h.Rm(str2);
                    com.facebook.a.a D = this.mQg.D(str2, bVar);
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
                    this.mPP.b(h);
                    this.mQc.remove(str);
                } else {
                    this.mPP.a(h);
                    this.mQc.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.mPC.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mPx, "getResource", e);
            h.e(e);
            this.mPP.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dCf();
        return this.mQg.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aM;
        synchronized (this.mLock) {
            aM = bVar.aM(bVar2);
            this.mQc.add(str);
            this.mQh.L(aM.size(), 1L);
        }
        return aM;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dCn().h(bVar);
        this.mPP.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Rm(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fU(a3.size()).fV(this.mQh.getSize());
                    this.mPP.d(h);
                    return a3;
                } finally {
                    if (!a2.dBR()) {
                        com.facebook.common.c.a.h(mPx, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.mPP.f(h);
                com.facebook.common.c.a.b(mPx, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.mQg.Ri(str);
                    this.mQc.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.mPC.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, mPx, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dCf() throws IOException {
        synchronized (this.mLock) {
            boolean dCh = dCh();
            dCg();
            long size = this.mQh.getSize();
            if (size > this.mQb && !dCh) {
                this.mQh.reset();
                dCh();
            }
            if (size > this.mQb) {
                a((this.mQb * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> j3 = j(this.mQg.dBO());
            long size = this.mQh.getSize();
            long j4 = size - j;
            int i2 = 0;
            long j5 = 0;
            Iterator<c.a> it = j3.iterator();
            while (true) {
                i = i2;
                j2 = j5;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j4) {
                    break;
                }
                long a2 = this.mQg.a(next);
                this.mQc.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fW = i.dCn().Rm(next.getId()).a(evictionReason).fU(a2).fV(size - j2).fW(j);
                    this.mPP.g(fW);
                    fW.recycle();
                }
                long j6 = j2;
                i2 = i;
                j5 = j6;
            }
            this.mQh.L(-j2, -i);
            this.mQg.dBN();
        } catch (IOException e) {
            this.mPC.a(CacheErrorLogger.CacheErrorCategory.EVICTION, mPx, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> j(Collection<c.a> collection) {
        long now = mPW + this.mPD.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.mPO.dBS());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dCg() {
        if (this.mQf.a(this.mQg.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mPZ - this.mQh.getSize())) {
            this.mQb = this.mPY;
        } else {
            this.mQb = this.mPZ;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.mQc.contains(a2.get(i))) {
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
                    if (this.mQg.E(str, bVar)) {
                        this.mQc.add(str);
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
    public boolean dCh() {
        long now = this.mPD.now();
        if (!this.mQh.isInitialized() || this.mQd == -1 || now - this.mQd > mPX) {
            return dCi();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dCi() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.mPD.now();
        long j3 = now + mPW;
        if (this.mPR && this.mQc.isEmpty()) {
            set = this.mQc;
        } else if (this.mPR) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.mQg.dBO()) {
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
                    if (this.mPR) {
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
                this.mPC.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, mPx, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.mQh.getCount() != i5 || this.mQh.getSize() != j4) {
                if (this.mPR && this.mQc != set) {
                    this.mQc.clear();
                    this.mQc.addAll(set);
                }
                this.mQh.K(j4, i5);
            }
            this.mQd = now;
            return true;
        } catch (IOException e) {
            this.mPC.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mPx, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

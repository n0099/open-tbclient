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
    private final g lQH;
    private final CacheEventListener lQI;
    private final boolean lQK;
    private final long lQR;
    private final long lQS;
    private final CountDownLatch lQT;
    private long lQU;
    @GuardedBy("mLock")
    final Set<String> lQV;
    private final long lQX;
    private final c lQZ;
    private final CacheErrorLogger lQv;
    private final com.facebook.common.time.a lQw;
    private boolean lRb;
    private static final Class<?> lQq = d.class;
    private static final long lQP = TimeUnit.HOURS.toMillis(2);
    private static final long lQQ = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper lQY = StatFsHelper.dnn();
    private long lQW = -1;
    private final a lRa = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long faR = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.faR = -1L;
            this.mSize = -1L;
        }

        public synchronized void G(long j, long j2) {
            this.faR = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void H(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.faR += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.faR;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long lQR;
        public final long lQS;
        public final long lQX;

        public b(long j, long j2, long j3) {
            this.lQX = j;
            this.lQR = j2;
            this.lQS = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.lQR = bVar.lQR;
        this.lQS = bVar.lQS;
        this.lQU = bVar.lQS;
        this.lQZ = cVar;
        this.lQH = gVar;
        this.lQI = cacheEventListener;
        this.lQX = bVar.lQX;
        this.lQv = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.lQw = com.facebook.common.time.c.dnr();
        this.lQK = z;
        this.lQV = new HashSet();
        if (this.lQK) {
            this.lQT = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dmG();
                    }
                    d.this.lRb = true;
                    d.this.lQT.countDown();
                }
            });
            return;
        }
        this.lQT = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dmM().h(bVar);
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
                    h.NZ(str2);
                    com.facebook.a.a A = this.lQZ.A(str2, bVar);
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
                    this.lQI.b(h);
                    this.lQV.remove(str);
                } else {
                    this.lQI.a(h);
                    this.lQV.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.lQv.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lQq, "getResource", e);
            h.d(e);
            this.lQI.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dmE();
        return this.lQZ.z(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aH;
        synchronized (this.mLock) {
            aH = bVar.aH(bVar2);
            this.lQV.add(str);
            this.lRa.H(aH.size(), 1L);
        }
        return aH;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dmM().h(bVar);
        this.lQI.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.NZ(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fC(a3.size()).fD(this.lRa.getSize());
                    this.lQI.d(h);
                    return a3;
                } finally {
                    if (!a2.dmq()) {
                        com.facebook.common.c.a.h(lQq, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.d(e);
                this.lQI.f(h);
                com.facebook.common.c.a.b(lQq, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.lQZ.NV(str);
                    this.lQV.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.lQv.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, lQq, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dmE() throws IOException {
        synchronized (this.mLock) {
            boolean dmG = dmG();
            dmF();
            long size = this.lRa.getSize();
            if (size > this.lQU && !dmG) {
                this.lRa.reset();
                dmG();
            }
            if (size > this.lQU) {
                a((this.lQU * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> h = h(this.lQZ.dmn());
            long size = this.lRa.getSize();
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
                long a2 = this.lQZ.a(next);
                this.lQV.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fE = i.dmM().NZ(next.getId()).a(evictionReason).fC(a2).fD(size - j2).fE(j);
                    this.lQI.g(fE);
                    fE.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.lRa.H(-j2, -i);
            this.lQZ.dmm();
        } catch (IOException e) {
            this.lQv.a(CacheErrorLogger.CacheErrorCategory.EVICTION, lQq, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> h(Collection<c.a> collection) {
        long now = lQP + this.lQw.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.lQH.dmr());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dmF() {
        if (this.lQY.a(this.lQZ.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.lQS - this.lRa.getSize())) {
            this.lQU = this.lQR;
        } else {
            this.lQU = this.lQS;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.lQV.contains(a2.get(i))) {
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
                    if (this.lQZ.B(str, bVar)) {
                        this.lQV.add(str);
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
    public boolean dmG() {
        long now = this.lQw.now();
        if (!this.lRa.isInitialized() || this.lQW == -1 || now - this.lQW > lQQ) {
            return dmH();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dmH() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.lQw.now();
        long j3 = now + lQP;
        if (this.lQK && this.lQV.isEmpty()) {
            set = this.lQV;
        } else if (this.lQK) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.lQZ.dmn()) {
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
                    if (this.lQK) {
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
                this.lQv.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, lQq, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.lRa.getCount() != i5 || this.lRa.getSize() != j4) {
                if (this.lQK && this.lQV != set) {
                    this.lQV.clear();
                    this.lQV.addAll(set);
                }
                this.lRa.G(j4, i5);
            }
            this.lQW = now;
            return true;
        } catch (IOException e) {
            this.lQv.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, lQq, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

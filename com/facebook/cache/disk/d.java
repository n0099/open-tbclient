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
    private static final Class<?> oJR = d.class;
    private static final long oKq = TimeUnit.HOURS.toMillis(2);
    private static final long oKr = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger oJW;
    private final com.facebook.common.time.a oJX;
    private final c oKA;
    private boolean oKC;
    private final g oKi;
    private final CacheEventListener oKj;
    private final boolean oKl;
    private final long oKs;
    private final long oKt;
    private final CountDownLatch oKu;
    private long oKv;
    @GuardedBy("mLock")
    final Set<String> oKw;
    private final long oKy;
    private final Object mLock = new Object();
    private final StatFsHelper oKz = StatFsHelper.eku();
    private long oKx = -1;
    private final a oKB = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gvN = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gvN = -1L;
            this.mSize = -1L;
        }

        public synchronized void J(long j, long j2) {
            this.gvN = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void K(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gvN += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gvN;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public final long oKs;
        public final long oKt;
        public final long oKy;

        public b(long j, long j2, long j3) {
            this.oKy = j;
            this.oKs = j2;
            this.oKt = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.oKs = bVar.oKs;
        this.oKt = bVar.oKt;
        this.oKv = bVar.oKt;
        this.oKA = cVar;
        this.oKi = gVar;
        this.oKj = cacheEventListener;
        this.oKy = bVar.oKy;
        this.oJW = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.oJX = com.facebook.common.time.c.eky();
        this.oKl = z;
        this.oKw = new HashSet();
        if (this.oKl) {
            this.oKu = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.ejN();
                    }
                    d.this.oKC = true;
                    d.this.oKu.countDown();
                }
            });
            return;
        }
        this.oKu = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.ejT().h(bVar);
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
                    h.XX(str2);
                    com.facebook.a.a D = this.oKA.D(str2, bVar);
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
                    this.oKj.b(h);
                    this.oKw.remove(str);
                } else {
                    this.oKj.a(h);
                    this.oKw.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.oJW.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, oJR, "getResource", e);
            h.e(e);
            this.oKj.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        ejL();
        return this.oKA.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aX;
        synchronized (this.mLock) {
            aX = bVar.aX(bVar2);
            this.oKw.add(str);
            this.oKB.K(aX.size(), 1L);
        }
        return aX;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.ejT().h(bVar);
        this.oKj.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.XX(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.hB(a3.size()).hC(this.oKB.getSize());
                    this.oKj.d(h);
                    return a3;
                } finally {
                    if (!a2.ejx()) {
                        com.facebook.common.c.a.h(oJR, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.oKj.f(h);
                com.facebook.common.c.a.b(oJR, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.oKA.XT(str);
                    this.oKw.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.oJW.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, oJR, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void ejL() throws IOException {
        synchronized (this.mLock) {
            boolean ejN = ejN();
            ejM();
            long size = this.oKB.getSize();
            if (size > this.oKv && !ejN) {
                this.oKB.reset();
                ejN();
            }
            if (size > this.oKv) {
                a((this.oKv * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.oKA.eju());
            long size = this.oKB.getSize();
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
                long a2 = this.oKA.a(next);
                this.oKw.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i hD = i.ejT().XX(next.getId()).a(evictionReason).hB(a2).hC(size - j2).hD(j);
                    this.oKj.g(hD);
                    hD.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.oKB.K(-j2, -i);
            this.oKA.ejt();
        } catch (IOException e) {
            this.oJW.a(CacheErrorLogger.CacheErrorCategory.EVICTION, oJR, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = oKq + this.oJX.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.oKi.ejy());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void ejM() {
        if (this.oKz.a(this.oKA.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.oKt - this.oKB.getSize())) {
            this.oKv = this.oKs;
        } else {
            this.oKv = this.oKt;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.oKw.contains(a2.get(i))) {
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
                    if (this.oKA.E(str, bVar)) {
                        this.oKw.add(str);
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
    public boolean ejN() {
        long now = this.oJX.now();
        if (!this.oKB.isInitialized() || this.oKx == -1 || now - this.oKx > oKr) {
            return ejO();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean ejO() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.oJX.now();
        long j3 = now + oKq;
        if (this.oKl && this.oKw.isEmpty()) {
            set = this.oKw;
        } else if (this.oKl) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.oKA.eju()) {
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
                    if (this.oKl) {
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
                this.oJW.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, oJR, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.oKB.getCount() != i5 || this.oKB.getSize() != j4) {
                if (this.oKl && this.oKw != set) {
                    this.oKw.clear();
                    this.oKw.addAll(set);
                }
                this.oKB.J(j4, i5);
            }
            this.oKx = now;
            return true;
        } catch (IOException e) {
            this.oJW.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, oJR, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
/* loaded from: classes17.dex */
public class d implements h, com.facebook.common.a.a {
    private final CacheErrorLogger oLA;
    private final com.facebook.common.time.a oLB;
    private final g oLM;
    private final CacheEventListener oLN;
    private final boolean oLP;
    private final long oLW;
    private final long oLX;
    private final CountDownLatch oLY;
    private long oLZ;
    @GuardedBy("mLock")
    final Set<String> oMa;
    private final long oMc;
    private final c oMe;
    private boolean oMg;
    private static final Class<?> oLv = d.class;
    private static final long oLU = TimeUnit.HOURS.toMillis(2);
    private static final long oLV = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper oMd = StatFsHelper.eks();
    private long oMb = -1;
    private final a oMf = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gvu = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gvu = -1L;
            this.mSize = -1L;
        }

        public synchronized void J(long j, long j2) {
            this.gvu = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void K(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gvu += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gvu;
        }
    }

    /* loaded from: classes17.dex */
    public static class b {
        public final long oLW;
        public final long oLX;
        public final long oMc;

        public b(long j, long j2, long j3) {
            this.oMc = j;
            this.oLW = j2;
            this.oLX = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.oLW = bVar.oLW;
        this.oLX = bVar.oLX;
        this.oLZ = bVar.oLX;
        this.oMe = cVar;
        this.oLM = gVar;
        this.oLN = cacheEventListener;
        this.oMc = bVar.oMc;
        this.oLA = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.oLB = com.facebook.common.time.c.ekw();
        this.oLP = z;
        this.oMa = new HashSet();
        if (this.oLP) {
            this.oLY = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.ejL();
                    }
                    d.this.oMg = true;
                    d.this.oLY.countDown();
                }
            });
            return;
        }
        this.oLY = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.ejR().h(bVar);
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
                    h.XI(str2);
                    com.facebook.a.a D = this.oMe.D(str2, bVar);
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
                    this.oLN.b(h);
                    this.oMa.remove(str);
                } else {
                    this.oLN.a(h);
                    this.oMa.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.oLA.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, oLv, "getResource", e);
            h.e(e);
            this.oLN.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        ejJ();
        return this.oMe.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aY;
        synchronized (this.mLock) {
            aY = bVar.aY(bVar2);
            this.oMa.add(str);
            this.oMf.K(aY.size(), 1L);
        }
        return aY;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.ejR().h(bVar);
        this.oLN.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.XI(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.hE(a3.size()).hF(this.oMf.getSize());
                    this.oLN.d(h);
                    return a3;
                } finally {
                    if (!a2.ejv()) {
                        com.facebook.common.c.a.h(oLv, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.oLN.f(h);
                com.facebook.common.c.a.b(oLv, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.oMe.XE(str);
                    this.oMa.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.oLA.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, oLv, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void ejJ() throws IOException {
        synchronized (this.mLock) {
            boolean ejL = ejL();
            ejK();
            long size = this.oMf.getSize();
            if (size > this.oLZ && !ejL) {
                this.oMf.reset();
                ejL();
            }
            if (size > this.oLZ) {
                a((this.oLZ * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.oMe.ejs());
            long size = this.oMf.getSize();
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
                long a2 = this.oMe.a(next);
                this.oMa.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i hG = i.ejR().XI(next.getId()).a(evictionReason).hE(a2).hF(size - j2).hG(j);
                    this.oLN.g(hG);
                    hG.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.oMf.K(-j2, -i);
            this.oMe.ejr();
        } catch (IOException e) {
            this.oLA.a(CacheErrorLogger.CacheErrorCategory.EVICTION, oLv, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = oLU + this.oLB.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.oLM.ejw());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void ejK() {
        if (this.oMd.a(this.oMe.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.oLX - this.oMf.getSize())) {
            this.oLZ = this.oLW;
        } else {
            this.oLZ = this.oLX;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.oMa.contains(a2.get(i))) {
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
                    if (this.oMe.E(str, bVar)) {
                        this.oMa.add(str);
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
    public boolean ejL() {
        long now = this.oLB.now();
        if (!this.oMf.isInitialized() || this.oMb == -1 || now - this.oMb > oLV) {
            return ejM();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean ejM() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.oLB.now();
        long j3 = now + oLU;
        if (this.oLP && this.oMa.isEmpty()) {
            set = this.oMa;
        } else if (this.oLP) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.oMe.ejs()) {
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
                    if (this.oLP) {
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
                this.oLA.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, oLv, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.oMf.getCount() != i5 || this.oMf.getSize() != j4) {
                if (this.oLP && this.oMa != set) {
                    this.oMa.clear();
                    this.oMa.addAll(set);
                }
                this.oMf.J(j4, i5);
            }
            this.oMb = now;
            return true;
        } catch (IOException e) {
            this.oLA.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, oLv, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

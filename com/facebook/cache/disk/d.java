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
/* loaded from: classes2.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> iez = d.class;
    private static final long ifb = TimeUnit.HOURS.toMillis(2);
    private static final long ifc = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger ieE;
    private final com.facebook.common.time.a ieF;
    private final g ieT;
    private final CacheEventListener ieU;
    private final boolean ieW;
    private final long ifd;
    private final long ife;
    private long iff;
    @GuardedBy("mLock")
    final Set<String> ifg;
    private final long ifi;
    private final c ifk;
    private boolean ifm;
    private final CountDownLatch mCountDownLatch;
    private final Object mLock = new Object();
    private final StatFsHelper ifj = StatFsHelper.bTx();
    private long ifh = -1;
    private final a ifl = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean ifo = false;
        private long mSize = -1;
        private long ifp = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.ifo;
        }

        public synchronized void reset() {
            this.ifo = false;
            this.ifp = -1L;
            this.mSize = -1L;
        }

        public synchronized void o(long j, long j2) {
            this.ifp = j2;
            this.mSize = j;
            this.ifo = true;
        }

        public synchronized void p(long j, long j2) {
            if (this.ifo) {
                this.mSize += j;
                this.ifp += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.ifp;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long ifd;
        public final long ife;
        public final long ifi;

        public b(long j, long j2, long j3) {
            this.ifi = j;
            this.ifd = j2;
            this.ife = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.ifd = bVar.ifd;
        this.ife = bVar.ife;
        this.iff = bVar.ife;
        this.ifk = cVar;
        this.ieT = gVar;
        this.ieU = cacheEventListener;
        this.ifi = bVar.ifi;
        this.ieE = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.ieF = com.facebook.common.time.b.bTC();
        this.ieW = z;
        this.ifg = new HashSet();
        if (this.ieW) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bSP();
                    }
                    d.this.ifm = true;
                    d.this.mCountDownLatch.countDown();
                }
            });
            return;
        }
        this.mCountDownLatch = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.bSV().g(bVar);
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
                    g.zb(str2);
                    com.facebook.a.a l = this.ifk.l(str2, bVar);
                    if (l != null) {
                        str = str2;
                        aVar = l;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = l;
                }
                if (aVar == null) {
                    this.ieU.b(g);
                    this.ifg.remove(str);
                } else {
                    this.ieU.a(g);
                    this.ifg.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.ieE.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, iez, "getResource", e);
            g.a(e);
            this.ieU.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bSN();
        return this.ifk.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a am;
        synchronized (this.mLock) {
            am = bVar.am(bVar2);
            this.ifg.add(str);
            this.ifl.p(am.size(), 1L);
        }
        return am;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bSV().g(bVar);
        this.ieU.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.zb(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.ds(a3.size()).dt(this.ifl.getSize());
                    this.ieU.d(g);
                    return a3;
                } finally {
                    if (!a2.bSz()) {
                        com.facebook.common.c.a.g(iez, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.ieU.f(g);
                com.facebook.common.c.a.b(iez, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void bSN() throws IOException {
        synchronized (this.mLock) {
            boolean bSP = bSP();
            bSO();
            long size = this.ifl.getSize();
            if (size > this.iff && !bSP) {
                this.ifl.reset();
                bSP();
            }
            if (size > this.iff) {
                a((this.iff * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.ifk.bSw());
            long size = this.ifl.getSize();
            long j3 = size - j;
            int i2 = 0;
            long j4 = 0;
            Iterator<c.a> it = g.iterator();
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
                long a2 = this.ifk.a(next);
                this.ifg.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i du = i.bSV().zb(next.getId()).a(evictionReason).ds(a2).dt(size - j2).du(j);
                    this.ieU.g(du);
                    du.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.ifl.p(-j2, -i);
            this.ifk.bSv();
        } catch (IOException e) {
            this.ieE.a(CacheErrorLogger.CacheErrorCategory.EVICTION, iez, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = ifb + this.ieF.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.ieT.bSA());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bSO() {
        if (this.ifj.a(this.ifk.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.ife - this.ifl.getSize())) {
            this.iff = this.ifd;
        } else {
            this.iff = this.ife;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.ifg.contains(a2.get(i))) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            if (e(bVar)) {
                return true;
            }
            try {
                List<String> a2 = com.facebook.cache.common.c.a(bVar);
                for (int i = 0; i < a2.size(); i++) {
                    String str = a2.get(i);
                    if (this.ifk.m(str, bVar)) {
                        this.ifg.add(str);
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
    public boolean bSP() {
        long now = this.ieF.now();
        if (!this.ifl.isInitialized() || this.ifh == -1 || now - this.ifh > ifc) {
            return bSQ();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean bSQ() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.ieF.now();
        long j3 = now + ifb;
        if (this.ieW && this.ifg.isEmpty()) {
            set = this.ifg;
        } else if (this.ieW) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.ifk.bSw()) {
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
                    if (this.ieW) {
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
                this.ieE.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, iez, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.ifl.getCount() != i5 || this.ifl.getSize() != j4) {
                if (this.ieW && this.ifg != set) {
                    this.ifg.clear();
                    this.ifg.addAll(set);
                }
                this.ifl.o(j4, i5);
            }
            this.ifh = now;
            return true;
        } catch (IOException e) {
            this.ieE.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, iez, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

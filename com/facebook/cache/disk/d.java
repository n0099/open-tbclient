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
    private final CountDownLatch aoW;
    private final CacheErrorLogger jyA;
    private final com.facebook.common.time.a jyB;
    private final g jyO;
    private final CacheEventListener jyP;
    private final boolean jyR;
    private final long jyY;
    private final long jyZ;
    private long jza;
    @GuardedBy("mLock")
    final Set<String> jzb;
    private final long jzd;
    private final c jzf;
    private boolean jzh;
    private static final Class<?> jyv = d.class;
    private static final long jyW = TimeUnit.HOURS.toMillis(2);
    private static final long jyX = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper jze = StatFsHelper.ctT();
    private long jzc = -1;
    private final a jzg = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aSN = -1;
        private long jzj = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jzj = -1L;
            this.aSN = -1L;
        }

        public synchronized void t(long j, long j2) {
            this.jzj = j2;
            this.aSN = j;
            this.mInitialized = true;
        }

        public synchronized void u(long j, long j2) {
            if (this.mInitialized) {
                this.aSN += j;
                this.jzj += j2;
            }
        }

        public synchronized long getSize() {
            return this.aSN;
        }

        public synchronized long getCount() {
            return this.jzj;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jyY;
        public final long jyZ;
        public final long jzd;

        public b(long j, long j2, long j3) {
            this.jzd = j;
            this.jyY = j2;
            this.jyZ = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jyY = bVar.jyY;
        this.jyZ = bVar.jyZ;
        this.jza = bVar.jyZ;
        this.jzf = cVar;
        this.jyO = gVar;
        this.jyP = cacheEventListener;
        this.jzd = bVar.jzd;
        this.jyA = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jyB = com.facebook.common.time.b.ctY();
        this.jyR = z;
        this.jzb = new HashSet();
        if (this.jyR) {
            this.aoW = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.ctl();
                    }
                    d.this.jzh = true;
                    d.this.aoW.countDown();
                }
            });
            return;
        }
        this.aoW = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.ctr().g(bVar);
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
                    g.Fw(str2);
                    com.facebook.a.a o = this.jzf.o(str2, bVar);
                    if (o != null) {
                        str = str2;
                        aVar = o;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = o;
                }
                if (aVar == null) {
                    this.jyP.b(g);
                    this.jzb.remove(str);
                } else {
                    this.jyP.a(g);
                    this.jzb.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jyA.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyv, "getResource", e);
            g.a(e);
            this.jyP.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        ctj();
        return this.jzf.n(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aB;
        synchronized (this.mLock) {
            aB = bVar.aB(bVar2);
            this.jzb.add(str);
            this.jzg.u(aB.size(), 1L);
        }
        return aB;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.ctr().g(bVar);
        this.jyP.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.Fw(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.ec(a3.size()).ed(this.jzg.getSize());
                    this.jyP.d(g);
                    return a3;
                } finally {
                    if (!a2.csV()) {
                        com.facebook.common.c.a.g(jyv, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jyP.f(g);
                com.facebook.common.c.a.b(jyv, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void ctj() throws IOException {
        synchronized (this.mLock) {
            boolean ctl = ctl();
            ctk();
            long size = this.jzg.getSize();
            if (size > this.jza && !ctl) {
                this.jzg.reset();
                ctl();
            }
            if (size > this.jza) {
                a((this.jza * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jzf.csS());
            long size = this.jzg.getSize();
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
                long a2 = this.jzf.a(next);
                this.jzb.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i ee = i.ctr().Fw(next.getId()).a(evictionReason).ec(a2).ed(size - j2).ee(j);
                    this.jyP.g(ee);
                    ee.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jzg.u(-j2, -i);
            this.jzf.csR();
        } catch (IOException e) {
            this.jyA.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jyv, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jyW + this.jyB.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jyO.csW());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void ctk() {
        if (this.jze.a(this.jzf.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jyZ - this.jzg.getSize())) {
            this.jza = this.jyY;
        } else {
            this.jza = this.jyZ;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jzb.contains(a2.get(i))) {
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
                    if (this.jzf.p(str, bVar)) {
                        this.jzb.add(str);
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
    public boolean ctl() {
        long now = this.jyB.now();
        if (!this.jzg.isInitialized() || this.jzc == -1 || now - this.jzc > jyX) {
            return ctm();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean ctm() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jyB.now();
        long j3 = now + jyW;
        if (this.jyR && this.jzb.isEmpty()) {
            set = this.jzb;
        } else if (this.jyR) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jzf.csS()) {
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
                    if (this.jyR) {
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
                this.jyA.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jyv, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jzg.getCount() != i5 || this.jzg.getSize() != j4) {
                if (this.jyR && this.jzb != set) {
                    this.jzb.clear();
                    this.jzb.addAll(set);
                }
                this.jzg.t(j4, i5);
            }
            this.jzc = now;
            return true;
        } catch (IOException e) {
            this.jyA.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyv, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

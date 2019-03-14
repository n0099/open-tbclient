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
    private static final Class<?> jyG = d.class;
    private static final long jzh = TimeUnit.HOURS.toMillis(2);
    private static final long jzi = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch aoX;
    private final CacheErrorLogger jyL;
    private final com.facebook.common.time.a jyM;
    private final g jyZ;
    private final CacheEventListener jza;
    private final boolean jzc;
    private final long jzj;
    private final long jzk;
    private long jzl;
    @GuardedBy("mLock")
    final Set<String> jzm;
    private final long jzo;
    private final c jzq;
    private boolean jzs;
    private final Object mLock = new Object();
    private final StatFsHelper jzp = StatFsHelper.cug();
    private long jzn = -1;
    private final a jzr = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aSO = -1;
        private long jzu = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jzu = -1L;
            this.aSO = -1L;
        }

        public synchronized void t(long j, long j2) {
            this.jzu = j2;
            this.aSO = j;
            this.mInitialized = true;
        }

        public synchronized void u(long j, long j2) {
            if (this.mInitialized) {
                this.aSO += j;
                this.jzu += j2;
            }
        }

        public synchronized long getSize() {
            return this.aSO;
        }

        public synchronized long getCount() {
            return this.jzu;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jzj;
        public final long jzk;
        public final long jzo;

        public b(long j, long j2, long j3) {
            this.jzo = j;
            this.jzj = j2;
            this.jzk = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jzj = bVar.jzj;
        this.jzk = bVar.jzk;
        this.jzl = bVar.jzk;
        this.jzq = cVar;
        this.jyZ = gVar;
        this.jza = cacheEventListener;
        this.jzo = bVar.jzo;
        this.jyL = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jyM = com.facebook.common.time.b.cul();
        this.jzc = z;
        this.jzm = new HashSet();
        if (this.jzc) {
            this.aoX = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.cty();
                    }
                    d.this.jzs = true;
                    d.this.aoX.countDown();
                }
            });
            return;
        }
        this.aoX = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i g = i.ctE().g(bVar);
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
                    g.Fx(str2);
                    com.facebook.a.a o = this.jzq.o(str2, bVar);
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
                    this.jza.b(g);
                    this.jzm.remove(str);
                } else {
                    this.jza.a(g);
                    this.jzm.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jyL.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyG, "getResource", e);
            g.a(e);
            this.jza.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        ctw();
        return this.jzq.n(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aC;
        synchronized (this.mLock) {
            aC = bVar.aC(bVar2);
            this.jzm.add(str);
            this.jzr.u(aC.size(), 1L);
        }
        return aC;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.ctE().g(bVar);
        this.jza.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.Fx(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.ec(a3.size()).ed(this.jzr.getSize());
                    this.jza.d(g);
                    return a3;
                } finally {
                    if (!a2.cti()) {
                        com.facebook.common.c.a.g(jyG, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jza.f(g);
                com.facebook.common.c.a.b(jyG, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void ctw() throws IOException {
        synchronized (this.mLock) {
            boolean cty = cty();
            ctx();
            long size = this.jzr.getSize();
            if (size > this.jzl && !cty) {
                this.jzr.reset();
                cty();
            }
            if (size > this.jzl) {
                a((this.jzl * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jzq.ctf());
            long size = this.jzr.getSize();
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
                long a2 = this.jzq.a(next);
                this.jzm.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i ee = i.ctE().Fx(next.getId()).a(evictionReason).ec(a2).ed(size - j2).ee(j);
                    this.jza.g(ee);
                    ee.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jzr.u(-j2, -i);
            this.jzq.cte();
        } catch (IOException e) {
            this.jyL.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jyG, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jzh + this.jyM.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jyZ.ctj());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void ctx() {
        if (this.jzp.a(this.jzq.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jzk - this.jzr.getSize())) {
            this.jzl = this.jzj;
        } else {
            this.jzl = this.jzk;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jzm.contains(a2.get(i))) {
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
                    if (this.jzq.p(str, bVar)) {
                        this.jzm.add(str);
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
    public boolean cty() {
        long now = this.jyM.now();
        if (!this.jzr.isInitialized() || this.jzn == -1 || now - this.jzn > jzi) {
            return ctz();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean ctz() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jyM.now();
        long j3 = now + jzh;
        if (this.jzc && this.jzm.isEmpty()) {
            set = this.jzm;
        } else if (this.jzc) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jzq.ctf()) {
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
                    if (this.jzc) {
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
                this.jyL.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jyG, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jzr.getCount() != i5 || this.jzr.getSize() != j4) {
                if (this.jzc && this.jzm != set) {
                    this.jzm.clear();
                    this.jzm.addAll(set);
                }
                this.jzr.t(j4, i5);
            }
            this.jzn = now;
            return true;
        } catch (IOException e) {
            this.jyL.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyG, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
    private static final Class<?> jyO = d.class;
    private static final long jzp = TimeUnit.HOURS.toMillis(2);
    private static final long jzq = TimeUnit.MINUTES.toMillis(30);
    private final CountDownLatch aoW;
    private final CacheErrorLogger jyT;
    private final com.facebook.common.time.a jyU;
    private boolean jzA;
    private final g jzh;
    private final CacheEventListener jzi;
    private final boolean jzk;
    private final long jzr;
    private final long jzs;
    private long jzt;
    @GuardedBy("mLock")
    final Set<String> jzu;
    private final long jzw;
    private final c jzy;
    private final Object mLock = new Object();
    private final StatFsHelper jzx = StatFsHelper.cud();
    private long jzv = -1;
    private final a jzz = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean mInitialized = false;
        private long aSN = -1;
        private long jzC = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.jzC = -1L;
            this.aSN = -1L;
        }

        public synchronized void t(long j, long j2) {
            this.jzC = j2;
            this.aSN = j;
            this.mInitialized = true;
        }

        public synchronized void u(long j, long j2) {
            if (this.mInitialized) {
                this.aSN += j;
                this.jzC += j2;
            }
        }

        public synchronized long getSize() {
            return this.aSN;
        }

        public synchronized long getCount() {
            return this.jzC;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long jzr;
        public final long jzs;
        public final long jzw;

        public b(long j, long j2, long j3) {
            this.jzw = j;
            this.jzr = j2;
            this.jzs = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.jzr = bVar.jzr;
        this.jzs = bVar.jzs;
        this.jzt = bVar.jzs;
        this.jzy = cVar;
        this.jzh = gVar;
        this.jzi = cacheEventListener;
        this.jzw = bVar.jzw;
        this.jyT = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.jyU = com.facebook.common.time.b.cui();
        this.jzk = z;
        this.jzu = new HashSet();
        if (this.jzk) {
            this.aoW = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.ctv();
                    }
                    d.this.jzA = true;
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
        i g = i.ctB().g(bVar);
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
                    g.Fz(str2);
                    com.facebook.a.a o = this.jzy.o(str2, bVar);
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
                    this.jzi.b(g);
                    this.jzu.remove(str);
                } else {
                    this.jzi.a(g);
                    this.jzu.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.jyT.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyO, "getResource", e);
            g.a(e);
            this.jzi.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        ctt();
        return this.jzy.n(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aC;
        synchronized (this.mLock) {
            aC = bVar.aC(bVar2);
            this.jzu.add(str);
            this.jzz.u(aC.size(), 1L);
        }
        return aC;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.ctB().g(bVar);
        this.jzi.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.Fz(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.ec(a3.size()).ed(this.jzz.getSize());
                    this.jzi.d(g);
                    return a3;
                } finally {
                    if (!a2.ctf()) {
                        com.facebook.common.c.a.g(jyO, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.jzi.f(g);
                com.facebook.common.c.a.b(jyO, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void ctt() throws IOException {
        synchronized (this.mLock) {
            boolean ctv = ctv();
            ctu();
            long size = this.jzz.getSize();
            if (size > this.jzt && !ctv) {
                this.jzz.reset();
                ctv();
            }
            if (size > this.jzt) {
                a((this.jzt * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.jzy.ctc());
            long size = this.jzz.getSize();
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
                long a2 = this.jzy.a(next);
                this.jzu.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i ee = i.ctB().Fz(next.getId()).a(evictionReason).ec(a2).ed(size - j2).ee(j);
                    this.jzi.g(ee);
                    ee.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.jzz.u(-j2, -i);
            this.jzy.ctb();
        } catch (IOException e) {
            this.jyT.a(CacheErrorLogger.CacheErrorCategory.EVICTION, jyO, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = jzp + this.jyU.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.jzh.ctg());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void ctu() {
        if (this.jzx.a(this.jzy.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.jzs - this.jzz.getSize())) {
            this.jzt = this.jzr;
        } else {
            this.jzt = this.jzs;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.jzu.contains(a2.get(i))) {
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
                    if (this.jzy.p(str, bVar)) {
                        this.jzu.add(str);
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
    public boolean ctv() {
        long now = this.jyU.now();
        if (!this.jzz.isInitialized() || this.jzv == -1 || now - this.jzv > jzq) {
            return ctw();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean ctw() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.jyU.now();
        long j3 = now + jzp;
        if (this.jzk && this.jzu.isEmpty()) {
            set = this.jzu;
        } else if (this.jzk) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.jzy.ctc()) {
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
                    if (this.jzk) {
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
                this.jyT.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, jyO, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.jzz.getCount() != i5 || this.jzz.getSize() != j4) {
                if (this.jzk && this.jzu != set) {
                    this.jzu.clear();
                    this.jzu.addAll(set);
                }
                this.jzz.t(j4, i5);
            }
            this.jzv = now;
            return true;
        } catch (IOException e) {
            this.jyT.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, jyO, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

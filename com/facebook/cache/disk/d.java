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
/* loaded from: classes5.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> prR = d.class;
    private static final long psq = TimeUnit.HOURS.toMillis(2);
    private static final long psr = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger prW;
    private final com.facebook.common.time.a prX;
    private final c psA;
    private boolean psC;
    private final g psi;
    private final CacheEventListener psj;
    private final boolean psl;
    private final long pss;
    private final long pst;
    private final CountDownLatch psu;
    private long psv;
    @GuardedBy("mLock")
    final Set<String> psw;
    private final long psy;
    private final Object mLock = new Object();
    private final StatFsHelper psz = StatFsHelper.eur();
    private long psx = -1;
    private final a psB = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gPR = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gPR = -1L;
            this.mSize = -1L;
        }

        public synchronized void M(long j, long j2) {
            this.gPR = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void N(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gPR += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gPR;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final long pss;
        public final long pst;
        public final long psy;

        public b(long j, long j2, long j3) {
            this.psy = j;
            this.pss = j2;
            this.pst = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pss = bVar.pss;
        this.pst = bVar.pst;
        this.psv = bVar.pst;
        this.psA = cVar;
        this.psi = gVar;
        this.psj = cacheEventListener;
        this.psy = bVar.psy;
        this.prW = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.prX = com.facebook.common.time.c.euv();
        this.psl = z;
        this.psw = new HashSet();
        if (this.psl) {
            this.psu = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.etK();
                    }
                    d.this.psC = true;
                    d.this.psu.countDown();
                }
            });
            return;
        }
        this.psu = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.etQ().h(bVar);
        try {
            try {
                synchronized (this.mLock) {
                    List<String> a2 = com.facebook.cache.common.c.a(bVar);
                    aVar = null;
                    String str = null;
                    for (int i = 0; i < a2.size(); i++) {
                        str = a2.get(i);
                        h.Zn(str);
                        aVar = this.psA.G(str, bVar);
                        if (aVar != null) {
                            break;
                        }
                    }
                    if (aVar == null) {
                        this.psj.b(h);
                        this.psw.remove(str);
                    } else {
                        this.psj.a(h);
                        this.psw.add(str);
                    }
                }
                h.recycle();
                return aVar;
            } catch (IOException e) {
                this.prW.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, prR, "getResource", e);
                h.h(e);
                this.psj.e(h);
                h.recycle();
                return null;
            }
        } catch (Throwable th) {
            h.recycle();
            throw th;
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        etI();
        return this.psA.F(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aZ;
        synchronized (this.mLock) {
            aZ = bVar.aZ(bVar2);
            this.psw.add(str);
            this.psB.N(aZ.size(), 1L);
        }
        return aZ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.etQ().h(bVar);
        this.psj.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zn(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.ix(a3.size()).iy(this.psB.getSize());
                    this.psj.d(h);
                    return a3;
                } finally {
                    if (!a2.etv()) {
                        com.facebook.common.c.a.i(prR, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.h(e);
                this.psj.f(h);
                com.facebook.common.c.a.b(prR, "Failed inserting a file into the cache", e);
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
                    this.psA.Zj(str);
                    this.psw.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.prW.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, prR, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void etI() throws IOException {
        synchronized (this.mLock) {
            boolean etK = etK();
            etJ();
            long size = this.psB.getSize();
            if (size > this.psv && !etK) {
                this.psB.reset();
                etK();
            }
            if (size > this.psv) {
                a((this.psv * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2;
        try {
            Collection<c.a> l = l(this.psA.ets());
            long size = this.psB.getSize();
            long j3 = size - j;
            int i = 0;
            long j4 = 0;
            Iterator<c.a> it = l.iterator();
            while (true) {
                j2 = j4;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j3) {
                    break;
                }
                long a2 = this.psA.a(next);
                this.psw.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i iz = i.etQ().Zn(next.getId()).a(evictionReason).ix(a2).iy(size - j2).iz(j);
                    this.psj.g(iz);
                    iz.recycle();
                }
                j4 = j2;
            }
            this.psB.N(-j2, -i);
            this.psA.etr();
        } catch (IOException e) {
            this.prW.a(CacheErrorLogger.CacheErrorCategory.EVICTION, prR, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = psq + this.prX.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.psi.etw());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void etJ() {
        if (this.psz.a(this.psA.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pst - this.psB.getSize())) {
            this.psv = this.pss;
        } else {
            this.psv = this.pst;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.psw.contains(a2.get(i))) {
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
                    if (this.psA.H(str, bVar)) {
                        this.psw.add(str);
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
    public boolean etK() {
        long now = this.prX.now();
        if (!this.psB.isInitialized() || this.psx == -1 || now - this.psx > psr) {
            return etL();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean etL() {
        Set<String> set;
        long j;
        long j2 = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        long j3 = -1;
        long now = this.prX.now();
        long j4 = now + psq;
        if (this.psl && this.psw.isEmpty()) {
            set = this.psw;
        } else if (this.psl) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            int i3 = 0;
            for (c.a aVar : this.psA.ets()) {
                i3++;
                j2 += aVar.getSize();
                if (aVar.getTimestamp() > j4) {
                    z = true;
                    i++;
                    i2 = (int) (i2 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j3);
                } else {
                    if (this.psl) {
                        set.add(aVar.getId());
                    }
                    j = j3;
                }
                j3 = j;
            }
            if (z) {
                this.prW.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, prR, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            if (this.psB.getCount() != i3 || this.psB.getSize() != j2) {
                if (this.psl && this.psw != set) {
                    this.psw.clear();
                    this.psw.addAll(set);
                }
                this.psB.M(j2, i3);
            }
            this.psx = now;
            return true;
        } catch (IOException e) {
            this.prW.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, prR, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
/* loaded from: classes6.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> prQ = d.class;
    private static final long psp = TimeUnit.HOURS.toMillis(2);
    private static final long psq = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger prV;
    private final com.facebook.common.time.a prW;
    private boolean psB;
    private final g psh;
    private final CacheEventListener psi;
    private final boolean psk;
    private final long psr;
    private final long pss;
    private final CountDownLatch pst;
    private long psu;
    @GuardedBy("mLock")
    final Set<String> psv;
    private final long psx;
    private final c psz;
    private final Object mLock = new Object();
    private final StatFsHelper psy = StatFsHelper.euk();
    private long psw = -1;
    private final a psA = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class b {
        public final long psr;
        public final long pss;
        public final long psx;

        public b(long j, long j2, long j3) {
            this.psx = j;
            this.psr = j2;
            this.pss = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.psr = bVar.psr;
        this.pss = bVar.pss;
        this.psu = bVar.pss;
        this.psz = cVar;
        this.psh = gVar;
        this.psi = cacheEventListener;
        this.psx = bVar.psx;
        this.prV = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.prW = com.facebook.common.time.c.euo();
        this.psk = z;
        this.psv = new HashSet();
        if (this.psk) {
            this.pst = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.etG();
                    }
                    d.this.psB = true;
                    d.this.pst.countDown();
                }
            });
            return;
        }
        this.pst = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.etM().h(bVar);
        try {
            try {
                synchronized (this.mLock) {
                    List<String> a2 = com.facebook.cache.common.c.a(bVar);
                    aVar = null;
                    String str = null;
                    for (int i = 0; i < a2.size(); i++) {
                        str = a2.get(i);
                        h.Zo(str);
                        aVar = this.psz.G(str, bVar);
                        if (aVar != null) {
                            break;
                        }
                    }
                    if (aVar == null) {
                        this.psi.b(h);
                        this.psv.remove(str);
                    } else {
                        this.psi.a(h);
                        this.psv.add(str);
                    }
                }
                h.recycle();
                return aVar;
            } catch (IOException e) {
                this.prV.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, prQ, "getResource", e);
                h.h(e);
                this.psi.e(h);
                h.recycle();
                return null;
            }
        } catch (Throwable th) {
            h.recycle();
            throw th;
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        etE();
        return this.psz.F(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aZ;
        synchronized (this.mLock) {
            aZ = bVar.aZ(bVar2);
            this.psv.add(str);
            this.psA.N(aZ.size(), 1L);
        }
        return aZ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.etM().h(bVar);
        this.psi.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zo(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.ix(a3.size()).iy(this.psA.getSize());
                    this.psi.d(h);
                    return a3;
                } finally {
                    if (!a2.etr()) {
                        com.facebook.common.c.a.i(prQ, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.h(e);
                this.psi.f(h);
                com.facebook.common.c.a.b(prQ, "Failed inserting a file into the cache", e);
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
                    this.psz.Zk(str);
                    this.psv.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.prV.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, prQ, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void etE() throws IOException {
        synchronized (this.mLock) {
            boolean etG = etG();
            etF();
            long size = this.psA.getSize();
            if (size > this.psu && !etG) {
                this.psA.reset();
                etG();
            }
            if (size > this.psu) {
                a((this.psu * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2;
        try {
            Collection<c.a> l = l(this.psz.eto());
            long size = this.psA.getSize();
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
                long a2 = this.psz.a(next);
                this.psv.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i iz = i.etM().Zo(next.getId()).a(evictionReason).ix(a2).iy(size - j2).iz(j);
                    this.psi.g(iz);
                    iz.recycle();
                }
                j4 = j2;
            }
            this.psA.N(-j2, -i);
            this.psz.etn();
        } catch (IOException e) {
            this.prV.a(CacheErrorLogger.CacheErrorCategory.EVICTION, prQ, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = psp + this.prW.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.psh.ets());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void etF() {
        if (this.psy.a(this.psz.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pss - this.psA.getSize())) {
            this.psu = this.psr;
        } else {
            this.psu = this.pss;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.psv.contains(a2.get(i))) {
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
                    if (this.psz.H(str, bVar)) {
                        this.psv.add(str);
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
    public boolean etG() {
        long now = this.prW.now();
        if (!this.psA.isInitialized() || this.psw == -1 || now - this.psw > psq) {
            return etH();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean etH() {
        Set<String> set;
        long j;
        long j2 = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        long j3 = -1;
        long now = this.prW.now();
        long j4 = now + psp;
        if (this.psk && this.psv.isEmpty()) {
            set = this.psv;
        } else if (this.psk) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            int i3 = 0;
            for (c.a aVar : this.psz.eto()) {
                i3++;
                j2 += aVar.getSize();
                if (aVar.getTimestamp() > j4) {
                    z = true;
                    i++;
                    i2 = (int) (i2 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j3);
                } else {
                    if (this.psk) {
                        set.add(aVar.getId());
                    }
                    j = j3;
                }
                j3 = j;
            }
            if (z) {
                this.prV.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, prQ, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            if (this.psA.getCount() != i3 || this.psA.getSize() != j2) {
                if (this.psk && this.psv != set) {
                    this.psv.clear();
                    this.psv.addAll(set);
                }
                this.psA.M(j2, i3);
            }
            this.psw = now;
            return true;
        } catch (IOException e) {
            this.prV.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, prQ, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

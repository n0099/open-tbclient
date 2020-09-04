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
/* loaded from: classes8.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> njM = d.class;
    private static final long nkl = TimeUnit.HOURS.toMillis(2);
    private static final long nkm = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger njR;
    private final com.facebook.common.time.a njS;
    private final g nkd;
    private final CacheEventListener nke;
    private final boolean nkg;
    private final long nkn;
    private final long nko;
    private final CountDownLatch nkp;
    private long nkq;
    @GuardedBy("mLock")
    final Set<String> nkr;
    private final long nkt;
    private final c nkv;
    private boolean nkx;
    private final Object mLock = new Object();
    private final StatFsHelper nku = StatFsHelper.dOY();
    private long nks = -1;
    private final a nkw = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long fQt = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.fQt = -1L;
            this.mSize = -1L;
        }

        public synchronized void K(long j, long j2) {
            this.fQt = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void L(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.fQt += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.fQt;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final long nkn;
        public final long nko;
        public final long nkt;

        public b(long j, long j2, long j3) {
            this.nkt = j;
            this.nkn = j2;
            this.nko = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.nkn = bVar.nkn;
        this.nko = bVar.nko;
        this.nkq = bVar.nko;
        this.nkv = cVar;
        this.nkd = gVar;
        this.nke = cacheEventListener;
        this.nkt = bVar.nkt;
        this.njR = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.njS = com.facebook.common.time.c.dPc();
        this.nkg = z;
        this.nkr = new HashSet();
        if (this.nkg) {
            this.nkp = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dOr();
                    }
                    d.this.nkx = true;
                    d.this.nkp.countDown();
                }
            });
            return;
        }
        this.nkp = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dOx().h(bVar);
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
                    h.Uq(str2);
                    com.facebook.a.a C = this.nkv.C(str2, bVar);
                    if (C != null) {
                        str = str2;
                        aVar = C;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = C;
                }
                if (aVar == null) {
                    this.nke.b(h);
                    this.nkr.remove(str);
                } else {
                    this.nke.a(h);
                    this.nkr.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.njR.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, njM, "getResource", e);
            h.e(e);
            this.nke.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dOp();
        return this.nkv.B(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aO;
        synchronized (this.mLock) {
            aO = bVar.aO(bVar2);
            this.nkr.add(str);
            this.nkw.L(aO.size(), 1L);
        }
        return aO;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dOx().h(bVar);
        this.nke.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Uq(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.gj(a3.size()).gk(this.nkw.getSize());
                    this.nke.d(h);
                    return a3;
                } finally {
                    if (!a2.dOb()) {
                        com.facebook.common.c.a.h(njM, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.nke.f(h);
                com.facebook.common.c.a.b(njM, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.nkv.Um(str);
                    this.nkr.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.njR.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, njM, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dOp() throws IOException {
        synchronized (this.mLock) {
            boolean dOr = dOr();
            dOq();
            long size = this.nkw.getSize();
            if (size > this.nkq && !dOr) {
                this.nkw.reset();
                dOr();
            }
            if (size > this.nkq) {
                a((this.nkq * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.nkv.dNY());
            long size = this.nkw.getSize();
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
                long a2 = this.nkv.a(next);
                this.nkr.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i gl = i.dOx().Uq(next.getId()).a(evictionReason).gj(a2).gk(size - j2).gl(j);
                    this.nke.g(gl);
                    gl.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.nkw.L(-j2, -i);
            this.nkv.dNX();
        } catch (IOException e) {
            this.njR.a(CacheErrorLogger.CacheErrorCategory.EVICTION, njM, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = nkl + this.njS.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.nkd.dOc());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dOq() {
        if (this.nku.a(this.nkv.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.nko - this.nkw.getSize())) {
            this.nkq = this.nkn;
        } else {
            this.nkq = this.nko;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.nkr.contains(a2.get(i))) {
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
                    if (this.nkv.D(str, bVar)) {
                        this.nkr.add(str);
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
    public boolean dOr() {
        long now = this.njS.now();
        if (!this.nkw.isInitialized() || this.nks == -1 || now - this.nks > nkm) {
            return dOs();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dOs() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.njS.now();
        long j3 = now + nkl;
        if (this.nkg && this.nkr.isEmpty()) {
            set = this.nkr;
        } else if (this.nkg) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.nkv.dNY()) {
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
                    if (this.nkg) {
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
                this.njR.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, njM, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.nkw.getCount() != i5 || this.nkw.getSize() != j4) {
                if (this.nkg && this.nkr != set) {
                    this.nkr.clear();
                    this.nkr.addAll(set);
                }
                this.nkw.K(j4, i5);
            }
            this.nks = now;
            return true;
        } catch (IOException e) {
            this.njR.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, njM, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

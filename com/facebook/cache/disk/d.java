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
/* loaded from: classes7.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> paF = d.class;
    private static final long pbe = TimeUnit.HOURS.toMillis(2);
    private static final long pbf = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger paK;
    private final com.facebook.common.time.a paL;
    private final g paW;
    private final CacheEventListener paX;
    private final boolean paZ;
    private final long pbg;
    private final long pbh;
    private final CountDownLatch pbi;
    private long pbj;
    @GuardedBy("mLock")
    final Set<String> pbk;
    private final long pbm;
    private final c pbo;
    private boolean pbq;
    private final Object mLock = new Object();
    private final StatFsHelper pbn = StatFsHelper.eqi();
    private long pbl = -1;
    private final a pbp = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gEf = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gEf = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.gEf = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gEf += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gEf;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public final long pbg;
        public final long pbh;
        public final long pbm;

        public b(long j, long j2, long j3) {
            this.pbm = j;
            this.pbg = j2;
            this.pbh = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pbg = bVar.pbg;
        this.pbh = bVar.pbh;
        this.pbj = bVar.pbh;
        this.pbo = cVar;
        this.paW = gVar;
        this.paX = cacheEventListener;
        this.pbm = bVar.pbm;
        this.paK = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.paL = com.facebook.common.time.c.eqm();
        this.paZ = z;
        this.pbk = new HashSet();
        if (this.paZ) {
            this.pbi = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.epB();
                    }
                    d.this.pbq = true;
                    d.this.pbi.countDown();
                }
            });
            return;
        }
        this.pbi = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.epH().h(bVar);
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
                    h.Zd(str2);
                    com.facebook.a.a C = this.pbo.C(str2, bVar);
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
                    this.paX.b(h);
                    this.pbk.remove(str);
                } else {
                    this.paX.a(h);
                    this.pbk.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.paK.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, paF, "getResource", e);
            h.e(e);
            this.paX.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        epz();
        return this.pbo.B(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aY;
        synchronized (this.mLock) {
            aY = bVar.aY(bVar2);
            this.pbk.add(str);
            this.pbp.J(aY.size(), 1L);
        }
        return aY;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.epH().h(bVar);
        this.paX.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zd(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.ij(a3.size()).ik(this.pbp.getSize());
                    this.paX.d(h);
                    return a3;
                } finally {
                    if (!a2.epm()) {
                        com.facebook.common.c.a.h(paF, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.paX.f(h);
                com.facebook.common.c.a.b(paF, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.pbo.YZ(str);
                    this.pbk.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.paK.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, paF, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void epz() throws IOException {
        synchronized (this.mLock) {
            boolean epB = epB();
            epA();
            long size = this.pbp.getSize();
            if (size > this.pbj && !epB) {
                this.pbp.reset();
                epB();
            }
            if (size > this.pbj) {
                a((this.pbj * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.pbo.epj());
            long size = this.pbp.getSize();
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
                long a2 = this.pbo.a(next);
                this.pbk.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i il = i.epH().Zd(next.getId()).a(evictionReason).ij(a2).ik(size - j2).il(j);
                    this.paX.g(il);
                    il.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.pbp.J(-j2, -i);
            this.pbo.epi();
        } catch (IOException e) {
            this.paK.a(CacheErrorLogger.CacheErrorCategory.EVICTION, paF, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = pbe + this.paL.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.paW.epn());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void epA() {
        if (this.pbn.a(this.pbo.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pbh - this.pbp.getSize())) {
            this.pbj = this.pbg;
        } else {
            this.pbj = this.pbh;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.pbk.contains(a2.get(i))) {
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
                    if (this.pbo.D(str, bVar)) {
                        this.pbk.add(str);
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
    public boolean epB() {
        long now = this.paL.now();
        if (!this.pbp.isInitialized() || this.pbl == -1 || now - this.pbl > pbf) {
            return epC();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean epC() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.paL.now();
        long j3 = now + pbe;
        if (this.paZ && this.pbk.isEmpty()) {
            set = this.pbk;
        } else if (this.paZ) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.pbo.epj()) {
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
                    if (this.paZ) {
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
                this.paK.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, paF, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.pbp.getCount() != i5 || this.pbp.getSize() != j4) {
                if (this.paZ && this.pbk != set) {
                    this.pbk.clear();
                    this.pbk.addAll(set);
                }
                this.pbp.I(j4, i5);
            }
            this.pbl = now;
            return true;
        } catch (IOException e) {
            this.paK.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, paF, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

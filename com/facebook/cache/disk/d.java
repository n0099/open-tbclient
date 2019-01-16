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
    private static final Class<?> iiQ = d.class;
    private static final long ijs = TimeUnit.HOURS.toMillis(2);
    private static final long ijt = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger iiV;
    private final com.facebook.common.time.a iiW;
    private final c ijB;
    private boolean ijD;
    private final g ijk;
    private final CacheEventListener ijl;
    private final boolean ijn;
    private final long iju;
    private final long ijv;
    private long ijw;
    @GuardedBy("mLock")
    final Set<String> ijx;
    private final long ijz;
    private final CountDownLatch mCountDownLatch;
    private final Object mLock = new Object();
    private final StatFsHelper ijA = StatFsHelper.bUV();
    private long ijy = -1;
    private final a ijC = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean ijF = false;
        private long mSize = -1;
        private long ijG = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.ijF;
        }

        public synchronized void reset() {
            this.ijF = false;
            this.ijG = -1L;
            this.mSize = -1L;
        }

        public synchronized void o(long j, long j2) {
            this.ijG = j2;
            this.mSize = j;
            this.ijF = true;
        }

        public synchronized void p(long j, long j2) {
            if (this.ijF) {
                this.mSize += j;
                this.ijG += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.ijG;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long iju;
        public final long ijv;
        public final long ijz;

        public b(long j, long j2, long j3) {
            this.ijz = j;
            this.iju = j2;
            this.ijv = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.iju = bVar.iju;
        this.ijv = bVar.ijv;
        this.ijw = bVar.ijv;
        this.ijB = cVar;
        this.ijk = gVar;
        this.ijl = cacheEventListener;
        this.ijz = bVar.ijz;
        this.iiV = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.iiW = com.facebook.common.time.b.bVa();
        this.ijn = z;
        this.ijx = new HashSet();
        if (this.ijn) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bUn();
                    }
                    d.this.ijD = true;
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
        i g = i.bUt().g(bVar);
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
                    g.zu(str2);
                    com.facebook.a.a l = this.ijB.l(str2, bVar);
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
                    this.ijl.b(g);
                    this.ijx.remove(str);
                } else {
                    this.ijl.a(g);
                    this.ijx.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.iiV.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, iiQ, "getResource", e);
            g.a(e);
            this.ijl.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bUl();
        return this.ijB.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a am;
        synchronized (this.mLock) {
            am = bVar.am(bVar2);
            this.ijx.add(str);
            this.ijC.p(am.size(), 1L);
        }
        return am;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bUt().g(bVar);
        this.ijl.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.zu(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.dx(a3.size()).dy(this.ijC.getSize());
                    this.ijl.d(g);
                    return a3;
                } finally {
                    if (!a2.bTX()) {
                        com.facebook.common.c.a.g(iiQ, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.ijl.f(g);
                com.facebook.common.c.a.b(iiQ, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void bUl() throws IOException {
        synchronized (this.mLock) {
            boolean bUn = bUn();
            bUm();
            long size = this.ijC.getSize();
            if (size > this.ijw && !bUn) {
                this.ijC.reset();
                bUn();
            }
            if (size > this.ijw) {
                a((this.ijw * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.ijB.bTU());
            long size = this.ijC.getSize();
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
                long a2 = this.ijB.a(next);
                this.ijx.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i dz = i.bUt().zu(next.getId()).a(evictionReason).dx(a2).dy(size - j2).dz(j);
                    this.ijl.g(dz);
                    dz.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.ijC.p(-j2, -i);
            this.ijB.bTT();
        } catch (IOException e) {
            this.iiV.a(CacheErrorLogger.CacheErrorCategory.EVICTION, iiQ, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = ijs + this.iiW.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.ijk.bTY());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bUm() {
        if (this.ijA.a(this.ijB.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.ijv - this.ijC.getSize())) {
            this.ijw = this.iju;
        } else {
            this.ijw = this.ijv;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.ijx.contains(a2.get(i))) {
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
                    if (this.ijB.m(str, bVar)) {
                        this.ijx.add(str);
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
    public boolean bUn() {
        long now = this.iiW.now();
        if (!this.ijC.isInitialized() || this.ijy == -1 || now - this.ijy > ijt) {
            return bUo();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean bUo() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.iiW.now();
        long j3 = now + ijs;
        if (this.ijn && this.ijx.isEmpty()) {
            set = this.ijx;
        } else if (this.ijn) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.ijB.bTU()) {
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
                    if (this.ijn) {
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
                this.iiV.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, iiQ, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.ijC.getCount() != i5 || this.ijC.getSize() != j4) {
                if (this.ijn && this.ijx != set) {
                    this.ijx.clear();
                    this.ijx.addAll(set);
                }
                this.ijC.o(j4, i5);
            }
            this.ijy = now;
            return true;
        } catch (IOException e) {
            this.iiV.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, iiQ, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

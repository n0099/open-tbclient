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
    private static final Class<?> iiR = d.class;
    private static final long ijt = TimeUnit.HOURS.toMillis(2);
    private static final long iju = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger iiW;
    private final com.facebook.common.time.a iiX;
    private final long ijA;
    private final c ijC;
    private boolean ijE;
    private final g ijl;
    private final CacheEventListener ijm;
    private final boolean ijo;
    private final long ijv;
    private final long ijw;
    private long ijx;
    @GuardedBy("mLock")
    final Set<String> ijy;
    private final CountDownLatch mCountDownLatch;
    private final Object mLock = new Object();
    private final StatFsHelper ijB = StatFsHelper.bUV();
    private long ijz = -1;
    private final a ijD = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean ijG = false;
        private long mSize = -1;
        private long ijH = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.ijG;
        }

        public synchronized void reset() {
            this.ijG = false;
            this.ijH = -1L;
            this.mSize = -1L;
        }

        public synchronized void o(long j, long j2) {
            this.ijH = j2;
            this.mSize = j;
            this.ijG = true;
        }

        public synchronized void p(long j, long j2) {
            if (this.ijG) {
                this.mSize += j;
                this.ijH += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.ijH;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long ijA;
        public final long ijv;
        public final long ijw;

        public b(long j, long j2, long j3) {
            this.ijA = j;
            this.ijv = j2;
            this.ijw = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.ijv = bVar.ijv;
        this.ijw = bVar.ijw;
        this.ijx = bVar.ijw;
        this.ijC = cVar;
        this.ijl = gVar;
        this.ijm = cacheEventListener;
        this.ijA = bVar.ijA;
        this.iiW = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.iiX = com.facebook.common.time.b.bVa();
        this.ijo = z;
        this.ijy = new HashSet();
        if (this.ijo) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bUn();
                    }
                    d.this.ijE = true;
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
                    com.facebook.a.a l = this.ijC.l(str2, bVar);
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
                    this.ijm.b(g);
                    this.ijy.remove(str);
                } else {
                    this.ijm.a(g);
                    this.ijy.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.iiW.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, iiR, "getResource", e);
            g.a(e);
            this.ijm.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bUl();
        return this.ijC.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a am;
        synchronized (this.mLock) {
            am = bVar.am(bVar2);
            this.ijy.add(str);
            this.ijD.p(am.size(), 1L);
        }
        return am;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bUt().g(bVar);
        this.ijm.c(g);
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
                    g.dx(a3.size()).dy(this.ijD.getSize());
                    this.ijm.d(g);
                    return a3;
                } finally {
                    if (!a2.bTX()) {
                        com.facebook.common.c.a.g(iiR, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.ijm.f(g);
                com.facebook.common.c.a.b(iiR, "Failed inserting a file into the cache", (Throwable) e);
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
            long size = this.ijD.getSize();
            if (size > this.ijx && !bUn) {
                this.ijD.reset();
                bUn();
            }
            if (size > this.ijx) {
                a((this.ijx * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.ijC.bTU());
            long size = this.ijD.getSize();
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
                long a2 = this.ijC.a(next);
                this.ijy.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i dz = i.bUt().zu(next.getId()).a(evictionReason).dx(a2).dy(size - j2).dz(j);
                    this.ijm.g(dz);
                    dz.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.ijD.p(-j2, -i);
            this.ijC.bTT();
        } catch (IOException e) {
            this.iiW.a(CacheErrorLogger.CacheErrorCategory.EVICTION, iiR, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = ijt + this.iiX.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.ijl.bTY());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bUm() {
        if (this.ijB.a(this.ijC.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.ijw - this.ijD.getSize())) {
            this.ijx = this.ijv;
        } else {
            this.ijx = this.ijw;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.ijy.contains(a2.get(i))) {
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
                    if (this.ijC.m(str, bVar)) {
                        this.ijy.add(str);
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
        long now = this.iiX.now();
        if (!this.ijD.isInitialized() || this.ijz == -1 || now - this.ijz > iju) {
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
        long now = this.iiX.now();
        long j3 = now + ijt;
        if (this.ijo && this.ijy.isEmpty()) {
            set = this.ijy;
        } else if (this.ijo) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.ijC.bTU()) {
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
                    if (this.ijo) {
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
                this.iiW.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, iiR, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.ijD.getCount() != i5 || this.ijD.getSize() != j4) {
                if (this.ijo && this.ijy != set) {
                    this.ijy.clear();
                    this.ijy.addAll(set);
                }
                this.ijD.o(j4, i5);
            }
            this.ijz = now;
            return true;
        } catch (IOException e) {
            this.iiW.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, iiR, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

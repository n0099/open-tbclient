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
    private static final Class<?> ihJ = d.class;
    private static final long iil = TimeUnit.HOURS.toMillis(2);
    private static final long iim = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger ihO;
    private final com.facebook.common.time.a ihP;
    private final g iid;
    private final CacheEventListener iie;
    private final boolean iig;
    private final long iin;
    private final long iio;
    private long iip;
    @GuardedBy("mLock")
    final Set<String> iiq;
    private final long iis;
    private final c iiu;
    private boolean iiw;
    private final CountDownLatch mCountDownLatch;
    private final Object mLock = new Object();
    private final StatFsHelper iit = StatFsHelper.bUn();
    private long iir = -1;
    private final a iiv = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        private boolean iiy = false;
        private long mSize = -1;
        private long iiz = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.iiy;
        }

        public synchronized void reset() {
            this.iiy = false;
            this.iiz = -1L;
            this.mSize = -1L;
        }

        public synchronized void o(long j, long j2) {
            this.iiz = j2;
            this.mSize = j;
            this.iiy = true;
        }

        public synchronized void p(long j, long j2) {
            if (this.iiy) {
                this.mSize += j;
                this.iiz += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.iiz;
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final long iin;
        public final long iio;
        public final long iis;

        public b(long j, long j2, long j3) {
            this.iis = j;
            this.iin = j2;
            this.iio = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.iin = bVar.iin;
        this.iio = bVar.iio;
        this.iip = bVar.iio;
        this.iiu = cVar;
        this.iid = gVar;
        this.iie = cacheEventListener;
        this.iis = bVar.iis;
        this.ihO = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.ihP = com.facebook.common.time.b.bUs();
        this.iig = z;
        this.iiq = new HashSet();
        if (this.iig) {
            this.mCountDownLatch = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.bTF();
                    }
                    d.this.iiw = true;
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
        i g = i.bTL().g(bVar);
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
                    g.ze(str2);
                    com.facebook.a.a l = this.iiu.l(str2, bVar);
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
                    this.iie.b(g);
                    this.iiq.remove(str);
                } else {
                    this.iie.a(g);
                    this.iiq.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.ihO.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, ihJ, "getResource", e);
            g.a(e);
            this.iie.e(g);
            return null;
        } finally {
            g.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        bTD();
        return this.iiu.k(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a am;
        synchronized (this.mLock) {
            am = bVar.am(bVar2);
            this.iiq.add(str);
            this.iiv.p(am.size(), 1L);
        }
        return am;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i g = i.bTL().g(bVar);
        this.iie.c(g);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        g.ze(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    g.dx(a3.size()).dy(this.iiv.getSize());
                    this.iie.d(g);
                    return a3;
                } finally {
                    if (!a2.bTp()) {
                        com.facebook.common.c.a.g(ihJ, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                g.a(e);
                this.iie.f(g);
                com.facebook.common.c.a.b(ihJ, "Failed inserting a file into the cache", (Throwable) e);
                throw e;
            }
        } finally {
            g.recycle();
        }
    }

    private void bTD() throws IOException {
        synchronized (this.mLock) {
            boolean bTF = bTF();
            bTE();
            long size = this.iiv.getSize();
            if (size > this.iip && !bTF) {
                this.iiv.reset();
                bTF();
            }
            if (size > this.iip) {
                a((this.iip * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> g = g(this.iiu.bTm());
            long size = this.iiv.getSize();
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
                long a2 = this.iiu.a(next);
                this.iiq.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i dz = i.bTL().ze(next.getId()).a(evictionReason).dx(a2).dy(size - j2).dz(j);
                    this.iie.g(dz);
                    dz.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.iiv.p(-j2, -i);
            this.iiu.bTl();
        } catch (IOException e) {
            this.ihO.a(CacheErrorLogger.CacheErrorCategory.EVICTION, ihJ, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> g(Collection<c.a> collection) {
        long now = iil + this.ihP.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.iid.bTq());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void bTE() {
        if (this.iit.a(this.iiu.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.iio - this.iiv.getSize())) {
            this.iip = this.iin;
        } else {
            this.iip = this.iio;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean e(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.iiq.contains(a2.get(i))) {
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
                    if (this.iiu.m(str, bVar)) {
                        this.iiq.add(str);
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
    public boolean bTF() {
        long now = this.ihP.now();
        if (!this.iiv.isInitialized() || this.iir == -1 || now - this.iir > iim) {
            return bTG();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean bTG() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.ihP.now();
        long j3 = now + iil;
        if (this.iig && this.iiq.isEmpty()) {
            set = this.iiq;
        } else if (this.iig) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.iiu.bTm()) {
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
                    if (this.iig) {
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
                this.ihO.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, ihJ, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.iiv.getCount() != i5 || this.iiv.getSize() != j4) {
                if (this.iig && this.iiq != set) {
                    this.iiq.clear();
                    this.iiq.addAll(set);
                }
                this.iiv.o(j4, i5);
            }
            this.iir = now;
            return true;
        } catch (IOException e) {
            this.ihO.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, ihJ, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

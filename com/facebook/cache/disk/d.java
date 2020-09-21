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
/* loaded from: classes12.dex */
public class d implements h, com.facebook.common.a.a {
    private static final Class<?> ntL = d.class;
    private static final long nuk = TimeUnit.HOURS.toMillis(2);
    private static final long nul = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger ntQ;
    private final com.facebook.common.time.a ntR;
    private final g nuc;
    private final CacheEventListener nud;
    private final boolean nuf;
    private final long nun;
    private final long nuo;
    private final CountDownLatch nup;
    private long nuq;
    @GuardedBy("mLock")
    final Set<String> nur;
    private final long nut;
    private final c nuv;
    private boolean nux;
    private final Object mLock = new Object();
    private final StatFsHelper nuu = StatFsHelper.dSW();
    private long nus = -1;
    private final a nuw = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long fTD = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.fTD = -1L;
            this.mSize = -1L;
        }

        public synchronized void H(long j, long j2) {
            this.fTD = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void I(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.fTD += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.fTD;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public final long nun;
        public final long nuo;
        public final long nut;

        public b(long j, long j2, long j3) {
            this.nut = j;
            this.nun = j2;
            this.nuo = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.nun = bVar.nun;
        this.nuo = bVar.nuo;
        this.nuq = bVar.nuo;
        this.nuv = cVar;
        this.nuc = gVar;
        this.nud = cacheEventListener;
        this.nut = bVar.nut;
        this.ntQ = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.ntR = com.facebook.common.time.c.dTa();
        this.nuf = z;
        this.nur = new HashSet();
        if (this.nuf) {
            this.nup = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dSp();
                    }
                    d.this.nux = true;
                    d.this.nup.countDown();
                }
            });
            return;
        }
        this.nup = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dSv().h(bVar);
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
                    h.US(str2);
                    com.facebook.a.a C = this.nuv.C(str2, bVar);
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
                    this.nud.b(h);
                    this.nur.remove(str);
                } else {
                    this.nud.a(h);
                    this.nur.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.ntQ.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, ntL, "getResource", e);
            h.e(e);
            this.nud.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dSn();
        return this.nuv.B(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aQ;
        synchronized (this.mLock) {
            aQ = bVar.aQ(bVar2);
            this.nur.add(str);
            this.nuw.I(aQ.size(), 1L);
        }
        return aQ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dSv().h(bVar);
        this.nud.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.US(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.gx(a3.size()).gy(this.nuw.getSize());
                    this.nud.d(h);
                    return a3;
                } finally {
                    if (!a2.dRZ()) {
                        com.facebook.common.c.a.h(ntL, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.nud.f(h);
                com.facebook.common.c.a.b(ntL, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.nuv.UO(str);
                    this.nur.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.ntQ.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, ntL, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dSn() throws IOException {
        synchronized (this.mLock) {
            boolean dSp = dSp();
            dSo();
            long size = this.nuw.getSize();
            if (size > this.nuq && !dSp) {
                this.nuw.reset();
                dSp();
            }
            if (size > this.nuq) {
                a((this.nuq * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.nuv.dRW());
            long size = this.nuw.getSize();
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
                long a2 = this.nuv.a(next);
                this.nur.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i gz = i.dSv().US(next.getId()).a(evictionReason).gx(a2).gy(size - j2).gz(j);
                    this.nud.g(gz);
                    gz.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.nuw.I(-j2, -i);
            this.nuv.dRV();
        } catch (IOException e) {
            this.ntQ.a(CacheErrorLogger.CacheErrorCategory.EVICTION, ntL, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = nuk + this.ntR.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.nuc.dSa());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dSo() {
        if (this.nuu.a(this.nuv.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.nuo - this.nuw.getSize())) {
            this.nuq = this.nun;
        } else {
            this.nuq = this.nuo;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.nur.contains(a2.get(i))) {
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
                    if (this.nuv.D(str, bVar)) {
                        this.nur.add(str);
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
    public boolean dSp() {
        long now = this.ntR.now();
        if (!this.nuw.isInitialized() || this.nus == -1 || now - this.nus > nul) {
            return dSq();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dSq() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.ntR.now();
        long j3 = now + nuk;
        if (this.nuf && this.nur.isEmpty()) {
            set = this.nur;
        } else if (this.nuf) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.nuv.dRW()) {
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
                    if (this.nuf) {
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
                this.ntQ.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, ntL, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.nuw.getCount() != i5 || this.nuw.getSize() != j4) {
                if (this.nuf && this.nur != set) {
                    this.nur.clear();
                    this.nur.addAll(set);
                }
                this.nuw.H(j4, i5);
            }
            this.nus = now;
            return true;
        } catch (IOException e) {
            this.ntQ.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, ntL, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

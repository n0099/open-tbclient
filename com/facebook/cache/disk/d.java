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
/* loaded from: classes13.dex */
public class d implements h, com.facebook.common.a.a {
    private final g mHI;
    private final CacheEventListener mHJ;
    private final boolean mHL;
    private final long mHS;
    private final long mHT;
    private final CountDownLatch mHU;
    private long mHV;
    @GuardedBy("mLock")
    final Set<String> mHW;
    private final long mHY;
    private final CacheErrorLogger mHw;
    private final com.facebook.common.time.a mHx;
    private final c mIa;
    private boolean mIc;
    private static final Class<?> mHr = d.class;
    private static final long mHQ = TimeUnit.HOURS.toMillis(2);
    private static final long mHR = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper mHZ = StatFsHelper.dzC();
    private long mHX = -1;
    private final a mIb = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long fzR = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.fzR = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.fzR = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.fzR += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.fzR;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long mHS;
        public final long mHT;
        public final long mHY;

        public b(long j, long j2, long j3) {
            this.mHY = j;
            this.mHS = j2;
            this.mHT = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.mHS = bVar.mHS;
        this.mHT = bVar.mHT;
        this.mHV = bVar.mHT;
        this.mIa = cVar;
        this.mHI = gVar;
        this.mHJ = cacheEventListener;
        this.mHY = bVar.mHY;
        this.mHw = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.mHx = com.facebook.common.time.c.dzG();
        this.mHL = z;
        this.mHW = new HashSet();
        if (this.mHL) {
            this.mHU = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dyV();
                    }
                    d.this.mIc = true;
                    d.this.mHU.countDown();
                }
            });
            return;
        }
        this.mHU = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dzb().h(bVar);
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
                    h.QB(str2);
                    com.facebook.a.a D = this.mIa.D(str2, bVar);
                    if (D != null) {
                        str = str2;
                        aVar = D;
                        break;
                    }
                    i++;
                    str = str2;
                    aVar = D;
                }
                if (aVar == null) {
                    this.mHJ.b(h);
                    this.mHW.remove(str);
                } else {
                    this.mHJ.a(h);
                    this.mHW.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.mHw.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mHr, "getResource", e);
            h.e(e);
            this.mHJ.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dyT();
        return this.mIa.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aM;
        synchronized (this.mLock) {
            aM = bVar.aM(bVar2);
            this.mHW.add(str);
            this.mIb.J(aM.size(), 1L);
        }
        return aM;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dzb().h(bVar);
        this.mHJ.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.QB(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fH(a3.size()).fI(this.mIb.getSize());
                    this.mHJ.d(h);
                    return a3;
                } finally {
                    if (!a2.dyF()) {
                        com.facebook.common.c.a.h(mHr, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.mHJ.f(h);
                com.facebook.common.c.a.b(mHr, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.mIa.Qx(str);
                    this.mHW.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.mHw.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, mHr, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dyT() throws IOException {
        synchronized (this.mLock) {
            boolean dyV = dyV();
            dyU();
            long size = this.mIb.getSize();
            if (size > this.mHV && !dyV) {
                this.mIb.reset();
                dyV();
            }
            if (size > this.mHV) {
                a((this.mHV * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> j3 = j(this.mIa.dyC());
            long size = this.mIb.getSize();
            long j4 = size - j;
            int i2 = 0;
            long j5 = 0;
            Iterator<c.a> it = j3.iterator();
            while (true) {
                i = i2;
                j2 = j5;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j4) {
                    break;
                }
                long a2 = this.mIa.a(next);
                this.mHW.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fJ = i.dzb().QB(next.getId()).a(evictionReason).fH(a2).fI(size - j2).fJ(j);
                    this.mHJ.g(fJ);
                    fJ.recycle();
                }
                long j6 = j2;
                i2 = i;
                j5 = j6;
            }
            this.mIb.J(-j2, -i);
            this.mIa.dyB();
        } catch (IOException e) {
            this.mHw.a(CacheErrorLogger.CacheErrorCategory.EVICTION, mHr, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> j(Collection<c.a> collection) {
        long now = mHQ + this.mHx.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.mHI.dyG());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dyU() {
        if (this.mHZ.a(this.mIa.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mHT - this.mIb.getSize())) {
            this.mHV = this.mHS;
        } else {
            this.mHV = this.mHT;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.mHW.contains(a2.get(i))) {
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
                    if (this.mIa.E(str, bVar)) {
                        this.mHW.add(str);
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
    public boolean dyV() {
        long now = this.mHx.now();
        if (!this.mIb.isInitialized() || this.mHX == -1 || now - this.mHX > mHR) {
            return dyW();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dyW() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.mHx.now();
        long j3 = now + mHQ;
        if (this.mHL && this.mHW.isEmpty()) {
            set = this.mHW;
        } else if (this.mHL) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.mIa.dyC()) {
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
                    if (this.mHL) {
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
                this.mHw.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, mHr, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.mIb.getCount() != i5 || this.mIb.getSize() != j4) {
                if (this.mHL && this.mHW != set) {
                    this.mHW.clear();
                    this.mHW.addAll(set);
                }
                this.mIb.I(j4, i5);
            }
            this.mHX = now;
            return true;
        } catch (IOException e) {
            this.mHw.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mHr, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

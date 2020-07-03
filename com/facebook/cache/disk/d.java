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
    private final g mHF;
    private final CacheEventListener mHG;
    private final boolean mHI;
    private final long mHP;
    private final long mHQ;
    private final CountDownLatch mHR;
    private long mHS;
    @GuardedBy("mLock")
    final Set<String> mHT;
    private final long mHV;
    private final c mHX;
    private boolean mHZ;
    private final CacheErrorLogger mHt;
    private final com.facebook.common.time.a mHu;
    private static final Class<?> mHo = d.class;
    private static final long mHN = TimeUnit.HOURS.toMillis(2);
    private static final long mHO = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper mHW = StatFsHelper.dzy();
    private long mHU = -1;
    private final a mHY = new a();

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
        public final long mHP;
        public final long mHQ;
        public final long mHV;

        public b(long j, long j2, long j3) {
            this.mHV = j;
            this.mHP = j2;
            this.mHQ = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.mHP = bVar.mHP;
        this.mHQ = bVar.mHQ;
        this.mHS = bVar.mHQ;
        this.mHX = cVar;
        this.mHF = gVar;
        this.mHG = cacheEventListener;
        this.mHV = bVar.mHV;
        this.mHt = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.mHu = com.facebook.common.time.c.dzC();
        this.mHI = z;
        this.mHT = new HashSet();
        if (this.mHI) {
            this.mHR = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dyR();
                    }
                    d.this.mHZ = true;
                    d.this.mHR.countDown();
                }
            });
            return;
        }
        this.mHR = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dyX().h(bVar);
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
                    h.QA(str2);
                    com.facebook.a.a D = this.mHX.D(str2, bVar);
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
                    this.mHG.b(h);
                    this.mHT.remove(str);
                } else {
                    this.mHG.a(h);
                    this.mHT.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.mHt.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mHo, "getResource", e);
            h.e(e);
            this.mHG.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dyP();
        return this.mHX.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aM;
        synchronized (this.mLock) {
            aM = bVar.aM(bVar2);
            this.mHT.add(str);
            this.mHY.J(aM.size(), 1L);
        }
        return aM;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dyX().h(bVar);
        this.mHG.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.QA(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fH(a3.size()).fI(this.mHY.getSize());
                    this.mHG.d(h);
                    return a3;
                } finally {
                    if (!a2.dyB()) {
                        com.facebook.common.c.a.h(mHo, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.mHG.f(h);
                com.facebook.common.c.a.b(mHo, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.mHX.Qw(str);
                    this.mHT.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.mHt.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, mHo, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dyP() throws IOException {
        synchronized (this.mLock) {
            boolean dyR = dyR();
            dyQ();
            long size = this.mHY.getSize();
            if (size > this.mHS && !dyR) {
                this.mHY.reset();
                dyR();
            }
            if (size > this.mHS) {
                a((this.mHS * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> j3 = j(this.mHX.dyy());
            long size = this.mHY.getSize();
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
                long a2 = this.mHX.a(next);
                this.mHT.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fJ = i.dyX().QA(next.getId()).a(evictionReason).fH(a2).fI(size - j2).fJ(j);
                    this.mHG.g(fJ);
                    fJ.recycle();
                }
                long j6 = j2;
                i2 = i;
                j5 = j6;
            }
            this.mHY.J(-j2, -i);
            this.mHX.dyx();
        } catch (IOException e) {
            this.mHt.a(CacheErrorLogger.CacheErrorCategory.EVICTION, mHo, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> j(Collection<c.a> collection) {
        long now = mHN + this.mHu.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.mHF.dyC());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dyQ() {
        if (this.mHW.a(this.mHX.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mHQ - this.mHY.getSize())) {
            this.mHS = this.mHP;
        } else {
            this.mHS = this.mHQ;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.mHT.contains(a2.get(i))) {
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
                    if (this.mHX.E(str, bVar)) {
                        this.mHT.add(str);
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
    public boolean dyR() {
        long now = this.mHu.now();
        if (!this.mHY.isInitialized() || this.mHU == -1 || now - this.mHU > mHO) {
            return dyS();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dyS() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.mHu.now();
        long j3 = now + mHN;
        if (this.mHI && this.mHT.isEmpty()) {
            set = this.mHT;
        } else if (this.mHI) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.mHX.dyy()) {
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
                    if (this.mHI) {
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
                this.mHt.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, mHo, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.mHY.getCount() != i5 || this.mHY.getSize() != j4) {
                if (this.mHI && this.mHT != set) {
                    this.mHT.clear();
                    this.mHT.addAll(set);
                }
                this.mHY.I(j4, i5);
            }
            this.mHU = now;
            return true;
        } catch (IOException e) {
            this.mHt.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mHo, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

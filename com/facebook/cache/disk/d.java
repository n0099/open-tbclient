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
    private final CacheEventListener mkA;
    private final boolean mkC;
    private final long mkJ;
    private final long mkK;
    private final CountDownLatch mkL;
    private long mkM;
    @GuardedBy("mLock")
    final Set<String> mkN;
    private final long mkP;
    private final c mkR;
    private boolean mkT;
    private final CacheErrorLogger mkn;
    private final com.facebook.common.time.a mko;
    private final g mkz;
    private static final Class<?> mki = d.class;
    private static final long mkH = TimeUnit.HOURS.toMillis(2);
    private static final long mkI = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper mkQ = StatFsHelper.duH();
    private long mkO = -1;
    private final a mkS = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long fot = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.fot = -1L;
            this.mSize = -1L;
        }

        public synchronized void H(long j, long j2) {
            this.fot = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void I(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.fot += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.fot;
        }
    }

    /* loaded from: classes13.dex */
    public static class b {
        public final long mkJ;
        public final long mkK;
        public final long mkP;

        public b(long j, long j2, long j3) {
            this.mkP = j;
            this.mkJ = j2;
            this.mkK = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.mkJ = bVar.mkJ;
        this.mkK = bVar.mkK;
        this.mkM = bVar.mkK;
        this.mkR = cVar;
        this.mkz = gVar;
        this.mkA = cacheEventListener;
        this.mkP = bVar.mkP;
        this.mkn = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.mko = com.facebook.common.time.c.duL();
        this.mkC = z;
        this.mkN = new HashSet();
        if (this.mkC) {
            this.mkL = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dua();
                    }
                    d.this.mkT = true;
                    d.this.mkL.countDown();
                }
            });
            return;
        }
        this.mkL = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dug().h(bVar);
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
                    h.PN(str2);
                    com.facebook.a.a D = this.mkR.D(str2, bVar);
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
                    this.mkA.b(h);
                    this.mkN.remove(str);
                } else {
                    this.mkA.a(h);
                    this.mkN.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.mkn.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mki, "getResource", e);
            h.e(e);
            this.mkA.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dtY();
        return this.mkR.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aL;
        synchronized (this.mLock) {
            aL = bVar.aL(bVar2);
            this.mkN.add(str);
            this.mkS.I(aL.size(), 1L);
        }
        return aL;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dug().h(bVar);
        this.mkA.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.PN(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.fC(a3.size()).fD(this.mkS.getSize());
                    this.mkA.d(h);
                    return a3;
                } finally {
                    if (!a2.dtK()) {
                        com.facebook.common.c.a.h(mki, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.mkA.f(h);
                com.facebook.common.c.a.b(mki, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.mkR.PJ(str);
                    this.mkN.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.mkn.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, mki, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dtY() throws IOException {
        synchronized (this.mLock) {
            boolean dua = dua();
            dtZ();
            long size = this.mkS.getSize();
            if (size > this.mkM && !dua) {
                this.mkS.reset();
                dua();
            }
            if (size > this.mkM) {
                a((this.mkM * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> j3 = j(this.mkR.dtH());
            long size = this.mkS.getSize();
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
                long a2 = this.mkR.a(next);
                this.mkN.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i fE = i.dug().PN(next.getId()).a(evictionReason).fC(a2).fD(size - j2).fE(j);
                    this.mkA.g(fE);
                    fE.recycle();
                }
                long j6 = j2;
                i2 = i;
                j5 = j6;
            }
            this.mkS.I(-j2, -i);
            this.mkR.dtG();
        } catch (IOException e) {
            this.mkn.a(CacheErrorLogger.CacheErrorCategory.EVICTION, mki, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> j(Collection<c.a> collection) {
        long now = mkH + this.mko.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.mkz.dtL());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dtZ() {
        if (this.mkQ.a(this.mkR.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.mkK - this.mkS.getSize())) {
            this.mkM = this.mkJ;
        } else {
            this.mkM = this.mkK;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.mkN.contains(a2.get(i))) {
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
                    if (this.mkR.E(str, bVar)) {
                        this.mkN.add(str);
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
    public boolean dua() {
        long now = this.mko.now();
        if (!this.mkS.isInitialized() || this.mkO == -1 || now - this.mkO > mkI) {
            return dub();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dub() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.mko.now();
        long j3 = now + mkH;
        if (this.mkC && this.mkN.isEmpty()) {
            set = this.mkN;
        } else if (this.mkC) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.mkR.dtH()) {
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
                    if (this.mkC) {
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
                this.mkn.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, mki, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.mkS.getCount() != i5 || this.mkS.getSize() != j4) {
                if (this.mkC && this.mkN != set) {
                    this.mkN.clear();
                    this.mkN.addAll(set);
                }
                this.mkS.H(j4, i5);
            }
            this.mkO = now;
            return true;
        } catch (IOException e) {
            this.mkn.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, mki, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

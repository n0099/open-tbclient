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
    private final com.facebook.common.time.a njA;
    private final g njL;
    private final CacheEventListener njM;
    private final boolean njO;
    private final long njV;
    private final long njW;
    private final CountDownLatch njX;
    private long njY;
    @GuardedBy("mLock")
    final Set<String> njZ;
    private final CacheErrorLogger njz;
    private final long nkb;
    private final c nkd;
    private boolean nkf;
    private static final Class<?> nju = d.class;
    private static final long njT = TimeUnit.HOURS.toMillis(2);
    private static final long njU = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper nkc = StatFsHelper.dOP();
    private long nka = -1;
    private final a nke = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long fQp = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.fQp = -1L;
            this.mSize = -1L;
        }

        public synchronized void K(long j, long j2) {
            this.fQp = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void L(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.fQp += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.fQp;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public final long njV;
        public final long njW;
        public final long nkb;

        public b(long j, long j2, long j3) {
            this.nkb = j;
            this.njV = j2;
            this.njW = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.njV = bVar.njV;
        this.njW = bVar.njW;
        this.njY = bVar.njW;
        this.nkd = cVar;
        this.njL = gVar;
        this.njM = cacheEventListener;
        this.nkb = bVar.nkb;
        this.njz = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.njA = com.facebook.common.time.c.dOT();
        this.njO = z;
        this.njZ = new HashSet();
        if (this.njO) {
            this.njX = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.dOi();
                    }
                    d.this.nkf = true;
                    d.this.njX.countDown();
                }
            });
            return;
        }
        this.njX = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.dOo().h(bVar);
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
                    com.facebook.a.a C = this.nkd.C(str2, bVar);
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
                    this.njM.b(h);
                    this.njZ.remove(str);
                } else {
                    this.njM.a(h);
                    this.njZ.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.njz.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, nju, "getResource", e);
            h.e(e);
            this.njM.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        dOg();
        return this.nkd.B(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aO;
        synchronized (this.mLock) {
            aO = bVar.aO(bVar2);
            this.njZ.add(str);
            this.nke.L(aO.size(), 1L);
        }
        return aO;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.dOo().h(bVar);
        this.njM.c(h);
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
                    h.gh(a3.size()).gi(this.nke.getSize());
                    this.njM.d(h);
                    return a3;
                } finally {
                    if (!a2.dNS()) {
                        com.facebook.common.c.a.h(nju, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.njM.f(h);
                com.facebook.common.c.a.b(nju, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.nkd.Um(str);
                    this.njZ.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.njz.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, nju, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void dOg() throws IOException {
        synchronized (this.mLock) {
            boolean dOi = dOi();
            dOh();
            long size = this.nke.getSize();
            if (size > this.njY && !dOi) {
                this.nke.reset();
                dOi();
            }
            if (size > this.njY) {
                a((this.njY * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.nkd.dNP());
            long size = this.nke.getSize();
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
                long a2 = this.nkd.a(next);
                this.njZ.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i gj = i.dOo().Uq(next.getId()).a(evictionReason).gh(a2).gi(size - j2).gj(j);
                    this.njM.g(gj);
                    gj.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.nke.L(-j2, -i);
            this.nkd.dNO();
        } catch (IOException e) {
            this.njz.a(CacheErrorLogger.CacheErrorCategory.EVICTION, nju, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = njT + this.njA.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.njL.dNT());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void dOh() {
        if (this.nkc.a(this.nkd.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.njW - this.nke.getSize())) {
            this.njY = this.njV;
        } else {
            this.njY = this.njW;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.njZ.contains(a2.get(i))) {
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
                    if (this.nkd.D(str, bVar)) {
                        this.njZ.add(str);
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
    public boolean dOi() {
        long now = this.njA.now();
        if (!this.nke.isInitialized() || this.nka == -1 || now - this.nka > njU) {
            return dOj();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean dOj() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.njA.now();
        long j3 = now + njT;
        if (this.njO && this.njZ.isEmpty()) {
            set = this.njZ;
        } else if (this.njO) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.nkd.dNP()) {
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
                    if (this.njO) {
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
                this.njz.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, nju, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.nke.getCount() != i5 || this.nke.getSize() != j4) {
                if (this.njO && this.njZ != set) {
                    this.njZ.clear();
                    this.njZ.addAll(set);
                }
                this.nke.K(j4, i5);
            }
            this.nka = now;
            return true;
        } catch (IOException e) {
            this.njz.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, nju, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

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
    private final CacheErrorLogger oAD;
    private final com.facebook.common.time.a oAE;
    private final g oAP;
    private final CacheEventListener oAQ;
    private final boolean oAS;
    private final long oAZ;
    private final long oBa;
    private final CountDownLatch oBb;
    private long oBc;
    @GuardedBy("mLock")
    final Set<String> oBd;
    private final long oBf;
    private final c oBh;
    private boolean oBj;
    private static final Class<?> oAy = d.class;
    private static final long oAX = TimeUnit.HOURS.toMillis(2);
    private static final long oAY = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper oBg = StatFsHelper.egF();
    private long oBe = -1;
    private final a oBi = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gpZ = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gpZ = -1L;
            this.mSize = -1L;
        }

        public synchronized void I(long j, long j2) {
            this.gpZ = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void J(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gpZ += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gpZ;
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public final long oAZ;
        public final long oBa;
        public final long oBf;

        public b(long j, long j2, long j3) {
            this.oBf = j;
            this.oAZ = j2;
            this.oBa = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.oAZ = bVar.oAZ;
        this.oBa = bVar.oBa;
        this.oBc = bVar.oBa;
        this.oBh = cVar;
        this.oAP = gVar;
        this.oAQ = cacheEventListener;
        this.oBf = bVar.oBf;
        this.oAD = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.oAE = com.facebook.common.time.c.egJ();
        this.oAS = z;
        this.oBd = new HashSet();
        if (this.oAS) {
            this.oBb = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.efY();
                    }
                    d.this.oBj = true;
                    d.this.oBb.countDown();
                }
            });
            return;
        }
        this.oBb = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.ege().h(bVar);
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
                    h.Xt(str2);
                    com.facebook.a.a D = this.oBh.D(str2, bVar);
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
                    this.oAQ.b(h);
                    this.oBd.remove(str);
                } else {
                    this.oAQ.a(h);
                    this.oBd.add(str);
                }
            }
            return aVar;
        } catch (IOException e) {
            this.oAD.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, oAy, "getResource", e);
            h.e(e);
            this.oAQ.e(h);
            return null;
        } finally {
            h.recycle();
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        efW();
        return this.oBh.C(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aX;
        synchronized (this.mLock) {
            aX = bVar.aX(bVar2);
            this.oBd.add(str);
            this.oBi.J(aX.size(), 1L);
        }
        return aX;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.ege().h(bVar);
        this.oAQ.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Xt(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.hf(a3.size()).hg(this.oBi.getSize());
                    this.oAQ.d(h);
                    return a3;
                } finally {
                    if (!a2.efI()) {
                        com.facebook.common.c.a.h(oAy, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.e(e);
                this.oAQ.f(h);
                com.facebook.common.c.a.b(oAy, "Failed inserting a file into the cache", (Throwable) e);
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
                    this.oBh.Xp(str);
                    this.oBd.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.oAD.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, oAy, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void efW() throws IOException {
        synchronized (this.mLock) {
            boolean efY = efY();
            efX();
            long size = this.oBi.getSize();
            if (size > this.oBc && !efY) {
                this.oBi.reset();
                efY();
            }
            if (size > this.oBc) {
                a((this.oBc * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        int i;
        long j2;
        try {
            Collection<c.a> l = l(this.oBh.efF());
            long size = this.oBi.getSize();
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
                long a2 = this.oBh.a(next);
                this.oBd.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i hh = i.ege().Xt(next.getId()).a(evictionReason).hf(a2).hg(size - j2).hh(j);
                    this.oAQ.g(hh);
                    hh.recycle();
                }
                long j5 = j2;
                i2 = i;
                j4 = j5;
            }
            this.oBi.J(-j2, -i);
            this.oBh.efE();
        } catch (IOException e) {
            this.oAD.a(CacheErrorLogger.CacheErrorCategory.EVICTION, oAy, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = oAX + this.oAE.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.oAP.efJ());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void efX() {
        if (this.oBg.a(this.oBh.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.oBa - this.oBi.getSize())) {
            this.oBc = this.oAZ;
        } else {
            this.oBc = this.oBa;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.oBd.contains(a2.get(i))) {
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
                    if (this.oBh.E(str, bVar)) {
                        this.oBd.add(str);
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
    public boolean efY() {
        long now = this.oAE.now();
        if (!this.oBi.isInitialized() || this.oBe == -1 || now - this.oBe > oAY) {
            return efZ();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean efZ() {
        Set<String> set;
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        long j2 = -1;
        long now = this.oAE.now();
        long j3 = now + oAX;
        if (this.oAS && this.oBd.isEmpty()) {
            set = this.oBd;
        } else if (this.oAS) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            long j4 = 0;
            int i5 = 0;
            for (c.a aVar : this.oBh.efF()) {
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
                    if (this.oAS) {
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
                this.oAD.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, oAy, "Future timestamp found in " + i3 + " files , with a total size of " + i4 + " bytes, and a maximum time delta of " + j2 + "ms", null);
            }
            if (this.oBi.getCount() != i5 || this.oBi.getSize() != j4) {
                if (this.oAS && this.oBd != set) {
                    this.oBd.clear();
                    this.oBd.addAll(set);
                }
                this.oBi.I(j4, i5);
            }
            this.oBe = now;
            return true;
        } catch (IOException e) {
            this.oAD.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, oAy, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

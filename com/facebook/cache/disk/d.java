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
/* loaded from: classes5.dex */
public class d implements h, com.facebook.common.a.a {
    private final long pyD;
    private final long pyE;
    private final CountDownLatch pyF;
    private long pyG;
    @GuardedBy("mLock")
    final Set<String> pyH;
    private final long pyJ;
    private final c pyL;
    private boolean pyN;
    private final CacheErrorLogger pyh;
    private final com.facebook.common.time.a pyi;
    private final g pyt;
    private final CacheEventListener pyu;
    private final boolean pyw;
    private static final Class<?> pyc = d.class;
    private static final long pyB = TimeUnit.HOURS.toMillis(2);
    private static final long pyC = TimeUnit.MINUTES.toMillis(30);
    private final Object mLock = new Object();
    private final StatFsHelper pyK = StatFsHelper.esY();
    private long pyI = -1;
    private final a pyM = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gOf = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gOf = -1L;
            this.mSize = -1L;
        }

        public synchronized void Q(long j, long j2) {
            this.gOf = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void R(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gOf += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gOf;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final long pyD;
        public final long pyE;
        public final long pyJ;

        public b(long j, long j2, long j3) {
            this.pyJ = j;
            this.pyD = j2;
            this.pyE = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pyD = bVar.pyD;
        this.pyE = bVar.pyE;
        this.pyG = bVar.pyE;
        this.pyL = cVar;
        this.pyt = gVar;
        this.pyu = cacheEventListener;
        this.pyJ = bVar.pyJ;
        this.pyh = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.pyi = com.facebook.common.time.c.etc();
        this.pyw = z;
        this.pyH = new HashSet();
        if (this.pyw) {
            this.pyF = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.esr();
                    }
                    d.this.pyN = true;
                    d.this.pyF.countDown();
                }
            });
            return;
        }
        this.pyF = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.esx().h(bVar);
        try {
            try {
                synchronized (this.mLock) {
                    List<String> a2 = com.facebook.cache.common.c.a(bVar);
                    aVar = null;
                    String str = null;
                    for (int i = 0; i < a2.size(); i++) {
                        str = a2.get(i);
                        h.Zt(str);
                        aVar = this.pyL.F(str, bVar);
                        if (aVar != null) {
                            break;
                        }
                    }
                    if (aVar == null) {
                        this.pyu.b(h);
                        this.pyH.remove(str);
                    } else {
                        this.pyu.a(h);
                        this.pyH.add(str);
                    }
                }
                h.recycle();
                return aVar;
            } catch (IOException e) {
                this.pyh.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pyc, "getResource", e);
                h.h(e);
                this.pyu.e(h);
                h.recycle();
                return null;
            }
        } catch (Throwable th) {
            h.recycle();
            throw th;
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        esp();
        return this.pyL.E(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aZ;
        synchronized (this.mLock) {
            aZ = bVar.aZ(bVar2);
            this.pyH.add(str);
            this.pyM.R(aZ.size(), 1L);
        }
        return aZ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.esx().h(bVar);
        this.pyu.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zt(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.iA(a3.size()).iB(this.pyM.getSize());
                    this.pyu.d(h);
                    return a3;
                } finally {
                    if (!a2.esc()) {
                        com.facebook.common.c.a.i(pyc, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.h(e);
                this.pyu.f(h);
                com.facebook.common.c.a.b(pyc, "Failed inserting a file into the cache", e);
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
                    this.pyL.Zp(str);
                    this.pyH.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.pyh.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, pyc, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void esp() throws IOException {
        synchronized (this.mLock) {
            boolean esr = esr();
            esq();
            long size = this.pyM.getSize();
            if (size > this.pyG && !esr) {
                this.pyM.reset();
                esr();
            }
            if (size > this.pyG) {
                a((this.pyG * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2;
        try {
            Collection<c.a> l = l(this.pyL.erZ());
            long size = this.pyM.getSize();
            long j3 = size - j;
            int i = 0;
            long j4 = 0;
            Iterator<c.a> it = l.iterator();
            while (true) {
                j2 = j4;
                if (!it.hasNext()) {
                    break;
                }
                c.a next = it.next();
                if (j2 > j3) {
                    break;
                }
                long a2 = this.pyL.a(next);
                this.pyH.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i iC = i.esx().Zt(next.getId()).a(evictionReason).iA(a2).iB(size - j2).iC(j);
                    this.pyu.g(iC);
                    iC.recycle();
                }
                j4 = j2;
            }
            this.pyM.R(-j2, -i);
            this.pyL.erY();
        } catch (IOException e) {
            this.pyh.a(CacheErrorLogger.CacheErrorCategory.EVICTION, pyc, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = pyB + this.pyi.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.pyt.esd());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void esq() {
        if (this.pyK.a(this.pyL.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pyE - this.pyM.getSize())) {
            this.pyG = this.pyD;
        } else {
            this.pyG = this.pyE;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.pyH.contains(a2.get(i))) {
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
                    if (this.pyL.G(str, bVar)) {
                        this.pyH.add(str);
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
    public boolean esr() {
        long now = this.pyi.now();
        if (!this.pyM.isInitialized() || this.pyI == -1 || now - this.pyI > pyC) {
            return ess();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean ess() {
        Set<String> set;
        long j;
        long j2 = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        long j3 = -1;
        long now = this.pyi.now();
        long j4 = now + pyB;
        if (this.pyw && this.pyH.isEmpty()) {
            set = this.pyH;
        } else if (this.pyw) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            int i3 = 0;
            for (c.a aVar : this.pyL.erZ()) {
                i3++;
                j2 += aVar.getSize();
                if (aVar.getTimestamp() > j4) {
                    z = true;
                    i++;
                    i2 = (int) (i2 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j3);
                } else {
                    if (this.pyw) {
                        set.add(aVar.getId());
                    }
                    j = j3;
                }
                j3 = j;
            }
            if (z) {
                this.pyh.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, pyc, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            if (this.pyM.getCount() != i3 || this.pyM.getSize() != j2) {
                if (this.pyw && this.pyH != set) {
                    this.pyH.clear();
                    this.pyH.addAll(set);
                }
                this.pyM.Q(j2, i3);
            }
            this.pyI = now;
            return true;
        } catch (IOException e) {
            this.pyh.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pyc, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

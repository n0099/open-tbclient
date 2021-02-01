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
    private static final Class<?> pxC = d.class;
    private static final long pyb = TimeUnit.HOURS.toMillis(2);
    private static final long pyc = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger pxH;
    private final com.facebook.common.time.a pxI;
    private final g pxT;
    private final CacheEventListener pxU;
    private final boolean pxW;
    private final long pyd;
    private final long pye;
    private final CountDownLatch pyf;
    private long pyg;
    @GuardedBy("mLock")
    final Set<String> pyh;
    private final long pyj;
    private final c pyl;
    private boolean pyn;
    private final Object mLock = new Object();
    private final StatFsHelper pyk = StatFsHelper.esQ();
    private long pyi = -1;
    private final a pym = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        private boolean mInitialized = false;
        private long mSize = -1;
        private long gNR = -1;

        a() {
        }

        public synchronized boolean isInitialized() {
            return this.mInitialized;
        }

        public synchronized void reset() {
            this.mInitialized = false;
            this.gNR = -1L;
            this.mSize = -1L;
        }

        public synchronized void Q(long j, long j2) {
            this.gNR = j2;
            this.mSize = j;
            this.mInitialized = true;
        }

        public synchronized void R(long j, long j2) {
            if (this.mInitialized) {
                this.mSize += j;
                this.gNR += j2;
            }
        }

        public synchronized long getSize() {
            return this.mSize;
        }

        public synchronized long getCount() {
            return this.gNR;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public final long pyd;
        public final long pye;
        public final long pyj;

        public b(long j, long j2, long j3) {
            this.pyj = j;
            this.pyd = j2;
            this.pye = j3;
        }
    }

    public d(c cVar, g gVar, b bVar, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, @Nullable com.facebook.common.a.b bVar2, Context context, Executor executor, boolean z) {
        this.pyd = bVar.pyd;
        this.pye = bVar.pye;
        this.pyg = bVar.pye;
        this.pyl = cVar;
        this.pxT = gVar;
        this.pxU = cacheEventListener;
        this.pyj = bVar.pyj;
        this.pxH = cacheErrorLogger;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        this.pxI = com.facebook.common.time.c.esU();
        this.pxW = z;
        this.pyh = new HashSet();
        if (this.pxW) {
            this.pyf = new CountDownLatch(1);
            executor.execute(new Runnable() { // from class: com.facebook.cache.disk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (d.this.mLock) {
                        d.this.esj();
                    }
                    d.this.pyn = true;
                    d.this.pyf.countDown();
                }
            });
            return;
        }
        this.pyf = new CountDownLatch(0);
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a d(com.facebook.cache.common.b bVar) {
        com.facebook.a.a aVar;
        i h = i.esp().h(bVar);
        try {
            try {
                synchronized (this.mLock) {
                    List<String> a2 = com.facebook.cache.common.c.a(bVar);
                    aVar = null;
                    String str = null;
                    for (int i = 0; i < a2.size(); i++) {
                        str = a2.get(i);
                        h.Zh(str);
                        aVar = this.pyl.F(str, bVar);
                        if (aVar != null) {
                            break;
                        }
                    }
                    if (aVar == null) {
                        this.pxU.b(h);
                        this.pyh.remove(str);
                    } else {
                        this.pxU.a(h);
                        this.pyh.add(str);
                    }
                }
                h.recycle();
                return aVar;
            } catch (IOException e) {
                this.pxH.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pxC, "getResource", e);
                h.h(e);
                this.pxU.e(h);
                h.recycle();
                return null;
            }
        } catch (Throwable th) {
            h.recycle();
            throw th;
        }
    }

    private c.b a(String str, com.facebook.cache.common.b bVar) throws IOException {
        esh();
        return this.pyl.E(str, bVar);
    }

    private com.facebook.a.a a(c.b bVar, com.facebook.cache.common.b bVar2, String str) throws IOException {
        com.facebook.a.a aZ;
        synchronized (this.mLock) {
            aZ = bVar.aZ(bVar2);
            this.pyh.add(str);
            this.pym.R(aZ.size(), 1L);
        }
        return aZ;
    }

    @Override // com.facebook.cache.disk.h
    public com.facebook.a.a a(com.facebook.cache.common.b bVar, com.facebook.cache.common.h hVar) throws IOException {
        String b2;
        i h = i.esp().h(bVar);
        this.pxU.c(h);
        synchronized (this.mLock) {
            b2 = com.facebook.cache.common.c.b(bVar);
        }
        h.Zh(b2);
        try {
            try {
                c.b a2 = a(b2, bVar);
                try {
                    a2.a(hVar, bVar);
                    com.facebook.a.a a3 = a(a2, bVar, b2);
                    h.iA(a3.size()).iB(this.pym.getSize());
                    this.pxU.d(h);
                    return a3;
                } finally {
                    if (!a2.erU()) {
                        com.facebook.common.c.a.i(pxC, "Failed to delete temp file");
                    }
                }
            } catch (IOException e) {
                h.h(e);
                this.pxU.f(h);
                com.facebook.common.c.a.b(pxC, "Failed inserting a file into the cache", e);
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
                    this.pyl.Zd(str);
                    this.pyh.remove(str);
                    i = i2 + 1;
                }
            } catch (IOException e) {
                this.pxH.a(CacheErrorLogger.CacheErrorCategory.DELETE_FILE, pxC, "delete: " + e.getMessage(), e);
            }
        }
    }

    private void esh() throws IOException {
        synchronized (this.mLock) {
            boolean esj = esj();
            esi();
            long size = this.pym.getSize();
            if (size > this.pyg && !esj) {
                this.pym.reset();
                esj();
            }
            if (size > this.pyg) {
                a((this.pyg * 9) / 10, CacheEventListener.EvictionReason.CACHE_FULL);
            }
        }
    }

    @GuardedBy("mLock")
    private void a(long j, CacheEventListener.EvictionReason evictionReason) throws IOException {
        long j2;
        try {
            Collection<c.a> l = l(this.pyl.erR());
            long size = this.pym.getSize();
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
                long a2 = this.pyl.a(next);
                this.pyh.remove(next.getId());
                if (a2 > 0) {
                    i++;
                    j2 += a2;
                    i iC = i.esp().Zh(next.getId()).a(evictionReason).iA(a2).iB(size - j2).iC(j);
                    this.pxU.g(iC);
                    iC.recycle();
                }
                j4 = j2;
            }
            this.pym.R(-j2, -i);
            this.pyl.erQ();
        } catch (IOException e) {
            this.pxH.a(CacheErrorLogger.CacheErrorCategory.EVICTION, pxC, "evictAboveSize: " + e.getMessage(), e);
            throw e;
        }
    }

    private Collection<c.a> l(Collection<c.a> collection) {
        long now = pyb + this.pxI.now();
        ArrayList arrayList = new ArrayList(collection.size());
        ArrayList arrayList2 = new ArrayList(collection.size());
        for (c.a aVar : collection) {
            if (aVar.getTimestamp() > now) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        Collections.sort(arrayList2, this.pxT.erV());
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    @GuardedBy("mLock")
    private void esi() {
        if (this.pyk.a(this.pyl.isExternal() ? StatFsHelper.StorageType.EXTERNAL : StatFsHelper.StorageType.INTERNAL, this.pye - this.pym.getSize())) {
            this.pyg = this.pyd;
        } else {
            this.pyg = this.pye;
        }
    }

    @Override // com.facebook.cache.disk.h
    public boolean f(com.facebook.cache.common.b bVar) {
        synchronized (this.mLock) {
            List<String> a2 = com.facebook.cache.common.c.a(bVar);
            for (int i = 0; i < a2.size(); i++) {
                if (this.pyh.contains(a2.get(i))) {
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
                    if (this.pyl.G(str, bVar)) {
                        this.pyh.add(str);
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
    public boolean esj() {
        long now = this.pxI.now();
        if (!this.pym.isInitialized() || this.pyi == -1 || now - this.pyi > pyc) {
            return esk();
        }
        return false;
    }

    @GuardedBy("mLock")
    private boolean esk() {
        Set<String> set;
        long j;
        long j2 = 0;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        long j3 = -1;
        long now = this.pxI.now();
        long j4 = now + pyb;
        if (this.pxW && this.pyh.isEmpty()) {
            set = this.pyh;
        } else if (this.pxW) {
            set = new HashSet();
        } else {
            set = null;
        }
        try {
            int i3 = 0;
            for (c.a aVar : this.pyl.erR()) {
                i3++;
                j2 += aVar.getSize();
                if (aVar.getTimestamp() > j4) {
                    z = true;
                    i++;
                    i2 = (int) (i2 + aVar.getSize());
                    j = Math.max(aVar.getTimestamp() - now, j3);
                } else {
                    if (this.pxW) {
                        set.add(aVar.getId());
                    }
                    j = j3;
                }
                j3 = j;
            }
            if (z) {
                this.pxH.a(CacheErrorLogger.CacheErrorCategory.READ_INVALID_ENTRY, pxC, "Future timestamp found in " + i + " files , with a total size of " + i2 + " bytes, and a maximum time delta of " + j3 + "ms", null);
            }
            if (this.pym.getCount() != i3 || this.pym.getSize() != j2) {
                if (this.pxW && this.pyh != set) {
                    this.pyh.clear();
                    this.pyh.addAll(set);
                }
                this.pym.Q(j2, i3);
            }
            this.pyi = now;
            return true;
        } catch (IOException e) {
            this.pxH.a(CacheErrorLogger.CacheErrorCategory.GENERIC_IO, pxC, "calcFileCacheSize: " + e.getMessage(), e);
            return false;
        }
    }
}

package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class u {
    private static final Class<?> mls = u.class;
    @GuardedBy("this")
    private Map<com.facebook.cache.common.b, com.facebook.imagepipeline.g.e> mMap = new HashMap();

    private u() {
    }

    public static u dyk() {
        return new u();
    }

    public synchronized void a(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        com.facebook.imagepipeline.g.e.e(this.mMap.put(bVar, com.facebook.imagepipeline.g.e.b(eVar)));
        dyl();
    }

    public boolean s(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e remove;
        com.facebook.common.internal.g.checkNotNull(bVar);
        synchronized (this) {
            remove = this.mMap.remove(bVar);
        }
        if (remove == null) {
            return false;
        }
        try {
            return remove.isValid();
        } finally {
            remove.close();
        }
    }

    public synchronized boolean d(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        boolean z;
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        com.facebook.imagepipeline.g.e eVar2 = this.mMap.get(bVar);
        if (eVar2 == null) {
            z = false;
        } else {
            com.facebook.common.references.a<PooledByteBuffer> dAy = eVar2.dAy();
            com.facebook.common.references.a<PooledByteBuffer> dAy2 = eVar.dAy();
            if (dAy != null && dAy2 != null && dAy.get() == dAy2.get()) {
                this.mMap.remove(bVar);
                com.facebook.common.references.a.c(dAy2);
                com.facebook.common.references.a.c(dAy);
                com.facebook.imagepipeline.g.e.e(eVar2);
                dyl();
                z = true;
            } else {
                com.facebook.common.references.a.c(dAy2);
                com.facebook.common.references.a.c(dAy);
                com.facebook.imagepipeline.g.e.e(eVar2);
                z = false;
            }
        }
        return z;
    }

    public synchronized com.facebook.imagepipeline.g.e t(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e eVar;
        com.facebook.common.internal.g.checkNotNull(bVar);
        eVar = this.mMap.get(bVar);
        if (eVar != null) {
            synchronized (eVar) {
                if (!com.facebook.imagepipeline.g.e.f(eVar)) {
                    this.mMap.remove(bVar);
                    com.facebook.common.c.a.c(mls, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.dtP(), Integer.valueOf(System.identityHashCode(bVar)));
                    eVar = null;
                } else {
                    eVar = com.facebook.imagepipeline.g.e.b(eVar);
                }
            }
        }
        return eVar;
    }

    public synchronized boolean u(com.facebook.cache.common.b bVar) {
        boolean z;
        com.facebook.common.internal.g.checkNotNull(bVar);
        if (this.mMap.containsKey(bVar)) {
            com.facebook.imagepipeline.g.e eVar = this.mMap.get(bVar);
            synchronized (eVar) {
                if (com.facebook.imagepipeline.g.e.f(eVar)) {
                    z = true;
                } else {
                    this.mMap.remove(bVar);
                    com.facebook.common.c.a.c(mls, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.dtP(), Integer.valueOf(System.identityHashCode(bVar)));
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void dyl() {
        com.facebook.common.c.a.a(mls, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}

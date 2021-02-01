package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class u {
    private static final Class<?> pxC = u.class;
    @GuardedBy("this")
    private Map<com.facebook.cache.common.b, com.facebook.imagepipeline.f.e> mMap = new HashMap();

    private u() {
    }

    public static u ewa() {
        return new u();
    }

    public synchronized void a(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        com.facebook.imagepipeline.f.e.e(this.mMap.put(bVar, com.facebook.imagepipeline.f.e.b(eVar)));
        ewb();
    }

    public boolean s(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e remove;
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

    public synchronized boolean d(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        boolean z;
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkNotNull(eVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        com.facebook.imagepipeline.f.e eVar2 = this.mMap.get(bVar);
        if (eVar2 == null) {
            z = false;
        } else {
            com.facebook.common.references.a<PooledByteBuffer> eyn = eVar2.eyn();
            com.facebook.common.references.a<PooledByteBuffer> eyn2 = eVar.eyn();
            if (eyn != null && eyn2 != null && eyn.get() == eyn2.get()) {
                this.mMap.remove(bVar);
                com.facebook.common.references.a.c(eyn2);
                com.facebook.common.references.a.c(eyn);
                com.facebook.imagepipeline.f.e.e(eVar2);
                ewb();
                z = true;
            } else {
                com.facebook.common.references.a.c(eyn2);
                com.facebook.common.references.a.c(eyn);
                com.facebook.imagepipeline.f.e.e(eVar2);
                z = false;
            }
        }
        return z;
    }

    public synchronized com.facebook.imagepipeline.f.e t(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e eVar;
        com.facebook.common.internal.g.checkNotNull(bVar);
        eVar = this.mMap.get(bVar);
        if (eVar != null) {
            synchronized (eVar) {
                if (!com.facebook.imagepipeline.f.e.f(eVar)) {
                    this.mMap.remove(bVar);
                    com.facebook.common.c.a.c(pxC, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.erM(), Integer.valueOf(System.identityHashCode(bVar)));
                    eVar = null;
                } else {
                    eVar = com.facebook.imagepipeline.f.e.b(eVar);
                }
            }
        }
        return eVar;
    }

    public synchronized boolean u(com.facebook.cache.common.b bVar) {
        boolean z;
        com.facebook.common.internal.g.checkNotNull(bVar);
        if (this.mMap.containsKey(bVar)) {
            com.facebook.imagepipeline.f.e eVar = this.mMap.get(bVar);
            synchronized (eVar) {
                if (com.facebook.imagepipeline.f.e.f(eVar)) {
                    z = true;
                } else {
                    this.mMap.remove(bVar);
                    com.facebook.common.c.a.c(pxC, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.erM(), Integer.valueOf(System.identityHashCode(bVar)));
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void ewb() {
        com.facebook.common.c.a.c(pxC, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}

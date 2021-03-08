package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes5.dex */
public class u {
    private static final Class<?> pAh = u.class;
    @GuardedBy("this")
    private Map<com.facebook.cache.common.b, com.facebook.imagepipeline.f.e> mMap = new HashMap();

    private u() {
    }

    public static u ewr() {
        return new u();
    }

    public synchronized void a(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        com.facebook.imagepipeline.f.e.e(this.mMap.put(bVar, com.facebook.imagepipeline.f.e.b(eVar)));
        ews();
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
            com.facebook.common.references.a<PooledByteBuffer> eyE = eVar2.eyE();
            com.facebook.common.references.a<PooledByteBuffer> eyE2 = eVar.eyE();
            if (eyE != null && eyE2 != null && eyE.get() == eyE2.get()) {
                this.mMap.remove(bVar);
                com.facebook.common.references.a.c(eyE2);
                com.facebook.common.references.a.c(eyE);
                com.facebook.imagepipeline.f.e.e(eVar2);
                ews();
                z = true;
            } else {
                com.facebook.common.references.a.c(eyE2);
                com.facebook.common.references.a.c(eyE);
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
                    com.facebook.common.c.a.c(pAh, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.esd(), Integer.valueOf(System.identityHashCode(bVar)));
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
                    com.facebook.common.c.a.c(pAh, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.esd(), Integer.valueOf(System.identityHashCode(bVar)));
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void ews() {
        com.facebook.common.c.a.a(pAh, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}

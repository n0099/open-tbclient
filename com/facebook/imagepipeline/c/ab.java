package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class ab {
    private static final Class<?> hVC = ab.class;
    @GuardedBy("this")
    private Map<com.facebook.cache.common.b, com.facebook.imagepipeline.f.d> mMap = new HashMap();

    private ab() {
    }

    public static ab bUA() {
        return new ab();
    }

    public synchronized void a(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        com.facebook.imagepipeline.f.d.e(this.mMap.put(bVar, com.facebook.imagepipeline.f.d.b(dVar)));
        bUB();
    }

    public synchronized boolean d(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        boolean z;
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkNotNull(dVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        com.facebook.imagepipeline.f.d dVar2 = this.mMap.get(bVar);
        if (dVar2 == null) {
            z = false;
        } else {
            com.facebook.common.references.a<PooledByteBuffer> bWy = dVar2.bWy();
            com.facebook.common.references.a<PooledByteBuffer> bWy2 = dVar.bWy();
            if (bWy != null && bWy2 != null && bWy.get() == bWy2.get()) {
                this.mMap.remove(bVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy2);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy);
                com.facebook.imagepipeline.f.d.e(dVar2);
                bUB();
                z = true;
            } else {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy2);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy);
                com.facebook.imagepipeline.f.d.e(dVar2);
                z = false;
            }
        }
        return z;
    }

    public synchronized com.facebook.imagepipeline.f.d q(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d dVar;
        com.facebook.common.internal.g.checkNotNull(bVar);
        dVar = this.mMap.get(bVar);
        if (dVar != null) {
            synchronized (dVar) {
                if (!com.facebook.imagepipeline.f.d.f(dVar)) {
                    this.mMap.remove(bVar);
                    com.facebook.common.c.a.d(hVC, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(dVar)), bVar.getUriString(), Integer.valueOf(System.identityHashCode(bVar)));
                    dVar = null;
                } else {
                    dVar = com.facebook.imagepipeline.f.d.b(dVar);
                }
            }
        }
        return dVar;
    }

    public synchronized boolean r(com.facebook.cache.common.b bVar) {
        boolean z;
        com.facebook.common.internal.g.checkNotNull(bVar);
        if (this.mMap.containsKey(bVar)) {
            com.facebook.imagepipeline.f.d dVar = this.mMap.get(bVar);
            synchronized (dVar) {
                if (com.facebook.imagepipeline.f.d.f(dVar)) {
                    z = true;
                } else {
                    this.mMap.remove(bVar);
                    com.facebook.common.c.a.d(hVC, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(dVar)), bVar.getUriString(), Integer.valueOf(System.identityHashCode(bVar)));
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void bUB() {
        com.facebook.common.c.a.a(hVC, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}

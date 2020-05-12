package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes12.dex */
public class u {
    private static final Class<?> lQq = u.class;
    @GuardedBy("this")
    private Map<com.facebook.cache.common.b, com.facebook.imagepipeline.g.e> mMap = new HashMap();

    private u() {
    }

    public static u dqE() {
        return new u();
    }

    public synchronized void a(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        com.facebook.imagepipeline.g.e.e(this.mMap.put(bVar, com.facebook.imagepipeline.g.e.b(eVar)));
        dqF();
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
            com.facebook.common.references.a<PooledByteBuffer> dsS = eVar2.dsS();
            com.facebook.common.references.a<PooledByteBuffer> dsS2 = eVar.dsS();
            if (dsS != null && dsS2 != null && dsS.get() == dsS2.get()) {
                this.mMap.remove(bVar);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsS2);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsS);
                com.facebook.imagepipeline.g.e.e(eVar2);
                dqF();
                z = true;
            } else {
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsS2);
                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsS);
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
                    com.facebook.common.c.a.c(lQq, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.dmi(), Integer.valueOf(System.identityHashCode(bVar)));
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
                    com.facebook.common.c.a.c(lQq, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(eVar)), bVar.dmi(), Integer.valueOf(System.identityHashCode(bVar)));
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    private synchronized void dqF() {
        com.facebook.common.c.a.a(lQq, "Count = %d", Integer.valueOf(this.mMap.size()));
    }
}

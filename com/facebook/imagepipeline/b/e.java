package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class e {
    private static final Class<?> pxC = e.class;
    private final com.facebook.common.memory.g pGK;
    private final com.facebook.cache.disk.h pGX;
    private final com.facebook.common.memory.j pGY;
    private final Executor pGZ;
    private final Executor pHa;
    private final u pHb = u.ewa();
    private final n pHc;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pGX = hVar;
        this.pGK = gVar;
        this.pGY = jVar;
        this.pGZ = executor;
        this.pHa = executor2;
        this.pHc = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pHb.u(bVar) || this.pGX.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.i(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: evH */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pGZ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pxC, e, "Failed to schedule disk-cache read for %s", bVar.erM());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pHb.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pHb.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.c(pxC, "Found image for %s in staging area", bVar.erM());
            this.pHc.r(bVar);
            return true;
        }
        com.facebook.common.c.a.c(pxC, "Did not find image for %s in staging area", bVar.erM());
        this.pHc.evV();
        try {
            return this.pGX.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: evI */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pHb.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.c(e.pxC, "Found image for %s in staging area", bVar.erM());
                            e.this.pHc.r(bVar);
                        } else {
                            com.facebook.common.c.a.c(e.pxC, "Did not find image for %s in staging area", bVar.erM());
                            e.this.pHc.evV();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.f(e.pxC, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pGZ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pxC, e, "Failed to schedule disk-cache read for %s", bVar.erM());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pHb.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pHa.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b2);
                    } finally {
                        e.this.pHb.d(bVar, b2);
                        com.facebook.imagepipeline.f.e.e(b2);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(pxC, e, "Failed to schedule disk-cache write for %s", bVar.erM());
            this.pHb.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b2);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pHb.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pHb.s(bVar);
                    e.this.pGX.e(bVar);
                    return null;
                }
            }, this.pHa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pxC, e, "Failed to schedule disk-cache remove for %s", bVar.erM());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(pxC, "Found image for %s in staging area", bVar.erM());
        this.pHc.r(bVar);
        return bolts.g.i(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.c(pxC, "Disk cache read for %s", bVar.erM());
            com.facebook.a.a d = this.pGX.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.c(pxC, "Disk cache miss for %s", bVar.erM());
                this.pHc.evX();
                return null;
            }
            com.facebook.common.c.a.c(pxC, "Found entry in disk cache for %s", bVar.erM());
            this.pHc.evW();
            InputStream erL = d.erL();
            PooledByteBuffer b2 = this.pGK.b(erL, (int) d.size());
            erL.close();
            com.facebook.common.c.a.c(pxC, "Successful read from disk cache for %s", bVar.erM());
            return b2;
        } catch (IOException e) {
            com.facebook.common.c.a.a(pxC, e, "Exception reading from cache for %s", bVar.erM());
            this.pHc.evY();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(pxC, "About to write to disk-cache for key %s", bVar.erM());
        try {
            this.pGX.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pGY.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.c(pxC, "Successful disk-cache write for key %s", bVar.erM());
        } catch (IOException e) {
            com.facebook.common.c.a.a(pxC, e, "Failed to write to disk-cache for key %s", bVar.erM());
        }
    }
}

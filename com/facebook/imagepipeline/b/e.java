package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class e {
    private static final Class<?> pnm = e.class;
    private final com.facebook.common.memory.g pwB;
    private final com.facebook.cache.disk.h pwO;
    private final com.facebook.common.memory.j pwP;
    private final Executor pwQ;
    private final Executor pwR;
    private final u pwS = u.etI();
    private final n pwT;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pwO = hVar;
        this.pwB = gVar;
        this.pwP = jVar;
        this.pwQ = executor;
        this.pwR = executor2;
        this.pwT = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pwS.u(bVar) || this.pwO.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.i(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: etp */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pwQ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pnm, e, "Failed to schedule disk-cache read for %s", bVar.ept());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pwS.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pwS.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.c(pnm, "Found image for %s in staging area", bVar.ept());
            this.pwT.r(bVar);
            return true;
        }
        com.facebook.common.c.a.c(pnm, "Did not find image for %s in staging area", bVar.ept());
        this.pwT.etD();
        try {
            return this.pwO.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: etq */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pwS.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.c(e.pnm, "Found image for %s in staging area", bVar.ept());
                            e.this.pwT.r(bVar);
                        } else {
                            com.facebook.common.c.a.c(e.pnm, "Did not find image for %s in staging area", bVar.ept());
                            e.this.pwT.etD();
                            try {
                                com.facebook.common.references.a f = com.facebook.common.references.a.f(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(f);
                                com.facebook.common.references.a.c(f);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.f(e.pnm, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pwQ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pnm, e, "Failed to schedule disk-cache read for %s", bVar.ept());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pwS.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pwR.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b2);
                    } finally {
                        e.this.pwS.d(bVar, b2);
                        com.facebook.imagepipeline.f.e.e(b2);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(pnm, e, "Failed to schedule disk-cache write for %s", bVar.ept());
            this.pwS.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b2);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pwS.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pwS.s(bVar);
                    e.this.pwO.e(bVar);
                    return null;
                }
            }, this.pwR);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pnm, e, "Failed to schedule disk-cache remove for %s", bVar.ept());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(pnm, "Found image for %s in staging area", bVar.ept());
        this.pwT.r(bVar);
        return bolts.g.i(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.c(pnm, "Disk cache read for %s", bVar.ept());
            com.facebook.a.a d = this.pwO.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.c(pnm, "Disk cache miss for %s", bVar.ept());
                this.pwT.etF();
                return null;
            }
            com.facebook.common.c.a.c(pnm, "Found entry in disk cache for %s", bVar.ept());
            this.pwT.etE();
            InputStream eps = d.eps();
            PooledByteBuffer b2 = this.pwB.b(eps, (int) d.size());
            eps.close();
            com.facebook.common.c.a.c(pnm, "Successful read from disk cache for %s", bVar.ept());
            return b2;
        } catch (IOException e) {
            com.facebook.common.c.a.a(pnm, e, "Exception reading from cache for %s", bVar.ept());
            this.pwT.etG();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(pnm, "About to write to disk-cache for key %s", bVar.ept());
        try {
            this.pwO.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pwP.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.c(pnm, "Successful disk-cache write for key %s", bVar.ept());
        } catch (IOException e) {
            com.facebook.common.c.a.a(pnm, e, "Failed to write to disk-cache for key %s", bVar.ept());
        }
    }
}

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
    private static final Class<?> prQ = e.class;
    private final com.facebook.cache.disk.h pzI;
    private final com.facebook.common.memory.j pzJ;
    private final Executor pzK;
    private final Executor pzL;
    private final u pzM = u.ewY();
    private final n pzN;
    private final com.facebook.common.memory.g pzv;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pzI = hVar;
        this.pzv = gVar;
        this.pzJ = jVar;
        this.pzK = executor;
        this.pzL = executor2;
        this.pzN = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pzM.u(bVar) || this.pzI.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.i(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: ewF */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pzK);
        } catch (Exception e) {
            com.facebook.common.c.a.a(prQ, e, "Failed to schedule disk-cache read for %s", bVar.etj());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pzM.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pzM.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.c(prQ, "Found image for %s in staging area", bVar.etj());
            this.pzN.r(bVar);
            return true;
        }
        com.facebook.common.c.a.c(prQ, "Did not find image for %s in staging area", bVar.etj());
        this.pzN.ewT();
        try {
            return this.pzI.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: ewG */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pzM.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.c(e.prQ, "Found image for %s in staging area", bVar.etj());
                            e.this.pzN.r(bVar);
                        } else {
                            com.facebook.common.c.a.c(e.prQ, "Did not find image for %s in staging area", bVar.etj());
                            e.this.pzN.ewT();
                            try {
                                com.facebook.common.references.a f = com.facebook.common.references.a.f(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(f);
                                com.facebook.common.references.a.c(f);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.f(e.prQ, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pzK);
        } catch (Exception e) {
            com.facebook.common.c.a.a(prQ, e, "Failed to schedule disk-cache read for %s", bVar.etj());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pzM.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pzL.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b2);
                    } finally {
                        e.this.pzM.d(bVar, b2);
                        com.facebook.imagepipeline.f.e.e(b2);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(prQ, e, "Failed to schedule disk-cache write for %s", bVar.etj());
            this.pzM.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b2);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pzM.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pzM.s(bVar);
                    e.this.pzI.e(bVar);
                    return null;
                }
            }, this.pzL);
        } catch (Exception e) {
            com.facebook.common.c.a.a(prQ, e, "Failed to schedule disk-cache remove for %s", bVar.etj());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(prQ, "Found image for %s in staging area", bVar.etj());
        this.pzN.r(bVar);
        return bolts.g.i(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.c(prQ, "Disk cache read for %s", bVar.etj());
            com.facebook.a.a d = this.pzI.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.c(prQ, "Disk cache miss for %s", bVar.etj());
                this.pzN.ewV();
                return null;
            }
            com.facebook.common.c.a.c(prQ, "Found entry in disk cache for %s", bVar.etj());
            this.pzN.ewU();
            InputStream eti = d.eti();
            PooledByteBuffer b2 = this.pzv.b(eti, (int) d.size());
            eti.close();
            com.facebook.common.c.a.c(prQ, "Successful read from disk cache for %s", bVar.etj());
            return b2;
        } catch (IOException e) {
            com.facebook.common.c.a.a(prQ, e, "Exception reading from cache for %s", bVar.etj());
            this.pzN.ewW();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(prQ, "About to write to disk-cache for key %s", bVar.etj());
        try {
            this.pzI.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pzJ.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.c(prQ, "Successful disk-cache write for key %s", bVar.etj());
        } catch (IOException e) {
            com.facebook.common.c.a.a(prQ, e, "Failed to write to disk-cache for key %s", bVar.etj());
        }
    }
}

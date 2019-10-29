package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class e {
    private static final Class<?> jZN = e.class;
    private final com.facebook.cache.disk.h kgJ;
    private final com.facebook.common.memory.j kgK;
    private final Executor kgL;
    private final Executor kgM;
    private final ab kgN = ab.cFM();
    private final o kgO;
    private final com.facebook.common.memory.g kgu;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.kgJ = hVar;
        this.kgu = gVar;
        this.kgK = jVar;
        this.kgL = executor;
        this.kgM = executor2;
        this.kgO = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.kgN.r(bVar) || this.kgJ.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.g(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cFs */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.kgL);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jZN, e, "Failed to schedule disk-cache read for %s", bVar.cBY());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.kgN.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.kgN.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(jZN, "Found image for %s in staging area", bVar.cBY());
            this.kgO.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(jZN, "Did not find image for %s in staging area", bVar.cBY());
        this.kgO.cFG();
        try {
            return this.kgJ.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cFt */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.kgN.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.jZN, "Found image for %s in staging area", bVar.cBY());
                            e.this.kgO.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.jZN, "Did not find image for %s in staging area", bVar.cBY());
                            e.this.kgO.cFG();
                            try {
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(e.this.m(bVar));
                                q = new com.facebook.imagepipeline.f.d(c);
                                q.t(bVar);
                                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.c(e.jZN, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.kgL);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jZN, e, "Failed to schedule disk-cache read for %s", bVar.cBY());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.kgN.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.kgM.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.kgN.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(jZN, e, "Failed to schedule disk-cache write for %s", bVar.cBY());
            this.kgN.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jZN, "Found image for %s in staging area", bVar.cBY());
        this.kgO.p(bVar);
        return bolts.g.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(jZN, "Disk cache read for %s", bVar.cBY());
            com.facebook.a.a d = this.kgJ.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(jZN, "Disk cache miss for %s", bVar.cBY());
                this.kgO.cFI();
                return null;
            }
            com.facebook.common.c.a.a(jZN, "Found entry in disk cache for %s", bVar.cBY());
            this.kgO.cFH();
            InputStream cBX = d.cBX();
            PooledByteBuffer b = this.kgu.b(cBX, (int) d.size());
            cBX.close();
            com.facebook.common.c.a.a(jZN, "Successful read from disk cache for %s", bVar.cBY());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(jZN, e, "Exception reading from cache for %s", bVar.cBY());
            this.kgO.cFJ();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jZN, "About to write to disk-cache for key %s", bVar.cBY());
        try {
            this.kgJ.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.kgK.e(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(jZN, "Successful disk-cache write for key %s", bVar.cBY());
        } catch (IOException e) {
            com.facebook.common.c.a.a(jZN, e, "Failed to write to disk-cache for key %s", bVar.cBY());
        }
    }
}

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
    private static final Class<?> jYW = e.class;
    private final com.facebook.common.memory.g kfD;
    private final com.facebook.cache.disk.h kfS;
    private final com.facebook.common.memory.j kfT;
    private final Executor kfU;
    private final Executor kfV;
    private final ab kfW = ab.cFK();
    private final o kfX;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.kfS = hVar;
        this.kfD = gVar;
        this.kfT = jVar;
        this.kfU = executor;
        this.kfV = executor2;
        this.kfX = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.kfW.r(bVar) || this.kfS.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.g(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cFq */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.kfU);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jYW, e, "Failed to schedule disk-cache read for %s", bVar.cBW());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.kfW.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.kfW.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(jYW, "Found image for %s in staging area", bVar.cBW());
            this.kfX.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(jYW, "Did not find image for %s in staging area", bVar.cBW());
        this.kfX.cFE();
        try {
            return this.kfS.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cFr */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.kfW.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.jYW, "Found image for %s in staging area", bVar.cBW());
                            e.this.kfX.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.jYW, "Did not find image for %s in staging area", bVar.cBW());
                            e.this.kfX.cFE();
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
                            com.facebook.common.c.a.c(e.jYW, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.kfU);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jYW, e, "Failed to schedule disk-cache read for %s", bVar.cBW());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.kfW.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.kfV.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.kfW.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(jYW, e, "Failed to schedule disk-cache write for %s", bVar.cBW());
            this.kfW.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jYW, "Found image for %s in staging area", bVar.cBW());
        this.kfX.p(bVar);
        return bolts.g.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(jYW, "Disk cache read for %s", bVar.cBW());
            com.facebook.a.a d = this.kfS.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(jYW, "Disk cache miss for %s", bVar.cBW());
                this.kfX.cFG();
                return null;
            }
            com.facebook.common.c.a.a(jYW, "Found entry in disk cache for %s", bVar.cBW());
            this.kfX.cFF();
            InputStream cBV = d.cBV();
            PooledByteBuffer b = this.kfD.b(cBV, (int) d.size());
            cBV.close();
            com.facebook.common.c.a.a(jYW, "Successful read from disk cache for %s", bVar.cBW());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(jYW, e, "Exception reading from cache for %s", bVar.cBW());
            this.kfX.cFH();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jYW, "About to write to disk-cache for key %s", bVar.cBW());
        try {
            this.kfS.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.kfT.e(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(jYW, "Successful disk-cache write for key %s", bVar.cBW());
        } catch (IOException e) {
            com.facebook.common.c.a.a(jYW, e, "Failed to write to disk-cache for key %s", bVar.cBW());
        }
    }
}

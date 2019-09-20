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
    private static final Class<?> kbD = e.class;
    private final com.facebook.common.memory.j kiA;
    private final Executor kiB;
    private final Executor kiC;
    private final ab kiD = ab.cIP();
    private final o kiE;
    private final com.facebook.common.memory.g kik;
    private final com.facebook.cache.disk.h kiz;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.kiz = hVar;
        this.kik = gVar;
        this.kiA = jVar;
        this.kiB = executor;
        this.kiC = executor2;
        this.kiE = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.kiD.r(bVar) || this.kiz.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.g(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cIv */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.kiB);
        } catch (Exception e) {
            com.facebook.common.c.a.a(kbD, e, "Failed to schedule disk-cache read for %s", bVar.cFa());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.kiD.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.kiD.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(kbD, "Found image for %s in staging area", bVar.cFa());
            this.kiE.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(kbD, "Did not find image for %s in staging area", bVar.cFa());
        this.kiE.cIJ();
        try {
            return this.kiz.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cIw */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.kiD.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.kbD, "Found image for %s in staging area", bVar.cFa());
                            e.this.kiE.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.kbD, "Did not find image for %s in staging area", bVar.cFa());
                            e.this.kiE.cIJ();
                            try {
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(e.this.m(bVar));
                                q = new com.facebook.imagepipeline.f.d(d);
                                q.t(bVar);
                                com.facebook.common.references.a.c(d);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.d(e.kbD, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.kiB);
        } catch (Exception e) {
            com.facebook.common.c.a.a(kbD, e, "Failed to schedule disk-cache read for %s", bVar.cFa());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.kiD.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.kiC.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.kiD.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(kbD, e, "Failed to schedule disk-cache write for %s", bVar.cFa());
            this.kiD.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(kbD, "Found image for %s in staging area", bVar.cFa());
        this.kiE.p(bVar);
        return bolts.g.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(kbD, "Disk cache read for %s", bVar.cFa());
            com.facebook.a.a d = this.kiz.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(kbD, "Disk cache miss for %s", bVar.cFa());
                this.kiE.cIL();
                return null;
            }
            com.facebook.common.c.a.a(kbD, "Found entry in disk cache for %s", bVar.cFa());
            this.kiE.cIK();
            InputStream cEZ = d.cEZ();
            PooledByteBuffer b = this.kik.b(cEZ, (int) d.size());
            cEZ.close();
            com.facebook.common.c.a.a(kbD, "Successful read from disk cache for %s", bVar.cFa());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(kbD, e, "Exception reading from cache for %s", bVar.cFa());
            this.kiE.cIM();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(kbD, "About to write to disk-cache for key %s", bVar.cFa());
        try {
            this.kiz.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.kiA.g(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(kbD, "Successful disk-cache write for key %s", bVar.cFa());
        } catch (IOException e) {
            com.facebook.common.c.a.a(kbD, e, "Failed to write to disk-cache for key %s", bVar.cFa());
        }
    }
}

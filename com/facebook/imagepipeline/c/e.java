package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class e {
    private static final Class<?> lCO = e.class;
    private final com.facebook.common.memory.g lLT;
    private final com.facebook.cache.disk.h lMh;
    private final com.facebook.common.memory.j lMi;
    private final Executor lMj;
    private final Executor lMk;
    private final u lMl = u.dlN();
    private final n lMm;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lMh = hVar;
        this.lLT = gVar;
        this.lMi = jVar;
        this.lMj = executor;
        this.lMk = executor2;
        this.lMm = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lMl.u(bVar) || this.lMh.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dav */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lMj);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lCO, e, "Failed to schedule disk-cache read for %s", bVar.dhC());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lMl.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lMl.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lCO, "Found image for %s in staging area", bVar.dhC());
            this.lMm.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lCO, "Did not find image for %s in staging area", bVar.dhC());
        this.lMm.dlI();
        try {
            return this.lMh.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dlx */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lMl.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lCO, "Found image for %s in staging area", bVar.dhC());
                            e.this.lMm.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lCO, "Did not find image for %s in staging area", bVar.dhC());
                            e.this.lMm.dlI();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lCO, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lMj);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lCO, e, "Failed to schedule disk-cache read for %s", bVar.dhC());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lMl.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lMk.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lMl.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lCO, e, "Failed to schedule disk-cache write for %s", bVar.dhC());
            this.lMl.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lMl.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lMl.s(bVar);
                    e.this.lMh.e(bVar);
                    return null;
                }
            }, this.lMk);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lCO, e, "Failed to schedule disk-cache remove for %s", bVar.dhC());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lCO, "Found image for %s in staging area", bVar.dhC());
        this.lMm.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lCO, "Disk cache read for %s", bVar.dhC());
            com.facebook.a.a d = this.lMh.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lCO, "Disk cache miss for %s", bVar.dhC());
                this.lMm.dlK();
                return null;
            }
            com.facebook.common.c.a.a(lCO, "Found entry in disk cache for %s", bVar.dhC());
            this.lMm.dlJ();
            InputStream dhB = d.dhB();
            PooledByteBuffer c = this.lLT.c(dhB, (int) d.size());
            dhB.close();
            com.facebook.common.c.a.a(lCO, "Successful read from disk cache for %s", bVar.dhC());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lCO, e, "Exception reading from cache for %s", bVar.dhC());
            this.lMm.dlL();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lCO, "About to write to disk-cache for key %s", bVar.dhC());
        try {
            this.lMh.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lMi.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lCO, "Successful disk-cache write for key %s", bVar.dhC());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lCO, e, "Failed to write to disk-cache for key %s", bVar.dhC());
        }
    }
}

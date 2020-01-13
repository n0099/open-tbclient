package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public class e {
    private static final Class<?> lGm = e.class;
    private final com.facebook.common.memory.g lPE;
    private final com.facebook.cache.disk.h lPT;
    private final com.facebook.common.memory.j lPU;
    private final Executor lPV;
    private final Executor lPW;
    private final u lPX = u.dmS();
    private final n lPY;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lPT = hVar;
        this.lPE = gVar;
        this.lPU = jVar;
        this.lPV = executor;
        this.lPW = executor2;
        this.lPY = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lPX.u(bVar) || this.lPT.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dbx */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lPV);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGm, e, "Failed to schedule disk-cache read for %s", bVar.diD());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lPX.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lPX.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lGm, "Found image for %s in staging area", bVar.diD());
            this.lPY.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lGm, "Did not find image for %s in staging area", bVar.diD());
        this.lPY.dmN();
        try {
            return this.lPT.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dmC */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lPX.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lGm, "Found image for %s in staging area", bVar.diD());
                            e.this.lPY.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lGm, "Did not find image for %s in staging area", bVar.diD());
                            e.this.lPY.dmN();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lGm, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lPV);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGm, e, "Failed to schedule disk-cache read for %s", bVar.diD());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lPX.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lPW.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lPX.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGm, e, "Failed to schedule disk-cache write for %s", bVar.diD());
            this.lPX.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lPX.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lPX.s(bVar);
                    e.this.lPT.e(bVar);
                    return null;
                }
            }, this.lPW);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGm, e, "Failed to schedule disk-cache remove for %s", bVar.diD());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lGm, "Found image for %s in staging area", bVar.diD());
        this.lPY.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lGm, "Disk cache read for %s", bVar.diD());
            com.facebook.a.a d = this.lPT.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lGm, "Disk cache miss for %s", bVar.diD());
                this.lPY.dmP();
                return null;
            }
            com.facebook.common.c.a.a(lGm, "Found entry in disk cache for %s", bVar.diD());
            this.lPY.dmO();
            InputStream diC = d.diC();
            PooledByteBuffer c = this.lPE.c(diC, (int) d.size());
            diC.close();
            com.facebook.common.c.a.a(lGm, "Successful read from disk cache for %s", bVar.diD());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lGm, e, "Exception reading from cache for %s", bVar.diD());
            this.lPY.dmQ();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lGm, "About to write to disk-cache for key %s", bVar.diD());
        try {
            this.lPT.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lPU.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lGm, "Successful disk-cache write for key %s", bVar.diD());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lGm, e, "Failed to write to disk-cache for key %s", bVar.diD());
        }
    }
}

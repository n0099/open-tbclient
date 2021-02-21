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
    private static final Class<?> pyc = e.class;
    private final Executor pHA;
    private final u pHB = u.ewi();
    private final n pHC;
    private final com.facebook.common.memory.g pHk;
    private final com.facebook.cache.disk.h pHx;
    private final com.facebook.common.memory.j pHy;
    private final Executor pHz;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pHx = hVar;
        this.pHk = gVar;
        this.pHy = jVar;
        this.pHz = executor;
        this.pHA = executor2;
        this.pHC = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pHB.u(bVar) || this.pHx.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.i(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: evP */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pHz);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pyc, e, "Failed to schedule disk-cache read for %s", bVar.erU());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pHB.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pHB.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.c(pyc, "Found image for %s in staging area", bVar.erU());
            this.pHC.r(bVar);
            return true;
        }
        com.facebook.common.c.a.c(pyc, "Did not find image for %s in staging area", bVar.erU());
        this.pHC.ewd();
        try {
            return this.pHx.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: evQ */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pHB.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.c(e.pyc, "Found image for %s in staging area", bVar.erU());
                            e.this.pHC.r(bVar);
                        } else {
                            com.facebook.common.c.a.c(e.pyc, "Did not find image for %s in staging area", bVar.erU());
                            e.this.pHC.ewd();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.f(e.pyc, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pHz);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pyc, e, "Failed to schedule disk-cache read for %s", bVar.erU());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pHB.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pHA.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b2);
                    } finally {
                        e.this.pHB.d(bVar, b2);
                        com.facebook.imagepipeline.f.e.e(b2);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(pyc, e, "Failed to schedule disk-cache write for %s", bVar.erU());
            this.pHB.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b2);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pHB.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pHB.s(bVar);
                    e.this.pHx.e(bVar);
                    return null;
                }
            }, this.pHA);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pyc, e, "Failed to schedule disk-cache remove for %s", bVar.erU());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(pyc, "Found image for %s in staging area", bVar.erU());
        this.pHC.r(bVar);
        return bolts.g.i(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.c(pyc, "Disk cache read for %s", bVar.erU());
            com.facebook.a.a d = this.pHx.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.c(pyc, "Disk cache miss for %s", bVar.erU());
                this.pHC.ewf();
                return null;
            }
            com.facebook.common.c.a.c(pyc, "Found entry in disk cache for %s", bVar.erU());
            this.pHC.ewe();
            InputStream erT = d.erT();
            PooledByteBuffer b2 = this.pHk.b(erT, (int) d.size());
            erT.close();
            com.facebook.common.c.a.c(pyc, "Successful read from disk cache for %s", bVar.erU());
            return b2;
        } catch (IOException e) {
            com.facebook.common.c.a.a(pyc, e, "Exception reading from cache for %s", bVar.erU());
            this.pHC.ewg();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(pyc, "About to write to disk-cache for key %s", bVar.erU());
        try {
            this.pHx.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pHy.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.c(pyc, "Successful disk-cache write for key %s", bVar.erU());
        } catch (IOException e) {
            com.facebook.common.c.a.a(pyc, e, "Failed to write to disk-cache for key %s", bVar.erU());
        }
    }
}

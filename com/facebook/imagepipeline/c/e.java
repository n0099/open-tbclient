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
    private static final Class<?> lGr = e.class;
    private final com.facebook.common.memory.g lPJ;
    private final com.facebook.cache.disk.h lPY;
    private final com.facebook.common.memory.j lPZ;
    private final Executor lQa;
    private final Executor lQb;
    private final u lQc = u.dmU();
    private final n lQd;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lPY = hVar;
        this.lPJ = gVar;
        this.lPZ = jVar;
        this.lQa = executor;
        this.lQb = executor2;
        this.lQd = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lQc.u(bVar) || this.lPY.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dbz */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lQa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGr, e, "Failed to schedule disk-cache read for %s", bVar.diF());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lQc.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lQc.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lGr, "Found image for %s in staging area", bVar.diF());
            this.lQd.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lGr, "Did not find image for %s in staging area", bVar.diF());
        this.lQd.dmP();
        try {
            return this.lPY.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dmE */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lQc.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lGr, "Found image for %s in staging area", bVar.diF());
                            e.this.lQd.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lGr, "Did not find image for %s in staging area", bVar.diF());
                            e.this.lQd.dmP();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lGr, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lQa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGr, e, "Failed to schedule disk-cache read for %s", bVar.diF());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lQc.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lQb.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lQc.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGr, e, "Failed to schedule disk-cache write for %s", bVar.diF());
            this.lQc.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lQc.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lQc.s(bVar);
                    e.this.lPY.e(bVar);
                    return null;
                }
            }, this.lQb);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGr, e, "Failed to schedule disk-cache remove for %s", bVar.diF());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lGr, "Found image for %s in staging area", bVar.diF());
        this.lQd.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lGr, "Disk cache read for %s", bVar.diF());
            com.facebook.a.a d = this.lPY.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lGr, "Disk cache miss for %s", bVar.diF());
                this.lQd.dmR();
                return null;
            }
            com.facebook.common.c.a.a(lGr, "Found entry in disk cache for %s", bVar.diF());
            this.lQd.dmQ();
            InputStream diE = d.diE();
            PooledByteBuffer c = this.lPJ.c(diE, (int) d.size());
            diE.close();
            com.facebook.common.c.a.a(lGr, "Successful read from disk cache for %s", bVar.diF());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lGr, e, "Exception reading from cache for %s", bVar.diF());
            this.lQd.dmS();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lGr, "About to write to disk-cache for key %s", bVar.diF());
        try {
            this.lPY.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lPZ.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lGr, "Successful disk-cache write for key %s", bVar.diF());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lGr, e, "Failed to write to disk-cache for key %s", bVar.diF());
        }
    }
}

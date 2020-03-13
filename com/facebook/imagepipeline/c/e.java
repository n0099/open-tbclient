package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes12.dex */
public class e {
    private static final Class<?> lHl = e.class;
    private final com.facebook.common.memory.g lQD;
    private final com.facebook.cache.disk.h lQS;
    private final com.facebook.common.memory.j lQT;
    private final Executor lQU;
    private final Executor lQV;
    private final u lQW = u.dok();
    private final n lQX;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lQS = hVar;
        this.lQD = gVar;
        this.lQT = jVar;
        this.lQU = executor;
        this.lQV = executor2;
        this.lQX = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lQW.u(bVar) || this.lQS.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dcQ */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lQU);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHl, e, "Failed to schedule disk-cache read for %s", bVar.djV());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lQW.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lQW.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lHl, "Found image for %s in staging area", bVar.djV());
            this.lQX.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lHl, "Did not find image for %s in staging area", bVar.djV());
        this.lQX.dof();
        try {
            return this.lQS.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dnU */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lQW.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lHl, "Found image for %s in staging area", bVar.djV());
                            e.this.lQX.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lHl, "Did not find image for %s in staging area", bVar.djV());
                            e.this.lQX.dof();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lHl, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lQU);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHl, e, "Failed to schedule disk-cache read for %s", bVar.djV());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lQW.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lQV.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lQW.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHl, e, "Failed to schedule disk-cache write for %s", bVar.djV());
            this.lQW.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lQW.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lQW.s(bVar);
                    e.this.lQS.e(bVar);
                    return null;
                }
            }, this.lQV);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHl, e, "Failed to schedule disk-cache remove for %s", bVar.djV());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lHl, "Found image for %s in staging area", bVar.djV());
        this.lQX.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lHl, "Disk cache read for %s", bVar.djV());
            com.facebook.a.a d = this.lQS.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lHl, "Disk cache miss for %s", bVar.djV());
                this.lQX.doh();
                return null;
            }
            com.facebook.common.c.a.a(lHl, "Found entry in disk cache for %s", bVar.djV());
            this.lQX.dog();
            InputStream djU = d.djU();
            PooledByteBuffer c = this.lQD.c(djU, (int) d.size());
            djU.close();
            com.facebook.common.c.a.a(lHl, "Successful read from disk cache for %s", bVar.djV());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lHl, e, "Exception reading from cache for %s", bVar.djV());
            this.lQX.doi();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lHl, "About to write to disk-cache for key %s", bVar.djV());
        try {
            this.lQS.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lQT.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lHl, "Successful disk-cache write for key %s", bVar.djV());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lHl, e, "Failed to write to disk-cache for key %s", bVar.djV());
        }
    }
}

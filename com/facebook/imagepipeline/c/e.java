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
    private static final Class<?> lIR = e.class;
    private final Executor lSA;
    private final Executor lSB;
    private final u lSC = u.doH();
    private final n lSD;
    private final com.facebook.common.memory.g lSj;
    private final com.facebook.cache.disk.h lSy;
    private final com.facebook.common.memory.j lSz;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lSy = hVar;
        this.lSj = gVar;
        this.lSz = jVar;
        this.lSA = executor;
        this.lSB = executor2;
        this.lSD = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lSC.u(bVar) || this.lSy.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: ddn */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lSA);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lIR, e, "Failed to schedule disk-cache read for %s", bVar.dks());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lSC.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lSC.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lIR, "Found image for %s in staging area", bVar.dks());
            this.lSD.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lIR, "Did not find image for %s in staging area", bVar.dks());
        this.lSD.doC();
        try {
            return this.lSy.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dor */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lSC.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lIR, "Found image for %s in staging area", bVar.dks());
                            e.this.lSD.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lIR, "Did not find image for %s in staging area", bVar.dks());
                            e.this.lSD.doC();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lIR, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lSA);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lIR, e, "Failed to schedule disk-cache read for %s", bVar.dks());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lSC.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lSB.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lSC.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lIR, e, "Failed to schedule disk-cache write for %s", bVar.dks());
            this.lSC.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lSC.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lSC.s(bVar);
                    e.this.lSy.e(bVar);
                    return null;
                }
            }, this.lSB);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lIR, e, "Failed to schedule disk-cache remove for %s", bVar.dks());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lIR, "Found image for %s in staging area", bVar.dks());
        this.lSD.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lIR, "Disk cache read for %s", bVar.dks());
            com.facebook.a.a d = this.lSy.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lIR, "Disk cache miss for %s", bVar.dks());
                this.lSD.doE();
                return null;
            }
            com.facebook.common.c.a.a(lIR, "Found entry in disk cache for %s", bVar.dks());
            this.lSD.doD();
            InputStream dkr = d.dkr();
            PooledByteBuffer c = this.lSj.c(dkr, (int) d.size());
            dkr.close();
            com.facebook.common.c.a.a(lIR, "Successful read from disk cache for %s", bVar.dks());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lIR, e, "Exception reading from cache for %s", bVar.dks());
            this.lSD.doF();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lIR, "About to write to disk-cache for key %s", bVar.dks());
        try {
            this.lSy.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lSz.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lIR, "Successful disk-cache write for key %s", bVar.dks());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lIR, e, "Failed to write to disk-cache for key %s", bVar.dks());
        }
    }
}

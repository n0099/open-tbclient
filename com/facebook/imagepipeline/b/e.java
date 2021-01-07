package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class e {
    private static final Class<?> prR = e.class;
    private final com.facebook.common.memory.g pBc;
    private final com.facebook.cache.disk.h pBp;
    private final com.facebook.common.memory.j pBq;
    private final Executor pBr;
    private final Executor pBs;
    private final u pBt = u.exA();
    private final n pBu;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pBp = hVar;
        this.pBc = gVar;
        this.pBq = jVar;
        this.pBr = executor;
        this.pBs = executor2;
        this.pBu = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pBt.u(bVar) || this.pBp.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.i(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: exh */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pBr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(prR, e, "Failed to schedule disk-cache read for %s", bVar.etn());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pBt.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pBt.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.c(prR, "Found image for %s in staging area", bVar.etn());
            this.pBu.r(bVar);
            return true;
        }
        com.facebook.common.c.a.c(prR, "Did not find image for %s in staging area", bVar.etn());
        this.pBu.exv();
        try {
            return this.pBp.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: exi */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pBt.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.c(e.prR, "Found image for %s in staging area", bVar.etn());
                            e.this.pBu.r(bVar);
                        } else {
                            com.facebook.common.c.a.c(e.prR, "Did not find image for %s in staging area", bVar.etn());
                            e.this.pBu.exv();
                            try {
                                com.facebook.common.references.a f = com.facebook.common.references.a.f(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(f);
                                com.facebook.common.references.a.c(f);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.f(e.prR, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pBr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(prR, e, "Failed to schedule disk-cache read for %s", bVar.etn());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pBt.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b2 = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pBs.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b2);
                    } finally {
                        e.this.pBt.d(bVar, b2);
                        com.facebook.imagepipeline.f.e.e(b2);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(prR, e, "Failed to schedule disk-cache write for %s", bVar.etn());
            this.pBt.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b2);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pBt.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pBt.s(bVar);
                    e.this.pBp.e(bVar);
                    return null;
                }
            }, this.pBs);
        } catch (Exception e) {
            com.facebook.common.c.a.a(prR, e, "Failed to schedule disk-cache remove for %s", bVar.etn());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(prR, "Found image for %s in staging area", bVar.etn());
        this.pBu.r(bVar);
        return bolts.g.i(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.c(prR, "Disk cache read for %s", bVar.etn());
            com.facebook.a.a d = this.pBp.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.c(prR, "Disk cache miss for %s", bVar.etn());
                this.pBu.exx();
                return null;
            }
            com.facebook.common.c.a.c(prR, "Found entry in disk cache for %s", bVar.etn());
            this.pBu.exw();
            InputStream etm = d.etm();
            PooledByteBuffer b2 = this.pBc.b(etm, (int) d.size());
            etm.close();
            com.facebook.common.c.a.c(prR, "Successful read from disk cache for %s", bVar.etn());
            return b2;
        } catch (IOException e) {
            com.facebook.common.c.a.a(prR, e, "Exception reading from cache for %s", bVar.etn());
            this.pBu.exy();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.c(prR, "About to write to disk-cache for key %s", bVar.etn());
        try {
            this.pBp.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pBq.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.c(prR, "Successful disk-cache write for key %s", bVar.etn());
        } catch (IOException e) {
            com.facebook.common.c.a.a(prR, e, "Failed to write to disk-cache for key %s", bVar.etn());
        }
    }
}

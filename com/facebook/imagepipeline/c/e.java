package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes18.dex */
public class e {
    private static final Class<?> nJf = e.class;
    private final com.facebook.common.memory.g nSK;
    private final com.facebook.cache.disk.h nSY;
    private final com.facebook.common.memory.j nSZ;
    private final Executor nTa;
    private final Executor nTb;
    private final u nTc = u.dZU();
    private final n nTd;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.nSY = hVar;
        this.nSK = gVar;
        this.nSZ = jVar;
        this.nTa = executor;
        this.nTb = executor2;
        this.nTd = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.nTc.u(bVar) || this.nSY.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.l(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.nTa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(nJf, e, "Failed to schedule disk-cache read for %s", bVar.dVB());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.nTc.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.nTc.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(nJf, "Found image for %s in staging area", bVar.dVB());
            this.nTd.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(nJf, "Did not find image for %s in staging area", bVar.dVB());
        this.nTd.dZP();
        try {
            return this.nSY.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dZC */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.nTc.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.nJf, "Found image for %s in staging area", bVar.dVB());
                            e.this.nTd.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.nJf, "Did not find image for %s in staging area", bVar.dVB());
                            e.this.nTd.dZP();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.nJf, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.nTa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(nJf, e, "Failed to schedule disk-cache read for %s", bVar.dVB());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.nTc.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.nTb.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.nTc.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(nJf, e, "Failed to schedule disk-cache write for %s", bVar.dVB());
            this.nTc.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.nTc.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.nTc.s(bVar);
                    e.this.nSY.e(bVar);
                    return null;
                }
            }, this.nTb);
        } catch (Exception e) {
            com.facebook.common.c.a.a(nJf, e, "Failed to schedule disk-cache remove for %s", bVar.dVB());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(nJf, "Found image for %s in staging area", bVar.dVB());
        this.nTd.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(nJf, "Disk cache read for %s", bVar.dVB());
            com.facebook.a.a d = this.nSY.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(nJf, "Disk cache miss for %s", bVar.dVB());
                this.nTd.dZR();
                return null;
            }
            com.facebook.common.c.a.a(nJf, "Found entry in disk cache for %s", bVar.dVB());
            this.nTd.dZQ();
            InputStream dVA = d.dVA();
            PooledByteBuffer b = this.nSK.b(dVA, (int) d.size());
            dVA.close();
            com.facebook.common.c.a.a(nJf, "Successful read from disk cache for %s", bVar.dVB());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(nJf, e, "Exception reading from cache for %s", bVar.dVB());
            this.nTd.dZS();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(nJf, "About to write to disk-cache for key %s", bVar.dVB());
        try {
            this.nSY.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.nSZ.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(nJf, "Successful disk-cache write for key %s", bVar.dVB());
        } catch (IOException e) {
            com.facebook.common.c.a.a(nJf, e, "Failed to write to disk-cache for key %s", bVar.dVB());
        }
    }
}

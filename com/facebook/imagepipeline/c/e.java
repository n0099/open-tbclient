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
    private static final Class<?> mki = e.class;
    private final com.facebook.common.memory.g mtR;
    private final com.facebook.cache.disk.h muf;
    private final com.facebook.common.memory.j mug;
    private final Executor muh;
    private final Executor mui;
    private final u muj = u.dxW();
    private final n muk;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.muf = hVar;
        this.mtR = gVar;
        this.mug = jVar;
        this.muh = executor;
        this.mui = executor2;
        this.muk = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.muj.u(bVar) || this.muf.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.k(true) : l(bVar);
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
            }, this.muh);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mki, e, "Failed to schedule disk-cache read for %s", bVar.dtB());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.muj.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.muj.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(mki, "Found image for %s in staging area", bVar.dtB());
            this.muk.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(mki, "Did not find image for %s in staging area", bVar.dtB());
        this.muk.dxR();
        try {
            return this.muf.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dxE */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.muj.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.mki, "Found image for %s in staging area", bVar.dtB());
                            e.this.muk.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.mki, "Did not find image for %s in staging area", bVar.dtB());
                            e.this.muk.dxR();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.mki, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.muh);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mki, e, "Failed to schedule disk-cache read for %s", bVar.dtB());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.muj.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mui.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.muj.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(mki, e, "Failed to schedule disk-cache write for %s", bVar.dtB());
            this.muj.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.muj.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.muj.s(bVar);
                    e.this.muf.e(bVar);
                    return null;
                }
            }, this.mui);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mki, e, "Failed to schedule disk-cache remove for %s", bVar.dtB());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mki, "Found image for %s in staging area", bVar.dtB());
        this.muk.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(mki, "Disk cache read for %s", bVar.dtB());
            com.facebook.a.a d = this.muf.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(mki, "Disk cache miss for %s", bVar.dtB());
                this.muk.dxT();
                return null;
            }
            com.facebook.common.c.a.a(mki, "Found entry in disk cache for %s", bVar.dtB());
            this.muk.dxS();
            InputStream dtA = d.dtA();
            PooledByteBuffer c = this.mtR.c(dtA, (int) d.size());
            dtA.close();
            com.facebook.common.c.a.a(mki, "Successful read from disk cache for %s", bVar.dtB());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(mki, e, "Exception reading from cache for %s", bVar.dtB());
            this.muk.dxU();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mki, "About to write to disk-cache for key %s", bVar.dtB());
        try {
            this.muf.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.mug.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(mki, "Successful disk-cache write for key %s", bVar.dtB());
        } catch (IOException e) {
            com.facebook.common.c.a.a(mki, e, "Failed to write to disk-cache for key %s", bVar.dtB());
        }
    }
}

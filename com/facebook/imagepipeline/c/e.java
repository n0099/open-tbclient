package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public class e {
    private static final Class<?> mPz = e.class;
    private final com.facebook.cache.disk.h mZA;
    private final com.facebook.common.memory.j mZB;
    private final Executor mZC;
    private final Executor mZD;
    private final u mZE = u.dGd();
    private final n mZF;
    private final com.facebook.common.memory.g mZm;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mZA = hVar;
        this.mZm = gVar;
        this.mZB = jVar;
        this.mZC = executor;
        this.mZD = executor2;
        this.mZF = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mZE.u(bVar) || this.mZA.f(bVar);
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
            }, this.mZC);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPz, e, "Failed to schedule disk-cache read for %s", bVar.dBJ());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mZE.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mZE.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(mPz, "Found image for %s in staging area", bVar.dBJ());
            this.mZF.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(mPz, "Did not find image for %s in staging area", bVar.dBJ());
        this.mZF.dFY();
        try {
            return this.mZA.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dFL */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mZE.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.mPz, "Found image for %s in staging area", bVar.dBJ());
                            e.this.mZF.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.mPz, "Did not find image for %s in staging area", bVar.dBJ());
                            e.this.mZF.dFY();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.mPz, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mZC);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPz, e, "Failed to schedule disk-cache read for %s", bVar.dBJ());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mZE.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mZD.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mZE.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPz, e, "Failed to schedule disk-cache write for %s", bVar.dBJ());
            this.mZE.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mZE.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mZE.s(bVar);
                    e.this.mZA.e(bVar);
                    return null;
                }
            }, this.mZD);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPz, e, "Failed to schedule disk-cache remove for %s", bVar.dBJ());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mPz, "Found image for %s in staging area", bVar.dBJ());
        this.mZF.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(mPz, "Disk cache read for %s", bVar.dBJ());
            com.facebook.a.a d = this.mZA.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(mPz, "Disk cache miss for %s", bVar.dBJ());
                this.mZF.dGa();
                return null;
            }
            com.facebook.common.c.a.a(mPz, "Found entry in disk cache for %s", bVar.dBJ());
            this.mZF.dFZ();
            InputStream dBI = d.dBI();
            PooledByteBuffer c = this.mZm.c(dBI, (int) d.size());
            dBI.close();
            com.facebook.common.c.a.a(mPz, "Successful read from disk cache for %s", bVar.dBJ());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(mPz, e, "Exception reading from cache for %s", bVar.dBJ());
            this.mZF.dGb();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mPz, "About to write to disk-cache for key %s", bVar.dBJ());
        try {
            this.mZA.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.mZB.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(mPz, "Successful disk-cache write for key %s", bVar.dBJ());
        } catch (IOException e) {
            com.facebook.common.c.a.a(mPz, e, "Failed to write to disk-cache for key %s", bVar.dBJ());
        }
    }
}

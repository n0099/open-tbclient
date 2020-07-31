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
    private static final Class<?> mPx = e.class;
    private final Executor mZA;
    private final Executor mZB;
    private final u mZC = u.dGc();
    private final n mZD;
    private final com.facebook.common.memory.g mZk;
    private final com.facebook.cache.disk.h mZy;
    private final com.facebook.common.memory.j mZz;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mZy = hVar;
        this.mZk = gVar;
        this.mZz = jVar;
        this.mZA = executor;
        this.mZB = executor2;
        this.mZD = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mZC.u(bVar) || this.mZy.f(bVar);
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
            }, this.mZA);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPx, e, "Failed to schedule disk-cache read for %s", bVar.dBI());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mZC.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mZC.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(mPx, "Found image for %s in staging area", bVar.dBI());
            this.mZD.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(mPx, "Did not find image for %s in staging area", bVar.dBI());
        this.mZD.dFX();
        try {
            return this.mZy.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dFK */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mZC.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.mPx, "Found image for %s in staging area", bVar.dBI());
                            e.this.mZD.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.mPx, "Did not find image for %s in staging area", bVar.dBI());
                            e.this.mZD.dFX();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.mPx, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mZA);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPx, e, "Failed to schedule disk-cache read for %s", bVar.dBI());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mZC.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mZB.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mZC.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPx, e, "Failed to schedule disk-cache write for %s", bVar.dBI());
            this.mZC.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mZC.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mZC.s(bVar);
                    e.this.mZy.e(bVar);
                    return null;
                }
            }, this.mZB);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mPx, e, "Failed to schedule disk-cache remove for %s", bVar.dBI());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mPx, "Found image for %s in staging area", bVar.dBI());
        this.mZD.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(mPx, "Disk cache read for %s", bVar.dBI());
            com.facebook.a.a d = this.mZy.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(mPx, "Disk cache miss for %s", bVar.dBI());
                this.mZD.dFZ();
                return null;
            }
            com.facebook.common.c.a.a(mPx, "Found entry in disk cache for %s", bVar.dBI());
            this.mZD.dFY();
            InputStream dBH = d.dBH();
            PooledByteBuffer c = this.mZk.c(dBH, (int) d.size());
            dBH.close();
            com.facebook.common.c.a.a(mPx, "Successful read from disk cache for %s", bVar.dBI());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(mPx, e, "Exception reading from cache for %s", bVar.dBI());
            this.mZD.dGa();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mPx, "About to write to disk-cache for key %s", bVar.dBI());
        try {
            this.mZy.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.mZz.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(mPx, "Successful disk-cache write for key %s", bVar.dBI());
        } catch (IOException e) {
            com.facebook.common.c.a.a(mPx, e, "Failed to write to disk-cache for key %s", bVar.dBI());
        }
    }
}

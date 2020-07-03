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
    private static final Class<?> mHo = e.class;
    private final com.facebook.common.memory.g mQZ;
    private final com.facebook.cache.disk.h mRo;
    private final com.facebook.common.memory.j mRp;
    private final Executor mRq;
    private final Executor mRr;
    private final u mRs = u.dCM();
    private final n mRt;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mRo = hVar;
        this.mQZ = gVar;
        this.mRp = jVar;
        this.mRq = executor;
        this.mRr = executor2;
        this.mRt = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mRs.u(bVar) || this.mRo.f(bVar);
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
            }, this.mRq);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHo, e, "Failed to schedule disk-cache read for %s", bVar.dys());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mRs.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mRs.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(mHo, "Found image for %s in staging area", bVar.dys());
            this.mRt.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(mHo, "Did not find image for %s in staging area", bVar.dys());
        this.mRt.dCH();
        try {
            return this.mRo.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dCu */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mRs.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.mHo, "Found image for %s in staging area", bVar.dys());
                            e.this.mRt.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.mHo, "Did not find image for %s in staging area", bVar.dys());
                            e.this.mRt.dCH();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.mHo, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mRq);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHo, e, "Failed to schedule disk-cache read for %s", bVar.dys());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mRs.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mRr.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mRs.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHo, e, "Failed to schedule disk-cache write for %s", bVar.dys());
            this.mRs.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mRs.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mRs.s(bVar);
                    e.this.mRo.e(bVar);
                    return null;
                }
            }, this.mRr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHo, e, "Failed to schedule disk-cache remove for %s", bVar.dys());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mHo, "Found image for %s in staging area", bVar.dys());
        this.mRt.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(mHo, "Disk cache read for %s", bVar.dys());
            com.facebook.a.a d = this.mRo.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(mHo, "Disk cache miss for %s", bVar.dys());
                this.mRt.dCJ();
                return null;
            }
            com.facebook.common.c.a.a(mHo, "Found entry in disk cache for %s", bVar.dys());
            this.mRt.dCI();
            InputStream dyr = d.dyr();
            PooledByteBuffer c = this.mQZ.c(dyr, (int) d.size());
            dyr.close();
            com.facebook.common.c.a.a(mHo, "Successful read from disk cache for %s", bVar.dys());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(mHo, e, "Exception reading from cache for %s", bVar.dys());
            this.mRt.dCK();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mHo, "About to write to disk-cache for key %s", bVar.dys());
        try {
            this.mRo.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.mRp.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(mHo, "Successful disk-cache write for key %s", bVar.dys());
        } catch (IOException e) {
            com.facebook.common.c.a.a(mHo, e, "Failed to write to disk-cache for key %s", bVar.dys());
        }
    }
}

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
    private static final Class<?> mHr = e.class;
    private final com.facebook.common.memory.g mRd;
    private final com.facebook.cache.disk.h mRr;
    private final com.facebook.common.memory.j mRs;
    private final Executor mRt;
    private final Executor mRu;
    private final u mRv = u.dCQ();
    private final n mRw;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mRr = hVar;
        this.mRd = gVar;
        this.mRs = jVar;
        this.mRt = executor;
        this.mRu = executor2;
        this.mRw = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mRv.u(bVar) || this.mRr.f(bVar);
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
            }, this.mRt);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHr, e, "Failed to schedule disk-cache read for %s", bVar.dyw());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mRv.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mRv.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(mHr, "Found image for %s in staging area", bVar.dyw());
            this.mRw.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(mHr, "Did not find image for %s in staging area", bVar.dyw());
        this.mRw.dCL();
        try {
            return this.mRr.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dCy */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mRv.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.mHr, "Found image for %s in staging area", bVar.dyw());
                            e.this.mRw.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.mHr, "Did not find image for %s in staging area", bVar.dyw());
                            e.this.mRw.dCL();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.mHr, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mRt);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHr, e, "Failed to schedule disk-cache read for %s", bVar.dyw());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mRv.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mRu.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mRv.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHr, e, "Failed to schedule disk-cache write for %s", bVar.dyw());
            this.mRv.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mRv.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mRv.s(bVar);
                    e.this.mRr.e(bVar);
                    return null;
                }
            }, this.mRu);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mHr, e, "Failed to schedule disk-cache remove for %s", bVar.dyw());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mHr, "Found image for %s in staging area", bVar.dyw());
        this.mRw.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(mHr, "Disk cache read for %s", bVar.dyw());
            com.facebook.a.a d = this.mRr.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(mHr, "Disk cache miss for %s", bVar.dyw());
                this.mRw.dCN();
                return null;
            }
            com.facebook.common.c.a.a(mHr, "Found entry in disk cache for %s", bVar.dyw());
            this.mRw.dCM();
            InputStream dyv = d.dyv();
            PooledByteBuffer c = this.mRd.c(dyv, (int) d.size());
            dyv.close();
            com.facebook.common.c.a.a(mHr, "Successful read from disk cache for %s", bVar.dyw());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(mHr, e, "Exception reading from cache for %s", bVar.dyw());
            this.mRw.dCO();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mHr, "About to write to disk-cache for key %s", bVar.dyw());
        try {
            this.mRr.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.mRs.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(mHr, "Successful disk-cache write for key %s", bVar.dyw());
        } catch (IOException e) {
            com.facebook.common.c.a.a(mHr, e, "Failed to write to disk-cache for key %s", bVar.dyw());
        }
    }
}

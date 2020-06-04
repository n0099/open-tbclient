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
    private static final Class<?> mls = e.class;
    private final com.facebook.common.memory.g mvb;
    private final com.facebook.cache.disk.h mvp;
    private final com.facebook.common.memory.j mvq;
    private final Executor mvr;
    private final Executor mvs;
    private final u mvt = u.dyk();
    private final n mvu;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mvp = hVar;
        this.mvb = gVar;
        this.mvq = jVar;
        this.mvr = executor;
        this.mvs = executor2;
        this.mvu = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mvt.u(bVar) || this.mvp.f(bVar);
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
            }, this.mvr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mls, e, "Failed to schedule disk-cache read for %s", bVar.dtP());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mvt.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mvt.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(mls, "Found image for %s in staging area", bVar.dtP());
            this.mvu.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(mls, "Did not find image for %s in staging area", bVar.dtP());
        this.mvu.dyf();
        try {
            return this.mvp.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dxS */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mvt.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.mls, "Found image for %s in staging area", bVar.dtP());
                            e.this.mvu.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.mls, "Did not find image for %s in staging area", bVar.dtP());
                            e.this.mvu.dyf();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.mls, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mvr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mls, e, "Failed to schedule disk-cache read for %s", bVar.dtP());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mvt.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mvs.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mvt.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(mls, e, "Failed to schedule disk-cache write for %s", bVar.dtP());
            this.mvt.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mvt.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mvt.s(bVar);
                    e.this.mvp.e(bVar);
                    return null;
                }
            }, this.mvs);
        } catch (Exception e) {
            com.facebook.common.c.a.a(mls, e, "Failed to schedule disk-cache remove for %s", bVar.dtP());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mls, "Found image for %s in staging area", bVar.dtP());
        this.mvu.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(mls, "Disk cache read for %s", bVar.dtP());
            com.facebook.a.a d = this.mvp.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(mls, "Disk cache miss for %s", bVar.dtP());
                this.mvu.dyh();
                return null;
            }
            com.facebook.common.c.a.a(mls, "Found entry in disk cache for %s", bVar.dtP());
            this.mvu.dyg();
            InputStream dtO = d.dtO();
            PooledByteBuffer c = this.mvb.c(dtO, (int) d.size());
            dtO.close();
            com.facebook.common.c.a.a(mls, "Successful read from disk cache for %s", bVar.dtP());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(mls, e, "Exception reading from cache for %s", bVar.dtP());
            this.mvu.dyi();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(mls, "About to write to disk-cache for key %s", bVar.dtP());
        try {
            this.mvp.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.mvq.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(mls, "Successful disk-cache write for key %s", bVar.dtP());
        } catch (IOException e) {
            com.facebook.common.c.a.a(mls, e, "Failed to write to disk-cache for key %s", bVar.dtP());
        }
    }
}

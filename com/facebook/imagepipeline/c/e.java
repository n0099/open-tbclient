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
    private static final Class<?> oAy = e.class;
    private final com.facebook.common.memory.g oKc;
    private final com.facebook.cache.disk.h oKq;
    private final com.facebook.common.memory.j oKr;
    private final Executor oKs;
    private final Executor oKt;
    private final u oKu = u.ejS();
    private final n oKv;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.oKq = hVar;
        this.oKc = gVar;
        this.oKr = jVar;
        this.oKs = executor;
        this.oKt = executor2;
        this.oKv = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.oKu.u(bVar) || this.oKq.f(bVar);
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
            }, this.oKs);
        } catch (Exception e) {
            com.facebook.common.c.a.a(oAy, e, "Failed to schedule disk-cache read for %s", bVar.efz());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.oKu.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.oKu.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(oAy, "Found image for %s in staging area", bVar.efz());
            this.oKv.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(oAy, "Did not find image for %s in staging area", bVar.efz());
        this.oKv.ejN();
        try {
            return this.oKq.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: ejA */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.oKu.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.oAy, "Found image for %s in staging area", bVar.efz());
                            e.this.oKv.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.oAy, "Did not find image for %s in staging area", bVar.efz());
                            e.this.oKv.ejN();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.oAy, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.oKs);
        } catch (Exception e) {
            com.facebook.common.c.a.a(oAy, e, "Failed to schedule disk-cache read for %s", bVar.efz());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.oKu.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.oKt.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.oKu.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(oAy, e, "Failed to schedule disk-cache write for %s", bVar.efz());
            this.oKu.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.oKu.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.oKu.s(bVar);
                    e.this.oKq.e(bVar);
                    return null;
                }
            }, this.oKt);
        } catch (Exception e) {
            com.facebook.common.c.a.a(oAy, e, "Failed to schedule disk-cache remove for %s", bVar.efz());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(oAy, "Found image for %s in staging area", bVar.efz());
        this.oKv.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(oAy, "Disk cache read for %s", bVar.efz());
            com.facebook.a.a d = this.oKq.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(oAy, "Disk cache miss for %s", bVar.efz());
                this.oKv.ejP();
                return null;
            }
            com.facebook.common.c.a.a(oAy, "Found entry in disk cache for %s", bVar.efz());
            this.oKv.ejO();
            InputStream efy = d.efy();
            PooledByteBuffer b = this.oKc.b(efy, (int) d.size());
            efy.close();
            com.facebook.common.c.a.a(oAy, "Successful read from disk cache for %s", bVar.efz());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(oAy, e, "Exception reading from cache for %s", bVar.efz());
            this.oKv.ejQ();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(oAy, "About to write to disk-cache for key %s", bVar.efz());
        try {
            this.oKq.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.oKr.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(oAy, "Successful disk-cache write for key %s", bVar.efz());
        } catch (IOException e) {
            com.facebook.common.c.a.a(oAy, e, "Failed to write to disk-cache for key %s", bVar.efz());
        }
    }
}

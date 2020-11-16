package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class e {
    private static final Class<?> oLv = e.class;
    private final com.facebook.common.memory.g oUY;
    private final com.facebook.cache.disk.h oVm;
    private final com.facebook.common.memory.j oVn;
    private final Executor oVo;
    private final Executor oVp;
    private final u oVq = u.enG();
    private final n oVr;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.oVm = hVar;
        this.oUY = gVar;
        this.oVn = jVar;
        this.oVo = executor;
        this.oVp = executor2;
        this.oVr = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.oVq.u(bVar) || this.oVm.f(bVar);
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
            }, this.oVo);
        } catch (Exception e) {
            com.facebook.common.c.a.a(oLv, e, "Failed to schedule disk-cache read for %s", bVar.ejm());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.oVq.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.oVq.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(oLv, "Found image for %s in staging area", bVar.ejm());
            this.oVr.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(oLv, "Did not find image for %s in staging area", bVar.ejm());
        this.oVr.enB();
        try {
            return this.oVm.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: eno */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.oVq.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.oLv, "Found image for %s in staging area", bVar.ejm());
                            e.this.oVr.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.oLv, "Did not find image for %s in staging area", bVar.ejm());
                            e.this.oVr.enB();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.oLv, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.oVo);
        } catch (Exception e) {
            com.facebook.common.c.a.a(oLv, e, "Failed to schedule disk-cache read for %s", bVar.ejm());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.oVq.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.oVp.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.oVq.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(oLv, e, "Failed to schedule disk-cache write for %s", bVar.ejm());
            this.oVq.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.oVq.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.oVq.s(bVar);
                    e.this.oVm.e(bVar);
                    return null;
                }
            }, this.oVp);
        } catch (Exception e) {
            com.facebook.common.c.a.a(oLv, e, "Failed to schedule disk-cache remove for %s", bVar.ejm());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(oLv, "Found image for %s in staging area", bVar.ejm());
        this.oVr.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(oLv, "Disk cache read for %s", bVar.ejm());
            com.facebook.a.a d = this.oVm.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(oLv, "Disk cache miss for %s", bVar.ejm());
                this.oVr.enD();
                return null;
            }
            com.facebook.common.c.a.a(oLv, "Found entry in disk cache for %s", bVar.ejm());
            this.oVr.enC();
            InputStream ejl = d.ejl();
            PooledByteBuffer b = this.oUY.b(ejl, (int) d.size());
            ejl.close();
            com.facebook.common.c.a.a(oLv, "Successful read from disk cache for %s", bVar.ejm());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(oLv, e, "Exception reading from cache for %s", bVar.ejm());
            this.oVr.enE();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(oLv, "About to write to disk-cache for key %s", bVar.ejm());
        try {
            this.oVm.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.oVn.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(oLv, "Successful disk-cache write for key %s", bVar.ejm());
        } catch (IOException e) {
            com.facebook.common.c.a.a(oLv, e, "Failed to write to disk-cache for key %s", bVar.ejm());
        }
    }
}

package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class e {
    private static final Class<?> njM = e.class;
    private final com.facebook.cache.disk.h ntH;
    private final com.facebook.common.memory.j ntI;
    private final Executor ntJ;
    private final Executor ntK;
    private final u ntL = u.dSl();
    private final n ntM;
    private final com.facebook.common.memory.g ntt;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.ntH = hVar;
        this.ntt = gVar;
        this.ntI = jVar;
        this.ntJ = executor;
        this.ntK = executor2;
        this.ntM = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.ntL.u(bVar) || this.ntH.f(bVar);
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
            }, this.ntJ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(njM, e, "Failed to schedule disk-cache read for %s", bVar.dNS());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.ntL.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.ntL.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(njM, "Found image for %s in staging area", bVar.dNS());
            this.ntM.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(njM, "Did not find image for %s in staging area", bVar.dNS());
        this.ntM.dSg();
        try {
            return this.ntH.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dRT */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.ntL.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.njM, "Found image for %s in staging area", bVar.dNS());
                            e.this.ntM.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.njM, "Did not find image for %s in staging area", bVar.dNS());
                            e.this.ntM.dSg();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.njM, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.ntJ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(njM, e, "Failed to schedule disk-cache read for %s", bVar.dNS());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.ntL.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.ntK.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.ntL.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(njM, e, "Failed to schedule disk-cache write for %s", bVar.dNS());
            this.ntL.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.ntL.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.ntL.s(bVar);
                    e.this.ntH.e(bVar);
                    return null;
                }
            }, this.ntK);
        } catch (Exception e) {
            com.facebook.common.c.a.a(njM, e, "Failed to schedule disk-cache remove for %s", bVar.dNS());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(njM, "Found image for %s in staging area", bVar.dNS());
        this.ntM.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(njM, "Disk cache read for %s", bVar.dNS());
            com.facebook.a.a d = this.ntH.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(njM, "Disk cache miss for %s", bVar.dNS());
                this.ntM.dSi();
                return null;
            }
            com.facebook.common.c.a.a(njM, "Found entry in disk cache for %s", bVar.dNS());
            this.ntM.dSh();
            InputStream dNR = d.dNR();
            PooledByteBuffer b = this.ntt.b(dNR, (int) d.size());
            dNR.close();
            com.facebook.common.c.a.a(njM, "Successful read from disk cache for %s", bVar.dNS());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(njM, e, "Exception reading from cache for %s", bVar.dNS());
            this.ntM.dSj();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(njM, "About to write to disk-cache for key %s", bVar.dNS());
        try {
            this.ntH.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.ntI.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(njM, "Successful disk-cache write for key %s", bVar.dNS());
        } catch (IOException e) {
            com.facebook.common.c.a.a(njM, e, "Failed to write to disk-cache for key %s", bVar.dNS());
        }
    }
}

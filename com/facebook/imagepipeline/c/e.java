package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes25.dex */
public class e {
    private static final Class<?> ntL = e.class;
    private final com.facebook.cache.disk.h nDF;
    private final com.facebook.common.memory.j nDG;
    private final Executor nDH;
    private final Executor nDI;
    private final u nDJ = u.dWj();
    private final n nDK;
    private final com.facebook.common.memory.g nDr;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.nDF = hVar;
        this.nDr = gVar;
        this.nDG = jVar;
        this.nDH = executor;
        this.nDI = executor2;
        this.nDK = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.nDJ.u(bVar) || this.nDF.f(bVar);
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
            }, this.nDH);
        } catch (Exception e) {
            com.facebook.common.c.a.a(ntL, e, "Failed to schedule disk-cache read for %s", bVar.dRQ());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.nDJ.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.nDJ.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(ntL, "Found image for %s in staging area", bVar.dRQ());
            this.nDK.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(ntL, "Did not find image for %s in staging area", bVar.dRQ());
        this.nDK.dWe();
        try {
            return this.nDF.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dVR */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.nDJ.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.ntL, "Found image for %s in staging area", bVar.dRQ());
                            e.this.nDK.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.ntL, "Did not find image for %s in staging area", bVar.dRQ());
                            e.this.nDK.dWe();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.ntL, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.nDH);
        } catch (Exception e) {
            com.facebook.common.c.a.a(ntL, e, "Failed to schedule disk-cache read for %s", bVar.dRQ());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.nDJ.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.nDI.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.nDJ.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(ntL, e, "Failed to schedule disk-cache write for %s", bVar.dRQ());
            this.nDJ.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.nDJ.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.nDJ.s(bVar);
                    e.this.nDF.e(bVar);
                    return null;
                }
            }, this.nDI);
        } catch (Exception e) {
            com.facebook.common.c.a.a(ntL, e, "Failed to schedule disk-cache remove for %s", bVar.dRQ());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(ntL, "Found image for %s in staging area", bVar.dRQ());
        this.nDK.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(ntL, "Disk cache read for %s", bVar.dRQ());
            com.facebook.a.a d = this.nDF.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(ntL, "Disk cache miss for %s", bVar.dRQ());
                this.nDK.dWg();
                return null;
            }
            com.facebook.common.c.a.a(ntL, "Found entry in disk cache for %s", bVar.dRQ());
            this.nDK.dWf();
            InputStream dRP = d.dRP();
            PooledByteBuffer b = this.nDr.b(dRP, (int) d.size());
            dRP.close();
            com.facebook.common.c.a.a(ntL, "Successful read from disk cache for %s", bVar.dRQ());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(ntL, e, "Exception reading from cache for %s", bVar.dRQ());
            this.nDK.dWh();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(ntL, "About to write to disk-cache for key %s", bVar.dRQ());
        try {
            this.nDF.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.nDG.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(ntL, "Successful disk-cache write for key %s", bVar.dRQ());
        } catch (IOException e) {
            com.facebook.common.c.a.a(ntL, e, "Failed to write to disk-cache for key %s", bVar.dRQ());
        }
    }
}

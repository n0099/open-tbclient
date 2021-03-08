package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class e {
    private static final Class<?> pAh = e.class;
    private final com.facebook.cache.disk.h pJC;
    private final com.facebook.common.memory.j pJD;
    private final Executor pJE;
    private final Executor pJF;
    private final u pJG = u.ewr();
    private final n pJH;
    private final com.facebook.common.memory.g pJp;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pJC = hVar;
        this.pJp = gVar;
        this.pJD = jVar;
        this.pJE = executor;
        this.pJF = executor2;
        this.pJH = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pJG.u(bVar) || this.pJC.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.k(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: evY */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pJE);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pAh, e, "Failed to schedule disk-cache read for %s", bVar.esd());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pJG.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pJG.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(pAh, "Found image for %s in staging area", bVar.esd());
            this.pJH.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(pAh, "Did not find image for %s in staging area", bVar.esd());
        this.pJH.ewm();
        try {
            return this.pJC.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: evZ */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pJG.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.pAh, "Found image for %s in staging area", bVar.esd());
                            e.this.pJH.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.pAh, "Did not find image for %s in staging area", bVar.esd());
                            e.this.pJH.ewm();
                            try {
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(d);
                                com.facebook.common.references.a.c(d);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.f(e.pAh, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pJE);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pAh, e, "Failed to schedule disk-cache read for %s", bVar.esd());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pJG.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pJF.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.pJG.d(bVar, b);
                        com.facebook.imagepipeline.f.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(pAh, e, "Failed to schedule disk-cache write for %s", bVar.esd());
            this.pJG.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pJG.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pJG.s(bVar);
                    e.this.pJC.e(bVar);
                    return null;
                }
            }, this.pJF);
        } catch (Exception e) {
            com.facebook.common.c.a.a(pAh, e, "Failed to schedule disk-cache remove for %s", bVar.esd());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.a(pAh, "Found image for %s in staging area", bVar.esd());
        this.pJH.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(pAh, "Disk cache read for %s", bVar.esd());
            com.facebook.a.a d = this.pJC.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(pAh, "Disk cache miss for %s", bVar.esd());
                this.pJH.ewo();
                return null;
            }
            com.facebook.common.c.a.a(pAh, "Found entry in disk cache for %s", bVar.esd());
            this.pJH.ewn();
            InputStream esc = d.esc();
            PooledByteBuffer b = this.pJp.b(esc, (int) d.size());
            esc.close();
            com.facebook.common.c.a.a(pAh, "Successful read from disk cache for %s", bVar.esd());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(pAh, e, "Exception reading from cache for %s", bVar.esd());
            this.pJH.ewp();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.a(pAh, "About to write to disk-cache for key %s", bVar.esd());
        try {
            this.pJC.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pJD.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(pAh, "Successful disk-cache write for key %s", bVar.esd());
        } catch (IOException e) {
            com.facebook.common.c.a.a(pAh, e, "Failed to write to disk-cache for key %s", bVar.esd());
        }
    }
}

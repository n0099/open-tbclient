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
    private static final Class<?> lGY = e.class;
    private final com.facebook.cache.disk.h lQF;
    private final com.facebook.common.memory.j lQG;
    private final Executor lQH;
    private final Executor lQI;
    private final u lQJ = u.doh();
    private final n lQK;
    private final com.facebook.common.memory.g lQq;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lQF = hVar;
        this.lQq = gVar;
        this.lQG = jVar;
        this.lQH = executor;
        this.lQI = executor2;
        this.lQK = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lQJ.u(bVar) || this.lQF.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dcN */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lQH);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGY, e, "Failed to schedule disk-cache read for %s", bVar.djS());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lQJ.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lQJ.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lGY, "Found image for %s in staging area", bVar.djS());
            this.lQK.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lGY, "Did not find image for %s in staging area", bVar.djS());
        this.lQK.doc();
        try {
            return this.lQF.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dnR */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lQJ.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lGY, "Found image for %s in staging area", bVar.djS());
                            e.this.lQK.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lGY, "Did not find image for %s in staging area", bVar.djS());
                            e.this.lQK.doc();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lGY, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lQH);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGY, e, "Failed to schedule disk-cache read for %s", bVar.djS());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lQJ.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lQI.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lQJ.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGY, e, "Failed to schedule disk-cache write for %s", bVar.djS());
            this.lQJ.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lQJ.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lQJ.s(bVar);
                    e.this.lQF.e(bVar);
                    return null;
                }
            }, this.lQI);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lGY, e, "Failed to schedule disk-cache remove for %s", bVar.djS());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lGY, "Found image for %s in staging area", bVar.djS());
        this.lQK.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lGY, "Disk cache read for %s", bVar.djS());
            com.facebook.a.a d = this.lQF.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lGY, "Disk cache miss for %s", bVar.djS());
                this.lQK.doe();
                return null;
            }
            com.facebook.common.c.a.a(lGY, "Found entry in disk cache for %s", bVar.djS());
            this.lQK.dod();
            InputStream djR = d.djR();
            PooledByteBuffer c = this.lQq.c(djR, (int) d.size());
            djR.close();
            com.facebook.common.c.a.a(lGY, "Successful read from disk cache for %s", bVar.djS());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lGY, e, "Exception reading from cache for %s", bVar.djS());
            this.lQK.dof();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lGY, "About to write to disk-cache for key %s", bVar.djS());
        try {
            this.lQF.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lQG.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lGY, "Successful disk-cache write for key %s", bVar.djS());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lGY, e, "Failed to write to disk-cache for key %s", bVar.djS());
        }
    }
}

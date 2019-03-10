package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class e {
    private static final Class<?> jyO = e.class;
    private final com.facebook.cache.disk.h jFM;
    private final com.facebook.common.memory.j jFN;
    private final Executor jFO;
    private final Executor jFP;
    private final ab jFQ = ab.cwK();
    private final o jFR;
    private final com.facebook.common.memory.g jFx;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.jFM = hVar;
        this.jFx = gVar;
        this.jFN = jVar;
        this.jFO = executor;
        this.jFP = executor2;
        this.jFR = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.jFQ.r(bVar) || this.jFM.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.f(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cwq */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.jFO);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jyO, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.jFQ.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.jFQ.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(jyO, "Found image for %s in staging area", bVar.getUriString());
            this.jFR.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(jyO, "Did not find image for %s in staging area", bVar.getUriString());
        this.jFR.cwE();
        try {
            return this.jFM.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cwr */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.jFQ.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.jyO, "Found image for %s in staging area", bVar.getUriString());
                            e.this.jFR.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.jyO, "Did not find image for %s in staging area", bVar.getUriString());
                            e.this.jFR.cwE();
                            try {
                                com.facebook.common.references.a d = com.facebook.common.references.a.d(e.this.m(bVar));
                                q = new com.facebook.imagepipeline.f.d(d);
                                q.t(bVar);
                                com.facebook.common.references.a.c(d);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.d(e.jyO, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.jFO);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jyO, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.jFQ.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.jFP.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.jFQ.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(jyO, e, "Failed to schedule disk-cache write for %s", bVar.getUriString());
            this.jFQ.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jyO, "Found image for %s in staging area", bVar.getUriString());
        this.jFR.p(bVar);
        return bolts.g.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(jyO, "Disk cache read for %s", bVar.getUriString());
            com.facebook.a.a d = this.jFM.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(jyO, "Disk cache miss for %s", bVar.getUriString());
                this.jFR.cwG();
                return null;
            }
            com.facebook.common.c.a.a(jyO, "Found entry in disk cache for %s", bVar.getUriString());
            this.jFR.cwF();
            InputStream openStream = d.openStream();
            PooledByteBuffer b = this.jFx.b(openStream, (int) d.size());
            openStream.close();
            com.facebook.common.c.a.a(jyO, "Successful read from disk cache for %s", bVar.getUriString());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(jyO, e, "Exception reading from cache for %s", bVar.getUriString());
            this.jFR.cwH();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jyO, "About to write to disk-cache for key %s", bVar.getUriString());
        try {
            this.jFM.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.jFN.g(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(jyO, "Successful disk-cache write for key %s", bVar.getUriString());
        } catch (IOException e) {
            com.facebook.common.c.a.a(jyO, e, "Failed to write to disk-cache for key %s", bVar.getUriString());
        }
    }
}

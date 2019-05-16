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
    private static final Class<?> jQR = e.class;
    private final com.facebook.cache.disk.h jXM;
    private final com.facebook.common.memory.j jXN;
    private final Executor jXO;
    private final Executor jXP;
    private final ab jXQ = ab.cEC();
    private final o jXR;
    private final com.facebook.common.memory.g jXx;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.jXM = hVar;
        this.jXx = gVar;
        this.jXN = jVar;
        this.jXO = executor;
        this.jXP = executor2;
        this.jXR = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.jXQ.r(bVar) || this.jXM.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.g(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cEi */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.jXO);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jQR, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.jXQ.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.jXQ.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(jQR, "Found image for %s in staging area", bVar.getUriString());
            this.jXR.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(jQR, "Did not find image for %s in staging area", bVar.getUriString());
        this.jXR.cEw();
        try {
            return this.jXM.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cEj */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.jXQ.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.jQR, "Found image for %s in staging area", bVar.getUriString());
                            e.this.jXR.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.jQR, "Did not find image for %s in staging area", bVar.getUriString());
                            e.this.jXR.cEw();
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
                            com.facebook.common.c.a.d(e.jQR, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.jXO);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jQR, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.jXQ.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.jXP.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.jXQ.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(jQR, e, "Failed to schedule disk-cache write for %s", bVar.getUriString());
            this.jXQ.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jQR, "Found image for %s in staging area", bVar.getUriString());
        this.jXR.p(bVar);
        return bolts.g.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(jQR, "Disk cache read for %s", bVar.getUriString());
            com.facebook.a.a d = this.jXM.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(jQR, "Disk cache miss for %s", bVar.getUriString());
                this.jXR.cEy();
                return null;
            }
            com.facebook.common.c.a.a(jQR, "Found entry in disk cache for %s", bVar.getUriString());
            this.jXR.cEx();
            InputStream openStream = d.openStream();
            PooledByteBuffer b = this.jXx.b(openStream, (int) d.size());
            openStream.close();
            com.facebook.common.c.a.a(jQR, "Successful read from disk cache for %s", bVar.getUriString());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(jQR, e, "Exception reading from cache for %s", bVar.getUriString());
            this.jXR.cEz();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jQR, "About to write to disk-cache for key %s", bVar.getUriString());
        try {
            this.jXM.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.jXN.g(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(jQR, "Successful disk-cache write for key %s", bVar.getUriString());
        } catch (IOException e) {
            com.facebook.common.c.a.a(jQR, e, "Failed to write to disk-cache for key %s", bVar.getUriString());
        }
    }
}

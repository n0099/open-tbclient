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
    private static final Class<?> jya = e.class;
    private final com.facebook.common.memory.g jEJ;
    private final com.facebook.cache.disk.h jEY;
    private final com.facebook.common.memory.j jEZ;
    private final Executor jFa;
    private final Executor jFb;
    private final ab jFc = ab.cwG();
    private final o jFd;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.jEY = hVar;
        this.jEJ = gVar;
        this.jEZ = jVar;
        this.jFa = executor;
        this.jFb = executor2;
        this.jFd = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.jFc.r(bVar) || this.jEY.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.f(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cwm */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.jFa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jya, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.jFc.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.jFc.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(jya, "Found image for %s in staging area", bVar.getUriString());
            this.jFd.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(jya, "Did not find image for %s in staging area", bVar.getUriString());
        this.jFd.cwA();
        try {
            return this.jEY.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cwn */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.jFc.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.jya, "Found image for %s in staging area", bVar.getUriString());
                            e.this.jFd.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.jya, "Did not find image for %s in staging area", bVar.getUriString());
                            e.this.jFd.cwA();
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
                            com.facebook.common.c.a.d(e.jya, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.jFa);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jya, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.jFc.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.jFb.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.jFc.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(jya, e, "Failed to schedule disk-cache write for %s", bVar.getUriString());
            this.jFc.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jya, "Found image for %s in staging area", bVar.getUriString());
        this.jFd.p(bVar);
        return bolts.g.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(jya, "Disk cache read for %s", bVar.getUriString());
            com.facebook.a.a d = this.jEY.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(jya, "Disk cache miss for %s", bVar.getUriString());
                this.jFd.cwC();
                return null;
            }
            com.facebook.common.c.a.a(jya, "Found entry in disk cache for %s", bVar.getUriString());
            this.jFd.cwB();
            InputStream openStream = d.openStream();
            PooledByteBuffer b = this.jEJ.b(openStream, (int) d.size());
            openStream.close();
            com.facebook.common.c.a.a(jya, "Successful read from disk cache for %s", bVar.getUriString());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(jya, e, "Exception reading from cache for %s", bVar.getUriString());
            this.jFd.cwD();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jya, "About to write to disk-cache for key %s", bVar.getUriString());
        try {
            this.jEY.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.jEZ.g(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(jya, "Successful disk-cache write for key %s", bVar.getUriString());
        } catch (IOException e) {
            com.facebook.common.c.a.a(jya, e, "Failed to write to disk-cache for key %s", bVar.getUriString());
        }
    }
}

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
    private static final Class<?> ihJ = e.class;
    private final com.facebook.cache.disk.h ioF;
    private final com.facebook.common.memory.j ioG;
    private final Executor ioH;
    private final Executor ioI;
    private final ab ioJ = ab.bWR();
    private final o ioK;
    private final com.facebook.common.memory.g ioq;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.ioF = hVar;
        this.ioq = gVar;
        this.ioG = jVar;
        this.ioH = executor;
        this.ioI = executor2;
        this.ioK = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.ioJ.r(bVar) || this.ioF.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.f(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: bWx */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.ioH);
        } catch (Exception e) {
            com.facebook.common.c.a.a(ihJ, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.ioJ.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.ioJ.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(ihJ, "Found image for %s in staging area", bVar.getUriString());
            this.ioK.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(ihJ, "Did not find image for %s in staging area", bVar.getUriString());
        this.ioK.bWL();
        try {
            return this.ioF.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: bWy */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.ioJ.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.ihJ, "Found image for %s in staging area", bVar.getUriString());
                            e.this.ioK.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.ihJ, "Did not find image for %s in staging area", bVar.getUriString());
                            e.this.ioK.bWL();
                            try {
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(e.this.m(bVar));
                                q = new com.facebook.imagepipeline.f.d(c);
                                q.t(bVar);
                                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.d(e.ihJ, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.ioH);
        } catch (Exception e) {
            com.facebook.common.c.a.a(ihJ, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.ioJ.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.ioI.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.ioJ.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(ihJ, e, "Failed to schedule disk-cache write for %s", bVar.getUriString());
            this.ioJ.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(ihJ, "Found image for %s in staging area", bVar.getUriString());
        this.ioK.p(bVar);
        return bolts.g.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(ihJ, "Disk cache read for %s", bVar.getUriString());
            com.facebook.a.a d = this.ioF.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(ihJ, "Disk cache miss for %s", bVar.getUriString());
                this.ioK.bWN();
                return null;
            }
            com.facebook.common.c.a.a(ihJ, "Found entry in disk cache for %s", bVar.getUriString());
            this.ioK.bWM();
            InputStream openStream = d.openStream();
            PooledByteBuffer a = this.ioq.a(openStream, (int) d.size());
            openStream.close();
            com.facebook.common.c.a.a(ihJ, "Successful read from disk cache for %s", bVar.getUriString());
            return a;
        } catch (IOException e) {
            com.facebook.common.c.a.a(ihJ, e, "Exception reading from cache for %s", bVar.getUriString());
            this.ioK.bWO();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(ihJ, "About to write to disk-cache for key %s", bVar.getUriString());
        try {
            this.ioF.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.ioG.f(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(ihJ, "Successful disk-cache write for key %s", bVar.getUriString());
        } catch (IOException e) {
            com.facebook.common.c.a.a(ihJ, e, "Failed to write to disk-cache for key %s", bVar.getUriString());
        }
    }
}

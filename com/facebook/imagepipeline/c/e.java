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
    private static final Class<?> hVB = e.class;
    private final o icA;
    private final com.facebook.common.memory.g icg;
    private final com.facebook.cache.disk.h icv;
    private final com.facebook.common.memory.j icw;
    private final Executor icx;
    private final Executor icy;
    private final ab icz = ab.bUA();

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.icv = hVar;
        this.icg = gVar;
        this.icw = jVar;
        this.icx = executor;
        this.icy = executor2;
        this.icA = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.icz.r(bVar) || this.icv.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.f(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: bUg */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.icx);
        } catch (Exception e) {
            com.facebook.common.c.a.a(hVB, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.icz.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.icz.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(hVB, "Found image for %s in staging area", bVar.getUriString());
            this.icA.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(hVB, "Did not find image for %s in staging area", bVar.getUriString());
        this.icA.bUu();
        try {
            return this.icv.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: bUh */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.icz.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.hVB, "Found image for %s in staging area", bVar.getUriString());
                            e.this.icA.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.hVB, "Did not find image for %s in staging area", bVar.getUriString());
                            e.this.icA.bUu();
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
                            com.facebook.common.c.a.d(e.hVB, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.icx);
        } catch (Exception e) {
            com.facebook.common.c.a.a(hVB, e, "Failed to schedule disk-cache read for %s", bVar.getUriString());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.icz.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.icy.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.icz.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(hVB, e, "Failed to schedule disk-cache write for %s", bVar.getUriString());
            this.icz.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(hVB, "Found image for %s in staging area", bVar.getUriString());
        this.icA.p(bVar);
        return bolts.g.f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(hVB, "Disk cache read for %s", bVar.getUriString());
            com.facebook.a.a d = this.icv.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(hVB, "Disk cache miss for %s", bVar.getUriString());
                this.icA.bUw();
                return null;
            }
            com.facebook.common.c.a.a(hVB, "Found entry in disk cache for %s", bVar.getUriString());
            this.icA.bUv();
            InputStream openStream = d.openStream();
            PooledByteBuffer a = this.icg.a(openStream, (int) d.size());
            openStream.close();
            com.facebook.common.c.a.a(hVB, "Successful read from disk cache for %s", bVar.getUriString());
            return a;
        } catch (IOException e) {
            com.facebook.common.c.a.a(hVB, e, "Exception reading from cache for %s", bVar.getUriString());
            this.icA.bUx();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(hVB, "About to write to disk-cache for key %s", bVar.getUriString());
        try {
            this.icv.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.icw.f(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(hVB, "Successful disk-cache write for key %s", bVar.getUriString());
        } catch (IOException e) {
            com.facebook.common.c.a.a(hVB, e, "Failed to write to disk-cache for key %s", bVar.getUriString());
        }
    }
}

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
    private static final Class<?> jYa = e.class;
    private final com.facebook.common.memory.g keG;
    private final com.facebook.cache.disk.h keV;
    private final com.facebook.common.memory.j keW;
    private final Executor keX;
    private final Executor keY;
    private final ab keZ = ab.cHG();
    private final o kfa;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, o oVar) {
        this.keV = hVar;
        this.keG = gVar;
        this.keW = jVar;
        this.keX = executor;
        this.keY = executor2;
        this.kfa = oVar;
    }

    public boolean i(com.facebook.cache.common.b bVar) {
        return this.keZ.r(bVar) || this.keV.e(bVar);
    }

    public bolts.g<Boolean> j(com.facebook.cache.common.b bVar) {
        return i(bVar) ? bolts.g.g(true) : k(bVar);
    }

    private bolts.g<Boolean> k(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cHm */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.l(bVar));
                }
            }, this.keX);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jYa, e, "Failed to schedule disk-cache read for %s", bVar.cDR());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.d> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.d q = this.keZ.q(bVar);
        return q != null ? b(bVar, q) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.d q = this.keZ.q(bVar);
        if (q != null) {
            q.close();
            com.facebook.common.c.a.a(jYa, "Found image for %s in staging area", bVar.cDR());
            this.kfa.p(bVar);
            return true;
        }
        com.facebook.common.c.a.a(jYa, "Did not find image for %s in staging area", bVar.cDR());
        this.kfa.cHA();
        try {
            return this.keV.f(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.d>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: cHn */
                public com.facebook.imagepipeline.f.d call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.d q = e.this.keZ.q(bVar);
                        if (q != null) {
                            com.facebook.common.c.a.a(e.jYa, "Found image for %s in staging area", bVar.cDR());
                            e.this.kfa.p(bVar);
                            q.t(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.jYa, "Did not find image for %s in staging area", bVar.cDR());
                            e.this.kfa.cHA();
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
                            com.facebook.common.c.a.d(e.jYa, "Host thread was interrupted, decreasing reference count");
                            if (q != null) {
                                q.close();
                            }
                            throw new InterruptedException();
                        }
                        return q;
                    }
                    throw new CancellationException();
                }
            }, this.keX);
        } catch (Exception e) {
            com.facebook.common.c.a.a(jYa, e, "Failed to schedule disk-cache read for %s", bVar.cDR());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.d.f(dVar));
        this.keZ.a(bVar, dVar);
        dVar.t(bVar);
        final com.facebook.imagepipeline.f.d b = com.facebook.imagepipeline.f.d.b(dVar);
        try {
            this.keY.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.keZ.d(bVar, b);
                        com.facebook.imagepipeline.f.d.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(jYa, e, "Failed to schedule disk-cache write for %s", bVar.cDR());
            this.keZ.d(bVar, dVar);
            com.facebook.imagepipeline.f.d.e(b);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.d> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jYa, "Found image for %s in staging area", bVar.cDR());
        this.kfa.p(bVar);
        return bolts.g.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer m(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(jYa, "Disk cache read for %s", bVar.cDR());
            com.facebook.a.a d = this.keV.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(jYa, "Disk cache miss for %s", bVar.cDR());
                this.kfa.cHC();
                return null;
            }
            com.facebook.common.c.a.a(jYa, "Found entry in disk cache for %s", bVar.cDR());
            this.kfa.cHB();
            InputStream cDQ = d.cDQ();
            PooledByteBuffer b = this.keG.b(cDQ, (int) d.size());
            cDQ.close();
            com.facebook.common.c.a.a(jYa, "Successful read from disk cache for %s", bVar.cDR());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(jYa, e, "Exception reading from cache for %s", bVar.cDR());
            this.kfa.cHD();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.d dVar) {
        com.facebook.common.c.a.a(jYa, "About to write to disk-cache for key %s", bVar.cDR());
        try {
            this.keV.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.4
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.keW.g(dVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(jYa, "Successful disk-cache write for key %s", bVar.cDR());
        } catch (IOException e) {
            com.facebook.common.c.a.a(jYa, e, "Failed to write to disk-cache for key %s", bVar.cDR());
        }
    }
}

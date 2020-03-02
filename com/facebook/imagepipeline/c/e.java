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
    private static final Class<?> lHa = e.class;
    private final com.facebook.cache.disk.h lQH;
    private final com.facebook.common.memory.j lQI;
    private final Executor lQJ;
    private final Executor lQK;
    private final u lQL = u.doj();
    private final n lQM;
    private final com.facebook.common.memory.g lQs;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.lQH = hVar;
        this.lQs = gVar;
        this.lQI = jVar;
        this.lQJ = executor;
        this.lQK = executor2;
        this.lQM = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.lQL.u(bVar) || this.lQH.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.c.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dcP */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.lQJ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHa, e, "Failed to schedule disk-cache read for %s", bVar.djU());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.lQL.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.lQL.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lHa, "Found image for %s in staging area", bVar.djU());
            this.lQM.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lHa, "Did not find image for %s in staging area", bVar.djU());
        this.lQM.doe();
        try {
            return this.lQH.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dnT */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.lQL.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lHa, "Found image for %s in staging area", bVar.djU());
                            e.this.lQM.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lHa, "Did not find image for %s in staging area", bVar.djU());
                            e.this.lQM.doe();
                            try {
                                com.facebook.common.references.a b = com.facebook.common.references.a.b(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(b);
                                com.facebook.common.references.a.c(b);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lHa, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.lQJ);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHa, e, "Failed to schedule disk-cache read for %s", bVar.djU());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.lQL.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.lQK.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.lQL.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHa, e, "Failed to schedule disk-cache write for %s", bVar.djU());
            this.lQL.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.lQL.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.lQL.s(bVar);
                    e.this.lQH.e(bVar);
                    return null;
                }
            }, this.lQK);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lHa, e, "Failed to schedule disk-cache remove for %s", bVar.djU());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lHa, "Found image for %s in staging area", bVar.djU());
        this.lQM.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lHa, "Disk cache read for %s", bVar.djU());
            com.facebook.a.a d = this.lQH.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lHa, "Disk cache miss for %s", bVar.djU());
                this.lQM.dog();
                return null;
            }
            com.facebook.common.c.a.a(lHa, "Found entry in disk cache for %s", bVar.djU());
            this.lQM.dof();
            InputStream djT = d.djT();
            PooledByteBuffer c = this.lQs.c(djT, (int) d.size());
            djT.close();
            com.facebook.common.c.a.a(lHa, "Successful read from disk cache for %s", bVar.djU());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lHa, e, "Exception reading from cache for %s", bVar.djU());
            this.lQM.doh();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lHa, "About to write to disk-cache for key %s", bVar.djU());
        try {
            this.lQH.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.lQI.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lHa, "Successful disk-cache write for key %s", bVar.djU());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lHa, e, "Failed to write to disk-cache for key %s", bVar.djU());
        }
    }
}

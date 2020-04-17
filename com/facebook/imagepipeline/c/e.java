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
    private static final Class<?> lQm = e.class;
    private final com.facebook.common.memory.g lZS;
    private final com.facebook.cache.disk.h mai;
    private final com.facebook.common.memory.j maj;
    private final Executor mak;
    private final Executor mal;
    private final u mam = u.dqG();
    private final n man;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mai = hVar;
        this.lZS = gVar;
        this.maj = jVar;
        this.mak = executor;
        this.mal = executor2;
        this.man = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mam.u(bVar) || this.mai.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.j(true) : l(bVar);
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
            }, this.mak);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQm, e, "Failed to schedule disk-cache read for %s", bVar.dmk());
            return bolts.g.e(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mam.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mam.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lQm, "Found image for %s in staging area", bVar.dmk());
            this.man.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lQm, "Did not find image for %s in staging area", bVar.dmk());
        this.man.dqB();
        try {
            return this.mai.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dqo */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mam.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lQm, "Found image for %s in staging area", bVar.dmk());
                            e.this.man.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lQm, "Did not find image for %s in staging area", bVar.dmk());
                            e.this.man.dqB();
                            try {
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(c);
                                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lQm, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mak);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQm, e, "Failed to schedule disk-cache read for %s", bVar.dmk());
            return bolts.g.e(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mam.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.mal.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mam.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQm, e, "Failed to schedule disk-cache write for %s", bVar.dmk());
            this.mam.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mam.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mam.s(bVar);
                    e.this.mai.e(bVar);
                    return null;
                }
            }, this.mal);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQm, e, "Failed to schedule disk-cache remove for %s", bVar.dmk());
            return bolts.g.e(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lQm, "Found image for %s in staging area", bVar.dmk());
        this.man.r(bVar);
        return bolts.g.j(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lQm, "Disk cache read for %s", bVar.dmk());
            com.facebook.a.a d = this.mai.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lQm, "Disk cache miss for %s", bVar.dmk());
                this.man.dqD();
                return null;
            }
            com.facebook.common.c.a.a(lQm, "Found entry in disk cache for %s", bVar.dmk());
            this.man.dqC();
            InputStream dmj = d.dmj();
            PooledByteBuffer c = this.lZS.c(dmj, (int) d.size());
            dmj.close();
            com.facebook.common.c.a.a(lQm, "Successful read from disk cache for %s", bVar.dmk());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lQm, e, "Exception reading from cache for %s", bVar.dmk());
            this.man.dqE();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lQm, "About to write to disk-cache for key %s", bVar.dmk());
        try {
            this.mai.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.maj.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lQm, "Successful disk-cache write for key %s", bVar.dmk());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lQm, e, "Failed to write to disk-cache for key %s", bVar.dmk());
        }
    }
}

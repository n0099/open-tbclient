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
    private static final Class<?> lQq = e.class;
    private final com.facebook.common.memory.g lZW;
    private final com.facebook.cache.disk.h mam;
    private final com.facebook.common.memory.j man;
    private final Executor mao;
    private final Executor maq;
    private final u mar = u.dqE();
    private final n mas;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.mam = hVar;
        this.lZW = gVar;
        this.man = jVar;
        this.mao = executor;
        this.maq = executor2;
        this.mas = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.mar.u(bVar) || this.mam.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.k(true) : l(bVar);
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
            }, this.mao);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQq, e, "Failed to schedule disk-cache read for %s", bVar.dmi());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.mar.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.mar.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(lQq, "Found image for %s in staging area", bVar.dmi());
            this.mas.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(lQq, "Did not find image for %s in staging area", bVar.dmi());
        this.mas.dqz();
        try {
            return this.mam.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dqm */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.mar.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.lQq, "Found image for %s in staging area", bVar.dmi());
                            e.this.mas.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.lQq, "Did not find image for %s in staging area", bVar.dmi());
                            e.this.mas.dqz();
                            try {
                                com.facebook.common.references.a c = com.facebook.common.references.a.c(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(c);
                                com.facebook.common.references.a.c((com.facebook.common.references.a<?>) c);
                            } catch (Exception e) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.lQq, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.mao);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQq, e, "Failed to schedule disk-cache read for %s", bVar.dmi());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.mar.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.maq.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.mar.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQq, e, "Failed to schedule disk-cache write for %s", bVar.dmi());
            this.mar.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.mar.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.mar.s(bVar);
                    e.this.mam.e(bVar);
                    return null;
                }
            }, this.maq);
        } catch (Exception e) {
            com.facebook.common.c.a.a(lQq, e, "Failed to schedule disk-cache remove for %s", bVar.dmi());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lQq, "Found image for %s in staging area", bVar.dmi());
        this.mas.r(bVar);
        return bolts.g.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(lQq, "Disk cache read for %s", bVar.dmi());
            com.facebook.a.a d = this.mam.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(lQq, "Disk cache miss for %s", bVar.dmi());
                this.mas.dqB();
                return null;
            }
            com.facebook.common.c.a.a(lQq, "Found entry in disk cache for %s", bVar.dmi());
            this.mas.dqA();
            InputStream dmh = d.dmh();
            PooledByteBuffer c = this.lZW.c(dmh, (int) d.size());
            dmh.close();
            com.facebook.common.c.a.a(lQq, "Successful read from disk cache for %s", bVar.dmi());
            return c;
        } catch (IOException e) {
            com.facebook.common.c.a.a(lQq, e, "Exception reading from cache for %s", bVar.dmi());
            this.mas.dqC();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(lQq, "About to write to disk-cache for key %s", bVar.dmi());
        try {
            this.mam.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.man.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(lQq, "Successful disk-cache write for key %s", bVar.dmi());
        } catch (IOException e) {
            com.facebook.common.c.a.a(lQq, e, "Failed to write to disk-cache for key %s", bVar.dmi());
        }
    }
}

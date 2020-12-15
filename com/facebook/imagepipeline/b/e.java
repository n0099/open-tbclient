package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class e {
    private static final Class<?> paF = e.class;
    private final com.facebook.common.memory.g pjQ;
    private final com.facebook.cache.disk.h pkd;
    private final com.facebook.common.memory.j pke;
    private final Executor pkf;
    private final Executor pkh;
    private final u pki = u.etp();
    private final n pkj;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pkd = hVar;
        this.pjQ = gVar;
        this.pke = jVar;
        this.pkf = executor;
        this.pkh = executor2;
        this.pkj = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pki.u(bVar) || this.pkd.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.l(true) : l(bVar);
    }

    private bolts.g<Boolean> l(final com.facebook.cache.common.b bVar) {
        try {
            return bolts.g.a(new Callable<Boolean>() { // from class: com.facebook.imagepipeline.b.e.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    return Boolean.valueOf(e.this.m(bVar));
                }
            }, this.pkf);
        } catch (Exception e) {
            com.facebook.common.c.a.a(paF, e, "Failed to schedule disk-cache read for %s", bVar.epd());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pki.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pki.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(paF, "Found image for %s in staging area", bVar.epd());
            this.pkj.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(paF, "Did not find image for %s in staging area", bVar.epd());
        this.pkj.etk();
        try {
            return this.pkd.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: esX */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pki.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.paF, "Found image for %s in staging area", bVar.epd());
                            e.this.pkj.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.paF, "Did not find image for %s in staging area", bVar.epd());
                            e.this.pkj.etk();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.paF, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pkf);
        } catch (Exception e) {
            com.facebook.common.c.a.a(paF, e, "Failed to schedule disk-cache read for %s", bVar.epd());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pki.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pkh.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.pki.d(bVar, b);
                        com.facebook.imagepipeline.f.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(paF, e, "Failed to schedule disk-cache write for %s", bVar.epd());
            this.pki.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pki.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pki.s(bVar);
                    e.this.pkd.e(bVar);
                    return null;
                }
            }, this.pkh);
        } catch (Exception e) {
            com.facebook.common.c.a.a(paF, e, "Failed to schedule disk-cache remove for %s", bVar.epd());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.a(paF, "Found image for %s in staging area", bVar.epd());
        this.pkj.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(paF, "Disk cache read for %s", bVar.epd());
            com.facebook.a.a d = this.pkd.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(paF, "Disk cache miss for %s", bVar.epd());
                this.pkj.etm();
                return null;
            }
            com.facebook.common.c.a.a(paF, "Found entry in disk cache for %s", bVar.epd());
            this.pkj.etl();
            InputStream epc = d.epc();
            PooledByteBuffer b = this.pjQ.b(epc, (int) d.size());
            epc.close();
            com.facebook.common.c.a.a(paF, "Successful read from disk cache for %s", bVar.epd());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(paF, e, "Exception reading from cache for %s", bVar.epd());
            this.pkj.etn();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.a(paF, "About to write to disk-cache for key %s", bVar.epd());
        try {
            this.pkd.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pke.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(paF, "Successful disk-cache write for key %s", bVar.epd());
        } catch (IOException e) {
            com.facebook.common.c.a.a(paF, e, "Failed to write to disk-cache for key %s", bVar.epd());
        }
    }
}

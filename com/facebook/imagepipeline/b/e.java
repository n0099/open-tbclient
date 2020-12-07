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
    private static final Class<?> paD = e.class;
    private final com.facebook.common.memory.g pjO;
    private final com.facebook.cache.disk.h pkb;
    private final com.facebook.common.memory.j pkc;
    private final Executor pkd;
    private final Executor pke;
    private final u pkf = u.eto();
    private final n pkh;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.pkb = hVar;
        this.pjO = gVar;
        this.pkc = jVar;
        this.pkd = executor;
        this.pke = executor2;
        this.pkh = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.pkf.u(bVar) || this.pkb.f(bVar);
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
            }, this.pkd);
        } catch (Exception e) {
            com.facebook.common.c.a.a(paD, e, "Failed to schedule disk-cache read for %s", bVar.epc());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.f.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.f.e t = this.pkf.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.f.e t = this.pkf.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(paD, "Found image for %s in staging area", bVar.epc());
            this.pkh.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(paD, "Did not find image for %s in staging area", bVar.epc());
        this.pkh.etj();
        try {
            return this.pkb.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.f.e>() { // from class: com.facebook.imagepipeline.b.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: esW */
                public com.facebook.imagepipeline.f.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.f.e t = e.this.pkf.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.paD, "Found image for %s in staging area", bVar.epc());
                            e.this.pkh.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.paD, "Did not find image for %s in staging area", bVar.epc());
                            e.this.pkh.etj();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.f.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.paD, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.pkd);
        } catch (Exception e) {
            com.facebook.common.c.a.a(paD, e, "Failed to schedule disk-cache read for %s", bVar.epc());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.f.e.f(eVar));
        this.pkf.a(bVar, eVar);
        final com.facebook.imagepipeline.f.e b = com.facebook.imagepipeline.f.e.b(eVar);
        try {
            this.pke.execute(new Runnable() { // from class: com.facebook.imagepipeline.b.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.pkf.d(bVar, b);
                        com.facebook.imagepipeline.f.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(paD, e, "Failed to schedule disk-cache write for %s", bVar.epc());
            this.pkf.d(bVar, eVar);
            com.facebook.imagepipeline.f.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.pkf.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.b.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.pkf.s(bVar);
                    e.this.pkb.e(bVar);
                    return null;
                }
            }, this.pke);
        } catch (Exception e) {
            com.facebook.common.c.a.a(paD, e, "Failed to schedule disk-cache remove for %s", bVar.epc());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.f.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.a(paD, "Found image for %s in staging area", bVar.epc());
        this.pkh.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(paD, "Disk cache read for %s", bVar.epc());
            com.facebook.a.a d = this.pkb.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(paD, "Disk cache miss for %s", bVar.epc());
                this.pkh.etl();
                return null;
            }
            com.facebook.common.c.a.a(paD, "Found entry in disk cache for %s", bVar.epc());
            this.pkh.etk();
            InputStream epb = d.epb();
            PooledByteBuffer b = this.pjO.b(epb, (int) d.size());
            epb.close();
            com.facebook.common.c.a.a(paD, "Successful read from disk cache for %s", bVar.epc());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(paD, e, "Exception reading from cache for %s", bVar.epc());
            this.pkh.etm();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.f.e eVar) {
        com.facebook.common.c.a.a(paD, "About to write to disk-cache for key %s", bVar.epc());
        try {
            this.pkb.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.b.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.pkc.copy(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(paD, "Successful disk-cache write for key %s", bVar.epc());
        } catch (IOException e) {
            com.facebook.common.c.a.a(paD, e, "Failed to write to disk-cache for key %s", bVar.epc());
        }
    }
}

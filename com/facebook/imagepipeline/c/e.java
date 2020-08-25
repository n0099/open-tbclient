package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class e {
    private static final Class<?> nju = e.class;
    private final com.facebook.common.memory.g ntb;
    private final com.facebook.cache.disk.h ntp;
    private final com.facebook.common.memory.j ntq;
    private final Executor ntr;
    private final Executor nts;
    private final u ntt = u.dSc();
    private final n ntu;

    public e(com.facebook.cache.disk.h hVar, com.facebook.common.memory.g gVar, com.facebook.common.memory.j jVar, Executor executor, Executor executor2, n nVar) {
        this.ntp = hVar;
        this.ntb = gVar;
        this.ntq = jVar;
        this.ntr = executor;
        this.nts = executor2;
        this.ntu = nVar;
    }

    public boolean j(com.facebook.cache.common.b bVar) {
        return this.ntt.u(bVar) || this.ntp.f(bVar);
    }

    public bolts.g<Boolean> k(com.facebook.cache.common.b bVar) {
        return j(bVar) ? bolts.g.l(true) : l(bVar);
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
            }, this.ntr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(nju, e, "Failed to schedule disk-cache read for %s", bVar.dNJ());
            return bolts.g.f(e);
        }
    }

    public bolts.g<com.facebook.imagepipeline.g.e> a(com.facebook.cache.common.b bVar, AtomicBoolean atomicBoolean) {
        com.facebook.imagepipeline.g.e t = this.ntt.t(bVar);
        return t != null ? b(bVar, t) : b(bVar, atomicBoolean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(com.facebook.cache.common.b bVar) {
        com.facebook.imagepipeline.g.e t = this.ntt.t(bVar);
        if (t != null) {
            t.close();
            com.facebook.common.c.a.a(nju, "Found image for %s in staging area", bVar.dNJ());
            this.ntu.r(bVar);
            return true;
        }
        com.facebook.common.c.a.a(nju, "Did not find image for %s in staging area", bVar.dNJ());
        this.ntu.dRX();
        try {
            return this.ntp.g(bVar);
        } catch (Exception e) {
            return false;
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(final com.facebook.cache.common.b bVar, final AtomicBoolean atomicBoolean) {
        try {
            return bolts.g.a(new Callable<com.facebook.imagepipeline.g.e>() { // from class: com.facebook.imagepipeline.c.e.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                /* renamed from: dRK */
                public com.facebook.imagepipeline.g.e call() throws Exception {
                    if (!atomicBoolean.get()) {
                        com.facebook.imagepipeline.g.e t = e.this.ntt.t(bVar);
                        if (t != null) {
                            com.facebook.common.c.a.a(e.nju, "Found image for %s in staging area", bVar.dNJ());
                            e.this.ntu.r(bVar);
                        } else {
                            com.facebook.common.c.a.a(e.nju, "Did not find image for %s in staging area", bVar.dNJ());
                            e.this.ntu.dRX();
                            try {
                                com.facebook.common.references.a e = com.facebook.common.references.a.e(e.this.o(bVar));
                                t = new com.facebook.imagepipeline.g.e(e);
                                com.facebook.common.references.a.c(e);
                            } catch (Exception e2) {
                                return null;
                            }
                        }
                        if (Thread.interrupted()) {
                            com.facebook.common.c.a.e(e.nju, "Host thread was interrupted, decreasing reference count");
                            if (t != null) {
                                t.close();
                            }
                            throw new InterruptedException();
                        }
                        return t;
                    }
                    throw new CancellationException();
                }
            }, this.ntr);
        } catch (Exception e) {
            com.facebook.common.c.a.a(nju, e, "Failed to schedule disk-cache read for %s", bVar.dNJ());
            return bolts.g.f(e);
        }
    }

    public void a(final com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        com.facebook.common.internal.g.checkArgument(com.facebook.imagepipeline.g.e.f(eVar));
        this.ntt.a(bVar, eVar);
        final com.facebook.imagepipeline.g.e b = com.facebook.imagepipeline.g.e.b(eVar);
        try {
            this.nts.execute(new Runnable() { // from class: com.facebook.imagepipeline.c.e.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.this.c(bVar, b);
                    } finally {
                        e.this.ntt.d(bVar, b);
                        com.facebook.imagepipeline.g.e.e(b);
                    }
                }
            });
        } catch (Exception e) {
            com.facebook.common.c.a.a(nju, e, "Failed to schedule disk-cache write for %s", bVar.dNJ());
            this.ntt.d(bVar, eVar);
            com.facebook.imagepipeline.g.e.e(b);
        }
    }

    public bolts.g<Void> n(final com.facebook.cache.common.b bVar) {
        com.facebook.common.internal.g.checkNotNull(bVar);
        this.ntt.s(bVar);
        try {
            return bolts.g.a(new Callable<Void>() { // from class: com.facebook.imagepipeline.c.e.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    e.this.ntt.s(bVar);
                    e.this.ntp.e(bVar);
                    return null;
                }
            }, this.nts);
        } catch (Exception e) {
            com.facebook.common.c.a.a(nju, e, "Failed to schedule disk-cache remove for %s", bVar.dNJ());
            return bolts.g.f(e);
        }
    }

    private bolts.g<com.facebook.imagepipeline.g.e> b(com.facebook.cache.common.b bVar, com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(nju, "Found image for %s in staging area", bVar.dNJ());
        this.ntu.r(bVar);
        return bolts.g.l(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PooledByteBuffer o(com.facebook.cache.common.b bVar) throws IOException {
        try {
            com.facebook.common.c.a.a(nju, "Disk cache read for %s", bVar.dNJ());
            com.facebook.a.a d = this.ntp.d(bVar);
            if (d == null) {
                com.facebook.common.c.a.a(nju, "Disk cache miss for %s", bVar.dNJ());
                this.ntu.dRZ();
                return null;
            }
            com.facebook.common.c.a.a(nju, "Found entry in disk cache for %s", bVar.dNJ());
            this.ntu.dRY();
            InputStream dNI = d.dNI();
            PooledByteBuffer b = this.ntb.b(dNI, (int) d.size());
            dNI.close();
            com.facebook.common.c.a.a(nju, "Successful read from disk cache for %s", bVar.dNJ());
            return b;
        } catch (IOException e) {
            com.facebook.common.c.a.a(nju, e, "Exception reading from cache for %s", bVar.dNJ());
            this.ntu.dSa();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.facebook.cache.common.b bVar, final com.facebook.imagepipeline.g.e eVar) {
        com.facebook.common.c.a.a(nju, "About to write to disk-cache for key %s", bVar.dNJ());
        try {
            this.ntp.a(bVar, new com.facebook.cache.common.h() { // from class: com.facebook.imagepipeline.c.e.5
                @Override // com.facebook.cache.common.h
                public void write(OutputStream outputStream) throws IOException {
                    e.this.ntq.e(eVar.getInputStream(), outputStream);
                }
            });
            com.facebook.common.c.a.a(nju, "Successful disk-cache write for key %s", bVar.dNJ());
        } catch (IOException e) {
            com.facebook.common.c.a.a(nju, e, "Failed to write to disk-cache for key %s", bVar.dNJ());
        }
    }
}

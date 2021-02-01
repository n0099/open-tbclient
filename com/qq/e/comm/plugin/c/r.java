package com.qq.e.comm.plugin.c;

import com.kwai.video.player.NativeErrorCode;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import yaq.gdtadv;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  assets/yaqgdtadv0.sec
 */
/* loaded from: classes15.dex */
public class r implements k {

    /* renamed from: com.qq.e.comm.plugin.c.r$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements Future<com.qq.e.comm.plugin.s.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Future f11980a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f11981b;
        private com.qq.e.comm.plugin.s.b d;

        AnonymousClass1(Future future, f fVar) {
            this.f11980a = future;
            this.f11981b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Future
        /* renamed from: a */
        public com.qq.e.comm.plugin.s.b get() {
            return get(this.f11981b.y, TimeUnit.SECONDS);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Future
        /* renamed from: a */
        public com.qq.e.comm.plugin.s.b get(long j, TimeUnit timeUnit) {
            int i;
            com.qq.e.comm.plugin.s.b bVar;
            synchronized (this) {
                if (this.d != null) {
                    bVar = this.d;
                } else {
                    try {
                        com.qq.e.comm.plugin.t.b.f fVar = (com.qq.e.comm.plugin.t.b.f) this.f11980a.get(j, timeUnit);
                        if (fVar == null) {
                            i = -5006;
                        } else {
                            this.d = r.a(r.this, fVar, this.f11981b);
                            i = 0;
                        }
                    } catch (InterruptedException e) {
                        i = NativeErrorCode.EKS_AVERROR_EMFILE;
                    } catch (ExecutionException e2) {
                        i = NativeErrorCode.EKS_AVERROR_HTTP_BAD_REQUEST;
                    } catch (TimeoutException e3) {
                        i = NativeErrorCode.EKS_AVERROR_ETIMEDOUT;
                    } catch (Throwable th) {
                        i = -5006;
                    }
                    if (this.d == null) {
                        g.a(i, this.f11981b);
                        this.d = new com.qq.e.comm.plugin.s.b(i);
                    }
                    bVar = this.d;
                }
            }
            return bVar;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.f11980a.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f11980a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f11980a.isDone();
        }
    }

    static /* synthetic */ com.qq.e.comm.plugin.s.b a(r rVar, com.qq.e.comm.plugin.t.b.f fVar, f fVar2) {
        return (com.qq.e.comm.plugin.s.b) gdtadv.getobjresult(332, 1, rVar, fVar, fVar2);
    }

    private com.qq.e.comm.plugin.s.b a(com.qq.e.comm.plugin.t.b.f fVar, f fVar2) {
        return (com.qq.e.comm.plugin.s.b) gdtadv.getobjresult(333, 0, this, fVar, fVar2);
    }

    private void a(f fVar, Future<com.qq.e.comm.plugin.s.b> future) {
        gdtadv.getVresult(334, 0, this, fVar, future);
    }

    private String b(f fVar) {
        return (String) gdtadv.getobjresult(335, 0, this, fVar);
    }

    private String b(f fVar, String str) {
        return (String) gdtadv.getobjresult(336, 0, this, fVar, str);
    }

    private String c(f fVar, String str) {
        return (String) gdtadv.getobjresult(337, 0, this, fVar, str);
    }

    private Future<com.qq.e.comm.plugin.s.b> d(f fVar, String str) {
        return (Future) gdtadv.getobjresult(338, 0, this, fVar, str);
    }

    protected String a(f fVar, String str) {
        return (String) gdtadv.getobjresult(339, 0, this, fVar, str);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar) {
        return gdtadv.getZresult(340, 0, this, fVar);
    }

    @Override // com.qq.e.comm.plugin.c.k
    public boolean a(f fVar, com.qq.e.comm.plugin.c.a.a aVar) {
        return gdtadv.getZresult(341, 0, this, fVar, aVar);
    }
}

package h.o.c;

import h.g;
import h.k;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e extends h.g {

    /* renamed from: a  reason: collision with root package name */
    public static final e f68910a = new e();

    /* loaded from: classes7.dex */
    public final class a extends g.a implements k {

        /* renamed from: e  reason: collision with root package name */
        public final h.u.a f68911e = new h.u.a();

        public a() {
        }

        @Override // h.g.a
        public k b(h.n.a aVar) {
            aVar.call();
            return h.u.e.c();
        }

        @Override // h.g.a
        public k c(h.n.a aVar, long j, TimeUnit timeUnit) {
            return b(new i(aVar, this, e.this.now() + timeUnit.toMillis(j)));
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.f68911e.isUnsubscribed();
        }

        @Override // h.k
        public void unsubscribe() {
            this.f68911e.unsubscribe();
        }
    }

    @Override // h.g
    public g.a createWorker() {
        return new a();
    }
}

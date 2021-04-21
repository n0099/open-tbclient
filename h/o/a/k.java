package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class k implements d.a<Long> {

    /* renamed from: e  reason: collision with root package name */
    public final long f68923e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f68924f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f68925g;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68926e;

        public a(k kVar, h.j jVar) {
            this.f68926e = jVar;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f68926e.onNext(0L);
                this.f68926e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this.f68926e);
            }
        }
    }

    public k(long j, TimeUnit timeUnit, h.g gVar) {
        this.f68923e = j;
        this.f68924f = timeUnit;
        this.f68925g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super Long> jVar) {
        g.a createWorker = this.f68925g.createWorker();
        jVar.add(createWorker);
        createWorker.c(new a(this, jVar), this.f68923e, this.f68924f);
    }
}

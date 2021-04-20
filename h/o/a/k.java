package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class k implements d.a<Long> {

    /* renamed from: e  reason: collision with root package name */
    public final long f68776e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f68777f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f68778g;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68779e;

        public a(k kVar, h.j jVar) {
            this.f68779e = jVar;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f68779e.onNext(0L);
                this.f68779e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this.f68779e);
            }
        }
    }

    public k(long j, TimeUnit timeUnit, h.g gVar) {
        this.f68776e = j;
        this.f68777f = timeUnit;
        this.f68778g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super Long> jVar) {
        g.a createWorker = this.f68778g.createWorker();
        jVar.add(createWorker);
        createWorker.c(new a(this, jVar), this.f68776e, this.f68777f);
    }
}

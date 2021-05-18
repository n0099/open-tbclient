package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class j implements d.a<Long> {

    /* renamed from: e  reason: collision with root package name */
    public final long f68450e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f68451f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f68452g;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68453e;

        public a(j jVar, h.j jVar2) {
            this.f68453e = jVar2;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f68453e.onNext(0L);
                this.f68453e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this.f68453e);
            }
        }
    }

    public j(long j, TimeUnit timeUnit, h.g gVar) {
        this.f68450e = j;
        this.f68451f = timeUnit;
        this.f68452g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super Long> jVar) {
        g.a createWorker = this.f68452g.createWorker();
        jVar.add(createWorker);
        createWorker.c(new a(this, jVar), this.f68450e, this.f68451f);
    }
}

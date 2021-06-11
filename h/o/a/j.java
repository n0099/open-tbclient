package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class j implements d.a<Long> {

    /* renamed from: e  reason: collision with root package name */
    public final long f71749e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f71750f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f71751g;

    /* loaded from: classes8.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71752e;

        public a(j jVar, h.j jVar2) {
            this.f71752e = jVar2;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f71752e.onNext(0L);
                this.f71752e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this.f71752e);
            }
        }
    }

    public j(long j, TimeUnit timeUnit, h.g gVar) {
        this.f71749e = j;
        this.f71750f = timeUnit;
        this.f71751g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super Long> jVar) {
        g.a createWorker = this.f71751g.createWorker();
        jVar.add(createWorker);
        createWorker.c(new a(this, jVar), this.f71749e, this.f71750f);
    }
}

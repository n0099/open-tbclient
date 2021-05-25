package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class j implements d.a<Long> {

    /* renamed from: e  reason: collision with root package name */
    public final long f68493e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f68494f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f68495g;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f68496e;

        public a(j jVar, h.j jVar2) {
            this.f68496e = jVar2;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f68496e.onNext(0L);
                this.f68496e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this.f68496e);
            }
        }
    }

    public j(long j, TimeUnit timeUnit, h.g gVar) {
        this.f68493e = j;
        this.f68494f = timeUnit;
        this.f68495g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super Long> jVar) {
        g.a createWorker = this.f68495g.createWorker();
        jVar.add(createWorker);
        createWorker.c(new a(this, jVar), this.f68493e, this.f68494f);
    }
}

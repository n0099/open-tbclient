package h.o.a;

import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class j implements d.a<Long> {

    /* renamed from: e  reason: collision with root package name */
    public final long f67770e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f67771f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f67772g;

    /* loaded from: classes7.dex */
    public class a implements h.n.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f67773e;

        public a(j jVar, h.j jVar2) {
            this.f67773e = jVar2;
        }

        @Override // h.n.a
        public void call() {
            try {
                this.f67773e.onNext(0L);
                this.f67773e.onCompleted();
            } catch (Throwable th) {
                h.m.a.f(th, this.f67773e);
            }
        }
    }

    public j(long j, TimeUnit timeUnit, h.g gVar) {
        this.f67770e = j;
        this.f67771f = timeUnit;
        this.f67772g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.b
    /* renamed from: a */
    public void call(h.j<? super Long> jVar) {
        g.a createWorker = this.f67772g.createWorker();
        jVar.add(createWorker);
        createWorker.c(new a(this, jVar), this.f67770e, this.f67771f);
    }
}

package h.o.a;

import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes8.dex */
public final class k<T> implements d.b<Boolean, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f71857e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f71858f;

    /* loaded from: classes8.dex */
    public class a extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f71859e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f71860f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f71861g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f71862h;

        public a(SingleDelayedProducer singleDelayedProducer, h.j jVar) {
            this.f71861g = singleDelayedProducer;
            this.f71862h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f71860f) {
                return;
            }
            this.f71860f = true;
            if (this.f71859e) {
                this.f71861g.setValue(Boolean.FALSE);
            } else {
                this.f71861g.setValue(Boolean.valueOf(k.this.f71858f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.f71860f) {
                this.f71860f = true;
                this.f71862h.onError(th);
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f71860f) {
                return;
            }
            this.f71859e = true;
            try {
                if (k.this.f71857e.call(t).booleanValue()) {
                    this.f71860f = true;
                    this.f71861g.setValue(Boolean.valueOf(true ^ k.this.f71858f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public k(h.n.f<? super T, Boolean> fVar, boolean z) {
        this.f71857e = fVar;
        this.f71858f = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.n.f
    /* renamed from: a */
    public h.j<? super T> call(h.j<? super Boolean> jVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(jVar);
        a aVar = new a(singleDelayedProducer, jVar);
        jVar.add(aVar);
        jVar.setProducer(singleDelayedProducer);
        return aVar;
    }
}

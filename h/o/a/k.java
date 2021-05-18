package h.o.a;

import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class k<T> implements d.b<Boolean, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f68454e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f68455f;

    /* loaded from: classes7.dex */
    public class a extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f68456e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68457f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f68458g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f68459h;

        public a(SingleDelayedProducer singleDelayedProducer, h.j jVar) {
            this.f68458g = singleDelayedProducer;
            this.f68459h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68457f) {
                return;
            }
            this.f68457f = true;
            if (this.f68456e) {
                this.f68458g.setValue(Boolean.FALSE);
            } else {
                this.f68458g.setValue(Boolean.valueOf(k.this.f68455f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.f68457f) {
                this.f68457f = true;
                this.f68459h.onError(th);
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68457f) {
                return;
            }
            this.f68456e = true;
            try {
                if (k.this.f68454e.call(t).booleanValue()) {
                    this.f68457f = true;
                    this.f68458g.setValue(Boolean.valueOf(true ^ k.this.f68455f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public k(h.n.f<? super T, Boolean> fVar, boolean z) {
        this.f68454e = fVar;
        this.f68455f = z;
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

package h.o.a;

import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class k<T> implements d.b<Boolean, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f67769e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f67770f;

    /* loaded from: classes7.dex */
    public class a extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f67771e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67772f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f67773g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f67774h;

        public a(SingleDelayedProducer singleDelayedProducer, h.j jVar) {
            this.f67773g = singleDelayedProducer;
            this.f67774h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67772f) {
                return;
            }
            this.f67772f = true;
            if (this.f67771e) {
                this.f67773g.setValue(Boolean.FALSE);
            } else {
                this.f67773g.setValue(Boolean.valueOf(k.this.f67770f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.f67772f) {
                this.f67772f = true;
                this.f67774h.onError(th);
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f67772f) {
                return;
            }
            this.f67771e = true;
            try {
                if (k.this.f67769e.call(t).booleanValue()) {
                    this.f67772f = true;
                    this.f67773g.setValue(Boolean.valueOf(true ^ k.this.f67770f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public k(h.n.f<? super T, Boolean> fVar, boolean z) {
        this.f67769e = fVar;
        this.f67770f = z;
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

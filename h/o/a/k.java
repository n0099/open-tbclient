package h.o.a;

import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class k<T> implements d.b<Boolean, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f67764e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f67765f;

    /* loaded from: classes7.dex */
    public class a extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f67766e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67767f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f67768g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f67769h;

        public a(SingleDelayedProducer singleDelayedProducer, h.j jVar) {
            this.f67768g = singleDelayedProducer;
            this.f67769h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f67767f) {
                return;
            }
            this.f67767f = true;
            if (this.f67766e) {
                this.f67768g.setValue(Boolean.FALSE);
            } else {
                this.f67768g.setValue(Boolean.valueOf(k.this.f67765f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.f67767f) {
                this.f67767f = true;
                this.f67769h.onError(th);
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f67767f) {
                return;
            }
            this.f67766e = true;
            try {
                if (k.this.f67764e.call(t).booleanValue()) {
                    this.f67767f = true;
                    this.f67768g.setValue(Boolean.valueOf(true ^ k.this.f67765f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public k(h.n.f<? super T, Boolean> fVar, boolean z) {
        this.f67764e = fVar;
        this.f67765f = z;
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

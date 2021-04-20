package h.o.a;

import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class l<T> implements d.b<Boolean, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f68780e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f68781f;

    /* loaded from: classes7.dex */
    public class a extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f68782e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68783f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f68784g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f68785h;

        public a(SingleDelayedProducer singleDelayedProducer, h.j jVar) {
            this.f68784g = singleDelayedProducer;
            this.f68785h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68783f) {
                return;
            }
            this.f68783f = true;
            if (this.f68782e) {
                this.f68784g.setValue(Boolean.FALSE);
            } else {
                this.f68784g.setValue(Boolean.valueOf(l.this.f68781f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.f68783f) {
                this.f68783f = true;
                this.f68785h.onError(th);
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68783f) {
                return;
            }
            this.f68782e = true;
            try {
                if (l.this.f68780e.call(t).booleanValue()) {
                    this.f68783f = true;
                    this.f68784g.setValue(Boolean.valueOf(true ^ l.this.f68781f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public l(h.n.f<? super T, Boolean> fVar, boolean z) {
        this.f68780e = fVar;
        this.f68781f = z;
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

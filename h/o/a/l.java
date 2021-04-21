package h.o.a;

import h.d;
import rx.internal.producers.SingleDelayedProducer;
/* loaded from: classes7.dex */
public final class l<T> implements d.b<Boolean, T> {

    /* renamed from: e  reason: collision with root package name */
    public final h.n.f<? super T, Boolean> f68927e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f68928f;

    /* loaded from: classes7.dex */
    public class a extends h.j<T> {

        /* renamed from: e  reason: collision with root package name */
        public boolean f68929e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f68930f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SingleDelayedProducer f68931g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h.j f68932h;

        public a(SingleDelayedProducer singleDelayedProducer, h.j jVar) {
            this.f68931g = singleDelayedProducer;
            this.f68932h = jVar;
        }

        @Override // h.e
        public void onCompleted() {
            if (this.f68930f) {
                return;
            }
            this.f68930f = true;
            if (this.f68929e) {
                this.f68931g.setValue(Boolean.FALSE);
            } else {
                this.f68931g.setValue(Boolean.valueOf(l.this.f68928f));
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            if (!this.f68930f) {
                this.f68930f = true;
                this.f68932h.onError(th);
                return;
            }
            h.r.c.j(th);
        }

        @Override // h.e
        public void onNext(T t) {
            if (this.f68930f) {
                return;
            }
            this.f68929e = true;
            try {
                if (l.this.f68927e.call(t).booleanValue()) {
                    this.f68930f = true;
                    this.f68931g.setValue(Boolean.valueOf(true ^ l.this.f68928f));
                    unsubscribe();
                }
            } catch (Throwable th) {
                h.m.a.g(th, this, t);
            }
        }
    }

    public l(h.n.f<? super T, Boolean> fVar, boolean z) {
        this.f68927e = fVar;
        this.f68928f = z;
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

package f.b.x.e.a;

import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;
/* loaded from: classes7.dex */
public final class k<T> implements f.b.g<Object> {

    /* renamed from: e  reason: collision with root package name */
    public final FlowableSamplePublisher$SamplePublisherSubscriber<T> f68640e;

    public k(FlowableSamplePublisher$SamplePublisherSubscriber<T> flowableSamplePublisher$SamplePublisherSubscriber) {
        this.f68640e = flowableSamplePublisher$SamplePublisherSubscriber;
    }

    @Override // g.d.c
    public void onComplete() {
        this.f68640e.complete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.f68640e.error(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        this.f68640e.run();
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        if (this.f68640e.setOther(dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}

package f.a.x.e.a;

import io.reactivex.internal.operators.flowable.FlowableSamplePublisher$SamplePublisherSubscriber;
/* loaded from: classes7.dex */
public final class k<T> implements f.a.g<Object> {

    /* renamed from: e  reason: collision with root package name */
    public final FlowableSamplePublisher$SamplePublisherSubscriber<T> f67482e;

    public k(FlowableSamplePublisher$SamplePublisherSubscriber<T> flowableSamplePublisher$SamplePublisherSubscriber) {
        this.f67482e = flowableSamplePublisher$SamplePublisherSubscriber;
    }

    @Override // g.d.c
    public void onComplete() {
        this.f67482e.complete();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.f67482e.error(th);
    }

    @Override // g.d.c
    public void onNext(Object obj) {
        this.f67482e.run();
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(g.d.d dVar) {
        if (this.f67482e.setOther(dVar)) {
            dVar.request(Long.MAX_VALUE);
        }
    }
}

package f.a.x.e.a;

import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;
/* loaded from: classes7.dex */
public interface j<T> {
    void complete();

    void error(Throwable th);

    void next(T t);

    void replay(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription);
}

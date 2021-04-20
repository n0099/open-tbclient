package f.b.x.e.a;

import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber;
/* loaded from: classes7.dex */
public interface g {
    void innerClose(boolean z, FlowableGroupJoin$LeftRightEndSubscriber flowableGroupJoin$LeftRightEndSubscriber);

    void innerCloseError(Throwable th);

    void innerComplete(FlowableGroupJoin$LeftRightSubscriber flowableGroupJoin$LeftRightSubscriber);

    void innerError(Throwable th);

    void innerValue(boolean z, Object obj);
}

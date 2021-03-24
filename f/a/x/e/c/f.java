package f.a.x.e.c;

import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightEndObserver;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver;
/* loaded from: classes7.dex */
public interface f {
    void innerClose(boolean z, ObservableGroupJoin$LeftRightEndObserver observableGroupJoin$LeftRightEndObserver);

    void innerCloseError(Throwable th);

    void innerComplete(ObservableGroupJoin$LeftRightObserver observableGroupJoin$LeftRightObserver);

    void innerError(Throwable th);

    void innerValue(boolean z, Object obj);
}

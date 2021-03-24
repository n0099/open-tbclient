package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.x.e.c.h;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class ObservableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements h<T> {
    public static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public ObservableReplay$UnboundedReplayBuffer(int i) {
        super(i);
    }

    @Override // f.a.x.e.c.h
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // f.a.x.e.c.h
    public void error(Throwable th) {
        add(NotificationLite.error(th));
        this.size++;
    }

    @Override // f.a.x.e.c.h
    public void next(T t) {
        add(NotificationLite.next(t));
        this.size++;
    }

    @Override // f.a.x.e.c.h
    public void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        if (observableReplay$InnerDisposable.getAndIncrement() != 0) {
            return;
        }
        o<? super T> oVar = observableReplay$InnerDisposable.child;
        int i = 1;
        while (!observableReplay$InnerDisposable.isDisposed()) {
            int i2 = this.size;
            Integer num = (Integer) observableReplay$InnerDisposable.index();
            int intValue = num != null ? num.intValue() : 0;
            while (intValue < i2) {
                if (NotificationLite.accept(get(intValue), oVar) || observableReplay$InnerDisposable.isDisposed()) {
                    return;
                }
                intValue++;
            }
            observableReplay$InnerDisposable.index = Integer.valueOf(intValue);
            i = observableReplay$InnerDisposable.addAndGet(-i);
            if (i == 0) {
                return;
            }
        }
    }
}

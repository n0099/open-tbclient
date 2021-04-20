package io.reactivex.internal.operators.flowable;

import f.b.u.a;
import f.b.x.e.a.j;
import g.d.c;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public final class FlowableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements j<T> {
    public static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public FlowableReplay$UnboundedReplayBuffer(int i) {
        super(i);
    }

    @Override // f.b.x.e.a.j
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // f.b.x.e.a.j
    public void error(Throwable th) {
        add(NotificationLite.error(th));
        this.size++;
    }

    @Override // f.b.x.e.a.j
    public void next(T t) {
        add(NotificationLite.next(t));
        this.size++;
    }

    @Override // f.b.x.e.a.j
    public void replay(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        synchronized (flowableReplay$InnerSubscription) {
            if (flowableReplay$InnerSubscription.emitting) {
                flowableReplay$InnerSubscription.missed = true;
                return;
            }
            flowableReplay$InnerSubscription.emitting = true;
            c<? super T> cVar = flowableReplay$InnerSubscription.child;
            while (!flowableReplay$InnerSubscription.isDisposed()) {
                int i = this.size;
                Integer num = (Integer) flowableReplay$InnerSubscription.index();
                int intValue = num != null ? num.intValue() : 0;
                long j = flowableReplay$InnerSubscription.get();
                long j2 = j;
                long j3 = 0;
                while (j2 != 0 && intValue < i) {
                    Object obj = get(intValue);
                    try {
                        if (NotificationLite.accept(obj, cVar) || flowableReplay$InnerSubscription.isDisposed()) {
                            return;
                        }
                        intValue++;
                        j2--;
                        j3++;
                    } catch (Throwable th) {
                        a.a(th);
                        flowableReplay$InnerSubscription.dispose();
                        if (NotificationLite.isError(obj) || NotificationLite.isComplete(obj)) {
                            return;
                        }
                        cVar.onError(th);
                        return;
                    }
                }
                if (j3 != 0) {
                    flowableReplay$InnerSubscription.index = Integer.valueOf(intValue);
                    if (j != Long.MAX_VALUE) {
                        flowableReplay$InnerSubscription.produced(j3);
                    }
                }
                synchronized (flowableReplay$InnerSubscription) {
                    if (!flowableReplay$InnerSubscription.missed) {
                        flowableReplay$InnerSubscription.emitting = false;
                        return;
                    }
                    flowableReplay$InnerSubscription.missed = false;
                }
            }
        }
    }
}

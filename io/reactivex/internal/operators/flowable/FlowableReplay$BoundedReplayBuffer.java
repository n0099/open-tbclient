package io.reactivex.internal.operators.flowable;

import f.b.u.a;
import f.b.x.e.a.j;
import f.b.x.i.b;
import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class FlowableReplay$BoundedReplayBuffer<T> extends AtomicReference<FlowableReplay$Node> implements j<T> {
    public static final long serialVersionUID = 2346567790059478686L;
    public long index;
    public int size;
    public FlowableReplay$Node tail;

    public FlowableReplay$BoundedReplayBuffer() {
        FlowableReplay$Node flowableReplay$Node = new FlowableReplay$Node(null, 0L);
        this.tail = flowableReplay$Node;
        set(flowableReplay$Node);
    }

    public final void addLast(FlowableReplay$Node flowableReplay$Node) {
        this.tail.set(flowableReplay$Node);
        this.tail = flowableReplay$Node;
        this.size++;
    }

    public final void collect(Collection<? super T> collection) {
        FlowableReplay$Node head = getHead();
        while (true) {
            head = head.get();
            if (head == null) {
                return;
            }
            Object leaveTransform = leaveTransform(head.value);
            if (NotificationLite.isComplete(leaveTransform) || NotificationLite.isError(leaveTransform)) {
                return;
            }
            collection.add((Object) NotificationLite.getValue(leaveTransform));
        }
    }

    @Override // f.b.x.e.a.j
    public final void complete() {
        Object enterTransform = enterTransform(NotificationLite.complete());
        long j = this.index + 1;
        this.index = j;
        addLast(new FlowableReplay$Node(enterTransform, j));
        truncateFinal();
    }

    public Object enterTransform(Object obj) {
        return obj;
    }

    @Override // f.b.x.e.a.j
    public final void error(Throwable th) {
        Object enterTransform = enterTransform(NotificationLite.error(th));
        long j = this.index + 1;
        this.index = j;
        addLast(new FlowableReplay$Node(enterTransform, j));
        truncateFinal();
    }

    public FlowableReplay$Node getHead() {
        return get();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isComplete(leaveTransform(obj));
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isError(leaveTransform(obj));
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    @Override // f.b.x.e.a.j
    public final void next(T t) {
        Object enterTransform = enterTransform(NotificationLite.next(t));
        long j = this.index + 1;
        this.index = j;
        addLast(new FlowableReplay$Node(enterTransform, j));
        truncate();
    }

    public final void removeFirst() {
        FlowableReplay$Node flowableReplay$Node = get().get();
        if (flowableReplay$Node != null) {
            this.size--;
            setFirst(flowableReplay$Node);
            return;
        }
        throw new IllegalStateException("Empty list!");
    }

    public final void removeSome(int i) {
        FlowableReplay$Node flowableReplay$Node = get();
        while (i > 0) {
            flowableReplay$Node = flowableReplay$Node.get();
            i--;
            this.size--;
        }
        setFirst(flowableReplay$Node);
    }

    @Override // f.b.x.e.a.j
    public final void replay(FlowableReplay$InnerSubscription<T> flowableReplay$InnerSubscription) {
        FlowableReplay$Node flowableReplay$Node;
        synchronized (flowableReplay$InnerSubscription) {
            if (flowableReplay$InnerSubscription.emitting) {
                flowableReplay$InnerSubscription.missed = true;
                return;
            }
            flowableReplay$InnerSubscription.emitting = true;
            while (!flowableReplay$InnerSubscription.isDisposed()) {
                long j = flowableReplay$InnerSubscription.get();
                boolean z = j == Long.MAX_VALUE;
                FlowableReplay$Node flowableReplay$Node2 = (FlowableReplay$Node) flowableReplay$InnerSubscription.index();
                if (flowableReplay$Node2 == null) {
                    flowableReplay$Node2 = getHead();
                    flowableReplay$InnerSubscription.index = flowableReplay$Node2;
                    b.a(flowableReplay$InnerSubscription.totalRequested, flowableReplay$Node2.index);
                }
                long j2 = 0;
                while (j != 0 && (flowableReplay$Node = flowableReplay$Node2.get()) != null) {
                    Object leaveTransform = leaveTransform(flowableReplay$Node.value);
                    try {
                        if (NotificationLite.accept(leaveTransform, flowableReplay$InnerSubscription.child)) {
                            flowableReplay$InnerSubscription.index = null;
                            return;
                        }
                        j2++;
                        j--;
                        if (flowableReplay$InnerSubscription.isDisposed()) {
                            return;
                        }
                        flowableReplay$Node2 = flowableReplay$Node;
                    } catch (Throwable th) {
                        a.a(th);
                        flowableReplay$InnerSubscription.index = null;
                        flowableReplay$InnerSubscription.dispose();
                        if (NotificationLite.isError(leaveTransform) || NotificationLite.isComplete(leaveTransform)) {
                            return;
                        }
                        flowableReplay$InnerSubscription.child.onError(th);
                        return;
                    }
                }
                if (j2 != 0) {
                    flowableReplay$InnerSubscription.index = flowableReplay$Node2;
                    if (!z) {
                        flowableReplay$InnerSubscription.produced(j2);
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

    public final void setFirst(FlowableReplay$Node flowableReplay$Node) {
        set(flowableReplay$Node);
    }

    public void truncate() {
    }

    public void truncateFinal() {
    }
}

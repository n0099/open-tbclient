package io.reactivex.internal.operators.flowable;

import f.a.c0.a;
import f.a.p;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class FlowableReplay$SizeAndTimeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    public static final long serialVersionUID = 3457957419649567404L;
    public final int limit;
    public final long maxAge;
    public final p scheduler;
    public final TimeUnit unit;

    public FlowableReplay$SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, p pVar) {
        this.scheduler = pVar;
        this.limit = i;
        this.maxAge = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object enterTransform(Object obj) {
        return new a(obj, this.scheduler.b(this.unit), this.unit);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public FlowableReplay$Node getHead() {
        FlowableReplay$Node flowableReplay$Node;
        long b2 = this.scheduler.b(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node2 = get();
        FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2.get();
        while (true) {
            FlowableReplay$Node flowableReplay$Node4 = flowableReplay$Node3;
            flowableReplay$Node = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node4;
            if (flowableReplay$Node2 != null) {
                a aVar = (a) flowableReplay$Node2.value;
                if (NotificationLite.isComplete(aVar.b()) || NotificationLite.isError(aVar.b()) || aVar.a() > b2) {
                    break;
                }
                flowableReplay$Node3 = flowableReplay$Node2.get();
            } else {
                break;
            }
        }
        return flowableReplay$Node;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object leaveTransform(Object obj) {
        return ((a) obj).b();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncate() {
        FlowableReplay$Node flowableReplay$Node;
        long b2 = this.scheduler.b(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node2 = get();
        FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2.get();
        int i = 0;
        while (true) {
            FlowableReplay$Node flowableReplay$Node4 = flowableReplay$Node3;
            flowableReplay$Node = flowableReplay$Node2;
            flowableReplay$Node2 = flowableReplay$Node4;
            if (flowableReplay$Node2 != null) {
                int i2 = this.size;
                if (i2 > this.limit) {
                    i++;
                    this.size = i2 - 1;
                    flowableReplay$Node3 = flowableReplay$Node2.get();
                } else if (((a) flowableReplay$Node2.value).a() > b2) {
                    break;
                } else {
                    i++;
                    this.size--;
                    flowableReplay$Node3 = flowableReplay$Node2.get();
                }
            } else {
                break;
            }
        }
        if (i != 0) {
            setFirst(flowableReplay$Node);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        setFirst(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
        return;
     */
    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void truncateFinal() {
        long b2 = this.scheduler.b(this.unit) - this.maxAge;
        FlowableReplay$Node flowableReplay$Node = get();
        FlowableReplay$Node flowableReplay$Node2 = flowableReplay$Node.get();
        int i = 0;
        while (true) {
            FlowableReplay$Node flowableReplay$Node3 = flowableReplay$Node2;
            FlowableReplay$Node flowableReplay$Node4 = flowableReplay$Node;
            flowableReplay$Node = flowableReplay$Node3;
            if (flowableReplay$Node == null || this.size <= 1 || ((a) flowableReplay$Node.value).a() > b2) {
                break;
            }
            i++;
            this.size--;
            flowableReplay$Node2 = flowableReplay$Node.get();
        }
    }
}

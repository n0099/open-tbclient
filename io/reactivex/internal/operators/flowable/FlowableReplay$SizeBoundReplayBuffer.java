package io.reactivex.internal.operators.flowable;
/* loaded from: classes7.dex */
public final class FlowableReplay$SizeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    public static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public FlowableReplay$SizeBoundReplayBuffer(int i) {
        this.limit = i;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncate() {
        if (this.size > this.limit) {
            removeFirst();
        }
    }
}

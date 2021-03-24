package io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableReplay$Node extends AtomicReference<FlowableReplay$Node> {
    public static final long serialVersionUID = 245354315435971818L;
    public final long index;
    public final Object value;

    public FlowableReplay$Node(Object obj, long j) {
        this.value = obj;
        this.index = j;
    }
}

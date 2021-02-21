package rx.internal.util.a;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes5.dex */
abstract class b<E> extends d<E> {
    protected static final long qDM = ae.m(b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNF() {
        return (LinkedQueueNode) ae.qDZ.d(this, qDM);
    }
}

package rx.internal.util.a;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes12.dex */
abstract class b<E> extends d<E> {
    protected static final long pUC = ae.l(b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGl() {
        return (LinkedQueueNode) ae.pUP.d(this, pUC);
    }
}

package rx.internal.util.a;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes5.dex */
abstract class e<E> extends c<E> {
    protected static final long nRR = ae.l(e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dNv() {
        return (LinkedQueueNode) ae.nSd.c(this, nRR);
    }
}

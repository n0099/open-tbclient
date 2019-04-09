package rx.internal.util.a;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes2.dex */
abstract class e<E> extends c<E> {
    protected static final long kaQ = ae.j(e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEA() {
        return (LinkedQueueNode) ae.kbc.getObjectVolatile(this, kaQ);
    }
}

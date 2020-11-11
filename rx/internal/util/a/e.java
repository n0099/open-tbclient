package rx.internal.util.a;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes16.dex */
abstract class e<E> extends c<E> {
    protected static final long qiX = ae.l(e.class, "producerNode");
    protected LinkedQueueNode<E> producerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGg() {
        return (LinkedQueueNode) ae.qjj.d(this, qiX);
    }
}

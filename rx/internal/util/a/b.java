package rx.internal.util.a;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes2.dex */
abstract class b<E> extends d<E> {
    protected static final long iDF = ae.j(b.class, "consumerNode");
    protected LinkedQueueNode<E> consumerNode;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ccZ() {
        return (LinkedQueueNode) ae.iDS.getObjectVolatile(this, iDF);
    }
}

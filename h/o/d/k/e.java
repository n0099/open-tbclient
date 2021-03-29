package h.o.d.k;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class e<E> extends c<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final long f67967e = f0.a(e.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    public final LinkedQueueNode<E> b() {
        return (LinkedQueueNode) f0.f67972a.f(this, f67967e);
    }

    public final void c(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}

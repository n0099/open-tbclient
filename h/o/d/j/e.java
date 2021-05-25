package h.o.d.j;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class e<E> extends c<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final long f68709e = f0.a(e.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    public final LinkedQueueNode<E> b() {
        return (LinkedQueueNode) f0.f68715a.f(this, f68709e);
    }

    public final void c(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode = linkedQueueNode;
    }
}

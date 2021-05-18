package h.o.d.j;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class b<E> extends d<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final long f68661f = f0.a(b.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> d() {
        return (LinkedQueueNode) f0.f68672a.f(this, f68661f);
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}

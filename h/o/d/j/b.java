package h.o.d.j;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes8.dex */
public abstract class b<E> extends d<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final long f71960f = f0.a(b.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> d() {
        return (LinkedQueueNode) f0.f71971a.f(this, f71960f);
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}

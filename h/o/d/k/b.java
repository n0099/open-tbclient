package h.o.d.k;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class b<E> extends d<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final long f67957f = f0.a(b.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    public final LinkedQueueNode<E> d() {
        return (LinkedQueueNode) f0.f67967a.f(this, f67957f);
    }

    public final void e(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode = linkedQueueNode;
    }
}

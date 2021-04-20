package f.b.x.e.b;

import f.b.x.c.f;
/* loaded from: classes7.dex */
public interface d<T> extends f<T> {
    int consumerIndex();

    void drop();

    T peek();

    @Override // f.b.x.c.f
    T poll();

    int producerIndex();
}

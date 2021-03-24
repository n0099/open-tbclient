package f.a.x.e.b;

import f.a.x.c.f;
/* loaded from: classes7.dex */
public interface d<T> extends f<T> {
    int consumerIndex();

    void drop();

    T peek();

    @Override // f.a.x.c.f
    T poll();

    int producerIndex();
}

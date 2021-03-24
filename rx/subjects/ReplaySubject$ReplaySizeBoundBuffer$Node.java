package rx.subjects;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ReplaySubject$ReplaySizeBoundBuffer$Node<T> extends AtomicReference<ReplaySubject$ReplaySizeBoundBuffer$Node<T>> {
    public static final long serialVersionUID = 3713592843205853725L;
    public final T value;

    public ReplaySubject$ReplaySizeBoundBuffer$Node(T t) {
        this.value = t;
    }
}

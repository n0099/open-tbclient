package rx.subjects;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode<T> extends AtomicReference<ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode<T>> {
    public static final long serialVersionUID = 3713592843205853725L;
    public final long timestamp;
    public final T value;

    public ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode(T t, long j) {
        this.value = t;
        this.timestamp = j;
    }
}

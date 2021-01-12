package rx;
/* loaded from: classes14.dex */
public interface Emitter<T> extends e<T> {

    /* loaded from: classes14.dex */
    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }
}

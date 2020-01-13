package rx;
/* loaded from: classes5.dex */
public interface Emitter<T> extends e<T> {

    /* loaded from: classes5.dex */
    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }
}

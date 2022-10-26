package io.reactivex.internal.fuseable;
/* loaded from: classes8.dex */
public interface QueueFuseable extends SimpleQueue {
    public static final int ANY = 3;
    public static final int ASYNC = 2;
    public static final int BOUNDARY = 4;
    public static final int NONE = 0;
    public static final int SYNC = 1;

    int requestFusion(int i);
}

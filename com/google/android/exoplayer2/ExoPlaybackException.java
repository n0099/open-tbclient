package com.google.android.exoplayer2;

import java.io.IOException;
/* loaded from: classes6.dex */
public final class ExoPlaybackException extends Exception {
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public final int rendererIndex;
    public final int type;

    public static ExoPlaybackException createForRenderer(Exception exc, int i) {
        return new ExoPlaybackException(1, null, exc, i);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, null, iOException, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, null, runtimeException, -1);
    }

    private ExoPlaybackException(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.type = i;
        this.rendererIndex = i2;
    }

    public IOException getSourceException() {
        com.google.android.exoplayer2.util.a.checkState(this.type == 0);
        return (IOException) getCause();
    }

    public Exception getRendererException() {
        com.google.android.exoplayer2.util.a.checkState(this.type == 1);
        return (Exception) getCause();
    }

    public RuntimeException getUnexpectedException() {
        com.google.android.exoplayer2.util.a.checkState(this.type == 2);
        return (RuntimeException) getCause();
    }
}

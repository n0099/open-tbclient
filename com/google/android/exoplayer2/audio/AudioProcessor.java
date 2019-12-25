package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes4.dex */
public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    boolean ae(int i, int i2, int i3) throws UnhandledFormatException;

    boolean ati();

    int drm();

    int drn();

    int dro();

    void drp();

    ByteBuffer drq();

    void flush();

    void i(ByteBuffer byteBuffer);

    boolean isActive();

    void reset();

    /* loaded from: classes4.dex */
    public static final class UnhandledFormatException extends Exception {
        public UnhandledFormatException(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
        }
    }
}

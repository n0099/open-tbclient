package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    boolean af(int i, int i2, int i3) throws UnhandledFormatException;

    boolean avR();

    int dtO();

    int dtP();

    int dtQ();

    void dtR();

    ByteBuffer dtS();

    void flush();

    void i(ByteBuffer byteBuffer);

    boolean isActive();

    void reset();

    /* loaded from: classes6.dex */
    public static final class UnhandledFormatException extends Exception {
        public UnhandledFormatException(int i, int i2, int i3) {
            super("Unhandled format: " + i + " Hz, " + i2 + " channels in encoding " + i3);
        }
    }
}

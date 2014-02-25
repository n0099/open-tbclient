package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class ClosedOutputStream extends OutputStream {
    public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();

    @Override // java.io.OutputStream
    public void write(int i) {
        throw new IOException("write(" + i + ") failed: stream is closed");
    }
}

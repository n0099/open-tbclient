package org.apache.commons.io.output;

import java.io.OutputStream;
/* loaded from: classes.dex */
public class NullOutputStream extends OutputStream {
    public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
    }

    @Override // java.io.OutputStream
    public void write(int i) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
    }
}

package org.apache.commons.codec.binary4util;

import java.io.OutputStream;
/* loaded from: classes8.dex */
public class Base64OutputStream extends BaseNCodecOutputStream {
    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z) {
        super(outputStream, new Base64(false), z);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z, int i2, byte[] bArr) {
        super(outputStream, new Base64(i2, bArr), z);
    }
}

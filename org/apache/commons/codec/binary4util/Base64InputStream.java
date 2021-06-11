package org.apache.commons.codec.binary4util;

import java.io.InputStream;
/* loaded from: classes8.dex */
public class Base64InputStream extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base64InputStream(InputStream inputStream, boolean z) {
        super(inputStream, new Base64(false), z);
    }

    public Base64InputStream(InputStream inputStream, boolean z, int i2, byte[] bArr) {
        super(inputStream, new Base64(i2, bArr), z);
    }
}

package org.msgpack.io;

import java.io.Closeable;
import java.io.Flushable;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface g extends Closeable, Flushable {
    void a(byte b);

    void a(byte b, byte b2);

    void a(byte b, double d);

    void a(byte b, float f);

    void a(byte b, int i);

    void a(byte b, long j);

    void a(byte b, short s);

    void a(ByteBuffer byteBuffer);

    void a(byte[] bArr, int i, int i2);
}

package org.msgpack.packer;

import java.io.Closeable;
import java.io.Flushable;
import java.math.BigInteger;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface a extends Closeable, Flushable {
    a a();

    a a(byte b);

    a a(double d);

    a a(float f);

    a a(int i);

    a a(long j);

    a a(Object obj);

    a a(Short sh);

    a a(String str);

    a a(BigInteger bigInteger);

    a a(ByteBuffer byteBuffer);

    a a(short s);

    a a(boolean z);

    a a(byte[] bArr);

    a b();

    a c(int i);

    a c(boolean z);

    a d();

    a d(int i);

    a d(boolean z);
}

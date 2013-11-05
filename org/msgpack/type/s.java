package org.msgpack.type;

import java.math.BigInteger;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class s {
    public static NilValue a() {
        return NilValue.a();
    }

    public static BooleanValue a(boolean z) {
        return z ? q.b() : i.b();
    }

    public static IntegerValue a(byte b) {
        return new IntValueImpl(b);
    }

    public static IntegerValue a(short s) {
        return new IntValueImpl(s);
    }

    public static IntegerValue a(int i) {
        return new IntValueImpl(i);
    }

    public static IntegerValue a(long j) {
        return new LongValueImpl(j);
    }

    public static IntegerValue a(BigInteger bigInteger) {
        return new BigIntegerValueImpl(bigInteger);
    }

    public static FloatValue a(float f) {
        return new FloatValueImpl(f);
    }

    public static FloatValue a(double d) {
        return new DoubleValueImpl(d);
    }

    public static RawValue b() {
        return g.a();
    }

    public static RawValue a(byte[] bArr) {
        return a(bArr, false);
    }

    public static RawValue a(byte[] bArr, boolean z) {
        return new g(bArr, z);
    }

    public static RawValue a(byte[] bArr, int i, int i2) {
        return new g(bArr, i, i2);
    }

    public static RawValue a(String str) {
        return new p(str);
    }

    public static RawValue a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        try {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new g(bArr, true);
        } finally {
            byteBuffer.position(position);
        }
    }

    public static ArrayValue c() {
        return f.b();
    }

    public static ArrayValue a(r[] rVarArr, boolean z) {
        return rVarArr.length == 0 ? f.b() : new f(rVarArr, z);
    }

    public static MapValue d() {
        return j.b();
    }

    public static MapValue b(r[] rVarArr, boolean z) {
        return rVarArr.length == 0 ? j.b() : new j(rVarArr, z);
    }
}

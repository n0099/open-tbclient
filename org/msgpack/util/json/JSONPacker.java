package org.msgpack.util.json;

import com.baidu.zeus.bouncycastle.DERTags;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.msgpack.MessageTypeException;
import org.msgpack.a;
import org.msgpack.io.g;
import org.msgpack.packer.AbstractPacker;
import org.msgpack.packer.b;
/* loaded from: classes.dex */
public class JSONPacker extends AbstractPacker {
    private static final byte[] c = {110, 117, 108, 108};
    private static final byte[] d = {116, 114, 117, 101};
    private static final byte[] e = {102, 97, 108, 115, 101};
    private static final int[] i = new int[DERTags.TAGGED];
    private static final byte[] j;
    protected final g b;
    private int[] f;
    private b g;
    private CharsetDecoder h;

    static {
        for (int i2 = 0; i2 < 32; i2++) {
            i[i2] = -1;
        }
        i[34] = 34;
        i[92] = 92;
        i[8] = 98;
        i[9] = 116;
        i[12] = 102;
        i[10] = 110;
        i[13] = 114;
        char[] charArray = "0123456789ABCDEF".toCharArray();
        j = new byte[charArray.length];
        for (int i3 = 0; i3 < charArray.length; i3++) {
            j[i3] = (byte) charArray[i3];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONPacker(a aVar, g gVar) {
        super(aVar);
        this.g = new b();
        this.b = gVar;
        this.g = new b();
        this.f = new int[DERTags.TAGGED];
        this.h = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(boolean z) {
        c();
        if (z) {
            this.b.a(d, 0, d.length);
        } else {
            this.b.a(e, 0, e.length);
        }
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(byte b) {
        c();
        byte[] bytes = Byte.toString(b).getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(short s) {
        c();
        byte[] bytes = Short.toString(s).getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(int i2) {
        c();
        byte[] bytes = Integer.toString(i2).getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(long j2) {
        c();
        byte[] bytes = Long.toString(j2).getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(BigInteger bigInteger) {
        c();
        byte[] bytes = bigInteger.toString().getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(float f) {
        c();
        Float valueOf = Float.valueOf(f);
        if (valueOf.isInfinite() || valueOf.isNaN()) {
            throw new IOException("JSONPacker doesn't support NaN and infinite float value");
        }
        byte[] bytes = Float.toString(f).getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(double d2) {
        c();
        Double valueOf = Double.valueOf(d2);
        if (valueOf.isInfinite() || valueOf.isNaN()) {
            throw new IOException("JSONPacker doesn't support NaN and infinite float value");
        }
        byte[] bytes = Double.toString(d2).getBytes();
        this.b.a(bytes, 0, bytes.length);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void a(byte[] bArr, int i2, int i3) {
        e();
        this.b.a((byte) 34);
        a(this.b, bArr, i2, i3);
        this.b.a((byte) 34);
        f();
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(ByteBuffer byteBuffer) {
        e();
        this.b.a((byte) 34);
        int position = byteBuffer.position();
        try {
            a(this.b, byteBuffer);
            byteBuffer.position(position);
            this.b.a((byte) 34);
            f();
        } catch (Throwable th) {
            byteBuffer.position(position);
            throw th;
        }
    }

    @Override // org.msgpack.packer.AbstractPacker
    protected void b(String str) {
        e();
        this.b.a((byte) 34);
        a(this.b, str);
        this.b.a((byte) 34);
        f();
    }

    @Override // org.msgpack.packer.a
    public org.msgpack.packer.a d() {
        c();
        this.b.a(c, 0, c.length);
        f();
        return this;
    }

    @Override // org.msgpack.packer.a
    public org.msgpack.packer.a c(int i2) {
        c();
        this.b.a((byte) 91);
        f();
        this.g.a(i2);
        this.f[this.g.d()] = 1;
        return this;
    }

    @Override // org.msgpack.packer.a
    public org.msgpack.packer.a c(boolean z) {
        if (!this.g.f()) {
            throw new MessageTypeException("writeArrayEnd() is called but writeArrayBegin() is not called");
        }
        int e2 = this.g.e();
        if (e2 > 0) {
            if (z) {
                throw new MessageTypeException("writeArrayEnd(check=true) is called but the array is not end: " + e2);
            }
            for (int i2 = 0; i2 < e2; i2++) {
                d();
            }
        }
        this.g.c();
        this.b.a((byte) 93);
        return this;
    }

    @Override // org.msgpack.packer.a
    public org.msgpack.packer.a d(int i2) {
        c();
        this.b.a((byte) 123);
        f();
        this.g.b(i2);
        this.f[this.g.d()] = 3;
        return this;
    }

    @Override // org.msgpack.packer.a
    public org.msgpack.packer.a d(boolean z) {
        if (!this.g.g()) {
            throw new MessageTypeException("writeMapEnd() is called but writeMapBegin() is not called");
        }
        int e2 = this.g.e();
        if (e2 > 0) {
            if (z) {
                throw new MessageTypeException("writeMapEnd(check=true) is called but the map is not end: " + e2);
            }
            for (int i2 = 0; i2 < e2; i2++) {
                d();
            }
        }
        this.g.c();
        this.b.a((byte) 125);
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
        this.b.flush();
    }

    @Override // org.msgpack.packer.AbstractPacker, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.close();
    }

    private void c() {
        if ((this.f[this.g.d()] & 2) != 0) {
            throw new IOException("Key of a map must be a string in JSON");
        }
        e();
    }

    private void e() {
        int i2 = this.f[this.g.d()];
        if ((i2 & 4) != 0) {
            this.b.a((byte) 58);
        } else if (this.g.d() > 0 && (i2 & 1) == 0) {
            this.b.a((byte) 44);
        }
    }

    private void f() {
        int i2 = this.f[this.g.d()];
        if ((i2 & 2) != 0) {
            i2 = (i2 & (-3)) | 4;
        } else if ((i2 & 4) != 0) {
            i2 = (i2 & (-5)) | 2;
        }
        this.f[this.g.d()] = i2 & (-2);
        this.g.b();
    }

    private void a(g gVar, byte[] bArr, int i2, int i3) {
        a(gVar, ByteBuffer.wrap(bArr, i2, i3));
    }

    private void a(g gVar, ByteBuffer byteBuffer) {
        a(gVar, this.h.decode(byteBuffer).toString());
    }

    private static void a(g gVar, String str) {
        char[] charArray;
        byte[] bArr = new byte[6];
        bArr[0] = 92;
        bArr[1] = 117;
        for (char c2 : str.toCharArray()) {
            if (c2 <= 127) {
                int i2 = i[c2];
                if (i2 == 0) {
                    bArr[2] = (byte) c2;
                    gVar.a(bArr, 2, 1);
                } else if (i2 > 0) {
                    bArr[2] = 92;
                    bArr[3] = (byte) i2;
                    gVar.a(bArr, 2, 2);
                } else {
                    bArr[2] = 48;
                    bArr[3] = 48;
                    bArr[4] = j[c2 >> 4];
                    bArr[5] = j[c2 & 15];
                    gVar.a(bArr, 0, 6);
                }
            } else if (c2 <= 2047) {
                bArr[2] = (byte) ((c2 >> 6) | 192);
                bArr[3] = (byte) ((c2 & '?') | DERTags.TAGGED);
                gVar.a(bArr, 2, 2);
            } else if (c2 >= 55296 && c2 <= 57343) {
                bArr[2] = j[(c2 >> '\f') & 15];
                bArr[3] = j[(c2 >> '\b') & 15];
                bArr[4] = j[(c2 >> 4) & 15];
                bArr[5] = j[c2 & 15];
                gVar.a(bArr, 0, 6);
            } else {
                bArr[2] = (byte) ((c2 >> '\f') | 224);
                bArr[3] = (byte) (((c2 >> 6) & 63) | DERTags.TAGGED);
                bArr[4] = (byte) ((c2 & '?') | DERTags.TAGGED);
                gVar.a(bArr, 2, 3);
            }
        }
    }
}

package org.msgpack.type;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private static g f2942a = new g(new byte[0], true);
    private static final ThreadLocal<CharsetDecoder> b = new h();
    private byte[] c;

    public static RawValue a() {
        return f2942a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(byte[] bArr, boolean z) {
        if (z) {
            this.c = bArr;
            return;
        }
        this.c = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.c, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(byte[] bArr, int i, int i2) {
        this.c = new byte[i2];
        System.arraycopy(bArr, i, this.c, 0, i2);
    }

    @Override // org.msgpack.type.RawValue
    public byte[] b() {
        return this.c;
    }

    @Override // org.msgpack.type.RawValue
    public String c() {
        try {
            return b.get().decode(ByteBuffer.wrap(this.c)).toString();
        } catch (CharacterCodingException e) {
            throw new MessageTypeException(e);
        }
    }

    @Override // org.msgpack.type.r
    public void writeTo(org.msgpack.packer.a aVar) {
        aVar.a(this.c);
    }

    @Override // org.msgpack.type.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.isRawValue()) {
                return Arrays.equals(this.c, rVar.asRawValue().b());
            }
            return false;
        }
        return false;
    }

    @Override // org.msgpack.type.d
    public int hashCode() {
        return Arrays.hashCode(this.c);
    }
}

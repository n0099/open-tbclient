package org.msgpack.unpacker;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    String f2961a;
    private CharsetDecoder b;

    public j() {
        super("raw value");
        this.b = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a(byte[] bArr) {
        try {
            this.f2961a = this.b.decode(ByteBuffer.wrap(bArr)).toString();
        } catch (CharacterCodingException e) {
            throw new MessageTypeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.msgpack.unpacker.a
    public void a() {
        this.f2961a = "";
    }

    @Override // org.msgpack.unpacker.a, org.msgpack.io.b
    public void a(ByteBuffer byteBuffer, boolean z) {
        try {
            this.f2961a = this.b.decode(byteBuffer).toString();
        } catch (CharacterCodingException e) {
            throw new MessageTypeException(e);
        }
    }
}

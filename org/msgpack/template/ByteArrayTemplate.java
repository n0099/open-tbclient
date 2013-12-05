package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ByteArrayTemplate extends AbstractTemplate<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    static final ByteArrayTemplate f3069a = new ByteArrayTemplate();

    private ByteArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(bArr);
    }

    public static ByteArrayTemplate a() {
        return f3069a;
    }
}

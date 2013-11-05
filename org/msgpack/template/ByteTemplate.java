package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ByteTemplate extends AbstractTemplate<Byte> {

    /* renamed from: a  reason: collision with root package name */
    static final ByteTemplate f2858a = new ByteTemplate();

    private ByteTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Byte b, boolean z) {
        if (b == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(b.byteValue());
    }

    public static ByteTemplate a() {
        return f2858a;
    }
}

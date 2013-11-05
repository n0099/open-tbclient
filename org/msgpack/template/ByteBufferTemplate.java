package org.msgpack.template;

import java.nio.ByteBuffer;
import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class ByteBufferTemplate extends AbstractTemplate<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    static final ByteBufferTemplate f2857a = new ByteBufferTemplate();

    private ByteBufferTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(byteBuffer);
    }

    public static ByteBufferTemplate a() {
        return f2857a;
    }
}

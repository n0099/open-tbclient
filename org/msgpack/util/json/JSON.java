package org.msgpack.util.json;

import org.msgpack.a;
import org.msgpack.packer.BufferPacker;
import org.msgpack.unpacker.BufferUnpacker;
/* loaded from: classes.dex */
public class JSON extends a {
    @Override // org.msgpack.a
    public BufferPacker a() {
        return new JSONBufferPacker(this);
    }

    @Override // org.msgpack.a
    public BufferUnpacker b() {
        return new JSONBufferUnpacker();
    }

    @Override // org.msgpack.a
    public BufferUnpacker a(byte[] bArr, int i, int i2) {
        return b().a(bArr, i, i2);
    }
}

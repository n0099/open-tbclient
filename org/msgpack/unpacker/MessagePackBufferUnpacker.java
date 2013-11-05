package org.msgpack.unpacker;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import org.msgpack.io.LinkedBufferInput;
/* loaded from: classes.dex */
public class MessagePackBufferUnpacker extends MessagePackUnpacker implements BufferUnpacker {
    public MessagePackBufferUnpacker(org.msgpack.a aVar) {
        this(aVar, ImageManager.DEFAULT_MAX_CACHEABLE_SIZE);
    }

    public MessagePackBufferUnpacker(org.msgpack.a aVar, int i) {
        super(aVar, new LinkedBufferInput(i));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.unpacker.BufferUnpacker
    /* renamed from: b */
    public MessagePackBufferUnpacker a(byte[] bArr, int i, int i2) {
        ((LinkedBufferInput) this.e).j();
        ((LinkedBufferInput) this.e).a(bArr, i, i2, true);
        return this;
    }
}

package org.msgpack.packer;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import org.msgpack.io.LinkedBufferOutput;
/* loaded from: classes.dex */
public class MessagePackBufferPacker extends MessagePackPacker implements BufferPacker {
    public MessagePackBufferPacker(org.msgpack.a aVar) {
        this(aVar, ImageManager.DEFAULT_MAX_CACHEABLE_SIZE);
    }

    public MessagePackBufferPacker(org.msgpack.a aVar, int i) {
        super(aVar, new LinkedBufferOutput(i));
    }

    @Override // org.msgpack.packer.BufferPacker
    public byte[] c() {
        return ((LinkedBufferOutput) this.b).a();
    }
}

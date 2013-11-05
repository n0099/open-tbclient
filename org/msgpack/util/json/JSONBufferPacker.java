package org.msgpack.util.json;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import org.msgpack.a;
import org.msgpack.io.LinkedBufferOutput;
import org.msgpack.packer.BufferPacker;
/* loaded from: classes.dex */
public class JSONBufferPacker extends JSONPacker implements BufferPacker {
    public JSONBufferPacker() {
        this((int) ImageManager.DEFAULT_MAX_CACHEABLE_SIZE);
    }

    public JSONBufferPacker(int i) {
        this(new a(), i);
    }

    public JSONBufferPacker(a aVar) {
        this(aVar, ImageManager.DEFAULT_MAX_CACHEABLE_SIZE);
    }

    public JSONBufferPacker(a aVar, int i) {
        super(aVar, new LinkedBufferOutput(i));
    }

    @Override // org.msgpack.packer.BufferPacker
    public byte[] c() {
        return ((LinkedBufferOutput) this.b).a();
    }
}

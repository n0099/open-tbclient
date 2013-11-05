package org.msgpack.util.json;

import com.baidu.cloudsdk.common.imgloader.ImageManager;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.msgpack.a;
import org.msgpack.unpacker.BufferUnpacker;
/* loaded from: classes.dex */
public class JSONBufferUnpacker extends JSONUnpacker implements BufferUnpacker {
    public JSONBufferUnpacker() {
        this(ImageManager.DEFAULT_MAX_CACHEABLE_SIZE);
    }

    public JSONBufferUnpacker(int i) {
        this(new a(), i);
    }

    public JSONBufferUnpacker(a aVar, int i) {
        super(aVar, d());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.unpacker.BufferUnpacker
    /* renamed from: b */
    public JSONBufferUnpacker a(byte[] bArr, int i, int i2) {
        this.f = new InputStreamReader(new ByteArrayInputStream(bArr, i, i2));
        return this;
    }

    private static Reader d() {
        return new InputStreamReader(new ByteArrayInputStream(new byte[0]));
    }
}

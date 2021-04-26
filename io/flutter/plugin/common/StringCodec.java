package io.flutter.plugin.common;

import com.google.zxing.common.StringUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
/* loaded from: classes7.dex */
public final class StringCodec implements MessageCodec<String> {
    public static final Charset UTF8 = Charset.forName(StringUtils.UTF8);
    public static final StringCodec INSTANCE = new StringCodec();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public String decodeMessage(ByteBuffer byteBuffer) {
        byte[] bArr;
        int i2;
        if (byteBuffer == null) {
            return null;
        }
        int remaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i2 = byteBuffer.arrayOffset();
        } else {
            bArr = new byte[remaining];
            byteBuffer.get(bArr);
            i2 = 0;
        }
        return new String(bArr, i2, remaining, UTF8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.flutter.plugin.common.MessageCodec
    public ByteBuffer encodeMessage(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(UTF8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}

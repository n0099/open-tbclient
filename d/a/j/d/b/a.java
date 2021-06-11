package d.a.j.d.b;

import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public final class a {
    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2) {
        if (i2 < 0 || byteBuffer2.remaining() < i2 || byteBuffer3.remaining() < i2 || byteBuffer.remaining() < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }
}

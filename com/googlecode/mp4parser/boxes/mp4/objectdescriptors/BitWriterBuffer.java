package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class BitWriterBuffer {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public ByteBuffer buffer;
    public int initialPos;
    public int position = 0;

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public void writeBits(int i2, int i3) {
        int i4 = this.position;
        int i5 = 8 - (i4 % 8);
        if (i3 <= i5) {
            int i6 = this.buffer.get(this.initialPos + (i4 / 8));
            if (i6 < 0) {
                i6 += 256;
            }
            int i7 = i6 + (i2 << (i5 - i3));
            ByteBuffer byteBuffer = this.buffer;
            int i8 = this.initialPos + (this.position / 8);
            if (i7 > 127) {
                i7 -= 256;
            }
            byteBuffer.put(i8, (byte) i7);
            this.position += i3;
        } else {
            int i9 = i3 - i5;
            writeBits(i2 >> i9, i5);
            writeBits(i2 & ((1 << i9) - 1), i9);
        }
        ByteBuffer byteBuffer2 = this.buffer;
        int i10 = this.initialPos;
        int i11 = this.position;
        byteBuffer2.position(i10 + (i11 / 8) + (i11 % 8 <= 0 ? 0 : 1));
    }
}

package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import androidx.core.view.InputDeviceCompat;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class BitWriterBuffer {
    static final /* synthetic */ boolean $assertionsDisabled;
    private ByteBuffer buffer;
    int initialPos;
    int position = 0;

    static {
        $assertionsDisabled = !BitWriterBuffer.class.desiredAssertionStatus();
    }

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public void writeBits(int i, int i2) {
        if (!$assertionsDisabled && i > (1 << i2) - 1) {
            throw new AssertionError(String.format("Trying to write a value bigger (%s) than the number bits (%s) allows. Please mask the value before writing it and make your code is really working as intended.", Integer.valueOf(i), Integer.valueOf((1 << i2) - 1)));
        }
        int i3 = 8 - (this.position % 8);
        if (i2 <= i3) {
            int i4 = this.buffer.get(this.initialPos + (this.position / 8));
            if (i4 < 0) {
                i4 += 256;
            }
            int i5 = i4 + (i << (i3 - i2));
            ByteBuffer byteBuffer = this.buffer;
            int i6 = this.initialPos + (this.position / 8);
            if (i5 > 127) {
                i5 += InputDeviceCompat.SOURCE_ANY;
            }
            byteBuffer.put(i6, (byte) i5);
            this.position += i2;
        } else {
            int i7 = i2 - i3;
            writeBits(i >> i7, i3);
            writeBits(((1 << i7) - 1) & i, i7);
        }
        this.buffer.position((this.position % 8 > 0 ? 1 : 0) + (this.position / 8) + this.initialPos);
    }
}

package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import android.support.v4.view.MotionEventCompat;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class BitReaderBuffer {
    private ByteBuffer buffer;
    int initialPos;
    int position;

    public BitReaderBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public int readBits(int i) {
        int readBits;
        int i2 = this.buffer.get(this.initialPos + (this.position / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = 8 - (this.position % 8);
        if (i <= i3) {
            readBits = ((i2 << (this.position % 8)) & MotionEventCompat.ACTION_MASK) >> ((i3 - i) + (this.position % 8));
            this.position += i;
        } else {
            int i4 = i - i3;
            readBits = readBits(i4) + (readBits(i3) << i4);
        }
        this.buffer.position(this.initialPos + ((int) Math.ceil(this.position / 8.0d)));
        return readBits;
    }

    public int getPosition() {
        return this.position;
    }

    public int byteSync() {
        int i = 8 - (this.position % 8);
        if (i == 8) {
            i = 0;
        }
        readBits(i);
        return i;
    }

    public int remainingBits() {
        return (this.buffer.limit() * 8) - this.position;
    }
}

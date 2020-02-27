package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] maV;
    private int[] maW;
    private boolean maY;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maX = EMPTY_BUFFER;
    private int channelCount = -1;
    private int maU = -1;

    public void n(int[] iArr) {
        this.maV = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.maV, this.maW);
        this.maW = this.maV;
        if (this.maW == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.maU == i && this.channelCount == i2) {
                return false;
            }
            this.maU = i;
            this.channelCount = i2;
            this.active = i2 != this.maW.length;
            int i4 = 0;
            while (i4 < this.maW.length) {
                int i5 = this.maW[i4];
                if (i5 >= i2) {
                    throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
                }
                this.active = (i5 != i4) | this.active;
                i4++;
            }
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.active;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtL() {
        return this.maW == null ? this.channelCount : this.maW.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtM() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtN() {
        return this.maU;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.maW.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.maW) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.maX = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtO() {
        this.maY = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dtP() {
        ByteBuffer byteBuffer = this.maX;
        this.maX = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean avP() {
        return this.maY && this.maX == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.maX = EMPTY_BUFFER;
        this.maY = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.maU = -1;
        this.maW = null;
        this.active = false;
    }
}

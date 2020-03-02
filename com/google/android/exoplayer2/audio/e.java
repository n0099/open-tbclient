package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] maX;
    private int[] maY;
    private boolean mba;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maZ = EMPTY_BUFFER;
    private int channelCount = -1;
    private int maW = -1;

    public void n(int[] iArr) {
        this.maX = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.maX, this.maY);
        this.maY = this.maX;
        if (this.maY == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.maW == i && this.channelCount == i2) {
                return false;
            }
            this.maW = i;
            this.channelCount = i2;
            this.active = i2 != this.maY.length;
            int i4 = 0;
            while (i4 < this.maY.length) {
                int i5 = this.maY[i4];
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
    public int dtN() {
        return this.maY == null ? this.channelCount : this.maY.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtO() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtP() {
        return this.maW;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.maY.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.maY) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.maZ = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtQ() {
        this.mba = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dtR() {
        ByteBuffer byteBuffer = this.maZ;
        this.maZ = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean avR() {
        return this.mba && this.maZ == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.maZ = EMPTY_BUFFER;
        this.mba = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.maW = -1;
        this.maY = null;
        this.active = false;
    }
}

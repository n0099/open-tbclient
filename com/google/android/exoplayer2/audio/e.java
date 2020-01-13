package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] mai;
    private int[] maj;
    private boolean mal;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mak = EMPTY_BUFFER;
    private int channelCount = -1;
    private int mah = -1;

    public void o(int[] iArr) {
        this.mai = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.mai, this.maj);
        this.maj = this.mai;
        if (this.maj == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.mah == i && this.channelCount == i2) {
                return false;
            }
            this.mah = i;
            this.channelCount = i2;
            this.active = i2 != this.maj.length;
            int i4 = 0;
            while (i4 < this.maj.length) {
                int i5 = this.maj[i4];
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
    public int dsy() {
        return this.maj == null ? this.channelCount : this.maj.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dsz() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dsA() {
        return this.mah;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.maj.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.maj) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.mak = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dsB() {
        this.mal = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dsC() {
        ByteBuffer byteBuffer = this.mak;
        this.mak = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean atB() {
        return this.mal && this.mak == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mak = EMPTY_BUFFER;
        this.mal = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mah = -1;
        this.maj = null;
        this.active = false;
    }
}

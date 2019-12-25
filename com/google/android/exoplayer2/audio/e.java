package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes4.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] lWs;
    private int[] lWt;
    private boolean lWv;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer lWu = EMPTY_BUFFER;
    private int channelCount = -1;
    private int lWr = -1;

    public void o(int[] iArr) {
        this.lWs = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.lWs, this.lWt);
        this.lWt = this.lWs;
        if (this.lWt == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.lWr == i && this.channelCount == i2) {
                return false;
            }
            this.lWr = i;
            this.channelCount = i2;
            this.active = i2 != this.lWt.length;
            int i4 = 0;
            while (i4 < this.lWt.length) {
                int i5 = this.lWt[i4];
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
    public int drm() {
        return this.lWt == null ? this.channelCount : this.lWt.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int drn() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dro() {
        return this.lWr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.lWt.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.lWt) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.lWu = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void drp() {
        this.lWv = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer drq() {
        ByteBuffer byteBuffer = this.lWu;
        this.lWu = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ati() {
        return this.lWv && this.lWu == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.lWu = EMPTY_BUFFER;
        this.lWv = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.lWr = -1;
        this.lWt = null;
        this.active = false;
    }
}

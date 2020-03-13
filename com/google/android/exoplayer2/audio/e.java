package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] mbi;
    private int[] mbj;
    private boolean mbl;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mbk = EMPTY_BUFFER;
    private int channelCount = -1;
    private int mbh = -1;

    public void n(int[] iArr) {
        this.mbi = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.mbi, this.mbj);
        this.mbj = this.mbi;
        if (this.mbj == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.mbh == i && this.channelCount == i2) {
                return false;
            }
            this.mbh = i;
            this.channelCount = i2;
            this.active = i2 != this.mbj.length;
            int i4 = 0;
            while (i4 < this.mbj.length) {
                int i5 = this.mbj[i4];
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
    public int dtO() {
        return this.mbj == null ? this.channelCount : this.mbj.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtP() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtQ() {
        return this.mbh;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.mbj.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.mbj) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.mbk = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtR() {
        this.mbl = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dtS() {
        ByteBuffer byteBuffer = this.mbk;
        this.mbk = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean avR() {
        return this.mbl && this.mbk == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mbk = EMPTY_BUFFER;
        this.mbl = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mbh = -1;
        this.mbj = null;
        this.active = false;
    }
}

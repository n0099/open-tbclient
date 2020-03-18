package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes6.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] mcO;
    private int[] mcP;
    private boolean mcR;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mcQ = EMPTY_BUFFER;
    private int channelCount = -1;
    private int mcN = -1;

    public void n(int[] iArr) {
        this.mcO = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.mcO, this.mcP);
        this.mcP = this.mcO;
        if (this.mcP == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.mcN == i && this.channelCount == i2) {
                return false;
            }
            this.mcN = i;
            this.channelCount = i2;
            this.active = i2 != this.mcP.length;
            int i4 = 0;
            while (i4 < this.mcP.length) {
                int i5 = this.mcP[i4];
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
    public int dul() {
        return this.mcP == null ? this.channelCount : this.mcP.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dum() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dun() {
        return this.mcN;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.mcP.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.mcP) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.mcQ = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void duo() {
        this.mcR = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dup() {
        ByteBuffer byteBuffer = this.mcQ;
        this.mcQ = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean avU() {
        return this.mcR && this.mcQ == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mcQ = EMPTY_BUFFER;
        this.mcR = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mcN = -1;
        this.mcP = null;
        this.active = false;
    }
}

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes5.dex */
final class e implements AudioProcessor {
    private boolean active;
    private int[] man;
    private int[] mao;
    private boolean mar;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maq = EMPTY_BUFFER;
    private int channelCount = -1;
    private int mam = -1;

    public void o(int[] iArr) {
        this.man = iArr;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        boolean z = !Arrays.equals(this.man, this.mao);
        this.mao = this.man;
        if (this.mao == null) {
            this.active = false;
            return z;
        } else if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        } else {
            if (!z && this.mam == i && this.channelCount == i2) {
                return false;
            }
            this.mam = i;
            this.channelCount = i2;
            this.active = i2 != this.mao.length;
            int i4 = 0;
            while (i4 < this.mao.length) {
                int i5 = this.mao[i4];
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
    public int dsA() {
        return this.mao == null ? this.channelCount : this.mao.length;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dsB() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dsC() {
        return this.mam;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = ((limit - position) / (this.channelCount * 2)) * this.mao.length * 2;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            i = position;
        } else {
            this.buffer.clear();
            i = position;
        }
        while (i < limit) {
            for (int i2 : this.mao) {
                this.buffer.putShort(byteBuffer.getShort((i2 * 2) + i));
            }
            i = (this.channelCount * 2) + i;
        }
        byteBuffer.position(limit);
        this.buffer.flip();
        this.maq = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dsD() {
        this.mar = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dsE() {
        ByteBuffer byteBuffer = this.maq;
        this.maq = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean atB() {
        return this.mar && this.maq == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.maq = EMPTY_BUFFER;
        this.mar = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mam = -1;
        this.mao = null;
        this.active = false;
    }
}

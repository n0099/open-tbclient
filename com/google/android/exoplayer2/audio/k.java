package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes4.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int lWr;
    private boolean lWv;
    private int lYA;
    private int lYB;
    private int lYC;
    private byte[] lYD;
    private int lYE;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer lWu = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dI(int i, int i2) {
        this.lYA = i;
        this.lYB = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.lWr = i;
        this.lYD = new byte[this.lYB * i2 * 2];
        this.lYE = 0;
        this.lYC = this.lYA * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.lYA == 0 && this.lYB == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int drm() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.lYC);
        this.lYC -= min;
        byteBuffer.position(position + min);
        if (this.lYC <= 0) {
            int i2 = i - min;
            int length = (this.lYE + i2) - this.lYD.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int al = v.al(length, 0, this.lYE);
            this.buffer.put(this.lYD, 0, al);
            int al2 = v.al(length - al, 0, i2);
            byteBuffer.limit(byteBuffer.position() + al2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - al2;
            this.lYE -= al;
            System.arraycopy(this.lYD, al, this.lYD, 0, this.lYE);
            byteBuffer.get(this.lYD, this.lYE, i3);
            this.lYE = i3 + this.lYE;
            this.buffer.flip();
            this.lWu = this.buffer;
        }
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
        this.lYC = 0;
        this.lYE = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.lWr = -1;
        this.lYD = null;
    }
}

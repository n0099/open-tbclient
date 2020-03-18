package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int mcN;
    private boolean mcR;
    private int meW;
    private int meX;
    private int meY;
    private byte[] meZ;
    private int mfa;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mcQ = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dK(int i, int i2) {
        this.meW = i;
        this.meX = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.mcN = i;
        this.meZ = new byte[this.meX * i2 * 2];
        this.mfa = 0;
        this.meY = this.meW * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.meW == 0 && this.meX == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dul() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.meY);
        this.meY -= min;
        byteBuffer.position(position + min);
        if (this.meY <= 0) {
            int i2 = i - min;
            int length = (this.mfa + i2) - this.meZ.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int am = v.am(length, 0, this.mfa);
            this.buffer.put(this.meZ, 0, am);
            int am2 = v.am(length - am, 0, i2);
            byteBuffer.limit(byteBuffer.position() + am2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - am2;
            this.mfa -= am;
            System.arraycopy(this.meZ, am, this.meZ, 0, this.mfa);
            byteBuffer.get(this.meZ, this.mfa, i3);
            this.mfa = i3 + this.mfa;
            this.buffer.flip();
            this.mcQ = this.buffer;
        }
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
        this.meY = 0;
        this.mfa = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mcN = -1;
        this.meZ = null;
    }
}

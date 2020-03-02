package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int maW;
    private boolean mba;
    private int mdf;
    private int mdg;
    private int mdh;
    private byte[] mdi;
    private int mdj;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maZ = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dJ(int i, int i2) {
        this.mdf = i;
        this.mdg = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.maW = i;
        this.mdi = new byte[this.mdg * i2 * 2];
        this.mdj = 0;
        this.mdh = this.mdf * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.mdf == 0 && this.mdg == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtN() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.mdh);
        this.mdh -= min;
        byteBuffer.position(position + min);
        if (this.mdh <= 0) {
            int i2 = i - min;
            int length = (this.mdj + i2) - this.mdi.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int am = v.am(length, 0, this.mdj);
            this.buffer.put(this.mdi, 0, am);
            int am2 = v.am(length - am, 0, i2);
            byteBuffer.limit(byteBuffer.position() + am2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - am2;
            this.mdj -= am;
            System.arraycopy(this.mdi, am, this.mdi, 0, this.mdj);
            byteBuffer.get(this.mdi, this.mdj, i3);
            this.mdj = i3 + this.mdj;
            this.buffer.flip();
            this.maZ = this.buffer;
        }
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
        this.mdh = 0;
        this.mdj = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.maW = -1;
        this.mdi = null;
    }
}

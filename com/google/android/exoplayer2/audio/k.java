package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int maU;
    private boolean maY;
    private int mdd;
    private int mde;
    private int mdf;
    private byte[] mdg;
    private int mdh;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maX = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dJ(int i, int i2) {
        this.mdd = i;
        this.mde = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.maU = i;
        this.mdg = new byte[this.mde * i2 * 2];
        this.mdh = 0;
        this.mdf = this.mdd * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.mdd == 0 && this.mde == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtL() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.mdf);
        this.mdf -= min;
        byteBuffer.position(position + min);
        if (this.mdf <= 0) {
            int i2 = i - min;
            int length = (this.mdh + i2) - this.mdg.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int am = v.am(length, 0, this.mdh);
            this.buffer.put(this.mdg, 0, am);
            int am2 = v.am(length - am, 0, i2);
            byteBuffer.limit(byteBuffer.position() + am2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - am2;
            this.mdh -= am;
            System.arraycopy(this.mdg, am, this.mdg, 0, this.mdh);
            byteBuffer.get(this.mdg, this.mdh, i3);
            this.mdh = i3 + this.mdh;
            this.buffer.flip();
            this.maX = this.buffer;
        }
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
        this.mdf = 0;
        this.mdh = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.maU = -1;
        this.mdg = null;
    }
}

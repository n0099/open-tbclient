package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int mah;
    private boolean mal;
    private int mcs;
    private int mct;
    private int mcu;
    private byte[] mcv;
    private int mcw;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mak = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dG(int i, int i2) {
        this.mcs = i;
        this.mct = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.mah = i;
        this.mcv = new byte[this.mct * i2 * 2];
        this.mcw = 0;
        this.mcu = this.mcs * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.mcs == 0 && this.mct == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dsy() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.mcu);
        this.mcu -= min;
        byteBuffer.position(position + min);
        if (this.mcu <= 0) {
            int i2 = i - min;
            int length = (this.mcw + i2) - this.mcv.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int al = v.al(length, 0, this.mcw);
            this.buffer.put(this.mcv, 0, al);
            int al2 = v.al(length - al, 0, i2);
            byteBuffer.limit(byteBuffer.position() + al2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - al2;
            this.mcw -= al;
            System.arraycopy(this.mcv, al, this.mcv, 0, this.mcw);
            byteBuffer.get(this.mcv, this.mcw, i3);
            this.mcw = i3 + this.mcw;
            this.buffer.flip();
            this.mak = this.buffer;
        }
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
        this.mcu = 0;
        this.mcw = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mah = -1;
        this.mcv = null;
    }
}

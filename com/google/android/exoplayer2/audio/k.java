package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int mam;
    private boolean mar;
    private byte[] mcA;
    private int mcB;
    private int mcx;
    private int mcy;
    private int mcz;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maq = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dG(int i, int i2) {
        this.mcx = i;
        this.mcy = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.mam = i;
        this.mcA = new byte[this.mcy * i2 * 2];
        this.mcB = 0;
        this.mcz = this.mcx * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.mcx == 0 && this.mcy == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dsA() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.mcz);
        this.mcz -= min;
        byteBuffer.position(position + min);
        if (this.mcz <= 0) {
            int i2 = i - min;
            int length = (this.mcB + i2) - this.mcA.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int al = v.al(length, 0, this.mcB);
            this.buffer.put(this.mcA, 0, al);
            int al2 = v.al(length - al, 0, i2);
            byteBuffer.limit(byteBuffer.position() + al2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - al2;
            this.mcB -= al;
            System.arraycopy(this.mcA, al, this.mcA, 0, this.mcB);
            byteBuffer.get(this.mcA, this.mcB, i3);
            this.mcB = i3 + this.mcB;
            this.buffer.flip();
            this.maq = this.buffer;
        }
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
        this.mcz = 0;
        this.mcB = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mam = -1;
        this.mcA = null;
    }
}

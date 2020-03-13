package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
final class k implements AudioProcessor {
    private boolean isActive;
    private int mbh;
    private boolean mbl;
    private int mdq;
    private int mdr;
    private int mds;
    private byte[] mdt;
    private int mdu;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mbk = EMPTY_BUFFER;
    private int channelCount = -1;

    public void dJ(int i, int i2) {
        this.mdq = i;
        this.mdr = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.mbh = i;
        this.mdt = new byte[this.mdr * i2 * 2];
        this.mdu = 0;
        this.mds = this.mdq * i2 * 2;
        boolean z = this.isActive;
        this.isActive = (this.mdq == 0 && this.mdr == 0) ? false : true;
        return z != this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dtO() {
        return this.channelCount;
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
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.mds);
        this.mds -= min;
        byteBuffer.position(position + min);
        if (this.mds <= 0) {
            int i2 = i - min;
            int length = (this.mdu + i2) - this.mdt.length;
            if (this.buffer.capacity() < length) {
                this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
            } else {
                this.buffer.clear();
            }
            int am = v.am(length, 0, this.mdu);
            this.buffer.put(this.mdt, 0, am);
            int am2 = v.am(length - am, 0, i2);
            byteBuffer.limit(byteBuffer.position() + am2);
            this.buffer.put(byteBuffer);
            byteBuffer.limit(limit);
            int i3 = i2 - am2;
            this.mdu -= am;
            System.arraycopy(this.mdt, am, this.mdt, 0, this.mdu);
            byteBuffer.get(this.mdt, this.mdu, i3);
            this.mdu = i3 + this.mdu;
            this.buffer.flip();
            this.mbk = this.buffer;
        }
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
        this.mds = 0;
        this.mdu = 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mbh = -1;
        this.mdt = null;
    }
}

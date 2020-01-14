package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes5.dex */
public final class j implements AudioProcessor {
    private boolean mar;
    private i mcs;
    private long mcv;
    private long mcw;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int mam = -1;
    private int mct = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer mcu = this.buffer.asShortBuffer();
    private ByteBuffer maq = EMPTY_BUFFER;
    private int mcr = -1;

    public float bx(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float by(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fL(long j) {
        if (this.mcw >= 1024) {
            if (this.mct == this.mam) {
                return v.h(j, this.mcv, this.mcw);
            }
            return v.h(j, this.mct * this.mcv, this.mam * this.mcw);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.mcr == -1 ? i : this.mcr;
        if (this.mam == i && this.channelCount == i2 && this.mct == i4) {
            return false;
        }
        this.mam = i;
        this.channelCount = i2;
        this.mct = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.mct != this.mam;
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
        return this.mct;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.mcv += remaining;
            this.mcs.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int dte = this.mcs.dte() * this.channelCount * 2;
        if (dte > 0) {
            if (this.buffer.capacity() < dte) {
                this.buffer = ByteBuffer.allocateDirect(dte).order(ByteOrder.nativeOrder());
                this.mcu = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.mcu.clear();
            }
            this.mcs.c(this.mcu);
            this.mcw += dte;
            this.buffer.limit(dte);
            this.maq = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dsD() {
        this.mcs.dsD();
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
        return this.mar && (this.mcs == null || this.mcs.dte() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mcs = new i(this.mam, this.channelCount, this.speed, this.pitch, this.mct);
        this.maq = EMPTY_BUFFER;
        this.mcv = 0L;
        this.mcw = 0L;
        this.mar = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.mcs = null;
        this.buffer = EMPTY_BUFFER;
        this.mcu = this.buffer.asShortBuffer();
        this.maq = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mam = -1;
        this.mct = -1;
        this.mcv = 0L;
        this.mcw = 0L;
        this.mar = false;
        this.mcr = -1;
    }
}

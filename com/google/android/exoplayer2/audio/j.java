package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes5.dex */
public final class j implements AudioProcessor {
    private boolean mal;
    private i mcn;
    private long mcq;
    private long mcr;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int mah = -1;
    private int mco = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer mcp = this.buffer.asShortBuffer();
    private ByteBuffer mak = EMPTY_BUFFER;
    private int mcm = -1;

    public float bx(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float by(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fL(long j) {
        if (this.mcr >= 1024) {
            if (this.mco == this.mah) {
                return v.h(j, this.mcq, this.mcr);
            }
            return v.h(j, this.mco * this.mcq, this.mah * this.mcr);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.mcm == -1 ? i : this.mcm;
        if (this.mah == i && this.channelCount == i2 && this.mco == i4) {
            return false;
        }
        this.mah = i;
        this.channelCount = i2;
        this.mco = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.mco != this.mah;
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
        return this.mco;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.mcq += remaining;
            this.mcn.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int dtc = this.mcn.dtc() * this.channelCount * 2;
        if (dtc > 0) {
            if (this.buffer.capacity() < dtc) {
                this.buffer = ByteBuffer.allocateDirect(dtc).order(ByteOrder.nativeOrder());
                this.mcp = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.mcp.clear();
            }
            this.mcn.c(this.mcp);
            this.mcr += dtc;
            this.buffer.limit(dtc);
            this.mak = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dsB() {
        this.mcn.dsB();
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
        return this.mal && (this.mcn == null || this.mcn.dtc() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mcn = new i(this.mah, this.channelCount, this.speed, this.pitch, this.mco);
        this.mak = EMPTY_BUFFER;
        this.mcq = 0L;
        this.mcr = 0L;
        this.mal = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.mcn = null;
        this.buffer = EMPTY_BUFFER;
        this.mcp = this.buffer.asShortBuffer();
        this.mak = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mah = -1;
        this.mco = -1;
        this.mcq = 0L;
        this.mcr = 0L;
        this.mal = false;
        this.mcm = -1;
    }
}

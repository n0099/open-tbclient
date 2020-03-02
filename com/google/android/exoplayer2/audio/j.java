package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public final class j implements AudioProcessor {
    private boolean mba;
    private i mda;
    private long mdd;
    private long mde;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int maW = -1;
    private int mdb = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer mdc = this.buffer.asShortBuffer();
    private ByteBuffer maZ = EMPTY_BUFFER;
    private int mcZ = -1;

    public float bw(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float bx(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fJ(long j) {
        if (this.mde >= 1024) {
            if (this.mdb == this.maW) {
                return v.i(j, this.mdd, this.mde);
            }
            return v.i(j, this.mdb * this.mdd, this.maW * this.mde);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.mcZ == -1 ? i : this.mcZ;
        if (this.maW == i && this.channelCount == i2 && this.mdb == i4) {
            return false;
        }
        this.maW = i;
        this.channelCount = i2;
        this.mdb = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.mdb != this.maW;
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
        return this.mdb;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.mdd += remaining;
            this.mda.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int dur = this.mda.dur() * this.channelCount * 2;
        if (dur > 0) {
            if (this.buffer.capacity() < dur) {
                this.buffer = ByteBuffer.allocateDirect(dur).order(ByteOrder.nativeOrder());
                this.mdc = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.mdc.clear();
            }
            this.mda.c(this.mdc);
            this.mde += dur;
            this.buffer.limit(dur);
            this.maZ = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtQ() {
        this.mda.dtQ();
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
        return this.mba && (this.mda == null || this.mda.dur() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mda = new i(this.maW, this.channelCount, this.speed, this.pitch, this.mdb);
        this.maZ = EMPTY_BUFFER;
        this.mdd = 0L;
        this.mde = 0L;
        this.mba = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.mda = null;
        this.buffer = EMPTY_BUFFER;
        this.mdc = this.buffer.asShortBuffer();
        this.maZ = EMPTY_BUFFER;
        this.channelCount = -1;
        this.maW = -1;
        this.mdb = -1;
        this.mdd = 0L;
        this.mde = 0L;
        this.mba = false;
        this.mcZ = -1;
    }
}

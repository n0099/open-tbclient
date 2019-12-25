package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes4.dex */
public final class j implements AudioProcessor {
    private boolean lWv;
    private i lYv;
    private long lYy;
    private long lYz;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int lWr = -1;
    private int lYw = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer lYx = this.buffer.asShortBuffer();
    private ByteBuffer lWu = EMPTY_BUFFER;
    private int lYu = -1;

    public float bx(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float by(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fG(long j) {
        if (this.lYz >= 1024) {
            if (this.lYw == this.lWr) {
                return v.h(j, this.lYy, this.lYz);
            }
            return v.h(j, this.lYw * this.lYy, this.lWr * this.lYz);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.lYu == -1 ? i : this.lYu;
        if (this.lWr == i && this.channelCount == i2 && this.lYw == i4) {
            return false;
        }
        this.lWr = i;
        this.channelCount = i2;
        this.lYw = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.lYw != this.lWr;
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
        return this.lYw;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.lYy += remaining;
            this.lYv.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int drQ = this.lYv.drQ() * this.channelCount * 2;
        if (drQ > 0) {
            if (this.buffer.capacity() < drQ) {
                this.buffer = ByteBuffer.allocateDirect(drQ).order(ByteOrder.nativeOrder());
                this.lYx = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.lYx.clear();
            }
            this.lYv.c(this.lYx);
            this.lYz += drQ;
            this.buffer.limit(drQ);
            this.lWu = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void drp() {
        this.lYv.drp();
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
        return this.lWv && (this.lYv == null || this.lYv.drQ() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.lYv = new i(this.lWr, this.channelCount, this.speed, this.pitch, this.lYw);
        this.lWu = EMPTY_BUFFER;
        this.lYy = 0L;
        this.lYz = 0L;
        this.lWv = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.lYv = null;
        this.buffer = EMPTY_BUFFER;
        this.lYx = this.buffer.asShortBuffer();
        this.lWu = EMPTY_BUFFER;
        this.channelCount = -1;
        this.lWr = -1;
        this.lYw = -1;
        this.lYy = 0L;
        this.lYz = 0L;
        this.lWv = false;
        this.lYu = -1;
    }
}

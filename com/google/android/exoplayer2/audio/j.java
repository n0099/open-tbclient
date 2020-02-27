package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public final class j implements AudioProcessor {
    private boolean maY;
    private i mcY;
    private long mdb;
    private long mdc;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int maU = -1;
    private int mcZ = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer mda = this.buffer.asShortBuffer();
    private ByteBuffer maX = EMPTY_BUFFER;
    private int mcX = -1;

    public float bw(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float bx(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fJ(long j) {
        if (this.mdc >= 1024) {
            if (this.mcZ == this.maU) {
                return v.i(j, this.mdb, this.mdc);
            }
            return v.i(j, this.mcZ * this.mdb, this.maU * this.mdc);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.mcX == -1 ? i : this.mcX;
        if (this.maU == i && this.channelCount == i2 && this.mcZ == i4) {
            return false;
        }
        this.maU = i;
        this.channelCount = i2;
        this.mcZ = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.mcZ != this.maU;
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
        return this.mcZ;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.mdb += remaining;
            this.mcY.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int dup = this.mcY.dup() * this.channelCount * 2;
        if (dup > 0) {
            if (this.buffer.capacity() < dup) {
                this.buffer = ByteBuffer.allocateDirect(dup).order(ByteOrder.nativeOrder());
                this.mda = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.mda.clear();
            }
            this.mcY.c(this.mda);
            this.mdc += dup;
            this.buffer.limit(dup);
            this.maX = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtO() {
        this.mcY.dtO();
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
        return this.maY && (this.mcY == null || this.mcY.dup() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mcY = new i(this.maU, this.channelCount, this.speed, this.pitch, this.mcZ);
        this.maX = EMPTY_BUFFER;
        this.mdb = 0L;
        this.mdc = 0L;
        this.maY = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.mcY = null;
        this.buffer = EMPTY_BUFFER;
        this.mda = this.buffer.asShortBuffer();
        this.maX = EMPTY_BUFFER;
        this.channelCount = -1;
        this.maU = -1;
        this.mcZ = -1;
        this.mdb = 0L;
        this.mdc = 0L;
        this.maY = false;
        this.mcX = -1;
    }
}

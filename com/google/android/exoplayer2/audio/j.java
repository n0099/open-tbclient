package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public final class j implements AudioProcessor {
    private boolean mcR;
    private i meR;
    private long meU;
    private long meV;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int mcN = -1;
    private int meS = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer meT = this.buffer.asShortBuffer();
    private ByteBuffer mcQ = EMPTY_BUFFER;
    private int meQ = -1;

    public float bw(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float bx(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fK(long j) {
        if (this.meV >= 1024) {
            if (this.meS == this.mcN) {
                return v.i(j, this.meU, this.meV);
            }
            return v.i(j, this.meS * this.meU, this.mcN * this.meV);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.meQ == -1 ? i : this.meQ;
        if (this.mcN == i && this.channelCount == i2 && this.meS == i4) {
            return false;
        }
        this.mcN = i;
        this.channelCount = i2;
        this.meS = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.meS != this.mcN;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dul() {
        return this.channelCount;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dum() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public int dun() {
        return this.meS;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.meU += remaining;
            this.meR.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int duP = this.meR.duP() * this.channelCount * 2;
        if (duP > 0) {
            if (this.buffer.capacity() < duP) {
                this.buffer = ByteBuffer.allocateDirect(duP).order(ByteOrder.nativeOrder());
                this.meT = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.meT.clear();
            }
            this.meR.c(this.meT);
            this.meV += duP;
            this.buffer.limit(duP);
            this.mcQ = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void duo() {
        this.meR.duo();
        this.mcR = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer dup() {
        ByteBuffer byteBuffer = this.mcQ;
        this.mcQ = EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean avU() {
        return this.mcR && (this.meR == null || this.meR.duP() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.meR = new i(this.mcN, this.channelCount, this.speed, this.pitch, this.meS);
        this.mcQ = EMPTY_BUFFER;
        this.meU = 0L;
        this.meV = 0L;
        this.mcR = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.meR = null;
        this.buffer = EMPTY_BUFFER;
        this.meT = this.buffer.asShortBuffer();
        this.mcQ = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mcN = -1;
        this.meS = -1;
        this.meU = 0L;
        this.meV = 0L;
        this.mcR = false;
        this.meQ = -1;
    }
}

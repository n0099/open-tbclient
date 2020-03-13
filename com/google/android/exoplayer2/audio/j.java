package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.util.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public final class j implements AudioProcessor {
    private boolean mbl;
    private i mdl;
    private long mdo;
    private long mdp;
    private float speed = 1.0f;
    private float pitch = 1.0f;
    private int channelCount = -1;
    private int mbh = -1;
    private int mdm = -1;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ShortBuffer mdn = this.buffer.asShortBuffer();
    private ByteBuffer mbk = EMPTY_BUFFER;
    private int mdk = -1;

    public float bw(float f) {
        this.speed = v.g(f, 0.1f, 8.0f);
        return this.speed;
    }

    public float bx(float f) {
        this.pitch = v.g(f, 0.1f, 8.0f);
        return f;
    }

    public long fJ(long j) {
        if (this.mdp >= 1024) {
            if (this.mdm == this.mbh) {
                return v.i(j, this.mdo, this.mdp);
            }
            return v.i(j, this.mdm * this.mdo, this.mbh * this.mdp);
        }
        return (long) (this.speed * j);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        int i4 = this.mdk == -1 ? i : this.mdk;
        if (this.mbh == i && this.channelCount == i2 && this.mdm == i4) {
            return false;
        }
        this.mbh = i;
        this.channelCount = i2;
        this.mdm = i4;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return Math.abs(this.speed - 1.0f) >= 0.01f || Math.abs(this.pitch - 1.0f) >= 0.01f || this.mdm != this.mbh;
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
        return this.mdm;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.mdo += remaining;
            this.mdl.b(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int dus = this.mdl.dus() * this.channelCount * 2;
        if (dus > 0) {
            if (this.buffer.capacity() < dus) {
                this.buffer = ByteBuffer.allocateDirect(dus).order(ByteOrder.nativeOrder());
                this.mdn = this.buffer.asShortBuffer();
            } else {
                this.buffer.clear();
                this.mdn.clear();
            }
            this.mdl.c(this.mdn);
            this.mdp += dus;
            this.buffer.limit(dus);
            this.mbk = this.buffer;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtR() {
        this.mdl.dtR();
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
        return this.mbl && (this.mdl == null || this.mdl.dus() == 0);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mdl = new i(this.mbh, this.channelCount, this.speed, this.pitch, this.mdm);
        this.mbk = EMPTY_BUFFER;
        this.mdo = 0L;
        this.mdp = 0L;
        this.mbl = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        this.mdl = null;
        this.buffer = EMPTY_BUFFER;
        this.mdn = this.buffer.asShortBuffer();
        this.mbk = EMPTY_BUFFER;
        this.channelCount = -1;
        this.mbh = -1;
        this.mdm = -1;
        this.mdo = 0L;
        this.mdp = 0L;
        this.mbl = false;
        this.mdk = -1;
    }
}

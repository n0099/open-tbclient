package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes5.dex */
final class h implements AudioProcessor {
    private boolean mar;
    private int mam = -1;
    private int channelCount = -1;
    private int maJ = 0;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maq = EMPTY_BUFFER;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean ae(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        if (this.mam == i && this.channelCount == i2 && this.maJ == i3) {
            return false;
        }
        this.mam = i;
        this.channelCount = i2;
        this.maJ = i3;
        if (i3 == 2) {
            this.buffer = EMPTY_BUFFER;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return (this.maJ == 0 || this.maJ == 2) ? false : true;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        switch (this.maJ) {
            case Integer.MIN_VALUE:
                i = (i2 / 3) * 2;
                break;
            case 3:
                i = i2 * 2;
                break;
            case 1073741824:
                i = i2 / 2;
                break;
            default:
                throw new IllegalStateException();
        }
        if (this.buffer.capacity() < i) {
            this.buffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        switch (this.maJ) {
            case Integer.MIN_VALUE:
                while (position < limit) {
                    this.buffer.put(byteBuffer.get(position + 1));
                    this.buffer.put(byteBuffer.get(position + 2));
                    position += 3;
                }
                break;
            case 3:
                while (position < limit) {
                    this.buffer.put((byte) 0);
                    this.buffer.put((byte) ((byteBuffer.get(position) & 255) - 128));
                    position++;
                }
                break;
            case 1073741824:
                for (int i3 = position; i3 < limit; i3 += 4) {
                    this.buffer.put(byteBuffer.get(i3 + 2));
                    this.buffer.put(byteBuffer.get(i3 + 3));
                }
                break;
            default:
                throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        this.buffer.flip();
        this.maq = this.buffer;
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
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.mam = -1;
        this.channelCount = -1;
        this.maJ = 0;
    }
}

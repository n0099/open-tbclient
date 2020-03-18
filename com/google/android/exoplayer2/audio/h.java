package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
final class h implements AudioProcessor {
    private boolean mcR;
    private int mcN = -1;
    private int channelCount = -1;
    private int mdi = 0;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer mcQ = EMPTY_BUFFER;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        if (this.mcN == i && this.channelCount == i2 && this.mdi == i3) {
            return false;
        }
        this.mcN = i;
        this.channelCount = i2;
        this.mdi = i3;
        if (i3 == 2) {
            this.buffer = EMPTY_BUFFER;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return (this.mdi == 0 || this.mdi == 2) ? false : true;
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
        return this.mcN;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        switch (this.mdi) {
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
        switch (this.mdi) {
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
        this.mcQ = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void duo() {
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
        return this.mcR && this.mcQ == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.mcQ = EMPTY_BUFFER;
        this.mcR = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.mcN = -1;
        this.channelCount = -1;
        this.mdi = 0;
    }
}

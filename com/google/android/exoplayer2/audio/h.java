package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
final class h implements AudioProcessor {
    private boolean maY;
    private int maU = -1;
    private int channelCount = -1;
    private int mbp = 0;
    private ByteBuffer buffer = EMPTY_BUFFER;
    private ByteBuffer maX = EMPTY_BUFFER;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean af(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        if (this.maU == i && this.channelCount == i2 && this.mbp == i3) {
            return false;
        }
        this.maU = i;
        this.channelCount = i2;
        this.mbp = i3;
        if (i3 == 2) {
            this.buffer = EMPTY_BUFFER;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return (this.mbp == 0 || this.mbp == 2) ? false : true;
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
        return this.maU;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void i(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        switch (this.mbp) {
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
        switch (this.mbp) {
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
        this.maX = this.buffer;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void dtO() {
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
        return this.maY && this.maX == EMPTY_BUFFER;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.maX = EMPTY_BUFFER;
        this.maY = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = EMPTY_BUFFER;
        this.maU = -1;
        this.channelCount = -1;
        this.mbp = 0;
    }
}

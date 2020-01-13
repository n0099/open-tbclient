package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends a {
    public ByteBuffer data;
    public final b mcP = new b();
    public long mcQ;
    private final int mcR;

    public static e dtn() {
        return new e(0);
    }

    public e(int i) {
        this.mcR = i;
    }

    public void Jj(int i) throws IllegalStateException {
        if (this.data == null) {
            this.data = Jk(i);
            return;
        }
        int capacity = this.data.capacity();
        int position = this.data.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer Jk = Jk(i2);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                Jk.put(this.data);
            }
            this.data = Jk;
        }
    }

    public final boolean dto() {
        return this.data == null && this.mcR == 0;
    }

    public final boolean dtp() {
        return Ji(1073741824);
    }

    public final void dtq() {
        this.data.flip();
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        if (this.data != null) {
            this.data.clear();
        }
    }

    private ByteBuffer Jk(int i) {
        if (this.mcR == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.mcR == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.data == null ? 0 : this.data.capacity()) + " < " + i + ")");
    }
}

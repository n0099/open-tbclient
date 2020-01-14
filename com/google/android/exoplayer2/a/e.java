package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e extends a {
    public ByteBuffer data;
    public final b mcU = new b();
    public long mcV;
    private final int mcW;

    public static e dtp() {
        return new e(0);
    }

    public e(int i) {
        this.mcW = i;
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

    public final boolean dtq() {
        return this.data == null && this.mcW == 0;
    }

    public final boolean dtr() {
        return Ji(1073741824);
    }

    public final void dts() {
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
        if (this.mcW == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.mcW == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.data == null ? 0 : this.data.capacity()) + " < " + i + ")");
    }
}

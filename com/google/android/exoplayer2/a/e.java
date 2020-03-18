package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e extends a {
    public ByteBuffer data;
    public final b mft = new b();
    public long mfu;
    private final int mfv;

    public static e dva() {
        return new e(0);
    }

    public e(int i) {
        this.mfv = i;
    }

    public void Ju(int i) throws IllegalStateException {
        if (this.data == null) {
            this.data = Jv(i);
            return;
        }
        int capacity = this.data.capacity();
        int position = this.data.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer Jv = Jv(i2);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                Jv.put(this.data);
            }
            this.data = Jv;
        }
    }

    public final boolean dvb() {
        return this.data == null && this.mfv == 0;
    }

    public final boolean dvc() {
        return Jt(1073741824);
    }

    public final void dvd() {
        this.data.flip();
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        if (this.data != null) {
            this.data.clear();
        }
    }

    private ByteBuffer Jv(int i) {
        if (this.mfv == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.mfv == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.data == null ? 0 : this.data.capacity()) + " < " + i + ")");
    }
}

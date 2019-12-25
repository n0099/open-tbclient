package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class e extends a {
    public ByteBuffer data;
    public final b lYX = new b();
    public long lYY;
    private final int lYZ;

    public static e dsb() {
        return new e(0);
    }

    public e(int i) {
        this.lYZ = i;
    }

    public void Ja(int i) throws IllegalStateException {
        if (this.data == null) {
            this.data = Jb(i);
            return;
        }
        int capacity = this.data.capacity();
        int position = this.data.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer Jb = Jb(i2);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                Jb.put(this.data);
            }
            this.data = Jb;
        }
    }

    public final boolean dsc() {
        return this.data == null && this.lYZ == 0;
    }

    public final boolean dsd() {
        return IZ(1073741824);
    }

    public final void dse() {
        this.data.flip();
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        if (this.data != null) {
            this.data.clear();
        }
    }

    private ByteBuffer Jb(int i) {
        if (this.lYZ == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.lYZ == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.data == null ? 0 : this.data.capacity()) + " < " + i + ")");
    }
}

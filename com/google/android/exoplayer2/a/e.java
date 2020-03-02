package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e extends a {
    public ByteBuffer data;
    public final b mdC = new b();
    public long mdD;
    private final int mdE;

    public static e duC() {
        return new e(0);
    }

    public e(int i) {
        this.mdE = i;
    }

    public void Jo(int i) throws IllegalStateException {
        if (this.data == null) {
            this.data = Jp(i);
            return;
        }
        int capacity = this.data.capacity();
        int position = this.data.position();
        int i2 = position + i;
        if (capacity < i2) {
            ByteBuffer Jp = Jp(i2);
            if (position > 0) {
                this.data.position(0);
                this.data.limit(position);
                Jp.put(this.data);
            }
            this.data = Jp;
        }
    }

    public final boolean duD() {
        return this.data == null && this.mdE == 0;
    }

    public final boolean duE() {
        return Jn(1073741824);
    }

    public final void duF() {
        this.data.flip();
    }

    @Override // com.google.android.exoplayer2.a.a
    public void clear() {
        super.clear();
        if (this.data != null) {
            this.data.clear();
        }
    }

    private ByteBuffer Jp(int i) {
        if (this.mdE == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.mdE == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        throw new IllegalStateException("Buffer too small (" + (this.data == null ? 0 : this.data.capacity()) + " < " + i + ")");
    }
}

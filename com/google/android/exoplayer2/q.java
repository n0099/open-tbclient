package com.google.android.exoplayer2;
/* loaded from: classes5.dex */
public final class q {
    public static final q lYW = new q(1.0f, 1.0f);
    private final int lYX;
    public final float pitch;
    public final float speed;

    public q(float f, float f2) {
        this.speed = f;
        this.pitch = f2;
        this.lYX = Math.round(1000.0f * f);
    }

    public long fB(long j) {
        return this.lYX * j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return this.speed == qVar.speed && this.pitch == qVar.pitch;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.speed) + 527) * 31) + Float.floatToRawIntBits(this.pitch);
    }
}

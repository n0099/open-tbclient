package com.google.android.exoplayer2;
/* loaded from: classes6.dex */
public final class q {
    public static final q lZU = new q(1.0f, 1.0f);
    private final int lZV;
    public final float pitch;
    public final float speed;

    public q(float f, float f2) {
        this.speed = f;
        this.pitch = f2;
        this.lZV = Math.round(1000.0f * f);
    }

    public long fz(long j) {
        return this.lZV * j;
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

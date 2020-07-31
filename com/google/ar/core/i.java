package com.google.ar.core;
/* loaded from: classes5.dex */
class i {
    public static final i nip = new i();
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;
    private float w = 1.0f;

    public i() {
        a(0.0f, 0.0f, 0.0f, 1.0f);
    }

    private final void a(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.z = f3;
        this.w = f4;
    }

    public final float a() {
        return this.x;
    }

    public final float b() {
        return this.y;
    }

    public final float c() {
        return this.z;
    }

    public final float d() {
        return this.w;
    }

    public String toString() {
        return String.format("[%.3f, %.3f, %.3f, %.3f]", Float.valueOf(this.x), Float.valueOf(this.y), Float.valueOf(this.z), Float.valueOf(this.w));
    }
}

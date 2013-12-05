package com.google.zxing.qrcode.detector;

import com.google.zxing.i;
/* loaded from: classes.dex */
public final class d extends i {

    /* renamed from: a  reason: collision with root package name */
    private final float f2892a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f2892a = f3;
        this.b = i;
    }

    public float c() {
        return this.f2892a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - b()) > f || Math.abs(f3 - a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2892a);
        return abs <= 1.0f || abs <= this.f2892a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d b(float f, float f2, float f3) {
        int i = this.b + 1;
        return new d(((this.b * a()) + f2) / i, ((this.b * b()) + f) / i, ((this.b * this.f2892a) + f3) / i, i);
    }
}

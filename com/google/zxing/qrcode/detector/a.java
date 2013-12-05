package com.google.zxing.qrcode.detector;

import com.google.zxing.i;
/* loaded from: classes.dex */
public final class a extends i {

    /* renamed from: a  reason: collision with root package name */
    private final float f2889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(float f, float f2, float f3) {
        super(f, f2);
        this.f2889a = f3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(float f, float f2, float f3) {
        if (Math.abs(f2 - b()) > f || Math.abs(f3 - a()) > f) {
            return false;
        }
        float abs = Math.abs(f - this.f2889a);
        return abs <= 1.0f || abs <= this.f2889a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b(float f, float f2, float f3) {
        return new a((a() + f2) / 2.0f, (b() + f) / 2.0f, (this.f2889a + f3) / 2.0f);
    }
}

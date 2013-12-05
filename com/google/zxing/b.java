package com.google.zxing;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f2837a;
    private com.google.zxing.common.a b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f2837a = aVar;
    }

    public com.google.zxing.common.a a() {
        if (this.b == null) {
            this.b = this.f2837a.b();
        }
        return this.b;
    }
}

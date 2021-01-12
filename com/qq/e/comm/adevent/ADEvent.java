package com.qq.e.comm.adevent;
/* loaded from: classes3.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f11536a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f11537b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f11536a = i;
        this.f11537b = objArr;
    }

    public Object[] getParas() {
        return this.f11537b == null ? new Object[0] : this.f11537b;
    }

    public int getType() {
        return this.f11536a;
    }
}

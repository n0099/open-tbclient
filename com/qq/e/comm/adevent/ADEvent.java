package com.qq.e.comm.adevent;
/* loaded from: classes15.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f11538a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f11539b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f11538a = i;
        this.f11539b = objArr;
    }

    public Object[] getParas() {
        return this.f11539b == null ? new Object[0] : this.f11539b;
    }

    public int getType() {
        return this.f11538a;
    }
}

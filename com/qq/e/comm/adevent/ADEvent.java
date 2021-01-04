package com.qq.e.comm.adevent;
/* loaded from: classes3.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f11835a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f11836b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f11835a = i;
        this.f11836b = objArr;
    }

    public Object[] getParas() {
        return this.f11836b == null ? new Object[0] : this.f11836b;
    }

    public int getType() {
        return this.f11835a;
    }
}

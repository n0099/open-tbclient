package com.qq.e.comm.adevent;
/* loaded from: classes4.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f11836a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f11837b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f11836a = i;
        this.f11837b = objArr;
    }

    public Object[] getParas() {
        return this.f11837b == null ? new Object[0] : this.f11837b;
    }

    public int getType() {
        return this.f11836a;
    }
}

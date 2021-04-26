package com.qq.e.comm.adevent;
/* loaded from: classes6.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f36218a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f36219b;

    public ADEvent(int i2) {
        this(i2, null);
    }

    public ADEvent(int i2, Object[] objArr) {
        this.f36218a = i2;
        this.f36219b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f36219b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f36218a;
    }
}

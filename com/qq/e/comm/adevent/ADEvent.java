package com.qq.e.comm.adevent;
/* loaded from: classes7.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f39071a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f39072b;

    public ADEvent(int i2) {
        this(i2, null);
    }

    public ADEvent(int i2, Object[] objArr) {
        this.f39071a = i2;
        this.f39072b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f39072b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f39071a;
    }
}

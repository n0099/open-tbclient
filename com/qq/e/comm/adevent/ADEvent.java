package com.qq.e.comm.adevent;
/* loaded from: classes7.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f35392a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f35393b;

    public ADEvent(int i2) {
        this(i2, null);
    }

    public ADEvent(int i2, Object[] objArr) {
        this.f35392a = i2;
        this.f35393b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f35393b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f35392a;
    }
}

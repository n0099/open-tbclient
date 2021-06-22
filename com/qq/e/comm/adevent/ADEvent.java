package com.qq.e.comm.adevent;
/* loaded from: classes7.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f39169a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f39170b;

    public ADEvent(int i2) {
        this(i2, null);
    }

    public ADEvent(int i2, Object[] objArr) {
        this.f39169a = i2;
        this.f39170b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f39170b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f39169a;
    }
}

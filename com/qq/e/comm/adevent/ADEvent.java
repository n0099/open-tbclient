package com.qq.e.comm.adevent;
/* loaded from: classes6.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f38260a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f38261b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f38260a = i;
        this.f38261b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f38261b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f38260a;
    }
}

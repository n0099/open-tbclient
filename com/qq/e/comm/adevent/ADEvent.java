package com.qq.e.comm.adevent;
/* loaded from: classes6.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f38644a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f38645b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f38644a = i;
        this.f38645b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f38645b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f38644a;
    }
}

package com.qq.e.comm.adevent;
/* loaded from: classes6.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    public final int f38259a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f38260b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f38259a = i;
        this.f38260b = objArr;
    }

    public Object[] getParas() {
        Object[] objArr = this.f38260b;
        return objArr == null ? new Object[0] : objArr;
    }

    public int getType() {
        return this.f38259a;
    }
}

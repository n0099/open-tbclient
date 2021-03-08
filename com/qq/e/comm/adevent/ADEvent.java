package com.qq.e.comm.adevent;
/* loaded from: classes4.dex */
public class ADEvent {

    /* renamed from: a  reason: collision with root package name */
    private final int f7557a;
    private final Object[] b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f7557a = i;
        this.b = objArr;
    }

    public Object[] getParas() {
        return this.b == null ? new Object[0] : this.b;
    }

    public int getType() {
        return this.f7557a;
    }
}

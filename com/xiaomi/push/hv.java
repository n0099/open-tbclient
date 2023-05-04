package com.xiaomi.push;
/* loaded from: classes9.dex */
public enum hv {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f554a;

    hv(int i) {
        this.f554a = i;
    }

    public static hv a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Init;
            }
            return PackageUnregistered;
        }
        return RegIdExpired;
    }

    public int a() {
        return this.f554a;
    }
}

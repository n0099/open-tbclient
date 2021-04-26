package com.xiaomi.push;
/* loaded from: classes7.dex */
public enum ht {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f552a;

    ht(int i2) {
        this.f552a = i2;
    }

    public static ht a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return null;
                }
                return Init;
            }
            return PackageUnregistered;
        }
        return RegIdExpired;
    }

    public int a() {
        return this.f552a;
    }
}

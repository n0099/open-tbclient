package com.xiaomi.push;
/* loaded from: classes7.dex */
public enum ht {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f552a;

    ht(int i) {
        this.f552a = i;
    }

    public static ht a(int i) {
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
        return this.f552a;
    }
}

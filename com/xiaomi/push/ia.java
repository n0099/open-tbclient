package com.xiaomi.push;
/* loaded from: classes18.dex */
public enum ia {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f525a;

    ia(int i) {
        this.f525a = i;
    }

    public static ia a(int i) {
        switch (i) {
            case 0:
                return RegIdExpired;
            case 1:
                return PackageUnregistered;
            case 2:
                return Init;
            default:
                return null;
        }
    }

    public int a() {
        return this.f525a;
    }
}

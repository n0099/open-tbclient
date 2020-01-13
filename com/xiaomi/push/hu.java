package com.xiaomi.push;
/* loaded from: classes6.dex */
public enum hu {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f538a;

    hu(int i) {
        this.f538a = i;
    }

    public static hu a(int i) {
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
        return this.f538a;
    }
}

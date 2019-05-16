package com.xiaomi.xmpush.thrift;
/* loaded from: classes3.dex */
public enum n {
    Circle(0),
    Polygon(1);
    
    private final int c;

    n(int i) {
        this.c = i;
    }

    public static n a(int i) {
        switch (i) {
            case 0:
                return Circle;
            case 1:
                return Polygon;
            default:
                return null;
        }
    }

    public int a() {
        return this.c;
    }
}

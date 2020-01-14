package com.xiaomi.push;
/* loaded from: classes6.dex */
public enum hn {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f481a;

    hn(int i) {
        this.f481a = i;
    }

    public static hn a(int i) {
        switch (i) {
            case 1:
                return INT;
            case 2:
                return LONG;
            case 3:
                return STRING;
            case 4:
                return BOOLEAN;
            default:
                return null;
        }
    }
}

package com.xiaomi.push;
/* loaded from: classes7.dex */
public enum ht {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: a  reason: collision with other field name */
    private final int f466a;

    ht(int i) {
        this.f466a = i;
    }

    public static ht a(int i) {
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

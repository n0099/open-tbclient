package com.xiaomi.push;
/* loaded from: classes10.dex */
public enum ho {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);
    

    /* renamed from: a  reason: collision with other field name */
    public final int f496a;

    ho(int i) {
        this.f496a = i;
    }

    public static ho a(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return BOOLEAN;
                }
                return STRING;
            }
            return LONG;
        }
        return INT;
    }
}

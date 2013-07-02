package com.mofamulu.tieba.dslv.lock;

import java.lang.reflect.Array;
/* loaded from: classes.dex */
public class i {
    static i[][] c = (i[][]) Array.newInstance(i.class, 3, 3);
    int a;
    int b;

    static {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                c[i][i2] = new i(i, i2);
            }
        }
    }

    private i(int i, int i2) {
        b(i, i2);
        this.a = i;
        this.b = i2;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public static synchronized i a(int i, int i2) {
        i iVar;
        synchronized (i.class) {
            b(i, i2);
            iVar = c[i][i2];
        }
        return iVar;
    }

    private static void b(int i, int i2) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("row must be in range 0-2");
        }
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("column must be in range 0-2");
        }
    }

    public String toString() {
        return "(row=" + this.a + ",clmn=" + this.b + ")";
    }
}

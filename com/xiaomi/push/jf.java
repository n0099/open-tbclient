package com.xiaomi.push;
/* loaded from: classes5.dex */
public class jf {
    private static int a = Integer.MAX_VALUE;

    public static void a(jc jcVar, byte b) {
        a(jcVar, b, a);
    }

    public static void a(jc jcVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new iw("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jcVar.m463a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.m451a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.m461a();
                return;
            case 8:
                jcVar.m452a();
                return;
            case 10:
                jcVar.m453a();
                return;
            case 11:
                jcVar.m460a();
                return;
            case 12:
                jcVar.m458a();
                while (true) {
                    iz m454a = jcVar.m454a();
                    if (m454a.a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, m454a.a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb m456a = jcVar.m456a();
                while (i2 < m456a.f797a) {
                    a(jcVar, m456a.a, i - 1);
                    a(jcVar, m456a.b, i - 1);
                    i2++;
                }
                jcVar.h();
                return;
            case 14:
                jg m457a = jcVar.m457a();
                while (i2 < m457a.f798a) {
                    a(jcVar, m457a.a, i - 1);
                    i2++;
                }
                jcVar.j();
                return;
            case 15:
                ja m455a = jcVar.m455a();
                while (i2 < m455a.f796a) {
                    a(jcVar, m455a.a, i - 1);
                    i2++;
                }
                jcVar.i();
                return;
        }
    }
}

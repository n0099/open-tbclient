package com.xiaomi.push;
/* loaded from: classes3.dex */
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
                jcVar.m460a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.m448a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.m458a();
                return;
            case 8:
                jcVar.m449a();
                return;
            case 10:
                jcVar.m450a();
                return;
            case 11:
                jcVar.m457a();
                return;
            case 12:
                jcVar.m455a();
                while (true) {
                    iz m451a = jcVar.m451a();
                    if (m451a.a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, m451a.a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb m453a = jcVar.m453a();
                while (i2 < m453a.f792a) {
                    a(jcVar, m453a.a, i - 1);
                    a(jcVar, m453a.b, i - 1);
                    i2++;
                }
                jcVar.h();
                return;
            case 14:
                jg m454a = jcVar.m454a();
                while (i2 < m454a.f793a) {
                    a(jcVar, m454a.a, i - 1);
                    i2++;
                }
                jcVar.j();
                return;
            case 15:
                ja m452a = jcVar.m452a();
                while (i2 < m452a.f791a) {
                    a(jcVar, m452a.a, i - 1);
                    i2++;
                }
                jcVar.i();
                return;
        }
    }
}

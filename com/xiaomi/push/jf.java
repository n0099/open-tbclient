package com.xiaomi.push;
/* loaded from: classes8.dex */
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
                jcVar.m477a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.m465a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.m475a();
                return;
            case 8:
                jcVar.m466a();
                return;
            case 10:
                jcVar.m467a();
                return;
            case 11:
                jcVar.m474a();
                return;
            case 12:
                jcVar.m472a();
                while (true) {
                    iz m468a = jcVar.m468a();
                    if (m468a.a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, m468a.a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb m470a = jcVar.m470a();
                while (i2 < m470a.f792a) {
                    a(jcVar, m470a.a, i - 1);
                    a(jcVar, m470a.b, i - 1);
                    i2++;
                }
                jcVar.h();
                return;
            case 14:
                jg m471a = jcVar.m471a();
                while (i2 < m471a.f793a) {
                    a(jcVar, m471a.a, i - 1);
                    i2++;
                }
                jcVar.j();
                return;
            case 15:
                ja m469a = jcVar.m469a();
                while (i2 < m469a.f791a) {
                    a(jcVar, m469a.a, i - 1);
                    i2++;
                }
                jcVar.i();
                return;
        }
    }
}

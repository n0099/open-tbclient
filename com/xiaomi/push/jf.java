package com.xiaomi.push;
/* loaded from: classes6.dex */
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
                jcVar.m472a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.m460a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.m470a();
                return;
            case 8:
                jcVar.m461a();
                return;
            case 10:
                jcVar.m462a();
                return;
            case 11:
                jcVar.m469a();
                return;
            case 12:
                jcVar.m467a();
                while (true) {
                    iz m463a = jcVar.m463a();
                    if (m463a.a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, m463a.a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb m465a = jcVar.m465a();
                while (i2 < m465a.f796a) {
                    a(jcVar, m465a.a, i - 1);
                    a(jcVar, m465a.b, i - 1);
                    i2++;
                }
                jcVar.h();
                return;
            case 14:
                jg m466a = jcVar.m466a();
                while (i2 < m466a.f797a) {
                    a(jcVar, m466a.a, i - 1);
                    i2++;
                }
                jcVar.j();
                return;
            case 15:
                ja m464a = jcVar.m464a();
                while (i2 < m464a.f795a) {
                    a(jcVar, m464a.a, i - 1);
                    i2++;
                }
                jcVar.i();
                return;
        }
    }
}

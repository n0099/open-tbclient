package com.xiaomi.push;
/* loaded from: classes10.dex */
public class jg {
    public static int a = Integer.MAX_VALUE;

    public static void a(jd jdVar, byte b) {
        a(jdVar, b, a);
    }

    public static void a(jd jdVar, byte b, int i) {
        if (i <= 0) {
            throw new ix("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                jdVar.mo701a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo688a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo698a();
                return;
            case 8:
                jdVar.mo689a();
                return;
            case 10:
                jdVar.mo690a();
                return;
            case 11:
                jdVar.mo697a();
                return;
            case 12:
                jdVar.mo695a();
                while (true) {
                    byte b2 = jdVar.mo691a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo693a = jdVar.mo693a();
                while (i2 < mo693a.f815a) {
                    int i3 = i - 1;
                    a(jdVar, mo693a.a, i3);
                    a(jdVar, mo693a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo694a = jdVar.mo694a();
                while (i2 < mo694a.f816a) {
                    a(jdVar, mo694a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo692a = jdVar.mo692a();
                while (i2 < mo692a.f814a) {
                    a(jdVar, mo692a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

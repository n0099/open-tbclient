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
                jdVar.mo704a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo691a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo701a();
                return;
            case 8:
                jdVar.mo692a();
                return;
            case 10:
                jdVar.mo693a();
                return;
            case 11:
                jdVar.mo700a();
                return;
            case 12:
                jdVar.mo698a();
                while (true) {
                    byte b2 = jdVar.mo694a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo696a = jdVar.mo696a();
                while (i2 < mo696a.f815a) {
                    int i3 = i - 1;
                    a(jdVar, mo696a.a, i3);
                    a(jdVar, mo696a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo697a = jdVar.mo697a();
                while (i2 < mo697a.f816a) {
                    a(jdVar, mo697a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo695a = jdVar.mo695a();
                while (i2 < mo695a.f814a) {
                    a(jdVar, mo695a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

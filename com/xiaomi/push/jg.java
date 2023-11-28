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
                jdVar.mo716a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo703a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo713a();
                return;
            case 8:
                jdVar.mo704a();
                return;
            case 10:
                jdVar.mo705a();
                return;
            case 11:
                jdVar.mo712a();
                return;
            case 12:
                jdVar.mo710a();
                while (true) {
                    byte b2 = jdVar.mo706a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo708a = jdVar.mo708a();
                while (i2 < mo708a.f811a) {
                    int i3 = i - 1;
                    a(jdVar, mo708a.a, i3);
                    a(jdVar, mo708a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo709a = jdVar.mo709a();
                while (i2 < mo709a.f812a) {
                    a(jdVar, mo709a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo707a = jdVar.mo707a();
                while (i2 < mo707a.f810a) {
                    a(jdVar, mo707a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

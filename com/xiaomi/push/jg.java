package com.xiaomi.push;
/* loaded from: classes8.dex */
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
                jdVar.mo623a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo610a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo620a();
                return;
            case 8:
                jdVar.mo611a();
                return;
            case 10:
                jdVar.mo612a();
                return;
            case 11:
                jdVar.mo619a();
                return;
            case 12:
                jdVar.mo617a();
                while (true) {
                    byte b2 = jdVar.mo613a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo615a = jdVar.mo615a();
                while (i2 < mo615a.f815a) {
                    int i3 = i - 1;
                    a(jdVar, mo615a.a, i3);
                    a(jdVar, mo615a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo616a = jdVar.mo616a();
                while (i2 < mo616a.f816a) {
                    a(jdVar, mo616a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo614a = jdVar.mo614a();
                while (i2 < mo614a.f814a) {
                    a(jdVar, mo614a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

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
                jdVar.mo627a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo614a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo624a();
                return;
            case 8:
                jdVar.mo615a();
                return;
            case 10:
                jdVar.mo616a();
                return;
            case 11:
                jdVar.mo623a();
                return;
            case 12:
                jdVar.mo621a();
                while (true) {
                    byte b2 = jdVar.mo617a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo619a = jdVar.mo619a();
                while (i2 < mo619a.f815a) {
                    int i3 = i - 1;
                    a(jdVar, mo619a.a, i3);
                    a(jdVar, mo619a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo620a = jdVar.mo620a();
                while (i2 < mo620a.f816a) {
                    a(jdVar, mo620a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo618a = jdVar.mo618a();
                while (i2 < mo618a.f814a) {
                    a(jdVar, mo618a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

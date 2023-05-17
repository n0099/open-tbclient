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
                jdVar.mo646a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo633a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo643a();
                return;
            case 8:
                jdVar.mo634a();
                return;
            case 10:
                jdVar.mo635a();
                return;
            case 11:
                jdVar.mo642a();
                return;
            case 12:
                jdVar.mo640a();
                while (true) {
                    byte b2 = jdVar.mo636a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo638a = jdVar.mo638a();
                while (i2 < mo638a.f815a) {
                    int i3 = i - 1;
                    a(jdVar, mo638a.a, i3);
                    a(jdVar, mo638a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo639a = jdVar.mo639a();
                while (i2 < mo639a.f816a) {
                    a(jdVar, mo639a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo637a = jdVar.mo637a();
                while (i2 < mo637a.f814a) {
                    a(jdVar, mo637a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

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
                jdVar.mo709a();
                return;
            case 3:
                jdVar.a();
                return;
            case 4:
                jdVar.mo696a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jdVar.mo706a();
                return;
            case 8:
                jdVar.mo697a();
                return;
            case 10:
                jdVar.mo698a();
                return;
            case 11:
                jdVar.mo705a();
                return;
            case 12:
                jdVar.mo703a();
                while (true) {
                    byte b2 = jdVar.mo699a().a;
                    if (b2 == 0) {
                        jdVar.f();
                        return;
                    } else {
                        a(jdVar, b2, i - 1);
                        jdVar.g();
                    }
                }
            case 13:
                jc mo701a = jdVar.mo701a();
                while (i2 < mo701a.f815a) {
                    int i3 = i - 1;
                    a(jdVar, mo701a.a, i3);
                    a(jdVar, mo701a.b, i3);
                    i2++;
                }
                jdVar.h();
                return;
            case 14:
                jh mo702a = jdVar.mo702a();
                while (i2 < mo702a.f816a) {
                    a(jdVar, mo702a.a, i - 1);
                    i2++;
                }
                jdVar.j();
                return;
            case 15:
                jb mo700a = jdVar.mo700a();
                while (i2 < mo700a.f814a) {
                    a(jdVar, mo700a.a, i - 1);
                    i2++;
                }
                jdVar.i();
                return;
        }
    }
}

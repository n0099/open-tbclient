package com.xiaomi.push;
/* loaded from: classes7.dex */
public class je {

    /* renamed from: a  reason: collision with root package name */
    public static int f40875a = Integer.MAX_VALUE;

    public static void a(jb jbVar, byte b2) {
        a(jbVar, b2, f40875a);
    }

    public static void a(jb jbVar, byte b2, int i) {
        if (i <= 0) {
            throw new iv("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b2) {
            case 2:
                jbVar.m510a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m498a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m508a();
                return;
            case 8:
                jbVar.m499a();
                return;
            case 10:
                jbVar.m500a();
                return;
            case 11:
                jbVar.m507a();
                return;
            case 12:
                jbVar.m505a();
                while (true) {
                    byte b3 = jbVar.m501a().f40866a;
                    if (b3 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b3, i - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m503a = jbVar.m503a();
                while (i2 < m503a.f811a) {
                    int i3 = i - 1;
                    a(jbVar, m503a.f40871a, i3);
                    a(jbVar, m503a.f40872b, i3);
                    i2++;
                }
                jbVar.h();
                return;
            case 14:
                jf m504a = jbVar.m504a();
                while (i2 < m504a.f812a) {
                    a(jbVar, m504a.f40876a, i - 1);
                    i2++;
                }
                jbVar.j();
                return;
            case 15:
                iz m502a = jbVar.m502a();
                while (i2 < m502a.f808a) {
                    a(jbVar, m502a.f40867a, i - 1);
                    i2++;
                }
                jbVar.i();
                return;
        }
    }
}

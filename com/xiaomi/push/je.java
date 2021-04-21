package com.xiaomi.push;
/* loaded from: classes7.dex */
public class je {

    /* renamed from: a  reason: collision with root package name */
    public static int f41260a = Integer.MAX_VALUE;

    public static void a(jb jbVar, byte b2) {
        a(jbVar, b2, f41260a);
    }

    public static void a(jb jbVar, byte b2, int i) {
        if (i <= 0) {
            throw new iv("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b2) {
            case 2:
                jbVar.m514a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m502a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m512a();
                return;
            case 8:
                jbVar.m503a();
                return;
            case 10:
                jbVar.m504a();
                return;
            case 11:
                jbVar.m511a();
                return;
            case 12:
                jbVar.m509a();
                while (true) {
                    byte b3 = jbVar.m505a().f41251a;
                    if (b3 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b3, i - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m507a = jbVar.m507a();
                while (i2 < m507a.f811a) {
                    int i3 = i - 1;
                    a(jbVar, m507a.f41256a, i3);
                    a(jbVar, m507a.f41257b, i3);
                    i2++;
                }
                jbVar.h();
                return;
            case 14:
                jf m508a = jbVar.m508a();
                while (i2 < m508a.f812a) {
                    a(jbVar, m508a.f41261a, i - 1);
                    i2++;
                }
                jbVar.j();
                return;
            case 15:
                iz m506a = jbVar.m506a();
                while (i2 < m506a.f808a) {
                    a(jbVar, m506a.f41252a, i - 1);
                    i2++;
                }
                jbVar.i();
                return;
        }
    }
}

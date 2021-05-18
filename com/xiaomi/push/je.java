package com.xiaomi.push;
/* loaded from: classes7.dex */
public class je {

    /* renamed from: a  reason: collision with root package name */
    public static int f38049a = Integer.MAX_VALUE;

    public static void a(jb jbVar, byte b2) {
        a(jbVar, b2, f38049a);
    }

    public static void a(jb jbVar, byte b2, int i2) {
        if (i2 <= 0) {
            throw new iv("Maximum skip depth exceeded");
        }
        int i3 = 0;
        switch (b2) {
            case 2:
                jbVar.m516a();
                return;
            case 3:
                jbVar.a();
                return;
            case 4:
                jbVar.m504a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jbVar.m514a();
                return;
            case 8:
                jbVar.m505a();
                return;
            case 10:
                jbVar.m506a();
                return;
            case 11:
                jbVar.m513a();
                return;
            case 12:
                jbVar.m511a();
                while (true) {
                    byte b3 = jbVar.m507a().f38040a;
                    if (b3 == 0) {
                        jbVar.f();
                        return;
                    } else {
                        a(jbVar, b3, i2 - 1);
                        jbVar.g();
                    }
                }
            case 13:
                ja m509a = jbVar.m509a();
                while (i3 < m509a.f811a) {
                    int i4 = i2 - 1;
                    a(jbVar, m509a.f38045a, i4);
                    a(jbVar, m509a.f38046b, i4);
                    i3++;
                }
                jbVar.h();
                return;
            case 14:
                jf m510a = jbVar.m510a();
                while (i3 < m510a.f812a) {
                    a(jbVar, m510a.f38050a, i2 - 1);
                    i3++;
                }
                jbVar.j();
                return;
            case 15:
                iz m508a = jbVar.m508a();
                while (i3 < m508a.f808a) {
                    a(jbVar, m508a.f38041a, i2 - 1);
                    i3++;
                }
                jbVar.i();
                return;
        }
    }
}

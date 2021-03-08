package com.xiaomi.push;
/* loaded from: classes5.dex */
public class jl {

    /* renamed from: a  reason: collision with root package name */
    private static int f8468a = Integer.MAX_VALUE;

    public static void a(ji jiVar, byte b) {
        a(jiVar, b, f8468a);
    }

    public static void a(ji jiVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jiVar.m498a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m486a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m496a();
                return;
            case 8:
                jiVar.m487a();
                return;
            case 10:
                jiVar.m488a();
                return;
            case 11:
                jiVar.m495a();
                return;
            case 12:
                jiVar.m493a();
                while (true) {
                    jf m489a = jiVar.m489a();
                    if (m489a.f8463a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m489a.f8463a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m491a = jiVar.m491a();
                while (i2 < m491a.f780a) {
                    a(jiVar, m491a.f8465a, i - 1);
                    a(jiVar, m491a.b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m492a = jiVar.m492a();
                while (i2 < m492a.f781a) {
                    a(jiVar, m492a.f8469a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m490a = jiVar.m490a();
                while (i2 < m490a.f779a) {
                    a(jiVar, m490a.f8464a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

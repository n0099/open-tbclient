package com.xiaomi.push;
/* loaded from: classes6.dex */
public class jl {

    /* renamed from: a  reason: collision with root package name */
    private static int f14179a = Integer.MAX_VALUE;

    public static void a(ji jiVar, byte b2) {
        a(jiVar, b2, f14179a);
    }

    public static void a(ji jiVar, byte b2, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b2) {
            case 2:
                jiVar.m520a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m508a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m518a();
                return;
            case 8:
                jiVar.m509a();
                return;
            case 10:
                jiVar.m510a();
                return;
            case 11:
                jiVar.m517a();
                return;
            case 12:
                jiVar.m515a();
                while (true) {
                    jf m511a = jiVar.m511a();
                    if (m511a.f14173a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m511a.f14173a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m513a = jiVar.m513a();
                while (i2 < m513a.f859a) {
                    a(jiVar, m513a.f14175a, i - 1);
                    a(jiVar, m513a.f14176b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m514a = jiVar.m514a();
                while (i2 < m514a.f860a) {
                    a(jiVar, m514a.f14180a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m512a = jiVar.m512a();
                while (i2 < m512a.f858a) {
                    a(jiVar, m512a.f14174a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

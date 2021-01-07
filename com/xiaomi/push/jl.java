package com.xiaomi.push;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes6.dex */
public class jl {

    /* renamed from: a  reason: collision with root package name */
    private static int f14477a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(ji jiVar, byte b2) {
        a(jiVar, b2, f14477a);
    }

    public static void a(ji jiVar, byte b2, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b2) {
            case 2:
                jiVar.m524a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m512a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m522a();
                return;
            case 8:
                jiVar.m513a();
                return;
            case 10:
                jiVar.m514a();
                return;
            case 11:
                jiVar.m521a();
                return;
            case 12:
                jiVar.m519a();
                while (true) {
                    jf m515a = jiVar.m515a();
                    if (m515a.f14471a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m515a.f14471a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m517a = jiVar.m517a();
                while (i2 < m517a.f860a) {
                    a(jiVar, m517a.f14473a, i - 1);
                    a(jiVar, m517a.f14474b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m518a = jiVar.m518a();
                while (i2 < m518a.f861a) {
                    a(jiVar, m518a.f14478a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m516a = jiVar.m516a();
                while (i2 < m516a.f859a) {
                    a(jiVar, m516a.f14472a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

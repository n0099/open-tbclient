package com.xiaomi.push;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes8.dex */
public class jl {
    private static int a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(ji jiVar, byte b) {
        a(jiVar, b, a);
    }

    public static void a(ji jiVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jiVar.m490a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m478a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m488a();
                return;
            case 8:
                jiVar.m479a();
                return;
            case 10:
                jiVar.m480a();
                return;
            case 11:
                jiVar.m487a();
                return;
            case 12:
                jiVar.m485a();
                while (true) {
                    jf m481a = jiVar.m481a();
                    if (m481a.a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m481a.a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m483a = jiVar.m483a();
                while (i2 < m483a.f779a) {
                    a(jiVar, m483a.a, i - 1);
                    a(jiVar, m483a.b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m484a = jiVar.m484a();
                while (i2 < m484a.f780a) {
                    a(jiVar, m484a.a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m482a = jiVar.m482a();
                while (i2 < m482a.f778a) {
                    a(jiVar, m482a.a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

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
                jiVar.m492a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m480a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m490a();
                return;
            case 8:
                jiVar.m481a();
                return;
            case 10:
                jiVar.m482a();
                return;
            case 11:
                jiVar.m489a();
                return;
            case 12:
                jiVar.m487a();
                while (true) {
                    jf m483a = jiVar.m483a();
                    if (m483a.a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m483a.a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m485a = jiVar.m485a();
                while (i2 < m485a.f779a) {
                    a(jiVar, m485a.a, i - 1);
                    a(jiVar, m485a.b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m486a = jiVar.m486a();
                while (i2 < m486a.f780a) {
                    a(jiVar, m486a.a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m484a = jiVar.m484a();
                while (i2 < m484a.f778a) {
                    a(jiVar, m484a.a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

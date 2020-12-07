package com.xiaomi.push;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes18.dex */
public class jl {

    /* renamed from: a  reason: collision with root package name */
    private static int f4775a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(ji jiVar, byte b) {
        a(jiVar, b, f4775a);
    }

    public static void a(ji jiVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jiVar.m487a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m475a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m485a();
                return;
            case 8:
                jiVar.m476a();
                return;
            case 10:
                jiVar.m477a();
                return;
            case 11:
                jiVar.m484a();
                return;
            case 12:
                jiVar.m482a();
                while (true) {
                    jf m478a = jiVar.m478a();
                    if (m478a.f4770a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m478a.f4770a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m480a = jiVar.m480a();
                while (i2 < m480a.f781a) {
                    a(jiVar, m480a.f4772a, i - 1);
                    a(jiVar, m480a.b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m481a = jiVar.m481a();
                while (i2 < m481a.f782a) {
                    a(jiVar, m481a.f4776a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m479a = jiVar.m479a();
                while (i2 < m479a.f780a) {
                    a(jiVar, m479a.f4771a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

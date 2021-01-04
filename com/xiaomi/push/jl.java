package com.xiaomi.push;

import androidx.appcompat.widget.ActivityChooserView;
/* loaded from: classes6.dex */
public class jl {

    /* renamed from: a  reason: collision with root package name */
    private static int f14476a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(ji jiVar, byte b2) {
        a(jiVar, b2, f14476a);
    }

    public static void a(ji jiVar, byte b2, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b2) {
            case 2:
                jiVar.m513a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m501a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m511a();
                return;
            case 8:
                jiVar.m502a();
                return;
            case 10:
                jiVar.m503a();
                return;
            case 11:
                jiVar.m510a();
                return;
            case 12:
                jiVar.m508a();
                while (true) {
                    jf m504a = jiVar.m504a();
                    if (m504a.f14470a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m504a.f14470a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m506a = jiVar.m506a();
                while (i2 < m506a.f859a) {
                    a(jiVar, m506a.f14472a, i - 1);
                    a(jiVar, m506a.f14473b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m507a = jiVar.m507a();
                while (i2 < m507a.f860a) {
                    a(jiVar, m507a.f14477a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m505a = jiVar.m505a();
                while (i2 < m505a.f858a) {
                    a(jiVar, m505a.f14471a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

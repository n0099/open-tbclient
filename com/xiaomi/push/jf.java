package com.xiaomi.push;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes8.dex */
public class jf {
    private static int a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(jc jcVar, byte b) {
        a(jcVar, b, a);
    }

    public static void a(jc jcVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new iw("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jcVar.m480a();
                return;
            case 3:
                jcVar.a();
                return;
            case 4:
                jcVar.m468a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jcVar.m478a();
                return;
            case 8:
                jcVar.m469a();
                return;
            case 10:
                jcVar.m470a();
                return;
            case 11:
                jcVar.m477a();
                return;
            case 12:
                jcVar.m475a();
                while (true) {
                    iz m471a = jcVar.m471a();
                    if (m471a.a == 0) {
                        jcVar.f();
                        return;
                    } else {
                        a(jcVar, m471a.a, i - 1);
                        jcVar.g();
                    }
                }
            case 13:
                jb m473a = jcVar.m473a();
                while (i2 < m473a.f793a) {
                    a(jcVar, m473a.a, i - 1);
                    a(jcVar, m473a.b, i - 1);
                    i2++;
                }
                jcVar.h();
                return;
            case 14:
                jg m474a = jcVar.m474a();
                while (i2 < m474a.f794a) {
                    a(jcVar, m474a.a, i - 1);
                    i2++;
                }
                jcVar.j();
                return;
            case 15:
                ja m472a = jcVar.m472a();
                while (i2 < m472a.f792a) {
                    a(jcVar, m472a.a, i - 1);
                    i2++;
                }
                jcVar.i();
                return;
        }
    }
}

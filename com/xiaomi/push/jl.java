package com.xiaomi.push;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes18.dex */
public class jl {

    /* renamed from: a  reason: collision with root package name */
    private static int f5005a = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;

    public static void a(ji jiVar, byte b) {
        a(jiVar, b, f5005a);
    }

    public static void a(ji jiVar, byte b, int i) {
        int i2 = 0;
        if (i <= 0) {
            throw new jc("Maximum skip depth exceeded");
        }
        switch (b) {
            case 2:
                jiVar.m497a();
                return;
            case 3:
                jiVar.a();
                return;
            case 4:
                jiVar.m485a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                jiVar.m495a();
                return;
            case 8:
                jiVar.m486a();
                return;
            case 10:
                jiVar.m487a();
                return;
            case 11:
                jiVar.m494a();
                return;
            case 12:
                jiVar.m492a();
                while (true) {
                    jf m488a = jiVar.m488a();
                    if (m488a.f5000a == 0) {
                        jiVar.f();
                        return;
                    } else {
                        a(jiVar, m488a.f5000a, i - 1);
                        jiVar.g();
                    }
                }
            case 13:
                jh m490a = jiVar.m490a();
                while (i2 < m490a.f783a) {
                    a(jiVar, m490a.f5002a, i - 1);
                    a(jiVar, m490a.b, i - 1);
                    i2++;
                }
                jiVar.h();
                return;
            case 14:
                jm m491a = jiVar.m491a();
                while (i2 < m491a.f784a) {
                    a(jiVar, m491a.f5006a, i - 1);
                    i2++;
                }
                jiVar.j();
                return;
            case 15:
                jg m489a = jiVar.m489a();
                while (i2 < m489a.f782a) {
                    a(jiVar, m489a.f5001a, i - 1);
                    i2++;
                }
                jiVar.i();
                return;
        }
    }
}

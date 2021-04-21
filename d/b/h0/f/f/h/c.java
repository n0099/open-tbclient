package d.b.h0.f.f.h;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48559a = k.f45772a;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String l = b.l(str2);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        if (f48559a) {
            Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b();
        bVar.m(aVar);
        bVar.f47973b = l;
        bVar.f47975d = str3;
        bVar.w = str;
        bVar.k = k0.z();
        if (e.O() != null) {
            b.a J = e.O().J();
            bVar.f47972a = h.n(J.F());
            bVar.f47976e = J.G();
            bVar.f47974c = J.S();
        }
        bVar.u = str4;
        h.u("1245", bVar);
    }
}

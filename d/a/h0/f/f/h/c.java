package d.a.h0.f.f.h;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46020a = k.f43101a;

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        String l = b.l(str2);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        if (f46020a) {
            Log.d("GameCenterStatistic", "packageName:" + str + ";operation:" + str2 + ";value:" + str3 + ";errorCode:" + str4);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b bVar = new b();
        bVar.m(aVar);
        bVar.f45412b = l;
        bVar.f45414d = str3;
        bVar.w = str;
        bVar.k = k0.z();
        if (e.O() != null) {
            b.a J = e.O().J();
            bVar.f45411a = h.n(J.F());
            bVar.f45415e = J.G();
            bVar.f45413c = J.S();
        }
        bVar.u = str4;
        h.u("1245", bVar);
    }
}

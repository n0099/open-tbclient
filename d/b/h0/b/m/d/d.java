package d.b.h0.b.m.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.h0.a.k;
import d.b.h0.a.z1.h;
import d.b.h0.a.z1.k.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48138a = k.f45772a;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.f47972a = "swan";
        fVar.f47973b = str;
        fVar.f47977f = str2;
        if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
            fVar.f47975d = str3;
        }
        fVar.f47976e = str5;
        fVar.a("source", str4);
        if (f48138a) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
        }
        h.u("1372", fVar);
    }
}

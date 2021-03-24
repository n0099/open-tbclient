package d.b.g0.b.m.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.b.g0.a.k;
import d.b.g0.a.z1.h;
import d.b.g0.a.z1.k.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47416a = k.f45050a;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.f47250a = "swan";
        fVar.f47251b = str;
        fVar.f47255f = str2;
        if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
            fVar.f47253d = str3;
        }
        fVar.f47254e = str5;
        fVar.a("source", str4);
        if (f47416a) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
        }
        h.u("1372", fVar);
    }
}

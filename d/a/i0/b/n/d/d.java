package d.a.i0.b.n.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.i0.a.j2.p.f;
import d.a.i0.a.k;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46203a = k.f43025a;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.f43011a = "swan";
        fVar.f43012b = str;
        fVar.f43017g = str2;
        if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
            fVar.f43015e = str3;
        }
        fVar.f43016f = str5;
        fVar.a("source", str4);
        if (f46203a) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
        }
        d.a.i0.a.j2.k.u("1372", fVar);
    }
}

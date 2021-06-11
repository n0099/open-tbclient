package d.a.l0.b.n.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.j2.p.f;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50053a = k.f46875a;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.f46861a = "swan";
        fVar.f46862b = str;
        fVar.f46867g = str2;
        if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
            fVar.f46865e = str3;
        }
        fVar.f46866f = str5;
        fVar.a("source", str4);
        if (f50053a) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
        }
        d.a.l0.a.j2.k.u("1372", fVar);
    }
}

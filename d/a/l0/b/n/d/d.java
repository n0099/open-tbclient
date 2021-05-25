package d.a.l0.b.n.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.j2.p.f;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46379a = k.f43199a;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.f43185a = "swan";
        fVar.f43186b = str;
        fVar.f43191g = str2;
        if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
            fVar.f43189e = str3;
        }
        fVar.f43190f = str5;
        fVar.a("source", str4);
        if (f46379a) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
        }
        d.a.l0.a.j2.k.u("1372", fVar);
    }
}

package d.a.h0.b.m.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.h0.a.k;
import d.a.h0.a.z1.h;
import d.a.h0.a.z1.k.f;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45584a = k.f43101a;

    public static void a(String str, String str2, String str3, String str4, String str5) {
        f fVar = new f();
        fVar.f45411a = "swan";
        fVar.f45412b = str;
        fVar.f45416f = str2;
        if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
            fVar.f45414d = str3;
        }
        fVar.f45415e = str5;
        fVar.a("source", str4);
        if (f45584a) {
            Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
        }
        h.u("1372", fVar);
    }
}

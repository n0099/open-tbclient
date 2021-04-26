package d.a.h0.a.t.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import d.a.h0.a.k;
import d.a.h0.a.p.d.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44328a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f44329b = {"swan", "swanAPI", "utils"};

    @NonNull
    public static Pair<Boolean, d.a.h0.a.t.e.a> a(d.a.h0.a.t.b.a aVar, String str) {
        d.a.h0.a.t.e.b bVar = new d.a.h0.a.t.e.b();
        boolean b2 = b(str, aVar.a().h());
        if (b2) {
            bVar.f44324b = 402;
        }
        return new Pair<>(Boolean.valueOf(b2), bVar);
    }

    public static boolean b(String str, CallbackHandler callbackHandler) {
        boolean z;
        if (!(callbackHandler instanceof d)) {
            if (f44328a) {
                Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (f44328a) {
                throw new RuntimeException("whitelistName is empty");
            }
            return false;
        } else {
            String a0 = ((d) callbackHandler).a0();
            if ("ai_apps_widget".equals(a0)) {
                z = c(str);
            } else if ("ai_apps_ad_landing".equals(a0)) {
                z = !d.a.h0.a.s1.a.b.a(str);
            } else {
                if (!"swan_app_alliance_login_widget".equals(a0) && !"swan_app_alliance_choose_address_widget".equals(a0) && f44328a) {
                    Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                }
                return false;
            }
            if (f44328a) {
                Log.d("SwanApiSafe", "intercept: result=" + z + ", path=" + str);
            }
            return z;
        }
    }

    public static boolean c(@NonNull String str) {
        String[] strArr;
        int indexOf = str.indexOf("/");
        if (indexOf < 0) {
            return true;
        }
        if (str.startsWith("swan")) {
            String substring = str.substring(indexOf + 1);
            for (String str2 : f44329b) {
                if (d.a.h0.a.s1.a.b.g(str2 + "/" + substring)) {
                    return false;
                }
            }
            return true;
        }
        return !d.a.h0.a.s1.a.b.g(str);
    }
}

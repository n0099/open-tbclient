package d.a.i0.a.u.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import d.a.i0.a.k;
import d.a.i0.a.p.e.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45066a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f45067b = {"swan", "swanAPI", "utils"};

    @NonNull
    public static Pair<Boolean, d.a.i0.a.u.h.a> a(d.a.i0.a.u.c.a aVar, String str) {
        d.a.i0.a.u.h.b bVar = new d.a.i0.a.u.h.b();
        boolean b2 = b(str, aVar.a().h());
        if (b2) {
            bVar.f45062b = 402;
        }
        return new Pair<>(Boolean.valueOf(b2), bVar);
    }

    public static boolean b(String str, CallbackHandler callbackHandler) {
        boolean z;
        if (!(callbackHandler instanceof d)) {
            if (f45066a) {
                Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (f45066a) {
                throw new RuntimeException("whitelistName is empty");
            }
            return false;
        } else {
            String c0 = ((d) callbackHandler).c0();
            if ("ai_apps_widget".equals(c0)) {
                z = c(str);
            } else if ("ai_apps_ad_landing".equals(c0)) {
                z = !d.a.i0.a.b2.a.b.a(str);
            } else {
                if (!"swan_app_alliance_login_widget".equals(c0) && !"swan_app_alliance_choose_address_widget".equals(c0) && f45066a) {
                    Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                }
                return false;
            }
            if (f45066a) {
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
            for (String str2 : f45067b) {
                if (d.a.i0.a.b2.a.b.g(str2 + "/" + substring)) {
                    return false;
                }
            }
            return true;
        }
        return !d.a.i0.a.b2.a.b.g(str);
    }
}

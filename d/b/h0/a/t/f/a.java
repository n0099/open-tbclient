package d.b.h0.a.t.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import d.b.h0.a.k;
import d.b.h0.a.p.d.d;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46940a = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f46941b = {"swan", "swanAPI", "utils"};

    @NonNull
    public static Pair<Boolean, d.b.h0.a.t.e.a> a(d.b.h0.a.t.b.a aVar, String str) {
        d.b.h0.a.t.e.b bVar = new d.b.h0.a.t.e.b();
        boolean b2 = b(str, aVar.a().h());
        if (b2) {
            bVar.f46936b = 402;
        }
        return new Pair<>(Boolean.valueOf(b2), bVar);
    }

    public static boolean b(String str, CallbackHandler callbackHandler) {
        boolean z;
        if (!(callbackHandler instanceof d)) {
            if (f46940a) {
                Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (f46940a) {
                throw new RuntimeException("whitelistName is empty");
            }
            return false;
        } else {
            String T = ((d) callbackHandler).T();
            if ("ai_apps_widget".equals(T)) {
                z = c(str);
            } else if ("ai_apps_ad_landing".equals(T)) {
                z = !d.b.h0.a.s1.a.b.a(str);
            } else {
                if (!"swan_app_alliance_login_widget".equals(T) && !"swan_app_alliance_choose_address_widget".equals(T) && f46940a) {
                    Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                }
                return false;
            }
            if (f46940a) {
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
            for (String str2 : f46941b) {
                if (d.b.h0.a.s1.a.b.g(str2 + "/" + substring)) {
                    return false;
                }
            }
            return true;
        }
        return !d.b.h0.a.s1.a.b.g(str);
    }
}

package d.b.g0.a.t.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import d.b.g0.a.k;
import d.b.g0.a.p.d.d;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46218a = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f46219b = {"swan", "swanAPI", "utils"};

    @NonNull
    public static Pair<Boolean, d.b.g0.a.t.e.a> a(d.b.g0.a.t.b.a aVar, String str) {
        d.b.g0.a.t.e.b bVar = new d.b.g0.a.t.e.b();
        boolean b2 = b(str, aVar.a().h());
        if (b2) {
            bVar.f46214b = 402;
        }
        return new Pair<>(Boolean.valueOf(b2), bVar);
    }

    public static boolean b(String str, CallbackHandler callbackHandler) {
        boolean z;
        if (!(callbackHandler instanceof d)) {
            if (f46218a) {
                Log.d("SwanApiSafe", "intercept: false, handler is null or not WebSafeHolder");
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (f46218a) {
                throw new RuntimeException("whitelistName is empty");
            }
            return false;
        } else {
            String S = ((d) callbackHandler).S();
            if ("ai_apps_widget".equals(S)) {
                z = c(str);
            } else if ("ai_apps_ad_landing".equals(S)) {
                z = !d.b.g0.a.s1.a.b.a(str);
            } else {
                if (!"swan_app_alliance_login_widget".equals(S) && !"swan_app_alliance_choose_address_widget".equals(S) && f46218a) {
                    Log.d("SwanApiSafe", "intercept: false, source frame is not aiapps widget frame");
                }
                return false;
            }
            if (f46218a) {
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
            for (String str2 : f46219b) {
                if (d.b.g0.a.s1.a.b.g(str2 + "/" + substring)) {
                    return false;
                }
            }
            return true;
        }
        return !d.b.g0.a.s1.a.b.g(str);
    }
}

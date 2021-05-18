package d.a.i0.d.g;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.tencent.open.SocialOperation;
import d.a.i0.t.d;
import d.a.i0.t.h;
import d.a.i0.t.i;
import d.a.i0.t.j;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f46344c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f46346b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f46345a = new a();

    /* loaded from: classes3.dex */
    public static class a extends j {
        public a() {
            super("swan_host_info_config_sp_name");
        }
    }

    public static c e() {
        if (f46344c == null) {
            synchronized (c.class) {
                if (f46344c == null) {
                    f46344c = new c();
                }
            }
        }
        return f46344c;
    }

    public Set<String> a() {
        Set<String> stringSet = this.f46345a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet != null) {
            return stringSet;
        }
        if (h()) {
            return this.f46345a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        }
        return null;
    }

    public String b() {
        String c2 = c("appKey");
        if (TextUtils.isEmpty(c2)) {
            if (d.a.i0.d.c.f46343a) {
                throw new IllegalStateException("获取 host app key 失败");
            }
            return "";
        }
        return c2;
    }

    public final String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.f46345a.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (h()) {
                String string2 = this.f46345a.getString(str, "");
                if (!TextUtils.isEmpty(string2)) {
                    return string2;
                }
            }
            return null;
        }
        return string;
    }

    public String d() {
        String c2 = c("hostName");
        if (TextUtils.isEmpty(c2)) {
            if (d.a.i0.d.c.f46343a) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return c2;
    }

    public String f() {
        String c2 = c("schemeHead");
        if (TextUtils.isEmpty(c2)) {
            if (d.a.i0.d.c.f46343a) {
                throw new IllegalStateException("获取 SchemeHead-协议头 失败");
            }
            return "";
        }
        return c2;
    }

    public String g(String str, int i2, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c2 = c("shareCallBackUrl");
        if (TextUtils.isEmpty(c2)) {
            return "";
        }
        String a2 = i.a(i.a(c2, "type", String.valueOf(i2)), "appKey", str);
        return !TextUtils.isEmpty(str2) ? i.a(a2, "path", h.b(str2)) : a2;
    }

    public final synchronized boolean h() {
        if (this.f46346b) {
            return true;
        }
        String C = d.C(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(C)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            C = file.exists() ? d.D(file) : null;
        }
        if (TextUtils.isEmpty(C)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
            String optString = jSONObject.optString("hostName");
            String optString2 = jSONObject.optString("schemeHead");
            String optString3 = jSONObject.optString("appKey");
            String optString4 = jSONObject.optString("shareCallBackUrl");
            int optInt = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                hashSet = new HashSet();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    hashSet.add(optJSONArray.optString(i2));
                }
            }
            i(optString, optString2, optString3, optString4, optInt, hashSet);
            this.f46346b = true;
            return true;
        } catch (JSONException e2) {
            if (d.a.i0.d.c.f46343a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void i(String str, String str2, String str3, String str4, int i2, Set<String> set) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 < 0) {
            return;
        }
        SharedPreferences.Editor putInt = this.f46345a.edit().putString("hostName", str).putString("schemeHead", str2).putString("appKey", str3).putString("shareCallBackUrl", str4).putInt("version", i2);
        if (set != null && !set.isEmpty()) {
            putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
        }
        putInt.apply();
    }
}

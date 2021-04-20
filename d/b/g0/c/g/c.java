package d.b.g0.c.g;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.tencent.open.SocialOperation;
import d.b.g0.p.d;
import d.b.g0.p.g;
import d.b.g0.p.h;
import d.b.g0.p.i;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f47878c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f47880b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f47879a = new a();

    /* loaded from: classes3.dex */
    public static class a extends i {
        public a() {
            super("swan_host_info_config_sp_name");
        }
    }

    public static c e() {
        if (f47878c == null) {
            synchronized (c.class) {
                if (f47878c == null) {
                    f47878c = new c();
                }
            }
        }
        return f47878c;
    }

    public Set<String> a() {
        Set<String> stringSet = this.f47879a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet != null) {
            return stringSet;
        }
        if (h()) {
            return this.f47879a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        }
        return null;
    }

    public String b() {
        String c2 = c("appKey");
        if (TextUtils.isEmpty(c2)) {
            if (d.b.g0.c.c.f47877a) {
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
        String string = this.f47879a.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (h()) {
                String string2 = this.f47879a.getString(str, "");
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
            if (d.b.g0.c.c.f47877a) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return c2;
    }

    public String f() {
        String c2 = c("schemeHead");
        if (TextUtils.isEmpty(c2)) {
            if (d.b.g0.c.c.f47877a) {
                throw new IllegalStateException("获取 SchemeHead-协议头 失败");
            }
            return "";
        }
        return c2;
    }

    public String g(String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String c2 = c("shareCallBackUrl");
        if (TextUtils.isEmpty(c2)) {
            return "";
        }
        String a2 = h.a(h.a(c2, "type", String.valueOf(i)), "appKey", str);
        return !TextUtils.isEmpty(str2) ? h.a(a2, "path", g.b(str2)) : a2;
    }

    public final synchronized boolean h() {
        if (this.f47880b) {
            return true;
        }
        String q = d.q(AppRuntime.getAppContext(), "config/union-cfg.json");
        HashSet hashSet = null;
        if (TextUtils.isEmpty(q)) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_config/union-cfg.json");
            q = file.exists() ? d.r(file) : null;
        }
        if (TextUtils.isEmpty(q)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            String optString = jSONObject.optString("hostName");
            String optString2 = jSONObject.optString("schemeHead");
            String optString3 = jSONObject.optString("appKey");
            String optString4 = jSONObject.optString("shareCallBackUrl");
            int optInt = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray(SocialOperation.GAME_SIGNATURE);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                hashSet = new HashSet();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    hashSet.add(optJSONArray.optString(i));
                }
            }
            i(optString, optString2, optString3, optString4, optInt, hashSet);
            this.f47880b = true;
            return true;
        } catch (JSONException e2) {
            if (d.b.g0.c.c.f47877a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void i(String str, String str2, String str3, String str4, int i, Set<String> set) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i < 0) {
            return;
        }
        SharedPreferences.Editor putInt = this.f47879a.edit().putString("hostName", str).putString("schemeHead", str2).putString("appKey", str3).putString("shareCallBackUrl", str4).putInt("version", i);
        if (set != null && !set.isEmpty()) {
            putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
        }
        putInt.apply();
    }
}

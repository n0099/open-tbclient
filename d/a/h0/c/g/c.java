package d.a.h0.c.g;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.tencent.open.SocialOperation;
import d.a.h0.p.d;
import d.a.h0.p.g;
import d.a.h0.p.h;
import d.a.h0.p.i;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f45656c;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f45658b = false;

    /* renamed from: a  reason: collision with root package name */
    public a f45657a = new a();

    /* loaded from: classes3.dex */
    public static class a extends i {
        public a() {
            super("swan_host_info_config_sp_name");
        }
    }

    public static c e() {
        if (f45656c == null) {
            synchronized (c.class) {
                if (f45656c == null) {
                    f45656c = new c();
                }
            }
        }
        return f45656c;
    }

    public Set<String> a() {
        Set<String> stringSet = this.f45657a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        if (stringSet != null) {
            return stringSet;
        }
        if (h()) {
            return this.f45657a.getStringSet(SocialOperation.GAME_SIGNATURE, null);
        }
        return null;
    }

    public String b() {
        String c2 = c("appKey");
        if (TextUtils.isEmpty(c2)) {
            if (d.a.h0.c.c.f45655a) {
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
        String string = this.f45657a.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            if (h()) {
                String string2 = this.f45657a.getString(str, "");
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
            if (d.a.h0.c.c.f45655a) {
                throw new IllegalStateException("获取 HostName-宿主名称 失败");
            }
            return "";
        }
        return c2;
    }

    public String f() {
        String c2 = c("schemeHead");
        if (TextUtils.isEmpty(c2)) {
            if (d.a.h0.c.c.f45655a) {
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
        String a2 = h.a(h.a(c2, "type", String.valueOf(i2)), "appKey", str);
        return !TextUtils.isEmpty(str2) ? h.a(a2, "path", g.b(str2)) : a2;
    }

    public final synchronized boolean h() {
        if (this.f45658b) {
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
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    hashSet.add(optJSONArray.optString(i2));
                }
            }
            i(optString, optString2, optString3, optString4, optInt, hashSet);
            this.f45658b = true;
            return true;
        } catch (JSONException e2) {
            if (d.a.h0.c.c.f45655a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public final void i(String str, String str2, String str3, String str4, int i2, Set<String> set) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i2 < 0) {
            return;
        }
        SharedPreferences.Editor putInt = this.f45657a.edit().putString("hostName", str).putString("schemeHead", str2).putString("appKey", str3).putString("shareCallBackUrl", str4).putInt("version", i2);
        if (set != null && !set.isEmpty()) {
            putInt.putStringSet(SocialOperation.GAME_SIGNATURE, set);
        }
        putInt.apply();
    }
}

package d.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f65020h = {"channel", "package", "app_version"};

    /* renamed from: a  reason: collision with root package name */
    public boolean f65021a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f65022b;

    /* renamed from: c  reason: collision with root package name */
    public final i f65023c;

    /* renamed from: f  reason: collision with root package name */
    public final SharedPreferences f65026f;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<h2> f65025e = new ArrayList<>(32);

    /* renamed from: g  reason: collision with root package name */
    public int f65027g = 0;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f65024d = new JSONObject();

    public j(Context context, i iVar) {
        this.f65022b = context;
        this.f65023c = iVar;
        this.f65026f = iVar.A();
        x0.d(this.f65022b);
    }

    public static void f(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static boolean n(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i) != '0') {
                break;
            } else {
                i++;
            }
        }
        return !z;
    }

    @Nullable
    public <T> T a(String str, T t) {
        JSONObject y = y();
        Object obj = (y == null || (obj = y.opt(str)) == null) ? null : null;
        return obj == null ? t : (T) obj;
    }

    public final String b(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @Nullable
    public JSONObject c() {
        if (this.f65021a) {
            return y();
        }
        return null;
    }

    public void d(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = y().optJSONObject("custom");
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e2) {
                r0.b(e2);
            }
        }
        if (k("custom", jSONObject)) {
            this.f65023c.x(jSONObject);
        }
    }

    public void e(JSONObject jSONObject) {
        this.f65023c.z(jSONObject);
        j(jSONObject);
    }

    public final boolean g(h2 h2Var) {
        boolean z = !this.f65023c.N() && h2Var.f65005d;
        if (r0.f65064b) {
            r0.a("needSyncFromSub " + h2Var + " " + z, null);
        }
        return z;
    }

    public boolean h(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (r0.f65064b) {
            r0.a("saveRegisterInfo, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONObject, null);
        }
        boolean p = p(str);
        boolean p2 = p(str2);
        try {
            boolean p3 = p(str3);
            int i = this.f65026f.getInt("version_code", 0);
            try {
                int optInt = y().optInt("version_code", 0);
                SharedPreferences.Editor edit = this.f65026f.edit();
                if (i != optInt) {
                    edit.putInt("version_code", optInt);
                }
                if (p) {
                    long currentTimeMillis = System.currentTimeMillis();
                    edit.putLong("register_time", currentTimeMillis);
                    k("register_time", Long.valueOf(currentTimeMillis));
                } else if (!p) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("response", jSONObject);
                    a.r("tt_fetch_did_error", jSONObject2);
                }
                String optString = y().optString(Constants.KEY_DEVICE_ID, "");
                if (p && k(Constants.KEY_DEVICE_ID, str)) {
                    edit.putString(Constants.KEY_DEVICE_ID, str);
                    z = true;
                } else {
                    z = false;
                }
                String optString2 = y().optString("install_id", "");
                if (p2 && k("install_id", str2)) {
                    edit.putString("install_id", str2);
                    z = true;
                }
                String optString3 = y().optString("ssid", "");
                if (p3 && k("ssid", str3)) {
                    edit.putString("ssid", str3);
                    z2 = true;
                } else {
                    z2 = z;
                }
                a.f().c(z2, optString, str, optString2, str2, optString3, str3);
                edit.apply();
            } catch (JSONException e2) {
                e = e2;
                r0.b(e);
                if (p) {
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
        return !p && p2;
    }

    @Nullable
    public JSONObject i() {
        JSONObject c2 = c();
        if (c2 != null) {
            try {
                String b2 = x0.b(c2.optJSONObject("oaid"));
                if (!TextUtils.isEmpty(b2)) {
                    JSONObject jSONObject = new JSONObject();
                    s0.g(jSONObject, c2);
                    jSONObject.put("oaid", b2);
                    return jSONObject;
                }
            } catch (Exception e2) {
                r0.b(e2);
            }
        }
        return c2;
    }

    public final synchronized void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            r0.c("null abconfig", null);
            return;
        }
        String optString = y().optString("ab_version");
        if (!TextUtils.isEmpty(optString)) {
            String[] split = optString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> keys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString(TiebaStatic.Params.VID));
                        } catch (JSONException e2) {
                            r0.b(e2);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            k("ab_version", b(hashSet));
        }
    }

    public final boolean k(String str, Object obj) {
        boolean z;
        Object opt = y().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f65024d;
                    JSONObject jSONObject2 = new JSONObject();
                    s0.g(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f65024d = jSONObject2;
                } catch (JSONException e2) {
                    r0.b(e2);
                }
            }
            z = true;
        }
        r0.a("updateHeader, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + opt + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj, null);
        return z;
    }

    public int l() {
        int optInt = this.f65021a ? y().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && optInt == -1; i++) {
            o();
            optInt = this.f65021a ? y().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public String m() {
        String optString = this.f65021a ? y().optString("app_version", null) : null;
        for (int i = 0; i < 3 && optString == null; i++) {
            o();
            optString = this.f65021a ? y().optString("app_version", null) : null;
        }
        return optString;
    }

    public boolean o() {
        String[] strArr;
        synchronized (this.f65025e) {
            if (this.f65025e.size() == 0) {
                this.f65025e.add(new e());
                this.f65025e.add(new g(this.f65022b));
                this.f65025e.add(new h(this.f65022b, this.f65023c));
                this.f65025e.add(new k(this.f65022b));
                this.f65025e.add(new m(this.f65022b));
                this.f65025e.add(new n(this.f65022b, this.f65023c));
                this.f65025e.add(new o(this.f65022b));
                this.f65025e.add(new q(this.f65022b));
                this.f65025e.add(new r(this.f65022b, this.f65023c));
                this.f65025e.add(new s());
                this.f65025e.add(new t(this.f65023c));
                this.f65025e.add(new u(this.f65022b));
                this.f65025e.add(new v(this.f65022b));
                this.f65025e.add(new w(this.f65022b, this.f65023c));
                this.f65025e.add(new f2(this.f65022b, this.f65023c));
                this.f65025e.add(new p(this.f65022b, this.f65023c));
                this.f65025e.add(new f(this.f65022b, this.f65023c));
            }
        }
        JSONObject y = y();
        JSONObject jSONObject = new JSONObject();
        s0.g(jSONObject, y);
        Iterator<h2> it = this.f65025e.iterator();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            h2 next = it.next();
            if (!next.f65002a || next.f65004c || g(next)) {
                try {
                    next.f65002a = next.b(jSONObject);
                } catch (SecurityException e2) {
                    if (!next.f65003b) {
                        i++;
                        r0.c("loadHeader, " + this.f65027g, e2);
                        if (!next.f65002a && this.f65027g > 10) {
                            next.f65002a = true;
                        }
                    }
                } catch (JSONException e3) {
                    r0.b(e3);
                }
                if (!next.f65002a && !next.f65003b) {
                    i2++;
                }
            }
            z &= next.f65002a || next.f65003b;
        }
        if (z) {
            int length = f65020h.length;
            for (int i3 = 0; i3 < length; i3++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(strArr[i3]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.f65024d = jSONObject;
        this.f65021a = z;
        if (r0.f65064b) {
            r0.a("loadHeader, " + this.f65021a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f65027g + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f65024d.toString(), null);
        } else {
            r0.e("loadHeader, " + this.f65021a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f65027g, null);
        }
        if (i > 0 && i == i2) {
            this.f65027g++;
            if (v() != 0) {
                this.f65027g += 10;
            }
        }
        if (this.f65021a) {
            a.f().a(r(), s(), t());
        }
        return this.f65021a;
    }

    public String q() {
        return y().optString("user_unique_id", "");
    }

    public String r() {
        return y().optString(Constants.KEY_DEVICE_ID, "");
    }

    public String s() {
        return y().optString("install_id", "");
    }

    public String t() {
        return y().optString("ssid", "");
    }

    public String u() {
        return y().optString("user_unique_id", "");
    }

    public int v() {
        String optString = y().optString(Constants.KEY_DEVICE_ID, "");
        y().optString("install_id", "");
        if (p(optString)) {
            return this.f65026f.getInt("version_code", 0) == y().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long w() {
        return y().optLong("register_time", 0L);
    }

    public String x() {
        return y().optString("ab_sdk_version", "");
    }

    @NonNull
    public final JSONObject y() {
        return this.f65024d;
    }
}

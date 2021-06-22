package d.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.service.AsInstallService;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f68882h = {"channel", AsInstallService.SCHEME_PACKAGE_ADDED, "app_version"};

    /* renamed from: a  reason: collision with root package name */
    public boolean f68883a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f68884b;

    /* renamed from: c  reason: collision with root package name */
    public final i f68885c;

    /* renamed from: f  reason: collision with root package name */
    public final SharedPreferences f68888f;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<h2> f68887e = new ArrayList<>(32);

    /* renamed from: g  reason: collision with root package name */
    public int f68889g = 0;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f68886d = new JSONObject();

    public j(Context context, i iVar) {
        this.f68884b = context;
        this.f68885c = iVar;
        this.f68888f = iVar.A();
        x0.d(this.f68884b);
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
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
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
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i2) != '0') {
                break;
            } else {
                i2++;
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
        if (this.f68883a) {
            return y();
        }
        return null;
    }

    public void d(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = y().optJSONObject(SchedulerSupport.CUSTOM);
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
        if (k(SchedulerSupport.CUSTOM, jSONObject)) {
            this.f68885c.x(jSONObject);
        }
    }

    public void e(JSONObject jSONObject) {
        this.f68885c.z(jSONObject);
        j(jSONObject);
    }

    public final boolean g(h2 h2Var) {
        boolean z = !this.f68885c.N() && h2Var.f68867d;
        if (r0.f68927b) {
            r0.a("needSyncFromSub " + h2Var + " " + z, null);
        }
        return z;
    }

    public boolean h(JSONObject jSONObject, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (r0.f68927b) {
            r0.a("saveRegisterInfo, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + jSONObject, null);
        }
        boolean p = p(str);
        boolean p2 = p(str2);
        try {
            boolean p3 = p(str3);
            int i2 = this.f68888f.getInt("version_code", 0);
            try {
                int optInt = y().optInt("version_code", 0);
                SharedPreferences.Editor edit = this.f68888f.edit();
                if (i2 != optInt) {
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
                a.f().b(z2, optString, str, optString2, str2, optString3, str3);
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
                    JSONObject jSONObject = this.f68886d;
                    JSONObject jSONObject2 = new JSONObject();
                    s0.g(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f68886d = jSONObject2;
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
        int optInt = this.f68883a ? y().optInt("version_code", -1) : -1;
        for (int i2 = 0; i2 < 3 && optInt == -1; i2++) {
            o();
            optInt = this.f68883a ? y().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public String m() {
        String optString = this.f68883a ? y().optString("app_version", null) : null;
        for (int i2 = 0; i2 < 3 && optString == null; i2++) {
            o();
            optString = this.f68883a ? y().optString("app_version", null) : null;
        }
        return optString;
    }

    public boolean o() {
        String[] strArr;
        synchronized (this.f68887e) {
            if (this.f68887e.size() == 0) {
                this.f68887e.add(new e());
                this.f68887e.add(new g(this.f68884b));
                this.f68887e.add(new h(this.f68884b, this.f68885c));
                this.f68887e.add(new k(this.f68884b));
                this.f68887e.add(new m(this.f68884b));
                this.f68887e.add(new n(this.f68884b, this.f68885c));
                this.f68887e.add(new o(this.f68884b));
                this.f68887e.add(new q(this.f68884b));
                this.f68887e.add(new r(this.f68884b, this.f68885c));
                this.f68887e.add(new s());
                this.f68887e.add(new t(this.f68885c));
                this.f68887e.add(new u(this.f68884b));
                this.f68887e.add(new v(this.f68884b));
                this.f68887e.add(new w(this.f68884b, this.f68885c));
                this.f68887e.add(new f2(this.f68884b, this.f68885c));
                this.f68887e.add(new p(this.f68884b, this.f68885c));
                this.f68887e.add(new f(this.f68884b, this.f68885c));
            }
        }
        JSONObject y = y();
        JSONObject jSONObject = new JSONObject();
        s0.g(jSONObject, y);
        Iterator<h2> it = this.f68887e.iterator();
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            h2 next = it.next();
            if (!next.f68864a || next.f68866c || g(next)) {
                try {
                    next.f68864a = next.b(jSONObject);
                } catch (SecurityException e2) {
                    if (!next.f68865b) {
                        i2++;
                        r0.c("loadHeader, " + this.f68889g, e2);
                        if (!next.f68864a && this.f68889g > 10) {
                            next.f68864a = true;
                        }
                    }
                } catch (JSONException e3) {
                    r0.b(e3);
                }
                if (!next.f68864a && !next.f68865b) {
                    i3++;
                }
            }
            z &= next.f68864a || next.f68865b;
        }
        if (z) {
            int length = f68882h.length;
            for (int i4 = 0; i4 < length; i4++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(strArr[i4]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.f68886d = jSONObject;
        this.f68883a = z;
        if (r0.f68927b) {
            r0.a("loadHeader, " + this.f68883a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f68889g + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f68886d.toString(), null);
        } else {
            r0.e("loadHeader, " + this.f68883a + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.f68889g, null);
        }
        if (i2 > 0 && i2 == i3) {
            this.f68889g++;
            if (v() != 0) {
                this.f68889g += 10;
            }
        }
        if (this.f68883a) {
            a.f().c(r(), s(), t());
        }
        return this.f68883a;
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
            return this.f68888f.getInt("version_code", 0) == y().optInt("version_code", -1) ? 1 : 2;
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
        return this.f68886d;
    }
}

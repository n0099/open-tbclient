package d.a.m0.a.n1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.Domains;
import com.facebook.common.internal.Sets;
import d.a.m0.a.c2.f.a0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Headers;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f47470d = Sets.newHashSet("REFERER", "USER-AGENT");

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Long> f47471c;

    public a(d.a.m0.a.c2.e eVar, String str) {
        super(eVar, str);
        this.f47471c = new ConcurrentHashMap<>();
    }

    public static HashMap<String, String> l(@Nullable JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() < 1) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && !f47470d.contains(next.toUpperCase())) {
                String optString = jSONObject.optString(next);
                if (TextUtils.isEmpty(optString)) {
                    optString = "";
                }
                hashMap.put(next, optString);
            }
        }
        return hashMap;
    }

    public static HashMap<String, String> m(@Nullable JSONObject jSONObject, boolean z) {
        HashMap<String, String> l = l(jSONObject);
        if (z) {
            if (l == null) {
                l = new HashMap<>();
            }
            l.put("Referer", d.a.m0.a.u.e.j.h.d());
        }
        return l;
    }

    public static JSONObject s(Headers headers) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (headers == null) {
            return jSONObject;
        }
        for (String str : headers.names()) {
            if (!TextUtils.isEmpty(str)) {
                List<String> values = headers.values(str);
                StringBuilder sb = new StringBuilder();
                int size = values.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append(values.get(i2));
                    if (i2 == size - 1) {
                        break;
                    }
                    sb.append(",");
                }
                jSONObject.put(str, sb.toString());
            }
        }
        return jSONObject;
    }

    public void j(@NonNull JSONObject jSONObject, String str) throws JSONException {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String optString = jSONObject.optString("Cookie");
        if (TextUtils.isEmpty(optString)) {
            jSONObject.put("Cookie", str);
            return;
        }
        if (optString.endsWith(";")) {
            str2 = optString + str;
        } else {
            str2 = optString + ";" + str;
        }
        jSONObject.put("Cookie", str2);
    }

    public boolean k(d.a.m0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        } else if (TextUtils.isEmpty(a2.optString("cb"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal cb");
            return false;
        } else if (TextUtils.isEmpty(a2.optString("url"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal url");
            return false;
        } else {
            return true;
        }
    }

    public JSONObject n(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("cancelTag", str);
            }
        } catch (JSONException e2) {
            if (a0.f44733b) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public String o() {
        return d.a.m0.a.c1.a.p().a().getCookie(Domains.BAIDU);
    }

    public final long p(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            return this.f47471c.get(str).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public final void q(String str) {
        if (this.f47471c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f47471c.remove(str);
    }

    public void r(String str, Headers headers) {
        if (TextUtils.isEmpty(str) || headers == null) {
            return;
        }
        try {
            JSONObject s = s(headers);
            if (s != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("header", s);
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.b(str, hashMap));
            }
        } catch (JSONException e2) {
            if (a0.f44733b) {
                e2.printStackTrace();
            }
        }
    }

    public JSONObject t(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                            }
                            return UnitedSchemeUtility.wrapCallbackParams(202, "illegal upload file over size.");
                        }
                        return UnitedSchemeUtility.wrapCallbackParams(202, "HTTP method is invalid");
                    }
                    return UnitedSchemeUtility.wrapCallbackParams(202, "request:fail parameter error: arrayBuffer of data exceed size limit.");
                }
                return UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
            }
            return UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
        }
        return UnitedSchemeUtility.wrapCallbackParams(0);
    }
}

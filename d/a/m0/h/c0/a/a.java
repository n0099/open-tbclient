package d.a.m0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.webkit.internal.CfgFileUtils;
import d.a.m0.a.a2.n.c;
import d.a.m0.a.k;
import d.a.m0.a.r1.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends d.a.m0.a.a2.n.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f51038h = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public int f51039b;

    /* renamed from: c  reason: collision with root package name */
    public b f51040c;

    /* renamed from: d  reason: collision with root package name */
    public c f51041d;

    /* renamed from: e  reason: collision with root package name */
    public String f51042e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.h.r.a f51043f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.h.y.e.a f51044g;

    /* renamed from: d.a.m0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1077a {

        /* renamed from: a  reason: collision with root package name */
        public String f51045a;

        /* renamed from: b  reason: collision with root package name */
        public String f51046b;

        /* renamed from: c  reason: collision with root package name */
        public String f51047c;

        /* renamed from: d  reason: collision with root package name */
        public String f51048d;

        public static C1077a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1077a c1077a = new C1077a();
            c1077a.f51046b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
            c1077a.f51045a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1077a.f51046b) && !TextUtils.isEmpty(c1077a.f51045a)) {
                if (c1077a.f51046b.endsWith(".js")) {
                    String[] split = c1077a.f51046b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1077a.f51048d = split[split.length - 1];
                    c1077a.f51047c = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        c1077a.f51047c += split[i2] + File.separator;
                    }
                } else {
                    String str = c1077a.f51046b;
                    c1077a.f51047c = str;
                    if (!str.endsWith(File.separator)) {
                        c1077a.f51047c += File.separator;
                    }
                    c1077a.f51048d = "index.js";
                }
                return c1077a;
            }
            return c();
        }

        public static C1077a c() {
            return new C1077a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1077a> f51049a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f51050b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f51049a = new ArrayList();
                bVar.f51050b = new HashMap<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bVar.f51049a.add(C1077a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f51049a = new ArrayList();
            bVar.f51050b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f51051a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1077a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f51049a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f51051a = new HashMap<>();
                for (C1077a c1077a : bVar.f51049a) {
                    if (c1077a != null && !TextUtils.isEmpty(c1077a.f51046b)) {
                        HashMap<String, String> hashMap = cVar.f51051a;
                        String str = c1077a.f51046b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f51051a = new HashMap<>();
            return cVar;
        }
    }

    public static a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f44563a = c.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f51039b = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f51039b = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f51040c = b2;
            aVar.f51041d = c.b(jSONObject, b2);
            aVar.f51042e = jSONObject.optString("openDataContext");
            aVar.f51043f = new d.a.m0.h.r.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            h.p("startup").A("preload_resources", z ? "1" : "0");
            aVar.f51044g = new d.a.m0.h.y.e.a(optJSONArray);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject != null) {
                optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            }
            return aVar;
        } catch (JSONException e2) {
            if (f51038h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

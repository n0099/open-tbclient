package d.a.l0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.webkit.internal.CfgFileUtils;
import d.a.l0.a.a2.n.c;
import d.a.l0.a.k;
import d.a.l0.a.r1.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends d.a.l0.a.a2.n.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47256h = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public int f47257b;

    /* renamed from: c  reason: collision with root package name */
    public b f47258c;

    /* renamed from: d  reason: collision with root package name */
    public c f47259d;

    /* renamed from: e  reason: collision with root package name */
    public String f47260e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.h.r.a f47261f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.y.e.a f47262g;

    /* renamed from: d.a.l0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1018a {

        /* renamed from: a  reason: collision with root package name */
        public String f47263a;

        /* renamed from: b  reason: collision with root package name */
        public String f47264b;

        /* renamed from: c  reason: collision with root package name */
        public String f47265c;

        /* renamed from: d  reason: collision with root package name */
        public String f47266d;

        public static C1018a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1018a c1018a = new C1018a();
            c1018a.f47264b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
            c1018a.f47263a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1018a.f47264b) && !TextUtils.isEmpty(c1018a.f47263a)) {
                if (c1018a.f47264b.endsWith(".js")) {
                    String[] split = c1018a.f47264b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1018a.f47266d = split[split.length - 1];
                    c1018a.f47265c = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        c1018a.f47265c += split[i2] + File.separator;
                    }
                } else {
                    String str = c1018a.f47264b;
                    c1018a.f47265c = str;
                    if (!str.endsWith(File.separator)) {
                        c1018a.f47265c += File.separator;
                    }
                    c1018a.f47266d = "index.js";
                }
                return c1018a;
            }
            return c();
        }

        public static C1018a c() {
            return new C1018a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1018a> f47267a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f47268b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f47267a = new ArrayList();
                bVar.f47268b = new HashMap<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bVar.f47267a.add(C1018a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f47267a = new ArrayList();
            bVar.f47268b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f47269a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1018a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f47267a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f47269a = new HashMap<>();
                for (C1018a c1018a : bVar.f47267a) {
                    if (c1018a != null && !TextUtils.isEmpty(c1018a.f47264b)) {
                        HashMap<String, String> hashMap = cVar.f47269a;
                        String str = c1018a.f47264b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f47269a = new HashMap<>();
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
            aVar.f40779a = c.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f47257b = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f47257b = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f47258c = b2;
            aVar.f47259d = c.b(jSONObject, b2);
            aVar.f47260e = jSONObject.optString("openDataContext");
            aVar.f47261f = new d.a.l0.h.r.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            h.p("startup").A("preload_resources", z ? "1" : "0");
            aVar.f47262g = new d.a.l0.h.y.e.a(optJSONArray);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject != null) {
                optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            }
            return aVar;
        } catch (JSONException e2) {
            if (f47256h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

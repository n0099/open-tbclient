package d.b.g0.g.z.a;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.j1.i;
import d.b.g0.a.k;
import d.b.g0.a.r1.n.b;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49085h = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public int f49086a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f49087b;

    /* renamed from: c  reason: collision with root package name */
    public b f49088c;

    /* renamed from: d  reason: collision with root package name */
    public c f49089d;

    /* renamed from: e  reason: collision with root package name */
    public String f49090e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.p.a f49091f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.w.f.a f49092g;

    /* renamed from: d.b.g0.g.z.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1016a {

        /* renamed from: a  reason: collision with root package name */
        public String f49093a;

        /* renamed from: b  reason: collision with root package name */
        public String f49094b;

        /* renamed from: c  reason: collision with root package name */
        public String f49095c;

        /* renamed from: d  reason: collision with root package name */
        public String f49096d;

        public static C1016a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1016a c1016a = new C1016a();
            c1016a.f49094b = jSONObject.optString("root");
            c1016a.f49093a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1016a.f49094b) && !TextUtils.isEmpty(c1016a.f49093a)) {
                if (c1016a.f49094b.endsWith(".js")) {
                    String[] split = c1016a.f49094b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1016a.f49096d = split[split.length - 1];
                    c1016a.f49095c = "";
                    for (int i = 0; i < split.length - 1; i++) {
                        c1016a.f49095c += split[i] + File.separator;
                    }
                } else {
                    String str = c1016a.f49094b;
                    c1016a.f49095c = str;
                    if (!str.endsWith(File.separator)) {
                        c1016a.f49095c += File.separator;
                    }
                    c1016a.f49096d = "index.js";
                }
                return c1016a;
            }
            return c();
        }

        public static C1016a c() {
            return new C1016a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1016a> f49097a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f49098b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f49097a = new ArrayList();
                bVar.f49098b = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bVar.f49097a.add(C1016a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f49097a = new ArrayList();
            bVar.f49098b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f49099a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1016a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f49097a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f49099a = new HashMap<>();
                for (C1016a c1016a : bVar.f49097a) {
                    if (c1016a != null && !TextUtils.isEmpty(c1016a.f49094b)) {
                        HashMap<String, String> hashMap = cVar.f49099a;
                        String str = c1016a.f49094b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f49099a = new HashMap<>();
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
            aVar.f49087b = b.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f49086a = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f49086a = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f49088c = b2;
            aVar.f49089d = c.b(jSONObject, b2);
            aVar.f49090e = jSONObject.optString("openDataContext");
            aVar.f49091f = new d.b.g0.g.p.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            i.o("startup").y("preload_resources", z ? "1" : "0");
            aVar.f49092g = new d.b.g0.g.w.f.a(optJSONArray);
            return aVar;
        } catch (JSONException e2) {
            if (f49085h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

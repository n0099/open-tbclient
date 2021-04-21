package d.b.h0.g.z.a;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.j1.i;
import d.b.h0.a.k;
import d.b.h0.a.r1.n.b;
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
    public static final boolean f49414h = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public int f49415a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f49416b;

    /* renamed from: c  reason: collision with root package name */
    public b f49417c;

    /* renamed from: d  reason: collision with root package name */
    public c f49418d;

    /* renamed from: e  reason: collision with root package name */
    public String f49419e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g.p.a f49420f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.g.w.f.a f49421g;

    /* renamed from: d.b.h0.g.z.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1036a {

        /* renamed from: a  reason: collision with root package name */
        public String f49422a;

        /* renamed from: b  reason: collision with root package name */
        public String f49423b;

        /* renamed from: c  reason: collision with root package name */
        public String f49424c;

        /* renamed from: d  reason: collision with root package name */
        public String f49425d;

        public static C1036a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1036a c1036a = new C1036a();
            c1036a.f49423b = jSONObject.optString("root");
            c1036a.f49422a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1036a.f49423b) && !TextUtils.isEmpty(c1036a.f49422a)) {
                if (c1036a.f49423b.endsWith(".js")) {
                    String[] split = c1036a.f49423b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1036a.f49425d = split[split.length - 1];
                    c1036a.f49424c = "";
                    for (int i = 0; i < split.length - 1; i++) {
                        c1036a.f49424c += split[i] + File.separator;
                    }
                } else {
                    String str = c1036a.f49423b;
                    c1036a.f49424c = str;
                    if (!str.endsWith(File.separator)) {
                        c1036a.f49424c += File.separator;
                    }
                    c1036a.f49425d = "index.js";
                }
                return c1036a;
            }
            return c();
        }

        public static C1036a c() {
            return new C1036a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1036a> f49426a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f49427b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f49426a = new ArrayList();
                bVar.f49427b = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bVar.f49426a.add(C1036a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f49426a = new ArrayList();
            bVar.f49427b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f49428a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1036a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f49426a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f49428a = new HashMap<>();
                for (C1036a c1036a : bVar.f49426a) {
                    if (c1036a != null && !TextUtils.isEmpty(c1036a.f49423b)) {
                        HashMap<String, String> hashMap = cVar.f49428a;
                        String str = c1036a.f49423b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f49428a = new HashMap<>();
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
            aVar.f49416b = b.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f49415a = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f49415a = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f49417c = b2;
            aVar.f49418d = c.b(jSONObject, b2);
            aVar.f49419e = jSONObject.optString("openDataContext");
            aVar.f49420f = new d.b.h0.g.p.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            i.o("startup").y("preload_resources", z ? "1" : "0");
            aVar.f49421g = new d.b.h0.g.w.f.a(optJSONArray);
            return aVar;
        } catch (JSONException e2) {
            if (f49414h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

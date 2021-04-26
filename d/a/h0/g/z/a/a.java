package d.a.h0.g.z.a;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.j1.i;
import d.a.h0.a.k;
import d.a.h0.a.r1.n.b;
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
    public static final boolean f46914h = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public int f46915a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f46916b;

    /* renamed from: c  reason: collision with root package name */
    public b f46917c;

    /* renamed from: d  reason: collision with root package name */
    public c f46918d;

    /* renamed from: e  reason: collision with root package name */
    public String f46919e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.g.p.a f46920f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.h0.g.w.f.a f46921g;

    /* renamed from: d.a.h0.g.z.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0975a {

        /* renamed from: a  reason: collision with root package name */
        public String f46922a;

        /* renamed from: b  reason: collision with root package name */
        public String f46923b;

        /* renamed from: c  reason: collision with root package name */
        public String f46924c;

        /* renamed from: d  reason: collision with root package name */
        public String f46925d;

        public static C0975a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C0975a c0975a = new C0975a();
            c0975a.f46923b = jSONObject.optString("root");
            c0975a.f46922a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c0975a.f46923b) && !TextUtils.isEmpty(c0975a.f46922a)) {
                if (c0975a.f46923b.endsWith(".js")) {
                    String[] split = c0975a.f46923b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c0975a.f46925d = split[split.length - 1];
                    c0975a.f46924c = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        c0975a.f46924c += split[i2] + File.separator;
                    }
                } else {
                    String str = c0975a.f46923b;
                    c0975a.f46924c = str;
                    if (!str.endsWith(File.separator)) {
                        c0975a.f46924c += File.separator;
                    }
                    c0975a.f46925d = "index.js";
                }
                return c0975a;
            }
            return c();
        }

        public static C0975a c() {
            return new C0975a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C0975a> f46926a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f46927b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f46926a = new ArrayList();
                bVar.f46927b = new HashMap<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bVar.f46926a.add(C0975a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f46926a = new ArrayList();
            bVar.f46927b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f46928a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C0975a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f46926a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f46928a = new HashMap<>();
                for (C0975a c0975a : bVar.f46926a) {
                    if (c0975a != null && !TextUtils.isEmpty(c0975a.f46923b)) {
                        HashMap<String, String> hashMap = cVar.f46928a;
                        String str = c0975a.f46923b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f46928a = new HashMap<>();
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
            aVar.f46916b = b.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f46915a = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f46915a = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f46917c = b2;
            aVar.f46918d = c.b(jSONObject, b2);
            aVar.f46919e = jSONObject.optString("openDataContext");
            aVar.f46920f = new d.a.h0.g.p.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            i.o("startup").y("preload_resources", z ? "1" : "0");
            aVar.f46921g = new d.a.h0.g.w.f.a(optJSONArray);
            return aVar;
        } catch (JSONException e2) {
            if (f46914h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

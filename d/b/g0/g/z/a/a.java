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
    public static final boolean f48693h = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public int f48694a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f48695b;

    /* renamed from: c  reason: collision with root package name */
    public b f48696c;

    /* renamed from: d  reason: collision with root package name */
    public c f48697d;

    /* renamed from: e  reason: collision with root package name */
    public String f48698e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.p.a f48699f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.w.f.a f48700g;

    /* renamed from: d.b.g0.g.z.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1004a {

        /* renamed from: a  reason: collision with root package name */
        public String f48701a;

        /* renamed from: b  reason: collision with root package name */
        public String f48702b;

        /* renamed from: c  reason: collision with root package name */
        public String f48703c;

        /* renamed from: d  reason: collision with root package name */
        public String f48704d;

        public static C1004a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1004a c1004a = new C1004a();
            c1004a.f48702b = jSONObject.optString("root");
            c1004a.f48701a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1004a.f48702b) && !TextUtils.isEmpty(c1004a.f48701a)) {
                if (c1004a.f48702b.endsWith(".js")) {
                    String[] split = c1004a.f48702b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1004a.f48704d = split[split.length - 1];
                    c1004a.f48703c = "";
                    for (int i = 0; i < split.length - 1; i++) {
                        c1004a.f48703c += split[i] + File.separator;
                    }
                } else {
                    String str = c1004a.f48702b;
                    c1004a.f48703c = str;
                    if (!str.endsWith(File.separator)) {
                        c1004a.f48703c += File.separator;
                    }
                    c1004a.f48704d = "index.js";
                }
                return c1004a;
            }
            return c();
        }

        public static C1004a c() {
            return new C1004a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1004a> f48705a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f48706b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f48705a = new ArrayList();
                bVar.f48706b = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bVar.f48705a.add(C1004a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f48705a = new ArrayList();
            bVar.f48706b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f48707a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1004a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f48705a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f48707a = new HashMap<>();
                for (C1004a c1004a : bVar.f48705a) {
                    if (c1004a != null && !TextUtils.isEmpty(c1004a.f48702b)) {
                        HashMap<String, String> hashMap = cVar.f48707a;
                        String str = c1004a.f48702b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f48707a = new HashMap<>();
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
            aVar.f48695b = b.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f48694a = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f48694a = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f48696c = b2;
            aVar.f48697d = c.b(jSONObject, b2);
            aVar.f48698e = jSONObject.optString("openDataContext");
            aVar.f48699f = new d.b.g0.g.p.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            i.o("startup").y("preload_resources", z ? "1" : "0");
            aVar.f48700g = new d.b.g0.g.w.f.a(optJSONArray);
            return aVar;
        } catch (JSONException e2) {
            if (f48693h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

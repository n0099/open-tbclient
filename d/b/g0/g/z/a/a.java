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
    public static final boolean f48692h = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public int f48693a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f48694b;

    /* renamed from: c  reason: collision with root package name */
    public b f48695c;

    /* renamed from: d  reason: collision with root package name */
    public c f48696d;

    /* renamed from: e  reason: collision with root package name */
    public String f48697e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.g.p.a f48698f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.g0.g.w.f.a f48699g;

    /* renamed from: d.b.g0.g.z.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1003a {

        /* renamed from: a  reason: collision with root package name */
        public String f48700a;

        /* renamed from: b  reason: collision with root package name */
        public String f48701b;

        /* renamed from: c  reason: collision with root package name */
        public String f48702c;

        /* renamed from: d  reason: collision with root package name */
        public String f48703d;

        public static C1003a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1003a c1003a = new C1003a();
            c1003a.f48701b = jSONObject.optString("root");
            c1003a.f48700a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1003a.f48701b) && !TextUtils.isEmpty(c1003a.f48700a)) {
                if (c1003a.f48701b.endsWith(".js")) {
                    String[] split = c1003a.f48701b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1003a.f48703d = split[split.length - 1];
                    c1003a.f48702c = "";
                    for (int i = 0; i < split.length - 1; i++) {
                        c1003a.f48702c += split[i] + File.separator;
                    }
                } else {
                    String str = c1003a.f48701b;
                    c1003a.f48702c = str;
                    if (!str.endsWith(File.separator)) {
                        c1003a.f48702c += File.separator;
                    }
                    c1003a.f48703d = "index.js";
                }
                return c1003a;
            }
            return c();
        }

        public static C1003a c() {
            return new C1003a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1003a> f48704a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f48705b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f48704a = new ArrayList();
                bVar.f48705b = new HashMap<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bVar.f48704a.add(C1003a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f48704a = new ArrayList();
            bVar.f48705b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f48706a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1003a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f48704a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f48706a = new HashMap<>();
                for (C1003a c1003a : bVar.f48704a) {
                    if (c1003a != null && !TextUtils.isEmpty(c1003a.f48701b)) {
                        HashMap<String, String> hashMap = cVar.f48706a;
                        String str = c1003a.f48701b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f48706a = new HashMap<>();
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
            aVar.f48694b = b.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f48693a = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f48693a = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f48695c = b2;
            aVar.f48696d = c.b(jSONObject, b2);
            aVar.f48697e = jSONObject.optString("openDataContext");
            aVar.f48698f = new d.b.g0.g.p.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            i.o("startup").y("preload_resources", z ? "1" : "0");
            aVar.f48699g = new d.b.g0.g.w.f.a(optJSONArray);
            return aVar;
        } catch (JSONException e2) {
            if (f48692h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

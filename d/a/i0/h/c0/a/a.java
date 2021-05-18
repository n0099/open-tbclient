package d.a.i0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.webkit.internal.CfgFileUtils;
import d.a.i0.a.a2.n.c;
import d.a.i0.a.k;
import d.a.i0.a.r1.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a extends d.a.i0.a.a2.n.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f47080h = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public int f47081b;

    /* renamed from: c  reason: collision with root package name */
    public b f47082c;

    /* renamed from: d  reason: collision with root package name */
    public c f47083d;

    /* renamed from: e  reason: collision with root package name */
    public String f47084e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.h.r.a f47085f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.h.y.e.a f47086g;

    /* renamed from: d.a.i0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1007a {

        /* renamed from: a  reason: collision with root package name */
        public String f47087a;

        /* renamed from: b  reason: collision with root package name */
        public String f47088b;

        /* renamed from: c  reason: collision with root package name */
        public String f47089c;

        /* renamed from: d  reason: collision with root package name */
        public String f47090d;

        public static C1007a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1007a c1007a = new C1007a();
            c1007a.f47088b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
            c1007a.f47087a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1007a.f47088b) && !TextUtils.isEmpty(c1007a.f47087a)) {
                if (c1007a.f47088b.endsWith(".js")) {
                    String[] split = c1007a.f47088b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1007a.f47090d = split[split.length - 1];
                    c1007a.f47089c = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        c1007a.f47089c += split[i2] + File.separator;
                    }
                } else {
                    String str = c1007a.f47088b;
                    c1007a.f47089c = str;
                    if (!str.endsWith(File.separator)) {
                        c1007a.f47089c += File.separator;
                    }
                    c1007a.f47090d = "index.js";
                }
                return c1007a;
            }
            return c();
        }

        public static C1007a c() {
            return new C1007a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1007a> f47091a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f47092b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f47091a = new ArrayList();
                bVar.f47092b = new HashMap<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bVar.f47091a.add(C1007a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f47091a = new ArrayList();
            bVar.f47092b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f47093a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1007a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f47091a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f47093a = new HashMap<>();
                for (C1007a c1007a : bVar.f47091a) {
                    if (c1007a != null && !TextUtils.isEmpty(c1007a.f47088b)) {
                        HashMap<String, String> hashMap = cVar.f47093a;
                        String str = c1007a.f47088b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f47093a = new HashMap<>();
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
            aVar.f40605a = c.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f47081b = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f47081b = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f47082c = b2;
            aVar.f47083d = c.b(jSONObject, b2);
            aVar.f47084e = jSONObject.optString("openDataContext");
            aVar.f47085f = new d.a.i0.h.r.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            h.p("startup").A("preload_resources", z ? "1" : "0");
            aVar.f47086g = new d.a.i0.h.y.e.a(optJSONArray);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject != null) {
                optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            }
            return aVar;
        } catch (JSONException e2) {
            if (f47080h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

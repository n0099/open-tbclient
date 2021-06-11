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
    public static final boolean f50930h = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public int f50931b;

    /* renamed from: c  reason: collision with root package name */
    public b f50932c;

    /* renamed from: d  reason: collision with root package name */
    public c f50933d;

    /* renamed from: e  reason: collision with root package name */
    public String f50934e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.h.r.a f50935f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.l0.h.y.e.a f50936g;

    /* renamed from: d.a.l0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1074a {

        /* renamed from: a  reason: collision with root package name */
        public String f50937a;

        /* renamed from: b  reason: collision with root package name */
        public String f50938b;

        /* renamed from: c  reason: collision with root package name */
        public String f50939c;

        /* renamed from: d  reason: collision with root package name */
        public String f50940d;

        public static C1074a b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            C1074a c1074a = new C1074a();
            c1074a.f50938b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
            c1074a.f50937a = jSONObject.optString("name");
            if (!TextUtils.isEmpty(c1074a.f50938b) && !TextUtils.isEmpty(c1074a.f50937a)) {
                if (c1074a.f50938b.endsWith(".js")) {
                    String[] split = c1074a.f50938b.split(File.separator);
                    if (split.length < 1) {
                        return c();
                    }
                    c1074a.f50940d = split[split.length - 1];
                    c1074a.f50939c = "";
                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                        c1074a.f50939c += split[i2] + File.separator;
                    }
                } else {
                    String str = c1074a.f50938b;
                    c1074a.f50939c = str;
                    if (!str.endsWith(File.separator)) {
                        c1074a.f50939c += File.separator;
                    }
                    c1074a.f50940d = "index.js";
                }
                return c1074a;
            }
            return c();
        }

        public static C1074a c() {
            return new C1074a();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<C1074a> f50941a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f50942b;

        public static b b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return c();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                b bVar = new b();
                bVar.f50941a = new ArrayList();
                bVar.f50942b = new HashMap<>();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        bVar.f50941a.add(C1074a.b(optJSONObject));
                    }
                }
                return bVar;
            }
            return c();
        }

        public static b c() {
            b bVar = new b();
            bVar.f50941a = new ArrayList();
            bVar.f50942b = new HashMap<>();
            return bVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f50943a;

        public static c b(JSONObject jSONObject, b bVar) {
            List<C1074a> list;
            if (jSONObject != null && bVar != null && (list = bVar.f50941a) != null && list.size() > 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                if (optJSONObject == null) {
                    return c();
                }
                c cVar = new c();
                cVar.f50943a = new HashMap<>();
                for (C1074a c1074a : bVar.f50941a) {
                    if (c1074a != null && !TextUtils.isEmpty(c1074a.f50938b)) {
                        HashMap<String, String> hashMap = cVar.f50943a;
                        String str = c1074a.f50938b;
                        hashMap.put(str, optJSONObject.optString(str));
                    }
                }
                return cVar;
            }
            return c();
        }

        public static c c() {
            c cVar = new c();
            cVar.f50943a = new HashMap<>();
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
            aVar.f44455a = c.a.a(jSONObject);
            String optString = jSONObject.optString("deviceOrientation", "portrait");
            boolean z = false;
            aVar.f50931b = 0;
            if (TextUtils.equals(optString, "landscape")) {
                aVar.f50931b = 1;
            }
            jSONObject.optBoolean("showStatusBar", false);
            jSONObject.optString("workers");
            b b2 = b.b(jSONObject);
            aVar.f50932c = b2;
            aVar.f50933d = c.b(jSONObject, b2);
            aVar.f50934e = jSONObject.optString("openDataContext");
            aVar.f50935f = new d.a.l0.h.r.a(jSONObject);
            JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z = true;
            }
            h.p("startup").A("preload_resources", z ? "1" : "0");
            aVar.f50936g = new d.a.l0.h.y.e.a(optJSONArray);
            JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
            if (optJSONObject != null) {
                optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
            }
            return aVar;
        } catch (JSONException e2) {
            if (f50930h) {
                Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
            }
            return null;
        }
    }
}

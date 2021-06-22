package d.a.m0.a.c2.f.g0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.e;
import d.a.m0.a.h0.g.g;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: d  reason: collision with root package name */
    public static String f44817d = "SwanAppPageForbidden";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44818e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f44819a;

    /* renamed from: b  reason: collision with root package name */
    public List<JSONObject> f44820b;

    /* renamed from: c  reason: collision with root package name */
    public String f44821c;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f44822e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44823f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f44824g;

        public a(d dVar, g gVar, String str, e eVar) {
            this.f44822e = gVar;
            this.f44823f = str;
            this.f44824g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.b i2 = this.f44822e.i(this.f44823f);
            i2.n(g.f45860g, g.f45862i);
            i2.j(this.f44824g);
            i2.b();
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f44825a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        return b.f44825a;
    }

    public boolean a(d.a.m0.a.l1.b bVar) {
        if (bVar != null && d.a.m0.a.v.a.e(d.a.m0.a.a2.d.g().r().N())) {
            if (!this.f44819a) {
                j();
            }
            List<JSONObject> list = this.f44820b;
            if (list == null || list.isEmpty()) {
                return false;
            }
            if (f44818e) {
                Log.d(f44817d, "ForbiddenPage Check");
            }
            return g(bVar);
        }
        return false;
    }

    public final String c(String str) {
        return str + "_forbidden_ban_page";
    }

    public String d() {
        return this.f44821c;
    }

    public final String e(String str) {
        return str + "_forbidden_tips";
    }

    public final boolean f(String[] strArr, List<String> list) {
        if (list == null || list.isEmpty() || strArr == null || strArr.length == 0) {
            return false;
        }
        List asList = Arrays.asList(strArr);
        if (asList.isEmpty()) {
            return false;
        }
        for (String str : list) {
            if (!asList.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public boolean g(d.a.m0.a.l1.b bVar) {
        if (bVar == null) {
            return false;
        }
        String str = bVar.f47141e;
        String str2 = bVar.f47144h;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            List<JSONObject> list = this.f44820b;
            if (list == null) {
                return false;
            }
            for (JSONObject jSONObject : list) {
                if (jSONObject != null && !jSONObject.isNull("type") && !jSONObject.isNull("path")) {
                    int optInt = jSONObject.optInt("type");
                    String optString = jSONObject.optString("path");
                    if (TextUtils.equals(str, optString) || TextUtils.equals(str2, optString)) {
                        if (optInt == 1) {
                            return true;
                        }
                        if (optInt != 2) {
                            if (optInt == 3 && !jSONObject.isNull("query")) {
                                String optString2 = jSONObject.optString("query");
                                if (TextUtils.isEmpty(bVar.f47142f)) {
                                    return false;
                                }
                                List<String> c2 = o0.c(optString2);
                                String[] split = bVar.f47142f.split("&");
                                if (split == null || split.length == 0 || c2 == null || c2.isEmpty()) {
                                    return false;
                                }
                                if (f(split, c2)) {
                                    return true;
                                }
                            }
                        } else if (jSONObject.isNull("query")) {
                            continue;
                        } else {
                            String optString3 = jSONObject.optString("query");
                            if (TextUtils.isEmpty(bVar.f47142f)) {
                                return false;
                            }
                            List<String> c3 = o0.c(optString3);
                            String[] split2 = bVar.f47142f.split("&");
                            if (split2 == null || split2.length == 0 || c3 == null || c3.isEmpty() || split2.length != c3.size()) {
                                return false;
                            }
                            if (f(split2, c3)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean h(d.a.m0.a.l1.b bVar) {
        List<JSONObject> list;
        if (bVar == null) {
            return false;
        }
        String str = bVar.f47144h;
        if (TextUtils.isEmpty(str) || (list = this.f44820b) == null) {
            return false;
        }
        for (JSONObject jSONObject : list) {
            if (jSONObject != null && TextUtils.equals(str, jSONObject.optString("path"))) {
                return true;
            }
        }
        return false;
    }

    public void i(String str, d.a.m0.a.l1.b bVar) {
        g W;
        String c2;
        if (bVar == null || (W = f.V().W()) == null || (W.m() instanceof e)) {
            return;
        }
        if (h(bVar)) {
            c2 = d.a.m0.a.l1.b.d(bVar);
        } else {
            c2 = d.a.m0.a.l1.b.c(bVar);
        }
        if (f44818e) {
            String str2 = f44817d;
            Log.d(str2, "jump from " + str + " ; path = " + c2);
        }
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        b.a L = r.L();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = r.getAppId();
        forbiddenInfo.appKey = r.D();
        forbiddenInfo.appTitle = L.K();
        forbiddenInfo.forbiddenReason = d();
        forbiddenInfo.forbiddenInformation = this.f44821c;
        forbiddenInfo.launchSource = L.T();
        forbiddenInfo.launchPath = c2;
        forbiddenInfo.enableSlidingFlag = 0;
        l(forbiddenInfo);
        q0.b0(new a(this, W, str, e.R2(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, forbiddenInfo, 0, 0)));
    }

    public void j() {
        d.a.m0.a.k2.g.b a2 = h.a();
        String D = d.a.m0.a.a2.d.g().r().D();
        if (a2 == null) {
            return;
        }
        String string = a2.getString(c(D), null);
        if (f44818e) {
            String str = f44817d;
            Log.d(str, "readData, appKey = " + D + " ; tips = " + this.f44821c + " ; page = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.f44820b = null;
        } else {
            JSONArray e2 = w.e(string);
            if (e2 == null) {
                return;
            }
            int length = e2.length();
            this.f44820b = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = e2.optJSONObject(i2);
                if (optJSONObject != null) {
                    this.f44820b.add(optJSONObject);
                }
            }
            this.f44821c = a2.getString(e(D), null);
        }
        this.f44819a = true;
    }

    public void k() {
        if (f44818e) {
            Log.d(f44817d, "releaseData");
        }
        this.f44819a = false;
        this.f44821c = null;
        List<JSONObject> list = this.f44820b;
        if (list != null) {
            list.clear();
            this.f44820b = null;
        }
    }

    public final void l(ForbiddenInfo forbiddenInfo) {
        d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
        if (Q == null) {
            return;
        }
        Q.r();
        SwanAppActivity x = Q.x();
        if (x == null) {
            return;
        }
        String i2 = d.a.m0.a.m2.b.i(f.V().N(), Q.N().G());
        d.a.m0.a.q2.a aVar = new d.a.m0.a.q2.a();
        aVar.j(10L);
        aVar.h(48L);
        aVar.c("page forbidden");
        forbiddenInfo.forbiddenDetail = x.getString(d.a.m0.a.h.aiapps_open_failed_detail_format, q0.D(), i2, String.valueOf(aVar.a()));
    }

    public void m(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("ai_apps_key", str);
        d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
        d.a.m0.a.v1.c.c cVar = new d.a.m0.a.v1.c.c(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, bundle);
        cVar.d();
        e2.h(cVar);
    }

    public void n(JSONArray jSONArray, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String c2 = c(str2);
        String e2 = e(str2);
        if (jSONArray != null && jSONArray.length() != 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            String jSONArray2 = jSONArray.toString();
            if (optJSONObject != null) {
                h.a().edit().putString(c2, jSONArray2).putString(e2, str).apply();
                if (f44818e) {
                    String str3 = f44817d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        h.a().edit().remove(c2).remove(e2).apply();
        if (f44818e) {
            String str4 = f44817d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }

    public d() {
        this.f44819a = false;
    }
}

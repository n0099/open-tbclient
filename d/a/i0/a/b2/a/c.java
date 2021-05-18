package d.a.i0.a.b2.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import d.a.i0.a.v2.w;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f40641a = k.f43025a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f40642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40643f;

        public a(d dVar, String str) {
            this.f40642e = dVar;
            this.f40643f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "async read webDomains");
            c.o(this.f40642e, this.f40643f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f40644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f40646g;

        public b(d dVar, String str, String str2) {
            this.f40644e = dVar;
            this.f40645f = str;
            this.f40646g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "async read serverDomains");
            c.p(this.f40644e, this.f40645f, this.f40646g);
        }
    }

    /* renamed from: d.a.i0.a.b2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0557c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f40647e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40648f;

        public RunnableC0557c(d dVar, String str) {
            this.f40647e = dVar;
            this.f40648f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "async read webActions");
            c.o(this.f40647e, this.f40648f);
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f40649a;

        /* renamed from: b  reason: collision with root package name */
        public List<String> f40650b = new CopyOnWriteArrayList();

        /* renamed from: c  reason: collision with root package name */
        public long f40651c;

        @NonNull
        public static List<String> d(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    arrayList.add(jSONArray.optString(i2));
                }
            }
            return arrayList;
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f40649a = jSONObject.optString("token");
            this.f40650b.addAll(d(jSONObject.optJSONArray("data")));
        }

        public void b(JSONObject jSONObject, String str) {
            JSONObject optJSONObject;
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.f40650b.addAll(d(optJSONObject.optJSONArray(str)));
        }

        public void c() {
            this.f40650b.clear();
        }

        public String toString() {
            return "WebSafeData{token='" + this.f40649a + "', data=" + this.f40650b + ", lastModifiedTime=" + this.f40651c + '}';
        }
    }

    @NonNull
    public static String c(String str, String str2, String str3) {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (TextUtils.isEmpty(str)) {
            return path + File.separator + str2 + File.separator + str3;
        }
        return path + File.separator + str2 + File.separator + str + "_" + str3;
    }

    public static List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("swanAPI/installApp4Ad");
        arrayList.add("swanAPI/openApp4Ad");
        arrayList.add("swanAPI/checkAppInstalled");
        return arrayList;
    }

    public static String e() {
        return AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/cloud_config";
    }

    @NonNull
    public static d.a.i0.t.b f(@NonNull String str) {
        return h.b(str + "_domain_config");
    }

    @Nullable
    public static Set<String> g(@NonNull String str) {
        return f(str).getStringSet("prelink", null);
    }

    public static void h(boolean z, String str, String str2, @NonNull d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (f40641a) {
                Log.w("WebSafeWhiteListMgr", "get serverDomains: appId is empty");
            }
        } else if (dVar == null) {
            if (f40641a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
        } else {
            String i2 = i(str);
            if (z) {
                ExecutorUtilsExt.postOnElastic(new b(dVar, i2, str2), "load-ServerDomains", 2);
            } else {
                p(dVar, i2, str2);
            }
        }
    }

    @NonNull
    public static String i(@NonNull String str) {
        return c(str, "aiapps_folder/cloud_config", "server_domains.json");
    }

    @NonNull
    public static String j() {
        return c("", "aiapps_folder/cloud_config", "global_web_actions.json");
    }

    public static void k(boolean z, @NonNull d dVar) {
        if (dVar == null) {
            if (f40641a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        String j = j();
        if (z) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0557c(dVar, j), "load-WebActions", 2);
        } else {
            o(dVar, j);
        }
    }

    public static void l(boolean z, String str, @NonNull d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (f40641a) {
                Log.w("WebSafeWhiteListMgr", "getWebDomains: appId is empty");
            }
        } else if (dVar == null) {
            if (f40641a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
        } else {
            String m = m(str);
            if (z) {
                ExecutorUtilsExt.postOnElastic(new a(dVar, m), "load-WebDomains", 2);
            } else {
                o(dVar, m);
            }
        }
    }

    @NonNull
    public static String m(@NonNull String str) {
        return c(str, "aiapps_folder/cloud_config", "web_domains.json");
    }

    public static boolean n(String str) {
        return new File(m(str)).exists();
    }

    public static void o(@NonNull d dVar, String str) {
        if (dVar == null) {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "webSafeData == null");
            return;
        }
        d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(before): " + dVar);
        try {
            dVar.a(new JSONObject(q(str)));
            v(dVar, str);
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(after): " + dVar);
        } catch (Exception e2) {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
        }
    }

    public static void p(d dVar, String str, String str2) {
        if (dVar == null) {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "webSafeData == null");
            return;
        }
        d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(before): " + dVar);
        try {
            dVar.b(new JSONObject(q(str)), str2);
            v(dVar, str);
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "update webSafeData(after): " + dVar);
        } catch (Exception e2) {
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
        }
    }

    public static String q(String str) {
        d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "read data from: " + str);
        return d.a.i0.a.b1.a.a(str);
    }

    public static void r(@NonNull String str, @NonNull String str2) {
        JSONArray optJSONArray = w.d(str2).optJSONArray("prelink");
        if (optJSONArray != null) {
            ArraySet arraySet = new ArraySet();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String optString = optJSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    arraySet.add(optString);
                }
            }
            w(str, arraySet);
        }
        if (f40641a) {
            Log.d("WebSafeWhiteListMgr", "saveDomainConfig appId=" + str + ", domainConfig=" + str2);
        }
    }

    public static boolean s(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONObject);
                String i2 = i(str);
                boolean b2 = d.a.i0.a.b1.a.b(i2, jSONObject2.toString(), false);
                d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "save serverDomains: result=" + b2 + " filePath=" + i2 + " appId= " + str + " data=" + jSONObject);
                return b2;
            } catch (JSONException e2) {
                if (f40641a) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
                }
                return false;
            }
        }
        if (f40641a) {
            Log.d("WebSafeWhiteListMgr", "save serverDomains: appId or data is empty");
        }
        return false;
    }

    public static boolean t(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            if (f40641a) {
                Log.w("WebSafeWhiteListMgr", "saveWebActions: data is empty");
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("token", str);
            }
            jSONObject.put("data", jSONArray);
            String j = j();
            boolean b2 = d.a.i0.a.b1.a.b(j, jSONObject.toString(), false);
            d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "save webActions: result=" + b2 + " filePath=" + j + " token=" + str + " data=" + jSONArray);
            return b2;
        } catch (JSONException e2) {
            if (f40641a) {
                Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
            }
            return false;
        }
    }

    public static boolean u(String str, String str2, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && jSONArray != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("token", str2);
                }
                jSONObject.put("data", jSONArray);
                String m = m(str);
                boolean b2 = d.a.i0.a.b1.a.b(m, jSONObject.toString(), false);
                d.a.i0.a.e0.d.h("WebSafeWhiteListMgr", "save WebDomains: result=" + b2 + " filePath=" + m + " appId= " + str + " token=" + str2 + " data=" + jSONArray);
                return b2;
            } catch (JSONException e2) {
                if (f40641a) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
                }
                return false;
            }
        }
        if (f40641a) {
            Log.w("WebSafeWhiteListMgr", "saveWebDomains: appId or data is empty");
        }
        return false;
    }

    public static void v(@NonNull d dVar, String str) {
        File file = new File(str);
        if (file.exists()) {
            dVar.f40651c = file.lastModified();
        }
    }

    public static void w(@NonNull String str, @Nullable Set<String> set) {
        if (set != null) {
            ArrayList arrayList = new ArrayList(set.size());
            ArraySet arraySet = new ArraySet(set.size());
            for (String str2 : set) {
                String e2 = d.a.i0.a.u.e.j.h.e(str2);
                if (e2 != null && !arrayList.contains(e2)) {
                    arraySet.add(str2);
                    arrayList.add(e2);
                }
            }
            set = arraySet;
        }
        f(str).putStringSet("prelink", set);
    }
}

package d.b.g0.a.s1.a;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.b.g0.a.k;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45908a = k.f45050a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45909e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f45910f;

        public a(String str, d dVar) {
            this.f45909e = str;
            this.f45910f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f45908a) {
                Log.d("WebSafeWhiteListMgr", "read webdomains from file async");
            }
            c.k(this.f45910f, c.j(this.f45909e));
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45911e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f45912f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45913g;

        public b(String str, d dVar, String str2) {
            this.f45911e = str;
            this.f45912f = dVar;
            this.f45913g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f45908a) {
                Log.d("WebSafeWhiteListMgr", "read serverDomains from file async");
            }
            c.l(this.f45912f, c.j(this.f45911e), this.f45913g);
        }
    }

    /* renamed from: d.b.g0.a.s1.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0793c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f45915f;

        public RunnableC0793c(String str, d dVar) {
            this.f45914e = str;
            this.f45915f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.f45908a) {
                Log.d("WebSafeWhiteListMgr", "read web actions from file async");
            }
            c.k(this.f45915f, c.j(this.f45914e));
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f45916a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f45917b = new ArrayList<>();

        public void a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f45916a = jSONObject.optString("token");
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    this.f45917b.add((String) optJSONArray.get(i));
                } catch (JSONException e2) {
                    if (c.f45908a) {
                        Log.w("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
                    }
                }
            }
        }

        public void b(JSONObject jSONObject, String str) {
            JSONArray optJSONArray;
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONObject("data").optJSONArray(str)) == null || optJSONArray.length() <= 0) {
                return;
            }
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    this.f45917b.add((String) optJSONArray.get(i));
                } catch (JSONException e2) {
                    if (c.f45908a) {
                        Log.w("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
                    }
                }
            }
        }
    }

    public static String d(String str, String str2, String str3) {
        String path = AppRuntime.getAppContext().getFilesDir().getPath();
        if (TextUtils.isEmpty(str)) {
            return path + File.separator + str2 + File.separator + str3;
        }
        return path + File.separator + str2 + File.separator + str + "_" + str3;
    }

    public static void e(d dVar) {
        if (dVar == null) {
            if (f45908a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("swanAPI/installApp4Ad");
        arrayList.add("swanAPI/openApp4Ad");
        arrayList.add("swanAPI/checkAppInstalled");
        dVar.f45917b = arrayList;
    }

    public static void f(boolean z, String str, String str2, @NonNull d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (f45908a) {
                Log.w("WebSafeWhiteListMgr", "get serverDomains: appId is empty");
            }
        } else if (dVar == null) {
            if (f45908a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
        } else {
            String d2 = d(str, "aiapps_folder/cloud_config", "server_domains.json");
            if (z) {
                ExecutorUtilsExt.postOnElastic(new b(d2, dVar, str2), "load-ServerDomains", 2);
            } else {
                l(dVar, j(d2), str2);
            }
        }
    }

    public static void g(boolean z, @NonNull d dVar) {
        if (dVar == null) {
            if (f45908a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        String d2 = d("", "aiapps_folder/cloud_config", "global_web_actions.json");
        if (z) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0793c(d2, dVar), "load-WebActions", 2);
        } else {
            k(dVar, j(d2));
        }
    }

    public static void h(boolean z, String str, @NonNull d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (f45908a) {
                Log.w("WebSafeWhiteListMgr", "getWebDomains: appId is empty");
            }
        } else if (dVar == null) {
            if (f45908a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
        } else {
            String d2 = d(str, "aiapps_folder/cloud_config", "web_domains.json");
            if (z) {
                ExecutorUtilsExt.postOnElastic(new a(d2, dVar), "load-WebDomains", 2);
            } else {
                k(dVar, j(d2));
            }
        }
    }

    public static boolean i(String str) {
        return new File(d(str, "aiapps_folder/cloud_config", "web_domains.json")).exists();
    }

    public static String j(String str) {
        if (f45908a) {
            Log.d("WebSafeWhiteListMgr", "the request webSafeData file path:" + str);
        }
        return d.b.g0.a.v0.a.a(str);
    }

    public static void k(d dVar, String str) {
        if (dVar == null) {
            if (f45908a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        try {
            dVar.a(new JSONObject(str));
            if (f45908a) {
                Log.e("WebSafeWhiteListMgr", "read WebSafeData by loading file: token=" + dVar.f45916a + ", data=" + dVar.f45917b);
            }
        } catch (JSONException e2) {
            if (f45908a) {
                Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
            }
        }
    }

    public static void l(d dVar, String str, String str2) {
        if (dVar == null) {
            if (f45908a) {
                throw new RuntimeException("Please init webSafeData first!");
            }
            return;
        }
        try {
            dVar.b(new JSONObject(str), str2);
            if (f45908a) {
                Log.e("WebSafeWhiteListMgr", "read WebSafeData by loading file:token=" + dVar.f45916a + ", data=" + dVar.f45917b);
            }
        } catch (JSONException e2) {
            if (f45908a) {
                Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
            }
        }
    }

    public static boolean m(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            String d2 = d(str, "aiapps_folder/cloud_config", "server_domains.json");
            if (f45908a) {
                Log.d("WebSafeWhiteListMgr", "serverDomains file path: " + d2);
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONObject);
                boolean b2 = d.b.g0.a.v0.a.b(d2, jSONObject2.toString(), false);
                if (f45908a) {
                    Log.d("WebSafeWhiteListMgr", "save Server Domains done: data = " + jSONObject);
                }
                return b2;
            } catch (JSONException e2) {
                if (f45908a) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
                }
                return false;
            }
        }
        if (f45908a) {
            Log.d("WebSafeWhiteListMgr", "save serverDomains: appId or data is empty");
        }
        return false;
    }

    public static boolean n(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            if (f45908a) {
                Log.w("WebSafeWhiteListMgr", "saveWebActions: data is empty");
            }
            return false;
        }
        String d2 = d("", "aiapps_folder/cloud_config", "global_web_actions.json");
        if (f45908a) {
            Log.d("WebSafeWhiteListMgr", "WebActions file path: " + d2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("token", str);
            }
            jSONObject.put("data", jSONArray);
            boolean b2 = d.b.g0.a.v0.a.b(d2, jSONObject.toString(), false);
            if (f45908a) {
                Log.d("WebSafeWhiteListMgr", "save WebActions done: token=" + str + ", data=" + jSONArray);
            }
            return b2;
        } catch (JSONException e2) {
            if (f45908a) {
                Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
            }
            return false;
        }
    }

    public static boolean o(String str, String str2, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && jSONArray != null) {
            String d2 = d(str, "aiapps_folder/cloud_config", "web_domains.json");
            if (f45908a) {
                Log.d("WebSafeWhiteListMgr", "WebDomains file path: " + d2);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("token", str2);
                }
                jSONObject.put("data", jSONArray);
                boolean b2 = d.b.g0.a.v0.a.b(d2, jSONObject.toString(), false);
                if (f45908a) {
                    Log.d("WebSafeWhiteListMgr", "save WebDomains done: appId= " + str + ", token=" + str2 + ", data=" + jSONArray);
                }
                return b2;
            } catch (JSONException e2) {
                if (f45908a) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e2));
                }
                return false;
            }
        }
        if (f45908a) {
            Log.w("WebSafeWhiteListMgr", "saveWebDomains: appId or data is empty");
        }
        return false;
    }
}

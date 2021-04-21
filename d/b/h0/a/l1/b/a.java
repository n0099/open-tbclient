package d.b.h0.a.l1.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.b.h0.a.k;
import d.b.h0.l.c;
import d.b.h0.l.k.h;
import d.b.h0.l.l.k.d;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45894a = k.f45772a;

    /* renamed from: d.b.h0.a.l1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0760a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.l1.f.a f45895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45896f;

        public RunnableC0760a(d.b.h0.a.l1.f.a aVar, boolean z) {
            this.f45895e = aVar;
            this.f45896f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.b(this.f45895e, this.f45896f);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d.b.h0.a.e0.n.b<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f45897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45898b;

        public b(boolean z, String str) {
            this.f45897a = z;
            this.f45898b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.e0.n.b
        /* renamed from: b */
        public void a(Boolean bool) {
            d.b.h0.a.l1.d.a.a("download plugin result = " + bool);
            if (this.f45897a) {
                d.b.h0.a.l1.e.a.a(this.f45898b, 2);
            }
        }
    }

    public static void b(d.b.h0.a.l1.f.a aVar, boolean z) {
        if (aVar != null && aVar.b()) {
            String str = aVar.f45946g;
            String str2 = aVar.f45945f;
            h p = d.b.h0.l.i.a.h().p(str, str2);
            if (p != null && !p.c()) {
                d.b.h0.a.l1.d.a.a("plugin is new, not yet expired");
                return;
            } else {
                c.c(new d(str, str2, aVar.f45947h), new d.b.h0.a.l1.a.a(str, str2, new b(z, str)));
                return;
            }
        }
        d.b.h0.a.l1.d.a.a("plugin is invalid");
    }

    public static long c(File file, String str) {
        String[] list;
        long j;
        if (file == null || TextUtils.isEmpty(str) || (list = file.list()) == null || list.length == 0) {
            return -1L;
        }
        long j2 = -1;
        for (String str2 : list) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException e2) {
                    d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
                    j = -1;
                }
                h p = d.b.h0.l.i.a.h().p(str, d.b.h0.a.b2.b.q(j));
                if (j > j2) {
                    if (p != null) {
                        j2 = j;
                    } else {
                        d.b.h0.a.l1.d.a.a(Log.getStackTraceString(new RuntimeException("get latest plugin version, but it hasn't insert the db yet")));
                    }
                }
            }
        }
        return j2;
    }

    public static boolean d(String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        int length;
        if (!TextUtils.isEmpty(str) && str.startsWith("__dynamicLib__")) {
            String[] split = str.split("/");
            if (split.length < 2) {
                return false;
            }
            String str2 = split[1];
            int indexOf = str.indexOf(str2) + str2.length() + 1;
            if (indexOf >= str.length()) {
                return false;
            }
            String substring = str.substring(indexOf);
            String h2 = d.b.h0.a.l1.g.b.h("dynamicLibConfig", null);
            if (TextUtils.isEmpty(h2)) {
                return false;
            }
            try {
                optJSONObject = new JSONObject(h2).optJSONObject(str2);
            } catch (JSONException e2) {
                d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
            }
            if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject("config")) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    if (TextUtils.equals(substring, optJSONArray.optString(i))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static String e(SwanAppConfigData swanAppConfigData, boolean z) {
        String str;
        if (swanAppConfigData == null) {
            d.b.h0.a.l1.d.a.a("parse app.json is null");
            return null;
        }
        List<d.b.h0.a.l1.f.a> h2 = swanAppConfigData.h(3);
        if (h2 != null && !h2.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            for (d.b.h0.a.l1.f.a aVar : h2) {
                if (aVar != null && aVar.b()) {
                    String str2 = aVar.f45946g;
                    long c2 = c(d.b.h0.a.u0.d.k(str2), str2);
                    int i = (c2 > d.b.h0.a.b2.b.h(aVar.f45945f) ? 1 : (c2 == d.b.h0.a.b2.b.h(aVar.f45945f) ? 0 : -1));
                    File l = i > 0 ? d.b.h0.a.u0.d.l(str2, String.valueOf(c2)) : null;
                    if (l == null) {
                        try {
                            str = aVar.i;
                            d.b.h0.a.l1.d.a.a("apply path inner swan app, name = " + str2);
                        } catch (JSONException e2) {
                            d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
                        }
                    } else {
                        str = l.getAbsolutePath();
                        d.b.h0.a.l1.d.a.a("apply path in workspace, name = " + str2);
                    }
                    jSONObject.put(str2, str);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.j)) {
                        File file = new File(str, aVar.j);
                        if (file.exists()) {
                            String r = d.b.h0.p.d.r(file);
                            d.b.h0.a.l1.d.a.a("pages info = " + r);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("config", new JSONObject(r));
                            jSONObject2.put(str2, jSONObject3);
                        }
                    }
                    if (i > 0) {
                        try {
                            aVar = (d.b.h0.a.l1.f.a) aVar.clone();
                        } catch (CloneNotSupportedException e3) {
                            d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e3));
                        }
                        aVar.f45945f = d.b.h0.a.b2.b.q(c2);
                    }
                    if (z) {
                        g(aVar, true);
                    }
                }
            }
            String jSONObject4 = jSONObject.toString();
            String jSONObject5 = jSONObject2.toString();
            d.b.h0.a.l1.g.b.c("dynamicLibPath", jSONObject4);
            d.b.h0.a.l1.g.b.c("dynamicLibConfig", jSONObject5);
            return jSONObject4;
        }
        d.b.h0.a.l1.g.b.c("dynamicLibPath", null);
        d.b.h0.a.l1.g.b.c("dynamicLibConfig", null);
        d.b.h0.a.l1.d.a.a("this swan app not apply on someone dynamic lib");
        return null;
    }

    public static String f(SwanAppConfigData swanAppConfigData, boolean z) {
        String str;
        if (swanAppConfigData == null) {
            if (f45894a) {
                d.b.h0.a.l1.d.a.a("parse app.json is null");
            }
            return null;
        }
        List<d.b.h0.a.l1.f.a> h2 = swanAppConfigData.h(3);
        if (h2 != null && !h2.isEmpty()) {
            String h3 = d.b.h0.a.l1.g.b.h("dynamicLibPath", null);
            if (TextUtils.isEmpty(h3)) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (d.b.h0.a.l1.f.a aVar : h2) {
                    if (aVar != null && aVar.b()) {
                        String str2 = aVar.f45946g;
                        long c2 = c(d.b.h0.a.u0.d.k(str2), str2);
                        int i = (c2 > d.b.h0.a.b2.b.h(aVar.f45945f) ? 1 : (c2 == d.b.h0.a.b2.b.h(aVar.f45945f) ? 0 : -1));
                        File l = i > 0 ? d.b.h0.a.u0.d.l(str2, String.valueOf(c2)) : null;
                        if (l == null) {
                            try {
                                str = aVar.i;
                                if (f45894a) {
                                    d.b.h0.a.l1.d.a.a("apply path inner swan app, name = " + str2);
                                }
                            } catch (JSONException e2) {
                                if (f45894a) {
                                    d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e2));
                                }
                            }
                        } else {
                            str = l.getAbsolutePath();
                            if (f45894a) {
                                d.b.h0.a.l1.d.a.a("apply path in workspace, name = " + str2);
                            }
                        }
                        jSONObject.put(str2, str);
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(aVar.j)) {
                            File file = new File(str, aVar.j);
                            if (file.exists()) {
                                String r = d.b.h0.p.d.r(file);
                                if (f45894a) {
                                    d.b.h0.a.l1.d.a.a("pages info = " + r);
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("config", new JSONObject(r));
                                jSONObject2.put(str2, jSONObject3);
                            }
                        }
                        if (i > 0) {
                            try {
                                aVar = (d.b.h0.a.l1.f.a) aVar.clone();
                            } catch (CloneNotSupportedException e3) {
                                if (f45894a) {
                                    d.b.h0.a.l1.d.a.a(Log.getStackTraceString(e3));
                                }
                            }
                            aVar.f45945f = d.b.h0.a.b2.b.q(c2);
                        }
                        if (z) {
                            g(aVar, true);
                        }
                    }
                }
                String jSONObject4 = jSONObject.toString();
                String jSONObject5 = jSONObject2.toString();
                d.b.h0.a.l1.g.b.c("dynamicLibPath", jSONObject4);
                d.b.h0.a.l1.g.b.c("dynamicLibConfig", jSONObject5);
                return jSONObject4;
            }
            return h3;
        }
        if (f45894a) {
            d.b.h0.a.l1.d.a.a("this swan app not apply on someone dynamic lib");
        }
        return null;
    }

    public static void g(d.b.h0.a.l1.f.a aVar, boolean z) {
        ExecutorUtilsExt.postOnElastic(new RunnableC0760a(aVar, z), "requestDynamicLib", 2);
    }
}

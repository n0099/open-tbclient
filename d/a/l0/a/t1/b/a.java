package d.a.l0.a.t1.b;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import d.a.l0.a.a1.e;
import d.a.l0.a.k;
import d.a.l0.a.u.f.b.g.a;
import d.a.l0.a.v2.l0;
import d.a.l0.n.h.h;
import d.a.l0.n.i.m.d;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48413a = k.f46875a;

    /* renamed from: d.a.l0.a.t1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0881a implements a.InterfaceC0927a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.f.a f48414a;

        public C0881a(d.a.l0.a.t1.f.a aVar) {
            this.f48414a = aVar;
        }

        @Override // d.a.l0.a.u.f.b.g.a.InterfaceC0927a
        public void a() {
            a.k(this.f48414a);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.t1.f.a f48415e;

        public b(d.a.l0.a.t1.f.a aVar) {
            this.f48415e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.f48415e);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements d.a.l0.a.h0.j.b<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48416a;

        public c(String str) {
            this.f48416a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.h0.j.b
        /* renamed from: b */
        public void a(Boolean bool) {
            d.a.l0.a.t1.d.a.a("download plugin result = " + bool);
            d.a.l0.a.t1.e.a.b(this.f48416a);
        }
    }

    public static void c(d.a.l0.a.t1.f.a aVar) {
        if (aVar != null && aVar.b()) {
            String str = aVar.f48468h;
            String str2 = aVar.f48466f;
            long j = aVar.f48467g;
            d.a.l0.n.b.e(new d(str, str2, j, aVar.f48469i), new d.a.l0.a.t1.a.a(str, str2, j, new c(str)));
            return;
        }
        d.a.l0.a.t1.d.a.a("plugin is invalid");
    }

    public static File d(h hVar) {
        if (hVar == null) {
            return null;
        }
        File t = e.t(hVar.f51686g, String.valueOf(hVar.f51688i));
        if (t == null || !t.exists()) {
            return e.t(hVar.f51686g, String.valueOf(l0.c(hVar.j)));
        }
        return t;
    }

    public static boolean e(String str) {
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
            String i2 = d.a.l0.a.t1.g.b.i("dynamicLibConfig", null);
            if (TextUtils.isEmpty(i2)) {
                return false;
            }
            try {
                optJSONObject = new JSONObject(i2).optJSONObject(str2);
            } catch (JSONException e2) {
                d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
            if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject("config")) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    if (TextUtils.equals(substring, optJSONArray.optString(i3))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static void f(SwanAppConfigData swanAppConfigData, boolean z) {
        if (swanAppConfigData == null) {
            if (f48413a) {
                d.a.l0.a.t1.d.a.a("parse app.json is null");
                return;
            }
            return;
        }
        List<d.a.l0.a.t1.f.a> h2 = swanAppConfigData.h(3);
        if (h2 != null && !h2.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (d.a.l0.a.p0.f.b.m()) {
                Iterator<d.a.l0.a.t1.f.a> it = h2.iterator();
                while (it.hasNext()) {
                    d.a.l0.a.t1.f.a next = it.next();
                    Pair<Boolean, File> i2 = d.a.l0.a.p0.f.b.i(next.f48468h);
                    if (((Boolean) i2.first).booleanValue()) {
                        d.a.l0.a.e0.d.h("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                        h(jSONObject, jSONObject2, (File) i2.second, next);
                        it.remove();
                    }
                }
            }
            g(h2, jSONObject, jSONObject2, z);
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            d.a.l0.a.t1.g.b.c("dynamicLibPath", jSONObject3);
            d.a.l0.a.t1.g.b.c("dynamicLibConfig", jSONObject4);
            return;
        }
        d.a.l0.a.t1.g.b.c("dynamicLibPath", null);
        d.a.l0.a.t1.g.b.c("dynamicLibConfig", null);
        if (f48413a) {
            d.a.l0.a.t1.d.a.a("this swan app not apply on someone dynamic lib");
        }
    }

    public static void g(@NonNull List<d.a.l0.a.t1.f.a> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        d.a.l0.a.t1.f.a aVar;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        long c2;
        if (list == null || list.size() == 0) {
            return;
        }
        List<h> u = d.a.l0.n.g.a.h().u(d.a.l0.a.t1.g.b.d(list));
        for (d.a.l0.a.t1.f.a aVar2 : list) {
            File file = null;
            try {
                aVar = (d.a.l0.a.t1.f.a) aVar2.clone();
            } catch (CloneNotSupportedException e2) {
                if (f48413a) {
                    d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
                }
                aVar = aVar2;
            }
            boolean z2 = true;
            if (u != null) {
                boolean z3 = true;
                boolean z4 = false;
                for (h hVar : u) {
                    if (aVar2.f48468h.equals(hVar.f51686g)) {
                        d.a.l0.a.t1.d.a.a("pluginName = " + aVar2.f48468h + " latestPlugin versionCode = " + hVar.f51688i + " cur model versionCode = " + aVar2.f48467g);
                        long j = aVar2.f48467g;
                        if (j >= 0) {
                            c2 = hVar.f51688i;
                        } else {
                            c2 = l0.c(hVar.j);
                            j = l0.c(aVar2.f48466f);
                        }
                        if (c2 > j) {
                            file = d(hVar);
                            z4 = true;
                        }
                        if (z4) {
                            aVar.f48466f = hVar.j;
                            aVar.f48467g = hVar.f51688i;
                        }
                        if (!hVar.c()) {
                            d.a.l0.a.t1.d.a.a("plugin is new, not yet expired");
                            z3 = false;
                        }
                    }
                }
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
                z2 = z3;
            } else {
                jSONObject3 = jSONObject;
                jSONObject4 = jSONObject2;
            }
            h(jSONObject3, jSONObject4, file, aVar2);
            if (z2 && z) {
                l(aVar);
            }
        }
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2, File file, d.a.l0.a.t1.f.a aVar) {
        String str;
        if (jSONObject == null || jSONObject2 == null || aVar == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (f48413a) {
                d.a.l0.a.t1.d.a.a("apply path in workspace, name = " + aVar.f48468h);
            }
        } else {
            str = aVar.j;
            if (f48413a) {
                d.a.l0.a.t1.d.a.a("apply path inner swan app, name = " + aVar.f48468h);
            }
        }
        try {
            jSONObject.put(aVar.f48468h, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(aVar.k)) {
                return;
            }
            File file2 = new File(str, aVar.k);
            if (file2.exists()) {
                String D = d.a.l0.t.d.D(file2);
                if (f48413a) {
                    d.a.l0.a.t1.d.a.a("pages info = " + D);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("config", new JSONObject(D));
                jSONObject2.put(aVar.f48468h, jSONObject3);
            }
        } catch (JSONException e2) {
            if (f48413a) {
                d.a.l0.a.t1.d.a.a(Log.getStackTraceString(e2));
            }
        }
    }

    public static h i(String str, String str2, long j) {
        String[] strArr;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (j >= 0) {
            strArr = new String[]{str, String.valueOf(j)};
            str3 = "bundle_id = ?  and version_code = ? ";
        } else if (TextUtils.isEmpty(str2)) {
            strArr = new String[]{str};
            str3 = "bundle_id = ? ";
        } else {
            String[] strArr2 = {str, str2};
            str3 = "bundle_id = ?  and version_name = ? ";
            strArr = strArr2;
        }
        List<h> q = d.a.l0.n.g.a.h().q(str3, strArr);
        if (q == null || q.size() <= 0) {
            return null;
        }
        return q.get(0);
    }

    public static List<h> j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d.a.l0.n.g.a.h().q("bundle_id = ? ", new String[]{str});
    }

    public static void k(d.a.l0.a.t1.f.a aVar) {
        ExecutorUtilsExt.postOnElastic(new b(aVar), "requestDynamicLib", 2);
    }

    public static void l(d.a.l0.a.t1.f.a aVar) {
        d.a.l0.a.u.f.a.d().c(new d.a.l0.a.u.f.b.g.a(new C0881a(aVar)));
    }
}

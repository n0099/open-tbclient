package d.a.i0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.i0.a.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42129c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f42130d;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0664a> f42131a = d.a.i0.a.v2.z0.a.a(new C0664a[0]);

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0664a> f42132b = d.a.i0.a.v2.z0.a.a(new C0664a[0]);

    public static a c() {
        if (f42130d == null) {
            synchronized (a.class) {
                if (f42130d == null) {
                    f42130d = new a();
                }
            }
        }
        return f42130d;
    }

    public void a() {
        b(true);
    }

    public void b(boolean z) {
        if (f42129c) {
            Log.d("PreloadAppsRecorder", "clear all");
        }
        synchronized (this.f42131a) {
            this.f42131a.clear();
            this.f42132b.clear();
        }
        if (z) {
            k();
        }
    }

    public Set<String> d() {
        HashSet a2 = d.a.i0.a.v2.z0.a.a(new String[0]);
        synchronized (this.f42131a) {
            for (C0664a c0664a : this.f42131a) {
                a2.add(c0664a.f42133a);
            }
            for (C0664a c0664a2 : this.f42132b) {
                a2.add(c0664a2.f42133a);
            }
        }
        return a2;
    }

    public boolean e() {
        return this.f42132b.size() > 0;
    }

    public boolean f(C0664a c0664a) {
        boolean contains;
        synchronized (this.f42131a) {
            contains = this.f42131a.contains(c0664a);
        }
        return contains;
    }

    public boolean g(C0664a c0664a) {
        boolean contains;
        synchronized (this.f42131a) {
            contains = this.f42132b.contains(c0664a);
        }
        return contains;
    }

    public void h(String str) {
        if (f42129c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.f42131a) {
                Iterator<C0664a> it = this.f42131a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<C0664a> it2 = this.f42132b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void i(C0664a c0664a, boolean z) {
        if (c0664a == null || !c0664a.a()) {
            return;
        }
        if (f42129c) {
            StringBuilder sb = new StringBuilder();
            sb.append("record one app status - ");
            sb.append(z ? "loaded" : "loading");
            Log.d("PreloadAppsRecorder", sb.toString());
            Log.d("PreloadAppsRecorder", "record one app - " + c0664a);
        }
        synchronized (this.f42131a) {
            (z ? this.f42131a : this.f42132b).add(c0664a);
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f42129c) {
            Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
        }
        synchronized (this.f42131a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0664a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0664a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        d.a.i0.a.v1.b.b v = d.a.i0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
        v.K(true);
        v.L();
        if (f42129c) {
            Log.d("PreloadAppsRecorder", "send all prefetch records to server");
        }
    }

    /* renamed from: d.a.i0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0664a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42133a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42134b;

        public C0664a(String str, long j) {
            this.f42133a = str;
            this.f42134b = String.valueOf(j);
        }

        public boolean a() {
            return (TextUtils.isEmpty(this.f42133a) || TextUtils.isEmpty(this.f42134b)) ? false : true;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0664a) {
                C0664a c0664a = (C0664a) obj;
                return TextUtils.equals(this.f42133a, c0664a.f42133a) && TextUtils.equals(this.f42134b, c0664a.f42134b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f42133a;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.f42134b;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Item{appKey='" + this.f42133a + "', version='" + this.f42134b + "'}";
        }

        public C0664a(JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f42134b = null;
                this.f42133a = null;
                return;
            }
            this.f42133a = jSONObject.optString("appKey");
            this.f42134b = jSONObject.optString("version");
        }
    }
}

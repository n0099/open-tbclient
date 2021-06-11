package d.a.l0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45979c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f45980d;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0731a> f45981a = d.a.l0.a.v2.z0.a.a(new C0731a[0]);

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0731a> f45982b = d.a.l0.a.v2.z0.a.a(new C0731a[0]);

    public static a c() {
        if (f45980d == null) {
            synchronized (a.class) {
                if (f45980d == null) {
                    f45980d = new a();
                }
            }
        }
        return f45980d;
    }

    public void a() {
        b(true);
    }

    public void b(boolean z) {
        if (f45979c) {
            Log.d("PreloadAppsRecorder", "clear all");
        }
        synchronized (this.f45981a) {
            this.f45981a.clear();
            this.f45982b.clear();
        }
        if (z) {
            k();
        }
    }

    public Set<String> d() {
        HashSet a2 = d.a.l0.a.v2.z0.a.a(new String[0]);
        synchronized (this.f45981a) {
            for (C0731a c0731a : this.f45981a) {
                a2.add(c0731a.f45983a);
            }
            for (C0731a c0731a2 : this.f45982b) {
                a2.add(c0731a2.f45983a);
            }
        }
        return a2;
    }

    public boolean e() {
        return this.f45982b.size() > 0;
    }

    public boolean f(C0731a c0731a) {
        boolean contains;
        synchronized (this.f45981a) {
            contains = this.f45981a.contains(c0731a);
        }
        return contains;
    }

    public boolean g(C0731a c0731a) {
        boolean contains;
        synchronized (this.f45981a) {
            contains = this.f45982b.contains(c0731a);
        }
        return contains;
    }

    public void h(String str) {
        if (f45979c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.f45981a) {
                Iterator<C0731a> it = this.f45981a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<C0731a> it2 = this.f45982b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void i(C0731a c0731a, boolean z) {
        if (c0731a == null || !c0731a.a()) {
            return;
        }
        if (f45979c) {
            StringBuilder sb = new StringBuilder();
            sb.append("record one app status - ");
            sb.append(z ? "loaded" : "loading");
            Log.d("PreloadAppsRecorder", sb.toString());
            Log.d("PreloadAppsRecorder", "record one app - " + c0731a);
        }
        synchronized (this.f45981a) {
            (z ? this.f45981a : this.f45982b).add(c0731a);
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f45979c) {
            Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
        }
        synchronized (this.f45981a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0731a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0731a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        d.a.l0.a.v1.b.b v = d.a.l0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
        v.K(true);
        v.L();
        if (f45979c) {
            Log.d("PreloadAppsRecorder", "send all prefetch records to server");
        }
    }

    /* renamed from: d.a.l0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0731a {

        /* renamed from: a  reason: collision with root package name */
        public final String f45983a;

        /* renamed from: b  reason: collision with root package name */
        public final String f45984b;

        public C0731a(String str, long j) {
            this.f45983a = str;
            this.f45984b = String.valueOf(j);
        }

        public boolean a() {
            return (TextUtils.isEmpty(this.f45983a) || TextUtils.isEmpty(this.f45984b)) ? false : true;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0731a) {
                C0731a c0731a = (C0731a) obj;
                return TextUtils.equals(this.f45983a, c0731a.f45983a) && TextUtils.equals(this.f45984b, c0731a.f45984b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f45983a;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.f45984b;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Item{appKey='" + this.f45983a + "', version='" + this.f45984b + "'}";
        }

        public C0731a(JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f45984b = null;
                this.f45983a = null;
                return;
            }
            this.f45983a = jSONObject.optString("appKey");
            this.f45984b = jSONObject.optString("version");
        }
    }
}

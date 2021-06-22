package d.a.m0.a.h0.l.g.o;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.m0.a.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46087c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f46088d;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0734a> f46089a = d.a.m0.a.v2.z0.a.a(new C0734a[0]);

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0734a> f46090b = d.a.m0.a.v2.z0.a.a(new C0734a[0]);

    public static a c() {
        if (f46088d == null) {
            synchronized (a.class) {
                if (f46088d == null) {
                    f46088d = new a();
                }
            }
        }
        return f46088d;
    }

    public void a() {
        b(true);
    }

    public void b(boolean z) {
        if (f46087c) {
            Log.d("PreloadAppsRecorder", "clear all");
        }
        synchronized (this.f46089a) {
            this.f46089a.clear();
            this.f46090b.clear();
        }
        if (z) {
            k();
        }
    }

    public Set<String> d() {
        HashSet a2 = d.a.m0.a.v2.z0.a.a(new String[0]);
        synchronized (this.f46089a) {
            for (C0734a c0734a : this.f46089a) {
                a2.add(c0734a.f46091a);
            }
            for (C0734a c0734a2 : this.f46090b) {
                a2.add(c0734a2.f46091a);
            }
        }
        return a2;
    }

    public boolean e() {
        return this.f46090b.size() > 0;
    }

    public boolean f(C0734a c0734a) {
        boolean contains;
        synchronized (this.f46089a) {
            contains = this.f46089a.contains(c0734a);
        }
        return contains;
    }

    public boolean g(C0734a c0734a) {
        boolean contains;
        synchronized (this.f46089a) {
            contains = this.f46090b.contains(c0734a);
        }
        return contains;
    }

    public void h(String str) {
        if (f46087c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.f46089a) {
                Iterator<C0734a> it = this.f46089a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<C0734a> it2 = this.f46090b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void i(C0734a c0734a, boolean z) {
        if (c0734a == null || !c0734a.a()) {
            return;
        }
        if (f46087c) {
            StringBuilder sb = new StringBuilder();
            sb.append("record one app status - ");
            sb.append(z ? "loaded" : "loading");
            Log.d("PreloadAppsRecorder", sb.toString());
            Log.d("PreloadAppsRecorder", "record one app - " + c0734a);
        }
        synchronized (this.f46089a) {
            (z ? this.f46089a : this.f46090b).add(c0734a);
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f46087c) {
            Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
        }
        synchronized (this.f46089a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0734a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0734a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        d.a.m0.a.v1.b.b v = d.a.m0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
        v.K(true);
        v.L();
        if (f46087c) {
            Log.d("PreloadAppsRecorder", "send all prefetch records to server");
        }
    }

    /* renamed from: d.a.m0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0734a {

        /* renamed from: a  reason: collision with root package name */
        public final String f46091a;

        /* renamed from: b  reason: collision with root package name */
        public final String f46092b;

        public C0734a(String str, long j) {
            this.f46091a = str;
            this.f46092b = String.valueOf(j);
        }

        public boolean a() {
            return (TextUtils.isEmpty(this.f46091a) || TextUtils.isEmpty(this.f46092b)) ? false : true;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0734a) {
                C0734a c0734a = (C0734a) obj;
                return TextUtils.equals(this.f46091a, c0734a.f46091a) && TextUtils.equals(this.f46092b, c0734a.f46092b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f46091a;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.f46092b;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Item{appKey='" + this.f46091a + "', version='" + this.f46092b + "'}";
        }

        public C0734a(JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f46092b = null;
                this.f46091a = null;
                return;
            }
            this.f46091a = jSONObject.optString("appKey");
            this.f46092b = jSONObject.optString("version");
        }
    }
}

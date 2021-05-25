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
    public static final boolean f42303c = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f42304d;

    /* renamed from: a  reason: collision with root package name */
    public final Set<C0675a> f42305a = d.a.l0.a.v2.z0.a.a(new C0675a[0]);

    /* renamed from: b  reason: collision with root package name */
    public final Set<C0675a> f42306b = d.a.l0.a.v2.z0.a.a(new C0675a[0]);

    public static a c() {
        if (f42304d == null) {
            synchronized (a.class) {
                if (f42304d == null) {
                    f42304d = new a();
                }
            }
        }
        return f42304d;
    }

    public void a() {
        b(true);
    }

    public void b(boolean z) {
        if (f42303c) {
            Log.d("PreloadAppsRecorder", "clear all");
        }
        synchronized (this.f42305a) {
            this.f42305a.clear();
            this.f42306b.clear();
        }
        if (z) {
            k();
        }
    }

    public Set<String> d() {
        HashSet a2 = d.a.l0.a.v2.z0.a.a(new String[0]);
        synchronized (this.f42305a) {
            for (C0675a c0675a : this.f42305a) {
                a2.add(c0675a.f42307a);
            }
            for (C0675a c0675a2 : this.f42306b) {
                a2.add(c0675a2.f42307a);
            }
        }
        return a2;
    }

    public boolean e() {
        return this.f42306b.size() > 0;
    }

    public boolean f(C0675a c0675a) {
        boolean contains;
        synchronized (this.f42305a) {
            contains = this.f42305a.contains(c0675a);
        }
        return contains;
    }

    public boolean g(C0675a c0675a) {
        boolean contains;
        synchronized (this.f42305a) {
            contains = this.f42306b.contains(c0675a);
        }
        return contains;
    }

    public void h(String str) {
        if (f42303c) {
            Log.d(str, "all apps in recorder :");
            synchronized (this.f42305a) {
                Iterator<C0675a> it = this.f42305a.iterator();
                while (it.hasNext()) {
                    Log.d(str, "loaded:" + it.next());
                }
                Iterator<C0675a> it2 = this.f42306b.iterator();
                while (it2.hasNext()) {
                    Log.d(str, "loading:" + it2.next());
                }
            }
        }
    }

    public void i(C0675a c0675a, boolean z) {
        if (c0675a == null || !c0675a.a()) {
            return;
        }
        if (f42303c) {
            StringBuilder sb = new StringBuilder();
            sb.append("record one app status - ");
            sb.append(z ? "loaded" : "loading");
            Log.d("PreloadAppsRecorder", sb.toString());
            Log.d("PreloadAppsRecorder", "record one app - " + c0675a);
        }
        synchronized (this.f42305a) {
            (z ? this.f42305a : this.f42306b).add(c0675a);
        }
    }

    public void j(JSONObject jSONObject) {
        int length;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        if (f42303c) {
            Log.d("PreloadAppsRecorder", "get multi preload status - " + jSONObject);
        }
        synchronized (this.f42305a) {
            b(false);
            JSONArray optJSONArray = jSONObject.optJSONArray("loaded");
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    i(new C0675a(optJSONArray.optJSONObject(i2)), true);
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("loading");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                i(new C0675a(optJSONObject), false);
            }
        }
        k();
    }

    public void k() {
        d.a.l0.a.v1.b.b v = d.a.l0.a.v1.b.c.E("swan_multi_preload_on_server").z("swan_multi_preload_app_ids", (String[]) d().toArray(new String[0])).v("swan_multi_preload_app_process_index", SwanAppProcessInfo.current().index);
        v.K(true);
        v.L();
        if (f42303c) {
            Log.d("PreloadAppsRecorder", "send all prefetch records to server");
        }
    }

    /* renamed from: d.a.l0.a.h0.l.g.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0675a {

        /* renamed from: a  reason: collision with root package name */
        public final String f42307a;

        /* renamed from: b  reason: collision with root package name */
        public final String f42308b;

        public C0675a(String str, long j) {
            this.f42307a = str;
            this.f42308b = String.valueOf(j);
        }

        public boolean a() {
            return (TextUtils.isEmpty(this.f42307a) || TextUtils.isEmpty(this.f42308b)) ? false : true;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C0675a) {
                C0675a c0675a = (C0675a) obj;
                return TextUtils.equals(this.f42307a, c0675a.f42307a) && TextUtils.equals(this.f42308b, c0675a.f42308b);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f42307a;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.f42308b;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Item{appKey='" + this.f42307a + "', version='" + this.f42308b + "'}";
        }

        public C0675a(JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f42308b = null;
                this.f42307a = null;
                return;
            }
            this.f42307a = jSONObject.optString("appKey");
            this.f42308b = jSONObject.optString("version");
        }
    }
}

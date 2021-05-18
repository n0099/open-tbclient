package d.a.i0.h.j;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsObject;
import d.a.i0.a.a2.e;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import d.a.i0.h.m0.c;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47237a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static long f47238b = 86400000;

    /* renamed from: c  reason: collision with root package name */
    public static String f47239c = "duration_permission_list";

    public static void a(JsObject jsObject) {
        b bVar;
        e i2 = e.i();
        d.a.i0.a.y.b.a aVar = null;
        if (jsObject == null || i2 == null || !b(i2)) {
            bVar = null;
        } else {
            if (f47237a) {
                Log.e("SwanGameDurationApi", "params is " + jsObject.toString());
            }
            d.a.i0.a.y.b.a G = d.a.i0.a.y.b.a.G(jsObject);
            String C = G.C("swanGameId");
            if (TextUtils.isEmpty(C)) {
                bVar = null;
            } else {
                d.a.i0.a.k2.g.b a2 = h.a();
                if (!c(Long.valueOf(a2.getLong(C + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                    a2.putLong(C + "_Duration", 0L);
                }
                bVar = new b();
                bVar.duration = a2.getLong(C + "_Duration", 0L);
            }
            aVar = G;
        }
        c.a(aVar, true, bVar);
    }

    public static boolean b(e eVar) {
        String string = h.a().getString(f47239c, "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (e.V().contains(jSONArray.optString(i2))) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                if (f47237a) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean c(Long l, Long l2) {
        return l.longValue() / 86400000 == l2.longValue() / 86400000;
    }

    public static void d(long j, long j2) {
        if (j2 <= j || e.i() == null || TextUtils.isEmpty(e.V())) {
            return;
        }
        String V = e.V();
        d.a.i0.a.k2.g.b a2 = h.a();
        long j3 = a2.getLong(V + "_LastPause", 0L);
        long j4 = a2.getLong(V + "_Duration", 0L);
        if (c(Long.valueOf(j), Long.valueOf(j2))) {
            if (c(Long.valueOf(j3), Long.valueOf(j))) {
                a2.putLong(V + "_Duration", (j4 + j2) - j);
            } else {
                a2.putLong(V + "_Duration", j2 - j);
            }
        } else {
            a2.putLong(V + "_Duration", j2 % f47238b);
        }
        a2.putLong(V + "_LastPause", System.currentTimeMillis());
    }
}

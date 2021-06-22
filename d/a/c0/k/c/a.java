package d.a.c0.k.c;

import d.a.c0.n.c;
import d.a.c0.n.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.c0.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0563a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.l.a f43169e;

        /* renamed from: d.a.c0.k.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0564a extends d.a.c0.l.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONArray f43170a;

            public C0564a(JSONArray jSONArray) {
                this.f43170a = jSONArray;
            }

            @Override // d.a.c0.l.a
            public void a(int i2, String str) {
                d.a.c0.l.a aVar = RunnableC0563a.this.f43169e;
                if (aVar != null) {
                    aVar.a(i2, str);
                }
                if (i2 == 1) {
                    a.d(this.f43170a);
                }
            }
        }

        public RunnableC0563a(d.a.c0.l.a aVar) {
            this.f43169e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray f2 = a.f();
            if (f2 == null) {
                return;
            }
            d.a.c0.k.b.a.a(f2, new C0564a(f2));
        }
    }

    public static void a(d.a.c0.l.a aVar) {
        d.a.c0.m.a.a(new RunnableC0563a(aVar));
    }

    public static synchronized void d(JSONArray jSONArray) {
        synchronized (a.class) {
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    c.b(jSONArray.toString(), new File(g.a().getFilesDir(), "poly_cashier_commission_record_cache.json"));
                }
            }
        }
    }

    public static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("operateTime", String.valueOf(System.currentTimeMillis() / 1000));
        } catch (JSONException unused) {
        }
        JSONArray f2 = f();
        if (f2 == null) {
            f2 = new JSONArray();
        }
        f2.put(jSONObject);
        if (f2.length() > 100) {
            f2.remove(0);
        }
        d(f2);
    }

    public static synchronized JSONArray f() {
        synchronized (a.class) {
            File file = new File(g.a().getFilesDir(), "poly_cashier_commission_record_cache.json");
            JSONArray jSONArray = null;
            if (file.exists()) {
                try {
                    JSONArray jSONArray2 = new JSONArray(c.d(file));
                    try {
                        file.delete();
                    } catch (JSONException unused) {
                    }
                    jSONArray = jSONArray2;
                } catch (JSONException unused2) {
                }
                return jSONArray;
            }
            return null;
        }
    }
}

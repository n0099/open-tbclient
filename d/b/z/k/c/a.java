package d.b.z.k.c;

import d.b.z.n.c;
import d.b.z.n.g;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.z.k.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC1800a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.z.l.a f65640e;

        /* renamed from: d.b.z.k.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C1801a extends d.b.z.l.a {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONArray f65641a;

            public C1801a(JSONArray jSONArray) {
                this.f65641a = jSONArray;
            }

            @Override // d.b.z.l.a
            public void a(int i, String str) {
                d.b.z.l.a aVar = RunnableC1800a.this.f65640e;
                if (aVar != null) {
                    aVar.a(i, str);
                }
                if (i == 1) {
                    a.d(this.f65641a);
                }
            }
        }

        public RunnableC1800a(d.b.z.l.a aVar) {
            this.f65640e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONArray f2 = a.f();
            if (f2 == null) {
                return;
            }
            d.b.z.k.b.a.a(f2, new C1801a(f2));
        }
    }

    public static void a(d.b.z.l.a aVar) {
        d.b.z.m.a.a(new RunnableC1800a(aVar));
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

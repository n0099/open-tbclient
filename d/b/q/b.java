package d.b.q;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import d.b.q.d.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f64246d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64247a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.q.d.a f64248b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.q.d.b f64249c;

    /* loaded from: classes2.dex */
    public class a implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64250a;

        public a(b bVar, c cVar) {
            this.f64250a = cVar;
        }

        @Override // d.b.q.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64250a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64250a.b(d.a(str), bundle);
        }
    }

    /* renamed from: d.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1740b implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64251a;

        public C1740b(b bVar, c cVar) {
            this.f64251a = cVar;
        }

        @Override // d.b.q.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64251a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64251a.b(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class c<T> extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.b.q.c<T> f64252a;

        public c(d.b.q.c<T> cVar, Looper looper) {
            super(looper);
            this.f64252a = cVar;
        }

        public void a(int i, Exception exc, Bundle bundle) {
            obtainMessage(1, i, 0, Pair.create(exc, bundle)).sendToTarget();
        }

        public void b(T t, Bundle bundle) {
            obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.b.q.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                Pair pair = (Pair) message.obj;
                this.f64252a.a(pair.first, (Bundle) pair.second);
            } else if (i != 1) {
            } else {
                Pair pair2 = (Pair) message.obj;
                this.f64252a.b(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f64253a;

        public d(List<e> list) {
            ArrayList arrayList = new ArrayList();
            this.f64253a = arrayList;
            arrayList.addAll(list);
        }

        public static d a(String str) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new e(jSONObject.getString("pkg"), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                }
                return new d(arrayList);
            } catch (JSONException unused) {
                return null;
            }
        }

        public List<e> b() {
            return this.f64253a;
        }

        public String toString() {
            return "sids {" + this.f64253a + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f64254a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64255b;

        /* renamed from: c  reason: collision with root package name */
        public final long f64256c;

        public e(String str, String str2, long j) {
            this.f64254a = str;
            this.f64255b = str2;
            this.f64256c = j;
        }

        public String toString() {
            return "aid {packageName='" + this.f64254a + "', aid='" + this.f64255b + "', priority=" + this.f64256c + '}';
        }
    }

    public b(Context context) {
        this.f64247a = context.getApplicationContext();
        d.b.q.d.b bVar = new d.b.q.d.b(new d.b.q.i.a());
        this.f64249c = bVar;
        this.f64248b = bVar.a();
        a.C1741a c1741a = new a.C1741a();
        c1741a.f64259a = new d.b.q.i.c();
        c1741a.f64260b = new d.b.q.i.b();
        c1741a.f64261c = this.f64247a;
        c1741a.f64262d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c1741a.f64263e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64248b.b(c1741a);
        this.f64248b.c(new a.b());
    }

    public static synchronized b d(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f64246d == null) {
                f64246d = new b(context.getApplicationContext());
            }
            bVar = f64246d;
        }
        return bVar;
    }

    public String a() {
        return this.f64248b.f("aid", null).f64264a;
    }

    public d.b.q.d.a b() {
        return this.f64248b;
    }

    public String c() {
        return this.f64248b.f("iid", null).f64264a;
    }

    public String e() {
        return this.f64248b.f("oid", null).f64264a;
    }

    public String f() {
        return this.f64248b.f("ssaid", null).f64264a;
    }

    public boolean g() {
        return this.f64248b.d(this.f64247a.getPackageName());
    }

    public void h(d.b.q.c<String> cVar) {
        i("gaid", cVar, Looper.getMainLooper());
    }

    public final void i(String str, d.b.q.c<String> cVar, Looper looper) {
        this.f64248b.a(str, null, new C1740b(this, new c(cVar, looper)));
    }

    public void j(d.b.q.c<String> cVar) {
        i("oid", cVar, Looper.getMainLooper());
    }

    public void k(d.b.q.c<d> cVar) {
        l(cVar, Looper.getMainLooper());
    }

    public void l(d.b.q.c<d> cVar, Looper looper) {
        this.f64248b.a("sids", null, new a(this, new c(cVar, looper)));
    }
}

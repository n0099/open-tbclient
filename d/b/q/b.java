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
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f64245d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64246a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.q.d.a f64247b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.q.d.b f64248c;

    /* loaded from: classes2.dex */
    public class a implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64249a;

        public a(b bVar, c cVar) {
            this.f64249a = cVar;
        }

        @Override // d.b.q.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64249a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64249a.b(d.a(str), bundle);
        }
    }

    /* renamed from: d.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1739b implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64250a;

        public C1739b(b bVar, c cVar) {
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
            this.f64250a.b(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class c<T> extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.b.q.c<T> f64251a;

        public c(d.b.q.c<T> cVar, Looper looper) {
            super(looper);
            this.f64251a = cVar;
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
                this.f64251a.a(pair.first, (Bundle) pair.second);
            } else if (i != 1) {
            } else {
                Pair pair2 = (Pair) message.obj;
                this.f64251a.b(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f64252a;

        public d(List<e> list) {
            ArrayList arrayList = new ArrayList();
            this.f64252a = arrayList;
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
            return this.f64252a;
        }

        public String toString() {
            return "sids {" + this.f64252a + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f64253a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64254b;

        /* renamed from: c  reason: collision with root package name */
        public final long f64255c;

        public e(String str, String str2, long j) {
            this.f64253a = str;
            this.f64254b = str2;
            this.f64255c = j;
        }

        public String toString() {
            return "aid {packageName='" + this.f64253a + "', aid='" + this.f64254b + "', priority=" + this.f64255c + '}';
        }
    }

    public b(Context context) {
        this.f64246a = context.getApplicationContext();
        d.b.q.d.b bVar = new d.b.q.d.b(new d.b.q.i.a());
        this.f64248c = bVar;
        this.f64247b = bVar.a();
        a.C1740a c1740a = new a.C1740a();
        c1740a.f64258a = new d.b.q.i.c();
        c1740a.f64259b = new d.b.q.i.b();
        c1740a.f64260c = this.f64246a;
        c1740a.f64261d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c1740a.f64262e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64247b.b(c1740a);
        this.f64247b.c(new a.b());
    }

    public static synchronized b d(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f64245d == null) {
                f64245d = new b(context.getApplicationContext());
            }
            bVar = f64245d;
        }
        return bVar;
    }

    public String a() {
        return this.f64247b.f("aid", null).f64263a;
    }

    public d.b.q.d.a b() {
        return this.f64247b;
    }

    public String c() {
        return this.f64247b.f("iid", null).f64263a;
    }

    public String e() {
        return this.f64247b.f("oid", null).f64263a;
    }

    public String f() {
        return this.f64247b.f("ssaid", null).f64263a;
    }

    public boolean g() {
        return this.f64247b.d(this.f64246a.getPackageName());
    }

    public void h(d.b.q.c<String> cVar) {
        i("gaid", cVar, Looper.getMainLooper());
    }

    public final void i(String str, d.b.q.c<String> cVar, Looper looper) {
        this.f64247b.a(str, null, new C1739b(this, new c(cVar, looper)));
    }

    public void j(d.b.q.c<String> cVar) {
        i("oid", cVar, Looper.getMainLooper());
    }

    public void k(d.b.q.c<d> cVar) {
        l(cVar, Looper.getMainLooper());
    }

    public void l(d.b.q.c<d> cVar, Looper looper) {
        this.f64247b.a("sids", null, new a(this, new c(cVar, looper)));
    }
}

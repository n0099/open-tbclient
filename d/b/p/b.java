package d.b.p;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import d.b.p.d.a;
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
    public static volatile b f64940d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64941a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.p.d.a f64942b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.p.d.b f64943c;

    /* loaded from: classes2.dex */
    public class a implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64944a;

        public a(b bVar, c cVar) {
            this.f64944a = cVar;
        }

        @Override // d.b.p.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64944a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.p.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64944a.b(d.a(str), bundle);
        }
    }

    /* renamed from: d.b.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1752b implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64945a;

        public C1752b(b bVar, c cVar) {
            this.f64945a = cVar;
        }

        @Override // d.b.p.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f64945a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.p.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64945a.b(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class c<T> extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.b.p.c<T> f64946a;

        public c(d.b.p.c<T> cVar, Looper looper) {
            super(looper);
            this.f64946a = cVar;
        }

        public void a(int i, Exception exc, Bundle bundle) {
            obtainMessage(1, i, 0, Pair.create(exc, bundle)).sendToTarget();
        }

        public void b(T t, Bundle bundle) {
            obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.b.p.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                Pair pair = (Pair) message.obj;
                this.f64946a.a(pair.first, (Bundle) pair.second);
            } else if (i != 1) {
            } else {
                Pair pair2 = (Pair) message.obj;
                this.f64946a.b(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f64947a;

        public d(List<e> list) {
            ArrayList arrayList = new ArrayList();
            this.f64947a = arrayList;
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
            return this.f64947a;
        }

        public String toString() {
            return "sids {" + this.f64947a + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f64948a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64949b;

        /* renamed from: c  reason: collision with root package name */
        public final long f64950c;

        public e(String str, String str2, long j) {
            this.f64948a = str;
            this.f64949b = str2;
            this.f64950c = j;
        }

        public String toString() {
            return "aid {packageName='" + this.f64948a + "', aid='" + this.f64949b + "', priority=" + this.f64950c + '}';
        }
    }

    public b(Context context) {
        this.f64941a = context.getApplicationContext();
        d.b.p.d.b bVar = new d.b.p.d.b(new d.b.p.i.a());
        this.f64943c = bVar;
        this.f64942b = bVar.a();
        a.C1753a c1753a = new a.C1753a();
        c1753a.f64953a = new d.b.p.i.c();
        c1753a.f64954b = new d.b.p.i.b();
        c1753a.f64955c = this.f64941a;
        c1753a.f64956d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c1753a.f64957e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64942b.b(c1753a);
        this.f64942b.c(new a.b());
    }

    public static synchronized b d(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f64940d == null) {
                f64940d = new b(context.getApplicationContext());
            }
            bVar = f64940d;
        }
        return bVar;
    }

    public String a() {
        return this.f64942b.f("aid", null).f64958a;
    }

    public d.b.p.d.a b() {
        return this.f64942b;
    }

    public String c() {
        return this.f64942b.f("iid", null).f64958a;
    }

    public String e() {
        return this.f64942b.f("oid", null).f64958a;
    }

    public String f() {
        return this.f64942b.f("ssaid", null).f64958a;
    }

    public boolean g() {
        return this.f64942b.d(this.f64941a.getPackageName());
    }

    public void h(d.b.p.c<String> cVar) {
        i("gaid", cVar, Looper.getMainLooper());
    }

    public final void i(String str, d.b.p.c<String> cVar, Looper looper) {
        this.f64942b.a(str, null, new C1752b(this, new c(cVar, looper)));
    }

    public void j(d.b.p.c<String> cVar) {
        i("oid", cVar, Looper.getMainLooper());
    }

    public void k(d.b.p.c<d> cVar) {
        l(cVar, Looper.getMainLooper());
    }

    public void l(d.b.p.c<d> cVar, Looper looper) {
        this.f64942b.a("sids", null, new a(this, new c(cVar, looper)));
    }
}

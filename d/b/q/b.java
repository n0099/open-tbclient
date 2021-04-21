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
    public static volatile b f65204d;

    /* renamed from: a  reason: collision with root package name */
    public Context f65205a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.q.d.a f65206b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.q.d.b f65207c;

    /* loaded from: classes2.dex */
    public class a implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65208a;

        public a(b bVar, c cVar) {
            this.f65208a = cVar;
        }

        @Override // d.b.q.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f65208a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f65208a.b(d.a(str), bundle);
        }
    }

    /* renamed from: d.b.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1771b implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65209a;

        public C1771b(b bVar, c cVar) {
            this.f65209a = cVar;
        }

        @Override // d.b.q.d.a.c
        public void b(int i, Exception exc, Bundle bundle) {
            this.f65209a.a(i, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f65209a.b(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class c<T> extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.b.q.c<T> f65210a;

        public c(d.b.q.c<T> cVar, Looper looper) {
            super(looper);
            this.f65210a = cVar;
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
                this.f65210a.a(pair.first, (Bundle) pair.second);
            } else if (i != 1) {
            } else {
                Pair pair2 = (Pair) message.obj;
                this.f65210a.b(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f65211a;

        public d(List<e> list) {
            ArrayList arrayList = new ArrayList();
            this.f65211a = arrayList;
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
            return this.f65211a;
        }

        public String toString() {
            return "sids {" + this.f65211a + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f65212a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65213b;

        /* renamed from: c  reason: collision with root package name */
        public final long f65214c;

        public e(String str, String str2, long j) {
            this.f65212a = str;
            this.f65213b = str2;
            this.f65214c = j;
        }

        public String toString() {
            return "aid {packageName='" + this.f65212a + "', aid='" + this.f65213b + "', priority=" + this.f65214c + '}';
        }
    }

    public b(Context context) {
        this.f65205a = context.getApplicationContext();
        d.b.q.d.b bVar = new d.b.q.d.b(new d.b.q.i.a());
        this.f65207c = bVar;
        this.f65206b = bVar.a();
        a.C1772a c1772a = new a.C1772a();
        c1772a.f65217a = new d.b.q.i.c();
        c1772a.f65218b = new d.b.q.i.b();
        c1772a.f65219c = this.f65205a;
        c1772a.f65220d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c1772a.f65221e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f65206b.b(c1772a);
        this.f65206b.c(new a.b());
    }

    public static synchronized b d(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f65204d == null) {
                f65204d = new b(context.getApplicationContext());
            }
            bVar = f65204d;
        }
        return bVar;
    }

    public String a() {
        return this.f65206b.f("aid", null).f65222a;
    }

    public d.b.q.d.a b() {
        return this.f65206b;
    }

    public String c() {
        return this.f65206b.f("iid", null).f65222a;
    }

    public String e() {
        return this.f65206b.f("oid", null).f65222a;
    }

    public String f() {
        return this.f65206b.f("ssaid", null).f65222a;
    }

    public boolean g() {
        return this.f65206b.d(this.f65205a.getPackageName());
    }

    public void h(d.b.q.c<String> cVar) {
        i("gaid", cVar, Looper.getMainLooper());
    }

    public final void i(String str, d.b.q.c<String> cVar, Looper looper) {
        this.f65206b.a(str, null, new C1771b(this, new c(cVar, looper)));
    }

    public void j(d.b.q.c<String> cVar) {
        i("oid", cVar, Looper.getMainLooper());
    }

    public void k(d.b.q.c<d> cVar) {
        l(cVar, Looper.getMainLooper());
    }

    public void l(d.b.q.c<d> cVar, Looper looper) {
        this.f65206b.a("sids", null, new a(this, new c(cVar, looper)));
    }
}

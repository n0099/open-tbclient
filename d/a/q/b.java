package d.a.q;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.baidu.common.param.CommonUrlParamManager;
import d.a.q.d.a;
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
    public static volatile b f64032d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64033a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.q.d.a f64034b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q.d.b f64035c;

    /* loaded from: classes2.dex */
    public class a implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64036a;

        public a(b bVar, c cVar) {
            this.f64036a = cVar;
        }

        @Override // d.a.q.d.a.c
        public void b(int i2, Exception exc, Bundle bundle) {
            this.f64036a.a(i2, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64036a.b(d.a(str), bundle);
        }
    }

    /* renamed from: d.a.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1775b implements a.c<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f64037a;

        public C1775b(b bVar, c cVar) {
            this.f64037a = cVar;
        }

        @Override // d.a.q.d.a.c
        public void b(int i2, Exception exc, Bundle bundle) {
            this.f64037a.a(i2, exc, bundle);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q.d.a.c
        /* renamed from: c */
        public void a(String str, Bundle bundle) {
            this.f64037a.b(str, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public static class c<T> extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public d.a.q.c<T> f64038a;

        public c(d.a.q.c<T> cVar, Looper looper) {
            super(looper);
            this.f64038a = cVar;
        }

        public void a(int i2, Exception exc, Bundle bundle) {
            obtainMessage(1, i2, 0, Pair.create(exc, bundle)).sendToTarget();
        }

        public void b(T t, Bundle bundle) {
            obtainMessage(0, Pair.create(t, bundle)).sendToTarget();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: d.a.q.c<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                Pair pair = (Pair) message.obj;
                this.f64038a.a(pair.first, (Bundle) pair.second);
            } else if (i2 != 1) {
            } else {
                Pair pair2 = (Pair) message.obj;
                this.f64038a.b(message.arg1, (Throwable) pair2.first, (Bundle) pair2.second);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<e> f64039a;

        public d(List<e> list) {
            ArrayList arrayList = new ArrayList();
            this.f64039a = arrayList;
            arrayList.addAll(list);
        }

        public static d a(String str) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    arrayList.add(new e(jSONObject.getString("pkg"), jSONObject.getString("aid"), jSONObject.getLong("priority")));
                }
                return new d(arrayList);
            } catch (JSONException unused) {
                return null;
            }
        }

        public List<e> b() {
            return this.f64039a;
        }

        public String toString() {
            return "sids {" + this.f64039a + '}';
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f64040a;

        /* renamed from: b  reason: collision with root package name */
        public final String f64041b;

        /* renamed from: c  reason: collision with root package name */
        public final long f64042c;

        public e(String str, String str2, long j) {
            this.f64040a = str;
            this.f64041b = str2;
            this.f64042c = j;
        }

        public String toString() {
            return "aid {packageName='" + this.f64040a + "', aid='" + this.f64041b + "', priority=" + this.f64042c + '}';
        }
    }

    public b(Context context) {
        this.f64033a = context.getApplicationContext();
        d.a.q.d.b bVar = new d.a.q.d.b(new d.a.q.i.a());
        this.f64035c = bVar;
        this.f64034b = bVar.a();
        a.C1776a c1776a = new a.C1776a();
        c1776a.f64045a = new d.a.q.i.c();
        c1776a.f64046b = new d.a.q.i.b();
        c1776a.f64047c = this.f64033a;
        c1776a.f64048d = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        c1776a.f64049e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f64034b.b(c1776a);
        this.f64034b.c(new a.b());
    }

    public static synchronized b d(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f64032d == null) {
                f64032d = new b(context.getApplicationContext());
            }
            bVar = f64032d;
        }
        return bVar;
    }

    public String a() {
        return this.f64034b.f("aid", null).f64050a;
    }

    public d.a.q.d.a b() {
        return this.f64034b;
    }

    public String c() {
        return this.f64034b.f(CommonUrlParamManager.PARAM_IID, null).f64050a;
    }

    public String e() {
        return this.f64034b.f("oid", null).f64050a;
    }

    public String f() {
        return this.f64034b.f("ssaid", null).f64050a;
    }

    public boolean g() {
        return this.f64034b.d(this.f64033a.getPackageName());
    }

    public void h(d.a.q.c<String> cVar) {
        i("gaid", cVar, Looper.getMainLooper());
    }

    public final void i(String str, d.a.q.c<String> cVar, Looper looper) {
        this.f64034b.a(str, null, new C1775b(this, new c(cVar, looper)));
    }

    public void j(d.a.q.c<String> cVar) {
        i("oid", cVar, Looper.getMainLooper());
    }

    public void k(d.a.q.c<d> cVar) {
        l(cVar, Looper.getMainLooper());
    }

    public void l(d.a.q.c<d> cVar, Looper looper) {
        this.f64034b.a("sids", null, new a(this, new c(cVar, looper)));
    }
}

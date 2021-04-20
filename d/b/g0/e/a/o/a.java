package d.b.g0.e.a.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.e.a.o.b;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f48026a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.e.a.m.b f48027b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48028c;

    /* renamed from: d.b.g0.e.a.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0946a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f48029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.e.a.m.e f48030f;

        /* renamed from: d.b.g0.e.a.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0947a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f48032a = 0;

            /* renamed from: d.b.g0.e.a.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0948a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f48034e;

                public RunnableC0948a(AdElementInfo adElementInfo) {
                    this.f48034e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f48027b != null) {
                        a.this.f48027b.f(this.f48034e);
                    }
                }
            }

            public C0947a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                if (adResponseInfo == null) {
                    a.this.f("200000");
                } else if (adResponseInfo.a().size() > 0) {
                    k0.X(new RunnableC0948a(adResponseInfo.c()));
                } else if (this.f48032a == 1 && RunnableC0946a.this.f48029e.i.c() == 1 && d.b.g0.e.a.q.f.h()) {
                    RunnableC0946a runnableC0946a = RunnableC0946a.this;
                    a.this.g(runnableC0946a.f48030f, runnableC0946a.f48029e, this);
                } else {
                    this.f48032a = 0;
                    String b2 = adResponseInfo.b();
                    if (b2.equals("0")) {
                        b2 = "201000";
                    }
                    a.this.f(b2);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i) {
                if (response != null && response.body() != null) {
                    this.f48032a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f48028c) {
                                return new AdResponseInfo(string, a.this.f48028c);
                            }
                            return new AdResponseInfo(string);
                        }
                    } catch (Exception | OutOfMemoryError unused) {
                    }
                }
                return null;
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                a.this.f("3010002");
            }
        }

        public RunnableC0946a(d dVar, d.b.g0.e.a.m.e eVar) {
            this.f48029e = dVar;
            this.f48030f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f48029e;
            if (dVar == null || dVar.i == null) {
                return;
            }
            C0947a c0947a = new C0947a();
            if (SwanAppNetworkUtils.h(a.this.f48026a)) {
                if (a.this.f48028c) {
                    d dVar2 = this.f48029e;
                    if (dVar2 instanceof e) {
                        e eVar = (e) dVar2;
                        if (this.f48030f == null || eVar.j() == null) {
                            return;
                        }
                        this.f48030f.a(eVar.h(), eVar.j(), c0947a);
                        return;
                    }
                }
                a.this.f48028c = false;
                String h2 = this.f48029e.h();
                d.b.g0.e.a.m.e eVar2 = this.f48030f;
                if (eVar2 != null) {
                    eVar2.e(h2, c0947a);
                    return;
                }
                return;
            }
            a.this.f("3010003");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48036e;

        public b(String str) {
            this.f48036e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48027b != null) {
                a.this.f48027b.c(this.f48036e);
            }
        }
    }

    public a(Context context) {
        this.f48026a = context;
    }

    public final void f(String str) {
        k0.X(new b(str));
    }

    public void g(d.b.g0.e.a.m.e eVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.h(this.f48026a)) {
            this.f48028c = true;
            if (dVar instanceof e) {
                e eVar2 = (e) dVar;
                if (eVar == null || eVar2.j() == null) {
                    return;
                }
                eVar.a(eVar2.h(), eVar2.j(), responseCallback);
                return;
            }
            b.C0949b c0949b = new b.C0949b();
            c0949b.l(d.b.g0.e.a.q.f.c());
            c0949b.i(d.b.g0.e.a.q.f.d());
            c0949b.m(dVar.i.f());
            c0949b.k(h0.m(this.f48026a));
            c0949b.h(h0.l(this.f48026a));
            e eVar3 = new e(this.f48026a, c0949b.g(), 5, 5);
            if (eVar == null || eVar3.j() == null) {
                return;
            }
            eVar.a(eVar3.h(), eVar3.j(), responseCallback);
            return;
        }
        f("3010003");
    }

    public void h(d dVar, d.b.g0.e.a.m.e eVar) {
        p.k(new RunnableC0946a(dVar, eVar), "execAdRequest");
    }

    public void i(d.b.g0.e.a.m.b bVar) {
        this.f48027b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f48028c = z;
    }
}

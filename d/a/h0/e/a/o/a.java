package d.a.h0.e.a.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.e.a.o.b;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f45809a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.e.a.m.b f45810b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45811c;

    /* renamed from: d.a.h0.e.a.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0905a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f45812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.e.a.m.e f45813f;

        /* renamed from: d.a.h0.e.a.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0906a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f45815a = 0;

            /* renamed from: d.a.h0.e.a.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0907a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f45817e;

                public RunnableC0907a(AdElementInfo adElementInfo) {
                    this.f45817e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f45810b != null) {
                        a.this.f45810b.c(this.f45817e);
                    }
                }
            }

            public C0906a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                if (adResponseInfo == null) {
                    a.this.f("200000");
                } else if (adResponseInfo.a().size() > 0) {
                    k0.X(new RunnableC0907a(adResponseInfo.c()));
                } else if (this.f45815a == 1 && RunnableC0905a.this.f45812e.f45841i.c() == 1 && d.a.h0.e.a.q.f.h()) {
                    RunnableC0905a runnableC0905a = RunnableC0905a.this;
                    a.this.g(runnableC0905a.f45813f, runnableC0905a.f45812e, this);
                } else {
                    this.f45815a = 0;
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
            public AdResponseInfo parseResponse(Response response, int i2) {
                if (response != null && response.body() != null) {
                    this.f45815a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f45811c) {
                                return new AdResponseInfo(string, a.this.f45811c);
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

        public RunnableC0905a(d dVar, d.a.h0.e.a.m.e eVar) {
            this.f45812e = dVar;
            this.f45813f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f45812e;
            if (dVar == null || dVar.f45841i == null) {
                return;
            }
            C0906a c0906a = new C0906a();
            if (SwanAppNetworkUtils.h(a.this.f45809a)) {
                if (a.this.f45811c) {
                    d dVar2 = this.f45812e;
                    if (dVar2 instanceof e) {
                        e eVar = (e) dVar2;
                        if (this.f45813f == null || eVar.j() == null) {
                            return;
                        }
                        this.f45813f.a(eVar.h(), eVar.j(), c0906a);
                        return;
                    }
                }
                a.this.f45811c = false;
                String h2 = this.f45812e.h();
                d.a.h0.e.a.m.e eVar2 = this.f45813f;
                if (eVar2 != null) {
                    eVar2.e(h2, c0906a);
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
        public final /* synthetic */ String f45819e;

        public b(String str) {
            this.f45819e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f45810b != null) {
                a.this.f45810b.a(this.f45819e);
            }
        }
    }

    public a(Context context) {
        this.f45809a = context;
    }

    public final void f(String str) {
        k0.X(new b(str));
    }

    public void g(d.a.h0.e.a.m.e eVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.h(this.f45809a)) {
            this.f45811c = true;
            if (dVar instanceof e) {
                e eVar2 = (e) dVar;
                if (eVar == null || eVar2.j() == null) {
                    return;
                }
                eVar.a(eVar2.h(), eVar2.j(), responseCallback);
                return;
            }
            b.C0908b c0908b = new b.C0908b();
            c0908b.l(d.a.h0.e.a.q.f.c());
            c0908b.i(d.a.h0.e.a.q.f.d());
            c0908b.m(dVar.f45841i.f());
            c0908b.k(h0.m(this.f45809a));
            c0908b.h(h0.l(this.f45809a));
            e eVar3 = new e(this.f45809a, c0908b.g(), 5, 5);
            if (eVar == null || eVar3.j() == null) {
                return;
            }
            eVar.a(eVar3.h(), eVar3.j(), responseCallback);
            return;
        }
        f("3010003");
    }

    public void h(d dVar, d.a.h0.e.a.m.e eVar) {
        p.k(new RunnableC0905a(dVar, eVar), "execAdRequest");
    }

    public void i(d.a.h0.e.a.m.b bVar) {
        this.f45810b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f45811c = z;
    }
}

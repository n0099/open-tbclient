package d.b.h0.e.a.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.e.a.o.b;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f48355a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.e.a.m.b f48356b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f48357c;

    /* renamed from: d.b.h0.e.a.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0966a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f48358e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.e.a.m.e f48359f;

        /* renamed from: d.b.h0.e.a.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0967a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f48361a = 0;

            /* renamed from: d.b.h0.e.a.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0968a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f48363e;

                public RunnableC0968a(AdElementInfo adElementInfo) {
                    this.f48363e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f48356b != null) {
                        a.this.f48356b.f(this.f48363e);
                    }
                }
            }

            public C0967a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                if (adResponseInfo == null) {
                    a.this.f("200000");
                } else if (adResponseInfo.a().size() > 0) {
                    k0.X(new RunnableC0968a(adResponseInfo.c()));
                } else if (this.f48361a == 1 && RunnableC0966a.this.f48358e.i.c() == 1 && d.b.h0.e.a.q.f.h()) {
                    RunnableC0966a runnableC0966a = RunnableC0966a.this;
                    a.this.g(runnableC0966a.f48359f, runnableC0966a.f48358e, this);
                } else {
                    this.f48361a = 0;
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
                    this.f48361a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f48357c) {
                                return new AdResponseInfo(string, a.this.f48357c);
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

        public RunnableC0966a(d dVar, d.b.h0.e.a.m.e eVar) {
            this.f48358e = dVar;
            this.f48359f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f48358e;
            if (dVar == null || dVar.i == null) {
                return;
            }
            C0967a c0967a = new C0967a();
            if (SwanAppNetworkUtils.h(a.this.f48355a)) {
                if (a.this.f48357c) {
                    d dVar2 = this.f48358e;
                    if (dVar2 instanceof e) {
                        e eVar = (e) dVar2;
                        if (this.f48359f == null || eVar.j() == null) {
                            return;
                        }
                        this.f48359f.a(eVar.h(), eVar.j(), c0967a);
                        return;
                    }
                }
                a.this.f48357c = false;
                String h2 = this.f48358e.h();
                d.b.h0.e.a.m.e eVar2 = this.f48359f;
                if (eVar2 != null) {
                    eVar2.e(h2, c0967a);
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
        public final /* synthetic */ String f48365e;

        public b(String str) {
            this.f48365e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f48356b != null) {
                a.this.f48356b.c(this.f48365e);
            }
        }
    }

    public a(Context context) {
        this.f48355a = context;
    }

    public final void f(String str) {
        k0.X(new b(str));
    }

    public void g(d.b.h0.e.a.m.e eVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.h(this.f48355a)) {
            this.f48357c = true;
            if (dVar instanceof e) {
                e eVar2 = (e) dVar;
                if (eVar == null || eVar2.j() == null) {
                    return;
                }
                eVar.a(eVar2.h(), eVar2.j(), responseCallback);
                return;
            }
            b.C0969b c0969b = new b.C0969b();
            c0969b.l(d.b.h0.e.a.q.f.c());
            c0969b.i(d.b.h0.e.a.q.f.d());
            c0969b.m(dVar.i.f());
            c0969b.k(h0.m(this.f48355a));
            c0969b.h(h0.l(this.f48355a));
            e eVar3 = new e(this.f48355a, c0969b.g(), 5, 5);
            if (eVar == null || eVar3.j() == null) {
                return;
            }
            eVar.a(eVar3.h(), eVar3.j(), responseCallback);
            return;
        }
        f("3010003");
    }

    public void h(d dVar, d.b.h0.e.a.m.e eVar) {
        p.k(new RunnableC0966a(dVar, eVar), "execAdRequest");
    }

    public void i(d.b.h0.e.a.m.b bVar) {
        this.f48356b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f48357c = z;
    }
}

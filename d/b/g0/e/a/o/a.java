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
    public Context f47634a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.e.a.m.b f47635b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47636c;

    /* renamed from: d.b.g0.e.a.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0934a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f47637e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.e.a.m.e f47638f;

        /* renamed from: d.b.g0.e.a.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0935a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f47640a = 0;

            /* renamed from: d.b.g0.e.a.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0936a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f47642e;

                public RunnableC0936a(AdElementInfo adElementInfo) {
                    this.f47642e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f47635b != null) {
                        a.this.f47635b.f(this.f47642e);
                    }
                }
            }

            public C0935a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i) {
                if (adResponseInfo == null) {
                    a.this.f("200000");
                } else if (adResponseInfo.a().size() > 0) {
                    k0.X(new RunnableC0936a(adResponseInfo.c()));
                } else if (this.f47640a == 1 && RunnableC0934a.this.f47637e.i.c() == 1 && d.b.g0.e.a.q.f.h()) {
                    RunnableC0934a runnableC0934a = RunnableC0934a.this;
                    a.this.g(runnableC0934a.f47638f, runnableC0934a.f47637e, this);
                } else {
                    this.f47640a = 0;
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
                    this.f47640a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f47636c) {
                                return new AdResponseInfo(string, a.this.f47636c);
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

        public RunnableC0934a(d dVar, d.b.g0.e.a.m.e eVar) {
            this.f47637e = dVar;
            this.f47638f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f47637e;
            if (dVar == null || dVar.i == null) {
                return;
            }
            C0935a c0935a = new C0935a();
            if (SwanAppNetworkUtils.h(a.this.f47634a)) {
                if (a.this.f47636c) {
                    d dVar2 = this.f47637e;
                    if (dVar2 instanceof e) {
                        e eVar = (e) dVar2;
                        if (this.f47638f == null || eVar.j() == null) {
                            return;
                        }
                        this.f47638f.a(eVar.h(), eVar.j(), c0935a);
                        return;
                    }
                }
                a.this.f47636c = false;
                String h2 = this.f47637e.h();
                d.b.g0.e.a.m.e eVar2 = this.f47638f;
                if (eVar2 != null) {
                    eVar2.e(h2, c0935a);
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
        public final /* synthetic */ String f47644e;

        public b(String str) {
            this.f47644e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f47635b != null) {
                a.this.f47635b.c(this.f47644e);
            }
        }
    }

    public a(Context context) {
        this.f47634a = context;
    }

    public final void f(String str) {
        k0.X(new b(str));
    }

    public void g(d.b.g0.e.a.m.e eVar, d dVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (SwanAppNetworkUtils.h(this.f47634a)) {
            this.f47636c = true;
            if (dVar instanceof e) {
                e eVar2 = (e) dVar;
                if (eVar == null || eVar2.j() == null) {
                    return;
                }
                eVar.a(eVar2.h(), eVar2.j(), responseCallback);
                return;
            }
            b.C0937b c0937b = new b.C0937b();
            c0937b.l(d.b.g0.e.a.q.f.c());
            c0937b.i(d.b.g0.e.a.q.f.d());
            c0937b.m(dVar.i.f());
            c0937b.k(h0.m(this.f47634a));
            c0937b.h(h0.l(this.f47634a));
            e eVar3 = new e(this.f47634a, c0937b.g(), 5, 5);
            if (eVar == null || eVar3.j() == null) {
                return;
            }
            eVar.a(eVar3.h(), eVar3.j(), responseCallback);
            return;
        }
        f("3010003");
    }

    public void h(d dVar, d.b.g0.e.a.m.e eVar) {
        p.k(new RunnableC0934a(dVar, eVar), "execAdRequest");
    }

    public void i(d.b.g0.e.a.m.b bVar) {
        this.f47635b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f47636c = z;
    }
}

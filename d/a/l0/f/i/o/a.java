package d.a.l0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import d.a.l0.f.i.o.c;
import d.a.l0.f.i.r.h;
import d.a.l0.f.i.r.i;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f46763a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.f.i.l.b f46764b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46765c;

    /* renamed from: d.a.l0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0983a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46766e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.f.i.l.g f46767f;

        /* renamed from: d.a.l0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0984a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f46769a = 0;

            /* renamed from: d.a.l0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0985a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f46771e;

                public RunnableC0985a(AdElementInfo adElementInfo) {
                    this.f46771e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f46764b != null) {
                        a.this.f46764b.c(this.f46771e);
                    }
                }
            }

            public C0984a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                RunnableC0983a runnableC0983a = RunnableC0983a.this;
                a.this.j(runnableC0983a.f46766e, "requestSuccess", runnableC0983a.f46767f);
                if (adResponseInfo == null) {
                    a.this.g("200000");
                } else if (adResponseInfo.a().size() <= 0) {
                    if (!a.this.f46765c) {
                        RunnableC0983a runnableC0983a2 = RunnableC0983a.this;
                        a.this.j(runnableC0983a2.f46766e, "requestNoAd", runnableC0983a2.f46767f);
                    }
                    if (this.f46769a == 1 && RunnableC0983a.this.f46766e.f46799i.c() == "video" && i.h()) {
                        RunnableC0983a runnableC0983a3 = RunnableC0983a.this;
                        a.this.h(runnableC0983a3.f46767f, runnableC0983a3.f46766e, this);
                        return;
                    }
                    this.f46769a = 0;
                    String b2 = adResponseInfo.b();
                    if (b2.equals("0")) {
                        b2 = "201000";
                    }
                    a.this.g(b2);
                } else {
                    d.a.l0.f.i.r.d.c(new RunnableC0985a(adResponseInfo.c()));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i2) {
                if (response != null && response.body() != null) {
                    this.f46769a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f46765c) {
                                return new AdResponseInfo(string, a.this.f46765c);
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
                a.this.g("3010002");
                RunnableC0983a runnableC0983a = RunnableC0983a.this;
                a.this.j(runnableC0983a.f46766e, "requestFail", runnableC0983a.f46767f);
            }
        }

        public RunnableC0983a(e eVar, d.a.l0.f.i.l.g gVar) {
            this.f46766e = eVar;
            this.f46767f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.f46766e;
            if (eVar == null || eVar.f46799i == null) {
                return;
            }
            C0984a c0984a = new C0984a();
            if (NetworkUtils.f(a.this.f46763a)) {
                if (a.this.f46765c) {
                    e eVar2 = this.f46766e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f46767f == null || fVar.i() == null) {
                            return;
                        }
                        this.f46767f.a(fVar.g(), fVar.i(), c0984a);
                        return;
                    }
                }
                a.this.f46765c = false;
                String g2 = this.f46766e.g();
                d.a.l0.f.i.l.g gVar = this.f46767f;
                if (gVar != null) {
                    gVar.e(g2, c0984a);
                }
                a.this.j(this.f46766e, "request", this.f46767f);
                return;
            }
            a.this.g("3010003");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46773e;

        public b(String str) {
            this.f46773e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46764b != null) {
                a.this.f46764b.a(this.f46773e);
            }
        }
    }

    public a(Context context) {
        this.f46763a = context;
    }

    public final void g(String str) {
        d.a.l0.f.i.r.d.c(new b(str));
    }

    public void h(d.a.l0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (NetworkUtils.f(this.f46763a)) {
            this.f46765c = true;
            if (eVar instanceof f) {
                f fVar = (f) eVar;
                if (gVar == null || fVar.i() == null) {
                    return;
                }
                gVar.a(fVar.g(), fVar.i(), responseCallback);
                return;
            }
            c.b bVar = new c.b();
            bVar.m(i.c());
            bVar.j(i.d());
            bVar.o(eVar.f46799i.g());
            bVar.l(h.i(this.f46763a));
            bVar.i(h.h(this.f46763a));
            f fVar2 = new f(this.f46763a, bVar.h(), 5, 5);
            if (gVar == null || fVar2.i() == null) {
                return;
            }
            gVar.a(fVar2.g(), fVar2.i(), responseCallback);
            return;
        }
        g("3010003");
    }

    public void i(e eVar, d.a.l0.f.i.l.g gVar) {
        d.a.l0.f.i.r.c.d(new RunnableC0983a(eVar, gVar), "execAdRequest");
    }

    public final void j(e eVar, String str, d.a.l0.f.i.l.g gVar) {
        d.a.l0.f.i.q.b.n(str, d.a.l0.f.i.q.b.a(eVar.f46799i.c(), eVar.f46799i.f(), eVar.f46799i.e(), eVar.f46799i.b(), false), gVar);
    }

    public void k(d.a.l0.f.i.l.b bVar) {
        this.f46764b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f46765c = z;
    }
}

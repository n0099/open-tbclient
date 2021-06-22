package d.a.m0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import d.a.m0.f.i.o.c;
import d.a.m0.f.i.r.h;
import d.a.m0.f.i.r.i;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f50545a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.f.i.l.b f50546b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50547c;

    /* renamed from: d.a.m0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1042a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50548e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.f.i.l.g f50549f;

        /* renamed from: d.a.m0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1043a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f50551a = 0;

            /* renamed from: d.a.m0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC1044a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f50553e;

                public RunnableC1044a(AdElementInfo adElementInfo) {
                    this.f50553e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f50546b != null) {
                        a.this.f50546b.c(this.f50553e);
                    }
                }
            }

            public C1043a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                RunnableC1042a runnableC1042a = RunnableC1042a.this;
                a.this.j(runnableC1042a.f50548e, "requestSuccess", runnableC1042a.f50549f);
                if (adResponseInfo == null) {
                    a.this.g("200000");
                } else if (adResponseInfo.a().size() <= 0) {
                    if (!a.this.f50547c) {
                        RunnableC1042a runnableC1042a2 = RunnableC1042a.this;
                        a.this.j(runnableC1042a2.f50548e, "requestNoAd", runnableC1042a2.f50549f);
                    }
                    if (this.f50551a == 1 && RunnableC1042a.this.f50548e.f50581i.c() == "video" && i.h()) {
                        RunnableC1042a runnableC1042a3 = RunnableC1042a.this;
                        a.this.h(runnableC1042a3.f50549f, runnableC1042a3.f50548e, this);
                        return;
                    }
                    this.f50551a = 0;
                    String b2 = adResponseInfo.b();
                    if (b2.equals("0")) {
                        b2 = "201000";
                    }
                    a.this.g(b2);
                } else {
                    d.a.m0.f.i.r.d.c(new RunnableC1044a(adResponseInfo.c()));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i2) {
                if (response != null && response.body() != null) {
                    this.f50551a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f50547c) {
                                return new AdResponseInfo(string, a.this.f50547c);
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
                RunnableC1042a runnableC1042a = RunnableC1042a.this;
                a.this.j(runnableC1042a.f50548e, "requestFail", runnableC1042a.f50549f);
            }
        }

        public RunnableC1042a(e eVar, d.a.m0.f.i.l.g gVar) {
            this.f50548e = eVar;
            this.f50549f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.f50548e;
            if (eVar == null || eVar.f50581i == null) {
                return;
            }
            C1043a c1043a = new C1043a();
            if (NetworkUtils.f(a.this.f50545a)) {
                if (a.this.f50547c) {
                    e eVar2 = this.f50548e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f50549f == null || fVar.i() == null) {
                            return;
                        }
                        this.f50549f.a(fVar.g(), fVar.i(), c1043a);
                        return;
                    }
                }
                a.this.f50547c = false;
                String g2 = this.f50548e.g();
                d.a.m0.f.i.l.g gVar = this.f50549f;
                if (gVar != null) {
                    gVar.e(g2, c1043a);
                }
                a.this.j(this.f50548e, "request", this.f50549f);
                return;
            }
            a.this.g("3010003");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50555e;

        public b(String str) {
            this.f50555e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f50546b != null) {
                a.this.f50546b.a(this.f50555e);
            }
        }
    }

    public a(Context context) {
        this.f50545a = context;
    }

    public final void g(String str) {
        d.a.m0.f.i.r.d.c(new b(str));
    }

    public void h(d.a.m0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (NetworkUtils.f(this.f50545a)) {
            this.f50547c = true;
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
            bVar.o(eVar.f50581i.g());
            bVar.l(h.i(this.f50545a));
            bVar.i(h.h(this.f50545a));
            f fVar2 = new f(this.f50545a, bVar.h(), 5, 5);
            if (gVar == null || fVar2.i() == null) {
                return;
            }
            gVar.a(fVar2.g(), fVar2.i(), responseCallback);
            return;
        }
        g("3010003");
    }

    public void i(e eVar, d.a.m0.f.i.l.g gVar) {
        d.a.m0.f.i.r.c.d(new RunnableC1042a(eVar, gVar), "execAdRequest");
    }

    public final void j(e eVar, String str, d.a.m0.f.i.l.g gVar) {
        d.a.m0.f.i.q.b.n(str, d.a.m0.f.i.q.b.a(eVar.f50581i.c(), eVar.f50581i.f(), eVar.f50581i.e(), eVar.f50581i.b(), false), gVar);
    }

    public void k(d.a.m0.f.i.l.b bVar) {
        this.f50546b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f50547c = z;
    }
}

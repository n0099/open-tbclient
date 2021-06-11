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
    public Context f50437a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.f.i.l.b f50438b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50439c;

    /* renamed from: d.a.l0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1039a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f50440e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.f.i.l.g f50441f;

        /* renamed from: d.a.l0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1040a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f50443a = 0;

            /* renamed from: d.a.l0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC1041a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f50445e;

                public RunnableC1041a(AdElementInfo adElementInfo) {
                    this.f50445e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f50438b != null) {
                        a.this.f50438b.c(this.f50445e);
                    }
                }
            }

            public C1040a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                RunnableC1039a runnableC1039a = RunnableC1039a.this;
                a.this.j(runnableC1039a.f50440e, "requestSuccess", runnableC1039a.f50441f);
                if (adResponseInfo == null) {
                    a.this.g("200000");
                } else if (adResponseInfo.a().size() <= 0) {
                    if (!a.this.f50439c) {
                        RunnableC1039a runnableC1039a2 = RunnableC1039a.this;
                        a.this.j(runnableC1039a2.f50440e, "requestNoAd", runnableC1039a2.f50441f);
                    }
                    if (this.f50443a == 1 && RunnableC1039a.this.f50440e.f50473i.c() == "video" && i.h()) {
                        RunnableC1039a runnableC1039a3 = RunnableC1039a.this;
                        a.this.h(runnableC1039a3.f50441f, runnableC1039a3.f50440e, this);
                        return;
                    }
                    this.f50443a = 0;
                    String b2 = adResponseInfo.b();
                    if (b2.equals("0")) {
                        b2 = "201000";
                    }
                    a.this.g(b2);
                } else {
                    d.a.l0.f.i.r.d.c(new RunnableC1041a(adResponseInfo.c()));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i2) {
                if (response != null && response.body() != null) {
                    this.f50443a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f50439c) {
                                return new AdResponseInfo(string, a.this.f50439c);
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
                RunnableC1039a runnableC1039a = RunnableC1039a.this;
                a.this.j(runnableC1039a.f50440e, "requestFail", runnableC1039a.f50441f);
            }
        }

        public RunnableC1039a(e eVar, d.a.l0.f.i.l.g gVar) {
            this.f50440e = eVar;
            this.f50441f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.f50440e;
            if (eVar == null || eVar.f50473i == null) {
                return;
            }
            C1040a c1040a = new C1040a();
            if (NetworkUtils.f(a.this.f50437a)) {
                if (a.this.f50439c) {
                    e eVar2 = this.f50440e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f50441f == null || fVar.i() == null) {
                            return;
                        }
                        this.f50441f.a(fVar.g(), fVar.i(), c1040a);
                        return;
                    }
                }
                a.this.f50439c = false;
                String g2 = this.f50440e.g();
                d.a.l0.f.i.l.g gVar = this.f50441f;
                if (gVar != null) {
                    gVar.e(g2, c1040a);
                }
                a.this.j(this.f50440e, "request", this.f50441f);
                return;
            }
            a.this.g("3010003");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50447e;

        public b(String str) {
            this.f50447e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f50438b != null) {
                a.this.f50438b.a(this.f50447e);
            }
        }
    }

    public a(Context context) {
        this.f50437a = context;
    }

    public final void g(String str) {
        d.a.l0.f.i.r.d.c(new b(str));
    }

    public void h(d.a.l0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (NetworkUtils.f(this.f50437a)) {
            this.f50439c = true;
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
            bVar.o(eVar.f50473i.g());
            bVar.l(h.i(this.f50437a));
            bVar.i(h.h(this.f50437a));
            f fVar2 = new f(this.f50437a, bVar.h(), 5, 5);
            if (gVar == null || fVar2.i() == null) {
                return;
            }
            gVar.a(fVar2.g(), fVar2.i(), responseCallback);
            return;
        }
        g("3010003");
    }

    public void i(e eVar, d.a.l0.f.i.l.g gVar) {
        d.a.l0.f.i.r.c.d(new RunnableC1039a(eVar, gVar), "execAdRequest");
    }

    public final void j(e eVar, String str, d.a.l0.f.i.l.g gVar) {
        d.a.l0.f.i.q.b.n(str, d.a.l0.f.i.q.b.a(eVar.f50473i.c(), eVar.f50473i.f(), eVar.f50473i.e(), eVar.f50473i.b(), false), gVar);
    }

    public void k(d.a.l0.f.i.l.b bVar) {
        this.f50438b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f50439c = z;
    }
}

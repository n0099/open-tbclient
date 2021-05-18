package d.a.i0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import d.a.i0.f.i.o.c;
import d.a.i0.f.i.r.h;
import d.a.i0.f.i.r.i;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f46587a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.f.i.l.b f46588b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46589c;

    /* renamed from: d.a.i0.f.i.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0972a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.f.i.l.g f46591f;

        /* renamed from: d.a.i0.f.i.o.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0973a extends ResponseCallback<AdResponseInfo> {

            /* renamed from: a  reason: collision with root package name */
            public int f46593a = 0;

            /* renamed from: d.a.i0.f.i.o.a$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0974a implements Runnable {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdElementInfo f46595e;

                public RunnableC0974a(AdElementInfo adElementInfo) {
                    this.f46595e = adElementInfo;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f46588b != null) {
                        a.this.f46588b.c(this.f46595e);
                    }
                }
            }

            public C0973a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: a */
            public void onSuccess(AdResponseInfo adResponseInfo, int i2) {
                RunnableC0972a runnableC0972a = RunnableC0972a.this;
                a.this.j(runnableC0972a.f46590e, "requestSuccess", runnableC0972a.f46591f);
                if (adResponseInfo == null) {
                    a.this.g("200000");
                } else if (adResponseInfo.a().size() <= 0) {
                    if (!a.this.f46589c) {
                        RunnableC0972a runnableC0972a2 = RunnableC0972a.this;
                        a.this.j(runnableC0972a2.f46590e, "requestNoAd", runnableC0972a2.f46591f);
                    }
                    if (this.f46593a == 1 && RunnableC0972a.this.f46590e.f46623i.c() == "video" && i.h()) {
                        RunnableC0972a runnableC0972a3 = RunnableC0972a.this;
                        a.this.h(runnableC0972a3.f46591f, runnableC0972a3.f46590e, this);
                        return;
                    }
                    this.f46593a = 0;
                    String b2 = adResponseInfo.b();
                    if (b2.equals("0")) {
                        b2 = "201000";
                    }
                    a.this.g(b2);
                } else {
                    d.a.i0.f.i.r.d.c(new RunnableC0974a(adResponseInfo.c()));
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            /* renamed from: b */
            public AdResponseInfo parseResponse(Response response, int i2) {
                if (response != null && response.body() != null) {
                    this.f46593a++;
                    if (!response.isSuccessful()) {
                        return null;
                    }
                    try {
                        String string = response.body().string();
                        if (!TextUtils.isEmpty(string)) {
                            if (a.this.f46589c) {
                                return new AdResponseInfo(string, a.this.f46589c);
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
                RunnableC0972a runnableC0972a = RunnableC0972a.this;
                a.this.j(runnableC0972a.f46590e, "requestFail", runnableC0972a.f46591f);
            }
        }

        public RunnableC0972a(e eVar, d.a.i0.f.i.l.g gVar) {
            this.f46590e = eVar;
            this.f46591f = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.f46590e;
            if (eVar == null || eVar.f46623i == null) {
                return;
            }
            C0973a c0973a = new C0973a();
            if (NetworkUtils.f(a.this.f46587a)) {
                if (a.this.f46589c) {
                    e eVar2 = this.f46590e;
                    if (eVar2 instanceof f) {
                        f fVar = (f) eVar2;
                        if (this.f46591f == null || fVar.i() == null) {
                            return;
                        }
                        this.f46591f.a(fVar.g(), fVar.i(), c0973a);
                        return;
                    }
                }
                a.this.f46589c = false;
                String g2 = this.f46590e.g();
                d.a.i0.f.i.l.g gVar = this.f46591f;
                if (gVar != null) {
                    gVar.e(g2, c0973a);
                }
                a.this.j(this.f46590e, "request", this.f46591f);
                return;
            }
            a.this.g("3010003");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46597e;

        public b(String str) {
            this.f46597e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f46588b != null) {
                a.this.f46588b.a(this.f46597e);
            }
        }
    }

    public a(Context context) {
        this.f46587a = context;
    }

    public final void g(String str) {
        d.a.i0.f.i.r.d.c(new b(str));
    }

    public void h(d.a.i0.f.i.l.g gVar, e eVar, ResponseCallback<AdResponseInfo> responseCallback) {
        if (NetworkUtils.f(this.f46587a)) {
            this.f46589c = true;
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
            bVar.o(eVar.f46623i.g());
            bVar.l(h.i(this.f46587a));
            bVar.i(h.h(this.f46587a));
            f fVar2 = new f(this.f46587a, bVar.h(), 5, 5);
            if (gVar == null || fVar2.i() == null) {
                return;
            }
            gVar.a(fVar2.g(), fVar2.i(), responseCallback);
            return;
        }
        g("3010003");
    }

    public void i(e eVar, d.a.i0.f.i.l.g gVar) {
        d.a.i0.f.i.r.c.d(new RunnableC0972a(eVar, gVar), "execAdRequest");
    }

    public final void j(e eVar, String str, d.a.i0.f.i.l.g gVar) {
        d.a.i0.f.i.q.b.n(str, d.a.i0.f.i.q.b.a(eVar.f46623i.c(), eVar.f46623i.f(), eVar.f46623i.e(), eVar.f46623i.b(), false), gVar);
    }

    public void k(d.a.i0.f.i.l.b bVar) {
        this.f46588b = bVar;
    }

    public a(Context context, boolean z) {
        this(context);
        this.f46589c = z;
    }
}

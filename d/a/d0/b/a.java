package d.a.d0.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.prologue.business.data.ParseError;
import com.baidu.prologue.service.network.Als;
import com.baidu.prologue.service.network.Request;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.qq.e.comm.constants.Constants;
import d.a.d0.a.c.g;
import d.a.d0.b.g.h;
import d.a.d0.b.g.j;
import d.a.d0.d.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.d0.b.c f43289b;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f43288a = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f43290c = new RunnableC0576a();

    /* renamed from: d  reason: collision with root package name */
    public int f43291d = 5000;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f43292e = false;

    /* renamed from: d.a.d0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0576a implements Runnable {
        public RunnableC0576a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f43292e = true;
            g.f43285a.e("Afd", "执行超时回调");
            h l = d.a.d0.b.g.f.l();
            if (a.this.f43289b == null) {
                return;
            }
            if (l != null) {
                a.this.f43289b.b(l);
            } else {
                a.this.f43289b.a(new Throwable("no ad"));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.a.b.a f43294a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f43295b;

        public b(d.a.d0.a.b.a aVar, long j) {
            this.f43294a = aVar;
            this.f43295b = j;
        }

        @Override // d.a.d0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f43285a;
            gVar.e("Afd", "update接口 " + th.getMessage());
            a.this.k(this.f43294a, this.f43295b, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.this.k(this.f43294a, this.f43295b, "200", IMTrack.DbBuilder.ACTION_UPDATE);
            try {
                d.a.d0.b.g.a.b(str, this.f43294a.l());
            } catch (ParseError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.a.b.a f43297a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f43298b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.b.c f43299c;

        public c(d.a.d0.a.b.a aVar, long j, d.a.d0.b.c cVar) {
            this.f43297a = aVar;
            this.f43298b = j;
            this.f43299c = cVar;
        }

        @Override // d.a.d0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f43285a;
            gVar.e("Afd", "query接口 " + th.getMessage());
            a.this.k(this.f43297a, this.f43298b, th.getMessage(), "query");
            if (!a.this.f43292e) {
                if (a.this.f43288a != null) {
                    a.this.f43288a.removeCallbacksAndMessages(null);
                    a.this.f43288a.post(a.this.f43290c);
                    return;
                }
                return;
            }
            g gVar2 = g.f43285a;
            StringBuilder sb = new StringBuilder();
            sb.append("query接口 error 超时：");
            sb.append(System.currentTimeMillis() - this.f43298b);
            sb.append(" cause : ");
            sb.append(th);
            gVar2.e("Afd", sb.toString() == null ? "unknow" : th.getMessage());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.this.k(this.f43297a, this.f43298b, "200", "query");
            if (!a.this.f43292e) {
                a.this.f43288a.removeCallbacksAndMessages(null);
                try {
                    List<h> b2 = d.a.d0.b.g.a.b(str, this.f43297a.l());
                    if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                        this.f43299c.b(b2.get(0));
                    } else {
                        this.f43299c.a(new Throwable("no ad"));
                    }
                    return;
                } catch (ParseError e2) {
                    e2.printStackTrace();
                    this.f43299c.a(e2);
                    return;
                }
            }
            g gVar = g.f43285a;
            gVar.e("Afd", "query接口 response 超时：" + (System.currentTimeMillis() - this.f43298b));
        }
    }

    public final void g(Request.c cVar, d.a.d0.a.b.a aVar) {
        cVar.j("ver", aVar.D());
        cVar.j("sv", "1.0");
        cVar.j("uid", aVar.w());
        cVar.j("bdid", aVar.k());
        cVar.j("cuid", aVar.f());
        cVar.j(SearchJsBridge.COOKIE_MOD, aVar.q());
        cVar.j(SearchJsBridge.COOKIE_OV, aVar.g());
        cVar.j("imei", aVar.C());
        cVar.j("ua", aVar.n());
        cVar.j("fmt", "json");
        cVar.j("coot", aVar.j());
        cVar.j("lgt", aVar.x()[0]);
        cVar.j(SuggestAddrField.KEY_LAT, aVar.x()[1]);
        cVar.j("apna", aVar.i());
        cVar.j("eid", aVar.y());
        cVar.j("st", "1");
        cVar.j("ot", "2");
        cVar.j("nt", String.valueOf(new d.a.d0.d.a.f(aVar.o()).d()));
        cVar.j(Config.EXCEPTION_CRASH_TYPE, "2");
        cVar.j("is_https", "1");
        cVar.j(IAdRequestParam.ANDROID_ID, aVar.a());
        cVar.j("from", aVar.from());
        cVar.j("cfrom", aVar.b());
        cVar.k("User-Agent", aVar.h());
        if (TextUtils.isEmpty(aVar.m())) {
            return;
        }
        cVar.j("oaid", aVar.m());
    }

    public final void h(Request.c cVar, String str, d.a.d0.a.b.a aVar, long j) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.APP_KEY, "cmd");
            jSONObject.put("v", str);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            List<h> p = d.a.d0.b.g.f.p();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (p != null && p.size() > 0) {
                for (h hVar : p) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Config.APP_KEY, hVar.f43341c);
                    if (!TextUtils.isEmpty(hVar.f43341c)) {
                        int e2 = d.a.d0.b.g.f.e(hVar);
                        Log.e("Afd", "onAdSuccess: " + e2);
                        if (e2 == 0) {
                            arrayList.add(hVar.f43341c);
                        }
                    }
                    jSONObject3.put(r.f7715a, String.valueOf(hVar.w));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", j.b());
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(Config.APP_KEY, Constants.KEYS.AD_INFO);
            jSONObject4.put("v", jSONObject2.toString());
            jSONArray.put(jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(Config.APP_KEY, "ukey");
            jSONObject5.put("v", TextUtils.join(",", arrayList));
            jSONArray.put(jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(Config.APP_KEY, "logid");
            jSONObject6.put("v", d.a.d0.a.c.f.c(aVar.f() + j));
            jSONArray.put(jSONObject6);
            cVar.j("ext", jSONArray.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public final Request.c i(d.a.d0.a.b.a aVar, String str, String str2, long j) {
        String a2 = d.a.d0.a.a.a.a();
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query");
        Request.c cVar = new Request.c(aVar.o(), sb.toString());
        cVar.j("ac", "3");
        cVar.j("pid", str2);
        cVar.j("product_id ", aVar.p());
        g(cVar, aVar);
        h(cVar, str, aVar, j);
        return cVar;
    }

    public void j(d.a.d0.a.b.a aVar, d.a.d0.b.c cVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c i2 = i(aVar, "query", aVar.l(), currentTimeMillis);
        i2.o(true);
        i2.m();
        i2.l().e(new c(aVar, currentTimeMillis, cVar));
        this.f43289b = cVar;
        this.f43292e = false;
        int t = aVar.t() - d.a.d0.b.g.g.d();
        this.f43291d = t;
        Handler handler = this.f43288a;
        if (handler != null) {
            handler.postDelayed(this.f43290c, t);
        }
    }

    public final void k(d.a.d0.a.b.a aVar, long j, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Als.f(d.a.d0.a.c.f.c(aVar.f() + j), aVar.l(), str, currentTimeMillis, str2);
    }

    public void l(d.a.d0.a.b.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c i2 = i(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.l(), currentTimeMillis);
        i2.m();
        i2.l().e(new b(aVar, currentTimeMillis));
    }
}

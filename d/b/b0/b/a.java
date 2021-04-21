package d.b.b0.b;

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
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.qq.e.comm.constants.Constants;
import d.b.b0.a.c.g;
import d.b.b0.b.f.i;
import d.b.b0.d.a.f;
import d.b.b0.d.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.b0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0565a implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.b0.a.b.a f42123a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f42124b;

        public C0565a(d.b.b0.a.b.a aVar, long j) {
            this.f42123a = aVar;
            this.f42124b = j;
        }

        @Override // d.b.b0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f42120a;
            gVar.e("Afd", "update接口 " + th.getMessage());
            a.f(this.f42123a, this.f42124b, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.f(this.f42123a, this.f42124b, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
            try {
                d.b.b0.b.f.a.b(str, this.f42123a.v());
            } catch (ParseError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.b0.a.b.a f42125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f42126b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f42127c;

        public b(d.b.b0.a.b.a aVar, long j, c cVar) {
            this.f42125a = aVar;
            this.f42126b = j;
            this.f42127c = cVar;
        }

        @Override // d.b.b0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f42120a;
            gVar.e("Afd", "query接口 " + th.getMessage());
            this.f42127c.b(th);
            a.f(this.f42125a, this.f42126b, th.getMessage(), "query");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.f(this.f42125a, this.f42126b, BasicPushStatus.SUCCESS_CODE, "query");
            try {
                List<d.b.b0.b.f.g> b2 = d.b.b0.b.f.a.b(str, this.f42125a.v());
                if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                    this.f42127c.a(b2.get(0));
                } else {
                    this.f42127c.b(new Throwable("no ad"));
                }
            } catch (ParseError e2) {
                e2.printStackTrace();
                this.f42127c.b(e2);
            }
        }
    }

    public static void b(Request.c cVar, d.b.b0.a.b.a aVar) {
        cVar.j("ver", aVar.t());
        cVar.j("sv", "1.0");
        cVar.j("uid", aVar.c());
        cVar.j("bdid", aVar.u());
        cVar.j("cuid", aVar.j());
        cVar.j("mod", aVar.A());
        cVar.j("ov", aVar.k());
        cVar.j("imei", aVar.s());
        cVar.j("ua", aVar.x());
        cVar.j("fmt", "json");
        cVar.j("coot", aVar.q());
        cVar.j("lgt", aVar.i()[0]);
        cVar.j(SuggestAddrField.KEY_LAT, aVar.i()[1]);
        cVar.j("apna", aVar.p());
        cVar.j("eid", aVar.m());
        cVar.j("st", "1");
        cVar.j("ot", "2");
        cVar.j("nt", String.valueOf(new f(aVar.y()).d()));
        cVar.j(Config.EXCEPTION_CRASH_TYPE, "2");
        cVar.j("is_https", "1");
        cVar.j(IAdRequestParam.ANDROID_ID, aVar.d());
        cVar.j("from", aVar.from());
        cVar.j("cfrom", aVar.e());
        cVar.k("User-Agent", aVar.l());
        if (TextUtils.isEmpty(aVar.w())) {
            return;
        }
        cVar.j("oaid", aVar.w());
    }

    public static void c(Request.c cVar, String str, d.b.b0.a.b.a aVar, long j) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.APP_KEY, "cmd");
            jSONObject.put("v", str);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            List<d.b.b0.b.f.g> n = d.b.b0.b.f.f.n();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (n != null && n.size() > 0) {
                for (d.b.b0.b.f.g gVar : n) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Config.APP_KEY, gVar.f42163c);
                    if (!TextUtils.isEmpty(gVar.f42163c)) {
                        int e2 = d.b.b0.b.f.f.e(gVar);
                        Log.e("Afd", "onAdSuccess: " + e2);
                        if (e2 == 0) {
                            arrayList.add(gVar.f42163c);
                        }
                    }
                    jSONObject3.put(r.f7699a, String.valueOf(gVar.w));
                    jSONArray2.put(jSONObject3);
                }
            }
            jSONObject2.put("d", jSONArray2);
            jSONObject2.put("s", i.b());
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
            jSONObject6.put("v", d.b.b0.a.c.f.c(aVar.j() + j));
            jSONArray.put(jSONObject6);
            cVar.j("ext", jSONArray.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static Request.c d(d.b.b0.a.b.a aVar, String str, String str2, long j) {
        String a2 = d.b.b0.a.a.a.a();
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query");
        Request.c cVar = new Request.c(aVar.y(), sb.toString());
        cVar.j("ac", "3");
        cVar.j("pid", str2);
        cVar.j("product_id ", aVar.z());
        b(cVar, aVar);
        c(cVar, str, aVar, j);
        return cVar;
    }

    public static void e(d.b.b0.a.b.a aVar, c cVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c d2 = d(aVar, "query", aVar.v(), currentTimeMillis);
        d2.o(true);
        d2.m();
        d2.l().e(new b(aVar, currentTimeMillis, cVar));
    }

    public static void f(d.b.b0.a.b.a aVar, long j, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Als.f(d.b.b0.a.c.f.c(aVar.j() + j), aVar.v(), str, currentTimeMillis, str2);
    }

    public static void g(d.b.b0.a.b.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c d2 = d(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.v(), currentTimeMillis);
        d2.m();
        d2.l().e(new C0565a(aVar, currentTimeMillis));
    }
}

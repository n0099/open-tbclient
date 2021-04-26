package d.a.b0.b;

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
import d.a.b0.a.c.g;
import d.a.b0.b.f.i;
import d.a.b0.d.a.f;
import d.a.b0.d.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.b0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0504a implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.b0.a.b.a f39305a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f39306b;

        public C0504a(d.a.b0.a.b.a aVar, long j) {
            this.f39305a = aVar;
            this.f39306b = j;
        }

        @Override // d.a.b0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f39302a;
            gVar.e("Afd", "update接口 " + th.getMessage());
            a.f(this.f39305a, this.f39306b, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.b0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.f(this.f39305a, this.f39306b, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
            try {
                d.a.b0.b.f.a.b(str, this.f39305a.l());
            } catch (ParseError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.b0.a.b.a f39307a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f39308b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f39309c;

        public b(d.a.b0.a.b.a aVar, long j, c cVar) {
            this.f39307a = aVar;
            this.f39308b = j;
            this.f39309c = cVar;
        }

        @Override // d.a.b0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f39302a;
            gVar.e("Afd", "query接口 " + th.getMessage());
            this.f39309c.a(th);
            a.f(this.f39307a, this.f39308b, th.getMessage(), "query");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.b0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.f(this.f39307a, this.f39308b, BasicPushStatus.SUCCESS_CODE, "query");
            try {
                List<d.a.b0.b.f.g> b2 = d.a.b0.b.f.a.b(str, this.f39307a.l());
                if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                    this.f39309c.b(b2.get(0));
                } else {
                    this.f39309c.a(new Throwable("no ad"));
                }
            } catch (ParseError e2) {
                e2.printStackTrace();
                this.f39309c.a(e2);
            }
        }
    }

    public static void b(Request.c cVar, d.a.b0.a.b.a aVar) {
        cVar.j("ver", aVar.D());
        cVar.j("sv", "1.0");
        cVar.j("uid", aVar.w());
        cVar.j("bdid", aVar.k());
        cVar.j("cuid", aVar.f());
        cVar.j("mod", aVar.q());
        cVar.j("ov", aVar.g());
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
        cVar.j("nt", String.valueOf(new f(aVar.o()).d()));
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

    public static void c(Request.c cVar, String str, d.a.b0.a.b.a aVar, long j) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.APP_KEY, "cmd");
            jSONObject.put("v", str);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            List<d.a.b0.b.f.g> n = d.a.b0.b.f.f.n();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (n != null && n.size() > 0) {
                for (d.a.b0.b.f.g gVar : n) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Config.APP_KEY, gVar.f39346c);
                    if (!TextUtils.isEmpty(gVar.f39346c)) {
                        int e2 = d.a.b0.b.f.f.e(gVar);
                        Log.e("Afd", "onAdSuccess: " + e2);
                        if (e2 == 0) {
                            arrayList.add(gVar.f39346c);
                        }
                    }
                    jSONObject3.put(r.f7975a, String.valueOf(gVar.w));
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
            jSONObject6.put("v", d.a.b0.a.c.f.c(aVar.f() + j));
            jSONArray.put(jSONObject6);
            cVar.j("ext", jSONArray.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static Request.c d(d.a.b0.a.b.a aVar, String str, String str2, long j) {
        String a2 = d.a.b0.a.a.a.a();
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(TextUtils.equals(str, IMTrack.DbBuilder.ACTION_UPDATE) ? "?action=update" : "?action=query");
        Request.c cVar = new Request.c(aVar.o(), sb.toString());
        cVar.j("ac", "3");
        cVar.j("pid", str2);
        cVar.j("product_id ", aVar.p());
        b(cVar, aVar);
        c(cVar, str, aVar, j);
        return cVar;
    }

    public static void e(d.a.b0.a.b.a aVar, c cVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c d2 = d(aVar, "query", aVar.l(), currentTimeMillis);
        d2.o(true);
        d2.m();
        d2.l().e(new b(aVar, currentTimeMillis, cVar));
    }

    public static void f(d.a.b0.a.b.a aVar, long j, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Als.f(d.a.b0.a.c.f.c(aVar.f() + j), aVar.l(), str, currentTimeMillis, str2);
    }

    public static void g(d.a.b0.a.b.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c d2 = d(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.l(), currentTimeMillis);
        d2.m();
        d2.l().e(new C0504a(aVar, currentTimeMillis));
    }
}

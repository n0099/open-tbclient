package d.b.a0.b;

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
import d.b.a0.a.c.g;
import d.b.a0.b.f.i;
import d.b.a0.d.a.f;
import d.b.a0.d.a.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.b.a0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0546a implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.a.b.a f41834a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f41835b;

        public C0546a(d.b.a0.a.b.a aVar, long j) {
            this.f41834a = aVar;
            this.f41835b = j;
        }

        @Override // d.b.a0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f41831a;
            gVar.e("Afd", "update接口 " + th.getMessage());
            a.f(this.f41834a, this.f41835b, th.getMessage(), IMTrack.DbBuilder.ACTION_UPDATE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.f(this.f41834a, this.f41835b, BasicPushStatus.SUCCESS_CODE, IMTrack.DbBuilder.ACTION_UPDATE);
            try {
                d.b.a0.b.f.a.b(str, this.f41834a.v());
            } catch (ParseError e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.a0.a.b.a f41836a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f41837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f41838c;

        public b(d.b.a0.a.b.a aVar, long j, c cVar) {
            this.f41836a = aVar;
            this.f41837b = j;
            this.f41838c = cVar;
        }

        @Override // d.b.a0.d.a.i
        public void a(Throwable th) {
            g gVar = g.f41831a;
            gVar.e("Afd", "query接口 " + th.getMessage());
            this.f41838c.b(th);
            a.f(this.f41836a, this.f41837b, th.getMessage(), "query");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a0.d.a.i
        /* renamed from: c */
        public void b(String str) {
            a.f(this.f41836a, this.f41837b, BasicPushStatus.SUCCESS_CODE, "query");
            try {
                List<d.b.a0.b.f.g> b2 = d.b.a0.b.f.a.b(str, this.f41836a.v());
                if (b2 != null && b2.size() > 0 && b2.get(0) != null) {
                    this.f41838c.a(b2.get(0));
                } else {
                    this.f41838c.b(new Throwable("no ad"));
                }
            } catch (ParseError e2) {
                e2.printStackTrace();
                this.f41838c.b(e2);
            }
        }
    }

    public static void b(Request.c cVar, d.b.a0.a.b.a aVar) {
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

    public static void c(Request.c cVar, String str, d.b.a0.a.b.a aVar, long j) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Config.APP_KEY, "cmd");
            jSONObject.put("v", str);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            List<d.b.a0.b.f.g> n = d.b.a0.b.f.f.n();
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = new JSONArray();
            if (n != null && n.size() > 0) {
                for (d.b.a0.b.f.g gVar : n) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(Config.APP_KEY, gVar.f41874c);
                    if (!TextUtils.isEmpty(gVar.f41874c)) {
                        int e2 = d.b.a0.b.f.f.e(gVar);
                        Log.e("Afd", "onAdSuccess: " + e2);
                        if (e2 == 0) {
                            arrayList.add(gVar.f41874c);
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
            jSONObject6.put("v", d.b.a0.a.c.f.c(aVar.j() + j));
            jSONArray.put(jSONObject6);
            cVar.j("ext", jSONArray.toString());
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static Request.c d(d.b.a0.a.b.a aVar, String str, String str2, long j) {
        String a2 = d.b.a0.a.a.a.a();
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

    public static void e(d.b.a0.a.b.a aVar, c cVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c d2 = d(aVar, "query", aVar.v(), currentTimeMillis);
        d2.o(true);
        d2.m();
        d2.l().e(new b(aVar, currentTimeMillis, cVar));
    }

    public static void f(d.b.a0.a.b.a aVar, long j, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Als.f(d.b.a0.a.c.f.c(aVar.j() + j), aVar.v(), str, currentTimeMillis, str2);
    }

    public static void g(d.b.a0.a.b.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        Request.c d2 = d(aVar, IMTrack.DbBuilder.ACTION_UPDATE, aVar.v(), currentTimeMillis);
        d2.m();
        d2.l().e(new C0546a(aVar, currentTimeMillis));
    }
}

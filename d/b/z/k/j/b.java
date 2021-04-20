package d.b.z.k.j;

import android.text.TextUtils;
import d.b.z.h;
import d.b.z.k.a.c;
import d.b.z.k.a.f;
import d.b.z.k.b.d;
import d.b.z.k.j.a;
import d.b.z.n.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public static class a extends d.b.z.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.z.k.j.a f65738a;

        public a(d.b.z.k.j.a aVar) {
            this.f65738a = aVar;
        }

        @Override // d.b.z.k.a.a
        public void b(Throwable th, String str) {
            a.C1807a c1807a = new a.C1807a();
            c1807a.f65734a = 2;
            c1807a.f65735b = g.a().getResources().getString(h.calculate_price_default_error);
            this.f65738a.a(c1807a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.z.k.a.a
        /* renamed from: c */
        public void a(String str) {
            a.C1807a c1807a = new a.C1807a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno") == 0) {
                    c1807a.f65734a = 0;
                    c1807a.f65735b = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    optJSONObject.optLong("totalAmount");
                    c1807a.f65736c = optJSONObject.optLong("userPayAmount");
                    c1807a.f65737d = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c1807a.f65734a = jSONObject.optInt("errorLevel", 2);
                    c1807a.f65735b = jSONObject.optString("msg");
                }
            } catch (Exception unused) {
                c1807a.f65734a = 2;
                c1807a.f65735b = g.a().getResources().getString(h.calculate_price_default_error);
            }
            this.f65738a.a(c1807a);
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, d.b.z.k.j.a aVar) {
        c cVar = new c();
        if (!TextUtils.isEmpty(str)) {
            cVar.e("Cookie", "BDUSS=" + str);
        }
        d.b.z.k.a.b bVar = new d.b.z.k.a.b();
        bVar.e("appKey", str2);
        bVar.e("totalAmount", str3);
        if (list != null && list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (String str4 : list) {
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        jSONArray.put(new JSONObject(str4));
                    } catch (Exception unused) {
                    }
                }
            }
            bVar.e("hostMarketingDetail", jSONArray.toString());
        }
        new f().a(d.c(), cVar, bVar, new a(aVar));
    }
}

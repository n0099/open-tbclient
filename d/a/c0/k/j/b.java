package d.a.c0.k.j;

import android.text.TextUtils;
import d.a.c0.h;
import d.a.c0.k.a.c;
import d.a.c0.k.a.f;
import d.a.c0.k.b.d;
import d.a.c0.k.j.a;
import d.a.c0.n.g;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    public static class a extends d.a.c0.k.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.c0.k.j.a f43167a;

        public a(d.a.c0.k.j.a aVar) {
            this.f43167a = aVar;
        }

        @Override // d.a.c0.k.a.a
        public void b(Throwable th, String str) {
            a.C0567a c0567a = new a.C0567a();
            c0567a.f43163a = 2;
            c0567a.f43164b = g.a().getResources().getString(h.calculate_price_default_error);
            this.f43167a.a(c0567a);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c0.k.a.a
        /* renamed from: c */
        public void a(String str) {
            a.C0567a c0567a = new a.C0567a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("errno") == 0) {
                    c0567a.f43163a = 0;
                    c0567a.f43164b = jSONObject.optString("msg");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    optJSONObject.optLong("totalAmount");
                    c0567a.f43165c = optJSONObject.optLong("userPayAmount");
                    c0567a.f43166d = optJSONObject.optString("usedhostMarketingDetail");
                } else {
                    c0567a.f43163a = jSONObject.optInt("errorLevel", 2);
                    c0567a.f43164b = jSONObject.optString("msg");
                }
            } catch (Exception unused) {
                c0567a.f43163a = 2;
                c0567a.f43164b = g.a().getResources().getString(h.calculate_price_default_error);
            }
            this.f43167a.a(c0567a);
        }
    }

    public static void a(String str, String str2, String str3, List<String> list, d.a.c0.k.j.a aVar) {
        c cVar = new c();
        if (!TextUtils.isEmpty(str)) {
            cVar.e("Cookie", "BDUSS=" + str);
        }
        d.a.c0.k.a.b bVar = new d.a.c0.k.a.b();
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

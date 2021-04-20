package d.b.z.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f65752a;

    /* renamed from: b  reason: collision with root package name */
    public List<C1810a> f65753b;

    /* renamed from: d.b.z.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1810a {

        /* renamed from: a  reason: collision with root package name */
        public int f65754a;

        /* renamed from: b  reason: collision with root package name */
        public String f65755b;

        /* renamed from: c  reason: collision with root package name */
        public String f65756c;

        /* renamed from: d  reason: collision with root package name */
        public String f65757d;

        /* renamed from: e  reason: collision with root package name */
        public String f65758e;

        /* renamed from: f  reason: collision with root package name */
        public Long f65759f;

        /* renamed from: g  reason: collision with root package name */
        public int f65760g;

        /* renamed from: h  reason: collision with root package name */
        public String f65761h;

        public C1810a() {
        }

        public C1810a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f65755b = jSONObject.optString("display_name");
            this.f65756c = jSONObject.optString("pay_text");
            this.f65758e = jSONObject.optString("icon");
            this.f65757d = jSONObject.optString("valid_info");
            this.f65761h = jSONObject.optString("host_marketing_detail");
            this.f65759f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f65760g = jSONObject.optInt("is_selected");
            this.f65754a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f65753b = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                this.f65753b.add(new C1810a(jSONObject));
            }
        }
        this.f65752a = this.f65753b.size() > 1;
    }
}

package d.a.c0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f43181a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0570a> f43182b;

    /* renamed from: d.a.c0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0570a {

        /* renamed from: a  reason: collision with root package name */
        public int f43183a;

        /* renamed from: b  reason: collision with root package name */
        public String f43184b;

        /* renamed from: c  reason: collision with root package name */
        public String f43185c;

        /* renamed from: d  reason: collision with root package name */
        public String f43186d;

        /* renamed from: e  reason: collision with root package name */
        public String f43187e;

        /* renamed from: f  reason: collision with root package name */
        public Long f43188f;

        /* renamed from: g  reason: collision with root package name */
        public int f43189g;

        /* renamed from: h  reason: collision with root package name */
        public String f43190h;

        public C0570a() {
        }

        public C0570a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f43184b = jSONObject.optString("display_name");
            this.f43185c = jSONObject.optString("pay_text");
            this.f43187e = jSONObject.optString("icon");
            this.f43186d = jSONObject.optString("valid_info");
            this.f43190h = jSONObject.optString("host_marketing_detail");
            this.f43188f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f43189g = jSONObject.optInt("is_selected");
            this.f43183a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f43182b = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
            if (jSONObject != null) {
                this.f43182b.add(new C0570a(jSONObject));
            }
        }
        this.f43181a = this.f43182b.size() > 1;
    }
}

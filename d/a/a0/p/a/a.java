package d.a.a0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f38480a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0488a> f38481b;

    /* renamed from: d.a.a0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0488a {

        /* renamed from: a  reason: collision with root package name */
        public int f38482a;

        /* renamed from: b  reason: collision with root package name */
        public String f38483b;

        /* renamed from: c  reason: collision with root package name */
        public String f38484c;

        /* renamed from: d  reason: collision with root package name */
        public String f38485d;

        /* renamed from: e  reason: collision with root package name */
        public String f38486e;

        /* renamed from: f  reason: collision with root package name */
        public Long f38487f;

        /* renamed from: g  reason: collision with root package name */
        public int f38488g;

        /* renamed from: h  reason: collision with root package name */
        public String f38489h;

        public C0488a() {
        }

        public C0488a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f38483b = jSONObject.optString("display_name");
            this.f38484c = jSONObject.optString("pay_text");
            this.f38486e = jSONObject.optString("icon");
            this.f38485d = jSONObject.optString("valid_info");
            this.f38489h = jSONObject.optString("host_marketing_detail");
            this.f38487f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f38488g = jSONObject.optInt("is_selected");
            this.f38482a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f38481b = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
            if (jSONObject != null) {
                this.f38481b.add(new C0488a(jSONObject));
            }
        }
        this.f38480a = this.f38481b.size() > 1;
    }
}

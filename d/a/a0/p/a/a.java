package d.a.a0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39235a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0501a> f39236b;

    /* renamed from: d.a.a0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0501a {

        /* renamed from: a  reason: collision with root package name */
        public int f39237a;

        /* renamed from: b  reason: collision with root package name */
        public String f39238b;

        /* renamed from: c  reason: collision with root package name */
        public String f39239c;

        /* renamed from: d  reason: collision with root package name */
        public String f39240d;

        /* renamed from: e  reason: collision with root package name */
        public String f39241e;

        /* renamed from: f  reason: collision with root package name */
        public Long f39242f;

        /* renamed from: g  reason: collision with root package name */
        public int f39243g;

        /* renamed from: h  reason: collision with root package name */
        public String f39244h;

        public C0501a() {
        }

        public C0501a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f39238b = jSONObject.optString("display_name");
            this.f39239c = jSONObject.optString("pay_text");
            this.f39241e = jSONObject.optString("icon");
            this.f39240d = jSONObject.optString("valid_info");
            this.f39244h = jSONObject.optString("host_marketing_detail");
            this.f39242f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f39243g = jSONObject.optInt("is_selected");
            this.f39237a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f39236b = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
            if (jSONObject != null) {
                this.f39236b.add(new C0501a(jSONObject));
            }
        }
        this.f39235a = this.f39236b.size() > 1;
    }
}

package d.a.c0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f43284a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0573a> f43285b;

    /* renamed from: d.a.c0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0573a {

        /* renamed from: a  reason: collision with root package name */
        public int f43286a;

        /* renamed from: b  reason: collision with root package name */
        public String f43287b;

        /* renamed from: c  reason: collision with root package name */
        public String f43288c;

        /* renamed from: d  reason: collision with root package name */
        public String f43289d;

        /* renamed from: e  reason: collision with root package name */
        public String f43290e;

        /* renamed from: f  reason: collision with root package name */
        public Long f43291f;

        /* renamed from: g  reason: collision with root package name */
        public int f43292g;

        /* renamed from: h  reason: collision with root package name */
        public String f43293h;

        public C0573a() {
        }

        public C0573a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f43287b = jSONObject.optString("display_name");
            this.f43288c = jSONObject.optString("pay_text");
            this.f43290e = jSONObject.optString("icon");
            this.f43289d = jSONObject.optString("valid_info");
            this.f43293h = jSONObject.optString("host_marketing_detail");
            this.f43291f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f43292g = jSONObject.optInt("is_selected");
            this.f43286a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f43285b = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
            if (jSONObject != null) {
                this.f43285b.add(new C0573a(jSONObject));
            }
        }
        this.f43284a = this.f43285b.size() > 1;
    }
}

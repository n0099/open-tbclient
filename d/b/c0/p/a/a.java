package d.b.c0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42684a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0573a> f42685b;

    /* renamed from: d.b.c0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0573a {

        /* renamed from: a  reason: collision with root package name */
        public int f42686a;

        /* renamed from: b  reason: collision with root package name */
        public String f42687b;

        /* renamed from: c  reason: collision with root package name */
        public String f42688c;

        /* renamed from: d  reason: collision with root package name */
        public String f42689d;

        /* renamed from: e  reason: collision with root package name */
        public String f42690e;

        /* renamed from: f  reason: collision with root package name */
        public Long f42691f;

        /* renamed from: g  reason: collision with root package name */
        public int f42692g;

        /* renamed from: h  reason: collision with root package name */
        public String f42693h;

        public C0573a() {
        }

        public C0573a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f42687b = jSONObject.optString("display_name");
            this.f42688c = jSONObject.optString("pay_text");
            this.f42690e = jSONObject.optString("icon");
            this.f42689d = jSONObject.optString("valid_info");
            this.f42693h = jSONObject.optString("host_marketing_detail");
            this.f42691f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f42692g = jSONObject.optInt("is_selected");
            this.f42686a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f42685b = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                this.f42685b.add(new C0573a(jSONObject));
            }
        }
        this.f42684a = this.f42685b.size() > 1;
    }
}

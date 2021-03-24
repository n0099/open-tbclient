package d.b.c0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42683a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0572a> f42684b;

    /* renamed from: d.b.c0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0572a {

        /* renamed from: a  reason: collision with root package name */
        public int f42685a;

        /* renamed from: b  reason: collision with root package name */
        public String f42686b;

        /* renamed from: c  reason: collision with root package name */
        public String f42687c;

        /* renamed from: d  reason: collision with root package name */
        public String f42688d;

        /* renamed from: e  reason: collision with root package name */
        public String f42689e;

        /* renamed from: f  reason: collision with root package name */
        public Long f42690f;

        /* renamed from: g  reason: collision with root package name */
        public int f42691g;

        /* renamed from: h  reason: collision with root package name */
        public String f42692h;

        public C0572a() {
        }

        public C0572a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f42686b = jSONObject.optString("display_name");
            this.f42687c = jSONObject.optString("pay_text");
            this.f42689e = jSONObject.optString("icon");
            this.f42688d = jSONObject.optString("valid_info");
            this.f42692h = jSONObject.optString("host_marketing_detail");
            this.f42690f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f42691g = jSONObject.optInt("is_selected");
            this.f42685a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f42684b = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                this.f42684b.add(new C0572a(jSONObject));
            }
        }
        this.f42683a = this.f42684b.size() > 1;
    }
}

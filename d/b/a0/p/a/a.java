package d.b.a0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f42054a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0562a> f42055b;

    /* renamed from: d.b.a0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0562a {

        /* renamed from: a  reason: collision with root package name */
        public int f42056a;

        /* renamed from: b  reason: collision with root package name */
        public String f42057b;

        /* renamed from: c  reason: collision with root package name */
        public String f42058c;

        /* renamed from: d  reason: collision with root package name */
        public String f42059d;

        /* renamed from: e  reason: collision with root package name */
        public String f42060e;

        /* renamed from: f  reason: collision with root package name */
        public Long f42061f;

        /* renamed from: g  reason: collision with root package name */
        public int f42062g;

        /* renamed from: h  reason: collision with root package name */
        public String f42063h;

        public C0562a() {
        }

        public C0562a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f42057b = jSONObject.optString("display_name");
            this.f42058c = jSONObject.optString("pay_text");
            this.f42060e = jSONObject.optString("icon");
            this.f42059d = jSONObject.optString("valid_info");
            this.f42063h = jSONObject.optString("host_marketing_detail");
            this.f42061f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f42062g = jSONObject.optInt("is_selected");
            this.f42056a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f42055b = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
            if (jSONObject != null) {
                this.f42055b.add(new C0562a(jSONObject));
            }
        }
        this.f42054a = this.f42055b.size() > 1;
    }
}

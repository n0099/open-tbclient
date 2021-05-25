package d.a.c0.p.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f39500a;

    /* renamed from: b  reason: collision with root package name */
    public List<C0514a> f39501b;

    /* renamed from: d.a.c0.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0514a {

        /* renamed from: a  reason: collision with root package name */
        public int f39502a;

        /* renamed from: b  reason: collision with root package name */
        public String f39503b;

        /* renamed from: c  reason: collision with root package name */
        public String f39504c;

        /* renamed from: d  reason: collision with root package name */
        public String f39505d;

        /* renamed from: e  reason: collision with root package name */
        public String f39506e;

        /* renamed from: f  reason: collision with root package name */
        public Long f39507f;

        /* renamed from: g  reason: collision with root package name */
        public int f39508g;

        /* renamed from: h  reason: collision with root package name */
        public String f39509h;

        public C0514a() {
        }

        public C0514a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.f39503b = jSONObject.optString("display_name");
            this.f39504c = jSONObject.optString("pay_text");
            this.f39506e = jSONObject.optString("icon");
            this.f39505d = jSONObject.optString("valid_info");
            this.f39509h = jSONObject.optString("host_marketing_detail");
            this.f39507f = Long.valueOf(jSONObject.optLong("available_par_money"));
            this.f39508g = jSONObject.optInt("is_selected");
            this.f39502a = jSONObject.optInt("type");
        }
    }

    public a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.f39501b = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = (JSONObject) jSONArray.opt(i2);
            if (jSONObject != null) {
                this.f39501b.add(new C0514a(jSONObject));
            }
        }
        this.f39500a = this.f39501b.size() > 1;
    }
}

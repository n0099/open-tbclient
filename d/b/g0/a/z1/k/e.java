package d.b.g0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final boolean i = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public String f47250a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f47251b;

    /* renamed from: c  reason: collision with root package name */
    public String f47252c;

    /* renamed from: d  reason: collision with root package name */
    public String f47253d;

    /* renamed from: e  reason: collision with root package name */
    public String f47254e;

    /* renamed from: f  reason: collision with root package name */
    public String f47255f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47256g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f47257h;

    public void a(@NonNull String str, Object obj) {
        if (this.f47256g == null) {
            this.f47256g = new JSONObject();
        }
        try {
            this.f47256g.put(str, obj);
        } catch (JSONException e2) {
            if (i) {
                e2.printStackTrace();
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.f47256g == null) {
            this.f47256g = new JSONObject();
        }
        JSONObject optJSONObject = this.f47256g.optJSONObject("extlog");
        this.f47257h = optJSONObject;
        if (optJSONObject == null) {
            this.f47257h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47257h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (i) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f47256g.put("extlog", this.f47257h);
        } catch (JSONException e3) {
            if (i) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f47256g == null) {
            return null;
        }
        try {
            return new JSONObject(this.f47256g.toString());
        } catch (JSONException e2) {
            if (i) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            e(new JSONObject(str));
        } catch (JSONException e2) {
            if (i) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.f47256g == null) {
            this.f47256g = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47256g.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f47250a)) {
                jSONObject.put("from", this.f47250a);
            }
            if (!TextUtils.isEmpty(this.f47251b)) {
                jSONObject.put("type", this.f47251b);
            }
            if (!TextUtils.isEmpty(this.f47253d)) {
                jSONObject.put("value", this.f47253d);
            }
            if (TextUtils.isEmpty(this.f47252c)) {
                this.f47252c = "NA";
            }
            jSONObject.put("source", this.f47252c);
            if (!TextUtils.isEmpty(this.f47255f)) {
                String a2 = d.b.g0.a.z1.g.a(this.f47255f);
                this.f47255f = a2;
                jSONObject.put("page", a2);
            }
            if (this.f47256g == null) {
                this.f47256g = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f47254e)) {
                this.f47256g.put("appid", this.f47254e);
            }
            jSONObject.put("ext", this.f47256g);
            return jSONObject;
        } catch (JSONException e2) {
            if (i) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

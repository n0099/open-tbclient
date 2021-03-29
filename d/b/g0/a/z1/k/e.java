package d.b.g0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    public static final boolean i = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f47251a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f47252b;

    /* renamed from: c  reason: collision with root package name */
    public String f47253c;

    /* renamed from: d  reason: collision with root package name */
    public String f47254d;

    /* renamed from: e  reason: collision with root package name */
    public String f47255e;

    /* renamed from: f  reason: collision with root package name */
    public String f47256f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47257g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f47258h;

    public void a(@NonNull String str, Object obj) {
        if (this.f47257g == null) {
            this.f47257g = new JSONObject();
        }
        try {
            this.f47257g.put(str, obj);
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
        if (this.f47257g == null) {
            this.f47257g = new JSONObject();
        }
        JSONObject optJSONObject = this.f47257g.optJSONObject("extlog");
        this.f47258h = optJSONObject;
        if (optJSONObject == null) {
            this.f47258h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47258h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (i) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f47257g.put("extlog", this.f47258h);
        } catch (JSONException e3) {
            if (i) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f47257g == null) {
            return null;
        }
        try {
            return new JSONObject(this.f47257g.toString());
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
        if (this.f47257g == null) {
            this.f47257g = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47257g.put(next, jSONObject.opt(next));
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
            if (!TextUtils.isEmpty(this.f47251a)) {
                jSONObject.put("from", this.f47251a);
            }
            if (!TextUtils.isEmpty(this.f47252b)) {
                jSONObject.put("type", this.f47252b);
            }
            if (!TextUtils.isEmpty(this.f47254d)) {
                jSONObject.put("value", this.f47254d);
            }
            if (TextUtils.isEmpty(this.f47253c)) {
                this.f47253c = "NA";
            }
            jSONObject.put("source", this.f47253c);
            if (!TextUtils.isEmpty(this.f47256f)) {
                String a2 = d.b.g0.a.z1.g.a(this.f47256f);
                this.f47256f = a2;
                jSONObject.put("page", a2);
            }
            if (this.f47257g == null) {
                this.f47257g = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f47255e)) {
                this.f47257g.put("appid", this.f47255e);
            }
            jSONObject.put("ext", this.f47257g);
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

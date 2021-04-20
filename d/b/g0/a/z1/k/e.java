package d.b.g0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.b.g0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final boolean i = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f47643a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f47644b;

    /* renamed from: c  reason: collision with root package name */
    public String f47645c;

    /* renamed from: d  reason: collision with root package name */
    public String f47646d;

    /* renamed from: e  reason: collision with root package name */
    public String f47647e;

    /* renamed from: f  reason: collision with root package name */
    public String f47648f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47649g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f47650h;

    public void a(@NonNull String str, Object obj) {
        if (this.f47649g == null) {
            this.f47649g = new JSONObject();
        }
        try {
            this.f47649g.put(str, obj);
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
        if (this.f47649g == null) {
            this.f47649g = new JSONObject();
        }
        JSONObject optJSONObject = this.f47649g.optJSONObject("extlog");
        this.f47650h = optJSONObject;
        if (optJSONObject == null) {
            this.f47650h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47650h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (i) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f47649g.put("extlog", this.f47650h);
        } catch (JSONException e3) {
            if (i) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f47649g == null) {
            return null;
        }
        try {
            return new JSONObject(this.f47649g.toString());
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
        if (this.f47649g == null) {
            this.f47649g = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47649g.put(next, jSONObject.opt(next));
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
            if (!TextUtils.isEmpty(this.f47643a)) {
                jSONObject.put("from", this.f47643a);
            }
            if (!TextUtils.isEmpty(this.f47644b)) {
                jSONObject.put("type", this.f47644b);
            }
            if (!TextUtils.isEmpty(this.f47646d)) {
                jSONObject.put("value", this.f47646d);
            }
            if (TextUtils.isEmpty(this.f47645c)) {
                this.f47645c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f47645c);
            if (!TextUtils.isEmpty(this.f47648f)) {
                String a2 = d.b.g0.a.z1.g.a(this.f47648f);
                this.f47648f = a2;
                jSONObject.put("page", a2);
            }
            if (this.f47649g == null) {
                this.f47649g = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f47647e)) {
                this.f47649g.put("appid", this.f47647e);
            }
            jSONObject.put("ext", this.f47649g);
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

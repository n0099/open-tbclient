package d.b.h0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.b.h0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final boolean i = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f47972a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f47973b;

    /* renamed from: c  reason: collision with root package name */
    public String f47974c;

    /* renamed from: d  reason: collision with root package name */
    public String f47975d;

    /* renamed from: e  reason: collision with root package name */
    public String f47976e;

    /* renamed from: f  reason: collision with root package name */
    public String f47977f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f47978g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f47979h;

    public void a(@NonNull String str, Object obj) {
        if (this.f47978g == null) {
            this.f47978g = new JSONObject();
        }
        try {
            this.f47978g.put(str, obj);
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
        if (this.f47978g == null) {
            this.f47978g = new JSONObject();
        }
        JSONObject optJSONObject = this.f47978g.optJSONObject("extlog");
        this.f47979h = optJSONObject;
        if (optJSONObject == null) {
            this.f47979h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47979h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (i) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f47978g.put("extlog", this.f47979h);
        } catch (JSONException e3) {
            if (i) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f47978g == null) {
            return null;
        }
        try {
            return new JSONObject(this.f47978g.toString());
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
        if (this.f47978g == null) {
            this.f47978g = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f47978g.put(next, jSONObject.opt(next));
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
            if (!TextUtils.isEmpty(this.f47972a)) {
                jSONObject.put("from", this.f47972a);
            }
            if (!TextUtils.isEmpty(this.f47973b)) {
                jSONObject.put("type", this.f47973b);
            }
            if (!TextUtils.isEmpty(this.f47975d)) {
                jSONObject.put("value", this.f47975d);
            }
            if (TextUtils.isEmpty(this.f47974c)) {
                this.f47974c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f47974c);
            if (!TextUtils.isEmpty(this.f47977f)) {
                String a2 = d.b.h0.a.z1.g.a(this.f47977f);
                this.f47977f = a2;
                jSONObject.put("page", a2);
            }
            if (this.f47978g == null) {
                this.f47978g = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f47976e)) {
                this.f47978g.put("appid", this.f47976e);
            }
            jSONObject.put("ext", this.f47978g);
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

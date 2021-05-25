package d.a.l0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.l0.a.j2.j;
import d.a.l0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final boolean j = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f43185a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f43186b;

    /* renamed from: c  reason: collision with root package name */
    public String f43187c;

    /* renamed from: d  reason: collision with root package name */
    public String f43188d;

    /* renamed from: e  reason: collision with root package name */
    public String f43189e;

    /* renamed from: f  reason: collision with root package name */
    public String f43190f;

    /* renamed from: g  reason: collision with root package name */
    public String f43191g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f43192h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f43193i;

    public void a(@NonNull String str, Object obj) {
        if (this.f43192h == null) {
            this.f43192h = new JSONObject();
        }
        try {
            this.f43192h.put(str, obj);
        } catch (JSONException e2) {
            if (j) {
                e2.printStackTrace();
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.f43192h == null) {
            this.f43192h = new JSONObject();
        }
        JSONObject optJSONObject = this.f43192h.optJSONObject("extlog");
        this.f43193i = optJSONObject;
        if (optJSONObject == null) {
            this.f43193i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f43193i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f43192h.put("extlog", this.f43193i);
        } catch (JSONException e3) {
            if (j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f43192h == null) {
            return null;
        }
        try {
            return new JSONObject(this.f43192h.toString());
        } catch (JSONException e2) {
            if (j) {
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
            if (j) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.f43192h == null) {
            this.f43192h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f43192h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f43185a)) {
                jSONObject.put("from", this.f43185a);
            }
            if (!TextUtils.isEmpty(this.f43186b)) {
                jSONObject.put("type", this.f43186b);
            }
            if (!TextUtils.isEmpty(this.f43189e)) {
                jSONObject.put("value", this.f43189e);
            }
            if (TextUtils.isEmpty(this.f43187c)) {
                this.f43187c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f43187c);
            if (!TextUtils.isEmpty(this.f43191g)) {
                String a2 = j.a(this.f43191g);
                this.f43191g = a2;
                jSONObject.put("page", a2);
            }
            if (this.f43192h == null) {
                this.f43192h = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f43190f)) {
                this.f43192h.put("appid", this.f43190f);
            }
            if (!TextUtils.isEmpty(this.f43188d)) {
                this.f43192h.put("launchid", this.f43188d);
            }
            jSONObject.put("ext", this.f43192h);
            return jSONObject;
        } catch (JSONException e2) {
            if (j) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

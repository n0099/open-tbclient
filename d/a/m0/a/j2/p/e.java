package d.a.m0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.m0.a.j2.j;
import d.a.m0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final boolean j = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f46969a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f46970b;

    /* renamed from: c  reason: collision with root package name */
    public String f46971c;

    /* renamed from: d  reason: collision with root package name */
    public String f46972d;

    /* renamed from: e  reason: collision with root package name */
    public String f46973e;

    /* renamed from: f  reason: collision with root package name */
    public String f46974f;

    /* renamed from: g  reason: collision with root package name */
    public String f46975g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f46976h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f46977i;

    public void a(@NonNull String str, Object obj) {
        if (this.f46976h == null) {
            this.f46976h = new JSONObject();
        }
        try {
            this.f46976h.put(str, obj);
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
        if (this.f46976h == null) {
            this.f46976h = new JSONObject();
        }
        JSONObject optJSONObject = this.f46976h.optJSONObject("extlog");
        this.f46977i = optJSONObject;
        if (optJSONObject == null) {
            this.f46977i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f46977i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f46976h.put("extlog", this.f46977i);
        } catch (JSONException e3) {
            if (j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f46976h == null) {
            return null;
        }
        try {
            return new JSONObject(this.f46976h.toString());
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
        if (this.f46976h == null) {
            this.f46976h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f46976h.put(next, jSONObject.opt(next));
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
            if (!TextUtils.isEmpty(this.f46969a)) {
                jSONObject.put("from", this.f46969a);
            }
            if (!TextUtils.isEmpty(this.f46970b)) {
                jSONObject.put("type", this.f46970b);
            }
            if (!TextUtils.isEmpty(this.f46973e)) {
                jSONObject.put("value", this.f46973e);
            }
            if (TextUtils.isEmpty(this.f46971c)) {
                this.f46971c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f46971c);
            if (!TextUtils.isEmpty(this.f46975g)) {
                String a2 = j.a(this.f46975g);
                this.f46975g = a2;
                jSONObject.put("page", a2);
            }
            if (this.f46976h == null) {
                this.f46976h = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f46974f)) {
                this.f46976h.put("appid", this.f46974f);
            }
            if (!TextUtils.isEmpty(this.f46972d)) {
                this.f46976h.put("launchid", this.f46972d);
            }
            jSONObject.put("ext", this.f46976h);
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

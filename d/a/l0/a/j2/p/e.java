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
    public static final boolean j = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f46861a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f46862b;

    /* renamed from: c  reason: collision with root package name */
    public String f46863c;

    /* renamed from: d  reason: collision with root package name */
    public String f46864d;

    /* renamed from: e  reason: collision with root package name */
    public String f46865e;

    /* renamed from: f  reason: collision with root package name */
    public String f46866f;

    /* renamed from: g  reason: collision with root package name */
    public String f46867g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f46868h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f46869i;

    public void a(@NonNull String str, Object obj) {
        if (this.f46868h == null) {
            this.f46868h = new JSONObject();
        }
        try {
            this.f46868h.put(str, obj);
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
        if (this.f46868h == null) {
            this.f46868h = new JSONObject();
        }
        JSONObject optJSONObject = this.f46868h.optJSONObject("extlog");
        this.f46869i = optJSONObject;
        if (optJSONObject == null) {
            this.f46869i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f46869i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f46868h.put("extlog", this.f46869i);
        } catch (JSONException e3) {
            if (j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f46868h == null) {
            return null;
        }
        try {
            return new JSONObject(this.f46868h.toString());
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
        if (this.f46868h == null) {
            this.f46868h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f46868h.put(next, jSONObject.opt(next));
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
            if (!TextUtils.isEmpty(this.f46861a)) {
                jSONObject.put("from", this.f46861a);
            }
            if (!TextUtils.isEmpty(this.f46862b)) {
                jSONObject.put("type", this.f46862b);
            }
            if (!TextUtils.isEmpty(this.f46865e)) {
                jSONObject.put("value", this.f46865e);
            }
            if (TextUtils.isEmpty(this.f46863c)) {
                this.f46863c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f46863c);
            if (!TextUtils.isEmpty(this.f46867g)) {
                String a2 = j.a(this.f46867g);
                this.f46867g = a2;
                jSONObject.put("page", a2);
            }
            if (this.f46868h == null) {
                this.f46868h = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f46866f)) {
                this.f46868h.put("appid", this.f46866f);
            }
            if (!TextUtils.isEmpty(this.f46864d)) {
                this.f46868h.put("launchid", this.f46864d);
            }
            jSONObject.put("ext", this.f46868h);
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

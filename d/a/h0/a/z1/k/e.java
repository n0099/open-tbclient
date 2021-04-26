package d.a.h0.a.z1.k;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.h0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f45410i = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f45411a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f45412b;

    /* renamed from: c  reason: collision with root package name */
    public String f45413c;

    /* renamed from: d  reason: collision with root package name */
    public String f45414d;

    /* renamed from: e  reason: collision with root package name */
    public String f45415e;

    /* renamed from: f  reason: collision with root package name */
    public String f45416f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f45417g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f45418h;

    public void a(@NonNull String str, Object obj) {
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        try {
            this.f45417g.put(str, obj);
        } catch (JSONException e2) {
            if (f45410i) {
                e2.printStackTrace();
            }
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        JSONObject optJSONObject = this.f45417g.optJSONObject("extlog");
        this.f45418h = optJSONObject;
        if (optJSONObject == null) {
            this.f45418h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f45418h.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f45410i) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f45417g.put("extlog", this.f45418h);
        } catch (JSONException e3) {
            if (f45410i) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f45417g == null) {
            return null;
        }
        try {
            return new JSONObject(this.f45417g.toString());
        } catch (JSONException e2) {
            if (f45410i) {
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
            if (f45410i) {
                e2.printStackTrace();
            }
        }
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (this.f45417g == null) {
            this.f45417g = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f45417g.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (f45410i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f45411a)) {
                jSONObject.put("from", this.f45411a);
            }
            if (!TextUtils.isEmpty(this.f45412b)) {
                jSONObject.put("type", this.f45412b);
            }
            if (!TextUtils.isEmpty(this.f45414d)) {
                jSONObject.put("value", this.f45414d);
            }
            if (TextUtils.isEmpty(this.f45413c)) {
                this.f45413c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f45413c);
            if (!TextUtils.isEmpty(this.f45416f)) {
                String a2 = d.a.h0.a.z1.g.a(this.f45416f);
                this.f45416f = a2;
                jSONObject.put("page", a2);
            }
            if (this.f45417g == null) {
                this.f45417g = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f45415e)) {
                this.f45417g.put("appid", this.f45415e);
            }
            jSONObject.put("ext", this.f45417g);
            return jSONObject;
        } catch (JSONException e2) {
            if (f45410i) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }
}

package d.a.i0.a.j2.p;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import d.a.i0.a.j2.j;
import d.a.i0.a.k;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static final boolean j = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f43011a = "swan";

    /* renamed from: b  reason: collision with root package name */
    public String f43012b;

    /* renamed from: c  reason: collision with root package name */
    public String f43013c;

    /* renamed from: d  reason: collision with root package name */
    public String f43014d;

    /* renamed from: e  reason: collision with root package name */
    public String f43015e;

    /* renamed from: f  reason: collision with root package name */
    public String f43016f;

    /* renamed from: g  reason: collision with root package name */
    public String f43017g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f43018h;

    /* renamed from: i  reason: collision with root package name */
    public JSONObject f43019i;

    public void a(@NonNull String str, Object obj) {
        if (this.f43018h == null) {
            this.f43018h = new JSONObject();
        }
        try {
            this.f43018h.put(str, obj);
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
        if (this.f43018h == null) {
            this.f43018h = new JSONObject();
        }
        JSONObject optJSONObject = this.f43018h.optJSONObject("extlog");
        this.f43019i = optJSONObject;
        if (optJSONObject == null) {
            this.f43019i = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f43019i.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                if (j) {
                    e2.printStackTrace();
                }
            }
        }
        try {
            this.f43018h.put("extlog", this.f43019i);
        } catch (JSONException e3) {
            if (j) {
                e3.printStackTrace();
            }
        }
    }

    public JSONObject c() {
        if (this.f43018h == null) {
            return null;
        }
        try {
            return new JSONObject(this.f43018h.toString());
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
        if (this.f43018h == null) {
            this.f43018h = new JSONObject();
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.f43018h.put(next, jSONObject.opt(next));
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
            if (!TextUtils.isEmpty(this.f43011a)) {
                jSONObject.put("from", this.f43011a);
            }
            if (!TextUtils.isEmpty(this.f43012b)) {
                jSONObject.put("type", this.f43012b);
            }
            if (!TextUtils.isEmpty(this.f43015e)) {
                jSONObject.put("value", this.f43015e);
            }
            if (TextUtils.isEmpty(this.f43013c)) {
                this.f43013c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            jSONObject.put("source", this.f43013c);
            if (!TextUtils.isEmpty(this.f43017g)) {
                String a2 = j.a(this.f43017g);
                this.f43017g = a2;
                jSONObject.put("page", a2);
            }
            if (this.f43018h == null) {
                this.f43018h = new JSONObject();
            }
            if (!TextUtils.isEmpty(this.f43016f)) {
                this.f43018h.put("appid", this.f43016f);
            }
            if (!TextUtils.isEmpty(this.f43014d)) {
                this.f43018h.put("launchid", this.f43014d);
            }
            jSONObject.put("ext", this.f43018h);
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

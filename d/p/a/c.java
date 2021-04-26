package d.p.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public Context f66794e;

    /* renamed from: f  reason: collision with root package name */
    public String f66795f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f66796g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f66797h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f66798i = "";
    public String j = "";
    public String k = "";
    public HashMap<String, String> l = new HashMap<>();

    public String a(boolean z) {
        if (z) {
            return m(this.f66795f);
        }
        return this.f66795f;
    }

    public Context b() {
        return this.f66794e;
    }

    public String c(boolean z) {
        if (this.l.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : this.l.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
                return "";
            }
        }
        if (z) {
            return m(jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public Object clone() {
        try {
            c cVar = (c) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : cVar.l.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            cVar.l = hashMap;
            return cVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String d(boolean z) {
        if (z) {
            return m(this.f66797h);
        }
        return this.f66797h;
    }

    public String e(boolean z) {
        if (z) {
            return m(this.j);
        }
        return this.j;
    }

    public String f(boolean z) {
        if (z) {
            return m(this.f66796g);
        }
        return this.f66796g;
    }

    public String g(boolean z) {
        if (z) {
            return m(this.k);
        }
        return this.k;
    }

    public String h(boolean z) {
        if (z) {
            return m(this.f66798i);
        }
        return this.f66798i;
    }

    public void i(String str) {
        this.f66795f = str;
    }

    public void j(Context context) {
        this.f66794e = context.getApplicationContext();
    }

    public void k(String str) {
        this.f66797h = str;
    }

    public void l(String str) {
        this.f66798i = str;
    }

    public final String m(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public boolean n() {
        return (this.f66794e == null || TextUtils.isEmpty(this.f66795f) || TextUtils.isEmpty(this.f66797h) || TextUtils.isEmpty(this.f66798i)) ? false : true;
    }
}

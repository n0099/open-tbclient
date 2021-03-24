package d.p.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public Context f67271e;

    /* renamed from: f  reason: collision with root package name */
    public String f67272f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f67273g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f67274h = "";
    public String i = "";
    public String j = "";
    public String k = "";
    public HashMap<String, String> l = new HashMap<>();

    public String a(boolean z) {
        if (z) {
            return m(this.f67272f);
        }
        return this.f67272f;
    }

    public Context b() {
        return this.f67271e;
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
            return m(this.f67274h);
        }
        return this.f67274h;
    }

    public String e(boolean z) {
        if (z) {
            return m(this.j);
        }
        return this.j;
    }

    public String f(boolean z) {
        if (z) {
            return m(this.f67273g);
        }
        return this.f67273g;
    }

    public String g(boolean z) {
        if (z) {
            return m(this.k);
        }
        return this.k;
    }

    public String h(boolean z) {
        if (z) {
            return m(this.i);
        }
        return this.i;
    }

    public void i(String str) {
        this.f67272f = str;
    }

    public void j(Context context) {
        this.f67271e = context.getApplicationContext();
    }

    public void k(String str) {
        this.f67274h = str;
    }

    public void l(String str) {
        this.i = str;
    }

    public final String m(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public boolean n() {
        return (this.f67271e == null || TextUtils.isEmpty(this.f67272f) || TextUtils.isEmpty(this.f67274h) || TextUtils.isEmpty(this.i)) ? false : true;
    }
}

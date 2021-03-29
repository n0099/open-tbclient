package d.b.g0.a.q.g.b;

import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45486g = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f45487a;

    /* renamed from: b  reason: collision with root package name */
    public String f45488b;

    /* renamed from: c  reason: collision with root package name */
    public String f45489c;

    /* renamed from: d  reason: collision with root package name */
    public String f45490d;

    /* renamed from: e  reason: collision with root package name */
    public String f45491e;

    /* renamed from: f  reason: collision with root package name */
    public long f45492f;

    public a(String str, String str2) {
        this.f45487a = str;
        this.f45488b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f45487a);
            jSONObject.put("name", this.f45488b);
            jSONObject.put("userAgent", this.f45489c);
            jSONObject.put("contentDisposition", this.f45490d);
            jSONObject.put("mimeType", this.f45491e);
            jSONObject.put("contentLength", this.f45492f);
        } catch (JSONException e2) {
            if (f45486g) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a(String str, String str2, String str3) {
        this.f45487a = str;
        this.f45488b = str2;
    }
}

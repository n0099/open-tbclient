package d.b.g0.a.q.g.b;

import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45485g = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public String f45486a;

    /* renamed from: b  reason: collision with root package name */
    public String f45487b;

    /* renamed from: c  reason: collision with root package name */
    public String f45488c;

    /* renamed from: d  reason: collision with root package name */
    public String f45489d;

    /* renamed from: e  reason: collision with root package name */
    public String f45490e;

    /* renamed from: f  reason: collision with root package name */
    public long f45491f;

    public a(String str, String str2) {
        this.f45486a = str;
        this.f45487b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f45486a);
            jSONObject.put("name", this.f45487b);
            jSONObject.put("userAgent", this.f45488c);
            jSONObject.put("contentDisposition", this.f45489d);
            jSONObject.put("mimeType", this.f45490e);
            jSONObject.put("contentLength", this.f45491f);
        } catch (JSONException e2) {
            if (f45485g) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a(String str, String str2, String str3) {
        this.f45486a = str;
        this.f45487b = str2;
    }
}

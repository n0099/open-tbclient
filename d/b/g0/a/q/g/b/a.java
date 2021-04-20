package d.b.g0.a.q.g.b;

import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f45878g = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f45879a;

    /* renamed from: b  reason: collision with root package name */
    public String f45880b;

    /* renamed from: c  reason: collision with root package name */
    public String f45881c;

    /* renamed from: d  reason: collision with root package name */
    public String f45882d;

    /* renamed from: e  reason: collision with root package name */
    public String f45883e;

    /* renamed from: f  reason: collision with root package name */
    public long f45884f;

    public a(String str, String str2) {
        this.f45879a = str;
        this.f45880b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f45879a);
            jSONObject.put("name", this.f45880b);
            jSONObject.put("userAgent", this.f45881c);
            jSONObject.put("contentDisposition", this.f45882d);
            jSONObject.put("mimeType", this.f45883e);
            jSONObject.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, this.f45884f);
        } catch (JSONException e2) {
            if (f45878g) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a(String str, String str2, String str3) {
        this.f45879a = str;
        this.f45880b = str2;
    }
}

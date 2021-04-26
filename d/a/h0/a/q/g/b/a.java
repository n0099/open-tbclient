package d.a.h0.a.q.g.b;

import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f43555g = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f43556a;

    /* renamed from: b  reason: collision with root package name */
    public String f43557b;

    /* renamed from: c  reason: collision with root package name */
    public String f43558c;

    /* renamed from: d  reason: collision with root package name */
    public String f43559d;

    /* renamed from: e  reason: collision with root package name */
    public String f43560e;

    /* renamed from: f  reason: collision with root package name */
    public long f43561f;

    public a(String str, String str2) {
        this.f43556a = str;
        this.f43557b = str2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f43556a);
            jSONObject.put("name", this.f43557b);
            jSONObject.put("userAgent", this.f43558c);
            jSONObject.put("contentDisposition", this.f43559d);
            jSONObject.put("mimeType", this.f43560e);
            jSONObject.put(XAdRemoteAPKDownloadExtraInfo.CONTENT_LENGTH, this.f43561f);
        } catch (JSONException e2) {
            if (f43555g) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public a(String str, String str2, String str3) {
        this.f43556a = str;
        this.f43557b = str2;
    }
}
